上一周，对公司搜索引擎工作流程的做改造工作。涉及到不同角色服务器之间的沟通工作。我们试图应用zookeeper到我们的场景，实现应用模块之间的解耦。本文深入到solr源码，从中掘金，看看solr是如何使用zookeeper的。
在做本次改造的时候，公司同事对于zookeeper的使用，提供了很好的建议，其中一个重要原则就是“谁创建，谁修改”，也就是各个服务应用自己创造自己的结点，自己去修改配置自己的最新状态。一般情况下，对结点的修改是结点的创建者，而不应该是其它对些结点数据的关注者，不然会增加操作复杂度与不确定性。
在阅读solr源码会发现，solr对zookeeper的使用，使用的是另一种思想，虽然增加了复杂度，但更适用于cloud中各结点角色不确定的场景。
这里涉及的相关代码，主要在package org.apache.solr.cloud中。
 
说明
本人一开始阅读的是4.4的版本的代码，最新的是4.10.1, 后来简单看了一下最新代码，没有发现多少变动。
别看我在这里一本正经地给大家作源码分析，但毕竟一个人看，总有疏漏的地方，存在理解不当的地方，如果错误，请大家指正。
 
solr在zookeeper中的结点




 
1、aliases.json 对colletion别名，另有妙用（solrcloud的build search分离），以后再写博客说明。
2、clusterstate.json  重要信息文件。包含了colletion ,shard replica的具体描述信息。
3、live_nodes ，下面都是瞬时的zk结点，代表当前存活的solrcloud中的节点。
4、overseer， solrcloud中的重要角色。下面存有三个重要的分布式队列，代表待执行solrcloud相关的zookeeper操作的任务队列。collection-queue-work是存放与collection相关的特办操作，如createcollection ，reloadcollection，createalias，deletealias ，splitshard 等。
5、queue则存放了所有与collection无关的操作，例如deletecore，removecollection，removeshard，leader，createshard，updateshardstate，还有包括节点的状态（down、active、recovering）的变化。
6、queue-work是一个临时队列，指正在处理中的消息。操作会先保存到/overseer/queue，在overseser进行处理时，被移到/overseer/queue-work中，处理完后消息之后在从/overseer/queue-work中删除。如果overseer中途挂了，新选举的overseer会选将/overseer/queue-work中的操作执行完，再去处理/overseer/queue中的操作。
注意：以上队列中存放的所有子结点，都是PERSISTENT_SEQUENTIAL类型的。
7、overseer_elect ,用于overseer的选举工作
8、colletcion，存放当前collection一些简单信息（主要信息都在clusterstate.json中）。 下面的leader_elect自然是用于collection中shard中副本集的leader选举的。
 
 
Overseer 的zk写流程
在看solrcloud的官方文档的时候，几乎也很少有overseer的这个角色的说明介绍。相信不少成功配置solrcloud的开发者，也没有意识到这个角色的存在。
Overseer，顾名思义，是一个照看全局的角色，做总控工作。体现在代码与zk的相关操作中，就是zookeeper中大多的写操作，是由overseer去处理的，并且维护好clusterstate.josn与aliases.json这两个zk结点的内容。与我们“谁创建，谁修改”做法不同。由各个solr node发起的操作，都会publish到/overseer结点下面相应的queue中去，再由overseer去些分布式队列中去取这些操作信息，做相应的zk修改，并将整个solrcloud中相关的具体状态信息，更新到cluseterstate.json中去，最终会将个操作，从queue中删除，表示完成操作。
以一个solr node将自身状态标记为down为例。该node会将这种“state”operation的相关信息，publish到/overseer/queue中。由Overseer去从中取得这个操作，然后将node state为down的信息写入clusterstate.json。最后删除queue中的这个结点。
当然overseer这个角色，是利用zookeeper在solrcloud中内部选举出来的。
 
一般的zk读操作
  Solr将最重要且信息最全面的内容都放在了cluseterstate.json中。这样做减少了，普通solr node需要关注的zk 结点数。除了clusterstate.json，普通的solr node在需要当前collection整体状态的时候，还会获取zk的/live_nodes中的信息，根据live_nodes中的信息，得知collection存活的node, 再从clusterstate.json获得这些node的信息。
 这种处理，其实也好理解。假如一个solr node非正常下线，clusterstate.json中不一定会有变化，但/live_nodes中这个node对应的zk结点就消失了（因为是瞬时的）。
 
总结
看过这部份原码后，跟同事讨论了一下。Solr对zookeeper的这种使用方法，比角色分明集群系统，确实复杂得多。但solr为达到群集自感知，高可用，最终形成cloud的效果，内部的角色是动态变化的，所以大家需要一个统一管理的角色。而使用分布式队列，由一个overseer统一处理操作的好处，在于保证了操作的有序，这点也很重要。将最要信息集中在clusterstate.json的作法，减少了其他solr node对zk的关注逻辑的复杂度。