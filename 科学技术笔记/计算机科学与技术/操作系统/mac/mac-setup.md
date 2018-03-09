# mac系统安装配置

2017年05月17日

## 修改电脑名称

【系统偏好设置】->【共享】->【电脑名称】

## 开启远程登陆

```
sudo launchctl load -w /System/Library/LaunchDaemons/ssh.plist
```

## 安装Xcode

从app store下载安装

### xcode-select --install

安装了git

```
# set the path for the active developer directory
sudo xcode-select -s /Library/Developer/CommandLineTools/
```

## mac软件安装管理工具

https://brew.sh

```
/usr/local/Cellar
/usr/local/Homebrew
/usr/local/Frameworks
/usr/local/bin
/usr/local/etc
/usr/local/include
/usr/local/lib
/usr/local/opt
/usr/local/sbin
/usr/local/share
/usr/local/share/zsh
/usr/local/share/zsh/site-functions
/usr/local/var

/Users/zlq/Library/Caches/Homebrew
/Library/Caches/Homebrew
```

用法举例

```
brew search tree
brew info tree
brew home tree
brew options tree

brew install tree
```

```
brew install tree
brew install wget
brew install gcc
brew install cmake
brew install scons
brew install tig
brew install gnu-sed --with-default-names
brew install gnutls --with-default-names
brew install gawk --with-default-names


brew install coreutils
brew install binutils
brew install diffutils
brew install ed --with-default-names
brew install findutils --with-default-names
brew install gawk
brew install gnu-indent --with-default-names
brew install gnu-sed --with-default-names
brew install gnu-tar --with-default-names
brew install gnu-which --with-default-names
brew install gnutls
brew install grep --with-default-names
brew install gzip
brew install screen
brew install watch
brew install wdiff --with-gettext
brew install wget

brew install bash
brew install emacs
brew install gdb  # gdb requires further actions to make it work. See `brew info gdb`.
brew install gpatch
brew install less
brew install m4
brew install make
brew install nano

brew install file-formula
brew install git
brew install openssh
brew install perl
brew install python
brew install rsync
brew install svn
brew install unzip
#brew install vim --override-system-vi
#brew install macvim --with-override-system-vim
brew install zsh
```

[install-and-use-gnu-command-line-tools-in-mac-os-x](https://www.topbug.net/blog/2013/04/14/install-and-use-gnu-command-line-tools-in-mac-os-x/)

```
brew install valgrind
brew install boost
brew install doxygen
```

```
brew install httpie
```

## 安装常用软件

[Pages](https://www.apple.com/pages/)

[Numbers](https://www.apple.com/numbers/)

[Keynote](https://www.apple.com/keynote/)

[微软office](https://products.office.com/zh-cn/home)

[QQ](https://im.qq.com/download/index.shtml)

[chrome](http://www.google.cn/chrome/browser/desktop/index.html)

[Firefox](http://www.firefox.com.cn/)

[360安全云盘](https://yunpan.360.cn/)

[sublime Text](http://www.sublimetext.com)

[OmniGraffle](https://www.omnigroup.com/omnigraffle/)

[Evernote](https://www.yinxiang.com/)

[iTerm2](http://www.iterm2.com/)

[sourcetree](https://www.sourcetreeapp.com/)

[virtualbox](https://www.virtualbox.org)

[vagrantup](https://www.vagrantup.com)

[osquery](https://osquery.io/)

## 安装字体

https://github.com/belluzj/fantasque-sans

## 系统设置

### locale

```
export LANG="en_US.UTF-8"
export LC_ALL="en_US.UTF-8"
```

```
scutil --get HostName
scutil --get ComputerName
scutil --get LocalHostName

sudo scutil --set HostName zlqMacBookPro2015MidA1398
sudo scutil --set ComputerName "周乐钦的MacBookPro2015MidA1398"
sudo scutil --set LocalHostName zlqMacBookPro2015MidA1398
```

### /etc/hosts文件

```
##
# Host Database
#
# localhost is used to configure the loopback interface
# when the system is booting.  Do not change this entry.
##
127.0.0.1	localhost
255.255.255.255	broadcasthost
::1             localhost 
```

```
127.0.0.1 zlqMacBookPro2015MidA1398
```

### network

```
networksetup -setsearchdomains Wi-Fi .local
networksetup -setdnsservers Wi-Fi 127.0.0.1
```

### 文件夹显示隐藏文件

```
defaults write com.apple.finder AppleShowAllFiles YES
killall Finder
defaults write com.apple.finder AppleShowAllFiles NO
```

## mac的一些工具简介

```
otool - object file displaying tool
install_name_tool - change dynamic shared library install names
dtruss - process syscall details. Uses DTrace.

echo "thread backtrace all" | lldb -p <pid>

sysctl -a | grep cache # 查看CPU缓存
```

### .bash_profile

通过alias添加shell命令别名

```
alias alert='notify-send --urgency=low -i "$([ $? = 0 ] && echo terminal || echo error)" "$(history|tail -n1|sed -e '\''s/^\s*[0-9]\+\s*//;s/[;&|]\s*alert$//'\'')"'
alias egrep='egrep --color=auto'
alias fgrep='fgrep --color=auto'
alias grep='grep --color=auto'
alias l='ls -CF'
alias la='ls -A'
alias ll='ls -alF'
alias ls='ls -G'
```
