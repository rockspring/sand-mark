# 登录机器的快捷shell: 

```
#!/usr/bin/expect

set timeout -1
set host x.x.x.x
set krb_user xxx
set krb_password xxxxxx

spawn kinit $krb_user
expect "password*"
send "$krb_password\r"
spawn ssh $krb_user@$host
interact
```


先登录一台机器，再登陆另一台机器，在一个脚本里如何操作？

```
#!/bin/sh

eval `ssh-agent -s`
ssh-add

if [ "$1" = "" ]; then
	ssh -A zlq@1.2.3.4
else
	ssh -A zlq@1.2.3.4 -t "ssh work@$1"
fi
```
