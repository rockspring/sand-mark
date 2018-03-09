# BKDReader

## 内部类

org.apache.lucene.util.bkd.BKDReader.IndexTree

org.apache.lucene.util.bkd.BKDReader.LegacyIndexTree 继承IndexTree

org.apache.lucene.util.bkd.BKDReader.PackedIndexTree 继承IndexTree

org.apache.lucene.util.bkd.BKDReader.IntersectState

## 公开方法

```
public BKDReader(IndexInput in)
public void intersect(IntersectVisitor visitor) throws IOException
public long estimatePointCount(IntersectVisitor visitor)
public IntersectState getIntersectState(IntersectVisitor visitor)
public void visitLeafBlockValues(IndexTree index, IntersectState state) throws IOException

public long ramBytesUsed()
public byte[] getMinPackedValue()
public byte[] getMaxPackedValue()
public int getNumDimensions()
public int getBytesPerDimension()
public long size()
public int getDocCount()
public boolean isLeafNode(int nodeID)
```

### ## org.apache.lucene.util.bkd.BKDReader#intersect(org.apache.lucene.index.PointValues.IntersectVisitor)

调用如下方法

```
org.apache.lucene.util.bkd.BKDReader#getIntersectState
org.apache.lucene.util.bkd.BKDReader#intersect(org.apache.lucene.util.bkd.BKDReader.IntersectState, byte[], byte[])
```

numDims

maxPointsInLeafNode

bytesPerDim

numLeaves

minPackedValue

maxPackedValue

pointCount

docCount

BKDWriter.VERSION_PACKED_INDEX

numBytes

packedIndex

org.apache.lucene.util.bkd.BKDReader#getIntersectState

输入packedIndex字节串，创建一个PackedIndexTree。

org.apache.lucene.util.bkd.BKDReader.PackedIndexTree#readNodeData

level初始值为1。

leafBlockFPStack[level]

code

splitValuesStack[level]

leftNumBytes

leftNode

rightNode


leftNodePositions

rightNodePositions


## org.apache.lucene.util.bkd.BKDReader.PackedIndexTree#pushLeft

移动到当前节点的左孩子节点

```
nodeID *= 2;
level++;
```

从leftNodePositions[level];得到数据存储位置，调用org.apache.lucene.util.bkd.BKDReader.PackedIndexTree#readNodeData读取节点数据。

## org.apache.lucene.util.bkd.BKDReader.PackedIndexTree#pushRight

移动到当前节点的左孩子节点

```
nodeID * 2 + 1;
level++;
```

从rightNodePositions[level];得到数据存储位置，调用org.apache.lucene.util.bkd.BKDReader.PackedIndexTree#readNodeData读取节点数据。


