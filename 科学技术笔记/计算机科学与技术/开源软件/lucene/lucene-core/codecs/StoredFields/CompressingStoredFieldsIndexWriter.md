CompressingStoredFieldsIndexWriter

文件名称

MockIndexOutputWrapper(RAMOutputStream(name="\_0.fdx"))

文件内容

模式org.apache.lucene.codecs.lucene50.Lucene50StoredFieldsFormat.Mode#BEST_SPEED，formatName为Lucene50StoredFieldsFast。

模式org.apache.lucene.codecs.lucene50.Lucene50StoredFieldsFormat.Mode#BEST_COMPRESSION，formatName为Lucene50StoredFieldsHigh。

org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#CODEC_SFX_IDX为Index，codecNameIdx为Lucene50StoredFieldsHighIndex。

org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#CODEC_SFX_DAT为Data，codecNameDat为Lucene50StoredFieldsHighData。


Magic来自org.apache.lucene.codecs.CodecUtil#CODEC_MAGIC的取值。

CodecName为codecNameIdx变量的取值。

Version来自org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#VERSION_CURRENT的取值。

ObjectID来自org.apache.lucene.index.SegmentInfo#getId()方法。

ObjectSuffix来自org.apache.lucene.codecs.compressing.CompressingStoredFieldsFormat#segmentSuffix字段的取值。

## 二 方法

### 1 org.apache.lucene.codecs.compressing.CompressingStoredFieldsIndexWriter#writeIndex(int numDocs, long startPointer) --> void

一个block对应多个chunk，一个chunk对应多个doc。

org.apache.lucene.codecs.compressing.CompressingStoredFieldsIndexWriter#docBaseDeltas记录每个chunk对应的doc数量。

org.apache.lucene.codecs.compressing.CompressingStoredFieldsIndexWriter#startPointerDeltas记录每个chunk对应的doc的字段存储的空间的起始位置减去上一个chunk对应的doc的字段存储的空间的起始位置，即两者之间的差值。

org.apache.lucene.codecs.compressing.CompressingStoredFieldsIndexWriter#blockChunks自增1。

org.apache.lucene.codecs.compressing.CompressingStoredFieldsIndexWriter#blockDocs自增numDocs。

org.apache.lucene.codecs.compressing.CompressingStoredFieldsIndexWriter#totalDocs自增numDocs。

通过blockChunks == blockSize条件判定是否需要写入一个块block。如果需要，调用org.apache.lucene.codecs.compressing.CompressingStoredFieldsIndexWriter#writeBlock()方法。

### 2 org.apache.lucene.codecs.compressing.CompressingStoredFieldsIndexWriter#writeBlock() --> void


## 实例构造代码调用链路

```
at org.apache.lucene.codecs.compressing.CompressingStoredFieldsIndexWriter.<init>(CompressingStoredFieldsIndexWriter.java:86)
at org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter.<init>(CompressingStoredFieldsWriter.java:126)
at org.apache.lucene.codecs.compressing.CompressingStoredFieldsFormat.fieldsWriter(CompressingStoredFieldsFormat.java:128)
at org.apache.lucene.codecs.lucene50.Lucene50StoredFieldsFormat.fieldsWriter(Lucene50StoredFieldsFormat.java:183)
at org.apache.lucene.index.StoredFieldsConsumer.initStoredFieldsWriter(StoredFieldsConsumer.java:39)
at org.apache.lucene.index.StoredFieldsConsumer.startDocument(StoredFieldsConsumer.java:46)
at org.apache.lucene.index.DefaultIndexingChain.startStoredFields(DefaultIndexingChain.java:353)
at org.apache.lucene.index.DefaultIndexingChain.processDocument(DefaultIndexingChain.java:387)
at org.apache.lucene.index.DocumentsWriterPerThread.updateDocument(DocumentsWriterPerThread.java:240)
at org.apache.lucene.index.DocumentsWriter.updateDocument(DocumentsWriter.java:496)
at org.apache.lucene.index.IndexWriter.updateDocument(IndexWriter.java:1729)
at org.apache.lucene.index.IndexWriter.addDocument(IndexWriter.java:1464)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:56) 
```