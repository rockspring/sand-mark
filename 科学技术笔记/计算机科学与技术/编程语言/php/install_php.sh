#!/bin/sh

# install tools
sudo apt-get update
sudo apt-get install -y autoconf

# add usergroup
sudo groupadd nobody

# install dependencies
sudo apt-get install -y libxml2-dev

wget http://cn2.php.net/distributions/php-5.5.4.tar.gz

tar -zxvf php-5.5.4.tar.gz
cd php-5.5.4
./configure --enable-fpm --enable-mysqlnd
make
sudo make install

# install curl extension
sudo apt-get install -y libcurl4-openssl-dev
cd ext/curl
phpize
./configure
make 
sudo make install
cd ../..

# install pdo_mysql extension
cd ext/pdo_mysql
phpize
./configure
make 
sudo make install
cd ../..

# install mbstring extension
cd ext/mbstring
phpize
./configure
make 
sudo make install
cd ../..

# install gd extension
sudo apt-get install -y libpng12-dev
sudo apt-get install -y libjpeg-dev

cd ext/gd
phpize
./configure
make 
sudo make install
cd ../..

# install zlib extension
sudo apt-get install -y zlib1g-dev

cd ext/zlib
cp config0.m4 config.m4
phpize
./configure
make 
sudo make install
cd ../..

# copy configure file
wget https://raw.github.com/bambooZhou/MyPages/master/%E7%BC%96%E7%A8%8B%E8%AF%AD%E8%A8%80/php/php.ini
sudo cp php.ini /usr/local/lib/

sudo cp /usr/local/etc/php-fpm.conf.default /usr/local/etc/php-fpm.conf
