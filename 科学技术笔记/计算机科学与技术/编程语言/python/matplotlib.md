wget http://www.python.org/ftp/python/2.7.6/Python-2.7.6.tar.xz
tar -zxvf Python-2.7.6.tar.xz
cd Python-2.7.6.tar.xz

./configure --enable-framework
make
sudo make install

sudo easy_install python

安装matplotlib的依赖库
brew install freetype

sudo easy_install numpy

sudo easy_install matplotlib


MySQLdb
在PATH中添加MySQL的bin路径
sudo easy_install MySQL-Python