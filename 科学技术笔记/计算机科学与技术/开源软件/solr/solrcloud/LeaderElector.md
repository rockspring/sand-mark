ZkController构造函数
ZkController.init
\__LeaderElector.joinElection
 \__LeaderElector.checkIfIamLeader
  \__LeaderElector.runIamLeaderProcess
   \__ShardLeaderElectionContext.runLeaderProcess
ShardLeaderElectionContext --> ShardLeaderElectionContextBase --> ElectionContext