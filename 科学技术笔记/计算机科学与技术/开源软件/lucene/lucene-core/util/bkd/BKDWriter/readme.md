# org.apache.lucene.util.bkd.BKDWriter

```
private final int bytesPerDoc;
固定宽度离线格式存储中每个文档占用的字节数量。每个文档存储的内容为dimensional values (numDims * bytesPerDim) + ord (int or long) + docID (int)。
如果文档最多一个值，不存储序号ord，因为与文档id重复了。bytesPerDoc = packedBytesLength + Integer.BYTES;。如果文档有多个值，并且序号使用8字节整数表示。bytesPerDoc = packedBytesLength + Long.BYTES + Integer.BYTES;。如果文档有多个值，并且序号使用4字节整数表示。bytesPerDoc = packedBytesLength + Integer.BYTES + Integer.BYTES;。

protected final int numDims;
正在创建索引的空间点的维度个数。

protected final int bytesPerDim;
每个维度值占用的字节数量。

protected final int packedBytesLength;
每个空间点占用的字节数量。packedBytesLength = numDims * bytesPerDim。

final TrackingDirectoryWrapper tempDir;

final String tempFileNamePrefix;
临时文件名称的前缀。例子：_0

final double maxMBSortInHeap;
分区时排序使用的堆内存，单位为MB（兆字节）。

final byte[] scratchDiff;
长度为bytesPerDim，刚好放置一个维度的值。

final byte[] scratch1;
长度为bytesPerDim，刚好放置一个维度的值。

final byte[] scratch2;
长度为bytesPerDim，刚好放置一个维度的值。

final BytesRef scratchBytesRef1 = new BytesRef();
final BytesRef scratchBytesRef2 = new BytesRef();

final int[] commonPrefixLengths;
长度为维度个数。每个维度使用一个元素记录公共前缀的长度。

protected final FixedBitSet docsSeen;
位图记录了哪些文档已经看到。位图的长度为maxDoc。

protected final int maxPointsInLeafNode;
private final int maxPointsSortInHeap;
每个维度都需要分区，分区需要排序，排序需要堆内存。递归处理过程中当前层上面的层所有节点数等于当前层的节点数。递归处理过程中以上层的空间点也要保存，因此存储的空间数量是实际需要的空间点数量的两倍。
maxPointsSortInHeap = (int) (0.5 * (maxMBSortInHeap * 1024 * 1024) / (bytesPerDoc * numDims));

/** Minimum per-dim values, packed */
protected final byte[] minPackedValue;

/** Maximum per-dim values, packed */
protected final byte[] maxPackedValue;

/** true if we have so many values that we must write ords using long (8 bytes) instead of int (4 bytes) */
protected final boolean longOrds;
空间点值特别多，4字节整数已无法表示所有序号，需要8字节整数表示序号。

/** An upper bound on how many points the caller will add (includes deletions) */
private final long totalPointCount;
调用者将添加或删除的空间点数量的上限。

/** True if every document has at most one value.  We specialize this case by not bothering to store the ord since it's redundant with docID.  */
protected final boolean singleValuePerDoc;
如果每个文档最多有一个空间点，该变量的值为true，否则为false。

/** How much heap OfflineSorter is allowed to use */
protected final OfflineSorter.BufferSize offlineSorterBufferMB;
OfflineSorter最大允许使用的堆内存数量。

/** How much heap OfflineSorter is allowed to use */
protected final int offlineSorterMaxTempFiles;
OfflineSorter最大允许使用的临时文件数。

private final int maxDoc;
最大文档值。

private OfflinePointWriter offlinePointWriter;
private HeapPointWriter heapPointWriter;
protected long pointCount;
private IndexOutput tempInput;
```

## public long writeField(IndexOutput out, String fieldName, MutablePointValues reader) throws IOException

写入某个字段的一批空间点值到文件中。例如文件名为“\_0.dim”。

如果是一维空间点，使用org.apache.lucene.util.bkd.BKDWriter#writeField1Dim。

