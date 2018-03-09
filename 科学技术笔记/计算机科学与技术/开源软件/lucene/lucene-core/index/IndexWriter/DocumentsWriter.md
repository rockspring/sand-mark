# DocumentsWriter

IndexWriter有一个成员字段为DocumentsWriter类型。

```
org.apache.lucene.index.IndexWriter#docWriter DocumentsWriter
```

## 代码调用链路

### org.apache.lucene.index.DocumentsWriter#applyAllDeletes

```
at org.apache.lucene.index.DocumentsWriter.applyAllDeletes(DocumentsWriter.java:188)
at org.apache.lucene.index.DocumentsWriter.postUpdate(DocumentsWriter.java:412)
at org.apache.lucene.index.DocumentsWriter.updateDocument(DocumentsWriter.java:517)
at org.apache.lucene.index.IndexWriter.updateDocument(IndexWriter.java:1729)
at org.apache.lucene.index.IndexWriter.addDocument(IndexWriter.java:1464)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:52)
```


```
at org.apache.lucene.index.DocumentsWriterFlushControl.getAndResetApplyAllDeletes(DocumentsWriterFlushControl.java:456)
at org.apache.lucene.index.DocumentsWriter.applyAllDeletes(DocumentsWriter.java:188)
at org.apache.lucene.index.DocumentsWriter.postUpdate(DocumentsWriter.java:412)
at org.apache.lucene.index.DocumentsWriter.updateDocument(DocumentsWriter.java:517)
at org.apache.lucene.index.IndexWriter.updateDocument(IndexWriter.java:1729)
at org.apache.lucene.index.IndexWriter.addDocument(IndexWriter.java:1464)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:52)
```

org.apache.lucene.index.DocumentsWriterFlushQueue#addDeletes

### org.apache.lucene.index.DocumentsWriter#doFlush

org.apache.lucene.index.DocumentsWriterFlushControl#nextPendingFlush

```
at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:525)
at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:672)
at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3615)
- locked <0x80b> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3590)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

```
at org.apache.lucene.index.DocumentsWriterFlushQueue.incTickets(DocumentsWriterFlushQueue.java:54)
at org.apache.lucene.index.DocumentsWriterFlushQueue.addFlushTicket(DocumentsWriterFlushQueue.java:66)
- locked <0x73b> (a org.apache.lucene.index.DocumentsWriterFlushQueue)
at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:551)
at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:672)
at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3615)
- locked <0x80b> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3590)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

关联的方法

```
org.apache.lucene.index.DocumentsWriterPerThread#prepareFlush
org.apache.lucene.index.DocumentsWriterDeleteQueue#freezeGlobalBuffer
org.apache.lucene.index.DocumentsWriterDeleteQueue.DeleteSlice#apply
org.apache.lucene.index.BufferedUpdates#any
org.apache.lucene.index.FrozenBufferedUpdates#FrozenBufferedUpdates
org.apache.lucene.index.DocumentsWriterFlushQueue.SegmentFlushTicket#SegmentFlushTicket
```

创建的org.apache.lucene.index.DocumentsWriterFlushQueue.SegmentFlushTicket添加到org.apache.lucene.index.DocumentsWriterFlushQueue#queue Queue<FlushTicket>。

```
at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:418)
at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:556)
at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:672)
at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3615)
- locked <0x80b> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3590)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

```
at org.apache.lucene.index.DefaultIndexingChain.flush(DefaultIndexingChain.java:122)
at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:452)
at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:556)
at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:672)
at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3615)
- locked <0x80b> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3590)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

段刷新之后

