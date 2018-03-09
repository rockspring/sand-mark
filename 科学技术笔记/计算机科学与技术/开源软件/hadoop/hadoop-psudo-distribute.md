etc/hadoop/core-site.xml:

```
<configuration>
    <property>
        <name>fs.defaultFS</name>
        <value>hdfs://localhost:9000</value>
    </property>
</configuration>
```

etc/hadoop/hdfs-site.xml:

```
<configuration>
    <property>
        <name>dfs.replication</name>
        <value>1</value>
    </property>
</configuration>
```

Apples-MacBook-Pro-2:hadoop-2.5.1 zlq$ bin/hdfs namenode -format
14/09/25 13:58:54 INFO namenode.NameNode: STARTUP_MSG:
/************************************************************
STARTUP_MSG: Starting NameNode
STARTUP_MSG:   host = Apples-MacBook-Pro-2.local/192.168.196.65
STARTUP_MSG:   args = [-format]
STARTUP_MSG:   version = 2.5.1
STARTUP_MSG:   classpath = /Users/zlq/servers/hadoop/hadoop-2.5.1/etc/hadoop:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/activation-1.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/apacheds-i18n-2.0.0-M15.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/apacheds-kerberos-codec-2.0.0-M15.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/api-asn1-api-1.0.0-M20.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/api-util-1.0.0-M20.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/asm-3.2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/avro-1.7.4.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-beanutils-1.7.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-beanutils-core-1.8.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-cli-1.2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-codec-1.4.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-collections-3.2.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-compress-1.4.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-configuration-1.6.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-digester-1.8.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-el-1.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-httpclient-3.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-io-2.4.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-lang-2.6.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-logging-1.1.3.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-math3-3.1.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/commons-net-3.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/guava-11.0.2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/hadoop-annotations-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/hadoop-auth-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/hamcrest-core-1.3.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/httpclient-4.2.5.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/httpcore-4.2.5.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jackson-core-asl-1.9.13.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jackson-jaxrs-1.9.13.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jackson-mapper-asl-1.9.13.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jackson-xc-1.9.13.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jasper-compiler-5.5.23.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jasper-runtime-5.5.23.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/java-xmlbuilder-0.4.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jaxb-api-2.2.2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jaxb-impl-2.2.3-1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jersey-core-1.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jersey-json-1.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jersey-server-1.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jets3t-0.9.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jettison-1.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jetty-6.1.26.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jetty-util-6.1.26.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jsch-0.1.42.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jsp-api-2.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/jsr305-1.3.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/junit-4.11.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/log4j-1.2.17.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/mockito-all-1.8.5.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/netty-3.6.2.Final.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/paranamer-2.3.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/protobuf-java-2.5.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/servlet-api-2.5.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/slf4j-api-1.7.5.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/slf4j-log4j12-1.7.5.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/snappy-java-1.0.4.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/stax-api-1.0-2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/xmlenc-0.52.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/xz-1.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/lib/zookeeper-3.4.6.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/hadoop-common-2.5.1-tests.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/hadoop-common-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/common/hadoop-nfs-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/asm-3.2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/commons-cli-1.2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/commons-codec-1.4.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/commons-daemon-1.0.13.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/commons-el-1.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/commons-io-2.4.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/commons-lang-2.6.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/commons-logging-1.1.3.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/guava-11.0.2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/jackson-core-asl-1.9.13.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/jackson-mapper-asl-1.9.13.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/jasper-runtime-5.5.23.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/jersey-core-1.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/jersey-server-1.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/jetty-6.1.26.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/jetty-util-6.1.26.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/jsp-api-2.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/jsr305-1.3.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/log4j-1.2.17.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/netty-3.6.2.Final.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/protobuf-java-2.5.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/servlet-api-2.5.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/lib/xmlenc-0.52.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/hadoop-hdfs-2.5.1-tests.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/hadoop-hdfs-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/hdfs/hadoop-hdfs-nfs-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/activation-1.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/aopalliance-1.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/asm-3.2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/commons-cli-1.2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/commons-codec-1.4.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/commons-collections-3.2.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/commons-compress-1.4.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/commons-httpclient-3.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/commons-io-2.4.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/commons-lang-2.6.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/commons-logging-1.1.3.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/guava-11.0.2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/guice-3.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/guice-servlet-3.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jackson-core-asl-1.9.13.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jackson-jaxrs-1.9.13.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jackson-mapper-asl-1.9.13.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jackson-xc-1.9.13.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/javax.inject-1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jaxb-api-2.2.2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jaxb-impl-2.2.3-1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jersey-client-1.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jersey-core-1.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jersey-guice-1.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jersey-json-1.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jersey-server-1.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jettison-1.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jetty-6.1.26.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jetty-util-6.1.26.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jline-0.9.94.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/jsr305-1.3.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/leveldbjni-all-1.8.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/log4j-1.2.17.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/netty-3.6.2.Final.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/protobuf-java-2.5.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/servlet-api-2.5.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/stax-api-1.0-2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/xz-1.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/lib/zookeeper-3.4.6.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/hadoop-yarn-api-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/hadoop-yarn-applications-distributedshell-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/hadoop-yarn-applications-unmanaged-am-launcher-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/hadoop-yarn-client-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/hadoop-yarn-common-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/hadoop-yarn-server-applicationhistoryservice-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/hadoop-yarn-server-common-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/hadoop-yarn-server-nodemanager-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/hadoop-yarn-server-resourcemanager-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/hadoop-yarn-server-tests-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/yarn/hadoop-yarn-server-web-proxy-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/aopalliance-1.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/asm-3.2.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/avro-1.7.4.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/commons-compress-1.4.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/commons-io-2.4.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/guice-3.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/guice-servlet-3.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/hadoop-annotations-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/hamcrest-core-1.3.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/jackson-core-asl-1.9.13.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/jackson-mapper-asl-1.9.13.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/javax.inject-1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/jersey-core-1.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/jersey-guice-1.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/jersey-server-1.9.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/junit-4.11.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/leveldbjni-all-1.8.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/log4j-1.2.17.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/netty-3.6.2.Final.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/paranamer-2.3.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/protobuf-java-2.5.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/snappy-java-1.0.4.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/lib/xz-1.0.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/hadoop-mapreduce-client-app-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/hadoop-mapreduce-client-common-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/hadoop-mapreduce-client-hs-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/hadoop-mapreduce-client-hs-plugins-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.5.1-tests.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/hadoop-mapreduce-client-shuffle-2.5.1.jar:/Users/zlq/servers/hadoop/hadoop-2.5.1/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.5.1.jar:/contrib/capacity-scheduler/*.jar
STARTUP_MSG:   build = https://git-wip-us.apache.org/repos/asf/hadoop.git -r 2e18d179e4a8065b6a9f29cf2de9451891265cce; compiled by 'jenkins' on 2014-09-05T23:11Z
STARTUP_MSG:   java = 1.7.0_67
************************************************************/
14/09/25 13:58:54 INFO namenode.NameNode: registered UNIX signal handlers for [TERM, HUP, INT]
14/09/25 13:58:54 INFO namenode.NameNode: createNameNode [-format]
14/09/25 13:58:55 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Formatting using clusterid: CID-6e0449e1-ea5a-40b9-9238-008d3004b0ee
14/09/25 13:58:55 INFO namenode.FSNamesystem: fsLock is fair:true
14/09/25 13:58:55 INFO blockmanagement.DatanodeManager: dfs.block.invalidate.limit=1000
14/09/25 13:58:55 INFO blockmanagement.DatanodeManager: dfs.namenode.datanode.registration.ip-hostname-check=true
14/09/25 13:58:55 INFO blockmanagement.BlockManager: dfs.namenode.startup.delay.block.deletion.sec is set to 000:00:00:00.000
14/09/25 13:58:55 INFO blockmanagement.BlockManager: The block deletion will start around 2014 Sep 25 13:58:55
14/09/25 13:58:55 INFO util.GSet: Computing capacity for map BlocksMap
14/09/25 13:58:55 INFO util.GSet: VM type       = 64-bit
14/09/25 13:58:55 INFO util.GSet: 2.0% max memory 889 MB = 17.8 MB
14/09/25 13:58:55 INFO util.GSet: capacity      = 2^21 = 2097152 entries
14/09/25 13:58:55 INFO blockmanagement.BlockManager: dfs.block.access.token.enable=false
14/09/25 13:58:55 INFO blockmanagement.BlockManager: defaultReplication         = 3
14/09/25 13:58:55 INFO blockmanagement.BlockManager: maxReplication             = 512
14/09/25 13:58:55 INFO blockmanagement.BlockManager: minReplication             = 1
14/09/25 13:58:55 INFO blockmanagement.BlockManager: maxReplicationStreams      = 2
14/09/25 13:58:55 INFO blockmanagement.BlockManager: shouldCheckForEnoughRacks  = false
14/09/25 13:58:55 INFO blockmanagement.BlockManager: replicationRecheckInterval = 3000
14/09/25 13:58:55 INFO blockmanagement.BlockManager: encryptDataTransfer        = false
14/09/25 13:58:55 INFO blockmanagement.BlockManager: maxNumBlocksToLog          = 1000
14/09/25 13:58:55 INFO namenode.FSNamesystem: fsOwner             = zlq (auth:SIMPLE)
14/09/25 13:58:55 INFO namenode.FSNamesystem: supergroup          = supergroup
14/09/25 13:58:55 INFO namenode.FSNamesystem: isPermissionEnabled = true
14/09/25 13:58:55 INFO namenode.FSNamesystem: HA Enabled: false
14/09/25 13:58:55 INFO namenode.FSNamesystem: Append Enabled: true
14/09/25 13:58:55 INFO util.GSet: Computing capacity for map INodeMap
14/09/25 13:58:55 INFO util.GSet: VM type       = 64-bit
14/09/25 13:58:55 INFO util.GSet: 1.0% max memory 889 MB = 8.9 MB
14/09/25 13:58:55 INFO util.GSet: capacity      = 2^20 = 1048576 entries
14/09/25 13:58:55 INFO namenode.NameNode: Caching file names occuring more than 10 times
14/09/25 13:58:55 INFO util.GSet: Computing capacity for map cachedBlocks
14/09/25 13:58:55 INFO util.GSet: VM type       = 64-bit
14/09/25 13:58:55 INFO util.GSet: 0.25% max memory 889 MB = 2.2 MB
14/09/25 13:58:55 INFO util.GSet: capacity      = 2^18 = 262144 entries
14/09/25 13:58:55 INFO namenode.FSNamesystem: dfs.namenode.safemode.threshold-pct = 0.9990000128746033
14/09/25 13:58:55 INFO namenode.FSNamesystem: dfs.namenode.safemode.min.datanodes = 0
14/09/25 13:58:55 INFO namenode.FSNamesystem: dfs.namenode.safemode.extension     = 30000
14/09/25 13:58:55 INFO namenode.FSNamesystem: Retry cache on namenode is enabled
14/09/25 13:58:55 INFO namenode.FSNamesystem: Retry cache will use 0.03 of total heap and retry cache entry expiry time is 600000 millis
14/09/25 13:58:55 INFO util.GSet: Computing capacity for map NameNodeRetryCache
14/09/25 13:58:55 INFO util.GSet: VM type       = 64-bit
14/09/25 13:58:55 INFO util.GSet: 0.029999999329447746% max memory 889 MB = 273.1 KB
14/09/25 13:58:55 INFO util.GSet: capacity      = 2^15 = 32768 entries
14/09/25 13:58:55 INFO namenode.NNConf: ACLs enabled? false
14/09/25 13:58:55 INFO namenode.NNConf: XAttrs enabled? true
14/09/25 13:58:55 INFO namenode.NNConf: Maximum size of an xattr: 16384
14/09/25 13:58:56 INFO namenode.FSImage: Allocated new BlockPoolId: BP-682935282-192.168.196.65-1411624736006
14/09/25 13:58:56 INFO common.Storage: Storage directory /tmp/hadoop-zlq/dfs/name has been successfully formatted.
14/09/25 13:58:56 INFO namenode.NNStorageRetentionManager: Going to retain 1 images with txid >= 0
14/09/25 13:58:56 INFO util.ExitUtil: Exiting with status 0
14/09/25 13:58:56 INFO namenode.NameNode: SHUTDOWN_MSG:
/************************************************************
SHUTDOWN_MSG: Shutting down NameNode at Apples-MacBook-Pro-2.local/192.168.196.65
************************************************************/

