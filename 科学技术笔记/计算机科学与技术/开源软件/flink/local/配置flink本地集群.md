# org.apache.flink.api.scala.FlinkShell#fetchConnectionInfo

创建LocalFlinkMiniCluster并启动。


配置网络连接的actor

private def getRemoteAkkaConfig(configuration: Configuration,
                                  bindAddress: String, port: Int,
                                  externalHostname: String, externalPort: Int)

akka.ask.timeout 阻塞调用方式集群端的超时时间 默认值10 s

akka.startup-timeout actor启动超时 默认值为akka.ask.timeout的10倍（100 seconds）

akka.transport.heartbeat.interval 传输通道失败探测器的心跳时间间隔 1000 s

akka.transport.heartbeat.pause 允许的传输通道失败探测器的心跳暂停时间 6000 s

akka.transport.threshold 传输通道失败探测器的探测阈值 300.0

akka.watch.heartbeat.interval Akka死亡监视心跳间隔 10 s

akka.watch.heartbeat.pause 最大可接受Akka死亡监视心跳暂停时间 60s

akka.watch.threshold phi accrual失败探测器的探测阈值 12

akka.tcp.timeout tcp连接的超时时间 20 s

akka.framesize akka消息的最大帧大小 10485760b

akka.log.lifecycle.events 是否记录生命周期事件 false

akka.ssl.enabled Akka传输通道是否支持SSL true，结合security.ssl.enabled设置

security.ssl.enabled 是否启动SSL支持

security.ssl.keystore 包含flink终端节点的key和certificate的java keystore文件 null

security.ssl.keystore-password 对keystore文件解密的秘钥 null

security.ssl.key-password 解密服务器server的秘钥 null

security.ssl.truststore 包含用于验证ssl节点的公开CA证书certificate的truststore文件 null

security.ssl.truststore-password 解密truststore的密钥 null

security.ssl.protocol 能够支持的SSL协议版本 TLSv1.2

security.ssl.algorithms 能够支持的标准SSL算法 TLS_RSA_WITH_AES_128_CBC_SHA

如果externalHostname不为空，则effectiveHostname为externalHostname



# 创建actor系统（startJobManagerActorSystem）

org.apache.flink.runtime.akka.AkkaUtils#createActorSystem

调用ActorSystem.create("flink", akkaConfig)创建一个actor系统

# 启动jobmanager

org.apache.flink.runtime.minicluster.LocalFlinkMiniCluster#startJobManager

jobmanager.rpc.port jobmanager对外开放的网络端口 默认值为6123

如果有多个jobmanager，通过jobManagerPort + index方式生成端口号

## 创建JobManager的组件

org.apache.flink.runtime.jobmanager.JobManager#createJobManagerComponents

```
(InstanceManager,
FlinkScheduler,
BlobLibraryCacheManager,
RestartStrategyFactory,
FiniteDuration, // timeout
Int, // number of archived jobs
Option[Path], // archive path
LeaderElectionService,
SubmittedJobGraphStore,
CheckpointRecoveryFactory,
FiniteDuration, // timeout for job recovery
Option[FlinkMetricRegistry]
)
```

### 创建基础组件

```
blobServer = new BlobServer(configuration)
instanceManager = new InstanceManager()
scheduler = new FlinkScheduler(ExecutionContext.fromExecutor(futureExecutor))
libraryCacheManager = new BlobLibraryCacheManager(blobServer, cleanupInterval)
```

akka.ask.timeout 阻塞调用方式集群端的超时时间 默认值10 s

library-cache-manager.cleanup.interval library缓存管理器的清理时间间隔 3600*1000 ms


RestartStrategyFactory 重启策略工厂，这里应用了工厂方法设计模式。具体的工厂有静态方法createRestartStrategyFactory根据配置Configuration创建。

有三种重启策略，分别为FailureRateRestartStrategyFactory、FixedDelayRestartStrategy、NoRestartStrategy


jobmanager.web.history jobmanager归档的job数量 5

jobmanager.archive.fs.dir 存储已经完成的job的归档目录 null


org.apache.flink.runtime.blob.BlobServer#BlobServer(org.apache.flink.configuration.Configuration)

BlobServer负责监听进来的请求，产生线程处理请求，创建用于存储BLOB或缓存BLOB的临时数据的目录。BlobServer继承了Thread，是一个线程。

blob.storage.directory blob服务器使用的存储目录，默认为null，则使用操作系统的java.io.tmpdir目录