如果是二维空间点，使用org.apache.lucene.util.bkd.BKDWriter#writeFieldNDims。

## private long writeFieldNDims(IndexOutput out, String fieldName, MutablePointValues values) throws IOException

countPerLeaf初始值设置为总的空间点数量。通过如下代码计算出内部节点数量。不断地进行二分，直到分出的数量小于或等于maxPointsInLeafNode为止。每分割一次，innerNodeCount乘以2，最终得到叶子节点个数。因为二分采用的是整数相除，在多出一个空间点时会出问题，所以，每次二分时先给总数加上1。

```
while (countPerLeaf > maxPointsInLeafNode) {
  countPerLeaf = (countPerLeaf+1)/2;
  innerNodeCount *= 2;
}
```

申请存储分裂点的字节数组。如下代码所示。

```
final byte[] splitPackedValues = new byte[numLeaves * (bytesPerDim + 1)];
```

申请存储叶子块的文件指针的长整数数组。如下代码所示。

```
final long[] leafBlockFPs = new long[numLeaves];
```

计算所有空间点所有维度值中的最小值minPackedValue和最大值maxPackedValue。计算过程中使用了scratchBytesRef1存储每次需要比较的一个空间点中的维度值。每次处理一个空间点，找到其对应的文档id，设置docsSeen中对应的位为1。

```
// compute the min/max for this slice
Arrays.fill(minPackedValue, (byte) 0xff);
Arrays.fill(maxPackedValue, (byte) 0);
for (int i = 0; i < Math.toIntExact(pointCount); ++i) {
  values.getValue(i, scratchBytesRef1);
  for(int dim=0;dim<numDims;dim++) {
    int offset = dim*bytesPerDim;
    if (StringHelper.compare(bytesPerDim, scratchBytesRef1.bytes, scratchBytesRef1.offset + offset, minPackedValue, offset) < 0) {
      System.arraycopy(scratchBytesRef1.bytes, scratchBytesRef1.offset + offset, minPackedValue, offset, bytesPerDim);
    }
    if (StringHelper.compare(bytesPerDim, scratchBytesRef1.bytes, scratchBytesRef1.offset + offset, maxPackedValue, offset) > 0) {
      System.arraycopy(scratchBytesRef1.bytes, scratchBytesRef1.offset + offset, maxPackedValue, offset, bytesPerDim);
    }
  }

  docsSeen.set(values.getDocID(i));
}
```

调用org.apache.lucene.util.bkd.BKDWriter#build(int nodeID, int leafNodeOffset, MutablePointValues reader, int from, int to, IndexOutput out, byte[] minPackedValue, byte[] maxPackedValue, int[] parentSplits, byte[] splitPackedValues, long[] leafBlockFPs, int[] spareDocIds)构建bkd树。

```
final int[] parentSplits = new int[numDims];
build(1, numLeaves, values, 0, Math.toIntExact(pointCount), out,
      minPackedValue, maxPackedValue, parentSplits,
      splitPackedValues, leafBlockFPs,
      new int[maxPointsInLeafNode]);
assert Arrays.equals(parentSplits, new int[numDims]);
```

## private void build(int nodeID, int leafNodeOffset, MutablePointValues reader, int from, int to, IndexOutput out, byte[] minPackedValue, byte[] maxPackedValue, int[] parentSplits, byte[] splitPackedValues, long[] leafBlockFPs, int[] spareDocIds)

splitPackedValues存储分割点，每个分割节点占用一个存储段，每个维度的存储段的第一个字节为分割维度值，后面的bytesPerDim存储分割的维度值。

内部节点

