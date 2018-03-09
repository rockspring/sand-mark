sudo apt-get install -y openssh-server

install.sh
```
cat > install.sh <<EOF
sudo apt install -y tree
sudo apt install -y vim
sudo apt install -y git
sudo apt install -y openjdk-8-jdk
sudo apt install -y maven

sudo apt install -y gcc
EOF
```

install_debug.sh
```
sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys C8CAB6595FDFF622

codename=$(lsb_release -c | awk  '{print $2}')
sudo tee /etc/apt/sources.list.d/ddebs.list << EOF
deb http://ddebs.ubuntu.com/ ${codename}      main restricted universe multiverse
deb http://ddebs.ubuntu.com/ ${codename}-security main restricted universe multiverse
deb http://ddebs.ubuntu.com/ ${codename}-updates  main restricted universe multiverse
deb http://ddebs.ubuntu.com/ ${codename}-proposed main restricted universe multiverse
EOF

sudo apt-get update
sudo apt-get -y install linux-image-$(uname -r)-dbgsym

sudo apt-get -y install systemtap

sudo apt autoremove
```

```
mkdir hadoop
cd hadoop
wget http://mirrors.tuna.tsinghua.edu.cn/apache/hadoop/common/hadoop-2.8.0/hadoop-2.8.0.tar.gz
tar -zxvf hadoop-2.8.0.tar.gz
cd ..

mkdir spark
cd spark
wget https://d3kbcqa49mib13.cloudfront.net/spark-2.1.1-bin-hadoop2.7.tgz
tar -zxvf spark-2.1.1-bin-hadoop2.7.tgz
cd ..

wget http://mirrors.cnnic.cn/apache//commons/daemon/binaries/commons-daemon-1.0.15-bin.tar.gz

wget http://mirrors.cnnic.cn/apache//commons/daemon/source/commons-daemon-1.0.15-src.tar.gz

mkdir hive
cd hive
wget http://mirrors.hust.edu.cn/apache/hive/hive-2.1.1/apache-hive-2.1.1-bin.tar.gz
cd ..

mkdir pig
cd pig
wget http://apache.fayea.com/pig/pig-0.16.0/pig-0.16.0.tar.gz
cd ..
```

# https://cwiki.apache.org/confluence/display/AMBARI/Installation+Guide+for+Ambari+2.4.2

```
mkdir ambari
cd ambari

wget http://www.apache.org/dist/ambari/ambari-2.4.2/apache-ambari-2.4.2-src.tar.gz (use the suggested mirror from above)
tar xfvz apache-ambari-2.4.2-src.tar.gz
cd apache-ambari-2.4.2-src
mvn versions:set -DnewVersion=2.4.2.0.0
 
pushd ambari-metrics
mvn versions:set -DnewVersion=2.4.2.0.0
popd

mvn -B clean install package jdeb:jdeb -DnewVersion=2.4.2.0.0 -DskipTests -Dpython.ver="python >= 2.6"
```

# 第二步

```
apt-get install ambari-server*.deb   #This should also pull in postgres packages as well.
```

# 第三步

```
ambari-server setup
ambari-server start
```

# 第四步

```
apt-get install ambari-agent*.rpm

ambari-agent start

cd ..
```