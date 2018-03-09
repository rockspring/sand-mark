# sed

sed=Stream-oriented, NonInteractive,Text Editor
S Ed

非交互式的编辑器

## 学习资料

http://www.grymoire.com/Unix/Sed.html#uh-10

http://www.grymoire.com/Unix/Quote.html

http://spurrier.gatorglory.com/ebooks/O'Reilly%20-%20sed%20&%20awk%202nd%20Edition.pdf

http://www.cs.nyu.edu/~mohri/unix08/lect5.pdf

## 准备

创建一个文件a.txt，文件内容如下

```
工欲善其事，必先利其器！
May you live in interesting times

language
abcdefg;hijklmn;opq;rst;uvw;xyz
English

中文
汉字

0,123,456,789
```

## sed 使用概览

使用的版本4.4

执行如下命令

```
sed --help
```

输出

```
Usage: sed [OPTION]... {script-only-if-no-other-script} [input-file]...

  -n, --quiet, --silent
                 suppress automatic printing of pattern space
  -e script, --expression=script
                 add the script to the commands to be executed
  -f script-file, --file=script-file
                 add the contents of script-file to the commands to be executed
  --follow-symlinks
                 follow symlinks when processing in place
  -i[SUFFIX], --in-place[=SUFFIX]
                 edit files in place (makes backup if SUFFIX supplied)
  -l N, --line-length=N
                 specify the desired line-wrap length for the `l' command
  --posix
                 disable all GNU extensions.
  -E, -r, --regexp-extended
                 use extended regular expressions in the script
                 (for portability use POSIX -E).
  -s, --separate
                 consider files as separate rather than as a single,
                 continuous long stream.
      --sandbox
                 operate in sandbox mode.
  -u, --unbuffered
                 load minimal amounts of data from the input files and flush
                 the output buffers more often
  -z, --null-data
                 separate lines by NUL characters
      --help     display this help and exit
      --version  output version information and exit

If no -e, --expression, -f, or --file option is given, then the first
non-option argument is taken as the sed script to interpret.  All
remaining arguments are names of input files; if no input files are
specified, then the standard input is read.

GNU sed home page: <http://www.gnu.org/software/sed/>.
General help using GNU software: <http://www.gnu.org/gethelp/>.
```

command由地址（address）和动作（action）组成

command_file可以包含多个command

一个简单的sed命令

```
sed 'p' a.txt
```

输出结果

```
工欲善其事，必先利其器！
工欲善其事，必先利其器！
May you live in interesting times
May you live in interesting times


language
language
abcdefg;hijklmn;opq;rst;uvw;xyz
abcdefg;hijklmn;opq;rst;uvw;xyz
English
English


中文
中文
汉字
汉字


0,123,456,789
0,123,456,789
```

每一个行都被输出了两遍

因为p是一个打印命令，每一行会被打印出来，sed处理完一行后会输出已被处理的行

添加一个参数-n

```
sed -n 'p' a.txt
```

输出结果

```
工欲善其事，必先利其器！
May you live in interesting times

language
abcdefg;hijklmn;opq;rst;uvw;xyz
English

中文
汉字

0,123,456,789
```

## 行号为地址

### 打印第一行

```
sed -n '1p' a.txt
```

输出结果

```
工欲善其事，必先利其器！
```

### 打印最后一行

$表示最后一行的行号

```
sed -n '$p' a.txt
```

输出结果

```
0,123,456,789
```

### 打印行区间

```
sed -n '1,2p' a.txt
```

输出结果

```
工欲善其事，必先利其器！
May you live in interesting times
```

### 打印排除某一行的所有行

```
sed -n '1!p' a.txt
```

输出结果

```
May you live in interesting times

language
abcdefg;hijklmn;opq;rst;uvw;xyz
English

中文
汉字

0,123,456,789
```

### 打印排除某几行的所有行

```
sed -n '2,3!p' a.txt
```

```
工欲善其事，必先利其器！
language
abcdefg;hijklmn;opq;rst;uvw;xyz
English

中文
汉字

0,123,456,789
```

## 地址通过模式匹配确定

$模式，匹配最后一行

```
sed -n '/pattern/command' a.txt
```

### 匹配某个字符串，就处理

```
sed -n '/language/p' a.txt
```

输出结果

```
language
```

### 处理除了匹配某个字符串的行之外的所有行

```
sed -n '/language/!p' a.txt
```

```
工欲善其事，必先利其器！
May you live in interesting times

abcdefg;hijklmn;opq;rst;uvw;xyz
English

中文
汉字