```
at org.apache.lucene.index.IndexWriter.publishFlushedSegment(IndexWriter.java:2680)
- locked <0x6d8> (a org.apache.lucene.index.IndexWriter)
at org.apache.lucene.index.DocumentsWriterFlushQueue$FlushTicket.publishFlushedSegment(DocumentsWriterFlushQueue.java:201)
at org.apache.lucene.index.DocumentsWriterFlushQueue$FlushTicket.finishFlush(DocumentsWriterFlushQueue.java:215)
at org.apache.lucene.index.DocumentsWriterFlushQueue$SegmentFlushTicket.publish(DocumentsWriterFlushQueue.java:252)
at org.apache.lucene.index.DocumentsWriterFlushQueue.innerPurge(DocumentsWriterFlushQueue.java:116)
at org.apache.lucene.index.DocumentsWriterFlushQueue.tryPurge(DocumentsWriterFlushQueue.java:153)
at org.apache.lucene.index.DocumentsWriter.purgeBuffer(DocumentsWriter.java:202)
at org.apache.lucene.index.IndexWriter.purge(IndexWriter.java:5051)
at org.apache.lucene.index.IndexWriter.doAfterSegmentFlushed(IndexWriter.java:5064)
at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:600)
at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:672)
at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3615)
- locked <0x80b> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3590)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

添加事件

org.apache.lucene.index.DocumentsWriter#putEvent(Event event)

org.apache.lucene.index.IndexWriter#processEvents(java.util.Queue<org.apache.lucene.index.IndexWriter.Event>, boolean, boolean) 处理事件

```
at org.apache.lucene.index.BufferedUpdatesStream$FinishedSegments.finishedSegment(BufferedUpdatesStream.java:416)
- locked <0xc20> (a org.apache.lucene.index.BufferedUpdatesStream$FinishedSegments)
at org.apache.lucene.index.BufferedUpdatesStream.finishedSegment(BufferedUpdatesStream.java:167)
at org.apache.lucene.index.IndexWriter.publishFlushedSegment(IndexWriter.java:2709)
- locked <0x6d8> (a org.apache.lucene.index.IndexWriter)
at org.apache.lucene.index.DocumentsWriterFlushQueue$FlushTicket.publishFlushedSegment(DocumentsWriterFlushQueue.java:201)
at org.apache.lucene.index.DocumentsWriterFlushQueue$FlushTicket.finishFlush(DocumentsWriterFlushQueue.java:215)
at org.apache.lucene.index.DocumentsWriterFlushQueue$SegmentFlushTicket.publish(DocumentsWriterFlushQueue.java:252)
at org.apache.lucene.index.DocumentsWriterFlushQueue.innerPurge(DocumentsWriterFlushQueue.java:116)
at org.apache.lucene.index.DocumentsWriterFlushQueue.tryPurge(DocumentsWriterFlushQueue.java:153)
at org.apache.lucene.index.DocumentsWriter.purgeBuffer(DocumentsWriter.java:202)
at org.apache.lucene.index.IndexWriter.purge(IndexWriter.java:5051)
at org.apache.lucene.index.IndexWriter.doAfterSegmentFlushed(IndexWriter.java:5064)
at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:600)
at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:672)
at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3615)
- locked <0x80b> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3590)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

添加新的段到SegmentInfos

```
at org.apache.lucene.index.SegmentInfos.add(SegmentInfos.java:962)
at org.apache.lucene.index.IndexWriter.publishFlushedSegment(IndexWriter.java:2715)
- locked <0x6d8> (a org.apache.lucene.index.IndexWriter)
at org.apache.lucene.index.DocumentsWriterFlushQueue$FlushTicket.publishFlushedSegment(DocumentsWriterFlushQueue.java:201)
at org.apache.lucene.index.DocumentsWriterFlushQueue$FlushTicket.finishFlush(DocumentsWriterFlushQueue.java:215)
at org.apache.lucene.index.DocumentsWriterFlushQueue$SegmentFlushTicket.publish(DocumentsWriterFlushQueue.java:252)
at org.apache.lucene.index.DocumentsWriterFlushQueue.innerPurge(DocumentsWriterFlushQueue.java:116)
at org.apache.lucene.index.DocumentsWriterFlushQueue.tryPurge(DocumentsWriterFlushQueue.java:153)
at org.apache.lucene.index.DocumentsWriter.purgeBuffer(DocumentsWriter.java:202)
at org.apache.lucene.index.IndexWriter.purge(IndexWriter.java:5051)
at org.apache.lucene.index.IndexWriter.doAfterSegmentFlushed(IndexWriter.java:5064)
at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:600)
at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:672)
at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3615)
- locked <0x80b> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3590)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

对段进行checkpoint

```
at org.apache.lucene.index.IndexFileDeleter.checkpoint(IndexFileDeleter.java:510)
at org.apache.lucene.index.IndexWriter.checkpoint(IndexWriter.java:2649)
- locked <0x6d8> (a org.apache.lucene.index.IndexWriter)
at org.apache.lucene.index.IndexWriter.publishFlushedSegment(IndexWriter.java:2717)
at org.apache.lucene.index.DocumentsWriterFlushQueue$FlushTicket.publishFlushedSegment(DocumentsWriterFlushQueue.java:201)
at org.apache.lucene.index.DocumentsWriterFlushQueue$FlushTicket.finishFlush(DocumentsWriterFlushQueue.java:215)
at org.apache.lucene.index.DocumentsWriterFlushQueue$SegmentFlushTicket.publish(DocumentsWriterFlushQueue.java:252)
at org.apache.lucene.index.DocumentsWriterFlushQueue.innerPurge(DocumentsWriterFlushQueue.java:116)
at org.apache.lucene.index.DocumentsWriterFlushQueue.tryPurge(DocumentsWriterFlushQueue.java:153)
at org.apache.lucene.index.DocumentsWriter.purgeBuffer(DocumentsWriter.java:202)
at org.apache.lucene.index.IndexWriter.purge(IndexWriter.java:5051)
at org.apache.lucene.index.IndexWriter.doAfterSegmentFlushed(IndexWriter.java:5064)
at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:600)
at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:672)
at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3615)
- locked <0x80b> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3590)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

