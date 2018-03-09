《C++标注库（第2版）》

# 如何开启一个新的项目

使用项目模板cmake-simple，适用于简单单文件项目

cp -r cmake-simple chapter5/section5.1/subsection5.1.1/example001

rm -fr chapter5/section5.1/subsection5.1.1/example001/build/*

xcode打开目录chapter5/section5.1/subsection5.1.1/example001/xcode

# 如何构建项目

cd build

cmake ..

make

# 如何让xcode构建

cd xcode

cmake -G Xcode ..
