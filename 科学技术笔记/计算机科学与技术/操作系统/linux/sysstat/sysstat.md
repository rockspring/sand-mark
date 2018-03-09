## 安装

```
sudo apt-get install sysstat
```

## mpstat

```
$ mpstat
Linux 4.13.0-32-generic (ubuntu-artful) 	01/28/18 	_x86_64_	(2 CPU)

09:54:41     CPU    %usr   %nice    %sys %iowait    %irq   %soft  %steal  %guest  %gnice   %idle
09:54:41     all    0.22    0.01    0.36    0.10    0.00    0.02    0.00    0.00    0.00   99.29
```

## mpstat -P ALL

```
$ mpstat -P ALL
Linux 4.13.0-32-generic (ubuntu-artful) 	01/28/18 	_x86_64_	(2 CPU)

09:55:35     CPU    %usr   %nice    %sys %iowait    %irq   %soft  %steal  %guest  %gnice   %idle
09:55:35     all    0.22    0.01    0.35    0.09    0.00    0.02    0.00    0.00    0.00   99.31
09:55:35       0    0.19    0.00    0.35    0.08    0.00    0.02    0.00    0.00    0.00   99.36
09:55:35       1    0.25    0.01    0.35    0.11    0.00    0.02    0.00    0.00    0.00   99.26
```

## vmstat

```
$ vmstat
procs -----------memory---------- ---swap-- -----io---- -system-- ------cpu-----
 r  b   swpd   free   buff  cache   si   so    bi    bo   in   cs us sy id wa st
 1  0      0 704120  13048 220392    0    0    69     7   22   27  0  0 99  0  0
```


## iostat

```
$ iostat
Linux 4.13.0-32-generic (ubuntu-artful) 	01/28/18 	_x86_64_	(2 CPU)

avg-cpu:  %user   %nice %system %iowait  %steal   %idle
           0.21    0.01    0.36    0.09    0.00   99.34

Device             tps    kB_read/s    kB_wrtn/s    kB_read    kB_wrtn
sdb               0.12         1.33         0.00       2014          0
sda               4.97       132.65        14.70     200387      22208
```
