new flexible indexing (flex) APIs (Fields, FieldsEnum, Terms, TermsEnum, DocsEnum, DocsAndPositionsEnum)

org/apache/lucene/index/StandardDirectoryReader.java

subReaders

org/apache/lucene/index/SegmentReader.java

org/apache/lucene/index/SegmentCoreReaders.java

org/apache/lucene/codecs/perfield/PerFieldPostingsFormat.java

org/apache/lucene/codecs/lucene50/Lucene50PostingsFormat.java

PostingsReaderBase
-Lucene50PostingsReader

Iterable<String>(interface)
-Fields(abstract)
--FieldsProducer(abstract)(implements Closeable, Accountable)
---BlockTreeTermsReader

AutoCloseable(interface)
-Closeable(interface)
 Accountable(interface)
--PostingsReaderBase(abstract)
---Lucene50PostingsReader

BytesRefIterator(interface)
-TermsEnum(abstract)
--SegmentTermsEnum


DocIdSetIterator(abstract)
-PostingsEnum(abstract)
--BlockDocsEnum
--BlockPostingsEnum
--EverythingEnum