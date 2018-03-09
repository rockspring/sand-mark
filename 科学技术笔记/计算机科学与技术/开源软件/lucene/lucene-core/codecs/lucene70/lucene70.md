# Apache Lucene - Index File Formats - Lucene 7.0 file format. 

2018年3月5日

## 1 Introduction

这个文档定义了Lucene当前版本的索引文件格式。

这个文档试图提供一个Lucene文件格式的高层定义。

## 2 Definitions

Lucene的基本概念是索引，文档，字段和词项。

一个索引包含一系列文档。

	一个文档是一系列字段。
	一个字段是一系列词项。
	一个词项是一系列字节。

在两个不同的字段中同样的字节序列被认为是不同的词项。因此词项被表示为一个对偶：字段的名称和在这个字段中的字节序列。

### 2.1 Inverted Indexing

为了使得基于词项的搜索更加高效，索引存储词项的统计信息。Lucene的索引归类到被称为倒排索引的索引家族。这是因为这种倒排索引能够列出包含一个词项的所有文档。这是文档到词项的自然关系的反向关系，在自然关系中文档列出词项。

### 2.2 Types of Fields

在Lucene中，字段可能会被存储，这种情况下字段文本以非倒排索引方式存储在索引中。字段被倒排索引处理后称之为被索引了。一个字段同时可以被存储和索引。

一个字段的文本可能被分割成一系列词项，每一个词项可以被索引。一个字段的文本也可以直接被当做一个词项被索引。大多数字段被分割，但有时候把标识字段当成一个词项被索引很有用。

点击 https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/document/Field.html 查看更多字段有关的信息。

### 2.3 Segments

一个索引可能是由几个子索引或者索引段组成。每一个段是一个完全独立的索引，它能够被单独搜索。索引设计如下两方面：

1，为新加的文档创建新索引段。

2，合并已经存在的索引段。

搜索可能设计多个索引段或多个索引，每一个索引可能由一个索引段集合组成。

### 2.4 Document Numbers

系统内部，Lucene通过一个文档编码的数字引用文档。第一个添加到索引的文档编码为0，后续添加的文档依次比前面添加的文档编号大1。

注意文档的编号可能会变化，所以当在Lucene索引外部存储这些数字时要特别小心。特别第注意，如下情形文档编号可能发生变化：

存储在每一个索引段中的数字编码仅仅在索引段内唯一，并且在更大的上下文中使用时必须被转换。标准的技术方法是基于在索引中使用的数字区间给每一个索引段分配一个数值区间。把一个索引段中的文档编号转换成外部值时，要加上索引段的基底文档编号。把一个外部文档编号还原成由外部文档编号值区间区分的索引段中特定的文档编号时，要减去索引段的基底文档编号。举个例子，有两个数量为5的索引段要合并，第一个索引段有一个基底值0，第二个索引段有一个基底值5。第二个索引段中的文档编号为3的文档在索引段合并之后编号为8。

当文档被删除时，在数字编号中创建间隙。他们在索引被合并时最终被移除。删除的文档在索引段被合并时被丢去。一个刚刚合并出来的索引段在数字编号上没有间隙。

## 3 Index Structure Overview

每一个索引段维护如下内容：

[Segment info](https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/codecs/lucene62/Lucene62SegmentInfoFormat.html) 它包含一个索引段的元数据，如文档数量，使用了哪些文件。

[Field names](https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/codecs/lucene50/Lucene50FieldInfosFormat.html) 它包含索引中使用的字段名称集合。

[Stored Field values](https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/codecs/lucene50/Lucene50StoredFieldsFormat.html) 对每一个文档，它包含一个属性-属性值对偶，其中属性是字段名称。这些用于存储文档的辅助信息，如标题，URL和访问数据库的唯一标识。当搜索时每一个命中的文档返回的字段值来自存储字段集合。存储字段集合通过文档唯一标识符与文档关联。

[Term dictionary](https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/codecs/lucene50/Lucene50PostingsFormat.html) 一个词典包含了所有文档的所有索引字段的所有词项。词典也包含包含词项的文档编号和指向词项的频率（frequency）及词项的接近度（proximity）数据的指针。

