打开索引

```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.store.MMapDirectory.openInput(MMapDirectory.java:235)
	  at org.apache.lucene.codecs.lucene50.Lucene50PostingsReader.<init>(Lucene50PostingsReader.java:81)
	  at org.apache.lucene.codecs.lucene50.Lucene50PostingsFormat.fieldsProducer(Lucene50PostingsFormat.java:442)
	  at org.apache.lucene.codecs.perfield.PerFieldPostingsFormat$FieldsReader.<init>(PerFieldPostingsFormat.java:261)
	  at org.apache.lucene.codecs.perfield.PerFieldPostingsFormat.fieldsProducer(PerFieldPostingsFormat.java:341)
	  at org.apache.lucene.index.SegmentCoreReaders.<init>(SegmentCoreReaders.java:106)
	  at org.apache.lucene.index.SegmentReader.<init>(SegmentReader.java:74)
	  at org.apache.lucene.index.StandardDirectoryReader$1.doBody(StandardDirectoryReader.java:62)
	  at org.apache.lucene.index.StandardDirectoryReader$1.doBody(StandardDirectoryReader.java:54)
	  at org.apache.lucene.index.SegmentInfos$FindSegmentsFile.run(SegmentInfos.java:685)
	  at org.apache.lucene.index.StandardDirectoryReader.open(StandardDirectoryReader.java:77)
	  at org.apache.lucene.index.DirectoryReader.open(DirectoryReader.java:63)
	  at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:193)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:219)
```

```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.store.MMapDirectory.openInput(MMapDirectory.java:235)
	  at org.apache.lucene.codecs.blocktree.BlockTreeTermsReader.<init>(BlockTreeTermsReader.java:153)
	  at org.apache.lucene.codecs.lucene50.Lucene50PostingsFormat.fieldsProducer(Lucene50PostingsFormat.java:445)
	  at org.apache.lucene.codecs.perfield.PerFieldPostingsFormat$FieldsReader.<init>(PerFieldPostingsFormat.java:261)
	  at org.apache.lucene.codecs.perfield.PerFieldPostingsFormat.fieldsProducer(PerFieldPostingsFormat.java:341)
	  at org.apache.lucene.index.SegmentCoreReaders.<init>(SegmentCoreReaders.java:106)
	  at org.apache.lucene.index.SegmentReader.<init>(SegmentReader.java:74)
	  at org.apache.lucene.index.StandardDirectoryReader$1.doBody(StandardDirectoryReader.java:62)
	  at org.apache.lucene.index.StandardDirectoryReader$1.doBody(StandardDirectoryReader.java:54)
	  at org.apache.lucene.index.SegmentInfos$FindSegmentsFile.run(SegmentInfos.java:685)
	  at org.apache.lucene.index.StandardDirectoryReader.open(StandardDirectoryReader.java:77)
	  at org.apache.lucene.index.DirectoryReader.open(DirectoryReader.java:63)
	  at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:193)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:219)
```

```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.store.Directory.openChecksumInput(Directory.java:137)
	  at org.apache.lucene.codecs.lucene53.Lucene53NormsProducer.<init>(Lucene53NormsProducer.java:55)
	  at org.apache.lucene.codecs.lucene53.Lucene53NormsFormat.normsProducer(Lucene53NormsFormat.java:82)
	  at org.apache.lucene.index.SegmentCoreReaders.<init>(SegmentCoreReaders.java:113)
	  at org.apache.lucene.index.SegmentReader.<init>(SegmentReader.java:74)
	  at org.apache.lucene.index.StandardDirectoryReader$1.doBody(StandardDirectoryReader.java:62)
	  at org.apache.lucene.index.StandardDirectoryReader$1.doBody(StandardDirectoryReader.java:54)
	  at org.apache.lucene.index.SegmentInfos$FindSegmentsFile.run(SegmentInfos.java:685)
	  at org.apache.lucene.index.StandardDirectoryReader.open(StandardDirectoryReader.java:77)
	  at org.apache.lucene.index.DirectoryReader.open(DirectoryReader.java:63)
	  at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:193)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:219)
```

```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.store.Directory.openChecksumInput(Directory.java:137)
	  at org.apache.lucene.codecs.compressing.CompressingStoredFieldsReader.<init>(CompressingStoredFieldsReader.java:129)
	  at org.apache.lucene.codecs.compressing.CompressingStoredFieldsFormat.fieldsReader(CompressingStoredFieldsFormat.java:121)
	  at org.apache.lucene.codecs.lucene50.Lucene50StoredFieldsFormat.fieldsReader(Lucene50StoredFieldsFormat.java:173)
	  at org.apache.lucene.index.SegmentCoreReaders.<init>(SegmentCoreReaders.java:119)
	  at org.apache.lucene.index.SegmentReader.<init>(SegmentReader.java:74)
	  at org.apache.lucene.index.StandardDirectoryReader$1.doBody(StandardDirectoryReader.java:62)
	  at org.apache.lucene.index.StandardDirectoryReader$1.doBody(StandardDirectoryReader.java:54)
	  at org.apache.lucene.index.SegmentInfos$FindSegmentsFile.run(SegmentInfos.java:685)
	  at org.apache.lucene.index.StandardDirectoryReader.open(StandardDirectoryReader.java:77)
	  at org.apache.lucene.index.DirectoryReader.open(DirectoryReader.java:63)
	  at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:193)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:219)
```


