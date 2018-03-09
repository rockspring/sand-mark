# MySQL快速入门使用

## 连接MySQL服务器

```
mysql -h localhost -u root -padmin db_name
```

## 配置文件

```
/etc/my.cnf /etc/mysql/my.cnf /usr/local/mysql/etc/my.cnf ~/.my.cnf 
```

## 设置默认参数值

### 通过环境变量

#### Windows

```
MYSQL_HOST=localhost
USER=root
MYSQL_PWD=admin
```

#### Linux

没有USER这个环境变量，默认的用户名为登录到Linux系统的用户名

```
export MYSQL_HOST=localhost
export MYSQL_PWD=admin
```

### 通过配置文件

```
vim ~/.my.cnf
```

```
[client]
host=localhost
user=root
password=admin
```

## 设置默认参数值后连接MySQL服务器

### 指定数据库名称

```
mysql db_name
```

### 不指定数据库名称

```
mysql
```
