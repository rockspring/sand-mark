# PointsReader

访问空间点值的接口API。

## public abstract PointValues getValues(String field) throws IOException;

通过字段名称获取对应的空间点值。

org.apache.lucene.index.PointValuesWriter#flush方法中创建一个匿名内部类PointsReader，空间点值的源头为org.apache.lucene.index.PointValuesWriter#flush方法中创建一个匿名内部类MutablePointValues，匿名内部类MutablePointValues的源头为org.apache.lucene.index.PointValuesWriter#bytes。
