String register(String coreName, final CoreDescriptor desc, boolean recoverReloadedCores, boolean afterExpiration)


该方法执行流程

* 从DirectUpdateHandler2获取本实例更新日志UpdateLog

* 从更新日志恢复solr，UpdateLog.recoverFromLog，返回一个Future对象

* 同步等待恢复完成，从Future对象获取结果

* ZkController.checkRecovery(String coreName, final CoreDescriptor desc, boolean recoverReloadedCores, final boolean isLeader, final CloudDescriptor cloudDesc, final String collection, final String shardZkNodeName, String shardId, ZkNodeProps leaderProps, SolrCore core, CoreContainer cc)

  * DefaultSolrCoreState.doRecovery
    * 创建RecoveryStrategy
  * 连接zookeeper