# shell脚本默认的变量

```
$0 执行的shell脚本本身的名字

$# 传给shell脚本的参数个数
$1 传递给该shell脚本的第1个参数
$2 传递给该shell脚本的第2个参数
...
$9 传递给该shell脚本的第9个参数，参数不能超过9个

$@ 传给脚本的所有参数的列表
$* 以一个单字符串显示所有向脚本传递的参数，与位置变量不同，参数可超过9个
$$ 脚本运行的当前进程ID号
$? 显示最后命令的退出状态，0表示没有错误，其他表示有错误
```

```
echo $0

echo $#
echo $1
echo $2
echo $3
echo $4
echo $5
echo $6
echo $7
echo $8
echo $9

echo $@

echo $*
echo "current pid="$$
echo "exit code="$?
```
