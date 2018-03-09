# DocumentsWriterFlushControl

DocumentsWriterFlushControl在索引过程中控制DocumentsWriterPerThread的刷新过程。它跟踪每个DocumentsWriterPerThread的内存消耗，使用一个FlushPolicy去决定一个DocumentsWriterPerThread是否刷新。

除了通过FlushPolicy判定是否刷新外。如果一个DocumentsWriterPerThread的内存消耗超过了IndexWriterConfig#getRAMPerThreadHardLimitMB()，为了避免地址空间耗尽，DocumentsWriterFlushControl设置某一个DocumentsWriterPerThread为待刷新状态。

## 一 内部类

### DocumentsWriterFlushControl.BlockedFlush

被阻塞的刷新。

数据结构

```
final DocumentsWriterPerThread dwpt;
final long bytes;
```

DocumentsWriterFlushControl#checkoutAndBlock创建BlockedFlush

DocumentsWriterFlushControl#checkout方法调用checkoutAndBlock

DocumentsWriterFlushControl#checkoutLargestNonPendingWriter调用checkout

DocumentsWriterFlushControl#doAfterDocument调用checkout

DocumentsWriter#flushOneDWPT调用checkoutLargestNonPendingWriter

IndexWriter#flushNextBuffer调用flushOneDWPT


## 二 字段

```
private final long org.apache.lucene.index.DocumentsWriterFlushControl.hardMaxBytesPerDWPT
private long org.apache.lucene.index.DocumentsWriterFlushControl.activeBytes
private long org.apache.lucene.index.DocumentsWriterFlushControl.flushBytes
private volatile int org.apache.lucene.index.DocumentsWriterFlushControl.numPending
private int org.apache.lucene.index.DocumentsWriterFlushControl.numDocsSinceStalled
private boolean org.apache.lucene.index.DocumentsWriterFlushControl.fullFlush
private final java.util.Queue org.apache.lucene.index.DocumentsWriterFlushControl.flushQueue
private final java.util.Queue org.apache.lucene.index.DocumentsWriterFlushControl.blockedFlushes
private final java.util.IdentityHashMap org.apache.lucene.index.DocumentsWriterFlushControl.flushingWriters
private final org.apache.lucene.index.DocumentsWriterPerThreadPool org.apache.lucene.index.DocumentsWriterFlushControl.perThreadPool
private final org.apache.lucene.index.FlushPolicy org.apache.lucene.index.DocumentsWriterFlushControl.flushPolicy
private boolean org.apache.lucene.index.DocumentsWriterFlushControl.closed
private final org.apache.lucene.index.DocumentsWriter org.apache.lucene.index.DocumentsWriterFlushControl.documentsWriter
private final org.apache.lucene.index.LiveIndexWriterConfig org.apache.lucene.index.DocumentsWriterFlushControl.config
private final org.apache.lucene.index.BufferedUpdatesStream org.apache.lucene.index.DocumentsWriterFlushControl.bufferedUpdatesStream
private final org.apache.lucene.util.InfoStream org.apache.lucene.index.DocumentsWriterFlushControl.infoStream
private long org.apache.lucene.index.DocumentsWriterFlushControl.stallStartNS
private final java.util.List org.apache.lucene.index.DocumentsWriterFlushControl.fullFlushBuffer

final java.util.concurrent.atomic.AtomicBoolean org.apache.lucene.index.DocumentsWriterFlushControl.flushDeletes
double org.apache.lucene.index.DocumentsWriterFlushControl.maxConfiguredRamBuffer
long org.apache.lucene.index.DocumentsWriterFlushControl.peakActiveBytes
long org.apache.lucene.index.DocumentsWriterFlushControl.peakFlushBytes
long org.apache.lucene.index.DocumentsWriterFlushControl.peakNetBytes
long org.apache.lucene.index.DocumentsWriterFlushControl.peakDelta
boolean org.apache.lucene.index.DocumentsWriterFlushControl.flushByRAMWasDisabled
final org.apache.lucene.index.DocumentsWriterStallControl org.apache.lucene.index.DocumentsWriterFlushControl.stallControl
```

###  private final long org.apache.lucene.index.DocumentsWriterFlushControl.hardMaxBytesPerDWPT
###  private long org.apache.lucene.index.DocumentsWriterFlushControl.activeBytes
###  private long org.apache.lucene.index.DocumentsWriterFlushControl.flushBytes
###  private volatile int org.apache.lucene.index.DocumentsWriterFlushControl.numPending
###  private int org.apache.lucene.index.DocumentsWriterFlushControl.numDocsSinceStalled
###  private boolean org.apache.lucene.index.DocumentsWriterFlushControl.fullFlush

