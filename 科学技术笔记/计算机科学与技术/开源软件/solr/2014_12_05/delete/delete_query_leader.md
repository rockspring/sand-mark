```
vinfo.blockUpdates();
try {

  if (versionsStored) {
    if (leaderLogic) {
      long version = vinfo.getNewClock();
      cmd.setVersion(-version);
      // TODO update versions in all buckets

      doLocalDelete(cmd);

    } else {
      cmd.setVersion(-versionOnUpdate);

      if (ulog.getState() != UpdateLog.State.ACTIVE && (cmd.getFlags() & UpdateCommand.REPLAY) == 0) {
        // we're not in an active state, and this update isn't from a replay, so buffer it.
        cmd.setFlags(cmd.getFlags() | UpdateCommand.BUFFERING);
        ulog.deleteByQuery(cmd);
        return;
      }

      //将命令传递到父类UpdateRequestProcessor的processDelete方法，这个方法将命令传递到下一个处理器RunUpdateProcessor
      // UpdateRequestProcessor充当命令处理链的角色，依次转发请求到各个处理器
      doLocalDelete(cmd);
    }
  }

  // since we don't know which documents were deleted, the easiest thing to do is to invalidate
  // all real-time caches (i.e. UpdateLog) which involves also getting a new version of the IndexReader
  // (so cache misses will see up-to-date data)

} finally {
  vinfo.unblockUpdates();
}
```


RunUpdateProcessor类的方法

```
public void processDelete(DeleteUpdateCommand cmd) throws IOException {
  if( cmd.isDeleteById()) {
    updateHandler.delete(cmd);
  }
  else {
    updateHandler.deleteByQuery(cmd);
  }
  super.processDelete(cmd);
  changesSinceCommit = true;
}
```


DirectUpdateHandler2类的方法

```
public void deleteByQuery(DeleteUpdateCommand cmd) throws IOException {
  deleteByQueryCommands.incrementAndGet();
  deleteByQueryCommandsCumulative.incrementAndGet();
  boolean madeIt=false;
  try {
    Query q = getQuery(cmd);
    
    boolean delAll = MatchAllDocsQuery.class == q.getClass();

    // currently for testing purposes.  Do a delete of complete index w/o worrying about versions, don't log, clean up most state in update log, etc
    if (delAll && cmd.getVersion() == -Long.MAX_VALUE) {
      synchronized (solrCoreState.getUpdateLock()) {
        deleteAll();
        ulog.deleteAll();
        return;
      }
    }

    //
    // synchronized to prevent deleteByQuery from running during the "open new searcher"
    // part of a commit.  DBQ needs to signal that a fresh reader will be needed for
    // a realtime view of the index.  When a new searcher is opened after a DBQ, that
    // flag can be cleared.  If those thing happen concurrently, it's not thread safe.
    //
    synchronized (solrCoreState.getUpdateLock()) {
      if (delAll) {
        deleteAll();
      } else {
        RefCounted<IndexWriter> iw = solrCoreState.getIndexWriter(core);
        try {
          iw.get().deleteDocuments(q);
        } finally {
          iw.decref();
        }
      }

      if (ulog != null) ulog.deleteByQuery(cmd);
    }

    madeIt = true;

    updateDeleteTrackers(cmd);

  } finally {
    if (!madeIt) {
      numErrors.incrementAndGet();
      numErrorsCumulative.incrementAndGet();
    }
  }
}
```

IndexWriterl类的方法
```
public void deleteDocuments(Query query) throws IOException {
  ensureOpen();
  try {
    if (docWriter.deleteQueries(query)) {
      processEvents(true, false);
    }
  } catch (OutOfMemoryError oom) {
    handleOOM(oom, "deleteDocuments(Query)");
  }
}
```