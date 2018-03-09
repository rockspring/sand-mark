# ifconfig

## 1 ifconfig输出网卡信息

```
ifconfig
```

输出结果

```
eth0      Link encap:Ethernet  HWaddr 08:00:27:98:dc:aa
          inet addr:10.0.2.15  Bcast:10.0.2.255  Mask:255.255.255.0
          inet6 addr: fe80::a00:27ff:fe98:dcaa/64 Scope:Link
          UP BROADCAST RUNNING MULTICAST  MTU:1500  Metric:1
          RX packets:525 errors:0 dropped:0 overruns:0 frame:0
          TX packets:447 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:1000
          RX bytes:56908 (56.9 KB)  TX bytes:50967 (50.9 KB)

eth1      Link encap:Ethernet  HWaddr 08:00:27:5f:a2:c5
          inet addr:192.168.33.10  Bcast:192.168.33.255  Mask:255.255.255.0
          inet6 addr: fe80::a00:27ff:fe5f:a2c5/64 Scope:Link
          UP BROADCAST RUNNING MULTICAST  MTU:1500  Metric:1
          RX packets:0 errors:0 dropped:0 overruns:0 frame:0
          TX packets:18 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:1000
          RX bytes:0 (0.0 B)  TX bytes:1596 (1.5 KB)

lo        Link encap:Local Loopback
          inet addr:127.0.0.1  Mask:255.0.0.0
          inet6 addr: ::1/128 Scope:Host
          UP LOOPBACK RUNNING  MTU:65536  Metric:1
          RX packets:240 errors:0 dropped:0 overruns:0 frame:0
          TX packets:240 errors:0 dropped:0 overruns:0 carrier:0
          collisions:0 txqueuelen:0
          RX bytes:19104 (19.1 KB)  TX bytes:19104 (19.1 KB)
```

## 2 过滤出包含IP地址的行

```
~$ ifconfig | grep inet
```

```
          inet addr:10.0.2.15  Bcast:10.0.2.255  Mask:255.255.255.0
          inet6 addr: fe80::a00:27ff:fe98:dcaa/64 Scope:Link
          inet addr:192.168.33.10  Bcast:192.168.33.255  Mask:255.255.255.0
          inet6 addr: fe80::a00:27ff:fe5f:a2c5/64 Scope:Link
          inet addr:127.0.0.1  Mask:255.0.0.0
          inet6 addr: ::1/128 Scope:Host
```

## 3 抽取出所有网卡的IP地址

```
~$ ifconfig | grep "inet addr" | awk '{print $2}' | awk -F ':' '{print $2}'
```

```
10.0.2.15
192.168.33.10
127.0.0.1
```

## 4 判断一个IP地址是不是本机网卡的IP地址，如果是，输出IP地址

```
~$ ip=192.168.33.10
~$ ifconfig | grep "inet addr" | awk '{print $2}' | awk -F ':' '{if ($2 == "'$ip'"){print $2}}'
```

```
192.168.33.10
```