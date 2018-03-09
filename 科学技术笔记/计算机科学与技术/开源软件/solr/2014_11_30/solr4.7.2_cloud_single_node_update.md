solr4.7.2

单实例连接单zookeeper

准备环境

zookeeper
rm -fr /tmp/zookeeper

启动zookeeper
bash zkServer.sh start-foreground

solr
rm -fr solr-4.7.2 && unzip solr-4.7.2.zip
export SOLR_ROOT=/Users/zlq/Servers/solr/solr-4.7.2

日志格式
log4j.appender.file.layout.ConversionPattern=%-5p - %d{yyyy-MM-dd HH:mm:ss.SSS}; [%t] %l; %m\n


先非cloud模式启动一次，解压war包

```
cd $SOLR_ROOT/example
java -jar start.jar
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

观察update的日志

java -jar -DzkHost=localhost:2181 start.jar
启动日志
5008行

第一次add文档
cd exampledocs/

curl http://localhost:8983/solr/update --data-binary @hd.xml -H 'Content-type:application/xml'

日志记录到5218行

系统15秒钟后进行了自动commit

日志记录到5316行

再一次发送文档add请求

curl http://localhost:8983/solr/update --data-binary @ipod_other.xml -H 'Content-type:application/xml'
日志记录到5341行

系统15秒钟后进行了自动commit

日志记录到5372行