# 写数据

## 1 写已知类型（writeKnownType）

### 1.1 写原始类型（writePrimitive）

#### 写空值（null）
一个表示0的字节
00000000

#### 写字符串（writeStr）

write the string as tag+length, with length being the number of UTF-8 bytes


##### 空字符串（null）

写一个空tag
00000000

##### 非空字符串（s）

对s进行UTF-8编码，编码后的数据放入bytes，编码后的字节数放入sz

* 1 先写入一个STR tag

STR tag是第二类tag，字节的后5位用来保存tag对应的数据的长度

长度小于31，0 <= sz < 31，字节的后5位用来保存tag对应的数据的长度够用

长度大于或等于31，字节的后5位用来保存tag对应的数据的长度的31位，多出的长度用一个变长的数字保存在tag的随后字节里

writeVInt

0x7F  0111 1111

~0x7F 1000 0000

0x80  1000 0000

int i

  i
& 0x7F

| 0x80

保存低7位，结果为1 xxx xxxx

去掉低7位，判断这次保存为低7位的值后是否还有字节数

* 2 写入一个STR tag对应的数据到随后的字节数

#### 写入数字（Number）

##### 写入整数（Integer）

writeInt方法
```
public void writeInt(int val) throws IOException 
```

* 1 val>0，写入的值为正整数
SINT 0100 0000

0x0f 0000 1111

  * val >= 15

0x10 0001 0000

( SINT | (val & 0x0f) ) | 0x10


例子：val = 15
```
15 0000 1111

  0000 1111

& 0000 1111

  0000 1111

| 0100 0000

  0100 1111

| 0001 0000

  0101 1111

 0x5f

 010 1 1111

 15 + 0*16

```

例子：val = 16
```
16 0001 0000

  0001 0000

& 0000 1111

  0000 0000

| 0100 0000

  0100 0000

| 0001 0000

  0101 0000

最后4位去掉得到数值用一个变长整数表示

编码后的数据 [0001 0110 0001的变长整数表示]

010 1 0110

0 + 1 * 16

```

例子：val = 17
```
17 0001 0001

  0001 0001

& 0000 1111

  0000 0001

| 0100 0000

  0000 0001

| 0101 0001

  0001 0001

最后4位去掉得到数值用一个变长整数表示

编码后的数据 [0001 0111 0001的变长整数表示]

1 + 1*16

```

例子：val = 31
```
31 0001 1111

  0001 1111

& 0000 1111

  0000 1111

| 0100 0000

  0000 1111

| 0001 1111

  0001 1111

最后4位去掉得到数值用一个变长整数表示

编码后的数据 [0001 1111 0001的变长整数表示]

15 + 1 * 16

```

  * 0 <= val < 15

用1个字节表示

SINT | (val & 0x0f)

前4位位类型tag，后4位为数值

* 2 val <= 0，写入的值为0或负整数

写入INT tag

在FastOutputStream的buf中预留好4个字节空间

第一个字节写入高8位，第二字节吸入第二个8位，第三个字节写入第三个8位，第四个字节写入第4个8位


##### 写入长整数（Long）

```
public void writeLong(long val) throws IOException;

1111 1111 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000
```

* 1 高位8个位全为0

```
1111 1111 xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx xxxx

0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 1111 0x0f

0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0110 0000 0x60 SLONG
```

val >= 15

分两部分保存，first + 16*second

val < 15

用1个字节保存

* 2 高位8个位不全为0

取值范围有部分整数和负数

两部分保存，1个字节LONG tag + 8字节数据流

##### 写入浮点数（Float）

两部分保存，1个字节FLOAT tag + 浮点数转换成int的原始字节数据流

##### 写入双精度浮点数（Double）

两部分保存，1个字节DOUBLE tag + 双精度浮点数转换成int的原始字节数据流

##### 写入字节类型整数（Byte）

两部分保存，1个字节BYTE tag + 1字节数据流

##### 写入短整型整数（Short）

两部分保存，1个字节SHORT tag + 2字节数据流


#### 写入日期（Date）

两部分保存，1个字节DATE tag + 将Date类型转换成毫秒数（long），8字节数据流

#### 写入布尔值（Boolean）

* true

1个字节 BOOL_TRUE tag

* false

1个字节 BOOL_FALSE tag

#### 写入字节数组（byte[]）

两部分保存，1个字节BYTEARR tag + byte数组

#### 写入字节缓冲池（ByteBuffer）

将ByteBuffer的数据转换成byte数组，然后采用写入字节数组（byte[]）的方法保存


