#phpMyAdmin安装指南
	操作系统:Ubuntu 13.04 i386
	phpMyAdmin：phpMyAdmin4.0.1
	phpMyAdmin发布时间：2013-05-14
>**前提条件**：已安装PHP和nginx服务器
	
##1.安装php的mysqli扩展
    apt-get install autoconf
    
    cd php-5.4.15/ext/mysqli
    phpize
    ./configure --prefix=/usr/local/mysqli --with-php-config=/usr/local/bin/php-config --with-mysqli=/usr/local/mysql/bin/mysql_config
    make
    make install
    
##2.修改PHP配置文件php.ini
    cd /usr/local/lib
    vim php.ini
    在930行Dynamci Extensions节区添加下面一行
    extension=mysqli.so
    
##3.将phpMyAdmin文件夹放到nginx配置的服务器的根目录
    打开浏览器测试
    http://localhost/phpMyAdmin
    如出现登陆界面说明安装成功
