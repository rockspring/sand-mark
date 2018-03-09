# MySQL安装

```
MySQL Community Server
MySQL Cluster
MySQL Router
MySQL Utilities
MySQL Shell
MySQL Workbench
MySQL Connectors
```

```
MySQL Utilities provides a collection of command-line utilities that are used for maintaining and administering MySQL servers, including:

Admin Utilities (Clone, Copy, Compare, Diff, Export, Import)
Replication Utilities (Setup, Configuration)
General Utilities (Disk Usage, Redundant Indexes, Search Meta Data)
And many more
```

## macOS

使用mysql-5.7.21-macos10.13-x86_64.dmg安装

安装完成后会弹出一个窗口，内容如下

```
2018-01-19T01:40:20.763670Z 1 [Note] A temporary password is generated for root@localhost: K+t_p#r*M1hj

If you lose this password, please consult the section How to Reset the Root Password in the MySQL reference manual.
```

如果想在另一个目录初始化数据库

```
# mysqld --initialize --user=mysql --basedir=/usr/local/mysql --datadir=/tmp/mysql/data/  --explicit_defaults_for_timestamp
```

--lc-messages-dir=/usr/local/mysql/share/

The directory where error messages are located. The server uses the value together with the value of --lc-messages to produce the location for the error message file. 

--lc-messages='en_US'

The locale to use for error messages. The default is en_US. The server converts the argument to a language name and combines it with the value of --lc-messages-dir to produce the location for the error message file. 

### 安装目录

```
lrwxr-xr-x  1 root  wheel  30  1 18 20:30 /usr/local/mysql@ -> mysql-5.7.21-macos10.13-x86_64
```

在~/.bash_profile文件中添加环境变量

```
export PATH=/usr/local/mysql/bin:$PATH
export DYLD_LIBRARY_PATH=/usr/local/mysql/lib
```

### 可执行文件

bin目录下的可执行文件

```
innochecksum
lz4_decompress
my_print_defaults
myisam_ftdump
myisamchk
myisamlog
myisampack
mysql
mysql_client_test_embedded
mysql_config
mysql_config_editor
mysql_embedded
mysql_install_db
mysql_plugin
mysql_secure_installation
mysql_ssl_rsa_setup
mysql_tzinfo_to_sql
mysql_upgrade
mysqladmin
mysqlbinlog
mysqlcheck
mysqld
mysqld-debug
mysqld_multi
mysqld_safe
mysqldump
mysqldumpslow
mysqlimport
mysqlpump
mysqlshow
mysqlslap
mysqltest_embedded
mysqlxtest
perror
replace
resolve_stack_dump
resolveip
zlib_decompress
```

### 服务器启动运行的进程

```
/usr/local/mysql/bin/mysqld --user=_mysql --basedir=/usr/local/mysql --datadir=/usr/local/mysql/data --plugin-dir=/usr/local/mysql/lib/plugin --log-error=/usr/local/mysql/data/mysqld.local.err --pid-file=/usr/local/mysql/data/mysqld.local.pid --keyring-file-data=/usr/local/mysql/keyring/keyring --early-plugin-load=keyring_file=keyring_file.so
```

### 创建配置文件

/usr/local/mysql/etc/my.cnf

```
[mysqld]
skip-grant-tables
```

重启MySQL

```
sudo launchctl unload -w /Library/LaunchDaemons/com.oracle.oss.mysql.mysqld.plist
sudo launchctl load -w /Library/LaunchDaemons/com.oracle.oss.mysql.mysqld.plist
```
