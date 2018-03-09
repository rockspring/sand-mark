## kill

## 常用的信号

```
1       HUP (hang up)
2       INT (interrupt)
3       QUIT (quit)
6       ABRT (abort)
9       KILL (non-catchable, non-ignorable kill)
14      ALRM (alarm clock)
15      TERM (software termination signal)
```

## 默认信号

默认信号为TERM，kill pid 等价于 kill -15 pid

## 判断一个进程是否存在

```
to_stop=$pid
if kill -0 $to_stop > /dev/null 2>&1;then echo "exist";fi
```

-0表示不发送任何信号给PID对应的进程，但是仍会对变量值PID对应的进程是否存在进行检查，如果$pid对应的进程存在

man 2 kill

```
A value of 0, however, will cause error checking to be performed (with no signal being sent).  This can be used to check the validity of pid.
```
