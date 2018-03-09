# PointValues

org.apache.lucene.codecs.lucene60.TestLucene60PointsFormat

org.apache.lucene.search.TestPointQueries	

Points 表示数字值，建立与文本不同的索引。Points的索引不是倒排索引，而是KD-tree索引。这个索引结构对区间查询、距离查询、邻近查询、多边形中的点查询进行了优化。

```
Java type	Lucene class
int	IntPoint
long	LongPoint
float	FloatPoint
double	DoublePoint
byte[]	BinaryPoint
BigInteger	BigIntegerPoint*
InetAddress	InetAddressPoint*
```

基本的点类型与对应的Java类型行为类似。比如，IntPoint表示一个有符号的32位整数。支持取值范围为Integer.MIN_VALUE到Integer.MAX_VALUE，排序时与Integer.compareTo(Integer)方法的排序结果一致。除了支持索引外，还包含一些静态方法创建常用的查询，如IntPoint.newRangeQuery(String, int, int)。

## 地理空间点类型

尽管DoublePoint支持多维点空间，Lucene为坐标数据设计了特殊的类型。它们更省空间，支持距离和多边形范围查询。

LatLonPoint (x,y)二维空间点
Geo3DPoint (x,y,z)三维空间点


## 内部类

org.apache.lucene.index.PointValues.Relation

递归处理子细胞空间与查询的关系

```
CELL_INSIDE_QUERY 细胞空间被查询全包含
CELL_OUTSIDE_QUERY 细胞空间与查询没有重叠
CELL_CROSSES_QUERY 细胞空间与查询有部分重叠
```

org.apache.lucene.index.PointValues.IntersectVisitor

我们递归地访问BKD树，使用一个实现了这个接口的实例引导递归过程

