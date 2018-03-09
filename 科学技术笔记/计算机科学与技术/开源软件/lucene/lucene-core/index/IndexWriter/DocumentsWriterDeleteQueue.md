# DocumentsWriterDeleteQueue

DocumentsWriterDeleteQueue是一个非阻塞链表形式队列，队列元素为待删除的数据。与其他队列实现方式对比，我们仅仅维护队列的尾部。一个待删除数据队列在一组DWPT和一个全局删除数据池子的背景中被使用。每一个DWPT和全局删除数据池子需要维护它们自己的队列头部（作为每个DocumentsWriterPerThread的一个DeleteSlice实例）。

DWPT，它一旦添加了首个文档就开始维护一个队列头部，因为针对索引段自己的删除，仅仅那个文档之后的删除是相关的。全局池子不一样，它一旦被创建出来并且采取哨兵实例作为它的初始化头部之后，它就开始维护它的头部。因为每一个DeleteSlice维护它自己的头部并且队列仅仅是单向链表，内存垃圾收集器负责为我们修剪列表。链表中仍然相关的所有节点应当直接地或间接地被DWPT的私有DeleteSlice或全局BufferedUpdates切片引用。

每一个DWPT和全局删除池子都维护它们私有的DeleteSlice。在DWPT这种情况下，更新一个切片等价于原子性结束文档处理。切片更新保证了“在某某之前发生”这种关系，也就是在同一个索引构建会话过程中的其他更新之前发生。当一个DWPT更新一个文档时，经历如下过程：

1，消费一个文档并且结束它的处理。

2，通过调用updateSlice(DeleteSlice)或add(Term, DeleteSlice)（如果文档有一个删除项delTerm）方法更新它自己的DeleteSlice。

3，在它自己的BufferedUpdates中实施切片中的所有删除，然后重置切片为零。

4，增加它的内部文档id。

为了确保更新的一致性，直到它已经更新了它的删除切片，DWPT才会实施它当前的文档删除delTerm。如果在DeleteSlice被成功更新之前更新失败了，deleteTerm既不会被添加到它私自的删除队列也不会被添加到全局删除队列。

## 关联的类

```
org.apache.lucene.index.Term
org.apache.lucene.index.BufferedUpdates
org.apache.lucene.search.Query
org.apache.lucene.index.DocValuesUpdate
org.apache.lucene.index.DocValuesUpdate.NumericDocValuesUpdate
org.apache.lucene.index.DocValuesUpdate.BinaryDocValuesUpdate
```

### 在哪里调用改类的方法？

org.apache.lucene.index.DocumentsWriter#deleteQueries
org.apache.lucene.index.DocumentsWriter#deleteTerms
org.apache.lucene.index.DocumentsWriter#updateDocValues

往上层调用方法追溯一层

org.apache.lucene.index.IndexWriter#deleteDocuments(org.apache.lucene.search.Query...)
org.apache.lucene.index.IndexWriter#deleteDocuments(org.apache.lucene.index.Term...)
org.apache.lucene.index.IndexWriter#updateDocValues
org.apache.lucene.index.IndexWriter#updateNumericDocValue
org.apache.lucene.index.IndexWriter#updateBinaryDocValue


更新一个文档
org.apache.lucene.index.DocumentsWriterPerThread#finishDocument方法里调用org.apache.lucene.index.DocumentsWriterDeleteQueue#add(org.apache.lucene.index.Term, org.apache.lucene.index.DocumentsWriterDeleteQueue.DeleteSlice)


## 一、内部类

### 1 org.apache.lucene.index.DocumentsWriterDeleteQueue.Node

数据结构如下

```
volatile Node<?> next;
final T item;
```

### 2 org.apache.lucene.index.DocumentsWriterDeleteQueue.TermNode

继承org.apache.lucene.index.DocumentsWriterDeleteQueue.Node，item类型为Term。

org.apache.lucene.index.DocumentsWriterDeleteQueue.TermNode#apply方法调用org.apache.lucene.index.BufferedUpdates#addTerm。

