# FieldsProducer

A block-based terms index and dictionary that assigns terms to variable length blocks according to how they share prefixes. The terms index is a prefix trie whose leaves are term blocks. The advantage of this approach is that seekExact is often able to determine a term cannot exist without doing any IO, and intersection with Automata is very fast. Note that this terms dictionary has its own fixed terms index (ie, it does not support a pluggable terms index implementation).
NOTE: this terms dictionary supports min/maxItemsPerBlock during indexing to control how much memory the terms index uses.
The data structure used by this implementation is very similar to a burst trie (http://citeseer.ist.psu.edu/viewdoc/summary?doi=10.1.1.18.3499), but with added logic to break up too-large blocks of all terms sharing a given prefix into smaller ones.
Use org.apache.lucene.index.CheckIndex with the -verbose option to see summary statistics on the blocks in the dictionary. See BlockTreeTermsWriter.

# FieldsConsumer

Abstract API that consumes terms, doc, freq, prox, offset and payloads postings. Concrete implementations of this actually do "something" with the postings (write it into the index in a specific format).

# BlockTreeTermsReader

Term Dictionary
The .tim file contains the list of terms in each field along with per-term statistics (such as docfreq) and per-term metadata (typically pointers to the postings list for that term in the inverted index).
The .tim is arranged in blocks: with blocks containing a variable number of entries (by default 25-48), where each entry is either a term or a reference to a sub-block.
NOTE: The term dictionary can plug into different postings implementations: the postings writer/reader are actually responsible for encoding and decoding the Postings Metadata and Term Metadata sections.



Notes:
Header is a CodecHeader storing the version information for the BlockTree implementation.
DirOffset is a pointer to the FieldSummary section.
DocFreq is the count of documents which contain the term.
TotalTermFreq is the total number of occurrences of the term. This is encoded as the difference between the total number of occurrences and the DocFreq.
FieldNumber is the fields number from FieldInfos. (.fnm)
NumTerms is the number of unique terms for the field.
RootCode points to the root block for the field.
SumDocFreq is the total number of postings, the number of term-document pairs across the entire field.
DocCount is the number of documents that have at least one posting for this field.
LongsSize records how many long values the postings writer/reader record per term (e.g., to hold freq/prox/doc file offsets).
MinTerm, MaxTerm are the lowest and highest term in this field.
PostingsHeader and TermMetadata are plugged into by the specific postings implementation: these contain arbitrary per-file data (such as parameters or versioning information) and per-term data (such as pointers to inverted files).
For inner nodes of the tree, every entry will steal one bit to mark whether it points to child nodes(sub-block). If so, the corresponding TermStats and TermMetaData are omitted



Term Index
The .tip file contains an index into the term dictionary, so that it can be accessed randomly. The index is also used to determine when a given term cannot exist on disk (in the .tim file), saving a disk seek.


Notes:
The .tip file contains a separate FST for each field. The FST maps a term prefix to the on-disk block that holds all terms starting with that prefix. Each field's IndexStartFP points to its FST.
DirOffset is a pointer to the start of the IndexStartFPs for all fields
It's possible that an on-disk block would contain too many terms (more than the allowed maximum (default: 48)). When this happens, the block is sub-divided into new blocks (called "floor blocks"), and then the output in the FST for the block's prefix encodes the leading byte of each sub-block, and its file pointer.

org/apache/lucene/codecs/blocktree/BlockTreeTermsWriter.java

## 公开接口方法

public void write(Fields fields);

### 参数说明

Fields参数的值的类型为org.apache.lucene.index.FilterLeafReader.FilterFields（抽象类）。在org.apache.lucene.codecs.perfield.PerFieldPostingsFormat.FieldsWriter中创建了一个匿名具体类，重载了public Iterator<String> iterator()方法。

### 功能描述

对Fields中的每一个字段，枚举出其所有词项（Terms），每个词项使用org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter.TermsWriter完成索引建立。所有词项处理后，进行一个结束操作。

### 实现细节

FreqProxFields为包含所有字段信息的底层数据源，给FilterFields上层提供数据。

FreqProxTermsWriterPerField单个字段的索引数据源，FreqProxFields中有一个关联容器将字段名和这个FreqProxTermsWriterPerField关联起来。

FreqProxTerms实现了Terms接口，使用FreqProxTermsWriterPerField作为其底层数据源。FreqProxTerms是一个迭代器工厂，产生TermsEnum迭代器，TermsEnum的具体实现类为FreqProxTermsEnum，使用FreqProxTermsWriterPerField作为底层数据源。


org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter.TermsWriter

TermsWriter是BlockTreeTermsWriter的内部类，具有包访问级别。

## 公开接口方法

public void write(BytesRef text, TermsEnum termsEnum)

### 参数说明

BytesRef text

需要写入的词项

TermsEnum termsEnum

词项没举器。TermsEnum的具体实现类为FreqProxTermsEnum

### 功能描述

使用Lucene50PostingsWriter将text词项对应的文档列表写入索引，返回一个BlockTermState，记录列表的存储位置。

将词项推入堆栈。

使用词项和词项的BlockTermState创建PendingTerm，加入List<PendingEntry> pending中，悬而未决，在调用private void pushTerm(BytesRef text)方法往堆栈添加新的词项时，判断是否要将一批词项写入词典块中。在将新词项推入堆栈无法触发的词项，候选finish方法会处理。


# org.apache.lucene.codecs.lucene50.Lucene50PostingsWriter

## 公开接口方法

public final BlockTermState writeTerm(BytesRef term, TermsEnum termsEnum, FixedBitSet docsSeen);

### 参数说明

BytesRef term

需要写入的词项，方法内部没有使用

TermsEnum termsEnum

词项没举器。TermsEnum的具体实现类为FreqProxTermsEnum。用来获取词项的文档列表枚举器PostingsEnum（具体类为FreqProxDocsEnum）。

FixedBitSet docsSeen

引用类型的出参。方法内部处理文档时修改docsSeen中对应的比特位。

### 功能描述

使用termsEnum（TermsEnum的具体实现类为FreqProxTermsEnum）的方法public abstract PostingsEnum postings(PostingsEnum reuse, int flags)获取文档列表枚举器PostingsEnum（具体类为FreqProxDocsEnum）。不断调用枚举器的public int nextDoc()方获取文档ID。在处理文档之前调用public abstract void startTerm()方法，在处理文档之后调用public abstract void finishTerm(BlockTermState state)方法。枚举出每一个文档ID，传入的参数docsSeen中设置这个docID对应的比特位为1，调用public abstract void startDoc(int docID, int freq)方法写入文档ID，调用public abstract void finishDoc()方法完成写入。


### 实现细节

FreqProxPostingsArray为FreqProxDocsEnum提供数据源。




# org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter.TermsWriter

1 void writeBlocks(int prefixLength, int count) throws IOException


2 private PendingBlock writeBlock(int prefixLength, boolean isFloor, int floorLeadLabel, int start, int end,
                                    boolean hasTerms, boolean hasSubBlocks) throws IOException


3 public void write(BytesRef text, TermsEnum termsEnum) throws IOException

4 private void pushTerm(BytesRef text) throws IOException

5 public void finish() throws IOException


1 --> 2

3 --> 4

4 --> 1

5 --> 4

5 --> 1

3 为BlockTreeTermsWriter的public void write(Fields fields)的方法调用TermsWriter的接口

5 为BlockTreeTermsWriter的public void write(Fields fields)的方法调用TermsWriter的接口

## private void pushTerm(BytesRef text) throws IOException方法实现

pos 指向当前text和之前最后一个lastTerm的公共前缀的结束位置，及pos指向的字符是第一个不是前缀的字符。

pos = 1
 |
 |
a b y s s

a c c e d e

prefixStarts记录了每个长度的前缀包含的第一个单词在pending中的下标索引位置

pending 记录了目前位置加入的词条

# BlockTreeTermsWriter

## 如何构造

```
public BlockTreeTermsWriter(SegmentWriteState state,
                              PostingsWriterBase postingsWriter,
                              int minItemsInBlock,
                              int maxItemsInBlock,
                              int minItemsInAutoPrefix,
                              int maxItemsInAutoPrefix)
    throws IOException
```

参数

SegmentWriteState state

要写入的索引段的信息

PostingsWriterBase postingsWriter

int minItemsInBlock

int maxItemsInBlock

int minItemsInAutoPrefix

int maxItemsInAutoPrefix

## 接口

```
public void write(Fields fields) throws IOException
```

### 参数

Fields fields









.tim Term Dictionary
.tip Term Index

# Term Dictionary

包含了一个字段的所有词项
每个词项的统计信息，如文档频率
每个词项的元数据，指向文档列表的指针

## 组织结构

以块为组织单元

每个块包含的条目数量不固定（默认在25-48条范围之内）

每个条目或者是一个词项，或者是一个指向子块的引用

词典可以使用不同的文档列表实现，文档列表读写器负责文档列表元数据和词项元数据的编码和解码。


TermsWriter.write()

## 写词项的文档列表信息，获取文档在文档文件中的文件指针信息，保存到BlockTermState对象

BlockTermState对象的字段值例子

```
docStartFP=94
posStartFP=61
payStartFP=61
skipOffset=146
lastPosBlockOffset=20
singletonDocID=-1
docFreq=1371
totalTermFreq=1371
termBlockOrd=0
blockFilePointer=0
ord=0
```

## 推送一个词项到栈顶，调用TermsWriter.pushTerm方法

## 使用词项目和其对应的BlockTermState对象构建PendingTerm对象，加入PendingTerm数组

```

```


# EntryCount

写

```
// Write block header:
int numEntries = end - start;
int code = numEntries << 1;
if (end == pending.size()) {
// Last block:
code |= 1;
}
termsOut.writeVInt(code);
```

读
```
int code = ste.in.readVInt();
entCount = code >>> 1;
assert entCount > 0;
isLastInFloor = (code & 1) != 0;
```


# SuffixLength

写

```
// For leaf block we write suffix straight
suffixWriter.writeVInt(suffix);

// For non-leaf block we borrow 1 bit to record
// if entry is term or sub-block
suffixWriter.writeVInt(suffix<<1);

// For non-leaf block we borrow 1 bit to record
// if entry is term or sub-block
suffixWriter.writeVInt((suffix<<1)|1);

```

读

```
// term suffixes:
code = ste.in.readVInt();
isLeafBlock = (code & 1) != 0;
int numBytes = code >>> 1;
if (suffixBytes.length < numBytes) {
  suffixBytes = new byte[ArrayUtil.oversize(numBytes, 1)];
}
```