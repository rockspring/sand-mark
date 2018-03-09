## 代码调用链

### org.apache.lucene.index.FlushByRamOrCountsPolicy#onInsert

```
at org.apache.lucene.index.FlushByRamOrCountsPolicy.onInsert(FlushByRamOrCountsPolicy.java:72)
at org.apache.lucene.index.DocumentsWriterFlushControl.doAfterDocument(DocumentsWriterFlushControl.java:177)
- locked <0x6d6> (a org.apache.lucene.index.DocumentsWriterFlushControl)
at org.apache.lucene.index.DocumentsWriter.updateDocument(DocumentsWriter.java:508)
at org.apache.lucene.index.IndexWriter.updateDocument(IndexWriter.java:1729)
at org.apache.lucene.index.IndexWriter.addDocument(IndexWriter.java:1464)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:52)
```

