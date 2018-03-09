# 使用grep抽取符合正则表达式的内容

## 用法简介

```
grep -Po [正则表达式]
```

## 选项说明

-P, --perl-regexp
    Interpret PATTERN as a Perl regular expression (PCRE, see below).  This is highly experimental and grep -P may warn of unimplemented features.

-o, --only-matching
    Print only the matched (non-empty) parts of a matching line, with each such part on a separate output line.


## 举例

```
# 将一段文字中的两个数字抽取出来，抽取出来的数字分别为11.8何24.6
echo "2016年6月末，M2和M1同比增速分别为11.8%和24.6%，M2和M1的增速差出现扩大趋势。" | grep -Po "\d+\.\d+"
```

输出结果

```
11.8
24.6
```

```
echo "2016年6月末，M2和M1同比增速分别为11.8%和24.6%，M2和M1的增速差出现扩大趋势。" | grep -Po "(\d+年\d+月|M2|M1|\d+\.\d+)"
```

输出结果

```
2016年6月
M2
M1
11.8
24.6
M2
M1
```

## 参考链接

[http://news.xinhuanet.com/fortune/2016-07/25/c_129174503.htm](http://news.xinhuanet.com/fortune/2016-07/25/c_129174503.htm)
