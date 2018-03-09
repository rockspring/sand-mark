# MySQL安装

## Ubuntu

```
CPU：Core i5-3210M 2.5GHz
内存：12GB
硬盘：500G 7200转
操作系统:Ubuntu 13.04 i386
MySQL：mysql-5.6.11
编译过程耗时：23分钟
```

### 1.安装必备工具和程序库

```
sudo -s
apt-get install g++
apt-get install cmake
apt-get install libncurses5-dev
apt-get install bison
```
### 2.建立用户和用户组

```
groupadd mysql
useradd -r -g mysql mysql
```

### 3.开始编译安装

```
tar zxvf mysql-5.6.11.tar.gz
cd mysql-5.6.11
cmake .
make
make install
```

### 4.安装后处理

```
cd /usr/local/mysql
chown -R mysql .
chgrp -R mysql .
scripts/mysql_install_db --user=mysql
chown -R root .
chown -R mysql data
```

### 5.启动MySQL数据库

```
./mysqld_safe --user=mysql
```

### 6.为root用户设置密码

```
./mysqladmin -u root password 'admin'
```

### 7.连接MySQL数据库

```
./mysql -u root -padmin
```

### 8.关闭MySQL数据库服务器

```
./mysqladmin -u root -p shutdown
```