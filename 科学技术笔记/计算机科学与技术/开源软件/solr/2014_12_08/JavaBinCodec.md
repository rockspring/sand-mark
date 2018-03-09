# 读数据

	date：2014-12-08

JavaBinCodec的入口函数

```
public void marshal(Object nl, OutputStream os) throws IOException;
```

* 读出第一个字节，即版本号，调用方法readByte

* 比较版本号，不匹配，抛出运行时异常

* 读出对象值，调用readVal

readVal方法首先读出数据类型，类型保存在一个字节里，命名为tagByte，根据tagByte调用不同的方法解码出对象值

## 1 类型和大小保存在单个字节的情形

STR、SINT、SLONG、ARR、ORDERED_MAP、NAMED_LST、EXTERN_STRING

超过31的长度保存在随后的变长整数里

### 1.1 解码出字符串（String）

* 读出字符串长度
	* 取出tagByte后5位并计算出其整数值sz
	* 如果sz为31，则后面还有一个变长的整数也是字符串长度的一部分

* 读sz长度的字节到字节数组bytes

* 将读出的字节数组转换成UTF-16的字符数组

* 将字符数组转换成字符串

### 1.2 解码出小整数（int）

v + 16 * vInt 

* 取出tagByte后4位并转换成整数

* 检查倒数第5位是否为1，如果为1，则还有一个变长的整数vInt，否则没有变长的整数vInt

### 1.3 解码出小长整数（long）

v + 16 * vLong

* 取出tagByte后4位并转换成整数

* 检查倒数第5位是否为1，如果为1，则还有一个变长的整数vLong，否则没有变长的整数vLong

### 1.4 解码出对象列表（List<Object>）

* 读出列表长度
	* 取出tagByte后5位并计算出其整数值sz
	* 如果sz为31，则后面还有一个变长的整数也是列表长度的一部分

* 依次解码出sz个对象值，调用readVal方法

### 1.5 解码出有序映射表（SimpleOrderedMap<Object>）

* 读出有序映射表长度
	* 取出tagByte后5位并计算出其整数值sz
	* 如果sz为31，则后面还有一个变长的整数也是有序映射表长度的一部分

* 依次解码出sz个名称-取值对，先调用readVal方法解码出名称，再调用readVal方法解码出取值

### 1.6 解码出命名列表（NamedList<Object>）

* 读出命名列表长度
	* 取出tagByte后5位并计算出其整数值sz
	* 如果sz为31，则后面还有一个变长的整数也是命名列表长度的一部分

* 依次解码出sz个名称-取值对，先调用readVal方法解码出名称，再调用readVal方法解码出取值

### 1.7 解码出额外字符串（String）

* 读出额外字符串在stringsList中得索引值
	* 取出tagByte后5位并计算出其整数值sz
	* 如果sz为31，则后面还有一个变长的整数也是索引值的一部分

* 如果idx不为0，则根据索引idx-1去stringsList取出其对应的值，否则，从接下来的字节中解码出一个对象，调用readVal，并将对象添加到stringsList



## 2 单个字节的标记（tag）中不包含长度信息

### 2.1 解码出空值（NULL）

值为null

### 2.2 解码出日期（DATE）

* 解码出长整形的数值，毫秒数，调用readLong

* 用这个毫秒数构造一个Date对象

### 2.3 解码出整数（INT）

* 解码出整形的数值，毫秒数，调用readInt

### 2.4 解码出布尔值真（BOOL_TRUE）

值为Boolean.TRUE

### 2.5 解码出布尔值假（BOOL_FALSE）

值为Boolean.FALSE

### 2.6 解码出浮点数（FLOAT）

* 解码出浮点数，调用readFloat

	* 解码出浮点数对应的整数表示，调用readInt

	* 将浮点数的整数表示转换成浮点数

### 2.7 解码出双精度浮点数（DOUBLE）

* 解码出双精度浮点数，调用readDouble

	* 解码出双精度浮点数对应的整数表示，调用readLong

	* 将浮点数的长整数表示转换成双精度浮点数

### 2.8 解码出长整形整数（LONG）

* 解码出长整形整数，调用readLong

	* 依次从高位到低位读出8个字节值，调用readUnsignedByte

### 2.9 解码出字节型整数（BYTE）

* 解码出一个字节

### 2.10 解码出短整形整数（SHORT）

* 解码出短整形整数，调用readLong

	* 依次从高位到低位读出2个字节值，调用readUnsignedByte

### 2.11 解码出映射表（MAP）

* 解码出Map的大小sz，调用readVInt

* 依次解码出sz个键-值对，先调用readVal方法解码出键，再调用readVal方法解码出值

### 2.12 解码出Solr文档对象（SOLRDOC）

* 解码出命名列表nl

* 根据nl的大小，依次从nl中取出字段名-值对，构造SolrDocument对象

### 2.13 解码出Solr文档列表（SOLRDOCLST）

调用readSolrDocumentList方法

* 解码出一个对象列表，3个值，分别为numFound、start、maxScore

* 解码出一个对象列表，为SolrDocument列表

### 2.14 解码出字节数组（BYTEARR）

* 解码出字节数组的长度len

* 读取len个字节

### 2.15 解码出迭代器（ITERATOR）

解码出对象，调用readVal，直到解码出的对象为END_OBJ为止

### 2.16 解码出对象结束符（END）

值为END_OBJ

### 2.17 解码出Solr输入文档（SOLRINPUTDOC）

* 解码出文档字段个数sz，调用readVInt

* 解码出文档的docBoost，调用readVal

* 循环解码sz次

	* 解码出一个对象obj，调用readVal
	* 如果obj为Float类型，则为字段的boost值，再解码出一个对象，这个对象为fieldName；如果obj为SolrInputDocument类型，obj为子文档列表，继续下一次解码；如果不是前两种类型，解码出对象，这个对象为fieldName
	* 解码出字段值

### 2.18 解码出枚举类型的字段值（ENUM_FIELD_VALUE）

* 解码出整数值，调用readVal

* 解码出字符串，调用readVal

### 2.19 解码出映射表的条目（MAP_ENTRY）

* 解码出键，调用readVal

* 解码出值，调用readVal
