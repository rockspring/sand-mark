## Lucene53NormsConsumer什么时候创建并初始化


```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.codecs.lucene53.Lucene53NormsConsumer.<init>(Lucene53NormsConsumer.java:42)
	  at org.apache.lucene.codecs.lucene53.Lucene53NormsFormat.normsConsumer(Lucene53NormsFormat.java:77)
	  at org.apache.lucene.index.DefaultIndexingChain.writeNorms(DefaultIndexingChain.java:266)
	  at org.apache.lucene.index.DefaultIndexingChain.flush(DefaultIndexingChain.java:95)
	  at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:443)
	  at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:539)
	  at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:653)
	  at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3364)
	  - locked <0x4e3> (a java.lang.Object)
	  at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3333)
	  at org.apache.lucene.index.IndexWriter.shutdown(IndexWriter.java:1117)
	  at org.apache.lucene.index.IndexWriter.close(IndexWriter.java:1162)
	  at io.swimmingsand.study.IndexingBoost.test(IndexingBoost.java:110)
	  at io.swimmingsand.study.IndexingBoost.main(IndexingBoost.java:191)
```


FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/_0.fdx")


FSIndexOutput
|
OutputStreamIndexOutput
|
BufferedOutputStream
|
CheckedOutputStream
|
FilterOutputStream
|
Channels$OutputStream
|
FileChannelImpl
|
MMapDirectory@/Users/zlq/Projects/oss/lucene-solr/index lockFactory=org.apache.lucene.store.NativeFSLockFactory@724af044


FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/index/_0.fdt")

FSIndexOutput
|
OutputStreamIndexOutput
|
BufferedOutputStream
|
CheckedOutputStream
|
FilterOutputStream
|
Channels$OutputStream
|
FileChannelImpl
|
MMapDirectory@/Users/zlq/Projects/oss/lucene-solr/index lockFactory=org.apache.lucene.store.NativeFSLockFactory@724af044




## 文件内容

codecNameIdx=Lucene50StoredFieldsFastIndex

codecNameDat=Lucene50StoredFieldsFastData


si.getId()

result = {byte[16]@1321} 
 0 = -56
 1 = 50
 2 = -53
 3 = -27
 4 = -115
 5 = -1
 6 = 90
 7 = 54
 8 = -103
 9 = -34
 10 = 41
 11 = 96
 12 = 48
 13 = 48
 14 = 84
 15 = -29

org/apache/lucene/store/DataOutput.java对数据进行编码

写单个字节
public abstract void writeByte(byte b)

|<--8位-->|

写字节数组
public void writeBytes(byte[] b, int length)

|<--8位-->|<--8位-->|...|

写字节数组的一部分
public abstract void writeBytes(byte[] b, int offset, int length)

|<--8位-->|<--8位-->|...|

使用4个字节写整型数字
高位在前
public void writeInt(int i)

|<--8位-->|<--8位-->|<--8位-->|<--8位-->|

使用2个字节写短整型数字
高位在前
public void writeShort(short i)

|<--8位-->|<--8位-->|

使用变长字节数写整型数字
支持负数，但避免使用
public final void writeVInt(int i)

每个字节的最高位用于指示是否后续是否还有字节
低位的7比特先写

Value Byte 1 Byte 2 Byte 3 Byte 4 Byte 5
0 00000000
1 00000001
2 00000010
...
127 01111111
128 10000000 00000001
129 10000001 00000001
130 10000010 00000001
...
16,383 11111111 01111111
16,384 10000000 10000000 00000001
16,385 10000001 10000000 00000001
134217728 10000000 10000000 10000000 01000000
2147483648 10000000 10000000 10000000 10000000 00001000
000010000000000000000000000000000000


0x7F =0b01111111
~0x7F=0b10000000
0x80 =0b10000000

每次取低位区的7个比特位，头部根据是否已经取完补0或1，组成一个8位字节

zig-zag编码写整型数字
适合小有符号整数
public final void writeZInt(int i)

将最高位的符号位移动到最低位，然后再用writeVInt存储


8字节写长整型数字
public void writeLong(long i)

变长字节数写长整型数字
不支持负数
public final void writeVLong(long i)


变长编码写有符号数
private void writeSignedVLong(long i)

zig-zag变长编码长整型
通常用于小的有符号数
public final void writeZLong(long i)

将最高位的符号位移动到最低位，然后再用writeVLong存储

utf-8编码写入字符串
public void writeString(String s)

字符串-字符串关联对写入
public void writeMapOfStrings(Map<String,String> map)

写入字符串集合
public void writeSetOfStrings(Set<String> set)

### 文件头内容

org/apache/lucene/codecs/CodecUtil.java工具写文件头内容

CODEC_MAGIC=1071082519 writeInt
codec=Lucene50StoredFieldsFastIndex writeString