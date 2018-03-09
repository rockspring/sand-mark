# MergePolicy

一个合并策略决定了原子合并操作的顺序。

无论什么时候索引中的段被IndexWriter改变了，改变的方式可以是添加一个新刷新的端、调用addIndexes添加很多段、先前合并的需要折叠的段，IndexWriter调用findMerges给MergePolicy一个机会选取需要的合并。org.apache.lucene.index.MergePolicy#findMerges方法返回一个MergeSpecification对象，如果有必要合并，则描述了一组需要完成的合并操作，否则为null。当org.apache.lucene.index.IndexWriter#forceMerge(int)方法被调用了，它会调用org.apache.lucene.index.MergePolicy#findForcedMerges，MergePolicy应当返回必要的合并操作。

MergePolicy能够一次返回多个合并操作。如果使用SerialMergeScheduler，则合并操作依次顺序执行。如果使用ConcurrentMergeScheduler，则合并操作并发地执行。

默认的MergePolicy是TieredMergePolicy。

## 内部类

### 1 org.apache.lucene.index.MergePolicy.OneMergeProgress

合并执行中的进度和状态。封装了暂停、恢复合并线和放弃整个合并的逻辑。

#### 字段

##### org.apache.lucene.index.MergePolicy.OneMergeProgress.PauseReason

暂停原因，有STOPPED、PAUSED、OTHER。STOPPED通常因为吞吐率设置为0，PAUSED是超过吞吐率的临时暂停。

##### org.apache.lucene.index.MergePolicy.OneMergeProgress#pauseTimesNS

是一个EnumMap<PauseReason, AtomicLong>，记录了每一种暂停原因的暂停时间，单位为纳秒。

##### org.apache.lucene.index.MergePolicy.OneMergeProgress#aborted

是否已经被放弃了。

##### org.apache.lucene.index.MergePolicy.OneMergeProgress#owner

仅仅调用org.apache.lucene.index.MergePolicy.OneMerge#mergeInit方法的同一个线程可以调用org.apache.lucene.index.MergePolicy.OneMergeProgress#pauseNanos方法

#### 方法

##### org.apache.lucene.index.MergePolicy.OneMergeProgress#abort()

在下一个可能的时刻放弃本进度条跟踪的合并。设置aborted为true，唤醒任何已经暂停的合并线程。

##### org.apache.lucene.index.MergePolicy.OneMergeProgress#isAborted()

返回这个合并是否已经被放弃了。

##### org.apache.lucene.index.MergePolicy.OneMergeProgress#pauseNanos(long pauseNanos, PauseReason reason, BooleanSupplier condition) throws InterruptedException

如果合并已经被放弃了或者外部条件返回false，改方法直接返回。否则，至少暂停调用线程pauseNanos纳秒。

##### org.apache.lucene.index.MergePolicy.OneMergeProgress#wakeup()

唤醒任何停顿的线程。

##### org.apache.lucene.index.MergePolicy.OneMergeProgress#getPauseTimes()

获取每一种停顿理由及停顿时间。

##### org.apache.lucene.index.MergePolicy.OneMergeProgress#setMergeThread

设定合并线程。

### 2 org.apache.lucene.index.MergePolicy.OneMerge

一次单独的原子合并操作所需要的信息，这次合并操作产生一个新的段。合并规范包括将要合并的段子集，新的段是否使用复合文件。

#### 字段

##### org.apache.lucene.index.MergePolicy.OneMerge#info SegmentCommitInfo

段提交信息

##### org.apache.lucene.index.MergePolicy.OneMerge#registerDone boolean

##### org.apache.lucene.index.MergePolicy.OneMerge#mergeGen long

##### org.apache.lucene.index.MergePolicy.OneMerge#isExternal boolean

##### org.apache.lucene.index.MergePolicy.OneMerge#maxNumSegments int

##### org.apache.lucene.index.MergePolicy.OneMerge#estimatedMergeBytes long

合并的段估计的大小，单位为字节。