如果在进行全部刷新，值为true。

###  private final java.util.Queue org.apache.lucene.index.DocumentsWriterFlushControl.flushQueue
###  private final java.util.Queue org.apache.lucene.index.DocumentsWriterFlushControl.blockedFlushes
###  private final java.util.IdentityHashMap org.apache.lucene.index.DocumentsWriterFlushControl.flushingWriters
###  private final org.apache.lucene.index.DocumentsWriterPerThreadPool org.apache.lucene.index.DocumentsWriterFlushControl.perThreadPool
###  private final org.apache.lucene.index.FlushPolicy org.apache.lucene.index.DocumentsWriterFlushControl.flushPolicy
###  private boolean org.apache.lucene.index.DocumentsWriterFlushControl.closed
###  private final org.apache.lucene.index.DocumentsWriter org.apache.lucene.index.DocumentsWriterFlushControl.documentsWriter
###  private final org.apache.lucene.index.LiveIndexWriterConfig org.apache.lucene.index.DocumentsWriterFlushControl.config
###  private final org.apache.lucene.index.BufferedUpdatesStream org.apache.lucene.index.DocumentsWriterFlushControl.bufferedUpdatesStream
###  private final org.apache.lucene.util.InfoStream org.apache.lucene.index.DocumentsWriterFlushControl.infoStream
###  private long org.apache.lucene.index.DocumentsWriterFlushControl.stallStartNS
###  private final java.util.List org.apache.lucene.index.DocumentsWriterFlushControl.fullFlushBuffer


## 三 构造函数

## 四 方法

```
private DocumentsWriterPerThread DocumentsWriterFlushControl.checkout(DocumentsWriterPerThreadPool$ThreadState,boolean)
private long DocumentsWriterFlushControl.stallLimitBytes()
private boolean DocumentsWriterFlushControl.assertMemory()
private void DocumentsWriterFlushControl.commitPerThreadBytes(DocumentsWriterPerThreadPool$ThreadState)
private boolean DocumentsWriterFlushControl.updatePeaks(long)
private boolean DocumentsWriterFlushControl.assertNumDocsSinceStalled(boolean)
private boolean DocumentsWriterFlushControl.updateStallState()
private void DocumentsWriterFlushControl.checkoutAndBlock(DocumentsWriterPerThreadPool$ThreadState)
private DocumentsWriterPerThread DocumentsWriterFlushControl.internalTryCheckOutForFlush(DocumentsWriterPerThreadPool$ThreadState)
private java.util.Iterator DocumentsWriterFlushControl.getPerThreadsIterator(int)
private boolean DocumentsWriterFlushControl.assertActiveDeleteQueue(DocumentsWriterDeleteQueue)
private void DocumentsWriterFlushControl.pruneBlockedQueue(DocumentsWriterDeleteQueue)
```

```
synchronized DocumentsWriterPerThread DocumentsWriterFlushControl.doAfterDocument(DocumentsWriterPerThreadPool$ThreadState,boolean)
synchronized void DocumentsWriterFlushControl.doAfterFlush(DocumentsWriterPerThread)
synchronized void DocumentsWriterFlushControl.doOnAbort(DocumentsWriterPerThreadPool$ThreadState)
synchronized DocumentsWriterPerThread DocumentsWriterFlushControl.tryCheckoutForFlush(DocumentsWriterPerThreadPool$ThreadState)
DocumentsWriterPerThread DocumentsWriterFlushControl.nextPendingFlush()
synchronized void DocumentsWriterFlushControl.setClosed()
synchronized void DocumentsWriterFlushControl.doOnDelete()
synchronized int DocumentsWriterFlushControl.numFlushingDWPT()
DocumentsWriterPerThreadPool$ThreadState DocumentsWriterFlushControl.obtainAndLock()
long DocumentsWriterFlushControl.markForFullFlush()
void DocumentsWriterFlushControl.addFlushableState(DocumentsWriterPerThreadPool$ThreadState)
synchronized void DocumentsWriterFlushControl.finishFullFlush()
boolean DocumentsWriterFlushControl.assertBlockedFlushes(DocumentsWriterDeleteQueue)
synchronized void DocumentsWriterFlushControl.abortFullFlushes()
synchronized void DocumentsWriterFlushControl.abortPendingFlushes()
synchronized boolean DocumentsWriterFlushControl.isFullFlush()
synchronized int DocumentsWriterFlushControl.numQueuedFlushes()
synchronized int DocumentsWriterFlushControl.numBlockedFlushes()
void DocumentsWriterFlushControl.waitIfStalled()
boolean DocumentsWriterFlushControl.anyStalledThreads()
synchronized DocumentsWriterPerThreadPool$ThreadState DocumentsWriterFlushControl.findLargestNonPendingWriter()
final DocumentsWriterPerThread DocumentsWriterFlushControl.checkoutLargestNonPendingWriter()
```

