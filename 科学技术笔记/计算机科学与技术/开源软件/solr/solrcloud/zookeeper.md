solr启动时zookeeper的入口

ZkContainer类的实例保存在CoreContainer类成员变量

```
protected ZkContainer zkSys = new ZkContainer();
```

CoreContainer.load方法里面调用ZkContainer.initZooKeeper方法



ZkContainer.initZooKeeper方法处理流程

* 判断zkHost、zkRun两个属性值是否为空，以便识别出solr是否运行在cloud模式

* 如果运行在cloud模式，如果zkRun不为空，则以嵌入式方式启动zookeeper服务器，否则solr将连接外部的zookeeper服务器

* 如果zkHost属性不为空，则solr运行在cloud模式
	* 检查是否有根路径，如果不存在则创建，根路径为连接字符串后面的路径，如localhost:2181
	* 创建ZkController类的实例，作为ZkContainer的成员变量


ZkController构造方法处理流程：

* 创建SolrZkClient类的实例，作为ZkController构造方法处理流程：的成员变量

* 调用Overseer.getInQueue()方法获得overseerJobQueue

* 调用Overseer.getCollectionQueue方法获得overseerCollectionQueue

* 创建ZkCmdExecutor类的实例

* 创建LeaderElector类的实例

* 创建ZkStateReader类的实例

* 调用ZkController.init()方法


ZkController.init()方法

* 如果存在/live_nodes存在，调用publishAndWaitForDownStates()方法调用overseerJobQueue.offer()方法