文件夹的名称命名规则如blobStore-319bb9ed-cb7e-4612-a094-abc31c05d590，即blobStore加UUID

blob.fetch.num-concurrent JobManager服务的最大并发抓取并发数，默认值为50

blob.fetch.backlog JobManager上BLOB抓取的backlog 默认值为1000

blob.server.port blob服务的端口，默认值为0，让操作系统选择一个端口

blob.service.ssl.enabled blob服务的传输通道是否支持ssl，默认为true


org.apache.flink.runtime.blob.BlobServerConnection#BlobServerConnection为blob接收到一个请求后创建的处理请求的线程。

## InstanceManager

org.apache.flink.runtime.instance.InstanceManager#InstanceManager

InstanceManager跟踪哪一个TaskManager是可用的且活跃的。

### 如何注册taskmanager到instanceManager，通过actor（jobmanager）接收一个RegisterTaskManager消息来执行

org.apache.flink.runtime.taskmanager.TaskManagerLocation由ResourceID resourceID、InetAddress inetAddress、String fqdnHostName、String hostName、int dataPort组成。

org.apache.flink.runtime.instance.HardwareDescription由int numberOfCPUCores、long sizeOfPhysicalMemory、long sizeOfJvmHeap、long sizeOfManagedMemory组成。

## clusterframework.types

org.apache.flink.runtime.clusterframework.types.ResourceIDRetrievable
org.apache.flink.runtime.clusterframework.types.ResourceID


哪个组件发送这个注册消息？

TaskManager自身先接收一个RegistrationMessage消息。

org.apache.flink.runtime.taskmanager.TaskManager#handleMessage
org.apache.flink.runtime.taskmanager.TaskManager#handleRegistrationMessage

## 组件Scheduler

org.apache.flink.runtime.jobmanager.scheduler.Scheduler#Scheduler

Scheduler负责分发准备运行的任务到TaskManager实例及TaskManager实例的资源槽中。支持两种调度模式，立即调度或排队等待调度。

Set<Instance> allInstances、HashMap<String, Set<Instance>> allInstancesByHost、Map<ResourceID, Instance> instancesWithAvailableResources、Queue<QueuedTask> taskQueue、BlockingQueue<Instance> newlyAvailableInstances、int unconstrainedAssignments、int localizedAssignments、int nonLocalizedAssignments。

org.apache.flink.runtime.jobmanager.scheduler.Scheduler.QueuedTask

包含等待被调度的任务ScheduledUnit及跟踪任务完成的CompletableFuture。

org.apache.flink.runtime.jobmanager.scheduler.ScheduledUnit

org.apache.flink.runtime.execution.librarycache.BlobLibraryCacheManager#BlobLibraryCacheManager

对每一个提交到系统的计算作业图，BlobLibraryCacheManager维持这个计算作业图需要的执行库文件（jar）

### 创建恢复相关的组件

#### HighAvailabilityMode.NONE

```
org.apache.flink.runtime.leaderelection.StandaloneLeaderElectionService
org.apache.flink.runtime.jobmanager.StandaloneSubmittedJobGraphStore
org.apache.flink.runtime.checkpoint.StandaloneCheckpointRecoveryFactory
```

#### HighAvailabilityMode.ZOOKEEPER

```
org.apache.flink.runtime.util.ZooKeeperUtils#startCuratorFramework
org.apache.flink.runtime.util.ZooKeeperUtils#createLeaderElectionService(org.apache.curator.framework.CuratorFramework, org.apache.flink.configuration.Configuration)
org.apache.flink.runtime.util.ZooKeeperUtils#createSubmittedJobGraphs
org.apache.flink.runtime.checkpoint.ZooKeeperCheckpointRecoveryFactory#ZooKeeperCheckpointRecoveryFactory
```

high-availability.job.delay 延迟多长时间故障转移组件恢复当前job。无默认值。废弃的key为recovery.job.delay。

### MetricRegistry

org.apache.flink.runtime.metrics.MetricRegistry#MetricRegistry

## 启动MetricQueryService

local.start-webserver 是否启动本地的web服务器。

org.apache.flink.runtime.metrics.MetricRegistry#startQueryService
org.apache.flink.runtime.metrics.dump.MetricQueryService#startMetricQueryService

## 启动MemoryArchivist这个Actor

保存终结的flink任务。

## 创建JobManager这个Actor

