sudo apt-get install libc++-dev

apt-cache depends libc++-dev

clang++ -Wall -std=c++11 -stdlib=libc++ main.cc