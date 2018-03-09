CompressingStoredFieldsWriter

文件名称

org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#fieldsStream=MockIndexOutputWrapper(RAMOutputStream(name="\_0.fdt"))

文件内容

模式org.apache.lucene.codecs.lucene50.Lucene50StoredFieldsFormat.Mode#BEST_SPEED，formatName为Lucene50StoredFieldsFast。

模式org.apache.lucene.codecs.lucene50.Lucene50StoredFieldsFormat.Mode#BEST_COMPRESSION，formatName为Lucene50StoredFieldsHigh。

org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#CODEC_SFX_IDX为Index，codecNameIdx为Lucene50StoredFieldsHighIndex。

org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#CODEC_SFX_DAT为Data，codecNameDat为Lucene50StoredFieldsHighData。

Magic来自org.apache.lucene.codecs.CodecUtil#CODEC_MAGIC的取值。

CodecName为codecNameDat变量的取值。

Version来自org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#VERSION_CURRENT的取值。

ObjectID来自org.apache.lucene.index.SegmentInfo#getId()方法。

ObjectSuffix来自org.apache.lucene.codecs.compressing.CompressingStoredFieldsFormat#segmentSuffix字段的取值。

## 二 方法

### 1 org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#startDocument() --> void

什么都没做

### 2 org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#writeField(FieldInfo info, IndexableField field) --> void

org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#numStoredFieldsInDoc计数器加1。

计算出字段的值，推断其类型，字段的类型为Number、BytesRef、String之一。根据具体的类型确定存储使用的bit数量，如下列出了具体类型的bit占用数量。

```
static final int         STRING = 0x00;
static final int       BYTE_ARR = 0x01;
static final int    NUMERIC_INT = 0x02;
static final int  NUMERIC_FLOAT = 0x03;
static final int   NUMERIC_LONG = 0x04;
static final int NUMERIC_DOUBLE = 0x05;
```

字段ID和字段类型保存在一个long类型的数字中，低地址的3位用来存字段类型，剩余的位用来保存字段ID，这个long类型的数字以变长编码的格式写入到org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#bufferedDocs。

#### a 字段值为BytesRef

```
bufferedDocs.writeVInt(bytes.length);
bufferedDocs.writeBytes(bytes.bytes, bytes.offset, bytes.length);
```

#### b 字段值为String

```
bufferedDocs.writeString(string);
```

#### c 字段值为Byte、Short、Integer

```
bufferedDocs.writeZInt(number.intValue());
```

#### d 字段值为Long

```
writeTLong(bufferedDocs, number.longValue());
```

#### e 字段值为Float

```
writeZFloat(bufferedDocs, number.floatValue());
```

#### f 字段值为Double

```
writeZDouble(bufferedDocs, number.doubleValue());
```

### 3 org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#writeTLong(DataOutput out, long l) --> void

l为时间戳数据，存储时可以进行压缩，压缩模式如下列出所示。

```
00 - uncompressed
01 - multiple of 1000 (second)
10 - multiple of 3600000 (hour)
11 - multiple of 86400000 (day)
```

根据时间戳是否能被秒、时、天整除，将时间戳进行单位变换，数值缩小，得到变换了单位的l值。如l的原始单位毫秒，数值为1000，变换到单位秒，数值为1。

整个存储内容由两部分组成，分别为头部Header，经过zigzag编码的l的高bit位部分（可能没有）。

头部Header是一个8位字节。从低位往高位数的7、8位存储压缩模式，压缩模式的存储内容如下。

```
static final int SECOND_ENCODING = 0x40; // 0b01 000000
static final int HOUR_ENCODING = 0x80;   // 0b10 000000
static final int DAY_ENCODING = 0xC0;    // 0b11 000000
```

对l进行org.apache.lucene.util.BitUtil#zigZagEncode(long)编码，然后取走其低5位，存储到Header的低5位。

如果取走低5位后，经过zigzag编码的l还有高位数据，Header的第6位存储比特1，否则存储比特0。

求出经过zigzag编码的l的高位upperBits = zigZagL >>> 5。使用VLong存储upperBits。


### 4 org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#writeZFloat(DataOutput out, float f) --> void

整个存储内容由两部分组成，分别为头部Header和尾部Bytes（可能没有）。