```
// inner node

// compute the split dimension and partition around it
final int splitDim = split(minPackedValue, maxPackedValue, parentSplits);
final int mid = (from + to + 1) >>> 1;

int commonPrefixLen = bytesPerDim;
for (int i = 0; i < bytesPerDim; ++i) {
if (minPackedValue[splitDim * bytesPerDim + i] != maxPackedValue[splitDim * bytesPerDim + i]) {
  commonPrefixLen = i;
  break;
}
}

MutablePointsReaderUtils.partition(maxDoc, splitDim, bytesPerDim, commonPrefixLen,
  reader, from, to, mid, scratchBytesRef1, scratchBytesRef2);

// set the split value
final int address = nodeID * (1+bytesPerDim);
splitPackedValues[address] = (byte) splitDim;
reader.getValue(mid, scratchBytesRef1);
System.arraycopy(scratchBytesRef1.bytes, scratchBytesRef1.offset + splitDim * bytesPerDim, splitPackedValues, address + 1, bytesPerDim);

byte[] minSplitPackedValue = Arrays.copyOf(minPackedValue, packedBytesLength);
byte[] maxSplitPackedValue = Arrays.copyOf(maxPackedValue, packedBytesLength);
System.arraycopy(scratchBytesRef1.bytes, scratchBytesRef1.offset + splitDim * bytesPerDim,
  minSplitPackedValue, splitDim * bytesPerDim, bytesPerDim);
System.arraycopy(scratchBytesRef1.bytes, scratchBytesRef1.offset + splitDim * bytesPerDim,
  maxSplitPackedValue, splitDim * bytesPerDim, bytesPerDim);

// recurse
parentSplits[splitDim]++;
build(nodeID * 2, leafNodeOffset, reader, from, mid, out,
  minPackedValue, maxSplitPackedValue, parentSplits,
  splitPackedValues, leafBlockFPs, spareDocIds);
build(nodeID * 2 + 1, leafNodeOffset, reader, mid, to, out,
  minSplitPackedValue, maxPackedValue, parentSplits,
  splitPackedValues, leafBlockFPs, spareDocIds);
parentSplits[splitDim]--;
```

调用org.apache.lucene.util.bkd.BKDWriter#split方法计算出使用哪个维度进行分割。

计算中间下标final int mid = (from + to + 1) >>> 1;。如果元素个数为偶数，下标指向右半部的第一个元素。

计算选中的维度的所有值的公共前缀长度。minPackedValue和maxPackedValue编码了多个维度的值在里面，使用splitDim * bytesPerDim定位需要读取的维度值数据。

```
  int commonPrefixLen = bytesPerDim;
  for (int i = 0; i < bytesPerDim; ++i) {
    if (minPackedValue[splitDim * bytesPerDim + i] != maxPackedValue[splitDim * bytesPerDim + i]) {
      commonPrefixLen = i;
      break;
    }
  }
```

使用public static void org.apache.lucene.util.bkd.MutablePointsReaderUtils#partition(int maxDoc, int splitDim, int bytesPerDim, int commonPrefixLen, MutablePointValues reader, int from, int to, int mid, BytesRef scratch1, BytesRef scratch2)对空间点按一个维度分成两半。

```
MutablePointsReaderUtils.partition(maxDoc, splitDim, bytesPerDim, commonPrefixLen, reader, from, to, mid, scratchBytesRef1, scratchBytesRef2);
```


叶子节点

