## 1 代码命令风格转换

### 下划线风格转换成驼峰风格

将如下内容加入到shell的.bash_profile文件中，在命令行就将underscoreCase2CamelCase当做一个命令使用

```
alias underscoreCase2CamelCase='python -c "
import sys
for line in sys.stdin:
    input = line.replace(\"\n\",\"\")
    item_list = input.split(\"_\")
    print \"\".join(item_list[0:1] + map(lambda x: str(x).title(), item_list[1:]))
"'
```

使用例子
```
echo -e "aaa_bbb\nccc_ddd" | underscoreCase2CamelCase

#输出如下
aaa_bbb
ccc_ddd
```

### 驼峰风格转换成下划线风格

将如下内容加入到shell的.bash_profile文件中，在命令行就将camelCase2underscoreCase当做一个命令使用
```
alias camelCase2underscoreCase='python -c "
import sys
for line in sys.stdin:
    input=line.replace(\"\n\",\"\")
    item_list = map(lambda x: \"_\" + x.lower() if (x != x.lower()) else x, input)
    print \"\".join(item_list)
"'
```

使用例子
```
echo -e 'aaaBbb\ncccDdd' | camelCase2underscoreCase

#输出如下
aaa_bbb
ccc_ddd
```

## 2 url转义与反转义

### url转义

将如下内容加入到shell的.bash_profile文件中，在命令行就将urlEncode当做一个命令使用

```
alias urlEncode='python -c "
import sys
import urllib as ul
for line in sys.stdin:
    input=line.replace(\"\n\",\"\")
    print ul.quote_plus(input)
"'
```

使用例子

```
echo "key1=value1&key2=value2" | urlEncode

输出
key1%3Dvalue1%26key2%3Dvalue2
```

### url反转义

将如下内容加入到shell的.bash_profile文件中，在命令行就将urlDecode当做一个命令使用
```
alias urlDecode='python -c "
import sys
import urllib as ul
for line in sys.stdin:
    input=line.replace(\"\n\",\"\")
    print ul.unquote_plus(input)
"'
```

使用例子

```
echo 'key1%3Dvalue1%26key2%3Dvalue2' | urlDecode

输出
key1=value1&key2=value2
```
