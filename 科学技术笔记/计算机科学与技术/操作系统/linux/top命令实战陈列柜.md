# top命令实战

## 1 定时显示指定进程的top结果，每个指定时间显示一次，多次的结果依次输出到标准输出控制台

```
top -c -b -p [进程ID] -d [间隔时间（单位为s）]
```

```
-c  :Command-line/Program-name toggle
    Starts  top  with the last remembered 'c' state reversed.  Thus, if top was displaying command lines, now that field will show program names, and visa versa.  See
    the 'c' interactive command for additional information.

-b  :Batch-mode operation
    Starts top in 'Batch' mode, which could be useful for sending output from top to other programs or to a file.  In this mode, top will not accept  input  and  runs
    until the iterations limit you've set with the '-n' command-line option or until killed.

-p  :Monitor-PIDs mode as:  -pN1 -pN2 ...  or  -pN1,N2,N3 ...
    Monitor only processes with specified process IDs.  This option can be given up to 20 times, or you can provide a comma delimited list with up to  20  pids.   Co-
    mingling both approaches is permitted.

    A pid value of zero will be treated as the process id of the top program itself once it is running.

    This  is  a  command-line  option only and should you wish to return to normal operation, it is not necessary to quit and restart top  --  just issue any of these
    interactive commands: '=', 'u' or 'U'.

    The 'p', 'u' and 'U' command-line options are mutually exclusive.


-d  :Delay-time interval as:  -d ss.t (secs.tenths)
    Specifies the delay between screen updates, and overrides the corresponding value in one's personal configuration file or the startup default.  Later this can  be
    changed with the 'd' or 's' interactive commands.

    Fractional  seconds  are  honored,  but  a negative number is not allowed.  In all cases, however, such changes are prohibited if top is running in 'Secure mode',
    except for root (unless the 's' command-line option was used).  For additional information on 'Secure mode' see topic 6a. SYSTEM Configuration File.
```

### 例子

监控系统的rsyslogd进程，两次显示结果如下所示

```
top -c -b -p 464 -d 10
```

```
top - 12:08:02 up 2 days,  1:08,  1 user,  load average: 0.08, 0.03, 0.05
Tasks:   1 total,   0 running,   1 sleeping,   0 stopped,   0 zombie
%Cpu(s):  0.5 us,  0.5 sy,  0.0 ni, 99.0 id,  0.0 wa,  0.0 hi,  0.0 si,  0.0 st
KiB Mem:   2049988 total,   991744 used,  1058244 free,    82924 buffers
KiB Swap:  3063804 total,        0 used,  3063804 free.   774180 cached Mem

  PID USER      PR  NI    VIRT    RES    SHR S  %CPU %MEM     TIME+ COMMAND
  464 syslog    20   0  255832   1568    944 S   0.0  0.1   0:00.12 rsyslogd

top - 12:08:12 up 2 days,  1:08,  1 user,  load average: 0.07, 0.03, 0.05
Tasks:   1 total,   0 running,   1 sleeping,   0 stopped,   0 zombie
%Cpu(s):  0.0 us,  0.1 sy,  0.0 ni, 99.9 id,  0.0 wa,  0.0 hi,  0.0 si,  0.0 st
KiB Mem:   2049988 total,   991752 used,  1058236 free,    82924 buffers
KiB Swap:  3063804 total,        0 used,  3063804 free.   774164 cached Mem

  PID USER      PR  NI    VIRT    RES    SHR S  %CPU %MEM     TIME+ COMMAND
  464 syslog    20   0  255832   1568    944 S   0.0  0.1   0:00.12 rsyslogd
```
