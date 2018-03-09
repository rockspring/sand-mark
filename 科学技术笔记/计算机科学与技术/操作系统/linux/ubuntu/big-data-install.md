mkdir hadoop
cd hadoop
wegt http://mirrors.tuna.tsinghua.edu.cn/apache/hadoop/common/hadoop-2.8.0/hadoop-2.8.0.tar.gz
tar -zxvf hadoop-2.8.0.tar.gz
cd ..

mkdir spark
cd spark
wget https://d3kbcqa49mib13.cloudfront.net/spark-2.1.1-bin-hadoop2.7.tgz
tar -zxvf spark-2.1.1-bin-hadoop2.7.tgz
cd ..


mkdir hive
cd hive
wget https://mirrors.tuna.tsinghua.edu.cn/apache/hive/hive-2.1.1/apache-hive-2.1.1-bin.tar.gz
tar -zxvf apache-hive-2.1.1-bin.tar.gz
cd ..
