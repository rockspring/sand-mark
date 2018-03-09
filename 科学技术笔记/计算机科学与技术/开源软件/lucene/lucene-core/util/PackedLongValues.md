org/apache/lucene/util/packed/PackedLongValues.java

```
PackedLongValues.Builder pending = PackedLongValues.deltaPackedBuilder(PackedInts.COMPACT)
long bytesUsed = pending.ramBytesUsed();
```


PackedLongValues$Builder

pageSize为一个页存放多少个数字。

pageSize = 1024

long[] pending

暂存需要打包的长整型数字

pending = new long[pageSize]

pending的长度由pageSize参数控制

int pageShift;

1左移位多少得到pageSize，如果pageSize=1024，pageShift=10。1 << 10 = 1024。

int pageMask;

pageSize对应的掩码，pageMask=pageSize - 1。

long size

当前暂存了多少个数字

int pendingOff

指示下一个放入暂存（悬而未决，所有数据放完后才打包）数字的数组下标位置。


页相关

INITIAL_PAGE_COUNT = 16;

PackedInts.Reader[] values = new PackedInts.Reader[INITIAL_PAGE_COUNT];

初始页的数量为16，创建16个PackedInts.Reader。

int valuesOff

指示下一个要用的页，PackedInts.Reader[]的下标索引。


# 接口

# 抽象类

## NumericDocValues

### 未实现方法一

```
public abstract long get(int docID);
```

根据docID获得与此doc关联的一个long类型数字。

## PackedInts.Reader

org/apache/lucene/util/packed/PackedInts.java

继承了NumericDocValues抽象类

### 模板方法一

```
public int get(int index, long[] arr, int off, int len);
```

从第一个docID（index）开始获取至少一个doc，至多len个doc关联的long类型数字，将结果存入数组arr，从arr的下标off开始存储。

### 未实现的抽象方法

```
public abstract int size();
```

获得doc的总数。

## PackedInts.Mutable

org/apache/lucene/util/packed/PackedInts.java

## 容器构造

通过静态工厂方法构造

org/apache/lucene/util/packed/PackedInts.java

```
public static Mutable getMutable(int valueCount,
      int bitsPerValue, PackedInts.Format format) {
    assert valueCount >= 0;
    switch (format) {
      case PACKED_SINGLE_BLOCK:
        return Packed64SingleBlock.create(valueCount, bitsPerValue);
      case PACKED:
        switch (bitsPerValue) {
          case 8:
            return new Direct8(valueCount);
          case 16:
            return new Direct16(valueCount);
          case 32:
            return new Direct32(valueCount);
          case 64:
            return new Direct64(valueCount);
          case 24:
            if (valueCount <= Packed8ThreeBlocks.MAX_SIZE) {
              return new Packed8ThreeBlocks(valueCount);
            }
            break;
          case 48:
            if (valueCount <= Packed16ThreeBlocks.MAX_SIZE) {
              return new Packed16ThreeBlocks(valueCount);
            }
            break;
        }
        return new Packed64(valueCount, bitsPerValue);
      default:
        throw new AssertionError();
    }
}
```

继承了PackedInts.Reader抽象类

### 接口方法一

```
public abstract int getBitsPerValue();
```

每个值存储时用了几个bits

### 接口方法二

```
public abstract void set(int index, long value);
```

在指定位置放置一个值，index一般就是docID

### 模板方法一

```
public int set(int index, long[] arr, int off, int len)
```

在arr数组中从下标off开始取出len个值，从index所指位置依次放置到Mutable容器中

### 模板方法二

```
public void fill(int fromIndex, int toIndex, long val)
```

从fromIndex位置开始，到toIndex位置结束（不包含toIndex），都放置val这个值。

### 模板方法三

```
public void clear()
```

将Mutable容器中的所有值重新设置为0

### 模板方法四

```
public void save(DataOutput out) throws IOException
```

将Mutable容器中值保存到DataOutput接口的实现体中。

通过PackedWriter将数据存储到DataOutput

PackedWriter使用BulkOperation对数据进行编码。

### 模板方法五

```
Format getFormat()
```

获得存储到数据库（这里指DataOutput接口的实现）的格式。


## MutableImpl

继承Mutable

### 构造方法一

```
protected MutableImpl(int valueCount, int bitsPerValue)
```

设置容器存放数字的个数valueCount

设置每个值需要使用bits数bitsPerValue


### 实现方法一

实现了父类的方法

```
public final int getBitsPerValue()
```

### 实现方法二

实现了父类的方法

```
public final int size()
```

### 实现方法三

```
public String toString()
```

记录valueCount和bitsPerValue


# 具体类

Direct8

# org/apache/lucene/util/packed/DeltaPackedLongValues.java

```
int decodeBlock(int block, long[] dest)
```

先调用父类的decodeBlock方法

org/apache/lucene/util/packed/PackedLongValues.java

block对应的块，dest中的值取决于block的实现，默认全部填充为0


block的实现，比如下面

org/apache/lucene/util/packed/Packed64SingleBlock.java

数组mins（long[]）保存了每个块的最小值，例如2

decodeBlock方法将每个dest元素加上这个最小值2













# BulkOperationPackedSingleBlock


The minimum number of long blocks to encode in a single iteration, when using long encoding.

int longBlockCount

The number of values that can be stored in {@link #longBlockCount()} long blocks.

int longValueCount

The minimum number of byte blocks to encode in a single iteration, when using byte encoding.

int byteBlockCount

The number of values that can be stored in {@link #byteBlockCount()} byte blocks.

int byteValueCount();


byteBlockCount=8 * BLOCK_COUNT = 8 * 1 = 8

当block为byte时，byteBlockCount的数量为8，8*8=64，一个long的存储长度

byteValueCount = 64 / bitsPerValue = 64 / 2 = 32

当block为byte时，一个long的存储空间可以保存多少个值，每个值占用2位，64 / 2 = 32

block为byte

一个block的大小为8bits

byteBlockCount + 8 * byteValueCount = 8 + 8 * 32 = 264

iterations = ramBudget / (byteBlockCount + 8 * byteValueCount) = 1024 / 264 = 3


(iterations - 1) * byteValueCount = （3 - 1） * 32 = 64

ceil((double) valueCount / byteValueCount()) = ceil(35 /32) = 2


批量读取时

iterations * v = 1 * 32 值，v为值的个数

iterations * b = 1 * 8 block