[Term Frequency data](https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/codecs/lucene50/Lucene50PostingsFormat.html) 对词典中的每一个词项，存储包含那个词项的所有文档的数量和在那个文档中词项出现的频率数据。如果索引选项为IndexOptions.DOCS_ONLY，这些数据被忽略。

[Term Proximity data](https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/codecs/lucene50/Lucene50PostingsFormat.html) 对词典中的每一个词项，存储其在每一个文档中出现的位置。如果索引选项忽略位置，这些数据被忽略。

[Normalization factors](https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/codecs/lucene70/Lucene70NormsFormat.html) 对每个文档的每一个字段，存储一个值，在命中这个字段时乘进分数。

[Term Vectors](https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/codecs/lucene50/Lucene50TermVectorsFormat.html) 对每个文档的每个字段，词向量（有时也叫文档向量）可能被存储。一个词向量有词项文本和词项频率组成。查看Field的构造函数了解如何添加词向量。

[Per-document values](https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/codecs/lucene70/Lucene70DocValuesFormat.html) 跟存储字段一样，也是以文档编号为主键，不同之处在于它为了快速访问把数据加载到主存中。存储字段通常用于来自搜索的概要结果。文档特定值用于打分时读取。

[Live documents](https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/codecs/lucene50/Lucene50LiveDocsFormat.html) 一个可选文件指示哪些文档是活跃的。

[Point values](https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/codecs/lucene60/Lucene60PointsFormat.html) 可选文件，记录多维索引字段，适用于快速数字区间过滤和超大数字（BigInteger和BigDecimal (1D) ）和几何图形求交集（2D, 3D）。

## 4 File Naming

属于一个段的所有文件有同样的名称，不同的扩展名。扩展名对应到不同的文件格式。当使用复合文件格式时（对小的段默认启用），除了段信息文件、锁文件、删除文档文件，其它文件被收纳进一个单一的.cfs文件。

通常，所有的段存储在单个目录下。然而，这不是必须的。

文件名称绝不会被重用。也就是说，当往目录中存储任何文件时，文件名称从未被使用过。这是通过一个简单的生成方式获得的。例如，第一个索引段文件使用 segments\_1，然后第二索引段使用segments\_2，等等以此类推。索引代是一个36进制的整数序列。

## 5 Summary of File Extensions

以下表格概括了Lucene中文件的名称和扩展名。

```
Name 	Extension 	Brief Description

Segments File 	segments_N 	存储一个提交点的信息
Lock File 	write.lock 	写入锁文件阻止多个IndexWriter往同样的文件中写入。
Segment Info 	.si 	存储索引段的元数据。
Compound File 	.cfs, .cfe 	一个虚拟的文件，包含了其他索引文件，防止出现文件勾本不够用的情况。
Fields 	.fnm 	存储字段的信息。
Field Index 	.fdx 	存储字段数据的指针。
Field Data 	.fdt 	存储文档字段。
Term Dictionary 	.tim 	词典，存储词项信息。
Term Index 	.tip 	词典的索引。
Frequencies 	.doc 	存储包含一个词项的文档列表及频率信息。
Positions 	.pos 	存储词项的位置信息。
Payloads 	.pay 	存储额外的位置相关的元数据如字符偏移量和用户自定义数据载荷。
Norms 	.nvd, .nvm 	为文档和字段的长度和提升因子编码。
Per-Document Values 	.dvd, .dvm 	为额外打分因子或每个文档的其它信息编码。
Term Vector Index 	.tvx 	存储文档数据文件的偏移量。
Term Vector Data 	.tvd 	存储词向量数据。
Live Documents 	.liv 	存储哪些文档是活跃的。
Point values 	.dii, .dim 	存储索引的空间点。
```
### 5.1 Lock File

锁文件，默认名称为“write.lock”，存储在索引目录中。如果锁目录不同于索引目录，锁文件的名称为“XXXX-write.lock”，其中XXXX从索引目录的全路径导出的唯一前缀。当这个文件存在时，一个writer正在修改索引（添加或删除文档）。锁文件确保一次仅有一个writer在修改索引。