##### org.apache.lucene.index.MergePolicy.OneMerge#totalMergeBytes long

所有SegmentCommitInfo的大小之和，单位字节。

##### org.apache.lucene.index.MergePolicy.OneMerge#readers List<SegmentReader>

所有要合并的段的段读取器

##### org.apache.lucene.index.MergePolicy.OneMerge#segments List<SegmentCommitInfo>

所有要合并的段的SegmentCommitInfo

##### org.apache.lucene.index.MergePolicy.OneMerge#mergeProgress OneMergeProgress

合并进度

##### org.apache.lucene.index.MergePolicy.OneMerge#mergeStartNS long

合并开始时间

##### org.apache.lucene.index.MergePolicy.OneMerge#totalMaxDoc int

##### org.apache.lucene.index.MergePolicy.OneMerge#error

#### 方法

##### org.apache.lucene.index.MergePolicy.OneMerge#OneMerge(List<SegmentCommitInfo> segments)

构造函数。接收要合并的段的SegmentCommitInfo信息，统计总的文档数量，赋值到totalMaxDoc字段中。

##### org.apache.lucene.index.MergePolicy.OneMerge#mergeInit()

合并开始后，由将要执行合并的线程通过IndexWriter调用该方法，作用就是设置mergeProgress的拥有者线程为当前线程。

##### org.apache.lucene.index.MergePolicy.OneMerge#mergeFinished()

合并结束后及所有的读取器关闭后通过IndexWriter调用该方法。该方法什么也不做。

##### org.apache.lucene.index.MergePolicy.OneMerge#wrapForMerge(CodecReader reader) throws IOException

包装读取器，为了往合并的段中添加或删除信息。

##### org.apache.lucene.index.MergePolicy.OneMerge#setMergeInfo(SegmentCommitInfo info)

给合并的段设置SegmentCommitInfo。

##### org.apache.lucene.index.MergePolicy.OneMerge#getMergeInfo()

获取合并的段的SegmentCommitInfo。

##### org.apache.lucene.index.MergePolicy.OneMerge#setException(Throwable error)

记录执行合并过程中的异常。

##### org.apache.lucene.index.MergePolicy.OneMerge#getException

获取执行合并过程中的异常。

##### org.apache.lucene.index.MergePolicy.OneMerge#segString()

当前的合并状态的易读的字符串描述。

##### org.apache.lucene.index.MergePolicy.OneMerge#totalBytesSize()

本次合并的输入段的总大小，单位为字节。

##### org.apache.lucene.index.MergePolicy.OneMerge#totalNumDocs()

本次合并的总文档数。

##### org.apache.lucene.index.MergePolicy.OneMerge#getStoreMergeInfo()

获取一个MergeInfo对象，它描述了这次合并。

##### org.apache.lucene.index.MergePolicy.OneMerge#isAborted()

本次合并是否已经或应当被放弃。

##### org.apache.lucene.index.MergePolicy.OneMerge#setAborted()

标记本次合并为放弃。

##### org.apache.lucene.index.MergePolicy.OneMerge#checkAborted() throws MergeAbortedException

检查合并是否被放弃了，如果是，抛出异常。

##### org.apache.lucene.index.MergePolicy.OneMerge#getMergeProgress()

获取合并进度。

### 3 org.apache.lucene.index.MergePolicy.MergeSpecification

提供了执行多个合并所必要的信息，包含的信息就是一个OneMerge列表。

#### 字段

##### org.apache.lucene.index.MergePolicy.MergeSpecification#merges List<OneMerge>

OneMerge列表。

#### 方法

##### org.apache.lucene.index.MergePolicy.MergeSpecification#add(OneMerge merge)

添加一个OneMerge。

##### org.apache.lucene.index.MergePolicy.MergeSpecification#segString(Directory dir)

获取一个易读的字符串描述。

### 4 org.apache.lucene.index.MergePolicy.MergeException

执行合并过程中任何问题将抛出这个异常。

