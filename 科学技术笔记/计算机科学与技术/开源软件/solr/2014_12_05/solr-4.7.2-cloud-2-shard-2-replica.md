目录结构

```
.
├── solr-4.7.2-8983-ready
├── solr-4.7.2-8984-ready
├── solr-4.7.2-8985-ready
└── solr-4.7.2-8986-ready
```

## 启动zookeeper

cd /Users/zlq/Servers/zookeeper

tar -zxvf zookeeper-3.4.6.tar.gz
cd zookeeper-3.4.6
cp ../conf/zoo_sample.cfg ../conf/zoo.cfg
rm -fr /tmp/zookeeper

启动zookeeper
bash bin/zkServer.sh start-foreground

## solr日志参数调整

日志格式
log4j.rootLogger=TRACE, file, CONSOLE
log4j.appender.file.layout.ConversionPattern=%-5p - %d{yyyy-MM-dd HH:mm:ss.SSS}; [%t] %l; %m\n

## 清理并重新初始化实例

```
cd /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica
rm -fr solr-4.7.2-8983/
rm -fr solr-4.7.2-8984/
rm -fr solr-4.7.2-8985/
rm -fr solr-4.7.2-8986/

cp -r solr-4.7.2-ready/ solr-4.7.2-8983
cp -r solr-4.7.2-ready/ solr-4.7.2-8984
cp -r solr-4.7.2-ready/ solr-4.7.2-8985
cp -r solr-4.7.2-ready/ solr-4.7.2-8986

cp -r solr-4.7.2-ready/ solr-4.7.2-8987
cp -r solr-4.7.2-ready/ solr-4.7.2-8988
```

## 上传配置到zookeeper



先非cloud模式启动一次，解压war包

```
export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2
cd $SOLR_ROOT/example
java -Djetty.port=8983 -jar start.jar
rm $SOLR_ROOT/example/logs/solr.log
```

```
export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2
cd $SOLR_ROOT/example/scripts/cloud-scripts/

bash zkcli.sh -zkhost localhost:2181 -cmd bootstrap -solrhome ../../solr

bash zkcli.sh -zkhost localhost:2181 -cmd list

bash zkcli.sh -zkhost localhost:2181 -cmd clear /configs

cd $SOLR_ROOT/example

bash zkcli.sh -zkhost localhost:2181 -cmd list > /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/zookeeper_solr_bootstrap.txt


使用自定义名字
cd $SOLR_ROOT/example/scripts/cloud-scripts/

bash zkcli.sh -zkhost localhost:2181 -cmd upconfig -confdir ../../solr/collection1/conf/ -confname myconf

bash zkcli.sh -zkhost localhost:2181 -cmd linkconfig -collection collection1 -confname myconf

cd $SOLR_ROOT/example

```

## 启动8983

export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983

cd $SOLR_ROOT/example

java -Djetty.port=8983 -DzkHost=localhost:2181 -DnumShards=2 -jar start.jar

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8983_start.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log 

bash zkcli.sh -zkhost localhost:2181 -cmd list > /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/zookeeper/zookeeper_solr_8983.txt

调试模式
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8765 -Djetty.port=8983 -DzkHost=localhost:2181 -DnumShards=2 -jar start.jar


## 启动8984
export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984
cd $SOLR_ROOT/example

java -Djetty.port=8984 -DzkHost=localhost:2181 -DnumShards=2 -jar start.jar


cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8984_start.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8983_start2.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log 

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 

bash zkcli.sh -zkhost localhost:2181 -cmd list > /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/zookeeper/zookeeper_solr_8983_8984.txt

调试模式
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8765 -Djetty.port=8984 -DzkHost=localhost:2181 -DnumShards=2 -jar start.jar

## 启动8985

export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985
cd $SOLR_ROOT/example

java -Djetty.port=8985 -DzkHost=localhost:2181 -DnumShards=2 -jar start.jar

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8985_start.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8984_start2.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8983_start3.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log 

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log 

bash zkcli.sh -zkhost localhost:2181 -cmd list > /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/zookeeper/zookeeper_solr_8983_8984_8984.txt

调试模式
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8765 -Djetty.port=8985 -DzkHost=localhost:2181 -DnumShards=2 -jar start.jar

## 启动8986

export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986
cd $SOLR_ROOT/example

java -Djetty.port=8986 -DzkHost=localhost:2181 -DnumShards=2 -jar start.jar

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8986_start.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8985_start2.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8984_start3.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8983_start4.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log 

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log 

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log 

bash zkcli.sh -zkhost localhost:2181 -cmd list > /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/zookeeper/zookeeper_solr_8983_8984_8985_8986.txt

调试模式
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8765 -Djetty.port=8986 -DzkHost=localhost:2181 -DnumShards=2 -jar start.jar

## 启动8987

export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8987
cd $SOLR_ROOT/example

java -Djetty.port=8987 -DzkHost=localhost:2181 -DnumShards=2 -jar start.jar

