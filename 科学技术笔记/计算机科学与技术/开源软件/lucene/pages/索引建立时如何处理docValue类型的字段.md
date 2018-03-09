# 索引建立时如何处理docValue类型的字段

索引处理阶段

```
#org/apache/lucene/index/DefaultIndexingChain.java
private int processField(IndexableField field, long fieldGen, int fieldCount) throws IOException, AbortingException;

```

## 计算字节的hash值
```
java.lang.Thread.State: RUNNABLE
      at org.apache.lucene.util.BytesRefHash.add(BytesRefHash.java:252)
      at org.apache.lucene.index.SortedDocValuesWriter.addOneValue(SortedDocValuesWriter.java:86)
      at org.apache.lucene.index.SortedDocValuesWriter.addValue(SortedDocValuesWriter.java:74)
      at org.apache.lucene.index.DefaultIndexingChain.indexDocValue(DefaultIndexingChain.java:533)
      at org.apache.lucene.index.DefaultIndexingChain.processField(DefaultIndexingChain.java:449)
      at org.apache.lucene.index.DefaultIndexingChain.processDocument(DefaultIndexingChain.java:373)
      at org.apache.lucene.index.DocumentsWriterPerThread.updateDocument(DocumentsWriterPerThread.java:231)
      at org.apache.lucene.index.DocumentsWriter.updateDocument(DocumentsWriter.java:478)
      at org.apache.lucene.index.IndexWriter.updateDocument(IndexWriter.java:1562)
      at org.apache.lucene.index.IndexWriter.addDocument(IndexWriter.java:1307)
      at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:185)
      at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:225)
```

## 暂存字节的hash值

```
java.lang.Thread.State: RUNNABLE
      at org.apache.lucene.util.packed.PackedLongValues$Builder.add(PackedLongValues.java:218)
      at org.apache.lucene.index.SortedDocValuesWriter.addOneValue(SortedDocValuesWriter.java:97)
      at org.apache.lucene.index.SortedDocValuesWriter.addValue(SortedDocValuesWriter.java:74)
      at org.apache.lucene.index.DefaultIndexingChain.indexDocValue(DefaultIndexingChain.java:533)
      at org.apache.lucene.index.DefaultIndexingChain.processField(DefaultIndexingChain.java:449)
      at org.apache.lucene.index.DefaultIndexingChain.processDocument(DefaultIndexingChain.java:373)
      at org.apache.lucene.index.DocumentsWriterPerThread.updateDocument(DocumentsWriterPerThread.java:231)
      at org.apache.lucene.index.DocumentsWriter.updateDocument(DocumentsWriter.java:478)
      at org.apache.lucene.index.IndexWriter.updateDocument(IndexWriter.java:1562)
      at org.apache.lucene.index.IndexWriter.addDocument(IndexWriter.java:1307)
      at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:185)
      at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:225)
```

# 索引刷新阶段

## 创建docvalues的写入器

```
java.lang.Thread.State: RUNNABLE
      at org.apache.lucene.codecs.perfield.PerFieldDocValuesFormat$FieldsWriter.<init>(PerFieldDocValuesFormat.java:104)
      at org.apache.lucene.codecs.perfield.PerFieldDocValuesFormat.fieldsConsumer(PerFieldDocValuesFormat.java:83)
      at org.apache.lucene.index.DefaultIndexingChain.writeDocValues(DefaultIndexingChain.java:211)
      at org.apache.lucene.index.DefaultIndexingChain.flush(DefaultIndexingChain.java:101)
      at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:443)
      at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:539)
      at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:653)
      at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3364)
      - locked <0x52c> (a java.lang.Object)
      at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3333)
      at org.apache.lucene.index.IndexWriter.shutdown(IndexWriter.java:1117)
      at org.apache.lucene.index.IndexWriter.close(IndexWriter.java:1162)
      at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:194)
      at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:225)
```

## 刷新内容到文件

## 刷新term值到文件

```
java.lang.Thread.State: RUNNABLE
      at org.apache.lucene.store.DataOutput.writeVInt(DataOutput.java:187)
      at org.apache.lucene.codecs.lucene54.Lucene54DocValuesConsumer.addBinaryField(Lucene54DocValuesConsumer.java:356)
      at org.apache.lucene.codecs.lucene54.Lucene54DocValuesConsumer.addTermsDict(Lucene54DocValuesConsumer.java:440)
      at org.apache.lucene.codecs.lucene54.Lucene54DocValuesConsumer.addSortedField(Lucene54DocValuesConsumer.java:578)
      at org.apache.lucene.codecs.perfield.PerFieldDocValuesFormat$FieldsWriter.addSortedField(PerFieldDocValuesFormat.java:119)
      at org.apache.lucene.index.SortedDocValuesWriter.flush(SortedDocValuesWriter.java:122)
      at org.apache.lucene.index.DefaultIndexingChain.writeDocValues(DefaultIndexingChain.java:215)
      at org.apache.lucene.index.DefaultIndexingChain.flush(DefaultIndexingChain.java:101)
      at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:443)
      at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:539)
      at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:653)
      at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3364)
      - locked <0x4df> (a java.lang.Object)
      at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3333)
      at org.apache.lucene.index.IndexWriter.shutdown(IndexWriter.java:1117)
      at org.apache.lucene.index.IndexWriter.close(IndexWriter.java:1162)
      at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:194)
      at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:225)
```

刷新hash值到文件

```
java.lang.Thread.State: RUNNABLE
      at org.apache.lucene.store.DataOutput.writeVInt(DataOutput.java:187)
      at org.apache.lucene.codecs.lucene54.Lucene54DocValuesConsumer.addNumericField(Lucene54DocValuesConsumer.java:191)
      at org.apache.lucene.codecs.lucene54.Lucene54DocValuesConsumer.addSortedField(Lucene54DocValuesConsumer.java:579)
      at org.apache.lucene.codecs.perfield.PerFieldDocValuesFormat$FieldsWriter.addSortedField(PerFieldDocValuesFormat.java:119)
      at org.apache.lucene.index.SortedDocValuesWriter.flush(SortedDocValuesWriter.java:122)
      at org.apache.lucene.index.DefaultIndexingChain.writeDocValues(DefaultIndexingChain.java:215)
      at org.apache.lucene.index.DefaultIndexingChain.flush(DefaultIndexingChain.java:101)
      at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:443)
      at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:539)
      at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:653)
      at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3364)
      - locked <0x52c> (a java.lang.Object)
      at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3333)
      at org.apache.lucene.index.IndexWriter.shutdown(IndexWriter.java:1117)
      at org.apache.lucene.index.IndexWriter.close(IndexWriter.java:1162)
      at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:194)
      at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:225)
```