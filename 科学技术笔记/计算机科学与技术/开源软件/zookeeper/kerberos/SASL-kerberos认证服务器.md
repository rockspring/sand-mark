## zookeeper配置文件

conf/zoo.cfg

```
tickTime=2000
initLimit=10
syncLimit=5
dataDir=/vagrant/projects/server/zookeeper/zookeeper-3.4.8/data
clientPort=2181
authProvider.1=org.apache.zookeeper.server.auth.SASLAuthenticationProvider
jaasLoginRenew=3600000
```

## jass 配置文件

conf/jaas.conf

```
Server {
       com.sun.security.auth.module.Krb5LoginModule required
       useKeyTab=true
       keyTab="/vagrant/projects/server/zookeeper/zookeeper.keytab"
       storeKey=true
       useTicketCache=false
       principal="zookeeper/localhost";
};
Client {
       com.sun.security.auth.module.Krb5LoginModule required
       useKeyTab=true
       keyTab="/vagrant/projects/server/zookeeper/myzkclient.keytab"
       storeKey=true
       principal="myzkclient"
       useTicketCache=false
       debug=true;
};
```

## java.env配置文件

conf/java.env

```
export JVMFLAGS="-Djava.security.auth.login.config=/vagrant/projects/server/zookeeper/zookeeper-3.4.8/conf/jaas.conf"
```

## 服务端启动

```
vagrant@ubuntu-14:/vagrant/projects/server/zookeeper/zookeeper-3.4.8$ bin/zkServer.sh start-foreground
ZooKeeper JMX enabled by default
Using config: /vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf/zoo.cfg
2016-04-18 03:23:38,860 [myid:] - INFO  [main:QuorumPeerConfig@103] - Reading configuration from: /vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf/zoo.cfg
2016-04-18 03:23:38,874 [myid:] - INFO  [main:DatadirCleanupManager@78] - autopurge.snapRetainCount set to 3
2016-04-18 03:23:38,874 [myid:] - INFO  [main:DatadirCleanupManager@79] - autopurge.purgeInterval set to 0
2016-04-18 03:23:38,875 [myid:] - INFO  [main:DatadirCleanupManager@101] - Purge task is not scheduled.
2016-04-18 03:23:38,876 [myid:] - WARN  [main:QuorumPeerMain@113] - Either no config or no quorum defined in config, running  in standalone mode
2016-04-18 03:23:38,901 [myid:] - INFO  [main:QuorumPeerConfig@103] - Reading configuration from: /vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf/zoo.cfg
2016-04-18 03:23:38,904 [myid:] - INFO  [main:ZooKeeperServerMain@95] - Starting server
2016-04-18 03:23:38,934 [myid:] - INFO  [main:Environment@100] - Server environment:zookeeper.version=3.4.8--1, built on 02/06/2016 03:18 GMT
2016-04-18 03:23:38,934 [myid:] - INFO  [main:Environment@100] - Server environment:host.name=ubuntu-14.04-amd64-vbox
2016-04-18 03:23:38,935 [myid:] - INFO  [main:Environment@100] - Server environment:java.version=1.7.0_95
2016-04-18 03:23:38,935 [myid:] - INFO  [main:Environment@100] - Server environment:java.vendor=Oracle Corporation
2016-04-18 03:23:38,935 [myid:] - INFO  [main:Environment@100] - Server environment:java.home=/usr/lib/jvm/java-7-openjdk-amd64/jre
2016-04-18 03:23:38,936 [myid:] - INFO  [main:Environment@100] - Server environment:java.class.path=/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../build/classes:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../build/lib/*.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/slf4j-log4j12-1.6.1.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/slf4j-api-1.6.1.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/netty-3.7.0.Final.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/log4j-1.2.16.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/jline-0.9.94.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../zookeeper-3.4.8.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../src/java/lib/*.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf:
2016-04-18 03:23:38,936 [myid:] - INFO  [main:Environment@100] - Server environment:java.library.path=/usr/java/packages/lib/amd64:/usr/lib/x86_64-linux-gnu/jni:/lib/x86_64-linux-gnu:/usr/lib/x86_64-linux-gnu:/usr/lib/jni:/lib:/usr/lib
2016-04-18 03:23:38,936 [myid:] - INFO  [main:Environment@100] - Server environment:java.io.tmpdir=/tmp
2016-04-18 03:23:38,937 [myid:] - INFO  [main:Environment@100] - Server environment:java.compiler=<NA>
2016-04-18 03:23:38,939 [myid:] - INFO  [main:Environment@100] - Server environment:os.name=Linux
2016-04-18 03:23:38,940 [myid:] - INFO  [main:Environment@100] - Server environment:os.arch=amd64
2016-04-18 03:23:38,940 [myid:] - INFO  [main:Environment@100] - Server environment:os.version=3.13.0-24-generic
2016-04-18 03:23:38,940 [myid:] - INFO  [main:Environment@100] - Server environment:user.name=vagrant
2016-04-18 03:23:38,941 [myid:] - INFO  [main:Environment@100] - Server environment:user.home=/home/vagrant
2016-04-18 03:23:38,941 [myid:] - INFO  [main:Environment@100] - Server environment:user.dir=/vagrant/projects/server/zookeeper/zookeeper-3.4.8
2016-04-18 03:23:38,971 [myid:] - INFO  [main:ZooKeeperServer@787] - tickTime set to 2000
2016-04-18 03:23:38,972 [myid:] - INFO  [main:ZooKeeperServer@796] - minSessionTimeout set to -1
2016-04-18 03:23:38,972 [myid:] - INFO  [main:ZooKeeperServer@805] - maxSessionTimeout set to -1
2016-04-18 03:23:39,156 [myid:] - INFO  [main:Login@294] - successfully logged in.
2016-04-18 03:23:39,160 [myid:] - INFO  [Thread-1:Login$1@127] - TGT refresh thread started.
2016-04-18 03:23:39,163 [myid:] - INFO  [main:NIOServerCnxnFactory@89] - binding to port 0.0.0.0/0.0.0.0:2181
2016-04-18 03:23:39,170 [myid:] - INFO  [Thread-1:Login@302] - TGT valid starting at:        Mon Apr 18 03:23:39 UTC 2016
2016-04-18 03:23:39,170 [myid:] - INFO  [Thread-1:Login@303] - TGT expires:                  Mon Apr 18 13:23:39 UTC 2016
2016-04-18 03:23:39,171 [myid:] - INFO  [Thread-1:Login$1@182] - TGT refresh sleeping until: Mon Apr 18 11:25:07 UTC 2016
```


