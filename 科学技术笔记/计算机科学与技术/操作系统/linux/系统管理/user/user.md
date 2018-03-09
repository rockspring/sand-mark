## gpasswd

gpasswd - administer /etc/group and /etc/gshadow

-a, --add user
    Add the user to the named group.

# adduser, addgroup

add a user or group to the system

# visudo

edit the sudoers file

# deluser, delgroup

remove a user or group from the system


# ssh-keygen

authentication key generation, management and conversion

例子
```
ssh-keygen -t rsa
# -t 指定key的类型
```

通过密码登陆传输ssh的公钥到远程服务器

```
cat ~/.ssh/id_rsa.pub | ssh root@[your.ip.address.here] "cat >> ~/.ssh/authorized_keys"
```

限制系统只能用ssh key登陆

修改文件/etc/ssh/sshd_config
```
PasswordAuthentication no
```

给远程登陆用户展示一个条幅

/etc/issue里存放条幅的内容

修改文件/etc/ssh/sshd_config
```
Banner /etc/issue
```

# chmod

change file mode bits

在Linux系统，每个文件都一个文件模式，标记这个文件可写、可读、可执行


chmod提供了两种方式改变文件的模式

* 符号方式

写法为[ugoa...][[+-=][perms...]...]

例子：
使用如下命令创建一个空文件a.txt
touch a.txt

u 文件拥护者
g 文件群组
o 其他用户
a 所有用户

+ 给文件在某种所属关系中添加一种模式
- 给文件在某种所属关系中移除一种模式
= 给文件在某种所属关系中使用新的模式

使用如下命令更改文件a.txt的模式为文件拥有者增加可读、可写、可执行，但用户组合其他用户对此文件的模式不会改变
chmod u+rwx a.txt

使用如下命令更改文件a.txt的模式为为文件拥有者模式更改为可读
chmod u=r a.txt

使用如下命令更改文件a.txt的模式为为文件拥有者模式更改为可读，文件所属群组的用户模式更改为可读
chmod u=r,g=r a.txt


使用如下命令更改文件a.txt的模式为所有用户的模式更改为可读
chmod a=r a.txt
chmod =r a.txt

* 数字方式

read (4), write (2), and execute (1)
每个用户对一个文件的拥有的模式用0-7表示，这个数字是三种子模式数值的累加

```
0 ---
1 --x
2 -w-
3 -wx
4 r--
5 r-x
6 rw-
7 rwx
```

例子

所有用户拥有可读权限
chmod 444 a.txt

如果不是三个数字，则从右往左依次改变用户的模式

如改变用户组的用户和其他用户的文件模式为可读

chmod 44 a.txt
