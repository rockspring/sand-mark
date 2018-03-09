#redis安装指南

----
	操作系统：Ubuntu 13.04 32位版
	Redis版本：2.6.13
	Redis2.6.13发布时间：2013-04-30

----
##1.下载并解压安装
下载地址：http://redis.io/download

下载文件： redis-2.6.13.tar.gz

输入命令如下：

	tar zxvf  redis-2.6.13.tar.gz
	cd redis-2.6.13
	make
	cd utils
	./install_server.sh
	
执行./install_server.sh后输出如下：

	Welcome to the redis service installer
	This script will help you easily set up a running redis server

	Please select the redis port for this instance: [6379] 
	Selecting default: 6379
	Please select the redis config file name [/etc/redis/6379.conf] 
	Selected default - /etc/redis/6379.conf
	Please select the redis log file name [/var/log/redis_6379.log] 
	Selected default - /var/log/redis_6379.log
	Please select the data directory for this instance [/var/lib/redis/6379] 
	Selected default - /var/lib/redis/6379
	Please select the redis executable path [/usr/local/bin/redis-server] 
	s#^port [0-9]{4}$#port 6379#;s#^logfile .+$#logfile /var/log/redis_6379.log#;s#^dir .+$#dir /var/lib/redis/6379#;s#^pidfile .+$#pidfile /var/run/redis_6379.pid#;s#^daemonize no$#daemonize yes#;
	Copied /tmp/6379.conf => /etc/init.d/redis_6379
	Installing service...
	update-rc.d: warning: /etc/init.d/redis_6379 missing LSB information
	update-rc.d: see <http://wiki.debian.org/LSBInitScripts>
	 Adding system startup for /etc/init.d/redis_6379 ...
	   /etc/rc0.d/K20redis_6379 -> ../init.d/redis_6379
	   /etc/rc1.d/K20redis_6379 -> ../init.d/redis_6379
	   /etc/rc6.d/K20redis_6379 -> ../init.d/redis_6379
	   /etc/rc2.d/S20redis_6379 -> ../init.d/redis_6379
	   /etc/rc3.d/S20redis_6379 -> ../init.d/redis_6379
	   /etc/rc4.d/S20redis_6379 -> ../init.d/redis_6379
	   /etc/rc5.d/S20redis_6379 -> ../init.d/redis_6379
	Success!
	Starting Redis server...
	Installation successful!

##2.启用Redis客户端连接Redis服务器
	# redis-cli
	redis 127.0.0.1:6379> ping
    PONG
	redis 127.0.0.1:6379> set foo bar
	OK
	redis 127.0.0.1:6379> get foo
	"bar"

	 