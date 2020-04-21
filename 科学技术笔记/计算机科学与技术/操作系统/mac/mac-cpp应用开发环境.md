# mac cpp应用开发环境

2020年4月21日

## 安装clang

```
$ brew install llvm
Updating Homebrew...
==> Downloading https://homebrew.bintray.com/bottles/llvm-10.0.0_3.catalina.bottle.tar.gz
==> Downloading from https://akamai.bintray.com/ea/ea9b9f579df49499d9ab0084e10edecc5350298d6c5db399a1dabc8694dab7db?__gda__=exp=1587393782~hmac=747847081f62fc2afe9cdb6c34ab26b5fc3ef96f763108b78d35ad6d0ea3
################################################                          67.9%^C
zlqMacBookPro2015MidA1398:Downloads zlq$ brew install llvm
Updating Homebrew...
==> Downloading https://homebrew.bintray.com/bottles/llvm-10.0.0_3.catalina.bottle.tar.gz
==> Downloading from https://akamai.bintray.com/ea/ea9b9f579df49499d9ab0084e10edecc5350298d6c5db399a1dabc8694dab7db?__gda__=exp=1587399630~hmac=984b13b26feabb1635cfd11a857049c01c2e984620a1fdc1b1467dc9054b
######################################################################## 100.0%
==> Pouring llvm-10.0.0_3.catalina.bottle.tar.gz
==> Caveats
To use the bundled libc++ please add the following LDFLAGS:
  LDFLAGS="-L/usr/local/opt/llvm/lib -Wl,-rpath,/usr/local/opt/llvm/lib"

llvm is keg-only, which means it was not symlinked into /usr/local,
because macOS already provides this software and installing another version in
parallel can cause all kinds of trouble.

If you need to have llvm first in your PATH run:
  echo 'export PATH="/usr/local/opt/llvm/bin:$PATH"' >> ~/.bash_profile

For compilers to find llvm you may need to set:
  export LDFLAGS="-L/usr/local/opt/llvm/lib"
  export CPPFLAGS="-I/usr/local/opt/llvm/include"

==> Summary
🍺  /usr/local/Cellar/llvm/10.0.0_3: 7,055 files, 1GB
```

## cling 交互式C++解释器

[https://root.cern.ch/cling](https://root.cern.ch/cling)

## 安装CLion

http://www.jetbrains.com/clion/
