IOManager

```
"IOManager reader thread #1" #274 daemon prio=5 os_prio=31 tid=0x00007fe69c236800 nid=0x981b waiting on condition [0x000070000383b000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000744542b40> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.flink.runtime.io.disk.iomanager.IOManagerAsync$ReaderThread.run(IOManagerAsync.java:380)

   Locked ownable synchronizers:
	- None

"IOManager writer thread #1" #273 daemon prio=5 os_prio=31 tid=0x00007fe69bf70000 nid=0x9717 waiting on condition [0x0000700003738000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000744542778> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.flink.runtime.io.disk.iomanager.IOManagerAsync$WriterThread.run(IOManagerAsync.java:486)

   Locked ownable synchronizers:
	- None
```

操作磁盘不是直接调用方法操作，而是创建一个IO请求，放入请求队列，由一个线程从请求队列读取IO请求，然后执行IO请求完成与磁盘的具体操作。

读磁盘数据由IOManagerAsync$ReaderThread线程完成，写磁盘数据由IOManagerAsync$WriterThread线程完成。

发起写请求的代码调用链路：

org.apache.flink.runtime.operators.sort.LargeRecordHandler#close
org.apache.flink.runtime.io.disk.FileChannelOutputView#close()
org.apache.flink.runtime.io.disk.FileChannelOutputView#close(boolean)
org.apache.flink.runtime.io.disk.FileChannelOutputView#writeSegment
org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockWriterWithCallback#writeBlock
org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#addRequest

org.apache.flink.runtime.io.disk.FileChannelOutputView#closeAndDelete
org.apache.flink.runtime.io.disk.FileChannelOutputView#close(boolean)
org.apache.flink.runtime.io.disk.FileChannelOutputView#writeSegment
org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockWriterWithCallback#writeBlock
org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#addRequest

org.apache.flink.runtime.io.disk.FileChannelOutputView#nextSegment
org.apache.flink.runtime.io.disk.FileChannelOutputView#writeSegment
org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockWriterWithCallback#writeBlock
org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#addRequest

org.apache.flink.runtime.io.disk.SpillingBuffer#flip

org.apache.flink.runtime.io.disk.SpillingBuffer#nextSegment

org.apache.flink.runtime.io.disk.iomanager.ChannelWriterOutputView#writeSegment

org.apache.flink.runtime.io.network.partition.SpillableSubpartition#add

org.apache.flink.runtime.io.network.partition.SpillableSubpartition#releaseMemory

org.apache.flink.runtime.io.network.partition.SpillableSubpartitionView#releaseMemory

org.apache.flink.runtime.iterative.io.SerializedUpdateBuffer#nextSegment

org.apache.flink.runtime.iterative.io.SerializedUpdateBuffer#switchBuffers

org.apache.flink.runtime.operators.hash.HashPartition.BuildSideBuffer#close

org.apache.flink.runtime.operators.hash.HashPartition.BuildSideBuffer#nextSegment

org.apache.flink.runtime.operators.hash.HashPartition.BuildSideBuffer#spill

org.apache.flink.runtime.operators.hash.ReOpenableHashPartition#spillInMemoryPartition

发起读请求的代码调用链路：

org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockReader#readBlock
org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#addRequest

org.apache.flink.runtime.operators.sort.LargeRecordHandler#finishWriteAndSortKeys
org.apache.flink.runtime.io.disk.FileChannelInputView#FileChannelInputView
org.apache.flink.runtime.io.disk.FileChannelInputView#sendReadRequest
org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockReader#readBlock
org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#addRequest

org.apache.flink.runtime.io.disk.FileChannelInputView#FileChannelInputView
org.apache.flink.runtime.memory.AbstractPagedInputView#advance
org.apache.flink.runtime.io.disk.FileChannelInputView#nextSegment
org.apache.flink.runtime.io.disk.FileChannelInputView#sendReadRequest
org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockReader#readBlock
org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#addRequest

