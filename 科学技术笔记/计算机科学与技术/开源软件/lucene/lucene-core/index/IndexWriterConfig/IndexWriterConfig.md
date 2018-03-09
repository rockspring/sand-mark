# IndexWriterConfig

IndexWriterConfig继承LiveIndexWriterConfig。

IndexWriter创建之后，配置不能再修改。

## 静态字段

###  public static final int org.apache.lucene.index.IndexWriterConfig.DISABLE_AUTO_FLUSH

值等于-1。刷新触发器被禁用。

###  public static final int org.apache.lucene.index.IndexWriterConfig.DEFAULT_MAX_BUFFERED_DELETE_TERMS

值等于DISABLE_AUTO_FLUSH。通过删除Term数量触发的刷新触发器被禁用。

###  public static final int org.apache.lucene.index.IndexWriterConfig.DEFAULT_MAX_BUFFERED_DOCS

值等于DISABLE_AUTO_FLUSH。通过添加文档数量触发的刷新触发器被禁用。

###  public static final double org.apache.lucene.index.IndexWriterConfig.DEFAULT_RAM_BUFFER_SIZE_MB

值等于16M。缓冲的文档消耗的内存超过该值时触发刷新。

###  public static final boolean org.apache.lucene.index.IndexWriterConfig.DEFAULT_READER_POOLING

值等于true。

并发删除、更新文档时设置org.apache.lucene.index.LiveIndexWriterConfig#readerPooling为该默认值。不然我们需要频繁地打开和关闭readers。

###  public static final int org.apache.lucene.index.IndexWriterConfig.DEFAULT_RAM_PER_THREAD_HARD_LIMIT_MB

值为1945。这是每个索引线程消耗内存的硬限制，单位为MB。

###  public static final boolean org.apache.lucene.index.IndexWriterConfig.DEFAULT_USE_COMPOUND_FILE_SYSTEM

值为true。这是表示使用复合文件系统。使用大的内存缓冲区批量构建索引时设置为false，不使用复合文件系统。

###  public static final boolean org.apache.lucene.index.IndexWriterConfig.DEFAULT_COMMIT_ON_CLOSE

值为true。这是表示调用close方法时包含一个commit。

###  private static final java.util.EnumSet org.apache.lucene.index.IndexWriterConfig.ALLOWED_INDEX_SORT_TYPES

仅仅允许如下类型使用index_sort

```
SortField.Type.STRING,
SortField.Type.LONG,
SortField.Type.INT,
SortField.Type.DOUBLE,
SortField.Type.FLOAT
```

## 实例字段

org.apache.lucene.index.IndexWriterConfig#writer

## 方法

```
IndexWriterConfig setIndexWriter(IndexWriter writer)

public IndexWriterConfig setOpenMode(OpenMode openMode)
public IndexWriterConfig setIndexDeletionPolicy(IndexDeletionPolicy delPolicy)
public IndexWriterConfig setIndexCommit(IndexCommit commit)
public IndexWriterConfig setSimilarity(Similarity similarity)
public IndexWriterConfig setMergeScheduler(MergeScheduler mergeScheduler)
public IndexWriterConfig setCodec(Codec codec)
IndexWriterConfig setIndexerThreadPool(DocumentsWriterPerThreadPool threadPool)
public IndexWriterConfig setReaderPooling(boolean readerPooling)
IndexWriterConfig setFlushPolicy(FlushPolicy flushPolicy)
public IndexWriterConfig setRAMPerThreadHardLimitMB(int perThreadHardLimitMB)
public IndexWriterConfig setInfoStream(InfoStream infoStream)
public IndexWriterConfig setInfoStream(PrintStream printStream)
public IndexWriterConfig setMergePolicy(MergePolicy mergePolicy)
public IndexWriterConfig setMaxBufferedDocs(int maxBufferedDocs)
public IndexWriterConfig setMergedSegmentWarmer(IndexReaderWarmer mergeSegmentWarmer)
public IndexWriterConfig setRAMBufferSizeMB(double ramBufferSizeMB)
public IndexWriterConfig setUseCompoundFile(boolean useCompoundFile)
public IndexWriterConfig setCommitOnClose(boolean commitOnClose)
public IndexWriterConfig setIndexSort(Sort sort)
```

### org.apache.lucene.index.IndexWriterConfig#setIndexWriter

关联IndexWriter和IndexWriterConfig。一个IndexWriterConfig只能被一个IndexWriter使用。