可能触发merge

```
org.apache.lucene.index.IndexWriter#maybeMerge(org.apache.lucene.index.MergePolicy, org.apache.lucene.index.MergeTrigger, int)
```

org.apache.lucene.index.DocumentsWriterFlushQueue#forcePurge

org.apache.lucene.index.DocumentsWriter#finishFullFlush

```
at org.apache.lucene.index.DocumentsWriterStallControl.updateStalled(DocumentsWriterStallControl.java:56)
at org.apache.lucene.index.DocumentsWriterFlushControl.updateStallState(DocumentsWriterFlushControl.java:245)
at org.apache.lucene.index.DocumentsWriterFlushControl.finishFullFlush(DocumentsWriterFlushControl.java:614)
- locked <0x6d6> (a org.apache.lucene.index.DocumentsWriterFlushControl)
at org.apache.lucene.index.DocumentsWriter.finishFullFlush(DocumentsWriter.java:705)
at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3628)
- locked <0x80b> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3590)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

处理事件

```
at org.apache.lucene.index.IndexWriter.processEvents(IndexWriter.java:5096)
at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3629)
- locked <0x80b> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3590)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

可能调用org.apache.lucene.index.IndexWriter#maybeMerge(org.apache.lucene.index.MergePolicy, org.apache.lucene.index.MergeTrigger, int)

applyAllDeletesAndUpdates

```
at org.apache.lucene.index.BufferedUpdatesStream.waitApply(BufferedUpdatesStream.java:229)
at org.apache.lucene.index.BufferedUpdatesStream.waitApplyAll(BufferedUpdatesStream.java:158)
at org.apache.lucene.index.IndexWriter.applyAllDeletesAndUpdates(IndexWriter.java:3663)
at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3634)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3590)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

doAfterFlush

```
at org.apache.lucene.index.IndexWriter.doAfterFlush(IndexWriter.java:3151)
at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3640)
- locked <0x6d8> (a org.apache.lucene.index.IndexWriter)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3590)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

doFlush方法返回true，调用maybeMerge

```
at org.apache.lucene.index.TieredMergePolicy.findMerges(TieredMergePolicy.java:285)
at org.apache.lucene.index.IndexWriter.updatePendingMerges(IndexWriter.java:2283)
- locked <0x6d8> (a org.apache.lucene.index.IndexWriter)
at org.apache.lucene.index.IndexWriter.maybeMerge(IndexWriter.java:2246)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3591)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)


at org.apache.lucene.index.ConcurrentMergeScheduler.merge(ConcurrentMergeScheduler.java:529)
- locked <0x800> (a org.apache.lucene.index.ConcurrentMergeScheduler)
at org.apache.lucene.index.IndexWriter.maybeMerge(IndexWriter.java:2247)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3591)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

ConcurrentMergeScheduler启动合并线程MergeThread

再次merge

```
at org.apache.lucene.index.ConcurrentMergeScheduler.merge(ConcurrentMergeScheduler.java:498)
- locked <0x800> (a org.apache.lucene.index.ConcurrentMergeScheduler)
at org.apache.lucene.index.IndexWriter.maybeMerge(IndexWriter.java:2247)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2080)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

可能org.apache.lucene.index.IndexWriter#doWait

提交

```
at org.apache.lucene.index.IndexWriter.prepareCommitInternal(IndexWriter.java:3214)
at org.apache.lucene.index.IndexWriter.commitInternal(IndexWriter.java:3458)
- locked <0x80a> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.commit(IndexWriter.java:3423)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:56)


at org.apache.lucene.index.IndexWriter#finishCommit(IndexWriter.java:3477)
at org.apache.lucene.index.IndexWriter.commitInternal(IndexWriter.java:3458)
- locked <0x80a> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.commit(IndexWriter.java:3423)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:56)
```

关闭IndexWriter

```
org.apache.lucene.index.IndexWriter#shutdown

org.apache.lucene.index.IndexWriter#rollback
```

### org.apache.lucene.index.DocumentsWriter#flushAllThreads

```
at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:649)
at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3615)
- locked <0x80b> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3590)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2051)
at org.apache.lucene.index.IndexWriter.forceMerge(IndexWriter.java:2031)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:54)
```

### org.apache.lucene.index.DocumentsWriter#flushOneDWPT

```
at org.apache.lucene.index.DocumentsWriter.flushOneDWPT(DocumentsWriter.java:259)
at org.apache.lucene.index.IndexWriter.flushNextBuffer(IndexWriter.java:3203)
at org.apache.lucene.index.TestIndexWriter.testFlushLargestWriter(TestIndexWriter.java:2762)
```

