#go语言环境搭建

----
	操作系统：Ubuntu 13.10 64位版
	go语言版本：1.2
	go发布时间：go1.1 2013/05/13 go1.2 2013/12/01

----
##1.下载并解压安装
下载地址：https://code.google.com/p/go

	wget https://go.googlecode.com/files/go1.2.linux-amd64.tar.gz
	sudo tar -zxvf  go1.2.linux-amd64.tar.gz -C /usr/local
	
##2.设置环境变量
```
vim $HOME/.bashrc
export GOROOT=/usr/local/go
export PATH=$PATH:$GOROOT/bin
```

##3.测试go环境是否正常
在命令行窗口输入下面命令

	go version

正常情况将输出下面内容

	go version go1.2 linux/amd64

##4.Hello, GO!

	vim hello.go

```
package main

import "fmt"

func main() {
    fmt.Printf("Hello,GO!\n")
}
```

	go run hello.go
