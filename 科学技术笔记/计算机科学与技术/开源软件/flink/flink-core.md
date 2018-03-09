## InputFormat

InputSplit

org.apache.flink.core.io.InputSplitSource

org.apache.flink.api.common.io.InputFormat

org.apache.flink.api.common.io.RichInputFormat

org.apache.flink.api.common.io.CheckpointableInputFormat 接口

org.apache.flink.api.common.io.FileInputFormat 抽象基类

org.apache.flink.api.common.io.BinaryInputFormat 抽象基类

org.apache.flink.api.common.io.SerializedInputFormat 具体类

org.apache.flink.api.java.io.TypeSerializerInputFormat 具体类

org.apache.flink.api.java.io.AvroInputFormat

org.apache.flink.api.common.io.DelimitedInputFormat 抽象基类

org.apache.flink.api.common.io.GenericCsvInputFormat 抽象基类

org.apache.flink.api.java.io.CsvInputFormat 抽象基类

org.apache.flink.api.java.io.PojoCsvInputFormat 具体类

org.apache.flink.api.java.io.RowCsvInputFormat 具体类

org.apache.flink.api.java.io.TupleCsvInputFormat 具体类

org.apache.flink.api.java.io.TextInputFormat

org.apache.flink.api.java.io.TextValueInputFormat

org.apache.flink.api.common.io.FileInputFormat#open方法打开一个FileInputSplit。

org.apache.flink.api.common.io.FileInputFormat.InputSplitOpenThread的run方法打开文件系统，输入参数为FileInputSplit。


org.apache.flink.api.common.operators.GenericDataSourceBase#executeOnCollections创建分片FileInputSplit。


org.apache.flink.runtime.operators.DataSourceTask#invoke使用Iterator<InputSplit>依次打开InputSplit并进一步处理。

## State

定义了状态接口，具体实现在runtime中。

org.apache.flink.api.common.state.State

org.apache.flink.api.common.state.MapState

org.apache.flink.api.common.state.ReducingState

org.apache.flink.api.common.state.StateDescriptor
org.apache.flink.api.common.state.MapStateDescriptor

## TypeInfo

org.apache.flink.api.common.typeinfo.TypeInfo

org.apache.flink.api.common.typeinfo.AtomicType

org.apache.flink.api.common.typeinfo.TypeInformation
org.apache.flink.api.common.typeinfo.BasicTypeInfo
org.apache.flink.api.common.typeinfo.NumericTypeInfo
org.apache.flink.api.common.typeinfo.IntegerTypeInfo
org.apache.flink.api.common.typeinfo.FractionalTypeInfo

org.apache.flink.api.common.typeinfo.NothingTypeInfo

org.apache.flink.api.common.typeinfo.PrimitiveArrayTypeInfo

org.apache.flink.api.common.typeinfo.SqlTimeTypeInfo

org.apache.flink.api.common.typeinfo.TypeHint

org.apache.flink.api.common.typeinfo.TypeInfoFactory

## TypeSerializer

org.apache.flink.api.common.typeutils.TypeSerializer
org.apache.flink.api.common.typeutils.base.TypeSerializerSingleton
org.apache.flink.api.common.typeutils.base.BigDecSerializer

org.apache.flink.api.common.typeutils.base.BigIntSerializer

org.apache.flink.api.common.typeutils.base.BooleanSerializer

org.apache.flink.api.common.typeutils.base.BooleanValueSerializer

org.apache.flink.api.common.typeutils.base.ByteSerializer

org.apache.flink.api.common.typeutils.base.ByteValueSerializer

org.apache.flink.api.common.typeutils.base.BasicTypeComparator

## DataInputView

内存上的视图，数据实际通常由MemorySegment支持。

java.io.DataInput
org.apache.flink.core.memory.DataInputView

## 类型org.apache.flink.types

org.apache.flink.core.io.IOReadableWritable

IOReadableWritable定义了类型的接口，数据可以通过DataOutputView视图写入或读取。

org.apache.flink.core.io.IOReadableWritable
org.apache.flink.types.Value
org.apache.flink.types.ResettableValue

ResettableValue定义数据类型对象的值是可以重新设置的。

org.apache.flink.types.Value
org.apache.flink.types.Key
org.apache.flink.types.NormalizableKey

Normalizable keys能够创建一个按字节比较的二进制表示。

org.apache.flink.core.io.IOReadableWritable
org.apache.flink.types.Value
org.apache.flink.types.CopyableValue

CopyableValue定义复制功能，使其数据能够高效复制。


org.apache.flink.types.BooleanValue
org.apache.flink.types.ByteValue
org.apache.flink.types.CharValue
org.apache.flink.types.DoubleValue
org.apache.flink.types.FloatValue
org.apache.flink.types.IntValue
org.apache.flink.types.LongValue
org.apache.flink.types.ShortValue
org.apache.flink.types.StringValue

org.apache.flink.types.Record

表示多值数据记录

org.apache.flink.types.Row

包含任意数量个字段

org.apache.flink.types.ListValue
org.apache.flink.types.MapValue

org.apache.flink.types.NullValue

org.apache.flink.types.Nothing

org.apache.flink.types.Either
org.apache.flink.types.Either.Left
org.apache.flink.types.Either.Right

org.apache.flink.types.JavaToValueConverter

FieldParser

org.apache.flink.types.parser.FieldParser
org.apache.flink.types.parser.BigDecParser

## common

org.apache.flink.api.common.Archiveable

## memory

代表一片由Flink管理的内存。

org.apache.flink.core.memory.MemoryType

org.apache.flink.core.memory.MemorySegment
org.apache.flink.core.memory.HeapMemorySegment
org.apache.flink.core.memory.HybridMemorySegment

直接管理的内存借助DirectByteBuffer去调用sun.misc.Unsafe#allocateMemory方法分配。

使用案例：org.apache.flink.runtime.io.network.buffer.NetworkBufferPool#NetworkBufferPool