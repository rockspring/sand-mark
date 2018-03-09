# tcpdump

```
sudo tcpdump -i eth0 -s 0 -l -w - dst host 10.10.8.24 and dst port 898 | tee cap | strings
```