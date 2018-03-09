hive安装

metastore使用mysql


需要下载mysql-connector，并放入hive的lib目录

[https://dev.mysql.com/downloads/connector/j/](https://dev.mysql.com/downloads/connector/j/)

cp mysql-connector-java-5.1.40/mysql-connector-java-5.1.40-bin.jar lib/


cp conf/hive-default.xml.template conf/hive-site.xml

修改配置

```
diff --git a/conf/hive-site.xml b/conf/hive-site.xml
index fc1e162..6238d9b 100644
--- a/conf/hive-site.xml
+++ b/conf/hive-site.xml
@@ -41,12 +41,12 @@
   </property>
   <property>
     <name>hive.exec.local.scratchdir</name>
-    <value>${system:java.io.tmpdir}/${system:user.name}</value>
+    <value>/tmp/hive</value>
     <description>Local scratch space for Hive jobs</description>
   </property>
   <property>
     <name>hive.downloaded.resources.dir</name>
-    <value>${system:java.io.tmpdir}/${hive.session.id}_resources</value>
+    <value>tmp/${hive.session.id}_resources</value>
     <description>Temporary local directory for added resources in the remote file system.</description>
   </property>
   <property>
@@ -483,7 +483,7 @@
   </property>
   <property>
     <name>javax.jdo.option.ConnectionPassword</name>
-    <value>mine</value>
+    <value>admin</value>
     <description>password to use against metastore database</description>
   </property>
   <property>
@@ -498,7 +498,7 @@
   </property>
   <property>
     <name>javax.jdo.option.ConnectionURL</name>
-    <value>jdbc:derby:;databaseName=metastore_db;create=true</value>
+    <value>jdbc:mysql://localhost:3306/metastore_db?createDatabaseIfNotExist=true</value>
     <description>
       JDBC connect string for a JDBC metastore.
       To use SSL to encrypt/authenticate the connection, provide database-specific SSL flag in the connection URL.
@@ -930,7 +930,7 @@
   </property>
   <property>
     <name>javax.jdo.option.ConnectionDriverName</name>
-    <value>org.apache.derby.jdbc.EmbeddedDriver</value>
+    <value>com.mysql.jdbc.Driver</value>
     <description>Driver class name for a JDBC metastore</description>
   </property>
   <property>
@@ -955,7 +955,7 @@
   </property>
   <property>
     <name>javax.jdo.option.ConnectionUserName</name>
-    <value>APP</value>
+    <value>root</value>
     <description>Username to use against metastore database</description>
   </property>
   <property>
```

## 在hdfs里创建目录

```
bin/hdfs dfs -mkdir /tmp
bin/hdfs dfs -mkdir -p /user/hive/warehouse
bin/hdfs dfs -chmod g+w /tmp
bin/hdfs dfs -chmod g+w /user/hive/warehouse
```

## hive(已经废弃)

```
bin/hive
```

## hive的metastore初始化

```
export HADOOP_HOME=~/Servers/hadoop/hadoop-2.8.0
export HIVE_HOME=~/Servers/hive/apache-hive-2.1.1-bin
export SPARK_DRIVER_MEMORY=1g

mkdir -p hcatalog/var/log

bin/schematool -dbType mysql -initSchema
```

## HiveServer2 and Beeline

```
nohup bin/hiveserver2 --hiveconf hive.root.logger=DEBUG,console &
```

```
bin/beeline -u jdbc:hive2://localhost:10000 -n anonymous -panonymous
```

## HCatalog

```
hcatalog/sbin/hcat_server.sh start
```

启动成功提示信息

```
Started metastore server init, testing if initialized correctly...
Metastore initialized successfully on port[9083].
```

使用hcatalog

```
hcatalog/bin/hcat
```

## WebHCat

```
hcatalog/sbin/webhcat_server.sh start
```

使用webhcat

```
curl http://localhost:50111/templeton/v1/status
curl http://localhost:50111/templeton/v1/version
curl http://localhost:50111/templeton/v1/version/hive
curl http://localhost:50111/templeton/v1/version/hadoop
```


## create table

```
create table test (key int, value string) row format delimited fields terminated by '\t';
```

test.txt
```
1	a
2	b
```

## 导入数据

```
load data local inpath 'test.txt' into table test;
```

## 执行query

```
insert into test values(1,"test");
select * from test;
select count(*) from test;
```

## 退出交互式系统

```
!q
```

## 切换执行引擎

```
export SPARK_HOME=/home/shg4873/Servers/spark/spark-2.1.1-bin-hadoop2.7

set hiveconf:hive.root.logger=DEBUG,console;

set hive.execution.engine=mr;
set hive.execution.engine=tez;
set hive.execution.engine=spark;

set spark.home=/home/shg4873/Servers/spark/spark-2.1.1-bin-hadoop2.7;

ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/scala-library-2.11.8.jar scala-library-2.11.8.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/spark-core_2.11-2.1.1.jar spark-core_2.11-2.1.1.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/spark-network-common_2.11-2.1.1.jar spark-network-common_2.11-2.1.1.jar

ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/chill-java-0.8.0.jar chill-java-0.8.0.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/chill_2.11-0.8.0.jar chill_2.11-0.8.0.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/jackson-module-paranamer-2.6.5.jar jackson-module-paranamer-2.6.5.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/jackson-module-scala_2.11-2.6.5.jar jackson-module-scala_2.11-2.6.5.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/jersey-container-servlet-core-2.22.2.jar jersey-container-servlet-core-2.22.2.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/jersey-server-2.22.2.jar jersey-server-2.22.2.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/json4s-ast_2.11-3.2.11.jar json4s-ast_2.11-3.2.11.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/kryo-shaded-3.0.3.jar kryo-shaded-3.0.3.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/minlog-1.3.0.jar minlog-1.3.0.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/scala-xml_2.11-1.0.2.jar scala-xml_2.11-1.0.2.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/spark-launcher_2.11-2.1.1.jar spark-launcher_2.11-2.1.1.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/spark-network-shuffle_2.11-2.1.1.jar spark-network-shuffle_2.11-2.1.1.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/spark-unsafe_2.11-2.1.1.jar spark-unsafe_2.11-2.1.1.jar
ln -s ~/Servers/spark/spark-2.1.1-bin-hadoop2.7/jars/xbean-asm5-shaded-4.4.jar xbean-asm5-shaded-4.4.jar

set spark.master=local;
set spark.master=yarn;
set spark.master=spark://shg4873-ThinkPad-L460:7077;

set spark.executor.cores=1;
set spark.driver.memory=4g; //没起作用
set spark.executor.memory=512m;
set spark.executor.instances=1;

set spark.yarn.driver.memoryOverhead
set spark.yarn.executor.memoryOverhead;
```

## 错误排查

org.apache.spark.memory.UnifiedMemoryManager#getMaxMemory

```
Caused by: java.lang.IllegalArgumentException: System memory 239075328 must be at least 471859200. Please increase heap size using the --driver-memory option or spark.driver.memory in Spark configuration.
	at org.apache.spark.memory.UnifiedMemoryManager$.getMaxMemory(UnifiedMemoryManager.scala:216)
```

```
private def getMaxMemory(conf: SparkConf): Long = {
    val systemMemory = conf.getLong("spark.testing.memory", Runtime.getRuntime.maxMemory)
    val reservedMemory = conf.getLong("spark.testing.reservedMemory",
      if (conf.contains("spark.testing")) 0 else RESERVED_SYSTEM_MEMORY_BYTES)
    val minSystemMemory = (reservedMemory * 1.5).ceil.toLong
    if (systemMemory < minSystemMemory) {
      throw new IllegalArgumentException(s"System memory $systemMemory must " +
        s"be at least $minSystemMemory. Please increase heap size using the --driver-memory " +
        s"option or spark.driver.memory in Spark configuration.")
    }
    // SPARK-12759 Check executor memory to fail fast if memory is insufficient
    if (conf.contains("spark.executor.memory")) {
      val executorMemory = conf.getSizeAsBytes("spark.executor.memory")
      if (executorMemory < minSystemMemory) {
        throw new IllegalArgumentException(s"Executor memory $executorMemory must be at least " +
          s"$minSystemMemory. Please increase executor memory using the " +
          s"--executor-memory option or spark.executor.memory in Spark configuration.")
      }
    }
    val usableMemory = systemMemory - reservedMemory
    val memoryFraction = conf.getDouble("spark.memory.fraction", 0.6)
    (usableMemory * memoryFraction).toLong
  }
```


export HADOOP_CLIENT_OPTS="$HADOOP_CLIENT_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -Dlog4j.configurationFile=hive-log4j2.properties "