```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.index.IndexReaderContext.<init>(IndexReaderContext.java:41)
	  at org.apache.lucene.index.CompositeReaderContext.<init>(CompositeReaderContext.java:56)
	  at org.apache.lucene.index.CompositeReaderContext.<init>(CompositeReaderContext.java:50)
	  at org.apache.lucene.index.CompositeReaderContext$Builder.build(CompositeReaderContext.java:107)
	  at org.apache.lucene.index.CompositeReaderContext$Builder.build(CompositeReaderContext.java:91)
	  at org.apache.lucene.index.CompositeReaderContext.create(CompositeReaderContext.java:34)
	  at org.apache.lucene.index.CompositeReader.getContext(CompositeReader.java:103)
	  at org.apache.lucene.index.CompositeReader.getContext(CompositeReader.java:53)
	  at org.apache.lucene.search.IndexSearcher.<init>(IndexSearcher.java:218)
	  at org.apache.lucene.search.IndexSearcher.<init>(IndexSearcher.java:203)
	  at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:194)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:219)
```

```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.index.IndexReaderContext.<init>(IndexReaderContext.java:39)
	  at org.apache.lucene.index.LeafReaderContext.<init>(LeafReaderContext.java:40)
	  at org.apache.lucene.index.CompositeReaderContext$Builder.build(CompositeReaderContext.java:97)
	  at org.apache.lucene.index.CompositeReaderContext$Builder.build(CompositeReaderContext.java:114)
	  at org.apache.lucene.index.CompositeReaderContext$Builder.build(CompositeReaderContext.java:91)
	  at org.apache.lucene.index.CompositeReaderContext.create(CompositeReaderContext.java:34)
	  at org.apache.lucene.index.CompositeReader.getContext(CompositeReader.java:103)
	  at org.apache.lucene.index.CompositeReader.getContext(CompositeReader.java:53)
	  at org.apache.lucene.search.IndexSearcher.<init>(IndexSearcher.java:218)
	  at org.apache.lucene.search.IndexSearcher.<init>(IndexSearcher.java:203)
	  at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:194)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:219)
```



search


org/apache/lucene/codecs/blocktree/FieldReader.java

public final class FieldReader extends Terms implements Accountable;

```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.codecs.blocktree.BlockTreeTermsReader.terms(BlockTreeTermsReader.java:291)
	  at org.apache.lucene.codecs.perfield.PerFieldPostingsFormat$FieldsReader.terms(PerFieldPostingsFormat.java:285)
	  at org.apache.lucene.index.LeafReader.terms(LeafReader.java:208)
	  at org.apache.lucene.index.TermContext.build(TermContext.java:91)
	  at org.apache.lucene.search.TermQuery.createWeight(TermQuery.java:198)
	  at org.apache.lucene.search.IndexSearcher.createWeight(IndexSearcher.java:753)
	  at org.apache.lucene.search.IndexSearcher.createNormalizedWeight(IndexSearcher.java:736)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
	  at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
	  at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:198)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:219)
```


```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.codecs.blocktree.SegmentTermsEnum.<init>(SegmentTermsEnum.java:77)
	  at org.apache.lucene.codecs.blocktree.FieldReader.iterator(FieldReader.java:156)
	  at org.apache.lucene.index.TermContext.build(TermContext.java:93)
	  at org.apache.lucene.search.TermQuery.createWeight(TermQuery.java:198)
	  at org.apache.lucene.search.IndexSearcher.createWeight(IndexSearcher.java:753)
	  at org.apache.lucene.search.IndexSearcher.createNormalizedWeight(IndexSearcher.java:736)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
	  at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
	  at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:198)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:219)
```

```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.codecs.blocktree.SegmentTermsEnum.seekExact(SegmentTermsEnum.java:328)
	  at org.apache.lucene.index.TermContext.build(TermContext.java:94)
	  at org.apache.lucene.search.TermQuery.createWeight(TermQuery.java:198)
	  at org.apache.lucene.search.IndexSearcher.createWeight(IndexSearcher.java:753)
	  at org.apache.lucene.search.IndexSearcher.createNormalizedWeight(IndexSearcher.java:736)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
	  at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
	  at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:198)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:219)
```


获取倒排链表PostingsEnum
```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.codecs.lucene50.Lucene50PostingsReader$BlockDocsEnum.reset(Lucene50PostingsReader.java:296)
	  at org.apache.lucene.codecs.lucene50.Lucene50PostingsReader.postings(Lucene50PostingsReader.java:210)
	  at org.apache.lucene.codecs.blocktree.SegmentTermsEnum.postings(SegmentTermsEnum.java:1002)
	  at org.apache.lucene.search.TermQuery$TermWeight.scorer(TermQuery.java:104)
	  at org.apache.lucene.search.Weight.bulkScorer(Weight.java:135)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:667)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
	  at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
	  at io.swimmingsand.study.IndexingBoost.test1(IndexingBoost.java:198)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:219)
```