## 客户端启动

```
vagrant@ubuntu-14:/vagrant/projects/server/zookeeper/zookeeper-3.4.8$ bin/zkCli.sh -server localhost:2181
Connecting to localhost:2181
2016-04-18 03:24:05,086 [myid:] - INFO  [main:Environment@100] - Client environment:zookeeper.version=3.4.8--1, built on 02/06/2016 03:18 GMT
2016-04-18 03:24:05,094 [myid:] - INFO  [main:Environment@100] - Client environment:host.name=ubuntu-14.04-amd64-vbox
2016-04-18 03:24:05,094 [myid:] - INFO  [main:Environment@100] - Client environment:java.version=1.7.0_95
2016-04-18 03:24:05,099 [myid:] - INFO  [main:Environment@100] - Client environment:java.vendor=Oracle Corporation
2016-04-18 03:24:05,099 [myid:] - INFO  [main:Environment@100] - Client environment:java.home=/usr/lib/jvm/java-7-openjdk-amd64/jre
2016-04-18 03:24:05,099 [myid:] - INFO  [main:Environment@100] - Client environment:java.class.path=/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../build/classes:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../build/lib/*.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/slf4j-log4j12-1.6.1.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/slf4j-api-1.6.1.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/netty-3.7.0.Final.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/log4j-1.2.16.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/jline-0.9.94.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../zookeeper-3.4.8.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../src/java/lib/*.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf:
2016-04-18 03:24:05,100 [myid:] - INFO  [main:Environment@100] - Client environment:java.library.path=/usr/java/packages/lib/amd64:/usr/lib/x86_64-linux-gnu/jni:/lib/x86_64-linux-gnu:/usr/lib/x86_64-linux-gnu:/usr/lib/jni:/lib:/usr/lib
2016-04-18 03:24:05,100 [myid:] - INFO  [main:Environment@100] - Client environment:java.io.tmpdir=/tmp
2016-04-18 03:24:05,100 [myid:] - INFO  [main:Environment@100] - Client environment:java.compiler=<NA>
2016-04-18 03:24:05,101 [myid:] - INFO  [main:Environment@100] - Client environment:os.name=Linux
2016-04-18 03:24:05,101 [myid:] - INFO  [main:Environment@100] - Client environment:os.arch=amd64
2016-04-18 03:24:05,101 [myid:] - INFO  [main:Environment@100] - Client environment:os.version=3.13.0-24-generic
2016-04-18 03:24:05,101 [myid:] - INFO  [main:Environment@100] - Client environment:user.name=vagrant
2016-04-18 03:24:05,102 [myid:] - INFO  [main:Environment@100] - Client environment:user.home=/home/vagrant
2016-04-18 03:24:05,102 [myid:] - INFO  [main:Environment@100] - Client environment:user.dir=/vagrant/projects/server/zookeeper/zookeeper-3.4.8
2016-04-18 03:24:05,106 [myid:] - INFO  [main:ZooKeeper@438] - Initiating client connection, connectString=localhost:2181 sessionTimeout=30000 watcher=org.apache.zookeeper.ZooKeeperMain$MyWatcher@43d6e29a
Welcome to ZooKeeper!
JLine support is enabled
Debug is  true storeKey true useTicketCache false useKeyTab true doNotPrompt false ticketCache is null isInitiator true KeyTab is /vagrant/projects/server/zookeeper/myzkclient.keytab refreshKrb5Config is false principal is myzkclient tryFirstPass is false useFirstPass is false storePass is false clearPass is false
[zk: localhost:2181(CONNECTING) 0] principal is myzkclient@LOCALHOST
Will use keytab
Commit Succeeded

2016-04-18 03:24:05,378 [myid:] - INFO  [main-SendThread(localhost:2181):Login@294] - successfully logged in.
2016-04-18 03:24:05,382 [myid:] - INFO  [Thread-1:Login$1@127] - TGT refresh thread started.
2016-04-18 03:24:05,395 [myid:] - INFO  [main-SendThread(localhost:2181):ZooKeeperSaslClient$1@285] - Client will use GSSAPI as SASL mechanism.
2016-04-18 03:24:05,398 [myid:] - INFO  [Thread-1:Login@302] - TGT valid starting at:        Mon Apr 18 03:24:05 UTC 2016
2016-04-18 03:24:05,399 [myid:] - INFO  [Thread-1:Login@303] - TGT expires:                  Mon Apr 18 13:24:05 UTC 2016
2016-04-18 03:24:05,400 [myid:] - INFO  [Thread-1:Login$1@182] - TGT refresh sleeping until: Mon Apr 18 11:26:41 UTC 2016
2016-04-18 03:24:05,492 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@1032] - Opening socket connection to server localhost/127.0.0.1:2181. Will attempt to SASL-authenticate using Login Context section 'Client'
2016-04-18 03:24:05,505 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@876] - Socket connection established to localhost/127.0.0.1:2181, initiating session
2016-04-18 03:24:05,676 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@1299] - Session establishment complete on server localhost/127.0.0.1:2181, sessionid = 0x15427651f400000, negotiated timeout = 30000

WATCHER::

WatchedEvent state:SyncConnected type:None path:null

WATCHER::

WatchedEvent state:SaslAuthenticated type:None path:null

[zk: localhost:2181(CONNECTED) 0]
```

