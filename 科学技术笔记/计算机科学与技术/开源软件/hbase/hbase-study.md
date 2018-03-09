zookeeper    org.apache.hadoop.hbase.zookeeper.HQuorumPeer
mapredcp     org.apache.hadoop.hbase.util.MapreduceDependencyClasspathTool
pe           org.apache.hadoop.hbase.PerformanceEvaluation
ltt          org.apache.hadoop.hbase.util.LoadTestTool
canary       org.apache.hadoop.hbase.tool.Canary
version      org.apache.hadoop.hbase.util.VersionInfo



hbase shell是ruby语言实现的，运行在jruby上。

ruby脚本在lib/ruby目录


```
java    10824 shg4873  132u     IPv6             382381      0t0      TCP *:2181 (LISTEN)
java    10824 shg4873  141u     IPv6             381406      0t0      TCP shg4873-ThinkPad-L460:37893 (LISTEN)
java    10824 shg4873  182u     IPv6             383169      0t0      TCP localhost:60190->localhost:2181 (ESTABLISHED)
java    10824 shg4873  183u     IPv6             381421      0t0      TCP localhost:2181->localhost:60190 (ESTABLISHED)
java    10824 shg4873  185u     IPv6             381422      0t0      TCP *:16010 (LISTEN)
java    10824 shg4873  189u     IPv6             383170      0t0      TCP shg4873-ThinkPad-L460:32807 (LISTEN)
java    10824 shg4873  229u     IPv6             381432      0t0      TCP localhost:60192->localhost:2181 (ESTABLISHED)
java    10824 shg4873  230u     IPv6             381433      0t0      TCP localhost:2181->localhost:60192 (ESTABLISHED)
java    10824 shg4873  231u     IPv6             383173      0t0      TCP *:38329 (LISTEN)
java    10824 shg4873  244u     IPv6             378509      0t0      TCP localhost:60198->localhost:2181 (ESTABLISHED)
java    10824 shg4873  245u     IPv6             382391      0t0      TCP localhost:2181->localhost:60198 (ESTABLISHED)
java    10824 shg4873  246u     IPv6             378510      0t0      TCP localhost:60200->localhost:2181 (ESTABLISHED)
java    10824 shg4873  247u     IPv6             382392      0t0      TCP localhost:2181->localhost:60200 (ESTABLISHED)
java    10824 shg4873  248u     IPv6             378511      0t0      TCP localhost:60202->localhost:2181 (ESTABLISHED)
java    10824 shg4873  249u     IPv6             382393      0t0      TCP localhost:2181->localhost:60202 (ESTABLISHED)
java    10824 shg4873  254u     IPv6             382657      0t0      TCP localhost:60204->localhost:2181 (ESTABLISHED)
java    10824 shg4873  255u     IPv6             381438      0t0      TCP localhost:2181->localhost:60204 (ESTABLISHED)
java    10824 shg4873  256u     IPv6             382659      0t0      TCP shg4873-ThinkPad-L460:46849->shg4873-ThinkPad-L460:37893 (ESTABLISHED)
java    10824 shg4873  257u     IPv6             383429      0t0      TCP shg4873-ThinkPad-L460:37893->shg4873-ThinkPad-L460:46849 (ESTABLISHED)
java    10824 shg4873  262u     IPv6             386369      0t0      TCP localhost:40764->shg4873-ThinkPad-L460:32807 (ESTABLISHED)
java    10824 shg4873  263u     IPv6             387209      0t0      TCP shg4873-ThinkPad-L460:32807->localhost:40764 (ESTABLISHED)
```

http://10.249.30.179:16010/master-status
http://10.249.30.179:38329/rs-status




## RPC request调度器

RpcScheduler（抽象类）


DelegatingRpcScheduler


FifoRpcScheduler


SimpleRpcScheduler


## CallRunner请求调用运行器

执行请求处理逻辑，通常由RpcScheduler调度派遣到一个线程池中的某个线程执行。

## RpcCall 单个RPC方法调用需要的东西

org.apache.hadoop.hbase.ipc.SimpleRpcServer.Call --（实现）--> org.apache.hadoop.hbase.ipc.RpcServer.Call --（实现）--> RpcCall

## RpcServerInterface RPC服务器，处理RPC方法调用