Apples-MacBook-Pro-2:hadoop-2.5.1 zlq$ sbin/start-dfs.sh
14/09/25 14:06:40 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Starting namenodes on [localhost]
localhost: starting namenode, logging to /Users/zlq/servers/hadoop/hadoop-2.5.1/logs/hadoop-zlq-namenode-Apples-MacBook-Pro-2.local.out
localhost: starting datanode, logging to /Users/zlq/servers/hadoop/hadoop-2.5.1/logs/hadoop-zlq-datanode-Apples-MacBook-Pro-2.local.out
Starting secondary namenodes [0.0.0.0]
0.0.0.0: starting secondarynamenode, logging to /Users/zlq/servers/hadoop/hadoop-2.5.1/logs/hadoop-zlq-secondarynamenode-Apples-MacBook-Pro-2.local.out
14/09/25 14:06:55 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable

http://localhost:50070/


Apples-MacBook-Pro-2:hadoop-2.5.1 zlq$ bin/hdfs dfs -mkdir /user
14/09/25 14:25:59 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable


Apples-MacBook-Pro-2:hadoop-2.5.1 zlq$ bin/hdfs dfs -mkdir /user/zlq
14/09/25 14:26:32 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Apples-MacBook-Pro-2:hadoop-2.5.1 zlq$ bin/hdfs dfs -put etc/hadoop input
14/09/25 14:27:15 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable

