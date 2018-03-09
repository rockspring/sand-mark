Lucene源码解读目录

## 1 Query

### 1.1 BlendedTermQuery

### 1.2 BooleanQuery

### 1.3 BoostQuery

### 1.4 ConstantScoreQuery

### 1.5 DisjunctionMaxQuery

### 1.6 DocValuesRewriteMethod.MultiTermQueryDocValuesWrapper

### 1.7 FieldValueQuery

### 1.8 MatchAllDocsQuery

### 1.9 MatchNoDocsQuery

### 1.10 MultiPhraseQuery

### 1.11 MultiTermQuery

#### 1.11.1 AutomatonQuery

##### 1.11.1.1 PrefixQuery

##### 1.11.1.2 RegexpQuery

##### 1.11.1.3 TermRangeQuery

##### 1.11.1.4 WildcardQuery

#### 1.11.2 FuzzyQuery 

#### 1.11.3 LegacyNumericRangeQuery<T> 

### 1.12 MultiTermQueryConstantScoreWrapper<Q>

### 1.13 NGramPhraseQuery

### 1.14 PhraseQuery

### 1.15 PointInSetQuery

### 1.16 PointRangeQuery

### 1.17 SpanQuery

#### 1.17.1 FieldMaskingSpanQuery

#### 1.17.2 SpanBoostQuery

#### 1.17.3 SpanContainQuery

##### 1.17.3.1 SpanContainingQuery

##### 1.17.3.2 SpanWithinQuery

#### 1.17.4 SpanMultiTermQueryWrapper<Q>

#### 1.17.5 SpanNearQuery

#### 1.17.6 SpanNearQuery.SpanGapQuery

#### 1.17.7 SpanNotQuery

#### 1.17.8 SpanOrQuery

#### 1.17.9 SpanPositionCheckQuery

##### 1.17.9.1 SpanPositionRangeQuery

###### 1.17.9.1.1 SpanFirstQuery

#### 1.17.10 SpanTermQuery

### 1.18 SynonymQuery

### 1.19 TermQuery

## 2 Scorer

### 2.1 CachingCollector.CachedScorer

### 2.2 ConjunctionScorer

#### 2.2.1 BooleanTopLevelScorers.CoordinatingConjunctionScorer

### 2.3 ConstantScoreScorer

### 2.4 DisjunctionScorer

#### 2.4.1 DisjunctionMaxScorer

#### 2.4.2 DisjunctionSumScorer

#### 2.4.3 SynonymQuery.SynonymScorer

### 2.5 ExactPhraseScorer

### 2.6 FakeScorer

### 2.7 FilterScorer

#### 2.7.1 BooleanTopLevelScorers.BoostedScorer

#### 2.7.2 ScoreCachingWrappingScorer

### 2.8 MinShouldMatchSumScorer

### 2.9 ReqExclScorer

### 2.10 ReqOptSumScorer

#### 2.10.1 BooleanTopLevelScorers.ReqMultiOptScorer

#### 2.10.2 BooleanTopLevelScorers.ReqSingleOptScorer

### 2.11 SloppyPhraseScorer

### 2.12 SpanScorer

### 2.13 TermScorer

## 3 Similarity

### 3.1 BM25Similarity

### 3.2 MultiSimilarity

### 3.3 PerFieldSimilarityWrapper

### 3.4 SimilarityBase

#### 3.4.1 DFISimilarity

#### 3.4.2 DFRSimilarity

#### 3.4.3 IBSimilarity

#### 3.4.4 LMSimilarity

##### 3.4.4.1 LMDirichletSimilarity 

##### 3.4.4.2 LMJelinekMercerSimilarity

### 3.5 TFIDFSimilarity

#### 3.5.1 ClassicSimilarity 

## 4 Similarity.SimScorer

### 4.1 BM25Similarity.BM25DocScorer

### 4.2 MultiSimilarity.MultiSimScorer

### 4.3 SimilarityBase.BasicSimScorer

### 4.4 TFIDFSimilarity.TFIDFSimScorer

## 5 Similarity.SimWeight

### 5.1 BasicStats

#### 5.1.1 LMSimilarity.LMStats

