FST

FST.INPUT_TYPE

FST.Arc

FST.BytesReader --> org.apache.lucene.store.DataInput

FST.NodeAndInCount

FST.NodeQueue --> org.apache.lucene.util.PriorityQueue（抽象）

###############################################################################

Builder

Builder.Node（接口）

<-- Builder.UnCompiledNode

<-- CompiledNode

Buidler.Arc

Buidler聚合了如下类的对象

NodeHash

FST

###############################################################################

FSTEnum（抽象） 

<-- BytesRefFSTEnum

<-- IntsRefFSTEnum


FSTEnum.InputOutput

###############################################################################

FST 聚合如下类的对象

BytesStore


###############################################################################

Outputs（抽象）

<-- PositiveIntOutputs

<-- PairOutputs

<-- NoOutputs

<-- IntSequenceOutputs

<-- ByteSequenceOutputs

<-- CharSequenceOutputs

###############################################################################

FST.BytesReader 

<-- ReverseBytesReader

<-- ForwardBytesReader





方法调用例子

add(IntsRef input, T output)


```
at org.apache.lucene.util.fst.Builder.add(Builder.java:334)
at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter$PendingBlock.compileIndex(BlockTreeTermsWriter.java:453)
at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter$TermsWriter.writeBlocks(BlockTreeTermsWriter.java:621)
at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter$TermsWriter.finish(BlockTreeTermsWriter.java:913)
at org.apache.lucene.codecs.blocktree.BlockTreeTermsWriter.write(BlockTreeTermsWriter.java:338)
at org.apache.lucene.codecs.perfield.PerFieldPostingsFormat$FieldsWriter.write(PerFieldPostingsFormat.java:198)
at org.apache.lucene.index.FreqProxTermsWriter.flush(FreqProxTermsWriter.java:107)
at org.apache.lucene.index.DefaultIndexingChain.flush(DefaultIndexingChain.java:112)
at org.apache.lucene.index.DocumentsWriterPerThread.flush(DocumentsWriterPerThread.java:420)
at org.apache.lucene.index.DocumentsWriter.doFlush(DocumentsWriter.java:512)
at org.apache.lucene.index.DocumentsWriter.postUpdate(DocumentsWriter.java:382)
at org.apache.lucene.index.DocumentsWriter.updateDocument(DocumentsWriter.java:475)
at org.apache.lucene.index.IndexWriter.updateDocument(IndexWriter.java:1350)
at org.apache.lucene.index.IndexWriter.addDocument(IndexWriter.java:1138)
at io.github.swimmingsand.lucene.IndexTest.testIndexLucene50(IndexTest.java:202)
at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-1)
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.lang.reflect.Method.invoke(Method.java:606)
at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:74)
at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:211)
at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:67)
```