## 服务端接收客户端连接

```
2016-04-18 03:24:05,507 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:NIOServerCnxnFactory@192] - Accepted socket connection from /127.0.0.1:60902
2016-04-18 03:24:05,628 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperServer@900] - Client attempting to establish new session at /127.0.0.1:60902
2016-04-18 03:24:05,632 [myid:] - INFO  [SyncThread:0:FileTxnLog@199] - Creating new log file: log.1
2016-04-18 03:24:05,674 [myid:] - INFO  [SyncThread:0:ZooKeeperServer@645] - Established session 0x15427651f400000 with negotiated timeout 30000 for client /127.0.0.1:60902
2016-04-18 03:24:05,727 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:SaslServerCallbackHandler@118] - Successfully authenticated client: authenticationID=myzkclient@LOCALHOST;  authorizationID=myzkclient@LOCALHOST.
2016-04-18 03:24:05,732 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:SaslServerCallbackHandler@134] - Setting authorizedID: myzkclient@LOCALHOST
2016-04-18 03:24:05,733 [myid:] - INFO  [NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181:ZooKeeperServer@996] - adding SASL authorization for authorizationID: myzkclient@LOCALHOST
```

## 验证

```
[zk: localhost:2181(CONNECTED) 0] create /test content sasl:myzkclient@LOCALHOST:cdwra
Created /test
[zk: localhost:2181(CONNECTED) 1] getAcl /test
'sasl,'myzkclient@LOCALHOT
: cdrwa
[zk: localhost:2181(CONNECTED) 2]
```