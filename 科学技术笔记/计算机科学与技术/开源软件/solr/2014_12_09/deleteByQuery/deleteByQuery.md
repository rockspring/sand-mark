UpdateLog类


```
public void deleteByQuery(DeleteUpdateCommand cmd) {
    synchronized (this) {
      long pos = -1;
      // don't log if we are replaying from another log
      if ((cmd.getFlags() & UpdateCommand.REPLAY) == 0) {
        ensureLog();
        pos = tlog.writeDeleteByQuery(cmd, operationFlags);
      }

      // only change our caches if we are not buffering
      if ((cmd.getFlags() & UpdateCommand.BUFFERING) == 0) {
        // given that we just did a delete-by-query, we don't know what documents were
        // affected and hence we must purge our caches.
        if (map != null) map.clear();
        if (prevMap != null) prevMap.clear();
        if (prevMap2 != null) prevMap2.clear();

        trackDeleteByQuery(cmd.getQuery(), cmd.getVersion());

        // oldDeletes.clear();

        // We must cause a new IndexReader to be opened before anything looks at these caches again
        // so that a cache miss will read fresh data.
        //
        // TODO: FUTURE: open a new searcher lazily for better throughput with delete-by-query commands
        try {
          RefCounted<SolrIndexSearcher> holder = uhandler.core.openNewSearcher(true, true);
          holder.decref();
        } catch (Exception e) {
          SolrException.log(log, "Error opening realtime searcher for deleteByQuery", e);
        }

      }

      LogPtr ptr = new LogPtr(pos, cmd.getVersion());

      if (trace) {
        log.trace("TLOG: added deleteByQuery " + cmd.query + " to " + tlog + " " + ptr + " map=" + System.identityHashCode(map));
      }
    }
  }
```

cmd 的内容,flags=0
```
delete{_version_=-1486969329646829568,query=`unique_id:SP2514N`,commitWithin=-1}
```


deleteByQueries
```
 size = 7
DBQ{version=1486969070710423552,q=unique_id:SP2514N}
DBQ{version=1486922259301924864,q=unique_id:SP2514N}
DBQ{version=1486920522891526144,q=unique_id:SP2514N}
DBQ{version=1486920494883012608,q=unique_id:SP2514N}
DBQ{version=1486920494779203584,q=unique_id:SP2514N}
DBQ{version=1486920494699511808,q=unique_id:SP2514N}
DBQ{version=1486920494669103104,q=unique_id:SP2514N}
```

从上到下，依次为头元素到尾元素，版本号越来越小

trackDeleteByQuery(String q, long version))
version=1486969329646829568

version比deleteByQueries得第一个版本号还要高