客户端

如果启用了可以连接readonly服务器，则如果服务器处于readonly状态，可以连接它。此时客户端的连接状态为ZooKeeper.States.CONNECTEDREADONLY，只能发送read命令，不能发送写命令！


服务端

在选举阶段，尝试启动ReadOnlyZooKeeperServer服务器

这个时候即使只有这台服务器节点存活，这台服务器节点不是完全启动不了，而是降级的方式，即只读的方式启动服务器，客户端还可以进行查询。

如果要启动全功能服务器，服务器集群的数量必须符合quorum的要求。

```
2016-04-11 23:08:34,610 [myid:3] - INFO  [QuorumPeer[myid=3]/0:0:0:0:0:0:0:0:2183:QuorumPeer@714] - LOOKING
2016-04-11 23:08:34,618 [myid:3] - INFO  [QuorumPeer[myid=3]/0:0:0:0:0:0:0:0:2183:QuorumPeer@717] - Attempting to start ReadOnlyZooKeeperServer
```

虽然服务器启动了ReadOnlyZooKeeperServer，但是选举过程任然在尝试，QuorumPeer的状态依然为LOOKING。