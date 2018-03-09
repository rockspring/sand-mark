
```
bash bin/hbase-daemons.sh --config conf start zookeeper
bash bin/hbase-daemons.sh --config conf stop zookeeper
```

```
zlq              73622   0.0  1.1  6033296  91140   ??  S     2:57PM   0:01.79 /Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home/bin/java -Dproc_zookeeper -XX:OnOutOfMemoryError=kill -9 %p -XX:+UseConcMarkSweepGC -Dhbase.log.dir=/Users/zlq/Servers/hbase/hbase-1.2.4/bin/../logs -Dhbase.log.file=hbase-zlq-zookeeper-Apples-MacBook-Pro-2.log -Dhbase.home.dir=/Users/zlq/Servers/hbase/hbase-1.2.4/bin/.. -Dhbase.id.str=zlq -Dhbase.root.logger=INFO,RFA -Dhbase.security.logger=INFO,RFAS org.apache.hadoop.hbase.zookeeper.HQuorumPeer start
zlq              73608   0.0  0.0  2454888   1280   ??  S     2:57PM   0:00.01 bash /Users/zlq/Servers/hbase/hbase-1.2.4/bin/hbase-daemon.sh --config /Users/zlq/Servers/hbase/hbase-1.2.4/bin/../conf foreground_start zookeeper
```


hbase-daemons.sh --> zookeepers.sh --> hbase-daemon.sh


```
bash bin/hbase-daemon.sh --config conf start master
bash bin/hbase-daemon.sh --config conf stop master
```

```
zlq              78271   0.0  2.7  6305556 228548 s010  S     3:11PM   0:12.09 /Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home/bin/java -Dproc_master -XX:OnOutOfMemoryError=kill -9 %p -XX:+UseConcMarkSweepGC -XX:PermSize=128m -XX:MaxPermSize=128m -Dhbase.log.dir=/Users/zlq/Servers/hbase/hbase-1.2.4/bin/../logs -Dhbase.log.file=hbase-zlq-master-Apples-MacBook-Pro-2.log -Dhbase.home.dir=/Users/zlq/Servers/hbase/hbase-1.2.4/bin/.. -Dhbase.id.str=zlq -Dhbase.root.logger=INFO,RFA -Dhbase.security.logger=INFO,RFAS org.apache.hadoop.hbase.master.HMaster start
zlq              78257   0.0  0.0  2446696   1276 s010  S     3:11PM   0:00.01 bash /Users/zlq/Servers/hbase/hbase-1.2.4/bin/hbase-daemon.sh --config /Users/zlq/Servers/hbase/hbase-1.2.4/bin/../conf foreground_start master
```

```
bash bin/hbase-daemons.sh --config conf --hosts conf/regionservers start regionserver
bash bin/hbase-daemons.sh --config conf --hosts conf/regionservers stop regionserver
```

```
zlq              83754   0.1  2.2  6145336 186472 s010  S     3:23PM   0:07.86 /Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home/bin/java -Dproc_regionserver -XX:OnOutOfMemoryError=kill -9 %p -XX:+UseConcMarkSweepGC -Dhbase.log.dir=/Users/zlq/Servers/hbase/hbase-1.2.4/bin/../logs -Dhbase.log.file=hbase-zlq-1-regionserver-Apples-MacBook-Pro-2.log -Dhbase.home.dir=/Users/zlq/Servers/hbase/hbase-1.2.4/bin/.. -Dhbase.id.str=zlq-1 -Dhbase.root.logger=INFO,RFA -Dhbase.security.logger=INFO,RFAS org.apache.hadoop.hbase.regionserver.HRegionServer -D hbase.regionserver.port=16201 -D hbase.regionserver.info.port=16301 start
```

```
hbase-daemons.sh --> master-backup.sh --> hbase-daemon.sh
```

```

```


远程操作

```
+ ssh localhost cd '/Users/zlq/Servers/hbase/hbase-1.2.4/bin/..;' /Users/zlq/Servers/hbase/hbase-1.2.4/bin/hbase-daemon.sh --config conf stop regionserver
```