0,123,456,789
```

## 命令

s - substitute
a - append
i - insert
d - delete
p - print
y - transform
c - change
q - quit


### 添加命令，在某一行后面添加一行

```
sed '/language/a\
语言' a.txt
```

### 插入命令，在某一行后面插入一行

```
sed '/language/i\
关于语言' a.txt
```

### 删除命令，删除某一行

```
sed /^$/d # 删除空白行

sed '/language/d' a.txt
```

#### 删除最后一行

```
$      Match the last line.

sed '$d' a.txt
sed \$d a.txt # 对$符号转义
```

### 修改命令，修改某一行

```
sed '/language/c\
语言' a.txt
```

### 替换命令

[address(es)]s/pattern/replacement/[flags]

flags

n 第几个匹配的将被替换
g 所有匹配都会被替换
p 打印模式空间

替换第一个匹配的内容

```
sed '/abcdefg/s/;/,/' a.txt
sed '/abcdefg/s/;/,/1' a.txt
```

替换第二个匹配的内容

```
sed '/abcdefg/s/;/,/2' a.txt
```

替换行中所有的匹配内容

```
sed '/abcdefg/s/;/,/g' a.txt
```

&代表整个被匹配的字符串，可以被引用

创建文件c.txt，内容如下

```
the UNIX operating system …
```

执行如下命令

```
sed 's/.NI./wonderful &/' c.txt
```

输出

```
the wonderful UNIX operating system …
```

使用匹配模式中第几个子串来替换

\n代表匹配模式中的第n个子模式

创建文件d.txt，内容如下

```
first:second
one:two
```

sed 's/\(.*\):\(.*\)/\2:\1/' d.txt

```
second:first
two:one
```

抽取一个字符串

```
echo " abc :   123  # comment" | sed -n "s/^[ ]*abc[ ]*: \([^#]*\).*$/\1/p"
```

去掉字符串前后的空格

```
echo "  abc  " | sed "s/^ *//;s/ *$//"
```

### 转换，将所有行中的;转换成-，,转换成-

```
sed 'y/;,/--/' a.txt
```

输出结果

```
工欲善其事，必先利其器！
May you live in interesting times

language
abcdefg-hijklmn-opq-rst-uvw-xyz
English

中文
汉字

0-123-456-789
```

## 技能进阶

### 地址

打印奇数行

```
sed -n '1~2p' a.txt
```

```
工欲善其事，必先利其器！

abcdefg;hijklmn;opq;rst;uvw;xyz

汉字
0,123,456,789
```

从某一行开始处理多少行

```
sed -n '1,+2p' a.txt
```

```
工欲善其事，必先利其器！
May you live in interesting times

```

给定一个其实行号，这一行的数据会被处理，给定一个行号倍数，如果后面的行号是这个N的倍数，则处理这一行后结束

sed -n '5,~3p' a.txt

```
abcdefg;hijklmn;opq;rst;uvw;xyz
English
```

## 同时执行多条命令

```
sed '{
y/;,/--/
s/language/语言/
}' a.txt
```

sed -e 'y/;,/--/' -e 's/language/语言/' a.txt

```
工欲善其事，必先利其器！
May you live in interesting times

语言
abcdefg-hijklmn-opq-rst-uvw-xyz
English

中文
汉字

0-123-456-789
```

## 将命令写在文件里

sed.command.txt

```
y/;,/--/
s/language/语言/
```

```
sed -f sed.command.txt a.txt
```

## 就地处理

sed -i 'y/;,/--/' a.txt

备份源文件

sed -i.bak 'y/;,/--/' a.txt

## 同时处理多个文件

b.txt

```
2016/02/02
猴年大吉
```

### 把多个文件连接起来当做一个整体处理（看做一个文件处理）

```
sed  -n '1,2p' a.txt b.txt
```

### 把多个文件看成独立的文件处理

```
sed -s -n '1,2p' a.txt b.txt
```

添加注释

```
sed  -n '1,2p#这是注释' a.txt
```

## 安静模式

sed.p.txt

```
#n
p
```

## 两个空间

Pattern space

工作空间，持有命令正在处理的单行输出数据

Hold space


h, H, g, G, x命令需要的存储空间


w命令

```
Adams, Henrietta Northeast
Banks, Freda South
Dennis, Jim Midwest
Garvey, Bill Northeast
Jeffries, Jane West
Madison, Sylvia Midwest
Sommes, Tom South
```

```
sed '{
/Northeast$/w region.northeast
/South$/w region.south
/Midwest$/w region.midwest
/West$/w region.west
}' aa.txt
```

r命令

从一个文件读入内容插入到当前行之后

aa.txt

```
For service, contact any of the following companies:
<Company-list>
Thank you.
```

bb.txt

```
	Allied
	Mayflower
	United
```

```
sed '/^<Company-list>/r bb.txt' -e '/^<Company-list>/d' aa.txt
```
