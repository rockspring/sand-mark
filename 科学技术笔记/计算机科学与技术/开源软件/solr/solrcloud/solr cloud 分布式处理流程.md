solr cloud 分布式处理


# follower节点处理流程
add命令

forwardToLeader=false，即该请求不需要转发给leader

执行DistributedUpdateProcessor.versionAdd方法

	设置命令的版本
	将请求委托给处理链中得下一个处理器RunUpdateProcessor

leader转发请求到follower，并行执行且异步等待结果

使用ConcurrentUpdateSolrServer发送请求到follower

ConcurrentUpdateSolrServer就是同时建立多个连接到follower节点

如果follower节点执行缓慢，leader节点接收到的客户端节点也不会结束


# leader节点

接收客户端的请求，则只有leader和follower都写成功，客户端请求才算结束

