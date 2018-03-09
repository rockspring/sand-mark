java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8765 -jar start.jar


### 启动zookeeper

### 启动solr使其war包解开
cd solr-4.7.2/example
java -jar start.jar

### 上传配置到zookeeper

cd solr-4.7.2/example/

cd scripts/cloud-scripts/

bash zkcli.sh -zkhost localhost:2181 -cmd upconfig -confdir ../../solr/collection1/conf/ -confname myconf

bash zkcli.sh -zkhost localhost:2181 -cmd linkconfig -collection collection1 -confname myconf

bash zkcli.sh -zkhost localhost:2181 -cmd bootstrap -solrhome ../../solr

cd ../..


### 启动solr，并连接zookeeper使其运行在集群模式

java -jar -DzkHost=localhost:2181 start.jar

java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=8765 -jar -DzkHost=localhost:2181 start.jar