```
protected val flinkConfiguration: Configuration,
protected val futureExecutor: ScheduledExecutorService,
protected val ioExecutor: Executor,
protected val instanceManager: InstanceManager,
protected val scheduler: FlinkScheduler,
protected val libraryCacheManager: BlobLibraryCacheManager,
protected val archive: ActorRef,
protected val restartStrategyFactory: RestartStrategyFactory,
protected val timeout: FiniteDuration,
protected val leaderElectionService: LeaderElectionService,
protected val submittedJobGraphs : SubmittedJobGraphStore,
protected val checkpointRecoveryFactory : CheckpointRecoveryFactory,
protected val jobRecoveryTimeout: FiniteDuration,
protected val metricsRegistry: Option[FlinkMetricRegistry]
```
至此，jobmanager这个actor启动完毕，Actor[akka://flink/user/jobmanager#-62153793]。

# 启动leader检索服务

## 创建LeaderRetrievalService

org.apache.flink.runtime.minicluster.FlinkMiniCluster#createLeaderRetrievalService

org.apache.flink.runtime.minicluster.FlinkMiniCluster#notifyLeaderAddress

### HighAvailabilityMode.NONE

org.apache.flink.runtime.leaderretrieval.StandaloneLeaderRetrievalService#StandaloneLeaderRetrievalService(java.lang.String)

### HighAvailabilityMode#ZOOKEEPER

org.apache.flink.runtime.util.ZooKeeperUtils#createLeaderRetrievalService(org.apache.flink.configuration.Configuration)

# 启动ResourceManager的Actor系统

akka://flink

## 启动ResourceManager

是一个actor

```
Actor[akka://flink/user/resourcemanager#1526964945]
```

org.apache.flink.runtime.minicluster.LocalFlinkMiniCluster#startResourceManager

resourcemanager.rpc.port 与resource manager通信的网络端口，默认为0，由操作系统自动分配。


org.apache.flink.runtime.clusterframework.standalone.StandaloneResourceManager

### 创建LeaderRetrievalService

#### HighAvailabilityMode.NONE

org.apache.flink.runtime.leaderretrieval.StandaloneLeaderRetrievalService#StandaloneLeaderRetrievalService(java.lang.String)

#### HighAvailabilityMode#ZOOKEEPER

org.apache.flink.runtime.util.ZooKeeperUtils#createLeaderRetrievalService(org.apache.flink.configuration.Configuration)

# 启动TaskManager的Actor系统

Actor[akka://flink/user/taskmanager#1293285460]

## 启动TaskManager，它是actor

org.apache.flink.runtime.minicluster.LocalFlinkMiniCluster#startTaskManager

taskmanager.rpc.port taskmanager的IPC端口，默认为0

taskmanager.data.port 数据端口，默认为0

org.apache.flink.runtime.taskexecutor.TaskManagerServicesConfiguration

org.apache.flink.runtime.taskexecutor.TaskManagerServices

org.apache.flink.runtime.taskexecutor.TaskManagerServices#getMetricRegistry

### 创建LeaderRetrievalService

#### HighAvailabilityMode.NONE

org.apache.flink.runtime.leaderretrieval.StandaloneLeaderRetrievalService#StandaloneLeaderRetrievalService(java.lang.String)

#### HighAvailabilityMode#ZOOKEEPER

org.apache.flink.runtime.util.ZooKeeperUtils#createLeaderRetrievalService(org.apache.flink.configuration.Configuration)

local.start-webserver 是否启动web服务器

# 启动web服务器

akka.tcp://flink@localhost:58446/user/jobmanager

org.apache.flink.runtime.minicluster.FlinkMiniCluster#startWebServer

local.start-webserver 是否启动web服务器

org.apache.flink.runtime.webmonitor.WebMonitorUtils#startWebRuntimeMonitor

# 等待所有taskmanager注册到jobmanager

org.apache.flink.runtime.minicluster.FlinkMiniCluster#waitForTaskManagersToBeRegistered

# 启动完毕

Starting local Flink cluster (host: localhost, port: 58446).


# 启动shell循环

Connecting to Flink cluster (host: localhost, port: 58446).

org.apache.flink.api.scala.FlinkILoop

org.apache.flink.api.scala.ILoopCompat

org.apache.flink.api.scala.FlinkILoop#createInterpreter

def process(settings: Settings): Boolean方法启动循环，循环执行read-eval-print。
