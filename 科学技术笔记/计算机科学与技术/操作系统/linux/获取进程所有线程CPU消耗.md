# 获取进程所有线程CPU消耗

```
按第二个字段数值排序
ps -mp 231941  -o THREAD,tid,time | sed -n '3,$p' | sort -n -k  2 | xargs printf "%x\n"
```