org.apache.flink.runtime.io.disk.SeekableFileChannelInputView#SeekableFileChannelInputView
org.apache.flink.runtime.memory.AbstractPagedInputView#advance
org.apache.flink.runtime.io.disk.FileChannelInputView#nextSegment
org.apache.flink.runtime.io.disk.FileChannelInputView#sendReadRequest
org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockReader#readBlock
org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#addRequest

org.apache.flink.runtime.io.disk.iomanager.ChannelReaderInputView#ChannelReaderInputView(org.apache.flink.runtime.io.disk.iomanager.BlockChannelReader<org.apache.flink.core.memory.MemorySegment>, java.util.List<org.apache.flink.core.memory.MemorySegment>, int, int, boolean)
org.apache.flink.runtime.memory.AbstractPagedInputView#advance
org.apache.flink.runtime.io.disk.FileChannelInputView#nextSegment
org.apache.flink.runtime.io.disk.FileChannelInputView#sendReadRequest
org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockReader#readBlock
org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#addRequest

org.apache.flink.runtime.memory.AbstractPagedInputView#read(byte[], int, int)
org.apache.flink.runtime.memory.AbstractPagedInputView#advance
org.apache.flink.runtime.io.disk.FileChannelInputView#nextSegment
org.apache.flink.runtime.io.disk.FileChannelInputView#sendReadRequest
org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockReader#readBlock
org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#addRequest


## 读请求的结果处理

org.apache.flink.runtime.io.network.partition.SpilledSubpartitionView#SpilledSubpartitionView
org.apache.flink.runtime.io.disk.iomanager.AsynchronousBufferFileWriter#registerAllRequestsProcessedListener
org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#registerAllRequestsProcessedListener


## ReaderThread

org.apache.flink.runtime.io.disk.iomanager.IOManagerAsync.ReaderThread#run
org.apache.flink.runtime.io.disk.iomanager.BufferReadRequest#read
org.apache.flink.runtime.io.disk.iomanager.BufferReadRequest#requestDone
org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#handleProcessedBuffer
org.apache.flink.runtime.io.disk.iomanager.QueuingCallback#requestSuccessful


org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockReader#AsynchronousBlockReader方法里returnSegments参数用来接收读取的结果。

org.apache.flink.runtime.operators.hash.MutableHashTable#prepareNextPartition
org.apache.flink.runtime.io.disk.ChannelReaderInputViewIterator#ChannelReaderInputViewIterator(org.apache.flink.runtime.io.disk.iomanager.IOManager, org.apache.flink.runtime.io.disk.iomanager.FileIOChannel.ID, java.util.concurrent.LinkedBlockingQueue<org.apache.flink.core.memory.MemorySegment>, java.util.List<org.apache.flink.core.memory.MemorySegment>, java.util.List<org.apache.flink.core.memory.MemorySegment>, org.apache.flink.api.common.typeutils.TypeSerializer<E>, int)
org.apache.flink.runtime.io.disk.iomanager.IOManagerAsync#createBlockChannelReader
org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockReader#AsynchronousBlockReader

## WriterThread

org.apache.flink.runtime.io.disk.iomanager.AsynchronousBufferFileWriter.RecyclingCallback#requestSuccessful
org.apache.flink.runtime.io.network.buffer.Buffer#recycle

## 类解读

### org.apache.flink.runtime.io.disk.iomanager.FileIOChannel

一个Channel代表一个文件集合，这个文件集逻辑上是同一个资源。举例来说，一个文件流分段排序后的各排序段文件，这些段文件后面会合并到一起。

```
获取其FileIOChannel.ID
获取其大小
检查是否已经关闭
关闭
删除
关闭并删除
获取文件通道FileChannel
```

### org.apache.flink.runtime.io.disk.iomanager.FileIOChannel.ID

唯一表示文件Channel，由文件路径File和线程号threadNum构成。

### org.apache.flink.runtime.io.disk.iomanager.AbstractFileIOChannel