### 3 org.apache.lucene.index.DocumentsWriterDeleteQueue.QueryArrayNode

继承org.apache.lucene.index.DocumentsWriterDeleteQueue.Node，item类型为Query[]。

org.apache.lucene.index.DocumentsWriterDeleteQueue.QueryArrayNode#apply方法针对每一个Query调用org.apache.lucene.index.BufferedUpdates#addQuery。

### 4 org.apache.lucene.index.DocumentsWriterDeleteQueue.TermArrayNode

继承org.apache.lucene.index.DocumentsWriterDeleteQueue.Node，item类型为Term[]。

org.apache.lucene.index.DocumentsWriterDeleteQueue.TermArrayNode#apply方法针对每一个Term调用org.apache.lucene.index.BufferedUpdates#addTerm。

### 5 org.apache.lucene.index.DocumentsWriterDeleteQueue.DocValuesUpdatesNode

继承org.apache.lucene.index.DocumentsWriterDeleteQueue.Node，item类型为DocValuesUpdate[]。

DocValuesUpdate分为NumericDocValuesUpdate和BinaryDocValuesUpdate，分别调用org.apache.lucene.index.BufferedUpdates#addNumericUpdate和org.apache.lucene.index.BufferedUpdates#addBinaryUpdate。


### 6 org.apache.lucene.index.DocumentsWriterDeleteQueue.DeleteSlice

持有一个Node链表的头部和尾部，链表上除了sliceHead节点，其它节点都是要实时删除操作的节点。

数据结构

```
Node<?> sliceHead; // we don't apply this one
Node<?> sliceTail;
```

sliceHead是不实施操作的节点。

org.apache.lucene.index.DocumentsWriterDeleteQueue.DeleteSlice#apply方法从sliceHead开始往后遍历节点，除了sliceHead自身，依次对其它节点实施操作。

## 二、字段

### 1 org.apache.lucene.index.DocumentsWriterDeleteQueue#tail

### 2 org.apache.lucene.index.DocumentsWriterDeleteQueue#globalSlice DeleteSlice

### 3 org.apache.lucene.index.DocumentsWriterDeleteQueue#globalBufferedUpdates BufferedUpdates

### 4 org.apache.lucene.index.DocumentsWriterDeleteQueue#globalBufferLock ReentrantLock

防止多线程并发地修改globalSlice和globalBufferedUpdates的锁。

### 5 org.apache.lucene.index.DocumentsWriterDeleteQueue#generation long

### 6 org.apache.lucene.index.DocumentsWriterDeleteQueue#nextSeqNo AtomicLong

### 7 org.apache.lucene.index.DocumentsWriterDeleteQueue#infoStream InfoStream

### 8 org.apache.lucene.index.DocumentsWriterDeleteQueue#maxSeqNo long

## 三、构造函数

### 1 org.apache.lucene.index.DocumentsWriterDeleteQueue#DocumentsWriterDeleteQueue(org.apache.lucene.util.InfoStream)

设置generation=0；nextSeqNo=1。

### 2 org.apache.lucene.index.DocumentsWriterDeleteQueue#DocumentsWriterDeleteQueue(org.apache.lucene.util.InfoStream, long, long)

创建globalBufferedUpdates，segmentName=“global”。

### 3 org.apache.lucene.index.DocumentsWriterDeleteQueue#DocumentsWriterDeleteQueue(org.apache.lucene.util.InfoStream, org.apache.lucene.index.BufferedUpdates, long, long)

创建sentinel节点。

## 四、方法

### 1 org.apache.lucene.index.DocumentsWriterDeleteQueue#addDelete(org.apache.lucene.search.Query...) -> long

创建QueryArrayNode节点，加入链表。尝试实施全局切片中的删除操作。操作序列号加1。

### 2 org.apache.lucene.index.DocumentsWriterDeleteQueue#addDelete(org.apache.lucene.index.Term...) -> long

