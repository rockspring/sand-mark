ThreadState引用和保护DocumentsWriterPerThread实例，在索引构建阶段用于构建内存索引段。ThreadState也拥有所有刷新相关的每线程数据，这些数据是由DocumentsWriterFlushControl控制的。

DocumentsWriterPerThread是单个线程独占使用的DocumentsWriter。

ThreadState的方法和成员，一次仅有一个线程可以访问。访问之前使用它的lock()方法获得锁，访问之后使用它的unlock()方法释放锁。



org/apache/lucene/index/IndexWriter.java

关联的类

```
org.apache.lucene.index.DocumentsWriterStallControl
```

# 公开的方法


构造方法

```
org.apache.lucene.index.IndexWriter#IndexWriter
```

获取信息类方法

```
org.apache.lucene.index.IndexWriter#ramBytesUsed
org.apache.lucene.index.IndexWriter#numDeletedDocs
org.apache.lucene.index.IndexWriter#getConfig
org.apache.lucene.index.IndexWriter#getDirectory
org.apache.lucene.index.IndexWriter#getAnalyzer
org.apache.lucene.index.IndexWriter#maxDoc()
org.apache.lucene.index.IndexWriter#numDocs
org.apache.lucene.index.IndexWriter#hasDeletions
org.apache.lucene.index.IndexWriter#getFieldNames
org.apache.lucene.index.IndexWriter#numRamDocs
org.apache.lucene.index.IndexWriter#isOpen
org.apache.lucene.index.IndexWriter#getMaxCompletedSequenceNumber
org.apache.lucene.index.IndexWriter#getTragicException

org.apache.lucene.index.IndexWriter#advanceSegmentInfosVersion 强制更新SegmentInfos的版本到一个更高的版本
```

添加文档类方法

```
org.apache.lucene.index.IndexWriter#addDocument
org.apache.lucene.index.IndexWriter#addDocuments
org.apache.lucene.index.IndexWriter#addIndexes(org.apache.lucene.store.Directory...)
org.apache.lucene.index.IndexWriter#addIndexes(org.apache.lucene.index.CodecReader...)
```

更新文档类方法

```
org.apache.lucene.index.IndexWriter#updateDocuments
org.apache.lucene.index.IndexWriter#updateDocument
org.apache.lucene.index.IndexWriter#updateNumericDocValue
org.apache.lucene.index.IndexWriter#updateBinaryDocValue
org.apache.lucene.index.IndexWriter#updateDocValues
```

删除文档类方法

```
org.apache.lucene.index.IndexWriter#tryDeleteDocument
org.apache.lucene.index.IndexWriter#deleteDocuments(org.apache.lucene.index.Term...)
org.apache.lucene.index.IndexWriter#deleteDocuments(org.apache.lucene.search.Query...)
org.apache.lucene.index.IndexWriter#deleteAll

```

刷新内存类方法

```
org.apache.lucene.index.IndexWriter#flushNextBuffer
org.apache.lucene.index.IndexWriter#flush()
```

索引段合并类方法

```
org.apache.lucene.index.IndexWriter#maybeMerge()
org.apache.lucene.index.IndexWriter#getMergingSegments
org.apache.lucene.index.IndexWriter#getNextMerge
org.apache.lucene.index.IndexWriter#hasPendingMerges

org.apache.lucene.index.IndexWriter#forceMerge(int)
org.apache.lucene.index.IndexWriter#forceMerge(int, boolean)
org.apache.lucene.index.IndexWriter#forceMergeDeletes(boolean)
org.apache.lucene.index.IndexWriter#forceMergeDeletes()
org.apache.lucene.index.IndexWriter#merge
```

事务类方法

```
org.apache.lucene.index.IndexWriter#setLiveCommitData(java.lang.Iterable<java.util.Map.Entry<java.lang.String,java.lang.String>>)
org.apache.lucene.index.IndexWriter#setLiveCommitData(java.lang.Iterable<java.util.Map.Entry<java.lang.String,java.lang.String>>, boolean)
org.apache.lucene.index.IndexWriter#getLiveCommitData
org.apache.lucene.index.IndexWriter#hasUncommittedChanges

org.apache.lucene.index.IndexWriter#prepareCommit
org.apache.lucene.index.IndexWriter#commit
org.apache.lucene.index.IndexWriter#rollback
org.apache.lucene.index.IndexWriter#close
```

索引文件回收类方法

```
org.apache.lucene.index.IndexWriter#deleteUnusedFiles
org.apache.lucene.index.IndexWriter#incRefDeleter
org.apache.lucene.index.IndexWriter#decRefDeleter
```


## 删除索引中所有的文档

public long deleteAll() throws IOException;

丢弃所有缓冲区中的文档

从索引中移除所有的段

所有的修改只有commit之后才可见

所有的修改可以通过rollback回滚




刷新锁，在哪里获取锁？

synchronized (fullFlushLock)


public long deleteAll() throws IOException;

锁住的理由：防止并发地提交、近实时搜索索引打开

private long prepareCommitInternal(MergePolicy mergePolicy) throws IOException;

private boolean doFlush(boolean applyAllDeletes) throws IOException;

DirectoryReader getReader(boolean applyAllDeletes, boolean writeAllDeletes) throws IOException;




org/apache/lucene/index/DocumentsWriterStallControl.java


线程等待wait和notifyAll()。



notifyAll()