## 启动8988

export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8988
cd $SOLR_ROOT/example

java -Djetty.port=8988 -DzkHost=localhost:2181 -DnumShards=3 -jar start.jar



## add doc

export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2
cd $SOLR_ROOT/example/exampledocs/


curl http://192.168.196.17:8985/solr/update --data-binary @hd.xml -H 'Content-type:application/xml'


cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8986_update.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8985_send_update.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8984_update.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8983_update.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log 

curl http://localhost:8986/solr/update --data-binary @ipod_other.xml -H 'Content-type:application/xml'

# 484795 [qtp14214026-18 - /solr/update] ERROR org.apache.solr.core.SolrCore  – org.apache.solr.common.SolrException: Unexpected EOF in prolog

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8986_send_update2.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8985_update2.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8984_update2.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8983_update2.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log

提交
curl http://localhost:8983/solr/update --data-binary '<commit/>' -H 'Content-type:application/xml'

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8986_commit.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8985_commit.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8984_commit.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8983_send_commit.log.txt

echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log


查询所有分片的数据
http://192.168.196.17:8985/solr/select?q=*:*
http://192.168.196.17:8985/solr/select?q=*:*&shards=shard1,shard2

只在指定分片中查询
http://192.168.196.17:8985/solr/select?q=*:*&shards=shard1



通过delete by query方式删除

curl http://localhost:8985/solr/update?commit=true --data-binary '<delete><query>id:F8V7067-APL-KIT</query></delete>' -H 'Content-type:application/xml'


cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8986_delete_query.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8985_send_delete_query.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8984_delete_query.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8983_delete_query.log.txt


通过ID删除

curl http://localhost:8985/solr/update?commit=true --data-binary '<delete><id>6H500F0</id></delete>' -H 'Content-type:application/xml'

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8986_delete_id.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8985_send_delete_id.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8984_delete_id.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8983_delete_id.log.txt



访问8983查询

数据在8984（leader）和8986（follower）
curl -v 'http://192.168.196.17:8983/solr/select?q=*:*'

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8986_select_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8985_select_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8984_select_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8983_send_select_all.log.txt


echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log

访问8984查询

数据在8984（leader）和8986（follower）
curl -v 'http://192.168.196.17:8984/solr/select?q=*:*'

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8986_select_8984_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8985_select_8984_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8984_select_8984_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8983_select_8984_all.log.txt


echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log


访问8985查询

数据在8984（leader）和8986（follower）
curl -v 'http://192.168.196.17:8985/solr/select?q=*:*'

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8986_select_8985_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8985_select_8985_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8984_select_8985_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8983_select_8985_all.log.txt


echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log


访问8986查询

数据在8984（leader）和8986（follower）
curl -v 'http://192.168.196.17:8986/solr/select?q=*:*'

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8986_select_8986_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8985_select_8986_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8984_select_8984_all.log.txt

cp /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log /Users/zlq/360云盘/文档/学习笔记/solr/2014_12_05/solr-4.7.2-cloud-2-shard-2-replica/logs/8983_select_8986_all.log.txt


echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8986/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8985/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8984/example/logs/solr.log 
echo > /Users/zlq/Servers/solr/solr-4.7.2-cloud-2-shard-2-replica/solr-4.7.2-8983/example/logs/solr.log


get接口

未提交的数据实时get

http://localhost:8983/solr/collection1/get/?id=maxtor!6H500F0

http://localhost:8983/solr/collection1/get/?id=maxtor!6H500F0&id=samsung!SP2514N


软提交

curl http://localhost:8983/solr/update --data-binary '<commit softCommit = "true"/>' -H 'Content-type:application/xml'


http://localhost:8984/solr/select?q=*:*&shard.keys=samsung!

http://localhost:8984/solr/select?q=*:*&_route_=samsung!

http://localhost:8984/solr/select?q=*:*&debug=true&fq=id:maxtor!6H500F0

指定分片

通过分片的名字指定

http://localhost:8984/solr/select?q=*:*&shards=shard1

http://localhost:8984/solr/select?q=*:*&shards=shard2

http://localhost:8984/solr/select?q=*:*&shards=shard1,shard2

http://127.0.0.1:8984/solr/select?q=*:*&shards=shard1,shard2

通过分片的地址指定

http://localhost:8984/solr/select?q=*:*&shards=http://localhost:8983/solr

http://localhost:8984/solr/select?q=*:*&shards=http://localhost:8984/solr


http://localhost:8984/solr/select?q=*:*&shards=http://localhost:8983/solr,http://localhost:8984/solr

http://127.0.0.1:8984/solr/select?q=*:*&shards=http://127.0.0.1:8983/solr,http://127.0.0.1:8984/solr

指定多个分片地址做负载均衡

http://127.0.0.1:8984/solr/select?q=*:*&shards=http://127.0.0.1:8983/solr|http://127.0.0.1:8984/solr