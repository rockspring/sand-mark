#php安装指南

>操作系统：Ubuntu 13.04 64位版

>CPU: Intel(R) Core(TM) i5-3210M CPU @ 2.50GHz 双核4线程

>php语言版本：5.5.4

>php5.5.4发布时间：2013-09-19

##1 安装前准备

**添加用户组**

	groupadd nobody

**安装依赖库**

	apt-get install libxml2-dev

##2 配置、编译、安装php
	./configure --enable-fpm --enable-mysqlnd
	make
	sudo make install

###make消耗CPU时长
	
	real	7m0.338s
	user	5m56.468s
	sys		0m21.100s

###安装目录结构

	Installing shared extensions:     /usr/local/lib/php/extensions/no-debug-non-zts-20121212/
	Installing PHP CLI binary:        /usr/local/bin/
	Installing PHP CLI man page:      /usr/local/php/man/man1/
	Installing PHP FPM binary:        /usr/local/sbin/
	Installing PHP FPM config:        /usr/local/etc/
	Installing PHP FPM man page:      /usr/local/php/man/man8/
	Installing PHP FPM status page:   /usr/local/php/fpm/
	Installing PHP CGI binary:        /usr/local/bin/
	Installing PHP CGI man page:      /usr/local/php/man/man1/
	Installing build environment:     /usr/local/lib/php/build/
	Installing header files:          /usr/local/include/php/
	Installing helper programs:       /usr/local/bin/
	  program: phpize
	  program: php-config
	Installing man pages:             /usr/local/php/man/man1/
	  page: phpize.1
	  page: php-config.1
	Installing PEAR environment:      /usr/local/lib/php/
	[PEAR] Archive_Tar    - installed: 1.3.11
	[PEAR] Console_Getopt - installed: 1.3.1
	warning: pear/PEAR requires package "pear/Structures_Graph" (recommended version 1.0.4)
	warning: pear/PEAR requires package "pear/XML_Util" (recommended version 1.2.1)
	[PEAR] PEAR           - installed: 1.9.4
	Wrote PEAR system config file at: /usr/local/etc/pear.conf
	You may want to add: /usr/local/lib/php to your php.ini include_path
	[PEAR] Structures_Graph- installed: 1.0.4
	[PEAR] XML_Util       - installed: 1.2.1
	/home/zlq/softwares/php-5.5.4/build/shtool install -c ext/phar/phar.phar /usr/local/bin
	ln -s -f /usr/local/bin/phar.phar /usr/local/bin/phar
	Installing PDO headers:           /usr/local/include/php/ext/pdo/



	
##3 安装php的配置文件和php-fpm的配置文件

	sudo cp php.ini-development /usr/local/lib/php.ini

	sudo cp /usr/local/etc/php-fpm.conf.default /usr/local/etc/php-fpm.conf
	
##4 启动php-fpm
	sudo php-fpm


**查看是否已经启动**

	ps -ef|grep php-fpm
**启动成功将出现下面信息**

	root      3686     1  0 13:36 ?        00:00:00 php-fpm: master process (/usr/local/etc/php-fpm.conf)
	nobody    3687  3686  0 13:36 ?        00:00:00 php-fpm: pool www
	nobody    3688  3686  0 13:36 ?        00:00:00 php-fpm: pool www

##5 重启php-fpm
	sudo kill -SIGUSR2 3686

##6 关掉php-fpm
	先用ps -ef|grep php-fpm找到进程ID号
	root      3794     1  0 13:43 ?        00:00:00 php-fpm: master process (/usr/local/etc/php-fpm.conf)
	nobody    3795  3794  0 13:43 ?        00:00:00 php-fpm: pool www
	nobody    3796  3794  0 13:43 ?        00:00:00 php-fpm: pool www

	然后执行下面命令
	sudo kill -SIGQUIT 3794

##7 php扩展安装
###7.1 curl安装
	sudo apt-get install libcurl4-openssl-dev
	cd ext/curl
	phpize
	./configure
	make 
	sudo make install
	cd ../..

启用curl扩展

	sudo vim /usr/local/lib/php.ini
	在908行Dynamic Extensions节区添加下面一行
	extension=curl.so
	
###7.2 pdo_mysql安装
	cd ext/pdo_mysql
	phpize
	./configure
	make 
	sudo make install
	cd ../..

启用pdo_mysql扩展

	sudo vim /usr/local/lib/php.ini
	在908行Dynamic Extensions节区添加下面一行
	extension=pdo_mysql.so
	
###7.3 mbstring安装
	cd ext/mbstring
	phpize
	./configure
	make 
	sudo make install
	cd ../..

启用mbstring扩展

	sudo vim /usr/local/lib/php.ini
	在908行Dynamic Extensions节区添加下面一行
	extension=mbstring.so

###7.4 gd安装

	sudo apt-get install libpng12-dev
	sudo apt-get install libjpeg-dev

	cd ext/gd
	phpize
	./configure
	make 
	sudo make install
	cd ../..

启用gd扩展

	sudo vim /usr/local/lib/php.ini
	在908行Dynamic Extensions节区添加下面一行
	extension=gd.so

###7.5 zlib安装

	sudo apt-get install zlib1g-dev

	cd ext/zlib
	cp config0.m4 config.m4
	phpize
	./configure
	make 
	sudo make install
	cd ../..

启用zlib扩展

	sudo vim /usr/local/lib/php.ini
	在908行Dynamic Extensions节区添加下面一行
	extension=zlib.so
