## 中位数选择器

org.apache.lucene.util.RadixSelector

相关原理说明文档

[http://www.cs.yale.edu/homes/aspnes/pinewiki/RadixSort.html](http://www.cs.yale.edu/homes/aspnes/pinewiki/RadixSort.html)

## private void select(int from, int to, int k, int d, int l)

from 数组起始下标
to 数组终止下标
k 要选择的第k个数，既对全部元素排序后排在第k位的数

如果元素个数小于100，to - from <= LENGTH_THRESHOLD，则使用getFallbackSelector(d)的选择器。

如果递归深度大于8，d >= LEVEL_THRESHOLD，则使用getFallbackSelector(d)的选择器。

默认情况调用org.apache.lucene.util.RadixSelector#radixSelect。

## private void radixSelect(int from, int to, int k, int d, int l)

from 数组起始下标
to 数组终止下标
k 要选择第k个数
d 一个数中要比较的第d个字符
l 递归的层级

调用org.apache.lucene.util.RadixSelector#computeCommonPrefixLengthAndBuildHistogram计算直方图数据。

## private int computeCommonPrefixLengthAndBuildHistogram(int from, int to, int k, int[] histogram)

```
from 数组起始下标
to 数组终止下标
k 比较的字节个数
histogram 存放直方图统计结果
```

```
private final int[] commonPrefix;

公共前缀

private final int maxLength;

键的最大长度
```

commonPrefixLength初始化为如下

```
int commonPrefixLength = Math.min(commonPrefix.length, maxLength - k);
```

计算第一个空间点存储的字节串长度。commonPrefix存储了第一个空间点的数据。

```
for (int j = 0; j < commonPrefixLength; ++j) {
  final int b = byteAt(from, k + j);
  commonPrefix[j] = b;
  if (b == -1) {
    commonPrefixLength = j + 1;
    break;
  }
}
```

从第二个空间点开始，依次将其与第一个空间点存储的字节相比。发现不同字节时，如果是第一个字节就不同，则跳出外层循环，说明没有公共前缀。

```
int i;
outer: for (i = from + 1; i < to; ++i) {
  for (int j = 0; j < commonPrefixLength; ++j) {
    final int b = byteAt(i, k + j);
    if (b != commonPrefix[j]) {
      commonPrefixLength = j;
      if (commonPrefixLength == 0) { // we have no common prefix
        histogram[commonPrefix[0] + 1] = i - from;
        histogram[b + 1] = 1;
        break outer;
      }
      break;
    }
  }
}
```

如果没有公共前缀，调用org.apache.lucene.util.RadixSelector#buildHistogram。

## private void buildHistogram(int from, int to, int k, int[] histogram)

调用org.apache.lucene.util.RadixSelector#getBucket获取维度值的第k个字符。

每个字符的出现次数，记录到histogram，下标索引就是字符值加1。得出第k个字符的频次分布数据。

## private int getBucket(int i, int k)

获取维度值的第k个字符。

## private void partition(int from, int to, int bucket, int bucketFrom, int bucketTo, int d)



## 具体类

org.apache.lucene.util.bkd.MutablePointsReaderUtils#partition#Anonymous匿名内部类

