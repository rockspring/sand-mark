# MutablePointsReaderUtils

## public static void partition(int maxDoc, int splitDim, int bytesPerDim, int commonPrefixLen, MutablePointValues reader, int from, int to, int mid, BytesRef scratch1, BytesRef scratch2)

scratch1用来存储分割点

scratch2用来存储每次需要比较的新元素


计算分割维度的值非公共前缀存储位置的起点位置

```
final int offset = splitDim * bytesPerDim + commonPrefixLen;
```

由于公共前缀部分不需要比较，根据公共前缀的长度计算需要比较的字节数。维度值总共占用的字节数bytesPerDim减去公共前缀字节数commonPrefixLen。

```
final int cmpBytes = bytesPerDim - commonPrefixLen;
```

计算每个docID打包存储时占用的比特位数量。

```
final int bitsPerDocId = PackedInts.bitsRequired(maxDoc - 1);
```

org.apache.lucene.util.RadixSelector#byteAt方法在获取下一个比较的字节时需要用到cmpBytes、offset、bitsPerDocId。

如果比较的还是维度值部分，直接根据偏移量offset和字节序号k获取下一个要比较的字节。

如果比较的是docID部分，首先从reader取出docID的编码值。由于docID的编码值是变长的比特位组成。因此根据字节序号k算出需要取出docID的哪一部分来做比较。

```
final int shift = bitsPerDocId - ((k - cmpBytes + 1) << 3);
return (reader.getDocID(i) >>> Math.max(0, shift)) & 0xff;
```

