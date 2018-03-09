## 将字节数组转换成long型整数

字节数组blocks的第一个字节放入long的高位字节区

```
private static long readLong(byte[] blocks, int blocksOffset)
```

## 单次迭代解码方法

### long型存储的block

#### 从block解码出一个数字值数组，存储到long型数组中

```
private int decode(long block, long[] values, int valuesOffset)
```

#### 从block解码出一个数字值数组，存储到int型数组中

```
private int decode(long block, int[] values, int valuesOffset)
```

### byte型存储的block

#### 从block解码出一个数字值数组，存储到long型数组中


## 单次迭代编码方法

### 待编码的数字存储在long数组中

```
private long encode(long[] values, int valuesOffset)
```

### 待编码的数字存储在int数组中

```
private long encode(int[] values, int valuesOffset)
```

## 多次迭代解码方法

### 从long数组块解码出数字值，存储到long数组中

```
@Override
public void decode(long[] blocks, int blocksOffset, long[] values,
      int valuesOffset, int iterations)
```


### 从byte数组块解码出数字值，存储到long数组中

```
@Override
public void decode(byte[] blocks, int blocksOffset, long[] values,
      int valuesOffset, int iterations)
```


### 从long数组块解码出数字值，存储到int数组中

```
@Override
public void decode(long[] blocks, int blocksOffset, int[] values,
      int valuesOffset, int iterations)
```

### 从byte数组块解码出数字值，存储到int数组中

```
@Override
public void decode(byte[] blocks, int blocksOffset, int[] values,
      int valuesOffset, int iterations)
```

## 多次迭代编码方法

### 将long型数组中的值编码到long数组块

```
@Override
public void encode(long[] values, int valuesOffset, long[] blocks,
      int blocksOffset, int iterations)
```

### 将int型数组中的值编码到long数组块

```
@Override
public void encode(int[] values, int valuesOffset, long[] blocks,
      int blocksOffset, int iterations)
```

### 将long型数组中的值编码到byte数组块

```
@Override
public void encode(long[] values, int valuesOffset, byte[] blocks, int blocksOffset, int iterations)
```

### 将int型数组中的值编码到byte数组块

```
@Override
public void encode(int[] values, int valuesOffset, byte[] blocks,
      int blocksOffset, int iterations)
```


# BulkOperation

## 将long型数字转换成byte数组

long的高位第一个字节存储到blocks数组的第一个元素

```
protected int writeLong(long block, byte[] blocks, int blocksOffset)
```

## 根据内存使用量运算计算最多迭代多少次

```
public final int computeIterations(int valueCount, int ramBudget)
```
