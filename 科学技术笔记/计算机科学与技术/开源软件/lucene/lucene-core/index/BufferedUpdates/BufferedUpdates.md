# BufferedUpdates

```
org.apache.lucene.index.FrozenBufferedUpdates
org.apache.lucene.index.BufferedUpdatesStream
```

## 字段

### 1 org.apache.lucene.index.BufferedUpdates#BYTES_PER_DEL_TERM

由Term确定的删除项占用内存估计。

HashMap有一个Entry数组（因为有负载因子，实际占用可能是2\*POINTER）。Entry是一个对象，包含Term类型的键，Integer类型的值，int类型的hash，Entry类型的next字段。Entry占用的内存大小为OBJ_HEADER + 3\*POINTER + INT。Term是一个对象，包含String类型的field和String类型的text字段。Term占用的内存大小为OBJ_HEADER + 2\*POINTER。Term的field字段是一个String对象，占用的内存大小为OBJ_HEADER + 4*INT + POINTER + OBJ_HEADER + string.length\*CHAR。Term的text字段是一个String对象，占用的内存大小为OBJ_HEADER + 4*INT + POINTER + OBJ_HEADER + string.length\*CHAR。Integer占用的内存大小为OBJ_HEADER + INT。


### 2 org.apache.lucene.index.BufferedUpdates#BYTES_PER_DEL_DOCID

由docID确定的删除项占用内存估计。

删除的docID存储在一个List<Integer>中。假设List分配的大小是实际大小的两倍，一个docID占用两个Integer指针。Integer占用的内存大小为OBJ_HEADER + INT。

### 3 org.apache.lucene.index.BufferedUpdates#BYTES_PER_DEL_QUERY

由Query确定的删除项占用内存估计。

HashMap有一个Entry数组（因为有负载因子，实际占用可能是2\*POINTER）。Entry是一个对象，包含Term类型的键，Integer类型的值，int类型的hash，Entry类型的next字段。Entry占用的内存大小为OBJ_HEADER + 3\*POINTER + INT。Query占用的内存通常在一个定值之下，比如24字节。Integer占用的内存大小为OBJ_HEADER + INT。

### 4 org.apache.lucene.index.BufferedUpdates#BYTES_PER_NUMERIC_FIELD_ENTRY

与NumericUpdate相关。

### 5 org.apache.lucene.index.BufferedUpdates#BYTES_PER_NUMERIC_UPDATE_ENTRY

与NumericUpdate相关。

### 6 org.apache.lucene.index.BufferedUpdates#BYTES_PER_BINARY_FIELD_ENTRY

与BinaryUpdate相关。

### 7 org.apache.lucene.index.BufferedUpdates#BYTES_PER_BINARY_UPDATE_ENTRY

与BinaryUpdate相关。

### 8 org.apache.lucene.index.BufferedUpdates#numTermDeletes AtomicInteger

### 9 org.apache.lucene.index.BufferedUpdates#numNumericUpdates AtomicInteger

### 10 org.apache.lucene.index.BufferedUpdates#numBinaryUpdates AtomicInteger

### 11 org.apache.lucene.index.BufferedUpdates#deleteTerms Map<Term,Integer>

### 12 org.apache.lucene.index.BufferedUpdates#deleteQueries Map<Query,Integer>

### 13 org.apache.lucene.index.BufferedUpdates#deleteDocIDs List<Integer>

### 14 org.apache.lucene.index.BufferedUpdates#numericUpdates Map<String,LinkedHashMap<Term,NumericDocValuesUpdate>>

字段类型为Map<String,LinkedHashMap<Term,NumericDocValuesUpdate>>。存储内容结构形如Map<dvField,Map<updateTerm,NumericUpdate>>。

对每一个字段，我们保持一个有序NumericUpdate列表，通过更新Term提供线索。LinkedHashMap保证我们后面以插入顺序遍历map，所以如果两个term影响同一个文档，最后一个term起作用。如果同一个term用于多次更新同一个字段，LinkedHashMap可以帮助我们更快地探测到，所以我们后续仅仅遍历它一次。

### 15 org.apache.lucene.index.BufferedUpdates#binaryUpdates Map<String,LinkedHashMap<Term,BinaryDocValuesUpdate>>

字段类型为Map<String,LinkedHashMap<Term,BinaryDocValuesUpdate>>。存储结构形如Map<dvField,Map<updateTerm,BinaryUpdate>>。

对每一个字段，我们保持一个有序BinaryUpdates列表，通过更新Term提供线索。LinkedHashMap保证我们后面以插入顺序遍历map，所以如果两个term影响同一个文档，最后一个term起作用。如果同一个term用于多次更新同一个字段，LinkedHashMap可以帮助我们更快地探测到，所以我们后续仅仅遍历它一次。

### 16 org.apache.lucene.index.BufferedUpdates#bytesUsed

### 17 org.apache.lucene.index.BufferedUpdates#gen

### 18 org.apache.lucene.index.BufferedUpdates#segmentName

## 构造函数

### 1 org.apache.lucene.index.BufferedUpdates#BufferedUpdates(String segmentName)

在org.apache.lucene.index.DocumentsWriterDeleteQueue#DocumentsWriterDeleteQueue(org.apache.lucene.util.InfoStream, long, long)中构造全局对象globalBufferedUpdates时，使用global作为segmentName。

## 方法

### 1 org.apache.lucene.index.BufferedUpdates#toString() -> String

### 2 org.apache.lucene.index.BufferedUpdates#addQuery(Query query, int docIDUpto) -> void

通过query确定删除文档。docIDUpto为删除文档的ID上限？

### 3 org.apache.lucene.index.BufferedUpdates#addDocID(int docID) -> void

通过docID确定删除文档。docIDUpto为删除文档的ID上限？

org.apache.lucene.index.DocumentsWriterPerThread#updateDocument方法中流程失败了就调用该方法。

org.apache.lucene.index.DocumentsWriterPerThread#updateDocuments方法中流程失败了就调用该方法。

### 4 org.apache.lucene.index.BufferedUpdates#addTerm(Term term, int docIDUpto) -> void

通过term确定删除文档。docIDUpto为删除文档的ID上限？

#################################################################

docvalues相关

### 5 org.apache.lucene.index.BufferedUpdates#addNumericUpdate(NumericDocValuesUpdate update, int docIDUpto) -> void

NumericDocValuesUpdate是一个就地更新的数据结构。核心字段如下所示

```
final DocValuesType type;
final Term term;
final String field;
final Object value;
```

首先通过NumericDocValuesUpdate的field找到LinkedHashMap<Term,NumericDocValuesUpdate> fieldUpdates。然后通过NumericDocValuesUpdate的term找到NumericDocValuesUpdate。然后对其更新docIDUpto。

### 6 org.apache.lucene.index.BufferedUpdates#addBinaryUpdate(BinaryDocValuesUpdate update, int docIDUpto) -> void

BinaryDocValuesUpdate是一个就地更新的数据结构。核心字段如下所示

```
final DocValuesType type;
final Term term;
final String field;
final Object value;
```

首先通过BinaryDocValuesUpdate的field找到LinkedHashMap<Term,BinaryDocValuesUpdate> fieldUpdates。然后通过BinaryDocValuesUpdate的term找到BinaryDocValuesUpdate。然后对其更新docIDUpto。

