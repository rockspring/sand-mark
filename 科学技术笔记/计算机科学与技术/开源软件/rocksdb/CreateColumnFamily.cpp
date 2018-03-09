Status DBImpl::CreateColumnFamily(const ColumnFamilyOptions& cf_options,
                                  const std::string& column_family_name,
                                  ColumnFamilyHandle** handle) {
  Status s;
  Status persist_options_status;
  *handle = nullptr;

  s = CheckCompressionSupported(cf_options);
  if (s.ok() && db_options_.allow_concurrent_memtable_write) {
    s = CheckConcurrentWritesSupported(cf_options);
  }
  if (!s.ok()) {
    return s;
  }

  {
    InstrumentedMutexLock l(&mutex_);

    if (versions_->GetColumnFamilySet()->GetColumnFamily(column_family_name) !=
        nullptr) {
      return Status::InvalidArgument("Column family already exists");
    }
    VersionEdit edit;
    edit.AddColumnFamily(column_family_name);
    uint32_t new_id = versions_->GetColumnFamilySet()->GetNextColumnFamilyID();
    edit.SetColumnFamily(new_id);
    edit.SetLogNumber(logfile_number_);
    edit.SetComparatorName(cf_options.comparator->Name());

    // LogAndApply will both write the creation in MANIFEST and create
    // ColumnFamilyData object
    Options opt(db_options_, cf_options);
    {  // write thread
      WriteThread::Writer w;
      write_thread_.EnterUnbatched(&w, &mutex_);
      // LogAndApply will both write the creation in MANIFEST and create
      // ColumnFamilyData object
      s = versions_->LogAndApply(
          nullptr, MutableCFOptions(opt, ImmutableCFOptions(opt)), &edit,
          &mutex_, directories_.GetDbDir(), false, &cf_options);

      if (s.ok()) {
        // If the column family was created successfully, we then persist
        // the updated RocksDB options under the same single write thread
        persist_options_status = WriteOptionsFile();
      }
      write_thread_.ExitUnbatched(&w);
    }
    if (s.ok()) {
      single_column_family_mode_ = false;
      auto* cfd =
          versions_->GetColumnFamilySet()->GetColumnFamily(column_family_name);
      assert(cfd != nullptr);
      delete InstallSuperVersionAndScheduleWork(
          cfd, nullptr, *cfd->GetLatestMutableCFOptions());

      if (!cfd->mem()->IsSnapshotSupported()) {
        is_snapshot_supported_ = false;
      }

      *handle = new ColumnFamilyHandleImpl(cfd, this, &mutex_);
      Log(InfoLogLevel::INFO_LEVEL, db_options_.info_log,
          "Created column family [%s] (ID %u)",
          column_family_name.c_str(), (unsigned)cfd->GetID());
    } else {
      Log(InfoLogLevel::ERROR_LEVEL, db_options_.info_log,
          "Creating column family [%s] FAILED -- %s",
          column_family_name.c_str(), s.ToString().c_str());
    }
  }  // InstrumentedMutexLock l(&mutex_)

  // this is outside the mutex
  if (s.ok()) {
    NewThreadStatusCfInfo(
        reinterpret_cast<ColumnFamilyHandleImpl*>(*handle)->cfd());
    if (!persist_options_status.ok()) {
      if (db_options_.fail_if_options_file_error) {
        s = Status::IOError(
            "ColumnFamily has been created, but unable to persist"
            "options in CreateColumnFamily()",
            persist_options_status.ToString().c_str());
      }
      Warn(db_options_.info_log,
           "Unable to persist options in CreateColumnFamily() -- %s",
           persist_options_status.ToString().c_str());
    }
  }
  return s;
}