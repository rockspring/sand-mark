cgroups

cgroups-mount

cgroups-umount

```
Memory and Swap Accounting

If you want to enable memory and swap accounting, you must add the following command-line parameters to your kernel:

cgroup_enable=memory swapaccount=1

On systems using GRUB (which is the default for Ubuntu), you can add those parameters by editing /etc/default/grub and extending GRUB_CMDLINE_LINUX. Look for the following line:

GRUB_CMDLINE_LINUX=""

And replace it by the following one:

GRUB_CMDLINE_LINUX="cgroup_enable=memory swapaccount=1"

Then run sudo update-grub, and reboot.

These parameters will help you get rid of the following warnings:

WARNING: Your kernel does not support cgroup swap limit.
WARNING: Your kernel does not support swap limit capabilities. Limitation discarded.
```

## ufw - program for managing a netfilter firewall

```
$ sudo nano /etc/default/ufw

# Change:
# DEFAULT_FORWARD_POLICY="DROP"
# to
DEFAULT_FORWARD_POLICY="ACCEPT"
```

UFW's default set of rules denies all incoming traffic. If you want to be able to reach your containers from another host then you should allow incoming connections on the Docker port (default 2375):

$ sudo ufw allow 2375/tcp



## dnsmasq


DNS servers

nameserver

 /etc/resolv.conf



$ sudo nano /etc/default/docker
---
# Add:
DOCKER_OPTS="--dns 8.8.8.8"
# 8.8.8.8 could be replaced with a local DNS server, such as 192.168.1.1
# multiple DNS servers can be specified: --dns 8.8.8.8 --dns 192.168.1.1