《Boost程序完全开发指南》

# 如何开启一个新的项目

使用项目模板cmake-simple，适用于简单单文件项目

cp -r cmake-simple chapter1/section1.1/subsection1.1.1/example001

rm -fr chapter1/section1.1/subsection1.1.1/example001/build/*

xcode打开目录chapter1/section1.1/subsection1.1.1/example001/xcode

# 如何构建项目

cd build

cmake ..

make

# 如何让xcode构建

cd xcode

cmake -G Xcode ..

# 如何安装boost

## 标准安装

编译release版本的库文件

把头文件安装到/usr/local/include/[boost]

把动态库文件安装到/usr/local/lib

```
bootstrap.sh # 编译前的配置工作

./b2 install # 真正的编译并安装boost
```

## 完全安装

编译调试版和发行版的动态、静态链接库

安装动态和静态链接库到/usr/local/lib

把头文件安装到/usr/local/include/[boost]

```
bootstrap.sh # 编译前的配置工作

./b2 --buildtype=complete install # 真正的编译并安装boost
```

## 定制安装

查看所有必须编译才能使用的库

./b2 --show-libraries

例如仅安装date_time库

./b2 --with-date_time --buildtype=complete install

## 查看帮助

./b2 --help

# 卸载

/usr/local/lib/libboost* and /usr/local/include/boost
