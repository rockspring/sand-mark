# LiveIndexWriterConfig

IndexWriter活跃期间，有一些配置可以修改。

## 实例字段

```
private final org.apache.lucene.analysis.Analyzer org.apache.lucene.index.LiveIndexWriterConfig.analyzer
private volatile int org.apache.lucene.index.LiveIndexWriterConfig.maxBufferedDocs
private volatile double org.apache.lucene.index.LiveIndexWriterConfig.ramBufferSizeMB
private volatile org.apache.lucene.index.IndexWriter$IndexReaderWarmer org.apache.lucene.index.LiveIndexWriterConfig.mergedSegmentWarmer
protected volatile org.apache.lucene.index.IndexDeletionPolicy org.apache.lucene.index.LiveIndexWriterConfig.delPolicy
protected volatile org.apache.lucene.index.IndexCommit org.apache.lucene.index.LiveIndexWriterConfig.commit
protected volatile org.apache.lucene.index.IndexWriterConfig$OpenMode org.apache.lucene.index.LiveIndexWriterConfig.openMode
protected volatile org.apache.lucene.search.similarities.Similarity org.apache.lucene.index.LiveIndexWriterConfig.similarity
protected volatile org.apache.lucene.index.MergeScheduler org.apache.lucene.index.LiveIndexWriterConfig.mergeScheduler
protected volatile org.apache.lucene.index.DocumentsWriterPerThread$IndexingChain org.apache.lucene.index.LiveIndexWriterConfig.indexingChain
protected volatile org.apache.lucene.codecs.Codec org.apache.lucene.index.LiveIndexWriterConfig.codec
protected volatile org.apache.lucene.util.InfoStream org.apache.lucene.index.LiveIndexWriterConfig.infoStream
protected volatile org.apache.lucene.index.MergePolicy org.apache.lucene.index.LiveIndexWriterConfig.mergePolicy
protected volatile org.apache.lucene.index.DocumentsWriterPerThreadPool org.apache.lucene.index.LiveIndexWriterConfig.indexerThreadPool
protected volatile boolean org.apache.lucene.index.LiveIndexWriterConfig.readerPooling
protected volatile org.apache.lucene.index.FlushPolicy org.apache.lucene.index.LiveIndexWriterConfig.flushPolicy
protected volatile int org.apache.lucene.index.LiveIndexWriterConfig.perThreadHardLimitMB
protected volatile boolean org.apache.lucene.index.LiveIndexWriterConfig.useCompoundFile
protected boolean org.apache.lucene.index.LiveIndexWriterConfig.commitOnClose
protected org.apache.lucene.search.Sort org.apache.lucene.index.LiveIndexWriterConfig.indexSort
protected java.util.Set org.apache.lucene.index.LiveIndexWriterConfig.indexSortFields
```

###  private final org.apache.lucene.analysis.Analyzer org.apache.lucene.index.LiveIndexWriterConfig.analyzer

建索引时使用的分词器。构造函数中传入，构造之后不能修改。

###  private volatile int org.apache.lucene.index.LiveIndexWriterConfig.maxBufferedDocs

缓冲在内存中的文档刷新到一个新的索引段之前，缓冲的最大文档数量。当这个配置被设置了，IndexWriter每到maxBufferedDocs个文档时刷新一次。设置为IndexWriterConfig#DISABLE_AUTO_FLUSH等价于禁止这种触发刷新的功能。如果同时启用内存使用量作为刷新阈值，这种条件哪个先达到哪个去触发刷新。

###  private volatile double org.apache.lucene.index.LiveIndexWriterConfig.ramBufferSizeMB

缓冲在内存中的文档刷新到一个新的索引段之前，缓冲的最大内存数量。通常来说，为了更快地构建索引，最好设置通过内存使用量触发刷新而不是文档数量，并且尽可能使用一个大的内存缓冲区。当这个配置被设置了，只要添加的文档和删除操作使用了这个量的内存时，就触发刷新。IndexWriter的索引过程中会使用比配置的内存限制更多的内存，因为内存限制仅仅是一个指示何时刷新缓冲区的文档到磁盘的指示器。刷新可能和其它线程并发地执行。我了应用的稳定性，JVM可用的内存大小应当大于缓冲区的内存大小。

