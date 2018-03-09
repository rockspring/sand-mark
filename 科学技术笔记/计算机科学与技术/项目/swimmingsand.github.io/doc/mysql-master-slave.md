#MySQL master-slave安装部署实战

>操作系统：Ubuntu 12.04 x86_64
>MySQL：5.5.37

##1，安装必备工具

```shell
sudo apt-get update
sudo apt-get -y install g++
sudo apt-get -y install cmake
sudo apt-get -y install libncurses5-dev
sudo apt-get -y install bison
sudo apt-get -y install vim
```

##2，创建MySQL用户和用户组

```shell
sudo groupadd -r mysql # -r创建系统组
sudo useradd -r -g mysql mysql #-r创建系统组
```

##3，下载并解压MySQL源码包

```shell
cd ~ #目录随意
wget http://cdn.mysql.com/Downloads/MySQL-5.5/mysql-5.5.37.tar.gz
tar -zxvf mysql-5.5.37.tar.gz
```
#4，master实例安装部署相关

#4.1，安装master实例

```shell
cd mysql-5.5.37

cmake . -DCMAKE_INSTALL_PREFIX=/usr/local/mysql_3306 -DMYSQL_DATADIR=/usr/local/mysql_3306/data -DDEFAULT_CHARSET=utf8 -DDEFAULT_COLLATION=utf8_general_ci -DEXTRA_CHARSETS=all -DENABLED_LOCAL_INFILE=1
make
sudo make install
```

##4.2，master实例安装后处理

```shell
cd /usr/local/mysql_3306
sudo chown -R mysql .
sudo chgrp -R mysql .
sudo scripts/mysql_install_db --user=mysql
sudo chown -R root .
sudo chown -R mysql data
```

##4.3，master实例配置文件

```shell
cd /usr/local/mysql_3306/support-files
sudo cp my-medium.cnf my.cnf
sudo vim my.cnf
```

**如下为my.cnf文件的内容**
```
# Example MySQL config file for medium systems.
#
# This is for a system with little memory (32M - 64M) where MySQL plays
# an important part, or systems up to 128M where MySQL is used together with
# other programs (such as a web server)
#
# MySQL programs look for option files in a set of
# locations which depend on the deployment platform.
# You can copy this option file to one of those
# locations. For information about these locations, see:
# http://dev.mysql.com/doc/mysql/en/option-files.html
#
# In this file, you can use all long options that a program supports.
# If you want to know which options a program supports, run the program
# with the "--help" option.

# The following options will be passed to all MySQL clients
[client]
#password   = your_password
port        = 3306
socket      = /tmp/mysql_3306.sock

# Here follows entries for some specific programs

# The MySQL server
[mysqld]
port        = 3306
socket      = /tmp/mysql_3306.sock
skip-external-locking
key_buffer_size = 16M
max_allowed_packet = 1M
table_open_cache = 64
sort_buffer_size = 512K
net_buffer_length = 8K
read_buffer_size = 256K
read_rnd_buffer_size = 512K
myisam_sort_buffer_size = 8M

# Don't listen on a TCP/IP port at all. This can be a security enhancement,
# if all processes that need to connect to mysqld run on the same host.
# All interaction with mysqld must be made via Unix sockets or named pipes.
# Note that using this option without enabling named pipes on Windows
# (via the "enable-named-pipe" option) will render mysqld useless!
#
#skip-networking

# Replication Master Server (default)
# binary logging is required for replication
log-bin=mysql-bin

# binary logging format - mixed recommended
binlog_format=mixed

# required unique id between 1 and 2^32 - 1
# defaults to 1 if master-host is not set
# but will not function as a master if omitted
server-id   = 1

# Replication Slave (comment out master section to use this)
#
# To configure this host as a replication slave, you can choose between
# two methods :
#
# 1) Use the CHANGE MASTER TO command (fully described in our manual) -
#    the syntax is:
#
#    CHANGE MASTER TO MASTER_HOST=<host>, MASTER_PORT=<port>,
#    MASTER_USER=<user>, MASTER_PASSWORD=<password> ;
#
#    where you replace <host>, <user>, <password> by quoted strings and
#    <port> by the master's port number (3306 by default).
#
#    Example:
#
#    CHANGE MASTER TO MASTER_HOST='125.564.12.1', MASTER_PORT=3306,
#    MASTER_USER='joe', MASTER_PASSWORD='secret';
#
# OR
#
# 2) Set the variables below. However, in case you choose this method, then
#    start replication for the first time (even unsuccessfully, for example
#    if you mistyped the password in master-password and the slave fails to
#    connect), the slave will create a master.info file, and any later
#    change in this file to the variables' values below will be ignored and
#    overridden by the content of the master.info file, unless you shutdown
#    the slave server, delete master.info and restart the slaver server.
#    For that reason, you may want to leave the lines below untouched
#    (commented) and instead use CHANGE MASTER TO (see above)
#
# required unique id between 2 and 2^32 - 1
# (and different from the master)
# defaults to 2 if master-host is set
# but will not function as a slave if omitted
#server-id       = 2
#
# The replication master for this slave - required
#master-host     =   <hostname>
#
# The username the slave will use for authentication when connecting
# to the master - required
#master-user     =   <username>
#
# The password the slave will authenticate with when connecting to
# the master - required
#master-password =   <password>
#
# The port the master is listening on.
# optional - defaults to 3306
#master-port     =  <port>
#
# binary logging - not required for slaves, but recommended
#log-bin=mysql-bin

# Uncomment the following if you are using InnoDB tables
#innodb_data_home_dir = /usr/local/mysql/data
#innodb_data_file_path = ibdata1:10M:autoextend
#innodb_log_group_home_dir = /usr/local/mysql/data
# You can set .._buffer_pool_size up to 50 - 80 %
# of RAM but beware of setting memory usage too high
#innodb_buffer_pool_size = 16M
#innodb_additional_mem_pool_size = 2M
# Set .._log_file_size to 25 % of buffer pool size
#innodb_log_file_size = 5M
#innodb_log_buffer_size = 8M
#innodb_flush_log_at_trx_commit = 1
#innodb_lock_wait_timeout = 50

[mysqldump]
quick
max_allowed_packet = 16M

[mysql]
no-auto-rehash
# Remove the next comment character if you are not familiar with SQL
#safe-updates

[myisamchk]
key_buffer_size = 20M
sort_buffer_size = 20M
read_buffer = 2M
write_buffer = 2M

[mysqlhotcopy]
interactive-timeout
```