创建TermArrayNode节点，加入链表。尝试实施全局切片中的删除操作。操作序列号加1。

### 3 org.apache.lucene.index.DocumentsWriterDeleteQueue#addDocValuesUpdates(DocValuesUpdate... updates) -> long

创建DocValuesUpdatesNode节点，加入链表。尝试实施全局切片中的删除操作。操作序列号加1。

### 4 org.apache.lucene.index.DocumentsWriterDeleteQueue#add(org.apache.lucene.index.Term, org.apache.lucene.index.DocumentsWriterDeleteQueue.DeleteSlice) -> long

创建TermNode节点，加入链表。移动slice的sliceTail指向新加的节点。尝试实施全局切片中的删除操作。

### 5 org.apache.lucene.index.DocumentsWriterDeleteQueue#add(org.apache.lucene.index.DocumentsWriterDeleteQueue.Node<?>) -> long

将节点加入到链表尾部，获取下一个序列号。

### 6 org.apache.lucene.index.DocumentsWriterDeleteQueue#anyChanges() -> boolean

### 7 org.apache.lucene.index.DocumentsWriterDeleteQueue#tryApplyGlobalSlice() -> void

### 8 org.apache.lucene.index.DocumentsWriterDeleteQueue#freezeGlobalBuffer(DeleteSlice callerSlice) -> FrozenBufferedUpdates

### 9 org.apache.lucene.index.DocumentsWriterDeleteQueue#newSlice() -> DeleteSlice

创建新的DeleteSlice实例。

### 10 org.apache.lucene.index.DocumentsWriterDeleteQueue#updateSlice(DeleteSlice slice) -> long

获取下一个序列号。将slice的sliceTail指向org.apache.lucene.index.DocumentsWriterDeleteQueue#tail。这表示新的删除来临了。

返回负的序列号，表示自从上次实施了删除操作后新的删除来临了。

### 11 org.apache.lucene.index.DocumentsWriterDeleteQueue#updateSliceNoSeqNo(DeleteSlice slice) -> boolean

跟updateSlice很像，但是不给seqNo赋值。

### 12 org.apache.lucene.index.DocumentsWriterDeleteQueue#numGlobalTermDeletes() -> int

org.apache.lucene.index.BufferedUpdates#numTermDeletes是AtomicInteger，无需上锁。

### 13 org.apache.lucene.index.DocumentsWriterDeleteQueue#clear() -> void

上锁防止其他线程执行该方法。

清空globalSlice和globalBufferedUpdates。

### 14 org.apache.lucene.index.DocumentsWriterDeleteQueue#forceApplyGlobalSlice() -> boolean

上锁防止其他线程执行该方法。

强制实施全局切片中的删除操作。

### 15 org.apache.lucene.index.DocumentsWriterDeleteQueue#getBufferedUpdatesTermsSize() -> int

上锁防止其他线程执行该方法。调用org.apache.lucene.index.DocumentsWriterDeleteQueue#forceApplyGlobalSlice()方法。

返回globalBufferedUpdates.deleteTerms.size()。

### 16 org.apache.lucene.index.DocumentsWriterDeleteQueue#ramBytesUsed() -> long

globalBufferedUpdates的内存使用量。

### 17 org.apache.lucene.index.DocumentsWriterDeleteQueue#toString() -> String

DocumentsWriterDeleteQueue字符串表示。

### 18 org.apache.lucene.index.DocumentsWriterDeleteQueue#getNextSequenceNumber() -> long

获取下一个序列号。

### 19 org.apache.lucene.index.DocumentsWriterDeleteQueue#getLastSequenceNumber() -> long

获取上一个序列号。

### 20 org.apache.lucene.index.DocumentsWriterDeleteQueue#skipSequenceNumbers(long jump) -> void

在序列号maxSeqNo数字之间插入一个间隙。IW在flush或commit的时候使用它去确保任何进行中的线程在间隙中得到一个序列号。