Apples-MacBook-Pro-2:hadoop-2.5.1 zlq$ bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.5.1.jar grep input output 'dfs[a-z.]+'

```
14/09/25 14:28:29 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
14/09/25 14:28:29 INFO Configuration.deprecation: session.id is deprecated. Instead, use dfs.metrics.session-id
14/09/25 14:28:29 INFO jvm.JvmMetrics: Initializing JVM Metrics with processName=JobTracker, sessionId=
14/09/25 14:28:29 WARN mapreduce.JobSubmitter: No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
14/09/25 14:28:30 INFO input.FileInputFormat: Total input paths to process : 25
14/09/25 14:28:30 INFO mapreduce.JobSubmitter: number of splits:25
14/09/25 14:28:30 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_local1253080347_0001
14/09/25 14:28:30 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/staging/zlq1253080347/.staging/job_local1253080347_0001/job.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.retry.interval;  Ignoring.
14/09/25 14:28:30 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/staging/zlq1253080347/.staging/job_local1253080347_0001/job.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.attempts;  Ignoring.
14/09/25 14:28:30 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/local/localRunner/zlq/job_local1253080347_0001/job_local1253080347_0001.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.retry.interval;  Ignoring.
14/09/25 14:28:30 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/local/localRunner/zlq/job_local1253080347_0001/job_local1253080347_0001.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.attempts;  Ignoring.
14/09/25 14:28:30 INFO mapreduce.Job: The url to track the job: http://localhost:8080/
14/09/25 14:28:30 INFO mapreduce.Job: Running job: job_local1253080347_0001
14/09/25 14:28:30 INFO mapred.LocalJobRunner: OutputCommitter set in config null
14/09/25 14:28:30 INFO mapred.LocalJobRunner: OutputCommitter is org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter
14/09/25 14:28:30 INFO mapred.LocalJobRunner: Waiting for map tasks
14/09/25 14:28:30 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000000_0
14/09/25 14:28:30 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:30 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:30 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/log4j.properties:0+11118
14/09/25 14:28:30 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:30 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:30 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:30 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:30 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:30 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:30 INFO mapred.LocalJobRunner:
14/09/25 14:28:30 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:30 INFO mapred.MapTask: Spilling map output
14/09/25 14:28:30 INFO mapred.MapTask: bufstart = 0; bufend = 279; bufvoid = 104857600
14/09/25 14:28:30 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214364(104857456); length = 33/6553600
14/09/25 14:28:30 INFO mapred.MapTask: Finished spill 0
14/09/25 14:28:30 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000000_0 is done. And is in the process of committing
14/09/25 14:28:30 INFO mapred.LocalJobRunner: map
14/09/25 14:28:30 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000000_0' done.
14/09/25 14:28:30 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000000_0
14/09/25 14:28:30 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000001_0
14/09/25 14:28:30 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:30 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:30 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/hadoop-policy.xml:0+9201
14/09/25 14:28:30 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:30 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:30 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:30 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:30 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:30 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:30 INFO mapred.LocalJobRunner:
14/09/25 14:28:30 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:30 INFO mapred.MapTask: Spilling map output
14/09/25 14:28:30 INFO mapred.MapTask: bufstart = 0; bufend = 17; bufvoid = 104857600
14/09/25 14:28:30 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214396(104857584); length = 1/6553600
14/09/25 14:28:31 INFO mapred.MapTask: Finished spill 0
14/09/25 14:28:31 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000001_0 is done. And is in the process of committing
14/09/25 14:28:31 INFO mapred.LocalJobRunner: map
14/09/25 14:28:31 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000001_0' done.
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000001_0
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000002_0
14/09/25 14:28:31 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:31 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:31 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/yarn-env.sh:0+4567
14/09/25 14:28:31 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:31 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:31 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:31 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:31 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:31 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:31 INFO mapred.LocalJobRunner:
14/09/25 14:28:31 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:31 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000002_0 is done. And is in the process of committing
14/09/25 14:28:31 INFO mapred.LocalJobRunner: map
14/09/25 14:28:31 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000002_0' done.
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000002_0
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000003_0
14/09/25 14:28:31 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:31 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:31 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/mapred-queues.xml.template:0+4113
14/09/25 14:28:31 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:31 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:31 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:31 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:31 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:31 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:31 INFO mapred.LocalJobRunner:
14/09/25 14:28:31 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:31 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000003_0 is done. And is in the process of committing
14/09/25 14:28:31 INFO mapred.LocalJobRunner: map
14/09/25 14:28:31 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000003_0' done.
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000003_0
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000004_0
14/09/25 14:28:31 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:31 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:31 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/hadoop-env.cmd:0+3670
14/09/25 14:28:31 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:31 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:31 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:31 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:31 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:31 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:31 INFO mapred.LocalJobRunner:
14/09/25 14:28:31 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:31 INFO mapred.MapTask: Spilling map output
14/09/25 14:28:31 INFO mapred.MapTask: bufstart = 0; bufend = 50; bufvoid = 104857600
14/09/25 14:28:31 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214392(104857568); length = 5/6553600
14/09/25 14:28:31 INFO mapred.MapTask: Finished spill 0
14/09/25 14:28:31 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000004_0 is done. And is in the process of committing
14/09/25 14:28:31 INFO mapred.LocalJobRunner: map
14/09/25 14:28:31 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000004_0' done.
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000004_0
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000005_0
14/09/25 14:28:31 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:31 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:31 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/capacity-scheduler.xml:0+3589
14/09/25 14:28:31 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:31 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:31 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:31 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:31 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:31 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:31 INFO mapreduce.Job: Job job_local1253080347_0001 running in uber mode : false
14/09/25 14:28:31 INFO mapreduce.Job:  map 100% reduce 0%
14/09/25 14:28:31 INFO mapred.LocalJobRunner:
14/09/25 14:28:31 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:31 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000005_0 is done. And is in the process of committing
14/09/25 14:28:31 INFO mapred.LocalJobRunner: map
14/09/25 14:28:31 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000005_0' done.
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000005_0
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000006_0
14/09/25 14:28:31 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:31 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:31 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/hadoop-env.sh:0+3443
14/09/25 14:28:31 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:31 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:31 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:31 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:31 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:31 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:31 INFO mapred.LocalJobRunner:
14/09/25 14:28:31 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:31 INFO mapred.MapTask: Spilling map output
14/09/25 14:28:31 INFO mapred.MapTask: bufstart = 0; bufend = 50; bufvoid = 104857600
14/09/25 14:28:31 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214392(104857568); length = 5/6553600
14/09/25 14:28:31 INFO mapred.MapTask: Finished spill 0
14/09/25 14:28:31 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000006_0 is done. And is in the process of committing
14/09/25 14:28:31 INFO mapred.LocalJobRunner: map
14/09/25 14:28:31 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000006_0' done.
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000006_0
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000007_0
14/09/25 14:28:31 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:31 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:31 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/hadoop-metrics.properties:0+2490
14/09/25 14:28:31 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:31 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:31 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:31 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:31 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:31 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:31 INFO mapred.LocalJobRunner:
14/09/25 14:28:31 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:31 INFO mapred.MapTask: Spilling map output
14/09/25 14:28:31 INFO mapred.MapTask: bufstart = 0; bufend = 170; bufvoid = 104857600
14/09/25 14:28:31 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214364(104857456); length = 33/6553600
14/09/25 14:28:31 INFO mapred.MapTask: Finished spill 0
14/09/25 14:28:31 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000007_0 is done. And is in the process of committing
14/09/25 14:28:31 INFO mapred.LocalJobRunner: map
14/09/25 14:28:31 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000007_0' done.
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000007_0
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000008_0
14/09/25 14:28:31 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:31 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:31 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/ssl-client.xml.example:0+2316
14/09/25 14:28:31 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:31 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:31 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:31 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:31 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:31 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:31 INFO mapred.LocalJobRunner:
14/09/25 14:28:31 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:31 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000008_0 is done. And is in the process of committing
14/09/25 14:28:31 INFO mapred.LocalJobRunner: map
14/09/25 14:28:31 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000008_0' done.
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000008_0
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000009_0
14/09/25 14:28:31 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:31 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:31 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/ssl-server.xml.example:0+2268
14/09/25 14:28:31 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:31 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:31 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:31 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:31 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:31 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:31 INFO mapred.LocalJobRunner:
14/09/25 14:28:31 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:31 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000009_0 is done. And is in the process of committing
14/09/25 14:28:31 INFO mapred.LocalJobRunner: map
14/09/25 14:28:31 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000009_0' done.
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000009_0
14/09/25 14:28:31 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000010_0
14/09/25 14:28:31 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:31 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:31 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/yarn-env.cmd:0+2237
14/09/25 14:28:31 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:31 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:31 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:31 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:31 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:31 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:31 INFO mapred.LocalJobRunner:
14/09/25 14:28:31 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:31 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000010_0 is done. And is in the process of committing
14/09/25 14:28:32 INFO mapred.LocalJobRunner: map
14/09/25 14:28:32 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000010_0' done.
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000010_0
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000011_0
14/09/25 14:28:32 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:32 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:32 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/hadoop-metrics2.properties:0+1774
14/09/25 14:28:32 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:32 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:32 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:32 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:32 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:32 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:32 INFO mapred.LocalJobRunner:
14/09/25 14:28:32 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:32 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000011_0 is done. And is in the process of committing
14/09/25 14:28:32 INFO mapred.LocalJobRunner: map
14/09/25 14:28:32 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000011_0' done.
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000011_0
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000012_0
14/09/25 14:28:32 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:32 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:32 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/httpfs-log4j.properties:0+1657
14/09/25 14:28:32 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:32 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:32 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:32 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:32 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:32 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:32 INFO mapred.LocalJobRunner:
14/09/25 14:28:32 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:32 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000012_0 is done. And is in the process of committing
14/09/25 14:28:32 INFO mapred.LocalJobRunner: map
14/09/25 14:28:32 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000012_0' done.
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000012_0
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000013_0
14/09/25 14:28:32 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:32 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:32 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/httpfs-env.sh:0+1449
14/09/25 14:28:32 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:32 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:32 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:32 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:32 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:32 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:32 INFO mapred.LocalJobRunner:
14/09/25 14:28:32 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:32 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000013_0 is done. And is in the process of committing
14/09/25 14:28:32 INFO mapred.LocalJobRunner: map
14/09/25 14:28:32 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000013_0' done.
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000013_0
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000014_0
14/09/25 14:28:32 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:32 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:32 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/mapred-env.sh:0+1383
14/09/25 14:28:32 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:32 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:32 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:32 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:32 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:32 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:32 INFO mapred.LocalJobRunner:
14/09/25 14:28:32 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:32 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000014_0 is done. And is in the process of committing
14/09/25 14:28:32 INFO mapred.LocalJobRunner: map
14/09/25 14:28:32 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000014_0' done.
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000014_0
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000015_0
14/09/25 14:28:32 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:32 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:32 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/configuration.xsl:0+1335
14/09/25 14:28:32 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:32 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:32 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:32 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:32 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:32 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:32 INFO mapred.LocalJobRunner:
14/09/25 14:28:32 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:32 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000015_0 is done. And is in the process of committing
14/09/25 14:28:32 INFO mapred.LocalJobRunner: map
14/09/25 14:28:32 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000015_0' done.
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000015_0
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000016_0
14/09/25 14:28:32 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:32 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:32 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/mapred-env.cmd:0+938
14/09/25 14:28:32 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:32 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:32 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:32 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:32 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:32 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:32 INFO mapred.LocalJobRunner:
14/09/25 14:28:32 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:32 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000016_0 is done. And is in the process of committing
14/09/25 14:28:32 INFO mapred.LocalJobRunner: map
14/09/25 14:28:32 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000016_0' done.
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000016_0
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000017_0
14/09/25 14:28:32 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:32 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:32 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/core-site.xml:0+884
14/09/25 14:28:32 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:32 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:32 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:32 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:32 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:32 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:32 INFO mapred.LocalJobRunner:
14/09/25 14:28:32 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:32 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000017_0 is done. And is in the process of committing
14/09/25 14:28:32 INFO mapred.LocalJobRunner: map
14/09/25 14:28:32 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000017_0' done.
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000017_0
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000018_0
14/09/25 14:28:32 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:32 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:32 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/hdfs-site.xml:0+867
14/09/25 14:28:32 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:32 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:32 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:32 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:32 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:32 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:32 INFO mapred.LocalJobRunner:
14/09/25 14:28:32 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:32 INFO mapred.MapTask: Spilling map output
14/09/25 14:28:32 INFO mapred.MapTask: bufstart = 0; bufend = 24; bufvoid = 104857600
14/09/25 14:28:32 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214396(104857584); length = 1/6553600
14/09/25 14:28:32 INFO mapred.MapTask: Finished spill 0
14/09/25 14:28:32 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000018_0 is done. And is in the process of committing
14/09/25 14:28:32 INFO mapred.LocalJobRunner: map
14/09/25 14:28:32 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000018_0' done.
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000018_0
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000019_0
14/09/25 14:28:32 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:32 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:32 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/mapred-site.xml.template:0+758
14/09/25 14:28:32 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:32 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:32 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:32 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:32 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:32 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:32 INFO mapred.LocalJobRunner:
14/09/25 14:28:32 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:32 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000019_0 is done. And is in the process of committing
14/09/25 14:28:32 INFO mapred.LocalJobRunner: map
14/09/25 14:28:32 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000019_0' done.
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000019_0
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000020_0
14/09/25 14:28:32 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:32 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:32 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/yarn-site.xml:0+690
14/09/25 14:28:32 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:32 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:32 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:32 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:32 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:32 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:32 INFO mapred.LocalJobRunner:
14/09/25 14:28:32 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:32 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000020_0 is done. And is in the process of committing
14/09/25 14:28:32 INFO mapred.LocalJobRunner: map
14/09/25 14:28:32 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000020_0' done.
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000020_0
14/09/25 14:28:32 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000021_0
14/09/25 14:28:32 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:32 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:32 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/httpfs-site.xml:0+620
14/09/25 14:28:32 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:32 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:32 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:32 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:32 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:32 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:33 INFO mapred.LocalJobRunner:
14/09/25 14:28:33 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:33 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000021_0 is done. And is in the process of committing
14/09/25 14:28:33 INFO mapred.LocalJobRunner: map
14/09/25 14:28:33 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000021_0' done.
14/09/25 14:28:33 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000021_0
14/09/25 14:28:33 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000022_0
14/09/25 14:28:33 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:33 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:33 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/container-executor.cfg:0+318
14/09/25 14:28:33 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:33 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:33 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:33 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:33 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:33 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:33 INFO mapred.LocalJobRunner:
14/09/25 14:28:33 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:33 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000022_0 is done. And is in the process of committing
14/09/25 14:28:33 INFO mapred.LocalJobRunner: map
14/09/25 14:28:33 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000022_0' done.
14/09/25 14:28:33 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000022_0
14/09/25 14:28:33 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000023_0
14/09/25 14:28:33 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:33 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:33 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/httpfs-signature.secret:0+21
14/09/25 14:28:33 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:33 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:33 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:33 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:33 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:33 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:33 INFO mapred.LocalJobRunner:
14/09/25 14:28:33 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:33 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000023_0 is done. And is in the process of committing
14/09/25 14:28:33 INFO mapred.LocalJobRunner: map
14/09/25 14:28:33 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000023_0' done.
14/09/25 14:28:33 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000023_0
14/09/25 14:28:33 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_m_000024_0
14/09/25 14:28:33 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:33 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:33 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/input/slaves:0+10
14/09/25 14:28:33 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:33 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:33 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:33 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:33 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:33 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:33 INFO mapred.LocalJobRunner:
14/09/25 14:28:33 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:33 INFO mapred.Task: Task:attempt_local1253080347_0001_m_000024_0 is done. And is in the process of committing
14/09/25 14:28:33 INFO mapred.LocalJobRunner: map
14/09/25 14:28:33 INFO mapred.Task: Task 'attempt_local1253080347_0001_m_000024_0' done.
14/09/25 14:28:33 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_m_000024_0
14/09/25 14:28:33 INFO mapred.LocalJobRunner: map task executor complete.
14/09/25 14:28:33 INFO mapred.LocalJobRunner: Waiting for reduce tasks
14/09/25 14:28:33 INFO mapred.LocalJobRunner: Starting task: attempt_local1253080347_0001_r_000000_0
14/09/25 14:28:33 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:33 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:33 INFO mapred.ReduceTask: Using ShuffleConsumerPlugin: org.apache.hadoop.mapreduce.task.reduce.Shuffle@5a3564a1
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: MergerManager: memoryLimit=333971456, maxSingleShuffleLimit=83492864, mergeThreshold=220421168, ioSortFactor=10, memToMemMergeOutputsThreshold=10
14/09/25 14:28:33 INFO reduce.EventFetcher: attempt_local1253080347_0001_r_000000_0 Thread started: EventFetcher for fetching Map Completion Events
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000023_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000023_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 1, commitMemory -> 0, usedMemory ->2
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000011_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000011_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 2, commitMemory -> 2, usedMemory ->4
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000004_0 decomp: 29 len: 33 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 29 bytes from map-output for attempt_local1253080347_0001_m_000004_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 29, inMemoryMapOutputs.size() -> 3, commitMemory -> 4, usedMemory ->33
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000016_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000016_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 4, commitMemory -> 33, usedMemory ->35
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000017_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000017_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 5, commitMemory -> 35, usedMemory ->37
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000010_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000010_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 6, commitMemory -> 37, usedMemory ->39
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000021_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000021_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 7, commitMemory -> 39, usedMemory ->41
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000009_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000009_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 8, commitMemory -> 41, usedMemory ->43
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000003_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000003_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 9, commitMemory -> 43, usedMemory ->45
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000015_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000015_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 10, commitMemory -> 45, usedMemory ->47
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000008_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000008_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 11, commitMemory -> 47, usedMemory ->49
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000002_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000002_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 12, commitMemory -> 49, usedMemory ->51
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000022_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000022_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 13, commitMemory -> 51, usedMemory ->53
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000001_0 decomp: 21 len: 25 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 21 bytes from map-output for attempt_local1253080347_0001_m_000001_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 21, inMemoryMapOutputs.size() -> 14, commitMemory -> 53, usedMemory ->74
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000013_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000013_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 15, commitMemory -> 74, usedMemory ->76
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000020_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000020_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 16, commitMemory -> 76, usedMemory ->78
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000014_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000014_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 17, commitMemory -> 78, usedMemory ->80
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000000_0 decomp: 135 len: 139 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 135 bytes from map-output for attempt_local1253080347_0001_m_000000_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 135, inMemoryMapOutputs.size() -> 18, commitMemory -> 80, usedMemory ->215
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000007_0 decomp: 109 len: 113 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 109 bytes from map-output for attempt_local1253080347_0001_m_000007_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 109, inMemoryMapOutputs.size() -> 19, commitMemory -> 215, usedMemory ->324
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000024_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000024_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 20, commitMemory -> 324, usedMemory ->326
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000018_0 decomp: 28 len: 32 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 28 bytes from map-output for attempt_local1253080347_0001_m_000018_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 28, inMemoryMapOutputs.size() -> 21, commitMemory -> 326, usedMemory ->354
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000006_0 decomp: 29 len: 33 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 29 bytes from map-output for attempt_local1253080347_0001_m_000006_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 29, inMemoryMapOutputs.size() -> 22, commitMemory -> 354, usedMemory ->383
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000005_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000005_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 23, commitMemory -> 383, usedMemory ->385
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000012_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000012_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 24, commitMemory -> 385, usedMemory ->387
14/09/25 14:28:33 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1253080347_0001_m_000019_0 decomp: 2 len: 6 to MEMORY
14/09/25 14:28:33 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1253080347_0001_m_000019_0
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 25, commitMemory -> 387, usedMemory ->389
14/09/25 14:28:33 INFO reduce.EventFetcher: EventFetcher is interrupted.. Returning
14/09/25 14:28:33 INFO mapred.LocalJobRunner: 25 / 25 copied.
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: finalMerge called with 25 in-memory map-outputs and 0 on-disk map-outputs
14/09/25 14:28:33 INFO mapred.Merger: Merging 25 sorted segments
14/09/25 14:28:33 INFO mapred.Merger: Down to the last merge-pass, with 6 segments left of total size: 241 bytes
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: Merged 25 segments, 389 bytes to disk to satisfy reduce memory limit
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: Merging 1 files, 345 bytes from disk
14/09/25 14:28:33 INFO reduce.MergeManagerImpl: Merging 0 segments, 0 bytes from memory into reduce
14/09/25 14:28:33 INFO mapred.Merger: Merging 1 sorted segments
14/09/25 14:28:33 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 310 bytes
14/09/25 14:28:33 INFO mapred.LocalJobRunner: 25 / 25 copied.
14/09/25 14:28:33 INFO Configuration.deprecation: mapred.skip.on is deprecated. Instead, use mapreduce.job.skiprecords
14/09/25 14:28:33 INFO mapred.Task: Task:attempt_local1253080347_0001_r_000000_0 is done. And is in the process of committing
14/09/25 14:28:33 INFO mapred.LocalJobRunner: 25 / 25 copied.
14/09/25 14:28:33 INFO mapred.Task: Task attempt_local1253080347_0001_r_000000_0 is allowed to commit now
14/09/25 14:28:33 INFO output.FileOutputCommitter: Saved output of task 'attempt_local1253080347_0001_r_000000_0' to hdfs://localhost:9000/user/zlq/grep-temp-1304434231/_temporary/0/task_local1253080347_0001_r_000000
14/09/25 14:28:33 INFO mapred.LocalJobRunner: reduce > reduce
14/09/25 14:28:33 INFO mapred.Task: Task 'attempt_local1253080347_0001_r_000000_0' done.
14/09/25 14:28:33 INFO mapred.LocalJobRunner: Finishing task: attempt_local1253080347_0001_r_000000_0
14/09/25 14:28:33 INFO mapred.LocalJobRunner: reduce task executor complete.
14/09/25 14:28:34 INFO mapreduce.Job:  map 100% reduce 100%
14/09/25 14:28:34 INFO mapreduce.Job: Job job_local1253080347_0001 completed successfully
14/09/25 14:28:34 INFO mapreduce.Job: Counters: 35
	File System Counters
		FILE: Number of bytes read=810584
		FILE: Number of bytes written=6063899
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=1249714
		HDFS: Number of bytes written=437
		HDFS: Number of read operations=807
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=28
	Map-Reduce Framework
		Map input records=1588
		Map output records=24
		Map output bytes=590
		Map output materialized bytes=489
		Input split bytes=2985
		Combine input records=24
		Combine output records=13
		Reduce input groups=11
		Reduce shuffle bytes=489
		Reduce input records=13
		Reduce output records=11
		Spilled Records=26
		Shuffled Maps =25
		Failed Shuffles=0
		Merged Map outputs=25
		GC time elapsed (ms)=574
		Total committed heap usage (bytes)=9319743488
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=61716
	File Output Format Counters
		Bytes Written=437
14/09/25 14:28:34 INFO jvm.JvmMetrics: Cannot initialize JVM Metrics with processName=JobTracker, sessionId= - already initialized
14/09/25 14:28:34 WARN mapreduce.JobSubmitter: No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
14/09/25 14:28:34 INFO input.FileInputFormat: Total input paths to process : 1
14/09/25 14:28:34 INFO mapreduce.JobSubmitter: number of splits:1
14/09/25 14:28:34 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_local2025097035_0002
14/09/25 14:28:34 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/staging/zlq2025097035/.staging/job_local2025097035_0002/job.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.retry.interval;  Ignoring.
14/09/25 14:28:34 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/staging/zlq2025097035/.staging/job_local2025097035_0002/job.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.attempts;  Ignoring.
14/09/25 14:28:34 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/local/localRunner/zlq/job_local2025097035_0002/job_local2025097035_0002.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.retry.interval;  Ignoring.
14/09/25 14:28:34 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/local/localRunner/zlq/job_local2025097035_0002/job_local2025097035_0002.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.attempts;  Ignoring.
14/09/25 14:28:34 INFO mapreduce.Job: The url to track the job: http://localhost:8080/
14/09/25 14:28:34 INFO mapreduce.Job: Running job: job_local2025097035_0002
14/09/25 14:28:34 INFO mapred.LocalJobRunner: OutputCommitter set in config null
14/09/25 14:28:34 INFO mapred.LocalJobRunner: OutputCommitter is org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter
14/09/25 14:28:34 INFO mapred.LocalJobRunner: Waiting for map tasks
14/09/25 14:28:34 INFO mapred.LocalJobRunner: Starting task: attempt_local2025097035_0002_m_000000_0
14/09/25 14:28:34 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:34 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:34 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/zlq/grep-temp-1304434231/part-r-00000:0+437
14/09/25 14:28:34 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 14:28:34 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 14:28:34 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 14:28:34 INFO mapred.MapTask: soft limit at 83886080
14/09/25 14:28:34 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 14:28:34 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 14:28:34 INFO mapred.LocalJobRunner:
14/09/25 14:28:34 INFO mapred.MapTask: Starting flush of map output
14/09/25 14:28:34 INFO mapred.MapTask: Spilling map output
14/09/25 14:28:34 INFO mapred.MapTask: bufstart = 0; bufend = 263; bufvoid = 104857600
14/09/25 14:28:34 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214356(104857424); length = 41/6553600
14/09/25 14:28:34 INFO mapred.MapTask: Finished spill 0
14/09/25 14:28:34 INFO mapred.Task: Task:attempt_local2025097035_0002_m_000000_0 is done. And is in the process of committing
14/09/25 14:28:34 INFO mapred.LocalJobRunner: map
14/09/25 14:28:34 INFO mapred.Task: Task 'attempt_local2025097035_0002_m_000000_0' done.
14/09/25 14:28:34 INFO mapred.LocalJobRunner: Finishing task: attempt_local2025097035_0002_m_000000_0
14/09/25 14:28:34 INFO mapred.LocalJobRunner: map task executor complete.
14/09/25 14:28:34 INFO mapred.LocalJobRunner: Waiting for reduce tasks
14/09/25 14:28:34 INFO mapred.LocalJobRunner: Starting task: attempt_local2025097035_0002_r_000000_0
14/09/25 14:28:34 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 14:28:34 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 14:28:34 INFO mapred.ReduceTask: Using ShuffleConsumerPlugin: org.apache.hadoop.mapreduce.task.reduce.Shuffle@631e426e
14/09/25 14:28:34 INFO reduce.MergeManagerImpl: MergerManager: memoryLimit=333971456, maxSingleShuffleLimit=83492864, mergeThreshold=220421168, ioSortFactor=10, memToMemMergeOutputsThreshold=10
14/09/25 14:28:34 INFO reduce.EventFetcher: attempt_local2025097035_0002_r_000000_0 Thread started: EventFetcher for fetching Map Completion Events
14/09/25 14:28:34 INFO reduce.LocalFetcher: localfetcher#2 about to shuffle output of map attempt_local2025097035_0002_m_000000_0 decomp: 287 len: 291 to MEMORY
14/09/25 14:28:34 INFO reduce.InMemoryMapOutput: Read 287 bytes from map-output for attempt_local2025097035_0002_m_000000_0
14/09/25 14:28:34 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 287, inMemoryMapOutputs.size() -> 1, commitMemory -> 0, usedMemory ->287
14/09/25 14:28:34 INFO reduce.EventFetcher: EventFetcher is interrupted.. Returning
14/09/25 14:28:34 INFO mapred.LocalJobRunner: 1 / 1 copied.
14/09/25 14:28:34 INFO reduce.MergeManagerImpl: finalMerge called with 1 in-memory map-outputs and 0 on-disk map-outputs
14/09/25 14:28:34 INFO mapred.Merger: Merging 1 sorted segments
14/09/25 14:28:34 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 277 bytes
14/09/25 14:28:34 INFO reduce.MergeManagerImpl: Merged 1 segments, 287 bytes to disk to satisfy reduce memory limit
14/09/25 14:28:34 INFO reduce.MergeManagerImpl: Merging 1 files, 291 bytes from disk
14/09/25 14:28:34 INFO reduce.MergeManagerImpl: Merging 0 segments, 0 bytes from memory into reduce
14/09/25 14:28:34 INFO mapred.Merger: Merging 1 sorted segments
14/09/25 14:28:34 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 277 bytes
14/09/25 14:28:34 INFO mapred.LocalJobRunner: 1 / 1 copied.
14/09/25 14:28:34 INFO mapred.Task: Task:attempt_local2025097035_0002_r_000000_0 is done. And is in the process of committing
14/09/25 14:28:34 INFO mapred.LocalJobRunner: 1 / 1 copied.
14/09/25 14:28:34 INFO mapred.Task: Task attempt_local2025097035_0002_r_000000_0 is allowed to commit now
14/09/25 14:28:34 INFO output.FileOutputCommitter: Saved output of task 'attempt_local2025097035_0002_r_000000_0' to hdfs://localhost:9000/user/zlq/output/_temporary/0/task_local2025097035_0002_r_000000
14/09/25 14:28:34 INFO mapred.LocalJobRunner: reduce > reduce
14/09/25 14:28:34 INFO mapred.Task: Task 'attempt_local2025097035_0002_r_000000_0' done.
14/09/25 14:28:34 INFO mapred.LocalJobRunner: Finishing task: attempt_local2025097035_0002_r_000000_0
14/09/25 14:28:34 INFO mapred.LocalJobRunner: reduce task executor complete.
14/09/25 14:28:35 INFO mapreduce.Job: Job job_local2025097035_0002 running in uber mode : false
14/09/25 14:28:35 INFO mapreduce.Job:  map 100% reduce 100%
14/09/25 14:28:35 INFO mapreduce.Job: Job job_local2025097035_0002 completed successfully
14/09/25 14:28:35 INFO mapreduce.Job: Counters: 35
	File System Counters
		FILE: Number of bytes read=97204
		FILE: Number of bytes written=923683
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=124306
		HDFS: Number of bytes written=1071
		HDFS: Number of read operations=141
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=16
	Map-Reduce Framework
		Map input records=11
		Map output records=11
		Map output bytes=263
		Map output materialized bytes=291
		Input split bytes=129
		Combine input records=0
		Combine output records=0
		Reduce input groups=5
		Reduce shuffle bytes=291
		Reduce input records=11
		Reduce output records=11
		Spilled Records=22
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=0
		Total committed heap usage (bytes)=706740224
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=437
	File Output Format Counters
		Bytes Written=197
```

