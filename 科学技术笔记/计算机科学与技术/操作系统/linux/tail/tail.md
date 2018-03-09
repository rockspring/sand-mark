打印最后10行到控制台

tail -n 10 tail.c

tail --lines=10 tail.c

从第10行(包含)开始打印文件内容到控制台

tail -n +10 tail.c

下面两个效果一样

tail -n +0 a.txt

tail -n +1 a.txt

tail -n -1 a.txt