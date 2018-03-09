# hadoop单机上伪分布式部署与使用实战

## 1 hadoop系统搭建

### 下载

[http://mirrors.cnnic.cn/apache/hadoop/common/hadoop-2.6.0/hadoop-2.6.0.tar.gz](http://mirrors.cnnic.cn/apache/hadoop/common/hadoop-2.6.0/hadoop-2.6.0.tar.gz)

### 配置hadoop

使用本仓库配置文件配置

### 启动hadoop

#### 格式化HDFS文件系统

```
bin/hdfs namenode -format
```

```
/tmp/hadoop-zlq/
└── dfs
    └── name
        └── current
            ├── VERSION
            ├── fsimage_0000000000000000000
            ├── fsimage_0000000000000000000.md5
            └── seen_txid

3 directories, 4 files
```

```
cat /tmp/hadoop-zlq/dfs/name/current/VERSION
```

```
#Sat Jan 24 16:27:22 CST 2015
namespaceID=1194974531
clusterID=CID-61cf61b6-703f-4b1e-92d2-672aabf71b18
cTime=0
storageType=NAME_NODE
blockpoolID=BP-1697830516-127.0.0.1-1422088042899
layoutVersion=-60
```

HDFS文件系统在宿主机上创建一个`/tmp/hadoop-zlq`目录并初始化

#### 启动HDFS

```
sbin/start-dfs.sh
```

HDFS系统界面

[http://localhost:50070/](http://localhost:50070/)

#### 启动yarn

```
sbin/start-yarn.sh
```

资源管理器界面

[http://localhost:8088/](http://localhost:8088/)

#### 启动的进程

使用`jps`命名可以看到启动了如下5个进程

```
19082 NameNode
19449 NodeManager
19375 ResourceManager
19171 DataNode
19263 SecondaryNameNode
```

## 2 使用HDFS和yarn

在HDFS里创建一个用户目录

```
bin/hdfs dfs -mkdir /user

bin/hdfs dfs -mkdir /user/zlq
```

将宿主机上得文件夹的文件复制到HDFS的用户目录下的input目录

```
bin/hdfs dfs -put etc/hadoop input
```

在HDFS的用户目录下，使用输入目录input，map-reduce程序使用正则表达式过滤一些文本片段并把出现次数的统计结果输出到output目录

```
bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.6.0.jar grep input output 'dfs[a-z.]+'
```

将HDFS用户目录下的output文件夹复制到宿主机当前目录

```
bin/hdfs dfs -get output output
```

使用命令`cat output/*`查看结果

```
6   dfs.audit.logger
4   dfs.class
3   dfs.server.namenode.
2   dfs.period
2   dfs.audit.log.maxfilesize
2   dfs.audit.log.maxbackupindex
1   dfsmetrics.log
1   dfsadmin
1   dfs.servers
1   dfs.replication
1   dfs.file
```

删除input和output目录

```
bin/hdfs dfs -rm -r input

bin/hdfs dfs -rm -r output
```

运行wordcount例子

```
bin/hdfs dfs -mkdir input
bin/hdfs dfs -put LICENSE.txt README.txt NOTICE.txt input

bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.6.0.jar wordcount input output

bin/hdfs dfs -get output output
```

## 3 停止yarn

```
sbin/stop-yarn.sh
```

## 4 停止HDFS

```
sbin/stop-dfs.sh
```

## 5 注意点

如果`/bin/java`不存在，创建如下软链接

```
sudo ln -s $JAVA_HOME/bin/java /bin/java
```

## 6 参考资料

[http://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-common/SingleCluster.html](http://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-common/SingleCluster.html)
