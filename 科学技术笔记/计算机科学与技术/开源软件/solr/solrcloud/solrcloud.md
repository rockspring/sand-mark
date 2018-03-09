OverSeer，一个集群有一个

Shard Leader，每个Shard有几个Replica，其中有一个Leader

solrcloud

更新请求发到leader
org.apache.solr.update.processor.LogUpdateProcessor处理
	 |
	\|/
org.apache.solr.update.UpdateHandler这是抽象类，默认实现类org.apache.solr.update.DirectUpdateHandler2


leader接收到update请求，发送一个请求给follower，如下：
/solr/collection1/update?update.distrib=FROMLEADER&distrib.from=http%3A%2F%2F192.168.1.125%3A8983%2Fsolr%2Fcollection1%2F&wt=javabin&version=2


follower接收到update请求，先发送给leader，如下：
/solr/collection1/update?update.distrib=TOLEADER&distrib.from=http%3A%2F%2F192.168.1.125%3A7574%2Fsolr%2Fcollection1%2F&wt=javabin&version=2
follower使用org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrServer发送请求给leader

leader接收到follower的请求后，发送请求给follower，如下：
/solr/collection1/update?update.distrib=FROMLEADER&distrib.from=http%3A%2F%2F192.168.1.125%3A8983%2Fsolr%2Fcollection1%2F&wt=javabin&version=2



updateRequestProcessorChain（有SolrCore创建）
默认情况：
依次由LogUpdateProcessorFactory，DistributedUpdateProcessorFactory，RunUpdateProcessorFactory创建processor作为处理器链的处理器


启动instance1
java -Dbootstrap_confdir=./solr/collection1/conf -Dcollection.configName=myconf -DzkRun -DnumShards=2 -jar start.jar
启动instance2
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -Djetty.port=8984 -DzkHost=localhost:9983 -jar start.jar


handler继承关系
UpdateRequestHandler-->ContentStreamHandlerBase(abstract)-->RequestHandlerBase(abstract)-->SolrRequestHandler(interface)
非leader的update处理流程
SolrDispatch --> updateRequestHandler --> ContentStreamLoader --> DistributedUpdateProcessor -->SolrCmdDistributor -->LogUpdateProcessor













org.apache.solr.update.processor.LogUpdateProcessor
||
\/
org.apache.solr.update.SolrCmdDistributor













UpdateRequestProcessorChain 拥有UpdateRequestProcessorFactory对象数组
--> UpdateRequestProcessorFactory数组，由如下三个Factory组成
	* LogUpdateProcessorFactory
	* DistributedUpdateProcessorFactory
	* RunUpdateProcessorFactory







ContentStreamHandlerBase(抽象类，继承于ContentStreamHandlerBase).handleRequestBody处理流程

获取UpdateRequestProcessorChain，从处理器链里获取第一个处理器LogUpdateProcessor
创建ContentStreamLoader，调用load方法，将LogUpdateProcessor传进去，load方法根据文档类型获取XMLLoader

调用XMLLoader的load方法，将LogUpdateProcessor传进去

调用XMLLoader的processUpdate方法，将LogUpdateProcessor传进去

XMLLoader的processUpdate方法创建AddUpdateCommand（继承于UpdateCommand），调用LogUpdateProcessor的processAdd方法

LogUpdateProcessor的processAdd方法调用DistributedUpdateProcessor的processAdd方法
DistributedUpdateProcessor的processAdd方法调用DistributedUpdateProcessor的versionAdd方法




DistributedUpdateProcessor的setupRequest方法会设置forwardToLeader字段的值


UpdateRequestHandler（继承于ContentStreamHandlerBase）