```
public java.lang.String DocumentsWriterFlushControl.toString()
public synchronized long DocumentsWriterFlushControl.netBytes()
public synchronized long DocumentsWriterFlushControl.activeBytes()
public synchronized long DocumentsWriterFlushControl.flushBytes()
public synchronized void DocumentsWriterFlushControl.waitForFlush()
public synchronized void DocumentsWriterFlushControl.setFlushPending(DocumentsWriterPerThreadPool$ThreadState)
public java.util.Iterator DocumentsWriterFlushControl.allActiveThreadStates()
public long DocumentsWriterFlushControl.getDeleteBytesUsed()
public long DocumentsWriterFlushControl.ramBytesUsed()
public boolean DocumentsWriterFlushControl.getAndResetApplyAllDeletes()
public void DocumentsWriterFlushControl.setApplyAllDeletes()
public org.apache.lucene.util.InfoStream DocumentsWriterFlushControl.getInfoStream()
```

### 私有方法

#### private DocumentsWriterPerThread DocumentsWriterFlushControl.checkout(DocumentsWriterPerThreadPool$ThreadState perThread, boolean markPending)

如果fullFlush=true并且perThread.flushPending=true，则调用checkoutAndBlock将perThread的dwpt加入到org.apache.lucene.index.DocumentsWriterFlushControl#blockedFlushes。然后调用org.apache.lucene.index.DocumentsWriterFlushControl#nextPendingFlush方法返回下一个待刷新的

如果fullFlush=false。如果markPending=true，则标记perThread为待刷新状态。调用org.apache.lucene.index.DocumentsWriterFlushControl#tryCheckoutForFlush方法把其DocumentsWriterPerThread检出，将其返回。

如下方法调用改方法

```
synchronized DocumentsWriterPerThread DocumentsWriterFlushControl.doAfterDocument(DocumentsWriterPerThreadPool$ThreadState,boolean)
final DocumentsWriterPerThread DocumentsWriterFlushControl.checkoutLargestNonPendingWriter()
```

#### private long DocumentsWriterFlushControl.stallLimitBytes()



#### private boolean DocumentsWriterFlushControl.assertMemory()



#### private void DocumentsWriterFlushControl.commitPerThreadBytes(DocumentsWriterPerThreadPool$ThreadState)



#### private boolean DocumentsWriterFlushControl.updatePeaks(long)



#### private boolean DocumentsWriterFlushControl.assertNumDocsSinceStalled(boolean)



#### private boolean DocumentsWriterFlushControl.updateStallState()

调用org.apache.lucene.index.DocumentsWriterFlushControl#stallLimitBytes方法获取要进入暂停状态的内存极限值limit。

如果(activeBytes + flushBytes) > limit 且 activeBytes < limit 且 !closed，则设置stall=true，表示要暂停。调用org.apache.lucene.index.DocumentsWriterStallControl#updateStalled方法设置暂停标志为true，并且通知等待的线程。

#### private void DocumentsWriterFlushControl.checkoutAndBlock(DocumentsWriterPerThreadPool$ThreadState)

DocumentsWriterPerThreadPool$ThreadState类型的perThread必须是待刷新状态，即perThread.flushPending=true。
fullFlush必须等于true。

重置perThread，使得ThreadState不再拥有dwpt。numPending数量减去1。创建一个BlockedFlush对象，然后加入到org.apache.lucene.index.DocumentsWriterFlushControl#blockedFlushes。

#### private DocumentsWriterPerThread DocumentsWriterFlushControl.internalTryCheckOutForFlush(DocumentsWriterPerThreadPool$ThreadState perThread)

确保线程锁在DocumentsWriterFlushControl对象上。
确保perThread是在待刷新状态。