### 5.2 History

在版本2.1，文件格式变化成允许无锁提交（没有提交锁）。这个变化完全向后兼容，你可以打开2.1之前的版本的索引，进行搜索和添加及删除文档。当新的索引段被保存时（提交），将以新的文件格式被写入。但是，一旦提交发生了，2.1之前的版本不能读取这个索引。

在2.3版本，文件格式变化成允许所有的索引段共享单个文档存储文件集合（词向量和存储字段）。这在特定场景下使得索引访问更快。这个变化完全向后兼容，方式与2.1版本变化时一样。

在2.4版本，字符串以真正的UTF-8字节序列写入，而不是Java修改后的UTF-8编码。详情查看[LUCENE-510](https://issues.apache.org/jira/browse/LUCENE-510)。

在2.9版本，一个类型为Map<String,String>，名称为CommitUserData，存储什么内容模糊不清的数据对象应该被传入到IndexWriter的提交方法，对象内容记录在segments_N文件中。查看[LUCENE-1382](http://issues.apache.org/jira/browse/LUCENE-1382)获取详情。还有，一些诊断信息被添加到每个索引段，记录什么原因索引被写入的（因为刷新、合并）和使用了什么操作系统和JRE。查看[LUCENE-1654](http://issues.apache.org/jira/browse/LUCENE-1654)获取详情。

在3.0版本，压缩的字段不再写入到索引（它们能够被读取，但是当合并时，以非压缩的方式写入到索引）。查看[LUCENE-1960](http://issues.apache.org/jira/browse/LUCENE-1960)获取更多详情。

在3.1版本，索引段记录了Lucene的code版本。查看[LUCENE-2720](http://issues.apache.org/jira/browse/LUCENE-2720)获取更多详情。另外，索引段显示地跟踪它们是否有词向量。查看[LUCENE-2811](http://issues.apache.org/jira/browse/LUCENE-2811)获取详情。

在3.2版本，数字字段以原生的方式写入到存储文件，之前它们是以文本的格式写入的。

在3.4版本，字段可以忽略位置信息的同时保存词项频率信息。

在4.0版本，倒排索引的格式可以通过[Codec](https://lucene.apache.org/core/7_2_1/core/org/apache/lucene/codecs/Codec.html) api扩展。快速的文档特定存储（DocValues）被引入。规范化因子不再必须是单个字节，它们可以是任何NumericDocValues。词项不必是Unicode字符串，它们可以是任何字节序列。词项偏移量可以选择被索引进倒排列表。用户数据负载可以被存储到词向量。

在4.1版本，倒排列表的格式变化成使用FOR压缩或变长字节数编码，具体使用哪个取决于词项的频率。仅仅出现一次的词项变化成内联到词典中。存储字段默认使用压缩方式存储。

在4.2版本，词向量默认使用压缩方式。DocValues有一个新的多值类型SortedSet，这可以用于多值字段的faceting/grouping/joining。

在4.5版本，DocValues被扩展成显示表示缺失的值。

在4.6版本，FieldInfos被扩展成支持字段特定的DocValues代，允许更新NumericDocValues字段。

在4.8版本，校验和脚部数据加入到每一个索引文件的尾部来提升数据完整性。特别要提到的是，每一个索引文件的最后8字节包含了文件的zlib-crc32校验和。

在4.9版本，DocValues有一个新的多值数字类型SortedNumeric，适用于faceting/sorting/analytics。

在5.4版本，DocValues被改进到可以在磁盘上存储更多信息：二进制字段的地址和多值字段的序号索引。

在6.0版本，Points被加入索引，用于多维数据的区间和距离搜索。

在6.2版本，引入新的索引段信息格式，支持索引排序。

在7.0版本，DocValues被改进到支持稀疏文档值，这归功于有了迭代器API。


### 5.3 Limitations

Lucene使用Java的int存储文档编号，索引文件格式中使用Int32存储文档的编号。这是对索引文件格式和当前的系统实现的一个限制。最终应该被UInt64或者更好的Vint（没有上限限制）替换。
