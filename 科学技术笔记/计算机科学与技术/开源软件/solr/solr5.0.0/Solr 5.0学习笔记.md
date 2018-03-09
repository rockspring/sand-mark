Solr 5.0学习笔记

初始化IndexWriter时的代码执行情况

```
at org.apache.lucene.codecs.CodecUtil.checkIndexHeader(CodecUtil.java:257)
	  at org.apache.lucene.codecs.lucene50.Lucene50SegmentInfoFormat.read(Lucene50SegmentInfoFormat.java:91)
	  at org.apache.lucene.index.SegmentInfos.readCommit(SegmentInfos.java:327)
	  at org.apache.lucene.index.IndexWriter.<init>(IndexWriter.java:826)
	  at org.apache.solr.update.SolrIndexWriter.<init>(SolrIndexWriter.java:78)
	  at org.apache.solr.update.SolrIndexWriter.create(SolrIndexWriter.java:65)
	  at org.apache.solr.update.DefaultSolrCoreState.createMainIndexWriter(DefaultSolrCoreState.java:272)
	  at org.apache.solr.update.DefaultSolrCoreState.getIndexWriter(DefaultSolrCoreState.java:115)
	  at org.apache.solr.core.SolrCore.openNewSearcher(SolrCore.java:1573)
	  at org.apache.solr.core.SolrCore.getSearcher(SolrCore.java:1716)
	  at org.apache.solr.core.SolrCore.<init>(SolrCore.java:868)
	  at org.apache.solr.core.SolrCore.<init>(SolrCore.java:662)
	  at org.apache.solr.core.CoreContainer.create(CoreContainer.java:513)
	  at org.apache.solr.core.CoreContainer$1.call(CoreContainer.java:278)
	  at org.apache.solr.core.CoreContainer$1.call(CoreContainer.java:272)
	  at java.util.concurrent.FutureTask.run(FutureTask.java:262)
	  at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	  at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	  at java.lang.Thread.run(Thread.java:745)
```


段信息文件

```
A collection of segmentInfo objects with methods for operating on those segments in relation to the file system.
The active segments in the index are stored in the segment info file, segments_N. There may be one or more segments_N files in the index; however, the one with the largest generation is the active one (when older segments_N files are present it's because they temporarily cannot be deleted, or a custom IndexDeletionPolicy is in use). This file lists each segment by name and has details about the codec and generation of deletes.
Files:
segments_N: Header, Version, NameCounter, SegCount, <SegName, HasSegID, SegID, SegCodec, DelGen, DeletionCount, FieldInfosGen, DocValuesGen, UpdatesFiles>SegCount, CommitUserData, Footer
Data types:

Header --> IndexHeader
NameCounter, SegCount, DeletionCount --> Int32
Generation, Version, DelGen, Checksum, FieldInfosGen, DocValuesGen --> Int64
HasSegID --> Int8
SegID --> Int8ID_LENGTH
SegName, SegCodec --> String
CommitUserData --> Map<String,String>
UpdatesFiles --> Map<Int32, Set<String>>
Footer --> CodecFooter
Field Descriptions:

Version counts how often the index has been changed by adding or deleting documents.
NameCounter is used to generate names for new segment files.
SegName is the name of the segment, and is used as the file name prefix for all of the files that compose the segment's index.
DelGen is the generation count of the deletes file. If this is -1, there are no deletes. Anything above zero means there are deletes stored by LiveDocsFormat.
DeletionCount records the number of deleted documents in this segment.
SegCodec is the name of the Codec that encoded this segment.
HasSegID is nonzero if the segment has an identifier. Otherwise, when it is 0 the identifier is null and no SegID is written. Null only happens for Lucene 4.x segments referenced in commits.
SegID is the identifier of the Codec that encoded this segment.
CommitUserData stores an optional user-supplied opaque Map<String,String> that was passed to IndexWriter.setCommitData(Map).
FieldInfosGen is the generation count of the fieldInfos file. If this is -1, there are no updates to the fieldInfos in that segment. Anything above zero means there are updates to fieldInfos stored by FieldInfosFormat .
DocValuesGen is the generation count of the updatable DocValues. If this is -1, there are no updates to DocValues in that segment. Anything above zero means there are updates to DocValues stored by DocValuesFormat.
UpdatesFiles stores the set of files that were updated in that segment per field.
```