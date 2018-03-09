## grep 特殊字符

其实在linux中要正确匹配tab（退格）符有两种方式

1：用 grep  $'\t'       你的文件

2：用 grep '按CTRL+V 键，再按TAB键'      你的文件


## grep 多个字符串OR操作

可以通过使用 '\|' 来分割多个pattern，以此实现OR的操作。

grep -E 选项可以用来扩展选项为正则表达式。

egrep 命令等同于‘grep -E’

使用grep -e 选项，只能传递一个参数。在单条命令中使用多个 -e 选项，得到多个pattern，以此实现OR操作。

## grep 多个字符串AND操作

使用 -E 'pattern1.\*pattern2'

可以使用多个 grep 命令 ，由管道符分割，以此来实现 AND 语义。

## grep 多个字符串NOT操作

使用 grep -v 可以实现 NOT 操作

## grep 限制显示的条数

```
-m NUM, --max-count=NUM
        Stop  reading  a file after NUM matching lines.  If the input is standard input from a regular file, and NUM matching lines are output, grep ensures that the standard input is positioned to just after the last matching line before exiting, regardless of the presence of
        trailing context lines.  This enables a calling process to resume a search.  When grep stops after NUM matching lines, it outputs any trailing context lines.  When the -c or --count option is also used, grep does not output a count greater than NUM.   When  the  -v  or
        --invert-match option is also used, grep stops after outputting NUM non-matching lines.
```

## grep 不区分大小写

```
-i, --ignore-case
    Ignore case distinctions, so that characters that differ only in case match each other.
```