##4.4，master实例安装后设置root密码

```shell
cd /usr/local/mysql_3306/bin

sudo ./mysqld_safe --defaults-extra-file=../support-files/my.cnf & #使用指定配置文件启动MySQL服务器
./mysqladmin --socket=/tmp/mysql_3306.sock -u root password 'admin' #设置root的密码
./mysql -u root -padmin --socket=/tmp/mysql_3306.sock #尝试连接
./mysqladmin -u root -padmin --socket=/tmp/mysql_3306.sock shutdown #关闭MySQL服务器
```

##4.5，master实例添加replication账户
```
cd /usr/local/mysql_3306/bin
sudo ./mysqld_safe --defaults-extra-file=../support-files/my.cnf & #使用指定配置文件启动MySQL服务器
./mysql -u root -padmin --socket=/tmp/mysql_3306.sock #尝试连接

CREATE USER 'repl'@'%' IDENTIFIED BY 'slavepass';
GRANT REPLICATION SLAVE,REPLICATION CLIENT ON *.* TO 'repl'@'%' identified by 'slavepass' with grant option;
GRANT REPLICATION SLAVE,REPLICATION CLIENT ON *.* TO 'repl'@'localhost' identified by 'slavepass' with grant option;
```

#5，slave实例安装部署相关

##5.1，安装slave实例
```shell
cd mysql-5.5.37

cmake . -DCMAKE_INSTALL_PREFIX=/usr/local/mysql_3307 -DMYSQL_DATADIR=/usr/local/mysql_3307/data -DDEFAULT_CHARSET=utf8 -DDEFAULT_COLLATION=utf8_general_ci -DEXTRA_CHARSETS=all -DENABLED_LOCAL_INFILE=1
make
sudo make install
```

##5.2，slave实例安装后处理

```shell
cd /usr/local/mysql_3307
sudo chown -R mysql .
sudo chgrp -R mysql .
sudo scripts/mysql_install_db --user=mysql
sudo chown -R root .
sudo chown -R mysql data
```

##5.3，slave实例配置文件

```
cd /usr/local/mysql_3307/support-files
sudo cp my-medium.cnf my.cnf
sudo vim my.cnf
```

