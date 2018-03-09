# StoredFieldsConsumer

## 一、字段

### 1 org.apache.lucene.index.StoredFieldsConsumer#docWriter

DocumentsWriterPerThread是一个更高抽象层次的类，StoredFieldsConsumer保存它的引用是为了从中获取一些其他信息，如目录TrackingDirectoryWrapper和段信息SegmentInfo。

### 2 org.apache.lucene.index.StoredFieldsConsumer#writer

StoredFieldsWriter是负责将内存数据写入到磁盘文件的写入器。

### 3 org.apache.lucene.index.StoredFieldsConsumer#lastDoc

最后一个处理的docID。

## 二、方法

### 1 org.apache.lucene.index.StoredFieldsConsumer#initStoredFieldsWriter() --> void

StoredFieldsConsumer构造的时候类型为StoredFieldsWriter的字段没有被构造出来，这个方法负责从DocumentsWriterPerThread中获取使用的Codec的StoredFieldsFormat，使用它创建一个StoredFieldsWriter。

### 2 org.apache.lucene.index.StoredFieldsConsumer#startDocument(int docID) --> void

如果docID不是lastDoc+1，说明跳过了一些docID。跳过多少个docID就调用多少次org.apache.lucene.codecs.StoredFieldsWriter#startDocument和org.apache.lucene.codecs.StoredFieldsWriter#finishDocument。

针对docID，调用一次org.apache.lucene.codecs.StoredFieldsWriter#startDocument。

### 3 org.apache.lucene.index.StoredFieldsConsumer#writeField(FieldInfo info, IndexableField field) --> void

调用org.apache.lucene.codecs.StoredFieldsWriter#writeField方法。

