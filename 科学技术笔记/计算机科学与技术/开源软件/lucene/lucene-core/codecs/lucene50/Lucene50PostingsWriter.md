Lucene50PostingsWriter

Lucene50PostingsWriter --> PushPostingsWriterBase --> PostingsWriterBase

# 数据流图

```
org/apache/lucene/index/DefaultIndexingChain.java
private PerField[] fieldHash
 |
\|/

org/apache/lucene/index/DefaultIndexingChain.java
public void flush(SegmentWriteState state) throws IOException, AbortingException
 |
\|/

Map<String,TermsHashPerField> fieldsToFlush
 |
\|/

org/apache/lucene/index/FreqProxTermsWriter.java
public void flush(Map<String,TermsHashPerField> fieldsToFlush, final SegmentWriteState state) throws IOException;
 |
\|/

allFields按字段名称进行排序
List<FreqProxTermsWriterPerField> allFields
 |
\|/

FreqProxFields(allFields)
 |
\|/

FieldsWriter --> FieldsConsumer
FieldsWriter是在数据刷新到磁盘时创建。

```
"main@1" prio=5 tid=0x1 nid=NA runnable
  java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.codecs.perfield.PerFieldPostingsFormat$FieldsWriter.<init>(PerFieldPostingsFormat.java:113)
	  at org.apache.lucene.codecs.perfield.PerFieldPostingsFormat.fieldsConsumer(PerFieldPostingsFormat.java:335)
	  at org.apache.lucene.index.FreqProxTermsWriter.flush(FreqProxTermsWriter.java:104)
	  at org.apache.lucene.index.DefaultIndexingChain.flush(DefaultIndexingChain.java:134)
	  at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:443)
	  at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:539)
	  at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:653)
	  at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3364)
	  - locked <0x5d9> (a java.lang.Object)
	  at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3333)
	  at org.apache.lucene.index.IndexWriter.shutdown(IndexWriter.java:1117)
	  at org.apache.lucene.index.IndexWriter.close(IndexWriter.java:1162)
	  at BlockTreeTermsWriterStudy.indexGREWords(BlockTreeTermsWriterStudy.java:115)
	  at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-1)
	  at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	  at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	  at java.lang.reflect.Method.invoke(Method.java:497)
	  at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:45)
	  at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:15)
	  at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:42)
	  at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:20)
	  at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:263)
	  at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:68)
	  at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:47)
	  at org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)
	  at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)
	  at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)
	  at org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)
	  at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)
	  at org.junit.runners.ParentRunner.run(ParentRunner.java:300)
	  at org.junit.runner.JUnitCore.run(JUnitCore.java:157)
	  at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	  at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:51)
	  at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:237)
	  at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
```
org.apache.lucene.codecs.perfield.PerFieldPostingsFormat.FieldsWriter
public void write(Fields fields) throws IOException;
 |
\|/

Map<PostingsFormat,FieldsGroup> formatToGroups
 |
\|/

Fields maskedFields;按存储格式分成多个分组。Lucene6.2.1版本默认返回一个固定的存储格式PostingsFormat.forName("Lucene50")，即将所有字段分成一个组。
 |
\|/

BlockTreeTermsWriter --> FieldsConsumer
org/apache/lucene/codecs/lucene50/Lucene50PostingsFormat.java的public FieldsConsumer fieldsConsumer(SegmentWriteState state) throws IOException方法创建Lucene50PostingsWriter（继承PostingsWriterBase）和BlockTreeTermsWriter（继承FieldsConsumer），最后返回BlockTreeTermsWriter。
Lucene50PostingsWriter初始化时创建doc,pos,pay文件。BlockTreeTermsWriter初始化时创建tim,tip文件。
org/apache/lucene/codecs/blocktree/BlockTreeTermsWriter.java
public void write(Fields fields) throws IOException;
 |
\|/

Terms terms。以字段为单元循环，对每个字段得到一个terms。
 |
\|/

TermsEnum termsEnum。从terms获得字段词条迭代器。
 |
\|/

BytesRef term。以字段的词条为单元循环，得到字段的词条term。
 |
\|/

org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter.TermsWriter
public void write(BytesRef text, TermsEnum termsEnum) throws IOException;
 |
\|/

BytesRef text
 |
\|/

public final BlockTermState writeTerm(BytesRef term, TermsEnum termsEnum, FixedBitSet docsSeen) throws IOException;
 |
\|/

对一个term，取出其文档列表枚举器。
org.apache.lucene.index.FreqProxFields.FreqProxPostingsEnum#FreqProxPostingsEnum
private PostingsEnum postingsEnum;
 |
\|/

int docID。从postingsEnum枚举出文档ID。
 |
\|/

org/apache/lucene/codecs/lucene50/Lucene50PostingsWriter.java
public void startDoc(int docID, int termDocFreq) throws IOException;
```


