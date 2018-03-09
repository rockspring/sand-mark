# HeapPointWriter

将空间点写入到堆内存的数组中。

```
public final List<byte[]> blocks = new ArrayList<>();
存储空间点的维度值。
```

## public HeapPointWriter(int initSize, int maxSize, int packedBytesLength, boolean longOrds, boolean singleValuePerDoc)

```
initSize 数组的初始大小
maxSize 数组的最大大小
packedBytesLength 空间点的值占用的大小
longOrds 是否使用8字节整数表示序号
singleValuePerDoc 文档是否是单个值
```

## public void append(byte[] packedValue, long ord, int docID)

写入一个空间点的维度值。
