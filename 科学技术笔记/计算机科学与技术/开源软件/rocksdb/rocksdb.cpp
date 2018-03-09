Status DB::Open(const DBOptions& db_options, const std::string& dbname,
                const std::vector<ColumnFamilyDescriptor>& column_families,
                std::vector<ColumnFamilyHandle*>* handles, DB** dbptr) {
  Status s = SanitizeOptionsByTable(db_options, column_families);
  if (!s.ok()) {
    return s;
  }

  s = ValidateOptions(db_options, column_families);
  if (!s.ok()) {
    return s;
  }

  *dbptr = nullptr;
  handles->clear();

  size_t max_write_buffer_size = 0;
  for (auto cf : column_families) {
    max_write_buffer_size =
        std::max(max_write_buffer_size, cf.options.write_buffer_size);
  }

  DBImpl* impl = new DBImpl(db_options, dbname);
  s = impl->env_->CreateDirIfMissing(impl->db_options_.wal_dir);
  if (s.ok()) {
    for (auto db_path : impl->db_options_.db_paths) {
      s = impl->env_->CreateDirIfMissing(db_path.path);
      if (!s.ok()) {
        break;
      }
    }
  }

  if (!s.ok()) {
    delete impl;
    return s;
  }

  s = impl->CreateArchivalDirectory();
  if (!s.ok()) {
    delete impl;
    return s;
  }
  impl->mutex_.Lock();
  // Handles create_if_missing, error_if_exists
  s = impl->Recover(column_families);
  if (s.ok()) {
    uint64_t new_log_number = impl->versions_->NewFileNumber();
    unique_ptr<WritableFile> lfile;
    EnvOptions soptions(db_options);
    EnvOptions opt_env_options =
        impl->db_options_.env->OptimizeForLogWrite(soptions, impl->db_options_);
    s = NewWritableFile(impl->db_options_.env,
                        LogFileName(impl->db_options_.wal_dir, new_log_number),
                        &lfile, opt_env_options);
    if (s.ok()) {
      lfile->SetPreallocationBlockSize((max_write_buffer_size / 10) + max_write_buffer_size);
      impl->logfile_number_ = new_log_number;
      unique_ptr<WritableFileWriter> file_writer(
          new WritableFileWriter(std::move(lfile), opt_env_options));
      impl->logs_.emplace_back(
          new_log_number,
          new log::Writer(std::move(file_writer), new_log_number,
                          impl->db_options_.recycle_log_file_num > 0));

      // set column family handles
      for (auto cf : column_families) {
        auto cfd =
            impl->versions_->GetColumnFamilySet()->GetColumnFamily(cf.name);
        if (cfd != nullptr) {
          handles->push_back(
              new ColumnFamilyHandleImpl(cfd, impl, &impl->mutex_));
          impl->NewThreadStatusCfInfo(cfd);
        } else {
          if (db_options.create_missing_column_families) {
            // missing column family, create it
            ColumnFamilyHandle* handle;
            impl->mutex_.Unlock();
            s = impl->CreateColumnFamily(cf.options, cf.name, &handle);
            impl->mutex_.Lock();
            if (s.ok()) {
              handles->push_back(handle);
            } else {
              break;
            }
          } else {
            s = Status::InvalidArgument("Column family not found: ", cf.name);
            break;
          }
        }
      }
    }
    if (s.ok()) {
      for (auto cfd : *impl->versions_->GetColumnFamilySet()) {
        delete impl->InstallSuperVersionAndScheduleWork(
            cfd, nullptr, *cfd->GetLatestMutableCFOptions());
      }
      impl->alive_log_files_.push_back(
          DBImpl::LogFileNumberSize(impl->logfile_number_));
      impl->DeleteObsoleteFiles();
      s = impl->directories_.GetDbDir()->Fsync();
    }
  }

  if (s.ok()) {
    for (auto cfd : *impl->versions_->GetColumnFamilySet()) {
      if (cfd->ioptions()->compaction_style == kCompactionStyleFIFO) {
        auto* vstorage = cfd->current()->storage_info();
        for (int i = 1; i < vstorage->num_levels(); ++i) {
          int num_files = vstorage->NumLevelFiles(i);
          if (num_files > 0) {
            s = Status::InvalidArgument(
                "Not all files are at level 0. Cannot "
                "open with FIFO compaction style.");
            break;
          }
        }
      }
      if (!cfd->mem()->IsSnapshotSupported()) {
        impl->is_snapshot_supported_ = false;
      }
      if (cfd->ioptions()->merge_operator != nullptr &&
          !cfd->mem()->IsMergeOperatorSupported()) {
        s = Status::InvalidArgument(
            "The memtable of column family %s does not support merge operator "
            "its options.merge_operator is non-null", cfd->GetName().c_str());
      }
      if (!s.ok()) {
        break;
      }
    }
  }
  TEST_SYNC_POINT("DBImpl::Open:Opened");
  Status persist_options_status;
  if (s.ok()) {
    // Persist RocksDB Options before scheduling the compaction.
    // The WriteOptionsFile() will release and lock the mutex internally.
    persist_options_status = impl->WriteOptionsFile();

    *dbptr = impl;
    impl->opened_successfully_ = true;
    impl->MaybeScheduleFlushOrCompaction();
  }
  impl->mutex_.Unlock();

  auto sfm = static_cast<SstFileManagerImpl*>(
      impl->db_options_.sst_file_manager.get());
  if (s.ok() && sfm) {
    // Notify SstFileManager about all sst files that already exist in
    // db_paths[0] when the DB is opened.
    auto& db_path = impl->db_options_.db_paths[0];
    std::vector<std::string> existing_files;
    impl->db_options_.env->GetChildren(db_path.path, &existing_files);
    for (auto& file_name : existing_files) {
      uint64_t file_number;
      FileType file_type;
      std::string file_path = db_path.path + "/" + file_name;
      if (ParseFileName(file_name, &file_number, &file_type) &&
          file_type == kTableFile) {
        sfm->OnAddFile(file_path);
      }
    }
  }

  if (s.ok()) {
    Log(InfoLogLevel::INFO_LEVEL, impl->db_options_.info_log, "DB pointer %p",
        impl);
    LogFlush(impl->db_options_.info_log);
    if (!persist_options_status.ok()) {
      if (db_options.fail_if_options_file_error) {
        s = Status::IOError(
            "DB::Open() failed --- Unable to persist Options file",
            persist_options_status.ToString());
      }
      Warn(impl->db_options_.info_log,
           "Unable to persist options in DB::Open() -- %s",
           persist_options_status.ToString().c_str());
    }
  }
  if (!s.ok()) {
    for (auto* h : *handles) {
      delete h;
    }
    handles->clear();
    delete impl;
    *dbptr = nullptr;
  }
  return s;
}