synchronized void updateStalled(boolean stalled)


wait()

wait调用之前必须获得锁，之后释放锁，线程处于停滞状态

void waitIfStalled();


测试添加索引

org/apache/lucene/analysis/core/TestKeywordAnalyzer.java


测试删除

org/apache/lucene/index/TestIndexWriterDelete.java




DocumentsWriterPerThread

一次为一个线程使用，线程从DocumentsWriterPerThread池子里获取一个DocumentsWriterPerThread，获取动作通过org/apache/lucene/index/DocumentsWriterFlushControl.java间接操作，DocumentsWriterFlushControl从池子DocumentsWriterPerThreadPool里获取一个新的或已经回收的空闲的DocumentsWriter，并锁住它，使用完了再释放到池子里。


# IndexWriter

## 一、内部类

### 1 org.apache.lucene.index.IndexWriter.ReaderPool

### 2 org.apache.lucene.index.IndexWriter.MergedDeletesAndUpdates

### 3 org.apache.lucene.index.IndexWriter.IndexReaderWarmer

### 4 org.apache.lucene.index.IndexWriter.Event

## 二、字段

### 1 org.apache.lucene.index.IndexWriter#pendingNumDocs

表示索引中有多少个文档或者正在被添加（或预定添加）的文档数量。添加到索引之前先预定要添加N个文档，如果文档数量限制使得预定失败，添加失败，抛出异常。
org.apache.lucene.index.DocumentsWriterPerThread#reserveOneDoc方法先尝试预定一个文档位置，这会增加pendingNumDocs的数量，预定失败的话撤销预定，抛出异常。

## 三、方法

### org.apache.lucene.index.IndexWriter#applyAllDeletesAndUpdates

应用所有的删除和更新。依次调用org.apache.lucene.index.BufferedUpdatesStream中的所有FrozenBufferedUpdates的org.apache.lucene.index.FrozenBufferedUpdates#apply(org.apache.lucene.index.IndexWriter)方法，改方法是将通过term删除的请求、通过query删除的请求或文档值更新请求翻译成实际的文档ID。如何做呢？首先从IndexWriter中获取需要应用删除和更新的SegmentCommitInfo列表，使用org.apache.lucene.index.BufferedUpdatesStream#openSegmentStates方法打开这些SegmentCommitInfo，在内存中使用SegmentState表示打开的索引段，对打开的每一个索引段，调用org.apache.lucene.index.FrozenBufferedUpdates#apply(org.apache.lucene.index.BufferedUpdatesStream.SegmentState[])方法，决议出删除的文档ID，调用org.apache.lucene.index.ReadersAndUpdates#delete方法删除活跃文档ID文件中对应的ID，只是改变了内存中的状态。

### org.apache.lucene.index.IndexWriter.ReaderPool#commit

提交索引段的活跃文档修改到文件中，不调用文件系统的sync方法，没有强制刷新pagecache到磁盘中。


### org.apache.lucene.index.IndexWriter#publishFlushedSegment

调用org.apache.lucene.index.BufferedUpdatesStream#push方法。

### org.apache.lucene.index.IndexWriter#publishFrozenUpdates

调用org.apache.lucene.index.BufferedUpdatesStream#push方法。

### org.apache.lucene.index.DocumentsWriterFlushQueue.FlushTicket#finishFlush

调用org.apache.lucene.index.IndexWriter#publishFrozenUpdates

调用org.apache.lucene.index.DocumentsWriterFlushQueue.FlushTicket#publishFlushedSegment

### org.apache.lucene.index.DocumentsWriterFlushQueue.FlushTicket#publishFlushedSegment

调用org.apache.lucene.index.IndexWriter#publishFlushedSegment

### org.apache.lucene.index.DocumentsWriterFlushQueue.GlobalDeletesTicket#publish

调用org.apache.lucene.index.DocumentsWriterFlushQueue.FlushTicket#finishFlush

### org.apache.lucene.index.DocumentsWriterFlushQueue.SegmentFlushTicket#publish

调用org.apache.lucene.index.DocumentsWriterFlushQueue.FlushTicket#finishFlush

### org.apache.lucene.index.DocumentsWriterFlushQueue#innerPurge

调用org.apache.lucene.index.DocumentsWriterFlushQueue.SegmentFlushTicket#publish

调用org.apache.lucene.index.DocumentsWriterFlushQueue.GlobalDeletesTicket#publish

### org.apache.lucene.index.DocumentsWriterFlushQueue#forcePurge

调用org.apache.lucene.index.DocumentsWriterFlushQueue#innerPurge

### org.apache.lucene.index.DocumentsWriterFlushQueue#tryPurge

调用org.apache.lucene.index.DocumentsWriterFlushQueue#innerPurge

### org.apache.lucene.index.DocumentsWriter#purgeBuffer

调用org.apache.lucene.index.DocumentsWriterFlushQueue#forcePurge

调用org.apache.lucene.index.DocumentsWriterFlushQueue#tryPurge

### org.apache.lucene.index.IndexWriter#purge

调用org.apache.lucene.index.DocumentsWriter#purgeBuffer

### org.apache.lucene.index.IndexWriter#applyDeletesAndPurge

调用org.apache.lucene.index.IndexWriter#purge

### org.apache.lucene.index.DocumentsWriter.ApplyDeletesEvent#process

调用org.apache.lucene.index.IndexWriter#applyDeletesAndPurge

