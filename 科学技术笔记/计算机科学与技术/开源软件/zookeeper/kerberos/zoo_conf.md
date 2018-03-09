/vagrant/projects/server/zookeeper/zookeeper-3.4.8/conf


kerberos conf

```
[logging]
 default = FILE:/var/log/krb5libs.log
 kdc = FILE:/var/log/krb5kdc.log
 admin_server = FILE:/var/log/kadmind.log

[libdefaults]
 default_realm = LOCALHOST
 dns_lookup_realm = false
 dns_lookup_kdc = false
 ticket_lifetime = 24h
 renew_lifetime = 7d
 forwardable = true

[realms]
 LOCALHOST = {
  kdc = localhost
  admin_server = localhost
 }

[domain_realm]
 .localhost = LOCALHOST
 localhost = LOCALHOST
```

zookeeper conf/zoo.cfg

```
tickTime=2000
initLimit=10
syncLimit=5
dataDir=/vagrant/projects/server/zookeeper/zookeeper-3.4.8/data
clientPort=2181
authProvider.1=org.apache.zookeeper.server.auth.SASLAuthenticationProvider
jaasLoginRenew=3600000
```


jass config conf/jaas.conf

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

conf/java.env

```
export JVMFLAGS="-Djava.security.auth.login.config=/vagrant/projects/server/zookeeper/zookeeper-3.4.8/conf/jaas.conf"
```


bin/zkServer.sh start-foreground

the output is below

```
ZooKeeper JMX enabled by default
Using config: /vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf/zoo.cfg
2016-04-16 18:22:03,723 [myid:] - INFO  [main:QuorumPeerConfig@103] - Reading configuration from: /vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf/zoo.cfg
2016-04-16 18:22:03,733 [myid:] - INFO  [main:DatadirCleanupManager@78] - autopurge.snapRetainCount set to 3
2016-04-16 18:22:03,733 [myid:] - INFO  [main:DatadirCleanupManager@79] - autopurge.purgeInterval set to 0
2016-04-16 18:22:03,733 [myid:] - INFO  [main:DatadirCleanupManager@101] - Purge task is not scheduled.
2016-04-16 18:22:03,734 [myid:] - WARN  [main:QuorumPeerMain@113] - Either no config or no quorum defined in config, running  in standalone mode
2016-04-16 18:22:03,762 [myid:] - INFO  [main:QuorumPeerConfig@103] - Reading configuration from: /vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf/zoo.cfg
2016-04-16 18:22:03,767 [myid:] - INFO  [main:ZooKeeperServerMain@95] - Starting server
2016-04-16 18:22:03,783 [myid:] - INFO  [main:Environment@100] - Server environment:zookeeper.version=3.4.8--1, built on 02/06/2016 03:18 GMT
2016-04-16 18:22:03,784 [myid:] - INFO  [main:Environment@100] - Server environment:host.name=swimmingsand-usa
2016-04-16 18:22:03,784 [myid:] - INFO  [main:Environment@100] - Server environment:java.version=1.7.0_95
2016-04-16 18:22:03,784 [myid:] - INFO  [main:Environment@100] - Server environment:java.vendor=Oracle Corporation
2016-04-16 18:22:03,784 [myid:] - INFO  [main:Environment@100] - Server environment:java.home=/usr/lib/jvm/java-7-openjdk-amd64/jre
2016-04-16 18:22:03,784 [myid:] - INFO  [main:Environment@100] - Server environment:java.class.path=/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../build/classes:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../build/lib/*.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/slf4j-log4j12-1.6.1.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/slf4j-api-1.6.1.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/netty-3.7.0.Final.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/log4j-1.2.16.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/jline-0.9.94.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../zookeeper-3.4.8.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../src/java/lib/*.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf:
2016-04-16 18:22:03,785 [myid:] - INFO  [main:Environment@100] - Server environment:java.library.path=/usr/java/packages/lib/amd64:/usr/lib/x86_64-linux-gnu/jni:/lib/x86_64-linux-gnu:/usr/lib/x86_64-linux-gnu:/usr/lib/jni:/lib:/usr/lib
2016-04-16 18:22:03,785 [myid:] - INFO  [main:Environment@100] - Server environment:java.io.tmpdir=/tmp
2016-04-16 18:22:03,785 [myid:] - INFO  [main:Environment@100] - Server environment:java.compiler=<NA>
2016-04-16 18:22:03,788 [myid:] - INFO  [main:Environment@100] - Server environment:os.name=Linux
2016-04-16 18:22:03,788 [myid:] - INFO  [main:Environment@100] - Server environment:os.arch=amd64
2016-04-16 18:22:03,788 [myid:] - INFO  [main:Environment@100] - Server environment:os.version=3.13.0-57-generic
2016-04-16 18:22:03,788 [myid:] - INFO  [main:Environment@100] - Server environment:user.name=root
2016-04-16 18:22:03,788 [myid:] - INFO  [main:Environment@100] - Server environment:user.home=/root
2016-04-16 18:22:03,788 [myid:] - INFO  [main:Environment@100] - Server environment:user.dir=/vagrant/projects/server/zookeeper/zookeeper-3.4.8
2016-04-16 18:22:03,800 [myid:] - INFO  [main:ZooKeeperServer@787] - tickTime set to 2000
2016-04-16 18:22:03,800 [myid:] - INFO  [main:ZooKeeperServer@796] - minSessionTimeout set to -1
2016-04-16 18:22:03,800 [myid:] - INFO  [main:ZooKeeperServer@805] - maxSessionTimeout set to -1
2016-04-16 18:22:04,078 [myid:] - INFO  [main:Login@294] - successfully logged in.
2016-04-16 18:22:04,094 [myid:] - INFO  [Thread-1:Login$1@127] - TGT refresh thread started.
2016-04-16 18:22:04,117 [myid:] - INFO  [main:NIOServerCnxnFactory@89] - binding to port 0.0.0.0/0.0.0.0:2181
2016-04-16 18:22:04,163 [myid:] - INFO  [Thread-1:Login@302] - TGT valid starting at:        Sat Apr 16 18:22:04 EDT 2016
2016-04-16 18:22:04,164 [myid:] - INFO  [Thread-1:Login@303] - TGT expires:                  Sun Apr 17 04:22:04 EDT 2016
2016-04-16 18:22:04,167 [myid:] - INFO  [Thread-1:Login$1@182] - TGT refresh sleeping until: Sun Apr 17 02:47:34 EDT 2016
```

