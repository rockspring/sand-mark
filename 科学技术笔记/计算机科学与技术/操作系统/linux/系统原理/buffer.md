输入

```
ubuntu@ubuntu-xenial:~$ free -h -w
```

输出

```
              total        used        free      shared     buffers       cache   available
Mem:           3.9G         42M        3.7G        5.9M         10M        122M        3.6G
Swap:            0B          0B          0B
```

dd if=/dev/zero of=test bs=1M count=1000

ubuntu@ubuntu-xenial:~$ free -h -w
              total        used        free      shared     buffers       cache   available
Mem:           3.9G         41M        2.7G        5.9M         10M        1.1G        3.6G
Swap:            0B          0B          0B


echo 3 | sudo tee /proc/sys/vm/drop_caches


ubuntu@ubuntu-xenial:~$ free -h -w
              total        used        free      shared     buffers       cache   available
Mem:           3.9G         41M        3.8G        5.9M        1.4M         55M        3.7G
Swap:            0B          0B          0B


echo 1 | sudo tee /proc/sys/vm/drop_caches

echo 2 | sudo tee /proc/sys/vm/drop_caches



dd if=/dev/zero of=testfile.txt bs=1M count=10

ubuntu@ubuntu-xenial:~$ /vagrant/projects/pcstat testfile.txt
|--------------+----------------+------------+-----------+---------|
| Name         | Size           | Pages      | Cached    | Percent |
|--------------+----------------+------------+-----------+---------|
| testfile.txt | 10485760       | 2560       | 2560      | 100.000 |
|--------------+----------------+------------+-----------+---------|
ubuntu@ubuntu-xenial:~$ free -m
              total        used        free      shared  buff/cache   available
Mem:           3951          48        3826           5          76        3737
Swap:             0           0           0