锁住perThread。如果perThread已经初始化了，取出其dwpt，然后重置perThread为零。将dwpt放入到org.apache.lucene.index.DocumentsWriterFlushControl#flushingWriters。最后返回dwpt。释放perThread的锁。最后调用org.apache.lucene.index.DocumentsWriterFlushControl#updateStallState。

#### private java.util.Iterator DocumentsWriterFlushControl.getPerThreadsIterator(int upto)

```
at org.apache.lucene.index.DocumentsWriterFlushControl.getPerThreadsIterator(DocumentsWriterFlushControl.java:417)
at org.apache.lucene.index.DocumentsWriterFlushControl.allActiveThreadStates(DocumentsWriterFlushControl.java:413)
at org.apache.lucene.index.DocumentsWriterFlushControl.findLargestNonPendingWriter(DocumentsWriterFlushControl.java:726)
- locked <0x7a5> (a org.apache.lucene.index.DocumentsWriterFlushControl)
at org.apache.lucene.index.DocumentsWriterFlushControl.checkoutLargestNonPendingWriter(DocumentsWriterFlushControl.java:754)
at org.apache.lucene.index.DocumentsWriter.flushOneDWPT(DocumentsWriter.java:256)
at org.apache.lucene.index.IndexWriter.flushNextBuffer(IndexWriter.java:3203)
at org.apache.lucene.index.TestIndexWriter.testFlushLargestWriter(TestIndexWriter.java:2762)
```

创建一个迭代器，这个迭代器从perThreadPool中获取ThreadState，迭代器最多可以获取upto个ThreadState。


#### private boolean DocumentsWriterFlushControl.assertActiveDeleteQueue(DocumentsWriterDeleteQueue)



#### private void DocumentsWriterFlushControl.pruneBlockedQueue(DocumentsWriterDeleteQueue)


### 同一个包内可访问方法

#### synchronized DocumentsWriterPerThread DocumentsWriterFlushControl.doAfterDocument(DocumentsWriterPerThreadPool$ThreadState,boolean)



#### synchronized void DocumentsWriterFlushControl.doAfterFlush(DocumentsWriterPerThread)



#### synchronized void DocumentsWriterFlushControl.doOnAbort(DocumentsWriterPerThreadPool$ThreadState)



#### synchronized DocumentsWriterPerThread DocumentsWriterFlushControl.tryCheckoutForFlush(DocumentsWriterPerThreadPool$ThreadState perThread)

如果perThread不是待刷新状态，返回null。如果perThread是待刷新状态，调用org.apache.lucene.index.DocumentsWriterFlushControl#internalTryCheckOutForFlush方法，返回其结果。

#### DocumentsWriterPerThread DocumentsWriterFlushControl.nextPendingFlush()

```
at org.apache.lucene.index.DocumentsWriterFlushControl.nextPendingFlush(DocumentsWriterFlushControl.java:379)
at org.apache.lucene.index.DocumentsWriter.flushOneDWPT(DocumentsWriter.java:254)
at org.apache.lucene.index.IndexWriter.flushNextBuffer(IndexWriter.java:3203)
at org.apache.lucene.index.TestIndexWriter.testFlushLargestWriter(TestIndexWriter.java:2762)
```

尝试从org.apache.lucene.index.DocumentsWriterFlushControl#flushQueue中轮询出一个DocumentsWriterPerThread，如果flushQueue里面有DocumentsWriterPerThread，调用updateStallState方法，最后返回这个DocumentsWriterPerThread。

如果待刷新的数量大于0并且不是全刷新。调用org.apache.lucene.index.DocumentsWriterPerThreadPool#getActiveThreadStateCount方法获取活跃的ThreadState数量。从活跃的线程状态中选择一个处于待刷新状态的线程状态，并调用org.apache.lucene.index.DocumentsWriterFlushControl#tryCheckoutForFlush方法获取其DocumentsWriterPerThread。

#### synchronized void DocumentsWriterFlushControl.setClosed()



#### synchronized void DocumentsWriterFlushControl.doOnDelete()



#### synchronized int DocumentsWriterFlushControl.numFlushingDWPT()



#### DocumentsWriterPerThreadPool$ThreadState DocumentsWriterFlushControl.obtainAndLock()



#### long DocumentsWriterFlushControl.markForFullFlush()



#### void DocumentsWriterFlushControl.addFlushableState(DocumentsWriterPerThreadPool$ThreadState)



#### synchronized void DocumentsWriterFlushControl.finishFullFlush()



