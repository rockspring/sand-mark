http://man7.org/linux/man-pages/

Linux man pages online

# 如何开启一个新的项目

使用项目模板cmake-simple，适用于简单单文件项目

cd org.man7

cp -r cmake-simple man2/mmap/example001

rm -fr man2/mmap/example001/build/*

xcode打开目录man2/mmap/example001/example001/xcode

# 如何构建项目

cd build

cmake ..

make

# 如何让xcode构建

cd xcode

cmake -G Xcode ..
