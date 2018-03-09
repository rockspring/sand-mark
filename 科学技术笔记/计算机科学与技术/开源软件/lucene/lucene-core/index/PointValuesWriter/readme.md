# PointValuesWriter

## public PointValuesWriter(DocumentsWriterPerThread docWriter, FieldInfo fieldInfo)

```
public PointValuesWriter(DocumentsWriterPerThread docWriter, FieldInfo fieldInfo) {
    this.fieldInfo = fieldInfo;
    this.iwBytesUsed = docWriter.bytesUsed;
    this.bytes = new ByteBlockPool(docWriter.byteBlockAllocator);
    docIDs = new int[16];
    iwBytesUsed.addAndGet(16 * Integer.BYTES);
    packedBytesLength = fieldInfo.getPointDimensionCount() * fieldInfo.getPointNumBytes();
}
```

fieldInfo.getPointDimensionCount() 空间点的维度个数。例子，个数为2。

fieldInfo.getPointNumBytes() 空间点的每个维度值占用的字节数。例子，维度值占用的字节数为3。来源自org.apache.lucene.document.FieldType#setDimensions方法设置的值，值的源头为org.apache.lucene.document.IntPoint#getType方法里的代码。

packedBytesLength 一个空间点占用的总字节数。例子，2\*3=6。

## public void addPackedValue(int docID, BytesRef value)

```
public void addPackedValue(int docID, BytesRef value) {
    if (value == null) {
      throw new IllegalArgumentException("field=" + fieldInfo.name + ": point value must not be null");
    }
    if (value.length != packedBytesLength) {
      throw new IllegalArgumentException("field=" + fieldInfo.name + ": this field's value has length=" + value.length + " but should be " + (fieldInfo.getPointDimensionCount() * fieldInfo.getPointNumBytes()));
    }

    if (docIDs.length == numPoints) {
      docIDs = ArrayUtil.grow(docIDs, numPoints+1);
      iwBytesUsed.addAndGet((docIDs.length - numPoints) * Integer.BYTES);
    }
    bytes.append(value);
    docIDs[numPoints] = docID;
    if (docID != lastDocID) {
      numDocs++;
      lastDocID = docID;
    }

    numPoints++;
}
```

参数例子：docID=0，value=[84 da 10 d 59 3]。2个维度，每个维度值3个字节。

空间点的值追加到bytes中。

没往索引中加入一个空间点，建立空间点编号到到文档id的映射关系。

numDocs 唯一的docID数量，每次新增唯一值时递增。

numPoints 空间点的数量，每次递增。

## public void flush(SegmentWriteState state, Sorter.DocMap sortMap, PointsWriter writer) throws IOException

参数sortMap来自org.apache.lucene.index.DefaultIndexingChain#maybeSortSegment方法的结果。段内的索引docID排序。DocMap记录了排序前后的文档id映射关系。默认情况下没有索引排序。

```
public void flush(SegmentWriteState state, Sorter.DocMap sortMap, PointsWriter writer) throws IOException {
    PointValues points = new MutablePointValues() {
      final int[] ords = new int[numPoints];
      {
        for (int i = 0; i < numPoints; ++i) {
          ords[i] = i;
        }
      }

      @Override
      public void intersect(IntersectVisitor visitor) throws IOException {
        final BytesRef scratch = new BytesRef();
        final byte[] packedValue = new byte[packedBytesLength];
        for(int i=0;i<numPoints;i++) {
          getValue(i, scratch);
          assert scratch.length == packedValue.length;
          System.arraycopy(scratch.bytes, scratch.offset, packedValue, 0, packedBytesLength);
          visitor.visit(getDocID(i), packedValue);
        }
      }

      @Override
      public long estimatePointCount(IntersectVisitor visitor) {
        throw new UnsupportedOperationException();
      }

      @Override
      public byte[] getMinPackedValue() {
        throw new UnsupportedOperationException();
      }

      @Override
      public byte[] getMaxPackedValue() {
        throw new UnsupportedOperationException();
      }

      @Override
      public int getNumDimensions() {
        throw new UnsupportedOperationException();
      }

      @Override
      public int getBytesPerDimension() {
        throw new UnsupportedOperationException();
      }

      @Override
      public long size() {
        return numPoints;
      }

      @Override
      public int getDocCount() {
        return numDocs;
      }

      @Override
      public void swap(int i, int j) {
        int tmp = ords[i];
        ords[i] = ords[j];
        ords[j] = tmp;
      }

      @Override
      public int getDocID(int i) {
        return docIDs[ords[i]];
      }

      @Override
      public void getValue(int i, BytesRef packedValue) {
        final long offset = (long) packedBytesLength * ords[i];
        packedValue.length = packedBytesLength;
        bytes.setRawBytesRef(packedValue, offset);
      }

      @Override
      public byte getByteAt(int i, int k) {
        final long offset = (long) packedBytesLength * ords[i] + k;
        return bytes.readByte(offset);
      }
    };

    final PointValues values;
    if (sortMap == null) {
      values = points;
    } else {
      values = new MutableSortingPointValues((MutablePointValues) points, sortMap);
    }
    PointsReader reader = new PointsReader() {
      @Override
      public PointValues getValues(String fieldName) {
        if (fieldName.equals(fieldInfo.name) == false) {
          throw new IllegalArgumentException("fieldName must be the same");
        }
        return values;
      }

      @Override
      public void checkIntegrity() {
        throw new UnsupportedOperationException();
      }

      @Override
      public long ramBytesUsed() {
        return 0L;
      }

      @Override
      public void close() {
      }
    };
    writer.writeField(fieldInfo, reader);
}
```

创建匿名内部类PointsReader的实例，取名为points。
创建匿名内部类MutablePointValues的实例，取名为reader。
调用org.apache.lucene.codecs.PointsWriter#writeField方法写入空间点。