#### boolean DocumentsWriterFlushControl.assertBlockedFlushes(DocumentsWriterDeleteQueue)



#### synchronized void DocumentsWriterFlushControl.abortFullFlushes()



#### synchronized void DocumentsWriterFlushControl.abortPendingFlushes()



#### synchronized boolean DocumentsWriterFlushControl.isFullFlush()



#### synchronized int DocumentsWriterFlushControl.numQueuedFlushes()



#### synchronized int DocumentsWriterFlushControl.numBlockedFlushes()



#### void DocumentsWriterFlushControl.waitIfStalled()



#### boolean DocumentsWriterFlushControl.anyStalledThreads()



#### synchronized DocumentsWriterPerThreadPool$ThreadState DocumentsWriterFlushControl.findLargestNonPendingWriter()

```
at org.apache.lucene.index.DocumentsWriterFlushControl.findLargestNonPendingWriter(DocumentsWriterFlushControl.java:726)
- locked <0x7a5> (a org.apache.lucene.index.DocumentsWriterFlushControl)
at org.apache.lucene.index.DocumentsWriterFlushControl.checkoutLargestNonPendingWriter(DocumentsWriterFlushControl.java:754)
at org.apache.lucene.index.DocumentsWriter.flushOneDWPT(DocumentsWriter.java:256)
at org.apache.lucene.index.IndexWriter.flushNextBuffer(IndexWriter.java:3203)
at org.apache.lucene.index.TestIndexWriter.testFlushLargestWriter(TestIndexWriter.java:2762)
```

调用org.apache.lucene.index.DocumentsWriterFlushControl#allActiveThreadStates获取所有的活跃ThreadState的迭代器。从迭代器依次取出ThreadState，记录内存占用最大的并且不是flushPending状态的ThreadState，返回给上层调用者。

#### final DocumentsWriterPerThread DocumentsWriterFlushControl.checkoutLargestNonPendingWriter()

```
at org.apache.lucene.index.DocumentsWriterFlushControl.checkoutLargestNonPendingWriter(DocumentsWriterFlushControl.java:754)
at org.apache.lucene.index.DocumentsWriter.flushOneDWPT(DocumentsWriter.java:256)
at org.apache.lucene.index.IndexWriter.flushNextBuffer(IndexWriter.java:3203)
at org.apache.lucene.index.TestIndexWriter.testFlushLargestWriter(TestIndexWriter.java:2762)
```

获取内存占用最大的非待刷新状态的可刷新DWPT。

调用org.apache.lucene.index.DocumentsWriterFlushControl#findLargestNonPendingWriter获取占用内存最大的非刷新状态的ThreadState。

如果ThreadState没有关联DocumentsWriterPerThread，调用org.apache.lucene.index.DocumentsWriterFlushControl#nextPendingFlush方法。

如果ThreadState已经关联了DocumentsWriterPerThread，调用org.apache.lucene.index.DocumentsWriterFlushControl#checkout方法，首先设置largestNonPendingWriter的状态为待刷新状态，然后获取其DocumentsWriterPerThread。

### 公开方法

#### public java.lang.String DocumentsWriterFlushControl.toString()
#### public synchronized long DocumentsWriterFlushControl.netBytes()
#### public synchronized long DocumentsWriterFlushControl.activeBytes()
#### public synchronized long DocumentsWriterFlushControl.flushBytes()
#### public synchronized void DocumentsWriterFlushControl.waitForFlush()
#### public synchronized void DocumentsWriterFlushControl.setFlushPending(DocumentsWriterPerThreadPool$ThreadState perThread)

设置perThread的状态为待刷新状态。flushBytes增加perThread.bytesUsed，activeBytes减少perThread.bytesUsed。numPending加1。

#### public java.util.Iterator DocumentsWriterFlushControl.allActiveThreadStates()

调用org.apache.lucene.index.DocumentsWriterPerThreadPool#getActiveThreadStateCount获取活跃的ThreadState数量。调用org.apache.lucene.index.DocumentsWriterFlushControl#getPerThreadsIterator创建一个活跃ThreadState迭代器。

#### public long DocumentsWriterFlushControl.getDeleteBytesUsed()
#### public long DocumentsWriterFlushControl.ramBytesUsed()
#### public boolean DocumentsWriterFlushControl.getAndResetApplyAllDeletes()
#### public void DocumentsWriterFlushControl.setApplyAllDeletes()
#### public org.apache.lucene.util.InfoStream DocumentsWriterFlushControl.getInfoStream()