头部Header是一个Uint8类型的整数。

情形一，Header等于0xFF，存储的是一个负数，尾部有4个字节存储了数据。

情形二，Header的最高位bit为1，剩余的bit组成的数加1得到存储的数据。

情形三，Header的最高位bit为0，存储的数据是一个正浮点数，它的第一个字节存储在Header中，剩余的3个字节存储在尾部的3个字节中。


### 5 org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#writeZDouble(DataOutput out, double d) --> void

整个存储内容由两部分组成，分别为头部Header和尾部Bytes（可能没有）。

头部Header是一个Uint8类型的整数。

情形一，Header等于0xFF，存储的是一个负数，尾部有8个字节存储了数据。

情形一，Header等于0xFE，存储的是一个负数，尾部有4个字节存储了数据。

情形二，Header的最高位bit为1，剩余的bit组成的数加1得到存储的数据。

情形三，Header的最高位bit为0，存储的数据是一个正浮点数，它的第一个字节存储在Header中，剩余的7个字节存储在尾部的3个字节中。

### 6 org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#finishDocument() --> void

org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#numStoredFields记录每个文档存储了多少个字段，数组的下标索引为org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#numBufferedDocs，多少个字段从org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#numStoredFieldsInDoc取值获得。

org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#endOffsets记录每个文档的字段在org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#bufferedDocs中存储结束位置。

通过org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#triggerFlush()方法判定是否要刷新。如果要刷新，则调用org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#flush()方法刷新。

### 7 org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#triggerFlush() --> void

满足如下条件则进行刷新。

```
bufferedDocs.getPosition() >= chunkSize || // chunks of at least chunkSize bytes
numBufferedDocs >= maxDocsPerChunk;
```

### 8 org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#flush() --> void

写索引，调用org.apache.lucene.codecs.compressing.CompressingStoredFieldsIndexWriter#writeIndex方法，传入当前刷新的文档数量numDocs，该批文档的字段存储的起始位置startPointer。

调用org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#writeHeader方法写入一个chunk的头部。

调用org.apache.lucene.codecs.compressing.Compressor#compress方法对bufferedDocs进行压缩并且将压缩的结果写入到fdt文件中。

### 9 org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#writeHeader(int docBase, int numBufferedDocs, int[] numStoredFields, int[] lengths, boolean sliced) --> 

### 10 org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#saveInts(int[] values, int length, DataOutput out) --> void

### 11 org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#finish(FieldInfos fis, int numDocs) --> void

如果numBufferedDocs大于0，则调用org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#flush方法。

调用org.apache.lucene.codecs.compressing.CompressingStoredFieldsIndexWriter#finish方法。




# 使用了哪些技术？

## 块压缩技术

LZ4

## 整数打包技术

PackedInts


## 可增长的字节数组DataOutput

GrowableByteArrayDataOutput

用作文档的缓冲区，bufferedDocs


# 控制行为的属性变量

块大小

chunkSize

文档缓冲区的初始大小

每个块存放的最大文档数

maxDocsPerChunk

# 文件命名规则

段名称_段后缀.文件后缀

# 构造函数中做了什么？

创建字段数据字节流

创建字段数据索引字节流

创建字段数据索引字节流写入器

写入文件头的内容

写入chunkSize

写入整数打包格式的版本号PackedInts.VERSION_CURRENT

# 刷新缓冲区的数据到磁盘

## 刷新的条件

bufferedDocs.length >= chunkSize 或 numBufferedDocs >= maxDocsPerChunk

写数据索引到字段数据索引字节流，索引记录了，从当前文件位置开始起有多少篇文档

### 写一个头

记录文档ID的基础值，当前缓冲的文档数量，每个文档的存储型字段数量，每个文档在缓冲区中所占长度，是否切片

1 docBase VInt
2 ((numBufferedDocs) << 1 | slicedBit) VInt
3 numStoredFields

* 长度为1
	values[0] VInt
* 长度大于1
	* 值全相等
		0 VInt
		values[0] VInt
	* 值不是全相等
		bitsRequired VInt
		使用PackedWriter编码

4 lengths

* 长度为1
	values[0] VInt