Apples-MacBook-Pro-2:hadoop-2.5.1 zlq$ bin/hdfs dfs -get output output
14/09/25 14:35:04 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable


Apples-MacBook-Pro-2:hadoop-2.5.1 zlq$ bin/hdfs dfs -cat output/*
14/09/25 14:35:40 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
6	dfs.audit.logger
4	dfs.class
3	dfs.server.namenode.
2	dfs.period
2	dfs.audit.log.maxfilesize
2	dfs.audit.log.maxbackupindex
1	dfsmetrics.log
1	dfsadmin
1	dfs.servers
1	dfs.replication
1	dfs.file


Apples-MacBook-Pro-2:hadoop-2.5.1 zlq$ sbin/stop-dfs.sh
14/09/25 14:36:02 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Stopping namenodes on [localhost]
localhost: stopping namenode
localhost: stopping datanode
Stopping secondary namenodes [0.0.0.0]
0.0.0.0: stopping secondarynamenode
14/09/25 14:36:20 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable


# yarn
etc/hadoop/mapred-site.xml:

```
<configuration>
    <property>
        <name>mapreduce.framework.name</name>
        <value>yarn</value>
    </property>
</configuration>
```

etc/hadoop/yarn-site.xml:

```
<configuration>
    <property>
        <name>yarn.nodemanager.aux-services</name>
        <value>mapreduce_shuffle</value>
    </property>
</configuration>
```

Apples-MacBook-Pro-2:hadoop-2.5.1 zlq$ sbin/stop-dfs.sh
14/09/25 14:36:02 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Stopping namenodes on [localhost]
localhost: stopping namenode
localhost: stopping datanode
Stopping secondary namenodes [0.0.0.0]
0.0.0.0: stopping secondarynamenode
14/09/25 14:36:20 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Apples-MacBook-Pro-2:hadoop-2.5.1 zlq$ sbin/start-yarn.sh
starting yarn daemons
starting resourcemanager, logging to /Users/zlq/servers/hadoop/hadoop-2.5.1/logs/yarn-zlq-resourcemanager-Apples-MacBook-Pro-2.local.out
localhost: starting nodemanager, logging to /Users/zlq/servers/hadoop/hadoop-2.5.1/logs/yarn-zlq-nodemanager-Apples-MacBook-Pro-2.local.out


Apples-MacBook-Pro-2:hadoop-2.5.1 zlq$ sbin/stop-yarn.sh
stopping yarn daemons
stopping resourcemanager
localhost: stopping nodemanager
no proxyserver to stop