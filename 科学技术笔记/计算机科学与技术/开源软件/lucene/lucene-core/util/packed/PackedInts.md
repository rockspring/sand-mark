PackedInts

整数打包格式

只支持正整数

最小值：0
最大值：2**63-1

## PACKED

### 版本

VERSION_START = 0
VERSION_BYTE_ALIGNED = 1
VERSION_MONOTONIC_WITHOUT_ZIGZAG = 2

版本号小于1时，64位对齐，打包的整数所占字节数为64的倍数

版本号大于或等于1时，8位对齐，打包的整数所占自己数为8的倍数

PackedWriter

flush方法

1 将缓存的值数组nextValues中的值经编码器编码后写入nextBlocks
2 将nextBlocks字节缓存写入DataOutput
3 将缓存数组nextValues填充0初始化

## PACKED_SINGLE_BLOCK

64位对齐

保存的整数不会横跨多个块

值的个数valueCount=10
每个值所占位数bitsPerValue=1

每个long块容纳的值个数valuesPerBlock=64/bitsPerValue

long块数longCount=ceil(valueCount/valuesPerBlock)

所占字节数byteCount=8 * longCount

# 读取器

## PACKED_SINGLE_BLOCK格式

单个long类型块内聚集格式，块与块之间有间隙

Packed64SingleBlock

## PACKED

等宽位的整数连续聚集在一个，块与块之间没有间隙

### Direct8

### Direct16

### Direct32

### Direct64

### Packed8ThreeBlocks

聚集的数据位宽为24

### Packed16ThreeBlocks

聚集的数据位宽为48

### Packed64

```
long get(final int index)
```

# 读取迭代器

## PackedReaderIterator

# 直接读取器

## PACKED格式

### DirectPackedReader

## PACKED_SINGLE_BLOCK格式

### DirectPacked64SingleBlockReader


# GrowableWriter

# PagedGrowableWriter

MIN_BLOCK_SIZE = 1 << 6
MAX_BLOCK_SIZE = 1 << 30

pageSize 落在MIN_BLOCK_SIZE和MAX_BLOCK_SIZE之间

pageShift pageSize通过1左移多少位得到

pageMask pageSize的掩码

例子：pageSize=4=0b100 pageMask=3=0b11

size 总共保存多少个数值

blockSize = pageSize 每个块保存多少个数值

numBlocks = (int) (size / blockSize) + (size % blockSize == 0 ? 0 : 1)

numPages = numBlocks

### PackedLongValues.Builder

往建造者添加一个新元素
```
public Builder add(long l);
```

#### 添加流程

如果pending数组未满，添加到pending数组
如果pending数组已满，如果values.length == valuesOff，增长values的大小

# MonotonicBlockPackedWriter

# MonotonicBlockPackedReader


# EliasFanoDocIdSet

使用了EliasFanoEncoder和EliasFanoDecoder