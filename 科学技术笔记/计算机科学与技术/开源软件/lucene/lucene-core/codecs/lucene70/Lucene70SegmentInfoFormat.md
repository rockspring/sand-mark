

org.apache.lucene.index.IndexWriter#addIndexes(org.apache.lucene.index.CodecReader...)
org.apache.lucene.index.IndexWriter#mergeMiddle
org.apache.lucene.index.DocumentsWriterPerThread#sealFlushedSegment方法中调用org.apache.lucene.codecs.SegmentInfoFormat#write方法生成一个SegmentInfo文件。


org.apache.lucene.index.SegmentInfos#readCommit(org.apache.lucene.store.Directory, org.apache.lucene.store.ChecksumIndexInput, long)方法调用org.apache.lucene.codecs.lucene70.Lucene70SegmentInfoFormat#read方法。