**如下为my.cnf文件的内容**
```
# Example MySQL config file for medium systems.
#
# This is for a system with little memory (32M - 64M) where MySQL plays
# an important part, or systems up to 128M where MySQL is used together with
# other programs (such as a web server)
#
# MySQL programs look for option files in a set of
# locations which depend on the deployment platform.
# You can copy this option file to one of those
# locations. For information about these locations, see:
# http://dev.mysql.com/doc/mysql/en/option-files.html
#
# In this file, you can use all long options that a program supports.
# If you want to know which options a program supports, run the program
# with the "--help" option.

# The following options will be passed to all MySQL clients
[client]
#password   = your_password
port        = 3307
socket      = /tmp/mysql_3307.sock

# Here follows entries for some specific programs

# The MySQL server
[mysqld]
port        = 3307
socket      = /tmp/mysql_3307.sock
skip-external-locking
key_buffer_size = 16M
max_allowed_packet = 1M
table_open_cache = 64
sort_buffer_size = 512K
net_buffer_length = 8K
read_buffer_size = 256K
read_rnd_buffer_size = 512K
myisam_sort_buffer_size = 8M

# Don't listen on a TCP/IP port at all. This can be a security enhancement,
# if all processes that need to connect to mysqld run on the same host.
# All interaction with mysqld must be made via Unix sockets or named pipes.
# Note that using this option without enabling named pipes on Windows
# (via the "enable-named-pipe" option) will render mysqld useless!
#
#skip-networking

# Replication Master Server (default)
# binary logging is required for replication
#log-bin=mysql-bin

# binary logging format - mixed recommended
#binlog_format=mixed

# required unique id between 1 and 2^32 - 1
# defaults to 1 if master-host is not set
# but will not function as a master if omitted
#server-id  = 1

# Replication Slave (comment out master section to use this)
#
# To configure this host as a replication slave, you can choose between
# two methods :
#
# 1) Use the CHANGE MASTER TO command (fully described in our manual) -
#    the syntax is:
#
#    CHANGE MASTER TO MASTER_HOST=<host>, MASTER_PORT=<port>,
#    MASTER_USER=<user>, MASTER_PASSWORD=<password> ;
#
#    where you replace <host>, <user>, <password> by quoted strings and
#    <port> by the master's port number (3306 by default).
#
#    Example:
#
#    CHANGE MASTER TO MASTER_HOST='125.564.12.1', MASTER_PORT=3306,
#    MASTER_USER='joe', MASTER_PASSWORD='secret';
#
# OR
#
# 2) Set the variables below. However, in case you choose this method, then
#    start replication for the first time (even unsuccessfully, for example
#    if you mistyped the password in master-password and the slave fails to
#    connect), the slave will create a master.info file, and any later
#    change in this file to the variables' values below will be ignored and
#    overridden by the content of the master.info file, unless you shutdown
#    the slave server, delete master.info and restart the slaver server.
#    For that reason, you may want to leave the lines below untouched
#    (commented) and instead use CHANGE MASTER TO (see above)
#
# required unique id between 2 and 2^32 - 1
# (and different from the master)
# defaults to 2 if master-host is set
# but will not function as a slave if omitted
server-id       = 2
#
# The replication master for this slave - required
#master-host     =   <hostname>
#
# The username the slave will use for authentication when connecting
# to the master - required
#master-user     =   <username>
#
# The password the slave will authenticate with when connecting to
# the master - required
#master-password =   <password>
#
# The port the master is listening on.
# optional - defaults to 3306
#master-port     =  <port>
#
# binary logging - not required for slaves, but recommended
log-bin=mysql-bin

# Uncomment the following if you are using InnoDB tables
#innodb_data_home_dir = /usr/local/mysql/data
#innodb_data_file_path = ibdata1:10M:autoextend
#innodb_log_group_home_dir = /usr/local/mysql/data
# You can set .._buffer_pool_size up to 50 - 80 %
# of RAM but beware of setting memory usage too high
#innodb_buffer_pool_size = 16M
#innodb_additional_mem_pool_size = 2M
# Set .._log_file_size to 25 % of buffer pool size
#innodb_log_file_size = 5M
#innodb_log_buffer_size = 8M
#innodb_flush_log_at_trx_commit = 1
#innodb_lock_wait_timeout = 50

[mysqldump]
quick
max_allowed_packet = 16M

[mysql]
no-auto-rehash
# Remove the next comment character if you are not familiar with SQL
#safe-updates

[myisamchk]
key_buffer_size = 20M
sort_buffer_size = 20M
read_buffer = 2M
write_buffer = 2M

[mysqlhotcopy]
interactive-timeout
```

##5.4，slave实例安装后设置root密码

```shell
cd /usr/local/mysql_3307/bin
sudo ./mysqld_safe --defaults-extra-file=../support-files/my.cnf & #使用指定配置文件启动MySQL服务器
./mysqladmin --socket=/tmp/mysql_3307.sock -u root password 'admin' #设置root的密码
./mysql -u root -padmin --socket=/tmp/mysql_3307.sock #尝试连接
./mysqladmin -u root -padmin --socket=/tmp/mysql_3307.sock shutdown #关闭MySQL服务器
```

##5.5，启动slave服务器并开始设置与master同步

```shell
cd /usr/local/mysql_3307/bin

sudo ./mysqld_safe --defaults-extra-file=../support-files/my.cnf --relay-log=precise64-relay-bin &
./mysql -u root -padmin --socket=/tmp/mysql_3307.sock #尝试连接

#mysql>
stop slave; #先停止slave同步线程
change master to master_host='localhost', master_port=3306, master_user='repl', master_password='slavepass',master_log_file='mysql-bin.xxxxxx', master_log_pos=xxx; #mysql-bin.xxxxxx为master的log文件名，xxx为同步的起点，可在master实例查看（show master status;)
start slave; #开启slave同步线程

show processlist;
#如何分别有来自system user用户的Waiting for master to send event和Slave has read all relay log; waiting for the slave I/O thread to update it连接，则正常
```

#6，测试master-slave的同步功能是否工作正常

##6.1，在master里的test数据库创建一张表

```sql
use test;
create table test (
    id int
);
insert into test values(1);
```

##6.2，在slave里的test数据库查询在master的中创建的表及数添加的据

```sql
user test;
select * from test;
```

#7，如果顺利地走到这里，master-slave简易部署完毕
