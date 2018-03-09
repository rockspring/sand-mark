《程序员代码面试指南 IT名企算法与数据结构题目最优解》

# 如何开启一个新的项目

使用项目模板cmake-simple，适用于简单单文件项目

cp -r cmake-simple chapter1/problem1/solution1

rm -fr chapter1/problem1/solution1/build/*

rm -fr chapter1/problem1/solution1/xcode/*

xcode打开目录chapter1/problem1/solution1/xcode

# 如何构建项目

cd build

cmake ..

make

# 如何让xcode构建

cd xcode

cmake -G Xcode ..

设置Xcode工具

ALL_BUILD -> Apple LLVM 8.1 - Custom Compliler Flags

ALL_BUILD -> Apple LLVM 8.1 - Language - C++