```
sudo apt-get install libgmp-dev libmpc-dev libisl-dev libmpfr-dev
wget http://mirror1.babylon.network/gcc/releases/gcc-5.2.0/gcc-5.2.0.tar.bz2
tar jxvf gcc-5.2.0.tar.bz2
mkdir objdir
cd objdir
../gcc-5.2.0/configure --prefix=/tmp/mygcc5.2 --disable-multilib --disable-werror
make -j
make install
```
