DNS加2个：192.168.1.100
吴雄杰  22:07:06
192.168.1.98
吴雄杰  22:07:25
右边搜索域加一个：i.ajkdns.com
张浩  09:35:54
ip-down内容：
吴雄杰  21:38:43
#!/bin/bash
# file: /etc/ppp/ip-down

export PATH="/bin:/sbin:/usr/sbin:/usr/bin"

route delete 192.168.1.0/24 $4
route delete 192.168.190.0/24 $4
route delete 192.168.191.0/24 $4
route delete 192.168.192.0/24 $4
route delete 192.168.193.0/24 $4
route delete 192.168.194.0/24 $4
route delete 192.168.195.0/24 $4
route delete 192.168.196.0/24 $4
route delete 192.168.197.0/24 $4
route delete 192.168.198.0/24 $4
route delete 192.168.199.0/24 $4
route delete 10.20.0.0/16 $4
route delete 10.10.0.0/16 $4
吴雄杰  21:38:51
ip-up内容：
吴雄杰  21:39:06
#!/bin/bash
# file: /etc/ppp/ip-up
export PATH="/bin:/sbin:/usr/sbin:/usr/bin"

dscacheutil -flushcache

route add 192.168.1.0/24 $4
route add 192.168.189.0/24 $4
route add 192.168.190.0/24 $4
route add 192.168.191.0/24 $4
route add 192.168.192.0/24 $4
route add 192.168.193.0/24 $4
route add 192.168.194.0/24 $4
route add 192.168.195.0/24 $4
route add 192.168.196.0/24 $4
route add 192.168.197.0/24 $4
route add 192.168.198.0/24 $4
route add 192.168.199.0/24 $4
route add 10.20.0.0/16 $4
route add 10.10.0.0/16 $4





vpn连接之后会出现如下网卡信息


ppp0: flags=8051<UP,POINTOPOINT,RUNNING,MULTICAST> mtu 1444
	inet 192.168.189.105 --> 180.166.126.91 netmask 0xffffff00


针对192.168.189.102要添加路由规则