#### 写入结束对象（END_OBJ）

1个字节 END tag

### 1.2 写命名列表（NamedList）
```
public void writeNamedList(NamedList<?> nl) throws IOException;
```

先写入tag

如果是SimpleOrderedMap，写入ORDERED_MAP tag，否则，写入NAMED_LST tag

对命名列表中得每个名称-值对，先写名字，再写值

写名字的方法为

```
public void writeExternString(String s) throws IOException;
```

使用一个字符串-数字映射表stringsMap保存到目前为止已经写过的名称

s == null

写入NULL tag

s != null

先在stringsMap中按名称查找对应的索引idx

未找到，idx=0

写入EXTERN_STRING tag，idx数值保存在字节的后4位

如果 idx == 0，写入名称，将改字符串放入stringsMap，映射的idx=stringsCount + 1

写值的方法为

```
public void writeVal(Object val) throws IOException;
```

已知类型，调用writeKnownType方法

未知类型

* 如果有ObjectResolver，用它来解析，将未知类型的对象解析成已知类型，调用writeKnownType方法

* 如果没有ObjectResolver或ObjectResolver不能解析出未知类型，写入"类名 + : + 对象的toString方法返回的值"

### 1.3 写Solr文档列表（SolrDocumentList）

* 写入SOLRDOCLST tag

* 写入值

SolrDocumentList有3个属性，分别为numFound（long），start（long），maxScore（Float），且继承了ArrayList，具备列表的特性

  * 将3个属性值加入到Number列表，调用writeArray

```
public void writeArray(List l) throws IOException;
```

先写入ARR tag，数组大小写入tag的后4位

对每一个值，调用writeVal方法

  * solrDocumentList 就是一个SolrDocument列表，调用writeArray

```
public void writeArray(List l) throws IOException;
```

先写入ARR tag，数组大小写入tag的后4位

对每一个值，调用writeVal方法

### 1.4 写集合（Collection）

```
public void writeArray(Collection coll) throws IOException;
```

先写入ARR tag，集合大小写入tag的后4位

对每一个值，调用writeVal方法

### 1.5 写对象数组（Object[]）

```
public void writeArray(Object[] arr) throws IOException;
```

先写入ARR tag，对象数组大小写入tag的后4位

对每一个值，调用writeVal方法

### 1.6 写Solr文档（SolrDocument）

* 对象解析器ObjectResolver为null

```
public void writeSolrDocument(SolrDocument doc) throws IOException;
```

写入SOLRDOC tag

写入ORDERED_MAP tag，SolrDocument的大小放入随后的字节

对每一个doc字段，调用writeExternString写键，调用writeVal写值

* 对象解析器ObjectResolver不为null

  * 能够解析出来

解析出来的对象为SolrDocument类型，调用writeSolrDocument方法

解析出来的对象不是SolrDocument类型，调用writeVal方法

  * 不能够解析出来

什么都不做

### 1.7 写Solr输入文档（SolrInputDocument）

SolrInputDocument有3个属性，分别为_fields（Map<String,SolrInputField>），_documentBoost（float），_childDocuments（List<SolrInputDocument>）

计算数据大小sz，字段数+子文档字段数

写SOLRINPUTDOC，带上大小sz，调用writeTag

写_documentBoost，调用writeFloat

对每个字段：
如果字段有boost，写boost，调用writeFloat

写字段名称，调用writeExternString
写字段值，调用writeVal

如果有子文档列表，对每个子文档，调用writeSolrInputDocument

### 1.8 写映射表（Map）

写MAP tag，带上Map的大小

对Map的每个条目：
先写键，如果键为String，调用writeExternString，否则，调用writeVal
再写值，调用writeVal


### 1.9 写迭代器（Iterator）

写ITERATOR tag

对迭代器的每个元素，调用writeVal

写END_OBJ tag

### 1.10 写可迭代对象（Iterable）

获取其迭代器，调用writeIterator

### 1.11 写枚举字段值（EnumFieldValue）

写ENUM_FIELD_VALUE tag

将枚举字段值转换成整数，调用writeInt
将枚举字段值转换成字符串，调用writeStr


### 1.12 写映射表的条目（Map.Entry）

写MAP_ENTRY tag

获取键，调用writeVal
获取值，调用writeVal


## 2 写ObjectResolver能解析的类型

够能解析出来，调用writeKnownType

不能够解析出来，什么都不做

## 3 写未知类型及没有ObjectResolver解析器的类型

writeVal(val.getClass().getName() + ':' + val.toString());






