抽象基类，实现了FileIOChannel接口的一个方法。

构造时创建RandomAccessFile并获取其FileChannel。

### org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel

继承AbstractFileIOChannel。

接收以块block为单位的读写请求。请求委托异步IO线程执行。IO请求完成后，块block的内存段segment添加到一个集合。

异步访问使得预读（read-ahead）或预写（write-behind）成为可能。

构造时：调用父类AbstractFileIOChannel的构造方法。设置RequestQueue和RequestDoneCallback字段。

#### org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#handleProcessedBuffer方法

一旦I/O请求完成后，异步I/O工作线程调用此方法，参数为处理I/O请求时的buffer或异常IOException。

这个方法需要将requestsNotReturned减去1，如果减到0，则通知等在closeLock锁上的所有等待者，调用listener的onNotification方法。

#### org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#addRequest方法

将requestsNotReturned加1。如果发现通道已经关闭，则将requestsNotReturned减去1，调用listener的onNotification方法；否则将请求加入到RequestQueue里。

#### org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#registerAllRequestsProcessedListener方法

注册一个监听器，在所有请求都被处理了就通知这个监听器。

### org.apache.flink.runtime.io.disk.iomanager.IORequest

IO管理器的IO线程处理的IO请求的基础接口。定义了requestDone方法，I/O处理完请求成后调用此方法。

### org.apache.flink.runtime.io.disk.iomanager.ReadRequest

IO管理器的IO读线程处理的IO请求的接口。定义了read方法，执行实际读操作的I/O线程调用此方法。

### org.apache.flink.runtime.io.disk.iomanager.WriteRequest

IO管理器的IO写线程处理的IO请求的接口。定义了write方法，执行实际写操作的I/O线程调用此方法。

### org.apache.flink.runtime.io.disk.iomanager.RequestQueue

继承了LinkedBlockingQueue，添加了close方法。

### org.apache.flink.runtime.io.disk.iomanager.RequestDoneCallback

异步I/O请求完成后的回调接口。异步I/O请求成功回调requestSuccessful方法，异步I/O请求失败回调requestFailed方法。

### org.apache.flink.runtime.util.event.NotificationListener

通知监听器。

### org.apache.flink.runtime.io.disk.iomanager.SegmentReadRequest

### org.apache.flink.runtime.io.disk.iomanager.SegmentWriteRequest

### org.apache.flink.runtime.io.disk.iomanager.BufferWriteRequest

### org.apache.flink.runtime.io.disk.iomanager.BufferReadRequest

### org.apache.flink.runtime.io.disk.iomanager.FileSegmentReadRequest

### org.apache.flink.runtime.io.disk.iomanager.SeekRequest

### org.apache.flink.runtime.io.disk.iomanager.BlockChannelReader

### org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockReader

### org.apache.flink.runtime.io.disk.iomanager.BlockChannelWriterWithCallback

### org.apache.flink.runtime.io.disk.iomanager.BlockChannelWriter

### org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockWriter

### org.apache.flink.runtime.io.disk.iomanager.BlockChannelWriterWithCallback

### org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockWriterWithCallback

### org.apache.flink.runtime.io.disk.iomanager.BufferFileReader

### org.apache.flink.runtime.io.disk.iomanager.AsynchronousBufferFileReader

### org.apache.flink.runtime.io.disk.iomanager.BufferFileSegmentReader

### org.apache.flink.runtime.io.disk.iomanager.AsynchronousBufferFileSegmentReader

### org.apache.flink.runtime.io.disk.iomanager.BlockChannelWriterWithCallback

### org.apache.flink.runtime.io.disk.iomanager.BufferFileWriter

### org.apache.flink.runtime.io.disk.iomanager.AsynchronousBufferFileWriter

### org.apache.flink.runtime.io.disk.iomanager.BulkBlockChannelReader

### org.apache.flink.runtime.io.disk.iomanager.AsynchronousBulkBlockReader
