
1 zookeeper.globalOutstandingLimit这个java系统属性

Clients can submit requests faster than ZooKeeper can process them, especially if there are a lot of clients. To prevent ZooKeeper from running out of memory due to queued requests, ZooKeeper will throttle clients so that there is no more than globalOutstandingLimit outstanding requests in the system. The default limit is 1,000.

ZooKeeperServer::getGlobalOutstandingLimit

2 zookeeper.preAllocSize

To avoid seeks ZooKeeper allocates space in the transaction log file in blocks of preAllocSize kilobytes. The default block size is 64M. One reason for changing the size of the blocks is to reduce the block size if snapshots are taken more often. (Also, see snapCount).

FileTxnLog

3 zookeeper.snapCount

