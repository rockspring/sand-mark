# hadoop

版本：2.7.3

## hadoop

```
zlq@Apples-MacBook-Pro-2:hadoop-2.7.3$ bin/hadoop
Usage: hadoop [--config confdir] [COMMAND | CLASSNAME]
  CLASSNAME            run the class named CLASSNAME
 or
  where COMMAND is one of:
  fs                   run a generic filesystem user client
  version              print the version
  jar <jar>            run a jar file
                       note: please use "yarn jar" to launch
                             YARN applications, not this command.
  checknative [-a|-h]  check native hadoop and compression libraries availability
  distcp <srcurl> <desturl> copy file or directories recursively
  archive -archiveName NAME -p <parent path> <src>* <dest> create a hadoop archive
  classpath            prints the class path needed to get the
  credential           interact with credential providers
                       Hadoop jar and the required libraries
  daemonlog            get/set the log level for each daemon
  trace                view and modify Hadoop tracing settings

Most commands print help when invoked w/o parameters.
```

```
zlq@Apples-MacBook-Pro-2:hadoop-2.7.3$ bin/hdfs
Usage: hdfs [--config confdir] [--loglevel loglevel] COMMAND
       where COMMAND is one of:
  dfs                  run a filesystem command on the file systems supported in Hadoop.
  classpath            prints the classpath
  namenode -format     format the DFS filesystem
  secondarynamenode    run the DFS secondary namenode
  namenode             run the DFS namenode
  journalnode          run the DFS journalnode
  zkfc                 run the ZK Failover Controller daemon
  datanode             run a DFS datanode
  dfsadmin             run a DFS admin client
  haadmin              run a DFS HA admin client
  fsck                 run a DFS filesystem checking utility
  balancer             run a cluster balancing utility
  jmxget               get JMX exported values from NameNode or DataNode.
  mover                run a utility to move block replicas across
                       storage types
  oiv                  apply the offline fsimage viewer to an fsimage
  oiv_legacy           apply the offline fsimage viewer to an legacy fsimage
  oev                  apply the offline edits viewer to an edits file
  fetchdt              fetch a delegation token from the NameNode
  getconf              get config values from configuration
  groups               get the groups which users belong to
  snapshotDiff         diff two snapshots of a directory or diff the
                       current directory contents with a snapshot
  lsSnapshottableDir   list all snapshottable dirs owned by the current user
						Use -help to see options
  portmap              run a portmap service
  nfs3                 run an NFS version 3 gateway
  cacheadmin           configure the HDFS cache
  crypto               configure HDFS encryption zones
  storagepolicies      list/get/set block storage policies
  version              print the version

Most commands print help when invoked w/o parameters.
```

```
zlq@Apples-MacBook-Pro-2:hadoop-2.7.3$ bin/mapred
Usage: mapred [--config confdir] [--loglevel loglevel] COMMAND
       where COMMAND is one of:
  pipes                run a Pipes job
  job                  manipulate MapReduce jobs
  queue                get information regarding JobQueues
  classpath            prints the class path needed for running
                       mapreduce subcommands
  historyserver        run job history servers as a standalone daemon
  distcp <srcurl> <desturl> copy file or directories recursively
  archive -archiveName NAME -p <parent path> <src>* <dest> create a hadoop archive
  hsadmin              job history server admin interface

Most commands print help when invoked w/o parameters.
```

```
zlq@Apples-MacBook-Pro-2:hadoop-2.7.3$ bin/rcc
Usage: rcc --language [java|c++] ddl-files
```

```
zlq@Apples-MacBook-Pro-2:hadoop-2.7.3$ bin/yarn
Usage: yarn [--config confdir] [COMMAND | CLASSNAME]
  CLASSNAME                             run the class named CLASSNAME
 or
  where COMMAND is one of:
  resourcemanager -format-state-store   deletes the RMStateStore
  resourcemanager                       run the ResourceManager
  nodemanager                           run a nodemanager on each slave
  timelineserver                        run the timeline server
  rmadmin                               admin tools
  sharedcachemanager                    run the SharedCacheManager daemon
  scmadmin                              SharedCacheManager admin tools
  version                               print the version
  jar <jar>                             run a jar file
  application                           prints application(s)
                                        report/kill application
  applicationattempt                    prints applicationattempt(s)
                                        report
  container                             prints container(s) report
  node                                  prints node report(s)
  queue                                 prints queue information
  logs                                  dump container logs
  classpath                             prints the class path needed to
                                        get the Hadoop jar and the
                                        required libraries
  cluster                               prints cluster information
  daemonlog                             get/set the log level for each
                                        daemon

Most commands print help when invoked w/o parameters.
```


# 启动

sbin/start-all.sh

这个脚本已经废弃，使用sbin/start-dfs.sh和sbin/start-yarn.sh

## sbin/start-dfs.sh

namenodes

datanodes

secondary namenodes

quorumjournal nodes

ZK Failover controllers

# jsvc

https://commons.apache.org/proper/commons-daemon/jsvc.html

使得java程序在Linux系统运行更容易。能够执行一些特权操作（如绑定小于1024的端口号）。


# 属性-Djava.net.preferIPv4Stack=true

http://docs.oracle.com/javase/8/docs/technotes/guides/net/ipv6_guide/

java的网络协议配置

# 属性-Dhadoop.security.logger=${HADOOP_SECURITY_LOGGER:-INFO,RFAS}

# 属性-Dhdfs.audit.logger=${HDFS_AUDIT_LOGGER:-INFO,NullAppender}


# hadoop-policy.xml

Service Level Authorization

连接特定hadoop服务的客户端有必要的预配置的权限，被授权能够访问服务。例如，配置MapReduce cluster服务允许特定用户组的用户提交job。这个授权检查是在文件权限访问检查、job队列访问权限检查之前的一个检查。

# 类加载器

HADOOP_USE_CLIENT_CLASSLOADER Boolean
HADOOP_CLASSPATH String
HADOOP_CLIENT_CLASSLOADER_SYSTEM_CLASSES String
HADOOP_USER_CLASSPATH_FIRST

org/apache/hadoop/util/RunJar.java

# 编译hadoop 2.7.3

libprotoc 2.5.0




# hadoop相关进程

## 主名字服务器

http://10.249.30.179:50070/dfshealth.html#tab-overview

RPC端口9000

localhost:9000->localhost:36156

## 第二名字服务器

http://10.249.30.179:50090/status.html

## 数据节点

http://10.249.30.179:50075/

RPC端口50010，43217，50020

localhost:36156->localhost:9000

## 资源管理节点
http://10.249.30.179:8088/cluster

RPC端口：8031，8030，8032，omniorb，8033

shg4873-ThinkPad-L460:8031->localhost:58668

## 节点管理进程

http://10.249.30.179:8042/node

RPC端口：37341，8040

localhost:58668->shg4873-ThinkPad-L460:8031