# strace

strace - trace system calls and signals

## 运行

strace [-CdffhikqrtttTvVxxy] [-In] [-bexecve] [-eexpr]...  [-acolumn] [-ofile] [-sstrsize] [-Ppath]... -ppid... / [-D] [-Evar[=val]]... [-uusername] command [args]

strace -c[df] [-In] [-bexecve] [-eexpr]...  [-Ooverhead] [-Ssortby] -ppid... / [-D] [-Evar[=val]]... [-uusername] command [args]

## 参数解释

### -eexpr 设置过滤条件表达式。跟踪什么事件？怎么跟踪它们？

表达式的语法如下所示

```
[qualifier=][!]value1[,value2]...
```

qualifier可以选取如下的字符串之一

```
trace, abbrev, verbose, raw, signal, read, write, or fault
```

#### trace

跟踪什么？

```
-e trace=file
           Trace all system calls which take a file name as an argument.  You can think of this as an abbreviation for -e trace=open,stat,chmod,unlink,...  which is useful to seeing what files the process is referencing.  Furthermore, using the abbreviation will ensure that you  don't  acci‐
           dentally forget to include a call like lstat in the list.  Betchya woulda forgot that one.

-e trace=process
           Trace all system calls which involve process management.  This is useful for watching the fork, wait, and exec steps of a process.

-e trace=network
           Trace all the network related system calls.

-e trace=signal
           Trace all signal related system calls.

-e trace=ipc
           Trace all IPC related system calls.

-e trace=desc
           Trace all file descriptor related system calls.

-e trace=memory
           Trace all memory mapping related system calls.
```


#### abbrev

```
-e abbrev=set
           Abbreviate the output from printing each member of large structures.  The default is abbrev=all.  The -v option has the effect of abbrev=none.
```

-e abbrev=all 对大结构，缩略显示

```
fstat(3, {st_mode=S_IFCHR|0666, st_rdev=makedev(1, 3), ...}) = 0
```

-e abbrev=none 对大结构，不缩略显示，显示完整的数据

```
fstat(3, {st_dev=makedev(0, 6), st_ino=6, st_mode=S_IFCHR|0666, st_nlink=1, st_uid=0, st_gid=0, st_blksize=4096, st_blocks=0, st_rdev=makedev(1, 3), st_atime=2018-01-28T09:31:54+0000.452000000, st_mtime=2018-01-28T09:31:54+0000.452000000, st_ctime=2018-01-28T09:31:54+0000.452000000}) = 0
```

#### verbose

```
-e verbose=set
           Dereference structures for the specified set of system calls.  The default is verbose=all.
```

对指定的系统调用解引用数据结构。

strace -e trace=desc -e abbrev=none -e verbose=fstat cat /dev/null

```
fstat(3, 0x7ffdd78f77a0)                = 0
```

```
fstat(3, {st_dev=makedev(0, 6), st_ino=6, st_mode=S_IFCHR|0666, st_nlink=1, st_uid=0, st_gid=0, st_blksize=4096, st_blocks=0, st_rdev=makedev(1, 3), st_atime=2018-01-28T09:31:54+0000.452000000, st_mtime=2018-01-28T09:31:54+0000.452000000, st_ctime=2018-01-28T09:31:54+0000.452000000}) = 0
```


#### raw

```
-e raw=set  Print raw, undecoded arguments for the specified set of system calls.  This option has the effect of causing all arguments to be printed in hexadecimal.  This is mostly useful if you don't trust the decoding or you need to know the actual numeric value of an argument.
```
对指定的系统调用打印原始的未解析的参数。

strace -e trace=desc -e abbrev=none -e verbose=all -e raw=fstat cat /dev/null

```
fstat(0x3, 0x7ffcd2bf5630)              = 0
```

```
fstat(3, {st_dev=makedev(0, 6), st_ino=6, st_mode=S_IFCHR|0666, st_nlink=1, st_uid=0, st_gid=0, st_blksize=4096, st_blocks=0, st_rdev=makedev(1, 3), st_atime=2018-01-28T09:31:54+0000.452000000, st_mtime=2018-01-28T09:31:54+0000.452000000, st_ctime=2018-01-28T09:31:54+0000.452000000}) = 0
```

#### signal

```
-e signal=set
           Trace only the specified subset of signals.  The default is signal=all.  For example, signal =! SIGIO (or signal=!io) causes SIGIO signals not to be traced.
```

跟踪的信号子集


#### read

```
-e read=set Perform  a full hexadecimal and ASCII dump of all the data read from file descriptors listed in the specified set.  For example, to see all input activity on file descriptors 3 and 5 use -e read=3,5.  Note that this is independent from the normal tracing of the read(2) system call
           which is controlled by the option -e trace=read.
```

打印通过文件描述符指定的活跃输入文件的内容

#### write

```
-e write=set
           Perform a full hexadecimal and ASCII dump of all the data written to file descriptors listed in the specified set.  For example, to see all output activity on file descriptors 3 and 5 use -e write=3,5.  Note that this is independent from the normal tracing of the  write(2)  system
           call which is controlled by the option -e trace=write.
```

打印通过文件描述符指定的活跃输出文件的内容

#### fault

```
-e fault=set[:error=errno][:when=expr]
           Perform a syscall fault injection for the specified set of syscalls.  When a fault is injected into a syscall invocation, the syscall number is replaced by -1 which corresponds to an invalid syscall.

           If an error code is specified using a symbolic errno value like ENOSYS or a numeric value within 1..4095 range, this error code overrides the default error code returned by the kernel, which is traditionally ENOSYS for invalid syscall numbers on most architectures.

           Unless a :when=expr subexpression is specified, a fault is injected into every invocation of each syscall from the set.

           The format of the subexpression is one of the following:

             first
               For every syscall from the set, perform a syscall fault injection for the syscall invocation number first only.

             first+
               For every syscall from the set, perform syscall fault injections for the syscall invocation number first and all subsequent invocations.

             first+step
               For every syscall from the set, perform syscall fault injections for syscall invocations number first, first+step, first+step+step, and so on.

           For example, to fail each third and subsequent chdir syscalls with ENOENT, use -e fault=chdir:error=ENOENT:when=3+.

           The valid range for numbers first and step is 1..65535.

           If a fault expression contains multiple error= specifications, the last one takes precedence.  Likewise, if a fault expression contains multiple when= specifications, the last one takes precedence.

           Accounting of syscalls that are subject to fault injection is done per syscall and per tracee.

           Specification of syscall fault injection can be combined with other syscall filtering options, for example, -P /dev/urandom -e fault=all:error=ENOENT.
```

### -acolumn

设置系统调用输出命令时占用的列宽度。

```
strace -e trace=desc -e abbrev=none -e verbose=fstat -a292 cat /dev/null
```

### -ofile

```
strace -e trace=desc -e abbrev=none -e verbose=fstat -a292 -oresult.txt cat /dev/null
```

### -sstrsize

```
strace -e trace=desc -e abbrev=none -e verbose=fstat -a292 -oresult.txt -s10 cat /dev/null
```

### -Ppath

仅仅跟踪访问路径path的系统调用。

### -ppid

跟踪正在运行的进程。
