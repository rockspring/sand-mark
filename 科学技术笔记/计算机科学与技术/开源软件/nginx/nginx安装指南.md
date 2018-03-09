#nginx安装指南

>操作系统:Ubuntu 13.04 64位版

>CPU: Intel(R) Core(TM) i5-3210M CPU @ 2.50GHz 双核4线程

>nginx：nginx-1.4.2.tar.gz

>nginx-1.4.2发布时间：2013-07-17

##1.安装nginx依赖的程序库

	sudo apt-get install -y libpcre3
	sudo apt-get install -y libpcre3-dev

	sudo apt-get install -y zlib1g
	sudo apt-get install -y zlib1g-dev

##2.安装nginx
	wget http://nginx.org/download/nginx-1.4.2.tar.gz
	tar -zxvf nginx-1.4.2.tar.gz
	cd nginx-1.4.2
	./configure
	make
	sudo make install

----	
configure之后的输出结果

    Configuration summary
  		+ using system PCRE library
  		+ OpenSSL library is not used
  		+ using builtin md5 code
  		+ sha1 library is not found
  		+ using system zlib library

  		nginx path prefix: "/usr/local/nginx"
  		nginx binary file: "/usr/local/nginx/sbin/nginx"
  		nginx configuration prefix: "/usr/local/nginx/conf"
  		nginx configuration file: "/usr/local/nginx/conf/nginx.conf"
 		nginx pid file: "/usr/local/nginx/logs/nginx.pid"
  		nginx error log file: "/usr/local/nginx/logs/error.log"
  		nginx http access log file: "/usr/local/nginx/logs/access.log"
  		nginx http client request body temporary files: "client_body_temp"
  		nginx http proxy temporary files: "proxy_temp"
  		nginx http fastcgi temporary files: "fastcgi_temp"
  		nginx http uwsgi temporary files: "uwsgi_temp"
  		nginx http scgi temporary files: "scgi_temp"

##3.启动nginx服务器

	sudo /usr/local/nginx/sbin/nginx

##4.停止nginx服务器

	sudo /usr/local/nginx/sbin/nginx -s stop

##5.配置fpm作为web服务器的后端应用服务器

	修改nginx.conf配置文件
	将下面的行修改为再下面的一行
	fastcgi-param SCRIPT_FILENAME /scripts$fastcgi_script_name
	fastcgi-param SCRIPT_FILENAME $document_root$fastcgi_script_name

##6.修改配置

以vagrant环境为例
	mkdir -p /home/vagrant/projects/config/nginx
	sudo sed -i "s/zlq/vagrant/g" /usr/local/nginx/conf/nginx.conf