### 5 org.apache.lucene.index.MergePolicy.MergeAbortedException

org.apache.lucene.index.IndexWriter#abortMerges被调用显示放弃合并时抛出这个异常。

## 字段

### org.apache.lucene.index.MergePolicy#DEFAULT_NO_CFS_RATIO double

使用复合文件的比率。如果为1，则总是使用复合文件。

### org.apache.lucene.index.MergePolicy#DEFAULT_MAX_CFS_SEGMENT_SIZE long

为了使用复合文件的默认最大的段大小，默认为Long.MAX_VALUE。

### org.apache.lucene.index.MergePolicy#noCFSRatio double

如果合并段的大小超过了总索引大小的这个比率，任然使用非复合格式，这个比率默认为1.0。

### org.apache.lucene.index.MergePolicy#maxCFSSegmentSize

如果合并段的大小超过了这个值，将不使用复合文件格式，这个值默认为Long.MAX_VALUE。

## 方法

### org.apache.lucene.index.MergePolicy#MergePolicy()

默认构造函数，使用默认的DEFAULT_NO_CFS_RATIO和DEFAULT_MAX_CFS_SEGMENT_SIZE。

### org.apache.lucene.index.MergePolicy#MergePolicy(double defaultNoCFSRatio, long defaultMaxCFSSegmentSize)

构造函数，接收defaultNoCFSRatio和defaultMaxCFSSegmentSize。

### 抽象方法 org.apache.lucene.index.MergePolicy#findMerges(MergeTrigger mergeTrigger, SegmentInfos segmentInfos, IndexWriter writer) throws IOException

判定索引中哪一个合并操作集合现在是必要的。无论什么段有改变，IndexWriter就调用次方法。这个方法总是一次只能一个线程调用，是一个同步方法。mergeTrigger是触发合并的事件。segmentInfos是索引中总的段集合。writer是用来找合并的IndexWriter。

### 抽象方法 org.apache.lucene.index.MergePolicy#findForcedMerges(SegmentInfos segmentInfos, int maxSegmentCount, Map<SegmentCommitInfo,Boolean> segmentsToMerge, IndexWriter writer) throws IOException

判定为了合并到指定段数量哪些合并操作集合是必要的。当IndexWriter的forceMerge方法被调用后，IndexWriter调用次方法。这个方法总是一次只能一个线程调用，是一个同步方法。

segmentInfos是索引中总的段集合。

maxSegmentCount最终生成的段数量。

segmentsToMerge包含指定的端，必须被合并。如果对应段的值为true，这意味着这个段是一个原始段，否则，这是一个折叠的段。

writer是用来找合并的IndexWriter。

### 抽象方法 org.apache.lucene.index.MergePolicy#findForcedDeletesMerges(SegmentInfos segmentInfos, IndexWriter writer) throws IOException

为了从索引中消除所有删除判定出哪些合并操作集合是必要的。

segmentInfos是索引中总的段集合。

writer是用来找合并的IndexWriter。

### org.apache.lucene.index.MergePolicy#useCompoundFile(SegmentInfos infos, SegmentCommitInfo mergedInfo, IndexWriter writer) throws IOException

判定是否使用复合文件。

如果mergedInfo的大小小于或等于getMaxCFSSegmentSizeMB()并且小于或等于TotalIndexSize\*getNoCFSRatio()，返回true；否则，返回false。

### org.apache.lucene.index.MergePolicy#size(SegmentCommitInfo info, IndexWriter writer) throws IOException

返回提供的info的字节大小，扣除删除的部分。

### org.apache.lucene.index.MergePolicy#isMerged(SegmentInfos infos, SegmentCommitInfo info, IndexWriter writer) throws IOException

如果info已经全部被合并了，没有悬挂的删除，与writer在同一个目录，匹配当前的复合文件设定，返回true。

// 满足条件的段数量不是1

// 符合条件的最后一个段不是原始段

// 最后一个段已经被合并了