注意：待删除操作占用的内存数量是近似的。特别地注意，如果通过Query删除，Lucene目前没有任何方式测量其内存使用量，所以可能会估计过小，你应当通过定期调用commit或refresh补偿。

###  private volatile org.apache.lucene.index.IndexWriter$IndexReaderWarmer org.apache.lucene.index.LiveIndexWriterConfig.mergedSegmentWarmer

IndexReaderWarmer在合并提交之前预热新合并的索引段的reader。

###  protected volatile org.apache.lucene.index.IndexDeletionPolicy org.apache.lucene.index.LiveIndexWriterConfig.delPolicy

IndexDeletionPolicy控制什么时候删除提交点。

###  protected volatile org.apache.lucene.index.IndexCommit org.apache.lucene.index.LiveIndexWriterConfig.commit

IndexWriter打开时基于一个IndexCommit。

###  protected volatile org.apache.lucene.index.IndexWriterConfig$OpenMode org.apache.lucene.index.LiveIndexWriterConfig.openMode

IndexWriter打开的模式。

###  protected volatile org.apache.lucene.search.similarities.Similarity org.apache.lucene.index.LiveIndexWriterConfig.similarity

编码norms时使用的Similarity。

###  protected volatile org.apache.lucene.index.MergeScheduler org.apache.lucene.index.LiveIndexWriterConfig.mergeScheduler

MergeScheduler用于执行合并。

###  protected volatile org.apache.lucene.index.DocumentsWriterPerThread$IndexingChain org.apache.lucene.index.LiveIndexWriterConfig.indexingChain

IndexingChain确定文档处理的方式。

###  protected volatile org.apache.lucene.codecs.Codec org.apache.lucene.index.LiveIndexWriterConfig.codec

Codec确定写入新的索引段的格式。

###  protected volatile org.apache.lucene.util.InfoStream org.apache.lucene.index.LiveIndexWriterConfig.infoStream

用于打印调试信息。

###  protected volatile org.apache.lucene.index.MergePolicy org.apache.lucene.index.LiveIndexWriterConfig.mergePolicy

只要索引中的索引段有改变，MergePolicy就会被调用。他的任务是选择哪些段合并，并且返回一个MergePolicy.MergeSpecification描述合并。改方法设置的MergePolicy在接下来的端选择中起作用。任何在进行中的或者被之前的MergePolicy注册的合并不受影响。

###  protected volatile org.apache.lucene.index.DocumentsWriterPerThreadPool org.apache.lucene.index.LiveIndexWriterConfig.indexerThreadPool

DocumentsWriterPerThreadPool控制线程如何被分配给DocumentsWriterPerThread。

###  protected volatile boolean org.apache.lucene.index.LiveIndexWriterConfig.readerPooling

reader是否被池化。

###  protected volatile org.apache.lucene.index.FlushPolicy org.apache.lucene.index.LiveIndexWriterConfig.flushPolicy

FlushPolicy控制什么时候刷新索引段。

###  protected volatile int org.apache.lucene.index.LiveIndexWriterConfig.perThreadHardLimitMB

单个索引段内存使用的硬上限，内存使用量超过这个上限后索引段被强制刷新。

###  protected volatile boolean org.apache.lucene.index.LiveIndexWriterConfig.useCompoundFile

是否使用复合文件格式。

###  protected boolean org.apache.lucene.index.LiveIndexWriterConfig.commitOnClose

是否在close之前先调用一下commit。

###  protected org.apache.lucene.search.Sort org.apache.lucene.index.LiveIndexWriterConfig.indexSort

写入合并的索引段时使用的排序。

###  protected java.util.Set org.apache.lucene.index.LiveIndexWriterConfig.indexSortFields

indexSort涉及的字段名。

## 实例方法

```
public synchronized LiveIndexWriterConfig setRAMBufferSizeMB(double ramBufferSizeMB)
public synchronized LiveIndexWriterConfig setMaxBufferedDocs(int maxBufferedDocs)
public LiveIndexWriterConfig setMergePolicy(MergePolicy mergePolicy)
public LiveIndexWriterConfig setMergedSegmentWarmer(IndexReaderWarmer mergeSegmentWarmer)
public LiveIndexWriterConfig setUseCompoundFile(boolean useCompoundFile)
```
