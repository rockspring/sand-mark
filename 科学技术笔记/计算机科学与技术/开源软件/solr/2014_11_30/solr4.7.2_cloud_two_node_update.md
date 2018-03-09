solr4.7.2

2实例连接单zookeeper

准备环境

zookeeper
tar -zxvf zookeeper-3.4.6.tar.gz
cd zookeeper-3.4.6/bin
cp ../conf/zoo_sample.cfg ../conf/zoo.cfg
rm -fr /tmp/zookeeper

启动zookeeper
bash zkServer.sh start-foreground

solr
rm -fr solr-4.7.2 && unzip solr-4.7.2.zip

cp -r solr-4.7.2/ solr-4.7.2-8983
cp -r solr-4.7.2/ solr-4.7.2-8984

## 参数调整

日志格式
log4j.rootLogger=TRACE, file, CONSOLE
log4j.appender.file.layout.ConversionPattern=%-5p - %d{yyyy-MM-dd HH:mm:ss.SSS}; [%t] %l; %m\n


cp -r solr-4.7.2-8983/ solr-4.7.2-8983-ready
cp -r solr-4.7.2-8984/ solr-4.7.2-8984-ready

rm -fr solr-4.7.2-8983
rm -fr solr-4.7.2-8984
cp -r solr-4.7.2-8983-ready/ solr-4.7.2-8983
cp -r solr-4.7.2-8984-ready/ solr-4.7.2-8984
## 启动leader节点

export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-8983

先非cloud模式启动一次，解压war包

```
cd $SOLR_ROOT/example
java -Djetty.port=8983 -jar start.jar
rm $SOLR_ROOT/example/logs/solr.log
```

准备zookeeper的数据

```
cd $SOLR_ROOT/example/scripts/cloud-scripts/

bash zkcli.sh -zkhost localhost:2181 -cmd upconfig -confdir ../../solr/collection1/conf/ -confname myconf

bash zkcli.sh -zkhost localhost:2181 -cmd linkconfig -collection collection1 -confname myconf

bash zkcli.sh -zkhost localhost:2181 -cmd bootstrap -solrhome ../../solr

cd $SOLR_ROOT/example

```

java -jar -Djetty.port=8983 -DzkHost=localhost:2181 start.jar

java -Djetty.host=127.0.0.1 -Djetty.port=8983 -DzkHost=localhost:2181 -jar start.jar

java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8765 -Djetty.host=127.0.0.1 -Djetty.port=8983 -DzkHost=localhost:2181 -jar start.jar
启动日志
5010行

第二阶段5158行

第一次add文档
cd exampledocs/

curl http://localhost:8983/solr/update --data-binary @hd.xml -H 'Content-type:application/xml'

日志记录到5218行

系统15秒钟后进行了自动commit

日志记录到5725行

再一次发送文档add请求

curl http://localhost:8983/solr/update --data-binary @ipod_other.xml -H 'Content-type:application/xml'
5726-5802行

系统15秒钟后进行了自动commit

5803-5833行


###########################################################################################
## 启动follower节点

export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2-8984

```

java -Djetty.port=8984 -DzkHost=localhost:2181 -jar start.jar

java -Djetty.host=127.0.0.1 -Djetty.port=8984 -DzkHost=localhost:2181 -jar start.jar
启动日志
5403行

接收到master转发的请求

5537行 处理master转发的请求

5538-5633行 autocommit日志
5634-5635行 master转发的请求所在线程剩余的执行日志



5635-5658 处理master转发的请求
5659-5685 autocommit日志
5686-5687 master转发的请求所在线程剩余的执行日志




清空数据

curl http://localhost:8983/solr/update --data-binary '<delete><query>*:*</query></delete>' -H 'Content-type:application/xml'
