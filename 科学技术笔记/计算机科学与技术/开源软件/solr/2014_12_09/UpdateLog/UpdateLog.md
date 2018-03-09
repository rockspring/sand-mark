RecoveryStrategy 有一个doRecovery方法

```
public void doRecovery(SolrCore core) throws KeeperException, InterruptedException;
```

# 处理流程

* 获取最近的更新日志recentUpdates
* 获取最近的版本号recentVersions
* 获取起始版本号startingVersions

* 如果起始版本号startingVersions不为空且recoveringAfterStartup
	* 从起始版本号中获取第一个起始版本firstStartingVersion
	* 从最近的版本列表中寻找firstStartingVersion，找到了，oldIdx保存其在列表中的位置

* 如果recoveringAfterStartup
	* 从UpdateLog里获取最后一次操作类型startingOperation，如果是FLAG_GAP，则设firstTime = false，跳过peer sync.

* 满足条件(!successfulRecovery && !isInterrupted() && !isClosed())就进入循环体

	* 获取云描述符cloudDesc
	* 获取leader的属性leaderprops
	* 获取leader的leaderBaseUrl
	* 获取leader的leaderCoreName
	* 获取leader的leaderUrl
	* 获取ourUrl
	* 比较leaderUrl和ourUrl，如果相等，则isLeader=true
	* 如果isLeader=true但是cloudDesc里又不是leader，则抛出异常，流程结束
	* 如果cloudDesc里显示是leader，发布状态ACTIVE到zookeeper，流程结束
	* 发布状态RECOVERING到zookeeper
	* 发送PREPRECOVERY命令到leader
	* 等待2秒确保leader在看到

	* 如果firstTime=true，尝试peer sync方式
		* 创建PeerSync对象
		* 调用PeerSync对象的sync方法进行同步
			* 请求nUpdates个版本号，异步请求
			* 等待请求完成，获得响应
			* 处理响应，设置success状态
		* 如果sync方法成功
			* 在本节点传递一个commit命令
			* 发布ACTIVE状态到zookeeper，流程结束
		* 如果sync方法不成功，退出peer sync方式

	* 设置UpdateLog状态为BUFFERING，调用ulog.bufferUpdates()
	* 从leader复制索引数据，调用replicate方法
	* 回放从BUFFERING开始以来UpdateLog的日志，调用replay
	* 发布ACTIVE状态到zookeeper
	* 调用recoveryListener
	* 丢掉BUFFERING开始以来UpdateLog的日志，调用ulog.dropBufferedUpdates()
	* 如果recovery不成功，发布RECOVERY_FAILED状态到zookeeper，调用recoveryListener
	* 睡眠一定时间，重试，最大重试次数MAX_RETRIES=500

UpdateLog里有一个Deque<TransactionLog> logs字段，保存了最近的不在用的事务日志

TransactionLog prevTlog;
保存了前一个事务日志

protected TransactionLog tlog;
保存了当前事务日志


getRecentUpdates方法处理流程

* 创建一个链表logList，并用logs数据初始化

* 如果prevTlog不为空，加入到链表的头

* 如果tlog不为空，加入到链表的头

* 创建RecentUpdates对象

* 设置RecentUpdates对象的字段logList为前面创建的链表

* 更新RecentUpdates对象

	* 创建如下4个字段

	```
	updateList = new ArrayList<List<Update>>(logList.size());
	deleteByQueryList = new ArrayList<Update>();
	deleteList = new ArrayList<DeleteUpdate>();
	updates = new HashMap<Long,Update>(numRecordsToKeep);
	```