* 长度大于1
	* 值全相等
		0 VInt
		values[0] VInt
	* 值不是全相等
		bitsRequired VInt
		使用PackedWriter编码

### 将数据bufferedDocs压缩后写入

# finish方法

刷新缓冲区的数据到磁盘

完成字段数据索引的写入

numChunks VLong
numDirtyChunks VLong

写入文件脚writeFooter

	Magic FOOTER_MAGIC Int
	AlgorithmID 0 Int
	Checksum getChecksum Long

# writeField方法

数据写入到bufferedDocs

numStoredFieldsInDoc自增数量1

计算出字段的值和类型

字段ID和字段类型保存在一个long类型的数字中，低地址的3位用来存字段类型，剩余的位用来保存字段ID，这个long类型的数字以变长编码的格式写入到bufferedDocs

## 字符串类型的字段

将字符串使用utf-8编码，编码后的长度记为length

将length写入bufferedDocs

将编码后的utf-8格式字节序列写入bufferedDocs

## finishDocument()方法

numStoredFields记录么个doc的存储字段数量

numBufferedDocs记录已缓冲的文档数量

endOffsets记录了每个文档的数据在缓冲区占据空间的结束位置点

判断是否需要刷新


## 实例构造代码调用链路

```
at org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter.<init>(CompressingStoredFieldsWriter.java:99)
at org.apache.lucene.codecs.compressing.CompressingStoredFieldsFormat.fieldsWriter(CompressingStoredFieldsFormat.java:128)
at org.apache.lucene.codecs.lucene50.Lucene50StoredFieldsFormat.fieldsWriter(Lucene50StoredFieldsFormat.java:183)
at org.apache.lucene.index.StoredFieldsConsumer.initStoredFieldsWriter(StoredFieldsConsumer.java:39)
at org.apache.lucene.index.StoredFieldsConsumer.startDocument(StoredFieldsConsumer.java:46)
at org.apache.lucene.index.DefaultIndexingChain.startStoredFields(DefaultIndexingChain.java:353)
at org.apache.lucene.index.DefaultIndexingChain.processDocument(DefaultIndexingChain.java:387)
at org.apache.lucene.index.DocumentsWriterPerThread.updateDocument(DocumentsWriterPerThread.java:240)
at org.apache.lucene.index.DocumentsWriter.updateDocument(DocumentsWriter.java:496)
at org.apache.lucene.index.IndexWriter.updateDocument(IndexWriter.java:1729)
at org.apache.lucene.index.IndexWriter.addDocument(IndexWriter.java:1464)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:56)
```

## org.apache.lucene.index.StoredFieldsConsumer#finish代码调用链路

```
at org.apache.lucene.index.StoredFieldsConsumer.finish(StoredFieldsConsumer.java:63)
at org.apache.lucene.index.DefaultIndexingChain.flush(DefaultIndexingChain.java:144)
at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:452)
at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:556)
at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:672)
at org.apache.lucene.index.IndexWriter.prepareCommitInternal(IndexWriter.java:3246)
- locked <0x96d> (a java.lang.Object)
- locked <0x96e> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.commitInternal(IndexWriter.java:3458)
at org.apache.lucene.index.IndexWriter.commit(IndexWriter.java:3423)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:62)
```

## org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter#finish代码调用链路

```
at org.apache.lucene.codecs.compressing.CompressingStoredFieldsWriter.finish(CompressingStoredFieldsWriter.java:464)
at org.apache.lucene.index.StoredFieldsConsumer.flush(StoredFieldsConsumer.java:72)
at org.apache.lucene.index.DefaultIndexingChain.flush(DefaultIndexingChain.java:145)
at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:452)
at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:556)
at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:672)
at org.apache.lucene.index.IndexWriter.prepareCommitInternal(IndexWriter.java:3246)
- locked <0x96d> (a java.lang.Object)
- locked <0x96e> (a java.lang.Object)
at org.apache.lucene.index.IndexWriter.commitInternal(IndexWriter.java:3458)
at org.apache.lucene.index.IndexWriter.commit(IndexWriter.java:3423)
at org.apache.lucene.codecs.lucene50.TestLucene50StoredFieldsFormatHighCompression.testMixedCompressions(TestLucene50StoredFieldsFormatHighCompression.java:62)
```