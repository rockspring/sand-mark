有时特殊需要会要用到高版本的Python， 但是系统自带的版本又是很多其他工具依赖的， 不能随意更新。 所以就会考虑安装另一个版本的python环境， 然后需要用到这个版本时就在脚本头部指明  #/usr/bin/env python2.7 这样。

## 下载要安装的 Python版本源码包(我用的是 2.7 版本)
wget ‘http://www.python.org/ftp/python/2.7/Python-2.7.tar.bz2′
##标准的安装流程, 安装python2.7 到 /usr/local/python2.7 目录:
tar -xvf Python-2.7.tar.bz2
cd Python2.7
./configure –prefix=/usr/local/python2.7 &amp;&amp; make &amp;&amp; make install

## 建立一个 python2.7的链接， 方便调用
ln -sv /usr/local/python2.7/bin/python2.7 /usr/bin/python2.7
一般的需求到这一步即可使用 python2.7了。但是如果需要安装其他的包到python2.7, 在使用 easy_install、 pip 等包管理工具安装包时， 还是会装到系统自带版本python的目录。 在python2.7版本下也无法import安装的包。 以下是解决方法：
## 接下来安装一些需要的包环境(setuptools, pip)
wget –no-check-certificate ‘https://pypi.python.org/packages/source/s/setuptools/setuptools-0.7.2.tar.gz’
tar -xvf setuptools-0.7.2.tar.gz
cd setuptools-0.7.2
python2.7 setup.py install –prefix=/usr/local/python2.7

wget –no-check-certificate ‘https://pypi.python.org/packages/source/p/pip/pip-1.2.tar.gz’
tar -xvf pip-1.2.tar.gz
cd pip-1.2
python2.7 setup.py  install –prefix=/usr/local/python2.7
## 创建一个 pip-2.7 的链接， 方便调用
ln -sv /usr/local/python2.7/bin/pip-2.7 /usr/bin/pip-2.7
之后使用 pip-2.7 命令安装的包就会自动装到 /usr/local/python2.7 对应目录下了。 这样安装的包不仅能import， 更重要的是不会出现不同版本的兼容性问题(有些包在不同版本python下是不同的)
真水无香  17:04:23
不过这过程你会遇到问题
真水无香  17:04:48
注意要装python2.6.8不然你的zmq装不上