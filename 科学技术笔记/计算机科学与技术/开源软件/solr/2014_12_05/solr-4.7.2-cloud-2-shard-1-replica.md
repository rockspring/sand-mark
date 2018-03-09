# 一个分片，两个副本



## 启动zookeeper3.4.6
cd /Users/zlq/Servers/zookeeper/
tar -zxvf zookeeper-3.4.6.tar.gz
cd zookeeper-3.4.6/bin
cp ../conf/zoo_sample.cfg ../conf/zoo.cfg
rm -fr /tmp/zookeeper

cd /Users/zlq/Servers/zookeeper/zookeeper-3.4.6/bin
bash zkServer.sh start-foreground

## 启动zookeeper 3.4.5
cd /Users/zlq/Servers/zookeeper/
tar -zxvf zookeeper-3.4.5.tar.gz
cd zookeeper-3.4.5/bin
cp ../conf/zoo_sample.cfg ../conf/zoo.cfg
rm -fr /tmp/zookeeper

cd /Users/zlq/Servers/zookeeper/zookeeper-3.4.5/bin
rm -fr /tmp/zookeeper
bash zkServer.sh start-foreground



## solr日志参数调整

日志格式
log4j.rootLogger=TRACE, file, CONSOLE
log4j.appender.file.layout.ConversionPattern=%-5p - %d{yyyy-MM-dd HH:mm:ss.SSS}; [%t] %l; %m\n

## 清理并重新初始化实例

```
cd /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica
rm -fr solr-4.7.2-8983/
rm -fr solr-4.7.2-8984/

cp -r solr-4.7.2-ready/ solr-4.7.2-8983
cp -r solr-4.7.2-ready/ solr-4.7.2-8984


```

## 上传配置到zookeeper

先非cloud模式启动一次，解压war包

```
export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2
cd $SOLR_ROOT/example
java -Djetty.port=8983 -jar start.jar
rm $SOLR_ROOT/example/logs/solr.log
```

```
export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2
cd $SOLR_ROOT/example/scripts/cloud-scripts/

bash zkcli.sh -zkhost localhost:2181 -cmd bootstrap -solrhome ../../solr

bash zkcli.sh -zkhost localhost:2181 -cmd list

bash zkcli.sh -zkhost localhost:2181 -cmd clear /configs

cd $SOLR_ROOT/example

bash zkcli.sh -zkhost localhost:2181 -cmd list > /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/zookeeper_solr_bootstrap.txt


使用自定义名字
cd $SOLR_ROOT/example/scripts/cloud-scripts/

bash zkcli.sh -zkhost localhost:2181 -cmd upconfig -confdir ../../solr/collection1/conf/ -confname myconf

bash zkcli.sh -zkhost localhost:2181 -cmd linkconfig -collection collection1 -confname myconf

cd $SOLR_ROOT/example

```

## 启动8983

export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983

cd $SOLR_ROOT/example

java -Djetty.port=8983 -DzkHost=localhost:2181 -DnumShards=2 -DreplicationFactor=1 -jar start.jar

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8983_start.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log 

bash zkcli.sh -zkhost localhost:2181 -cmd list > /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/zookeeper/zookeeper_solr_8983.txt

单实例模式
java -Djetty.port=8983 -jar start.jar

java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8765 -Djetty.port=8983 -jar start.jar

调试模式
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8765 -Djetty.port=8983 -DzkHost=localhost:2181 -DzkClientTimeout=3000000 -DnumShards=1 -jar start.jar


## 启动8984
export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984
cd $SOLR_ROOT/example

java -Djetty.port=8984 -DzkHost=localhost:2181 -DzkClientTimeout=3000000 -DnumShards=2 -DreplicationFactor=1  -jar start.jar


cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8984_start.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8983_start2.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log 

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 

bash zkcli.sh -zkhost localhost:2181 -cmd list > /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/zookeeper/zookeeper_solr_8983_8984.txt

调试模式
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8765 -Djetty.port=8984 -DzkHost=localhost:2181 -DzkClientTimeout=10000000 -DnumShards=2 -jar start.jar


## add doc

export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2
cd $SOLR_ROOT/example/exampledocs/


curl http://localhost:8983/solr/update --data-binary @hd.xml -H 'Content-type:application/xml'

curl http://localhost:8983/solr/update --data-binary @ipod_other.xml -H 'Content-type:application/xml'


cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8984_update_8983.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8983_update_8983.log.txt
 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log 

curl http://localhost:8986/solr/update --data-binary @ipod_other.xml -H 'Content-type:application/xml'


cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8984_update2.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8983_update2.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log

提交
curl http://localhost:8983/solr/update --data-binary '<commit/>' -H 'Content-type:application/xml'


软提交
curl http://localhost:8983/solr/update --data-binary '<commit softCommit = "true"/>' -H 'Content-type:application/xml'


cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8984_commit_8983.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8983_commit_8983.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log


通过delete by query方式删除

curl http://localhost:8983/solr/update --data-binary '<delete><query>id:SP2514N</query></delete>' -H 'Content-type:application/xml'

curl http://localhost:8983/solr/update --data-binary '<delete><query>id:6H500F0</query></delete>' -H 'Content-type:application/xml'

curl http://localhost:8983/solr/update --data-binary '<delete><query>id:F8V7067-APL-KIT</query></delete>' -H 'Content-type:application/xml'

curl http://localhost:8983/solr/update --data-binary '<delete><query>id:IW-02</query></delete>' -H 'Content-type:application/xml'

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8984_delete_query_8983.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8983_delete_query_8983.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log


通过delete by id删除

curl http://localhost:8983/solr/update --data-binary '<delete><id>6H500F0</id></delete>' -H 'Content-type:application/xml'

curl http://localhost:8983/solr/update --data-binary '<delete><id>SP2514N</id></delete>' -H 'Content-type:application/xml'


cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8984_delete_id_8983.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8983_delete_id_8983.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log

提交
curl http://localhost:8983/solr/update --data-binary '<commit/>' -H 'Content-type:application/xml'


cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8984_delete_commit_8983.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8983_delete_commit_8983.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log

访问8983查询

数据在8983（leader）和8984（follower）
curl -v 'http://localhost:8983/solr/select?q=*:*'

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8984_select_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8983_send_select_all.log.txt


echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log

访问8984查询

数据在8983（leader）和8984（follower）
curl -v 'http://localhost:8984/solr/select?q=*:*'


cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8984_select_8984_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-1-shard-2-replica/logs/8983_select_8984_all.log.txt


echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-1-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log

