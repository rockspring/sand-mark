# DefaultIndexingChain

## org.apache.lucene.index.DefaultIndexingChain#DefaultIndexingChain

如果索引段没有排序，创建org.apache.lucene.index.StoredFieldsConsumer和org.apache.lucene.index.TermVectorsConsumer。

如果索引段有排序，创建org.apache.lucene.index.SortingStoredFieldsConsumer和org.apache.lucene.index.SortingTermVectorsConsumer。

无论索引段是否有排序，创建org.apache.lucene.index.FreqProxTermsWriter#FreqProxTermsWriter。

## 二 方法

### 1 org.apache.lucene.index.DefaultIndexingChain#startStoredFields(int docID) --> void

开始处理docID对应文档的存储字段。

### 2 org.apache.lucene.index.DefaultIndexingChain#processDocument() --> void

首先调用org.apache.lucene.index.TermsHash#startDocument方法。

然后调用org.apache.lucene.index.DefaultIndexingChain#startStoredFields方法。

然后从org.apache.lucene.index.DocumentsWriterPerThread.DocState取出文档的字段IndexableField。

针对每一个字段IndexableField，调用org.apache.lucene.index.DefaultIndexingChain#processField方法处理。

### 3 org.apache.lucene.index.DefaultIndexingChain#processField(IndexableField field, long fieldGen, int fieldCount) --> int

四大块处理，分别为倒排索引、字段存储、字段docvalues存储，空间点索引。

如果字段类型的索引选项org.apache.lucene.document.FieldType#indexOptions不为IndexOptions.NONE，调用org.apache.lucene.index.DefaultIndexingChain#getOrAddField方法获取一个PerField，然后调用org.apache.lucene.index.DefaultIndexingChain.PerField#invert方法。

如果字段类型表明该字段应该存储，调用org.apache.lucene.index.StoredFieldsConsumer#writeField方法。

如果字段类型的org.apache.lucene.index.IndexableFieldType#docValuesType不为DocValuesType.NONE，调用org.apache.lucene.index.DefaultIndexingChain#indexDocValue方法。

如果字段类型的org.apache.lucene.index.IndexableFieldType#pointDimensionCount不等于0，调用org.apache.lucene.index.DefaultIndexingChain#indexPoint。

