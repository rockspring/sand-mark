AB 测试nginx socket: Too many open files (24)  

sudo -s
ulimit -n 35768

./ab -c 10000 -n 100000 http://192.168.190.93:8080/



/etc/sysctl.conf:

fs.file-max = 2000000
net.ipv4.ip_local_port_range = 1025 65535
net.ipv4.tcp_tw_reuse = 1
net.ipv4.tcp_tw_recycle = 1
net.ipv4.tcp_max_tw_buckets = 5000
net.ipv4.tcp_fin_timeout = 30
net.ipv4.tcp_max_syn_backlog = 8192

/etc/security/limits.conf:

* hard nofile 1000000
* soft nofile 1000000