Lucene50PostingsWriter的IndexOutput docOut，IndexOutput posOut，IndexOutput payOut三个属性字段代表实际的数据文件。

startDoc方法中docDeltaBuffer和freqBuffer写入到docOut中。

addPosition方法中posDeltaBuffer写入到posOut。payloadLengthBuffer、payloadByteUpto和payloadBytes写入到payOut。offsetStartDeltaBuffer和offsetLengthBuffer写入到payOut。

finishTerm方法中将skipWriter中的数据写入到docOut。

finishTerm方法设置BlockTermState的值。

```
state.docStartFP = docStartFP;
state.posStartFP = posStartFP;
state.payStartFP = payStartFP;
state.singletonDocID = singletonDocID;
state.skipOffset = skipOffset;
state.lastPosBlockOffset = lastPosBlockOffset;
```

# writeTerm

PushPostingsWriterBase的方法

public final BlockTermState writeTerm(BytesRef term, TermsEnum termsEnum, FixedBitSet docsSeen) throws IOException;

startTerm

startDoc（每个doc执行一次）

addPosition（每个doc执行一次）

finishDoc（每个doc执行一次）

finishTerm

输入参数说明

```
term [61 62 61 63 75 73] abacus
termsEnum 类型为org.apache.lucene.index.FreqProxFields.FreqProxTermsEnum。字段关联的字段值枚举器，可以从termsEnum获得倒排列表枚举器。
docsSeen 用来收集写入的doc。TermsWriter的一个属性字段，一个文档的字段就会生成一个TermsWriter对象，里面创建docsSeen对象。
```

调用栈

```
java.lang.Thread.State: RUNNABLE
	  at org.apache.lucene.codecs.PushPostingsWriterBase.writeTerm(PushPostingsWriterBase.java:121)
	  at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter$TermsWriter.write(BlockTreeTermsWriter.java:871)
	  at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter.write(BlockTreeTermsWriter.java:344)
	  at org.apache.lucene.codecs.perfield.PerFieldPostingsFormat$FieldsWriter.write(PerFieldPostingsFormat.java:198)
	  at org.apache.lucene.index.FreqProxTermsWriter.flush(FreqProxTermsWriter.java:107)
	  at org.apache.lucene.index.DefaultIndexingChain.flush(DefaultIndexingChain.java:134)
	  at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:443)
	  at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:539)
	  at org.apache.lucene.index.DocumentsWriter.flushAllThreads(DocumentsWriter.java:653)
	  at org.apache.lucene.index.IndexWriter.doFlush(IndexWriter.java:3364)
	  - locked <0x5f0> (a java.lang.Object)
	  at org.apache.lucene.index.IndexWriter.flush(IndexWriter.java:3333)
	  at org.apache.lucene.index.IndexWriter.shutdown(IndexWriter.java:1117)
	  at org.apache.lucene.index.IndexWriter.close(IndexWriter.java:1162)
	  at BlockTreeTermsWriterStudy.indexGREWords(BlockTreeTermsWriterStudy.java:115)
	  at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-1)
	  at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	  at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	  at java.lang.reflect.Method.invoke(Method.java:497)
	  at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:45)
	  at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:15)
	  at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:42)
	  at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:20)
	  at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:263)
	  at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:68)
	  at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:47)
	  at org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)
	  at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)
	  at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)
	  at org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)
	  at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)
	  at org.junit.runners.ParentRunner.run(ParentRunner.java:300)
	  at org.junit.runner.JUnitCore.run(JUnitCore.java:157)
	  at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	  at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:51)
	  at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:237)
	  at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)

```

