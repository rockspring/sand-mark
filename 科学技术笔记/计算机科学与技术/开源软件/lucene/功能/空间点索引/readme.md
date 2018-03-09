# 空间点索引

[https://www.elastic.co/blog/lucene-points-6.0](https://www.elastic.co/blog/lucene-points-6.0)

```
// add year 1970 to document
document.add(new IntPoint("year", 1970));
// index document
writer.addDocument(document);
...
// issue range query of 1960-1980
Query query = IntPoint.newRangeQuery("year", 1960, 1980);
TopDocs docs = searcher.search(query, ...);
```

## org.apache.lucene.document.IntPoint

```
newExactQuery
newSetQuery
newRangeQuery
```

## org.apache.lucene.document.LongPoint

```
newExactQuery
newSetQuery
newRangeQuery
```

## org.apache.lucene.document.FloatPoint

```
newExactQuery
newSetQuery
newRangeQuery
```

## org.apache.lucene.document.DoublePoint

```
newExactQuery
newSetQuery
newRangeQuery
```

## org.apache.lucene.document.BinaryPoint

```
newExactQuery
newSetQuery
newRangeQuery
```

## org.apache.lucene.document.BigIntegerPoint

lucene-sandbox包

```
newExactQuery
newSetQuery
newRangeQuery
```

## org.apache.lucene.document.InetAddressPoint

lucene-misc包

支持的查询

```
newExactQuery
newPrefixQuery
newRangeQuery
newSetQuery
```

## org.apache.lucene.document.LatLonPoint

lucene-sandbox包

```
newBoxQuery
newDistanceQuery
newPolygonQuery
nearest
```

## org.apache.lucene.spatial3d.Geo3DPoint

lucene-spatial3d包

```
newDistanceQuery
newBoxQuery
newPolygonQuery
newLargePolygonQuery
newPathQuery
newShapeQuery
```

## 版本功能

Lucene 6.2.0 添加Index time sorting功能