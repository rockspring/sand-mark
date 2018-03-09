# SegmentInfos

## 涉及的类

```
SegmentInfos
SegmentCommitInfo
```

## 代码调用链路

```
at org.apache.lucene.index.SegmentInfos.write(SegmentInfos.java:476)
at org.apache.lucene.index.SegmentInfos.write(SegmentInfos.java:456)
at org.apache.lucene.index.SegmentInfos.prepareCommit(SegmentInfos.java:759)
at org.apache.lucene.index.IndexWriter.startCommit(IndexWriter.java:4793)
- locked <0x75c> (a org.apache.lucene.index.IndexWriter)
at org.apache.lucene.index.IndexWriter.prepareCommitInternal(IndexWriter.java:3326)
- locked <0x82f> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.commitInternal(IndexWriter.java:3458)
at org.apache.lucene.index.IndexWriter.commit(IndexWriter.java:3423)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:62)

```

```
at org.apache.lucene.index.SegmentInfos.readCommit(SegmentInfos.java:302)
at org.apache.lucene.index.SegmentInfos.readCommit(SegmentInfos.java:290)
at org.apache.lucene.index.StandardDirectoryReader$1.doBody(StandardDirectoryReader.java:59)
at org.apache.lucene.index.StandardDirectoryReader$1.doBody(StandardDirectoryReader.java:56)
at org.apache.lucene.index.SegmentInfos$FindSegmentsFile.run(SegmentInfos.java:675)
at org.apache.lucene.index.StandardDirectoryReader.open(StandardDirectoryReader.java:79)
at org.apache.lucene.index.DirectoryReader.open(DirectoryReader.java:63)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:65)
```

## 方法

### 1 org.apache.lucene.index.SegmentInfos#readCommit(org.apache.lucene.store.Directory, java.lang.String) --> SegmentInfos

给定一个段文件名，从指定目录读取段

打开文件创建ChecksumIndexInput

### 2 org.apache.lucene.index.SegmentInfos#readCommit(org.apache.lucene.store.Directory, org.apache.lucene.store.ChecksumIndexInput, long) --> SegmentInfos

通过org.apache.lucene.store.DataInput#readInt读取magic，验证是否等于org.apache.lucene.codecs.CodecUtil#CODEC_MAGIC。

通过org.apache.lucene.codecs.CodecUtil#checkHeaderNoMagic读取actualCodec、actualVersion，并且验证其合法性。

通过org.apache.lucene.store.DataInput#readBytes(byte[], int, int)读取id。

通过org.apache.lucene.codecs.CodecUtil#checkIndexHeaderSuffix读取和验证索引头部的后缀，期望的后缀是Long.toString(generation, Character.MAX_RADIX)。

读取三个VInt数据，通过org.apache.lucene.util.Version#fromBits方法构建Version对象。

如果actualVersion>=org.apache.lucene.index.SegmentInfos#VERSION_70，通过org.apache.lucene.store.DataInput#readVInt读取indexCreatedVersion。