# public void startTerm()

```
docOut=FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/data/indexGREWords/_0_Lucene50_0.doc")
docStartFP=94

posStartFP=FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/data/indexGREWords/_0_Lucene50_0.pos")
posStartFP=61

payOut=FSIndexOutput(path="/Users/zlq/Projects/oss/lucene-solr/data/indexGREWords/_0_Lucene50_0.pay")
payStartFP=61

lastDocID=0
lastBlockDocID=-1

skipWriter.resetSkip();
```

# public void startDoc(int docID, int termDocFreq)方法

FSIndexOutput(path="/Users/zlq/Projects/zlq/lucene-study/target/test-classes/testIndexLucene50/_2_Lucene50_0.doc")

bytesWritten=13394

数据存储格式

docDeltaBuffer 13394->13395

	如果所有值相等
	ALL_VALUES_EQUAL Byte

	int[] data中的data[0] VInt

	如果所有值不相等

	numBits Byte

	int[] data 用BulkOperationPacked编码后的数据，以字节数组格式写入doc文件

freqBuffer 13395->13493

	如果所有值相等
	ALL_VALUES_EQUAL Byte

	int[] data中的data[0] VInt

	如果所有制不相等

	numBits Byte

	int[] data 用BulkOperationPacked编码后的数据，以字节数组格式写入doc文件

# addPosition方法

FSIndexOutput(path="/Users/zlq/Projects/zlq/lucene-study/target/test-classes/testIndexLucene50/_2_Lucene50_0.pos")

数据存储格式

posDeltaBuffer 43118->43120
	如果所有值相等
	ALL_VALUES_EQUAL Byte

	int[] data中的data[0] VInt

	如果所有制不相等

	numBits Byte

	int[] data 用BulkOperationPacked编码后的数据，以字节数组格式写入pos文件

FSIndexOutput(path="/Users/zlq/Projects/zlq/lucene-study/target/test-classes/testIndexLucene50/_2_Lucene50_0.pay")

数据存储格式

payloadLengthBuffer 631502->631503

	如果所有值相等
	ALL_VALUES_EQUAL Byte

	int[] data中的data[0] VInt

	如果所有制不相等

	numBits Byte

	int[] data 用BulkOperationPacked编码后的数据，以字节数组格式写入pos文件

payloadByteUpto VInt

payloadBytes byte[payloadByteUpto]

offsetStartDeltaBuffer

	如果所有值相等
	ALL_VALUES_EQUAL Byte

	int[] data中的data[0] VInt

	如果所有制不相等

	numBits Byte

	int[] data 用BulkOperationPacked编码后的数据，以字节数组格式写入pos文件

offsetLengthBuffer
	
	如果所有值相等
	ALL_VALUES_EQUAL Byte

	int[] data中的data[0] VInt

	如果所有制不相等

	numBits Byte

	int[] data 用BulkOperationPacked编码后的数据，以字节数组格式写入pos文件


倒排索引文档列表存储格式数据例子

docStartFP，posStartFP，payStartFP，singletonDocID，skipOffset，lastPosBlockOffset

第一个词的文件内容位置
94，61，61，-1，23，4

第二个词的文件内容位置
124，65，1101，-1，151，4