编辑Markdown
solr集群部署
1,create zookeeper cluster

export ZK_ROOT=/Users/zlq/Servers/zookeeper-3.4.5
cd $ZK_ROOT/bin
./zkServer.sh start
2,create solr cluster solr1

export SOLR_ROOT=/Users/zlq/Servers/solr-4.6.0-8983

cd $SOLR_ROOT/example/cloud-scripts
#./zkcli.sh -zkhost localhost:2181 -cmd clear /solr1
./zkcli.sh -zkhost localhost:2181 -cmd makepath /solr1

./zkcli.sh -zkhost localhost:2181/solr1 -cmd upconfig -confdir ../solr/collection1/conf/ -confname solr1

./zkcli.sh -zkhost localhost:2181/solr1 -cmd linkconfig -collection collection1 -confname solr1

cd $SOLR_ROOT/example
java -Djetty.port=8983 -DzkHost=localhost:2181/solr1 -jar start.jar

export SOLR_ROOT=/Users/zlq/Servers/solr-4.6.0-8984
cd $SOLR_ROOT/example
java -Djetty.port=8984 -DzkHost=localhost:2181/solr1 -jar start.jar
3,create solr cluster solr2

export SOLR_ROOT=/Users/zlq/Servers/solr-4.6.0-9983

cd $SOLR_ROOT/example/cloud-scripts
#./zkcli.sh -zkhost localhost:2181 -cmd clear /solr2
./zkcli.sh -zkhost localhost:2181 -cmd makepath /solr2

./zkcli.sh -zkhost localhost:2181/solr2 -cmd upconfig -confdir ../solr/collection1/conf/ -confname solr2

./zkcli.sh -zkhost localhost:2181/solr2 -cmd linkconfig -collection collection1 -confname solr2

cd $SOLR_ROOT/example
java -Djetty.port=9983 -DzkHost=localhost:2181/solr2 -jar start.jar

export SOLR_ROOT=/Users/zlq/Servers/solr-4.6.0-8984
cd $SOLR_ROOT/example
java -Djetty.port=9984 -DzkHost=localhost:2181/solr2 -jar start.jar