when i run zookeeper client,i got zookeeper AuthFailed, can you help me to analyze its reason, thank you very much!

bin/zkCli.sh -server 127.0.0.1:2181

```
Connecting to 127.0.0.1:2181
2016-04-16 19:33:17,275 [myid:] - INFO  [main:Environment@100] - Client environment:zookeeper.version=3.4.8--1, built on 02/06/2016 03:18 GMT
2016-04-16 19:33:17,279 [myid:] - INFO  [main:Environment@100] - Client environment:host.name=swimmingsand-usa
2016-04-16 19:33:17,280 [myid:] - INFO  [main:Environment@100] - Client environment:java.version=1.7.0_95
2016-04-16 19:33:17,283 [myid:] - INFO  [main:Environment@100] - Client environment:java.vendor=Oracle Corporation
2016-04-16 19:33:17,284 [myid:] - INFO  [main:Environment@100] - Client environment:java.home=/usr/lib/jvm/java-7-openjdk-amd64/jre
2016-04-16 19:33:17,284 [myid:] - INFO  [main:Environment@100] - Client environment:java.class.path=/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../build/classes:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../build/lib/*.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/slf4j-log4j12-1.6.1.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/slf4j-api-1.6.1.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/netty-3.7.0.Final.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/log4j-1.2.16.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../lib/jline-0.9.94.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../zookeeper-3.4.8.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../src/java/lib/*.jar:/vagrant/projects/server/zookeeper/zookeeper-3.4.8/bin/../conf:
2016-04-16 19:33:17,284 [myid:] - INFO  [main:Environment@100] - Client environment:java.library.path=/usr/java/packages/lib/amd64:/usr/lib/x86_64-linux-gnu/jni:/lib/x86_64-linux-gnu:/usr/lib/x86_64-linux-gnu:/usr/lib/jni:/lib:/usr/lib
2016-04-16 19:33:17,284 [myid:] - INFO  [main:Environment@100] - Client environment:java.io.tmpdir=/tmp
2016-04-16 19:33:17,284 [myid:] - INFO  [main:Environment@100] - Client environment:java.compiler=<NA>
2016-04-16 19:33:17,285 [myid:] - INFO  [main:Environment@100] - Client environment:os.name=Linux
2016-04-16 19:33:17,285 [myid:] - INFO  [main:Environment@100] - Client environment:os.arch=amd64
2016-04-16 19:33:17,285 [myid:] - INFO  [main:Environment@100] - Client environment:os.version=3.13.0-57-generic
2016-04-16 19:33:17,285 [myid:] - INFO  [main:Environment@100] - Client environment:user.name=root
2016-04-16 19:33:17,285 [myid:] - INFO  [main:Environment@100] - Client environment:user.home=/root
2016-04-16 19:33:17,286 [myid:] - INFO  [main:Environment@100] - Client environment:user.dir=/vagrant/projects/server/zookeeper/zookeeper-3.4.8
2016-04-16 19:33:17,287 [myid:] - INFO  [main:ZooKeeper@438] - Initiating client connection, connectString=127.0.0.1:2181 sessionTimeout=30000 watcher=org.apache.zookeeper.ZooKeeperMain$MyWatcher@7a7025de
Welcome to ZooKeeper!
Debug is  true storeKey true useTicketCache false useKeyTab true doNotPrompt false ticketCache is null isInitiator true KeyTab is /root/zookeeper/conf/myzkclient.keytab refreshKrb5Config is false principal is myzkclient tryFirstPass is false useFirstPass is false storePass is false clearPass is false
JLine support is enabled
[zk: 127.0.0.1:2181(CONNECTING) 0] principal is myzkclient@LOCALHOST
Will use keytab
Commit Succeeded

2016-04-16 19:33:17,583 [myid:] - INFO  [main-SendThread(127.0.0.1:2181):Login@294] - successfully logged in.
2016-04-16 19:33:17,595 [myid:] - INFO  [Thread-1:Login$1@127] - TGT refresh thread started.
2016-04-16 19:33:17,627 [myid:] - INFO  [main-SendThread(127.0.0.1:2181):ZooKeeperSaslClient$1@285] - Client will use GSSAPI as SASL mechanism.
2016-04-16 19:33:17,655 [myid:] - INFO  [Thread-1:Login@302] - TGT valid starting at:        Sat Apr 16 19:33:17 EDT 2016
2016-04-16 19:33:17,659 [myid:] - INFO  [Thread-1:Login@303] - TGT expires:                  Sun Apr 17 05:33:17 EDT 2016
2016-04-16 19:33:17,660 [myid:] - INFO  [Thread-1:Login$1@182] - TGT refresh sleeping until: Sun Apr 17 03:41:04 EDT 2016
2016-04-16 19:33:17,767 [myid:] - INFO  [main-SendThread(127.0.0.1:2181):ClientCnxn$SendThread@1032] - Opening socket connection to server 127.0.0.1/127.0.0.1:2181. Will attempt to SASL-authenticate using Login Context section 'Client'
2016-04-16 19:33:17,787 [myid:] - INFO  [main-SendThread(127.0.0.1:2181):ClientCnxn$SendThread@876] - Socket connection established to 127.0.0.1/127.0.0.1:2181, initiating session
2016-04-16 19:33:17,842 [myid:] - INFO  [main-SendThread(127.0.0.1:2181):ClientCnxn$SendThread@1299] - Session establishment complete on server 127.0.0.1/127.0.0.1:2181, sessionid = 0x15421589ca20001, negotiated timeout = 30000

WATCHER::

WatchedEvent state:SyncConnected type:None path:null
2016-04-16 19:33:17,862 [myid:] - ERROR [main-SendThread(127.0.0.1:2181):ZooKeeperSaslClient@384] - An error: (java.security.PrivilegedActionException: javax.security.sasl.SaslException: GSS initiate failed [Caused by GSSException: No valid credentials provided (Mechanism level: Server not found in Kerberos database (7) - LOOKING_UP_SERVER)]) occurred when evaluating Zookeeper Quorum Member's  received SASL token. Zookeeper Client will go to AUTH_FAILED state.
2016-04-16 19:33:17,863 [myid:] - ERROR [main-SendThread(127.0.0.1:2181):ClientCnxn$SendThread@1072] - SASL authentication with Zookeeper Quorum member failed: javax.security.sasl.SaslException: An error: (java.security.PrivilegedActionException: javax.security.sasl.SaslException: GSS initiate failed [Caused by GSSException: No valid credentials provided (Mechanism level: Server not found in Kerberos database (7) - LOOKING_UP_SERVER)]) occurred when evaluating Zookeeper Quorum Member's  received SASL token. Zookeeper Client will go to AUTH_FAILED state.

WATCHER::

WatchedEvent state:AuthFailed type:None path:null
```


thank you very much




