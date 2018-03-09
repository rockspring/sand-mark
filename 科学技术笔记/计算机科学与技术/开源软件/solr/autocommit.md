@date 2014年11月12日
@author leqinzhou

solr 使用CommitTracker实现自动提交

CommitTracker在solr启动时初始化

DirectUpdateHandler2类根据配置初始化两个CommitTracker
```
4669 [coreLoadExecutor-5-thread-1] org.apache.solr.update.CommitTracker.<init>(CommitTracker.java:83) INFO  org.apache.solr.core.SolrCore  – Hard AutoCommit: if uncommited for 15000ms;
4669 [coreLoadExecutor-5-thread-1] org.apache.solr.update.CommitTracker.<init>(CommitTracker.java:83) INFO  org.apache.solr.core.SolrCore  – Soft AutoCommit: disabled
```


### 初始化流程

* SolrCore创建DirectUpdateHandler2类的实例

* DirectUpdateHandler2根据UpdateHandlerInfo实例（从SolrConfig实例获得）的commit配置创建CommitTracker实例

* CommitTracker创建ScheduledExecutorService，但此时没有线程

### CommitTracker如何调度

由update请求触发

addedDocument方法判断是否调度commit程序执行

调用链路1（根据文档数量判断）：DirectUpdateHandler2.addDoc0 --> commitTracker.addedDocument --> CommitTracker._scheduleCommitWithin

提交commit操作到线程调度器，update请求立即正常返回


调用链路2(根据上次commit时间判断)：DirectUpdateHandler2.addDoc0 --> commitTracker.addedDocument --> CommitTracker._scheduleCommitWithinIfNeeded --> CommitTracker._scheduleCommitWithin

提交commit操作到线程调度器，update请求立即正常返回


### DirectUpdateHandler2如何commit

调用链路：DirectUpdateHandler2.commit --> SolrCore.getSearcher(通过searcherLock锁对象同步)

问题：正常的查询请求是否也通过searcherLock锁对象同步，这个时刻查询会被阻塞？

