1，单机上集群安装
目录结构
mkdir zookeeper-cluster

wget http://apache.dataguru.cn/zookeeper/zookeeper-3.4.6/zookeeper-3.4.6.tar.gz

 

tar -zxvf zookeeper-3.4.6.tar.gz

mv zookeeper-3.4.6 zookeeper-3.4.6-server-001

cd zookeeper-3.4.6-server-001

cp conf/zoo_sample.cfg conf/zoo.cfg

mkdir -p tmp/zookeeper

echo "1" > tmp/zookeeper/myid

sed -i "s#/tmp/zookeeper#`pwd`/tmp/zookeeper#g" conf/zoo.cfg

echo "server.1=localhost:2888:3888" >> conf/zoo.cfg

echo "server.2=localhost:2889:3889" >> conf/zoo.cfg

echo "server.3=localhost:2890:3890" >> conf/zoo.cfg

cd ..

 

tar -zxvf zookeeper-3.4.6.tar.gz

mv zookeeper-3.4.6 zookeeper-3.4.6-server-002

cd zookeeper-3.4.6-server-002

cp conf/zoo_sample.cfg conf/zoo.cfg

mkdir -p tmp/zookeeper

echo "2" > tmp/zookeeper/myid

sed -i "s/2181/2182/g" conf/zoo.cfg

sed -i "s#/tmp/zookeeper#`pwd`/tmp/zookeeper#g" conf/zoo.cfg

echo "server.1=localhost:2888:3888" >> conf/zoo.cfg

echo "server.2=localhost:2889:3889" >> conf/zoo.cfg

echo "server.3=localhost:2890:3890" >> conf/zoo.cfg

cd ..

 

tar -zxvf zookeeper-3.4.6.tar.gz

mv zookeeper-3.4.6 zookeeper-3.4.6-server-003

cd zookeeper-3.4.6-server-003

cp conf/zoo_sample.cfg conf/zoo.cfg

mkdir -p tmp/zookeeper

echo "3" > tmp/zookeeper/myid

sed -i "s/2181/2183/g" conf/zoo.cfg

sed -i "s#/tmp/zookeeper#`pwd`/tmp/zookeeper#g" conf/zoo.cfg

 

echo "server.1=localhost:2888:3888" >> conf/zoo.cfg

 

echo "server.2=localhost:2889:3889" >> conf/zoo.cfg

 

echo "server.3=localhost:2890:3890" >> conf/zoo.cfg

cd ..

ls

 

cd zookeeper-3.4.6-server-001

java -cp zookeeper-3.4.6.jar:lib/slf4j-api-1.6.1.jar:lib/slf4j-log4j12-1.6.1.jar:lib/log4j-1.2.15.jar:conf org.apache.zookeeper.server.quorum.QuorumPeerMain conf/zoo.cfg

 