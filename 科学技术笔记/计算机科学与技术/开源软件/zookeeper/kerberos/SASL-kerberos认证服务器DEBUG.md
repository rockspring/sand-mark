## 服务端启动


```
vagrant@ubuntu-14:/vagrant/projects/server/zookeeper/zookeeper-3.4.8$ bin/zkServer.sh start-foreground
ZooKeeper JMX enabled by default
Using config: /vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf/zoo.cfg
2016-04-18 03:55:43,968 [myid:] - INFO  [main:QuorumPeerConfig@103] - Reading configuration from: /vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf/zoo.cfg
2016-04-18 03:55:43,982 [myid:] - INFO  [main:DatadirCleanupManager@78] - autopurge.snapRetainCount set to 3
2016-04-18 03:55:43,983 [myid:] - INFO  [main:DatadirCleanupManager@79] - autopurge.purgeInterval set to 0
2016-04-18 03:55:43,984 [myid:] - INFO  [main:DatadirCleanupManager@101] - Purge task is not scheduled.
2016-04-18 03:55:43,985 [myid:] - WARN  [main:QuorumPeerMain@113] - Either no config or no quorum defined in config, running  in standalone mode
2016-04-18 03:55:44,000 [myid:] - DEBUG [main:AbstractDynamicMBean@148] - preRegister called. Server=com.sun.jmx.mbeanserver.JmxMBeanServer@765e06ef, name=log4j:hiearchy=default
2016-04-18 03:55:44,001 [myid:] - DEBUG [main:HierarchyDynamicMBean@260] - postRegister is called.
2016-04-18 03:55:44,004 [myid:] - DEBUG [main:AbstractDynamicMBean@148] - preRegister called. Server=com.sun.jmx.mbeanserver.JmxMBeanServer@765e06ef, name=log4j:logger=root
2016-04-18 03:55:44,005 [myid:] - DEBUG [main:LoggerDynamicMBean@258] - Adding AppenderMBean for appender named CONSOLE
2016-04-18 03:55:44,009 [myid:] - DEBUG [main:AppenderDynamicMBean@158] - getMBeanInfo called.
2016-04-18 03:55:44,010 [myid:] - DEBUG [main:AppenderDynamicMBean@337] - preRegister called. Server=com.sun.jmx.mbeanserver.JmxMBeanServer@765e06ef, name=log4j:appender=CONSOLE
2016-04-18 03:55:44,010 [myid:] - DEBUG [main:AppenderDynamicMBean@197] - Adding LayoutMBean:CONSOLE,layout=org.apache.log4j.PatternLayout
2016-04-18 03:55:44,012 [myid:] - DEBUG [main:LayoutDynamicMBean@140] - getMBeanInfo called.
2016-04-18 03:55:44,013 [myid:] - DEBUG [main:AbstractDynamicMBean@148] - preRegister called. Server=com.sun.jmx.mbeanserver.JmxMBeanServer@765e06ef, name=log4j:appender=CONSOLE,layout=org.apache.log4j.PatternLayout
2016-04-18 03:55:44,014 [myid:] - DEBUG [main:HierarchyDynamicMBean@128] - ---Adding logger [root] as listener.
2016-04-18 03:55:44,016 [myid:] - DEBUG [main:AbstractDynamicMBean@148] - preRegister called. Server=com.sun.jmx.mbeanserver.JmxMBeanServer@765e06ef, name=log4j:logger=org.apache.log4j.jmx.LayoutDynamicMBean
2016-04-18 03:55:44,024 [myid:] - DEBUG [main:HierarchyDynamicMBean@128] - ---Adding logger [org.apache.log4j.jmx.LayoutDynamicMBean] as listener.
2016-04-18 03:55:44,025 [myid:] - DEBUG [main:AbstractDynamicMBean@148] - preRegister called. Server=com.sun.jmx.mbeanserver.JmxMBeanServer@765e06ef, name=log4j:logger=org.apache.zookeeper.server.quorum.QuorumPeerMain
2016-04-18 03:55:44,026 [myid:] - DEBUG [main:HierarchyDynamicMBean@128] - ---Adding logger [org.apache.zookeeper.server.quorum.QuorumPeerMain] as listener.
2016-04-18 03:55:44,027 [myid:] - DEBUG [main:AbstractDynamicMBean@148] - preRegister called. Server=com.sun.jmx.mbeanserver.JmxMBeanServer@765e06ef, name=log4j:logger=org.apache.log4j.jmx.LoggerDynamicMBean
2016-04-18 03:55:44,028 [myid:] - DEBUG [main:HierarchyDynamicMBean@128] - ---Adding logger [org.apache.log4j.jmx.LoggerDynamicMBean] as listener.
2016-04-18 03:55:44,028 [myid:] - DEBUG [main:AbstractDynamicMBean@148] - preRegister called. Server=com.sun.jmx.mbeanserver.JmxMBeanServer@765e06ef, name=log4j:logger=org.apache.zookeeper.server.quorum.QuorumPeerConfig
2016-04-18 03:55:44,029 [myid:] - DEBUG [main:HierarchyDynamicMBean@128] - ---Adding logger [org.apache.zookeeper.server.quorum.QuorumPeerConfig] as listener.
2016-04-18 03:55:44,030 [myid:] - DEBUG [main:AbstractDynamicMBean@148] - preRegister called. Server=com.sun.jmx.mbeanserver.JmxMBeanServer@765e06ef, name=log4j:logger=org.apache.zookeeper.server.ZooKeeperServerMain
2016-04-18 03:55:44,031 [myid:] - DEBUG [main:HierarchyDynamicMBean@128] - ---Adding logger [org.apache.zookeeper.server.ZooKeeperServerMain] as listener.
2016-04-18 03:55:44,032 [myid:] - DEBUG [main:AbstractDynamicMBean@148] - preRegister called. Server=com.sun.jmx.mbeanserver.JmxMBeanServer@765e06ef, name=log4j:logger=org.apache.zookeeper.jmx.MBeanRegistry
2016-04-18 03:55:44,032 [myid:] - DEBUG [main:HierarchyDynamicMBean@128] - ---Adding logger [org.apache.zookeeper.jmx.MBeanRegistry] as listener.
2016-04-18 03:55:44,033 [myid:] - DEBUG [main:AbstractDynamicMBean@148] - preRegister called. Server=com.sun.jmx.mbeanserver.JmxMBeanServer@765e06ef, name=log4j:logger=org.apache.log4j.jmx.HierarchyDynamicMBean
2016-04-18 03:55:44,034 [myid:] - DEBUG [main:HierarchyDynamicMBean@128] - ---Adding logger [org.apache.log4j.jmx.HierarchyDynamicMBean] as listener.
2016-04-18 03:55:44,035 [myid:] - DEBUG [main:AbstractDynamicMBean@148] - preRegister called. Server=com.sun.jmx.mbeanserver.JmxMBeanServer@765e06ef, name=log4j:logger=org.apache.log4j.jmx.AppenderDynamicMBean
2016-04-18 03:55:44,035 [myid:] - DEBUG [main:HierarchyDynamicMBean@128] - ---Adding logger [org.apache.log4j.jmx.AppenderDynamicMBean] as listener.
2016-04-18 03:55:44,036 [myid:] - DEBUG [main:AbstractDynamicMBean@148] - preRegister called. Server=com.sun.jmx.mbeanserver.JmxMBeanServer@765e06ef, name=log4j:logger=org.apache.zookeeper.server.DatadirCleanupManager
2016-04-18 03:55:44,039 [myid:] - DEBUG [main:HierarchyDynamicMBean@128] - ---Adding logger [org.apache.zookeeper.server.DatadirCleanupManager] as listener.
2016-04-18 03:55:44,043 [myid:] - INFO  [main:QuorumPeerConfig@103] - Reading configuration from: /vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf/zoo.cfg
2016-04-18 03:55:44,051 [myid:] - INFO  [main:ZooKeeperServerMain@95] - Starting server
2016-04-18 03:55:44,082 [myid:] - INFO  [main:Environment@100] - Server environment:zookeeper.version=3.4.8--1, built on 02/06/2016 03:18 GMT
2016-04-18 03:55:44,083 [myid:] - INFO  [main:Environment@100] - Server environment:host.name=ubuntu-14.04-amd64-vbox
2016-04-18 03:55:44,084 [myid:] - INFO  [main:Environment@100] - Server environment:java.version=1.7.0_95
2016-04-18 03:55:44,085 [myid:] - INFO  [main:Environment@100] - Server environment:java.vendor=Oracle Corporation
2016-04-18 03:55:44,085 [myid:] - INFO  [main:Environment@100] - Server environment:java.home=/usr/lib/jvm/java-7-openjdk-amd64/jre
2016-04-18 03:55:44,086 [myid:] - INFO  [main:Environment@100] - Server environment:java.class.path=/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../build/classes:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../build/lib/*.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/slf4j-log4j12-1.6.1.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/slf4j-api-1.6.1.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/netty-3.7.0.Final.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/log4j-1.2.16.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/jline-0.9.94.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../zookeeper-3.4.8.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../src/java/lib/*.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf:
2016-04-18 03:55:44,087 [myid:] - INFO  [main:Environment@100] - Server environment:java.library.path=/usr/java/packages/lib/amd64:/usr/lib/x86_64-linux-gnu/jni:/lib/x86_64-linux-gnu:/usr/lib/x86_64-linux-gnu:/usr/lib/jni:/lib:/usr/lib
2016-04-18 03:55:44,088 [myid:] - INFO  [main:Environment@100] - Server environment:java.io.tmpdir=/tmp
2016-04-18 03:55:44,088 [myid:] - INFO  [main:Environment@100] - Server environment:java.compiler=<NA>
2016-04-18 03:55:44,089 [myid:] - INFO  [main:Environment@100] - Server environment:os.name=Linux
2016-04-18 03:55:44,090 [myid:] - INFO  [main:Environment@100] - Server environment:os.arch=amd64
2016-04-18 03:55:44,090 [myid:] - INFO  [main:Environment@100] - Server environment:os.version=3.13.0-24-generic
2016-04-18 03:55:44,091 [myid:] - INFO  [main:Environment@100] - Server environment:user.name=vagrant
2016-04-18 03:55:44,092 [myid:] - INFO  [main:Environment@100] - Server environment:user.home=/home/vagrant
2016-04-18 03:55:44,093 [myid:] - INFO  [main:Environment@100] - Server environment:user.dir=/vagrant/projects/server/zookeeper/zookeeper-3.4.8
2016-04-18 03:55:44,109 [myid:] - DEBUG [main:FileTxnSnapLog@79] - Opening datadir:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/data snapDir:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/data
2016-04-18 03:55:44,126 [myid:] - INFO  [main:ZooKeeperServer@787] - tickTime set to 2000
2016-04-18 03:55:44,128 [myid:] - INFO  [main:ZooKeeperServer@796] - minSessionTimeout set to -1
2016-04-18 03:55:44,130 [myid:] - INFO  [main:ZooKeeperServer@805] - maxSessionTimeout set to -1
2016-04-18 03:55:44,309 [myid:] - INFO  [main:Login@294] - successfully logged in.
2016-04-18 03:55:44,315 [myid:] - INFO  [Thread-1:Login$1@127] - TGT refresh thread started.
2016-04-18 03:55:44,320 [myid:] - INFO  [main:NIOServerCnxnFactory@89] - binding to port 0.0.0.0/0.0.0.0:2181
2016-04-18 03:55:44,326 [myid:] - DEBUG [Thread-1:Login@320] - Found tgt Ticket (hex) =
0000: 61 82 01 46 30 82 01 42   A0 03 02 01 05 A1 0B 1B  a..F0..B........
0010: 09 4C 4F 43 41 4C 48 4F   53 54 A2 1E 30 1C A0 03  .LOCALHOST..0...
0020: 02 01 02 A1 15 30 13 1B   06 6B 72 62 74 67 74 1B  .....0...krbtgt.
0030: 09 4C 4F 43 41 4C 48 4F   53 54 A3 82 01 0C 30 82  .LOCALHOST....0.
0040: 01 08 A0 03 02 01 12 A1   03 02 01 01 A2 81 FB 04  ................
0050: 81 F8 F2 E6 63 C0 45 E7   F0 AD 04 DF 56 75 0C 22  ....c.E.....Vu."
0060: 43 8A 06 F4 CD A5 20 E7   4A F4 5C 36 54 DE 47 B8  C..... .J.\6T.G.
0070: 10 20 8A 9A 1C 79 94 C6   0F 88 D6 53 83 08 DA D8  . ...y.....S....
0080: 7A 91 CE D3 C3 14 94 B3   B3 5F 1A 06 11 EE 9D 94  z........_......
0090: 96 F1 84 FD B6 DF 85 50   09 BD 14 E5 D8 0D DC 15  .......P........
00A0: 99 E4 11 7A 63 93 6F 1B   8B 4E 60 9E 7E 5B 3B 0B  ...zc.o..N`..[;.
00B0: 6E F3 9E 6D 39 9B 0B AE   DC 15 45 10 FC 3A 7E 6A  n..m9.....E..:.j
00C0: 9B 01 27 C6 D5 17 6D 9B   1E 8C 09 F4 7B 1B D8 58  ..'...m........X
00D0: 35 36 B9 BE 98 33 72 2F   62 E5 00 B8 3C AD 39 F8  56...3r/b...<.9.
00E0: 74 41 6C 83 08 BD 61 4A   3E 6B 4D 90 40 AE 8A A7  tAl...aJ>kM.@...
00F0: 9D 19 94 76 6C DD 7F 01   ED C9 CE 24 5B C4 1E D2  ...vl......$[...
0100: A2 19 62 39 86 95 8D 49   65 19 AE 74 5F 11 3A 7E  ..b9...Ie..t_.:.
0110: 6D E8 18 9E 69 7B 4E 75   6B 38 8A A0 DF EC 39 A5  m...i.Nuk8....9.
0120: F5 45 21 E4 49 AC CE EB   56 D1 64 92 D9 3D E2 CE  .E!.I...V.d..=..
0130: F9 6C FD A0 D5 76 4D B3   21 8A 43 CF 56 B9 07 5B  .l...vM.!.C.V..[
0140: 90 DA 17 FE EC 0E 96 F7   14 D7                    ..........

Client Principal = zookeeper/localhost@LOCALHOST
Server Principal = krbtgt/LOCALHOST@LOCALHOST
Session Key = EncryptionKey: keyType=18 keyBytes (hex dump)=
0000: 58 EC 45 EA 34 32 A4 D1   B7 9C D5 08 74 4A B4 DA  X.E.42......tJ..
0010: 8C A1 5D 24 62 E4 12 9F   7D 2D 7C 25 7B C2 57 63  ..]$b....-.%..Wc


Forwardable Ticket true
Forwarded Ticket false
Proxiable Ticket true
Proxy Ticket false
Postdated Ticket false
Renewable Ticket false
Initial Ticket false
Auth Time = Mon Apr 18 03:55:44 UTC 2016
Start Time = Mon Apr 18 03:55:44 UTC 2016
End Time = Mon Apr 18 13:55:44 UTC 2016
Renew Till = null
Client Addresses  Null .
2016-04-18 03:55:44,337 [myid:] - INFO  [Thread-1:Login@302] - TGT valid starting at:        Mon Apr 18 03:55:44 UTC 2016
2016-04-18 03:55:44,338 [myid:] - INFO  [Thread-1:Login@303] - TGT expires:                  Mon Apr 18 13:55:44 UTC 2016
2016-04-18 03:55:44,339 [myid:] - INFO  [Thread-1:Login$1@182] - TGT refresh sleeping until: Mon Apr 18 12:02:49 UTC 2016
2016-04-18 03:55:44,364 [myid:] - DEBUG [main:FileTxnLog$FileTxnIterator@598] - Created new input stream /vagrant/projects/server/zookeeper/zookeeper-3.4.8/data/version-2/log.1
2016-04-18 03:55:44,366 [myid:] - DEBUG [main:FileTxnLog$FileTxnIterator@601] - Created new input archive /vagrant/projects/server/zookeeper/zookeeper-3.4.8/data/version-2/log.1
2016-04-18 03:55:44,392 [myid:] - DEBUG [main:FileTxnLog$FileTxnIterator@641] - EOF excepton java.io.EOFException: Failed to read /vagrant/projects/server/zookeeper/zookeeper-3.4.8/data/version-2/log.1
2016-04-18 03:55:44,393 [myid:] - DEBUG [main:FileTxnLog$FileTxnIterator@598] - Created new input stream /vagrant/projects/server/zookeeper/zookeeper-3.4.8/data/version-2/log.3
2016-04-18 03:55:44,394 [myid:] - DEBUG [main:FileTxnLog$FileTxnIterator@601] - Created new input archive /vagrant/projects/server/zookeeper/zookeeper-3.4.8/data/version-2/log.3
2016-04-18 03:55:44,395 [myid:] - DEBUG [main:FileTxnLog$FileTxnIterator@641] - EOF excepton java.io.EOFException: Failed to read /vagrant/projects/server/zookeeper/zookeeper-3.4.8/data/version-2/log.3
2016-04-18 03:55:44,510 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:NIOServerCnxnFactory@192] - Accepted socket connection from /127.0.0.1:60951
2016-04-18 03:55:44,515 [myid:] - DEBUG [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperSaslServer@78] - serviceHostname is 'localhost'
2016-04-18 03:55:44,515 [myid:] - DEBUG [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperSaslServer@79] - servicePrincipalName is 'zookeeper'
2016-04-18 03:55:44,515 [myid:] - DEBUG [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperSaslServer@80] - SASL mechanism(mech) is 'GSSAPI'
2016-04-18 03:55:44,584 [myid:] - DEBUG [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperServer@842] - Session establishment request from client /127.0.0.1:60951 client's lastZxid is 0x3
2016-04-18 03:55:44,587 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperServer@893] - Client attempting to renew session 0x15427812a090000 at /127.0.0.1:60951
2016-04-18 03:55:44,593 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperServer@645] - Established session 0x15427812a090000 with negotiated timeout 30000 for client /127.0.0.1:60951
2016-04-18 03:55:44,595 [myid:] - DEBUG [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperServer@981] - Responding to client SASL token.
2016-04-18 03:55:44,596 [myid:] - DEBUG [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperServer@985] - Size of client SASL token: 582
2016-04-18 03:55:44,609 [myid:] - DEBUG [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperServer@1016] - Size of server SASL response: 32
2016-04-18 03:55:44,613 [myid:] - DEBUG [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperServer@981] - Responding to client SASL token.
2016-04-18 03:55:44,613 [myid:] - DEBUG [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperServer@985] - Size of client SASL token: 52
2016-04-18 03:55:44,615 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:SaslServerCallbackHandler@118] - Successfully authenticated client: authenticationID=myzkclient@LOCALHOST;  authorizationID=myzkclient@LOCALHOST.
2016-04-18 03:55:44,620 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:SaslServerCallbackHandler@134] - Setting authorizedID: myzkclient@LOCALHOST
2016-04-18 03:55:44,621 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperServer@996] - adding SASL authorization for authorizationID: myzkclient@LOCALHOST
2016-04-18 03:55:54,519 [myid:] - DEBUG [SyncThread:0:FinalRequestProcessor@88] - Processing request:: sessionid:0x15427812a090000 type:ping cxid:0xfffffffffffffffe zxid:0xfffffffffffffffe txntype:unknown reqpath:n/a
2016-04-18 03:55:54,520 [myid:] - DEBUG [SyncThread:0:FinalRequestProcessor@160] - sessionid:0x15427812a090000 type:ping cxid:0xfffffffffffffffe zxid:0xfffffffffffffffe txntype:unknown reqpath:n/a
2016-04-18 03:56:04,531 [myid:] - DEBUG [SyncThread:0:FinalRequestProcessor@88] - Processing request:: sessionid:0x15427812a090000 type:ping cxid:0xfffffffffffffffe zxid:0xfffffffffffffffe txntype:unknown reqpath:n/a
2016-04-18 03:56:04,532 [myid:] - DEBUG [SyncThread:0:FinalRequestProcessor@160] - sessionid:0x15427812a090000 type:ping cxid:0xfffffffffffffffe zxid:0xfffffffffffffffe txntype:un
```

## 客户端启动

```
vagrant@ubuntu-14:/vagrant/projects/server/zookeeper/zookeeper-3.4.8$ bin/zkCli.sh -server localhost:2181
Connecting to localhost:2181
2016-04-18 03:57:25,760 [myid:] - INFO  [main:Environment@100] - Client environment:zookeeper.version=3.4.8--1, built on 02/06/2016 03:18 GMT
2016-04-18 03:57:25,768 [myid:] - INFO  [main:Environment@100] - Client environment:host.name=ubuntu-14.04-amd64-vbox
2016-04-18 03:57:25,768 [myid:] - INFO  [main:Environment@100] - Client environment:java.version=1.7.0_95
2016-04-18 03:57:25,772 [myid:] - INFO  [main:Environment@100] - Client environment:java.vendor=Oracle Corporation
2016-04-18 03:57:25,772 [myid:] - INFO  [main:Environment@100] - Client environment:java.home=/usr/lib/jvm/java-7-openjdk-amd64/jre
2016-04-18 03:57:25,773 [myid:] - INFO  [main:Environment@100] - Client environment:java.class.path=/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../build/classes:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../build/lib/*.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/slf4j-log4j12-1.6.1.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/slf4j-api-1.6.1.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/netty-3.7.0.Final.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/log4j-1.2.16.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/jline-0.9.94.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../zookeeper-3.4.8.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../src/java/lib/*.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf:
2016-04-18 03:57:25,773 [myid:] - INFO  [main:Environment@100] - Client environment:java.library.path=/usr/java/packages/lib/amd64:/usr/lib/x86_64-linux-gnu/jni:/lib/x86_64-linux-gnu:/usr/lib/x86_64-linux-gnu:/usr/lib/jni:/lib:/usr/lib
2016-04-18 03:57:25,773 [myid:] - INFO  [main:Environment@100] - Client environment:java.io.tmpdir=/tmp
2016-04-18 03:57:25,773 [myid:] - INFO  [main:Environment@100] - Client environment:java.compiler=<NA>
2016-04-18 03:57:25,774 [myid:] - INFO  [main:Environment@100] - Client environment:os.name=Linux
2016-04-18 03:57:25,774 [myid:] - INFO  [main:Environment@100] - Client environment:os.arch=amd64
2016-04-18 03:57:25,774 [myid:] - INFO  [main:Environment@100] - Client environment:os.version=3.13.0-24-generic
2016-04-18 03:57:25,774 [myid:] - INFO  [main:Environment@100] - Client environment:user.name=vagrant
2016-04-18 03:57:25,775 [myid:] - INFO  [main:Environment@100] - Client environment:user.home=/home/vagrant
2016-04-18 03:57:25,775 [myid:] - INFO  [main:Environment@100] - Client environment:user.dir=/vagrant/projects/server/zookeeper/zookeeper-3.4.8
2016-04-18 03:57:25,777 [myid:] - INFO  [main:ZooKeeper@438] - Initiating client connection, connectString=localhost:2181 sessionTimeout=30000 watcher=org.apache.zookeeper.ZooKeeperMain$MyWatcher@43d6e29a
2016-04-18 03:57:25,790 [myid:] - DEBUG [main:ClientCnxn@117] - zookeeper.disableAutoWatchReset is false
Welcome to ZooKeeper!
2016-04-18 03:57:25,849 [myid:] - DEBUG [main-SendThread(localhost:2181):ZooKeeperSaslClient@222] - JAAS loginContext is: Client
JLine support is enabled
Debug is  true storeKey true useTicketCache false useKeyTab true doNotPrompt false ticketCache is null isInitiator true KeyTab is /vagrant/projects/server/zookeeper/myzkclient.keytab refreshKrb5Config is false principal is myzkclient tryFirstPass is false useFirstPass is false storePass is false clearPass is false
[zk: localhost:2181(CONNECTING) 0] principal is myzkclient@LOCALHOST
Will use keytab
Commit Succeeded

2016-04-18 03:57:26,062 [myid:] - INFO  [main-SendThread(localhost:2181):Login@294] - successfully logged in.
2016-04-18 03:57:26,065 [myid:] - INFO  [Thread-1:Login$1@127] - TGT refresh thread started.
2016-04-18 03:57:26,073 [myid:] - INFO  [main-SendThread(localhost:2181):ZooKeeperSaslClient$1@285] - Client will use GSSAPI as SASL mechanism.
2016-04-18 03:57:26,073 [myid:] - DEBUG [main-SendThread(localhost:2181):ZooKeeperSaslClient$1@287] - creating sasl client: client=myzkclient@LOCALHOST;service=zookeeper;serviceHostname=localhost
2016-04-18 03:57:26,076 [myid:] - DEBUG [Thread-1:Login@320] - Found tgt Ticket (hex) =
0000: 61 82 01 3B 30 82 01 37   A0 03 02 01 05 A1 0B 1B  a..;0..7........
0010: 09 4C 4F 43 41 4C 48 4F   53 54 A2 1E 30 1C A0 03  .LOCALHOST..0...
0020: 02 01 02 A1 15 30 13 1B   06 6B 72 62 74 67 74 1B  .....0...krbtgt.
0030: 09 4C 4F 43 41 4C 48 4F   53 54 A3 82 01 01 30 81  .LOCALHOST....0.
0040: FE A0 03 02 01 12 A1 03   02 01 01 A2 81 F1 04 81  ................
0050: EE 73 20 C7 14 C9 EC 74   52 E5 C7 C3 B1 8A 8D A9  .s ....tR.......
0060: E2 36 62 C2 CE D7 B1 6A   FA 33 F9 D3 45 8B 18 74  .6b....j.3..E..t
0070: F7 50 1E D9 9F F8 F1 91   D1 B5 86 0C A9 D3 ED 5E  .P.............^
0080: D1 8A D3 89 26 89 79 FB   16 48 84 CA E5 83 2B 7B  ....&.y..H....+.
0090: D6 5C 8D 21 C2 C2 6E BC   6A EF 48 A6 72 A8 2C 74  .\.!..n.j.H.r.,t
00A0: 6C 6C 87 E0 2D 6E DF 4B   52 62 46 32 01 2C 1E CA  ll..-n.KRbF2.,..
00B0: 58 40 4C 3E FA E6 B9 45   3B 52 CF 0B 88 44 0D FB  X@L>...E;R...D..
00C0: 9A 63 64 38 E8 C7 A1 DC   26 1D F8 38 C7 C9 1D 95  .cd8....&..8....
00D0: 3B 15 54 C7 FD 3C A1 E9   E8 64 13 65 ED 8B 8F 12  ;.T..<...d.e....
00E0: D3 29 1F 69 B0 99 3E 69   19 C2 87 9C A9 79 DC 96  .).i..>i.....y..
00F0: 40 DC A3 5B 11 BD B5 D6   46 C0 6E E7 E6 1A 64 5E  @..[....F.n...d^
0100: 0F 6D 77 4E 08 FD 13 06   03 88 38 37 A2 8F 98 D8  .mwN......87....
0110: 8E F4 AA 60 52 DF 46 2C   D6 3B 43 B6 C7 05 C5 34  ...`R.F,.;C....4
0120: E9 0E 1C 75 1D 05 8D 7B   8A F8 4D F6 EF CB C8 B8  ...u......M.....
0130: 74 09 E3 EF 37 54 76 02   39 B9 23 A3 15 39 BE     t...7Tv.9.#..9.

Client Principal = myzkclient@LOCALHOST
Server Principal = krbtgt/LOCALHOST@LOCALHOST
Session Key = EncryptionKey: keyType=18 keyBytes (hex dump)=
0000: F1 57 FE EA 20 20 47 1D   D5 BC 2A BB F7 9D FC 40  .W..  G...*....@
0010: E4 69 74 AA BA D7 94 5F   67 DD 2C 71 26 19 CC 88  .it...._g.,q&...


Forwardable Ticket true
Forwarded Ticket false
Proxiable Ticket true
Proxy Ticket false
Postdated Ticket false
Renewable Ticket false
Initial Ticket false
Auth Time = Mon Apr 18 03:57:26 UTC 2016
Start Time = Mon Apr 18 03:57:26 UTC 2016
End Time = Mon Apr 18 13:57:26 UTC 2016
Renew Till = null
Client Addresses  Null .
2016-04-18 03:57:26,084 [myid:] - INFO  [Thread-1:Login@302] - TGT valid starting at:        Mon Apr 18 03:57:26 UTC 2016
2016-04-18 03:57:26,085 [myid:] - INFO  [Thread-1:Login@303] - TGT expires:                  Mon Apr 18 13:57:26 UTC 2016
2016-04-18 03:57:26,086 [myid:] - INFO  [Thread-1:Login$1@182] - TGT refresh sleeping until: Mon Apr 18 12:06:05 UTC 2016
2016-04-18 03:57:26,158 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@1032] - Opening socket connection to server localhost/0:0:0:0:0:0:0:1:2181. Will attempt to SASL-authenticate using Login Context section 'Client'
2016-04-18 03:57:26,171 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@876] - Socket connection established to localhost/0:0:0:0:0:0:0:1:2181, initiating session
2016-04-18 03:57:26,180 [myid:] - DEBUG [main-SendThread(localhost:2181):ClientCnxn$SendThread@949] - Session establishment request sent on localhost/0:0:0:0:0:0:0:1:2181
2016-04-18 03:57:26,228 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@1299] - Session establishment complete on server localhost/0:0:0:0:0:0:0:1:2181, sessionid = 0x15427827f930000, negotiated timeout = 30000

WATCHER::

WatchedEvent state:SyncConnected type:None path:null
2016-04-18 03:57:26,233 [myid:] - DEBUG [main-SendThread(localhost:2181):ZooKeeperSaslClient@417] - ClientCnxn:sendSaslPacket:length=0
2016-04-18 03:57:26,235 [myid:] - DEBUG [main-SendThread(localhost:2181):ZooKeeperSaslClient$2@365] - saslClient.evaluateChallenge(len=0)
2016-04-18 03:57:26,261 [myid:] - DEBUG [main-SendThread(localhost:2181):ZooKeeperSaslClient$2@365] - saslClient.evaluateChallenge(len=32)
2016-04-18 03:57:26,265 [myid:] - DEBUG [main-SendThread(localhost:2181):ZooKeeperSaslClient@399] - ClientCnxn:sendSaslPacket:length=52

WATCHER::

WatchedEvent state:SaslAuthenticated type:None path:null
```


```
[zk: localhost:2181(CONNECTED) 0] create /test2 content sasl:myzkclient@LOCALHOST:cdwra
Created /test
[zk: localhost:2181(CONNECTED) 1] getAcl /test2
'sasl,'myzkclient@LOCALHOT
: cdrwa
[zk: localhost:2181(CONNECTED) 2]
```

```
2016-04-18 03:59:54,972 [myid:] - DEBUG [SyncThread:0:FinalRequestProcessor@88] - Processing request:: sessionid:0x15427827f930000 type:create cxid:0x3 zxid:0x7 txntype:1 reqpath:n/a
2016-04-18 03:59:54,973 [myid:] - DEBUG [SyncThread:0:FinalRequestProcessor@160] - sessionid:0x15427827f930000 type:create cxid:0x3 zxid:0x7 txntype:1 reqpath:n/a
```


[zk: localhost:2181(CONNECTED) 0] create /test2 content sasl:myzkclient@LOCALHOST:cdwra
2016-04-18 03:59:54,953 [myid:] - DEBUG [main:ZooKeeperMain@644] - Processing create
2016-04-18 03:59:54,979 [myid:] - DEBUG [main-SendThread(localhost:2181):ClientCnxn$SendThread@843] - Reading reply sessionid:0x15427827f930000, packet:: clientPath:null serverPath:null finished:false header:: 3,1  replyHeader:: 3,7,0  request:: '/test2,#636f6e74656e74,v{s{31,s{'sasl,'myzkclient@LOCALHOST}}},0  response:: '/test2
Created /test2
[zk: localhost:2181(CONNECTED) 1]