```
  // leaf node
  final int count = to - from;
  assert count <= maxPointsInLeafNode;

  // Compute common prefixes
  Arrays.fill(commonPrefixLengths, bytesPerDim);
  reader.getValue(from, scratchBytesRef1);
  for (int i = from + 1; i < to; ++i) {
    reader.getValue(i, scratchBytesRef2);
    for (int dim=0;dim<numDims;dim++) {
      final int offset = dim * bytesPerDim;
      for(int j=0;j<commonPrefixLengths[dim];j++) {
        if (scratchBytesRef1.bytes[scratchBytesRef1.offset+offset+j] != scratchBytesRef2.bytes[scratchBytesRef2.offset+offset+j]) {
          commonPrefixLengths[dim] = j;
          break;
        }
      }
    }
  }

  // Find the dimension that has the least number of unique bytes at commonPrefixLengths[dim]
  FixedBitSet[] usedBytes = new FixedBitSet[numDims];
  for (int dim = 0; dim < numDims; ++dim) {
    if (commonPrefixLengths[dim] < bytesPerDim) {
      usedBytes[dim] = new FixedBitSet(256);
    }
  }
  for (int i = from + 1; i < to; ++i) {
    for (int dim=0;dim<numDims;dim++) {
      if (usedBytes[dim] != null) {
        byte b = reader.getByteAt(i, dim * bytesPerDim + commonPrefixLengths[dim]);
        usedBytes[dim].set(Byte.toUnsignedInt(b));
      }
    }
  }
  int sortedDim = 0;
  int sortedDimCardinality = Integer.MAX_VALUE;
  for (int dim = 0; dim < numDims; ++dim) {
    if (usedBytes[dim] != null) {
      final int cardinality = usedBytes[dim].cardinality();
      if (cardinality < sortedDimCardinality) {
        sortedDim = dim;
        sortedDimCardinality = cardinality;
      }
    }
  }

  // sort by sortedDim
  MutablePointsReaderUtils.sortByDim(sortedDim, bytesPerDim, commonPrefixLengths,
      reader, from, to, scratchBytesRef1, scratchBytesRef2);

  // Save the block file pointer:
  leafBlockFPs[nodeID - leafNodeOffset] = out.getFilePointer();

  assert scratchOut.getPosition() == 0;

  // Write doc IDs
  int[] docIDs = spareDocIds;
  for (int i = from; i < to; ++i) {
    docIDs[i - from] = reader.getDocID(i);
  }
  //System.out.println("writeLeafBlock pos=" + out.getFilePointer());
  writeLeafBlockDocs(scratchOut, docIDs, 0, count);

  // Write the common prefixes:
  reader.getValue(from, scratchBytesRef1);
  System.arraycopy(scratchBytesRef1.bytes, scratchBytesRef1.offset, scratch1, 0, packedBytesLength);
  writeCommonPrefixes(scratchOut, commonPrefixLengths, scratch1);

  // Write the full values:
  IntFunction<BytesRef> packedValues = new IntFunction<BytesRef>() {
    @Override
    public BytesRef apply(int i) {
      reader.getValue(from + i, scratchBytesRef1);
      return scratchBytesRef1;
    }
  };
  assert valuesInOrderAndBounds(count, sortedDim, minPackedValue, maxPackedValue, packedValues,
      docIDs, 0);
  writeLeafBlockPackedValues(scratchOut, commonPrefixLengths, count, sortedDim, packedValues);
  
  out.writeBytes(scratchOut.getBytes(), 0, scratchOut.getPosition());
  scratchOut.reset();
```

## protected int split(byte[] minPackedValue, byte[] maxPackedValue, int[] parentSplits)

为了确保所有的维度都被用作分割维度。首先查看是否有一个维度使用的次数比使用最多的维度的使用次数小2倍。

parentSplits记录每个维度使用的次数。使用如下代码求出最大的维度使用次数。

```
int maxNumSplits = 0;
for (int numSplits : parentSplits) {
  maxNumSplits = Math.max(maxNumSplits, numSplits);
}
```

使用如下代码找出一个维度，其使用次数比最大的维度使用次数小2倍。

```
for (int dim = 0; dim < numDims; ++dim) {
  final int offset = dim * bytesPerDim;
  if (parentSplits[dim] < maxNumSplits / 2 &&
      StringHelper.compare(bytesPerDim, minPackedValue, offset, maxPackedValue, offset) != 0) {
    return dim;
  }
}
```


使用如下代码取出取值范围最广的维度。

```
// Find which dim has the largest span so we can split on it:
int splitDim = -1;
for(int dim=0;dim<numDims;dim++) {
  NumericUtils.subtract(bytesPerDim, dim, maxPackedValue, minPackedValue, scratchDiff);
  if (splitDim == -1 || StringHelper.compare(bytesPerDim, scratchDiff, 0, scratch1, 0) > 0) {
    System.arraycopy(scratchDiff, 0, scratch1, 0, bytesPerDim);
    splitDim = dim;
  }
}
```

scratchDiff记录了最小值和最大值的差距。

















