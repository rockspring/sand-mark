# netperf

netperf - a network performance benchmark

```
$ netserver -p 12865

$ netperf -H 127.0.0.1 -t TCP_RR -- -o RT_LATENCY

MIGRATED TCP REQUEST/RESPONSE TEST from (null) (0.0.0.0) port 0 AF_INET to (null) () port 0 AF_INET : first burst 0
Round Trip Latency usec/tran
28.072
```

## 参数详解

```
-H name|ip,family (*)
      Set the hostname (or IP address) and address family to use to establish the control connection to the remote system. Passing a single name with no comma will only set remote_host and will leave selec-
      tion of address family for the control connection to the stack or by a -4 -r -6 command line option.
```