### 5.2 BM25Similarity.BM25Stats

### 5.3 MultiSimilarity.MultiStats

### 5.4 PerFieldSimilarityWrapper.PerFieldSimWeight

### 5.5 TFIDFSimilarity.IDFStats

# Directory

## BaseDirectory

### FSDirectory

# DataOutput

## GrowableByteArrayDataOutput

# IndexOutput

## IndexFileNames

## FSIndexOutput

集成OutputStreamIndexOutput

## OutputStreamIndexOutput

# 压缩

## CompressionMode

### LZ4FastCompressor

### DeflateCompressor

### LZ4HighCompressor

### DeflateDecompressor

# 索引创建

## Codec

### Lucene62Codec

TermVectorsFormat、FieldInfosFormat、SegmentInfoFormat、LiveDocsFormat、CompoundFormat、PostingsFormat、DocValuesFormat、StoredFieldsFormat、StoredFieldsFormat、PointsFormat、NormsFormat

#### Lucene50TermVectorsFormat

#### Lucene60FieldInfosFormat

FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/\_0.fnm")

#### Lucene50StoredFieldsFormat

#### Lucene62SegmentInfoFormat

#### Lucene50LiveDocsFormat

#### Lucene50CompoundFormat

#### PerFieldPostingsFormat

#### PerFieldDocValuesFormat

#### Lucene50StoredFieldsFormat

StoredFieldsWriter

##### CompressingStoredFieldsFormat(CompressionMode.FAST)

##### CompressingStoredFieldsFormat(CompressionMode.HIGH_COMPRESSION)

##### CompressingStoredFieldsWriter

fieldsStream FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/\_0.fdt")

##### CompressingStoredFieldsIndexWriter

indexStream FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/\_0.fdx")

#### Lucene60PointsFormat

#### Lucene53NormsFormat

##### Lucene53NormsConsumer

data FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/\_0.nvd")

meta FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/\_0.nvm")

## DocConsumer

### DefaultIndexingChain

#### FieldInfos.Builder

#### DocumentsWriterPerThread

##### DocState

#### TermsHash

#### FreqProxTermsWriter

在flush的时候才创建FieldsWriter将内存结构转换成磁盘数据结构

FieldsWriter调用BlockTreeTermsWriter的write(Fields fields)方法

继续调用下层的TermsWriter

倒排数据通过ByteSliceReader读取出来，转换成磁盘数据结构

FreqProxDocsEnum枚举倒排列表

org/apache/lucene/codecs/lucene50/Lucene50PostingsWriter.java


Lucene50PostingsWriter

FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/\_0\_Lucene50\_0.doc")

FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/\_0\_Lucene50\_0.pos")

MultiLevelSkipListWriter

Lucene50SkipWriter

PostingsEnum

FreqProxPostingsEnum

FreqProxPostingsArray

```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter$TermsWriter.write(BlockTreeTermsWriter.java:870)
	  at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter.write(BlockTreeTermsWriter.java:344)
	  at org.apache.lucene.codecs.perfield.PerFieldPostingsFormat$FieldsWriter.write(PerFieldPostingsFormat.java:198)
	  at org.apache.lucene.index.FreqProxTermsWriter.flush(FreqProxTermsWriter.java:107)
	  at org.apache.lucene.index.DefaultIndexingChain.flush(DefaultIndexingChain.java:134)
	  at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:443)
	  at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:539)
	  at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:653)
	  at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3364)
	  - locked <0xe31> (a java.lang.Object)
	  at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3333)
	  at org.apache.lucene.index.IndexWriter.shutdown(IndexWriter.java:1117)
	  at org.apache.lucene.index.IndexWriter.close(IndexWriter.java:1162)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:99)
```

org/apache/lucene/codecs/blocktree/BlockTreeTermsWriter.java的public void write(BytesRef text, TermsEnum termsEnum)方法


Lucene50PostingsWriter的finishTerm方法调用写文件数据接口写入FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/\_0\_Lucene50\_0.pos")

Lucene50PostingsWriter的finishTerm方法调用Lucene50SkipWriter的writeSkip方法，继而调用写文件数据接口写入FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/\_0\_Lucene50_0.doc")


FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/\_0\_Lucene50\_0.tim")

```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.store.DataOutput.writeVInt(DataOutput.java:187)
	  at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter$TermsWriter.writeBlock(BlockTreeTermsWriter.java:673)
	  at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter$TermsWriter.writeBlocks(BlockTreeTermsWriter.java:626)
	  at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter$TermsWriter.finish(BlockTreeTermsWriter.java:936)
	  at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter.write(BlockTreeTermsWriter.java:347)
	  at org.apache.lucene.codecs.perfield.PerFieldPostingsFormat$FieldsWriter.write(PerFieldPostingsFormat.java:198)
	  at org.apache.lucene.index.FreqProxTermsWriter.flush(FreqProxTermsWriter.java:107)
	  at org.apache.lucene.index.DefaultIndexingChain.flush(DefaultIndexingChain.java:134)
	  at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:443)
	  at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:539)
	  at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:653)
	  at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3364)
	  - locked <0x5e1> (a java.lang.Object)
	  at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3333)
	  at org.apache.lucene.index.IndexWriter.shutdown(IndexWriter.java:1117)
	  at org.apache.lucene.index.IndexWriter.close(IndexWriter.java:1162)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:99)
```

FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/\_0\_Lucene50\_0.tip")

```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.store.DataOutput.writeInt(DataOutput.java:70)
	  at org.apache.lucene.codecs.CodecUtil.writeHeader(CodecUtil.java:90)
	  at org.apache.lucene.util.fst.FST.save(FST.java:536)
	  at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter$TermsWriter.finish(BlockTreeTermsWriter.java:946)
	  at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter.write(BlockTreeTermsWriter.java:347)
	  at org.apache.lucene.codecs.perfield.PerFieldPostingsFormat$FieldsWriter.write(PerFieldPostingsFormat.java:198)
	  at org.apache.lucene.index.FreqProxTermsWriter.flush(FreqProxTermsWriter.java:107)
	  at org.apache.lucene.index.DefaultIndexingChain.flush(DefaultIndexingChain.java:134)
	  at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:443)
	  at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:539)
	  at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:653)
	  at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3364)
	  - locked <0x1699> (a java.lang.Object)
	  at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3333)
	  at org.apache.lucene.index.IndexWriter.shutdown(IndexWriter.java:1117)
	  at org.apache.lucene.index.IndexWriter.close(IndexWriter.java:1162)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:99)
```

FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/\_0.si")

```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.store.DataOutput.writeInt(DataOutput.java:70)
	  at org.apache.lucene.codecs.CodecUtil.writeHeader(CodecUtil.java:90)
	  at org.apache.lucene.codecs.CodecUtil.writeIndexHeader(CodecUtil.java:133)
	  at org.apache.lucene.codecs.lucene62.Lucene62SegmentInfoFormat.write(Lucene62SegmentInfoFormat.java:216)
	  at org.apache.lucene.index.DocumentsWriterPerThread.sealFlushedSegment(DocumentsWriterPerThread.java:525)
	  at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:480)
	  at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:539)
	  at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:653)
	  at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3364)
	  - locked <0xd72> (a java.lang.Object)
	  at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3333)
	  at org.apache.lucene.index.IndexWriter.shutdown(IndexWriter.java:1117)
	  at org.apache.lucene.index.IndexWriter.close(IndexWriter.java:1162)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:99)
```

#### TermVectorsConsumer

FreqProxTermsWriter内部使用nextTermsHash存储TermVectorsConsumer

##### TermVectorsWriter

##### ByteSliceReader

##### TermVectorsConsumerPerField

## DocumentsWriter

### ThreadState

### LiveIndexWriterConfig

### DocumentsWriterDeleteQueue

### DocumentsWriterFlushQueue

### DocumentsWriterPerThreadPool

### FlushPolicy

### DocumentsWriterFlushControl

### IndexWriter

## PostingsFormat

### PerFieldPostingsFormat

#### FieldsConsumer

##### FieldsWriter

##### BlockTreeTermsWriter

## IntBlockPool

## ByteBlockPool