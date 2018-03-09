#tailer
##简介
Implements tailing and heading functionality like GNU tail and head commands.

##安装

sudo pip install tailer

##使用

###follow功能

取得文件新增加的内容

```
import os, tailer
fw = file('test_follow.txt', 'w')
fr = file('test_follow.txt', 'r')
generator = tailer.follow(fr)
fw.write('Line 1\n')
fw.flush()
generator.next()
fw.close()
fr.close()
os.remove('test_follow.txt')
pass

```

###head功能

```
import StringIO， tailer
f=StringIO.StringIO()
for i in range(11):
f.write('Line %d\n' % (i+1))

tailer.head(f,3)
pass
```

###tail功能

```
import StringIO， tailer
f=StringIO.StringIO()
for i in range(11):
f.write('Line %d\n' % (i+1))

tailer.tail(f,3)
pass
```