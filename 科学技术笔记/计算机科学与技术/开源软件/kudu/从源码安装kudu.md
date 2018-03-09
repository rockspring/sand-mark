# 从源码安装kudu

sudo apt-get install autoconf automake curl g++ gcc gdb git \
  krb5-admin-server krb5-kdc krb5-user libkrb5-dev libsasl2-dev libsasl2-modules \
  libsasl2-modules-gssapi-mit libssl-dev libtool lsb-release make ntp openssl \
  patch pkg-config python rsync unzip vim-common

kdb5_util -r SHG4873 create -s

sudo apt-get install doxygen gem graphviz ruby-dev xsltproc zlib1g-dev

git clone https://github.com/apache/kudu

cd kudu

thirdparty/build-if-necessary.sh

mkdir -p build/release
cd build/release
../../thirdparty/installed/common/bin/cmake -DCMAKE_BUILD_TYPE=release ../..
make -j4

sudo make DESTDIR=/opt/kudu install

make docs

# java客户端

前提条件：JDK 7、Apache Maven 3.x、protoc 2.6

thirdparty/download-thirdparty.sh

thirdparty/build-thirdparty.sh protobuf

mvn install -DskipTests

文档
https://kudu.apache.org/apidocs/index.html


# 启动

## 启动kudu-master

nohup /home/shg4873/Servers/kudu/kudu-master/kudu-master --fs_data_dirs /home/shg4873/Servers/kudu/kudu-master/data --fs_wal_dir /home/shg4873/Servers/kudu/kudu-master/wal --log_dir /home/shg4873/Servers/kudu/kudu-master/logs --webserver_doc_root /home/shg4873/Projects/oss/kudu/www &

## 启动kudu-tserver

nohup /home/shg4873/Servers/kudu/kudu-tserver/kudu-tserver --fs_data_dirs /home/shg4873/Servers/kudu/kudu-tserver/data --fs_wal_dir /home/shg4873/Servers/kudu/kudu-tserver/wal --log_dir /home/shg4873/Servers/kudu/kudu-tserver/logs --webserver_doc_root /home/shg4873/Projects/oss/kudu/www &


--tserver_master_addrs --block_cache_capacity_mb --memory_limit_hard_bytes



# 验证

kudu-master的web页面，http://10.249.30.196:8051

kudu-tserver的web页面，http://10.249.30.196:8050