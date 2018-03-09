#!/bin/sh

#install tools
sudo apt-get update
sudo apt-get install -y make
sudo apt-get install -y g++

sudo apt-get install -y libpcre3
sudo apt-get install -y libpcre3-dev

sudo apt-get install -y zlib1g
sudo apt-get install -y zlib1g-dev

wget http://nginx.org/download/nginx-1.4.2.tar.gz
tar -zxvf nginx-1.4.2.tar.gz
cd nginx-1.4.2
./configure
make
sudo make install
cd ..

#sudo /usr/local/nginx/sbin/nginx
#wget -qO- 127.0.0.1

wget https://raw.github.com/bambooZhou/MyPages/master/web%E6%9C%8D%E5%8A%A1%E5%99%A8/nginx/nginx.conf

sudo cp nginx.conf /usr/local/nginx/conf/

#mkdir -p /home/zlq/projects/config/nginx

#mkdir -p /home/vagrant/projects/config/nginx
#sudo sed -i "s/zlq/vagrant/g" /usr/local/nginx/conf/nginx.conf