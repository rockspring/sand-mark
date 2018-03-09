# ResourceManager是一个组合服务，组合了其他的服务

AsyncDispatcher
AdminService
RMApplicationHistoryWriter
SystemMetricsPublisher

ResourceManager的serviceInit创建了以上的服务，然后通过调用super.serviceInit方法的方式依次调用以上服务的serviceInit方法。

有一个组合服务比较特殊，在createAndInitActiveServices方法中创建并执行init方法，这个服务作为用ResourceManager的字段activeServices引用。


## org.apache.hadoop.yarn.event.AsyncDispatcher

在一个单独的线程中派遣org.apache.hadoop.yarn.event.Event事件。

AsyncDispatcher继承AbstractService，是一个服务。

AbstractService服务启动之后以一个独立线程循环执行。

## org.apache.hadoop.yarn.server.resourcemanager.AdminService

AdminService继承CompositeService，CompositeService继承AbstractService，是一个组合服务。

默认监听地址为0.0.0.0:8033

网络服务器使用org.apache.hadoop.yarn.ipc.YarnRPC实现。HadoopYarnProtoRPC是YarnRPC的一个具体实现。


ResourceManagerAdministrationProtocol是一个协议接口，它继承了GetUserMappingsProtocol，实现了如下接口

```
getGroupsForUser

refreshQueues
refreshNodes
refreshSuperUserGroupsConfiguration
refreshUserToGroupsMappings
refreshAdminAcls
refreshServiceAcls
updateNodeResource
addToClusterNodeLabels
removeFromClusterNodeLabels
replaceLabelsOnNode
```

对启用了HA功能的resourcemanager，设置HAServiceProtocolPB使用ProtobufRpcEngine引擎。

HAServiceProtocolServerSideTranslatorPB是一个服务器实现，组合了AdminService。

HAServiceProtocolService是一个protobuf协议的服务接口，组合了HAServiceProtocolServerSideTranslatorPB，它的接口调用转到HAServiceProtocolServerSideTranslatorPB。

HAServiceProtocolService注册到org.apache.hadoop.ipc.ProtobufRpcEngine.Server#Server。




org.apache.hadoop.yarn.ipc.YarnRPC#getServer(java.lang.Class, java.lang.Object, java.net.InetSocketAddress, org.apache.hadoop.conf.Configuration, org.apache.hadoop.security.token.SecretManager<? extends org.apache.hadoop.security.token.TokenIdentifier>, int)

org.apache.hadoop.yarn.ipc.YarnRPC#getServer(java.lang.Class, java.lang.Object, java.net.InetSocketAddress, org.apache.hadoop.conf.Configuration, org.apache.hadoop.security.token.SecretManager<? extends org.apache.hadoop.security.token.TokenIdentifier>, int, java.lang.String)

org.apache.hadoop.yarn.ipc.HadoopYarnProtoRPC#getServer

org.apache.hadoop.yarn.factories.impl.pb.RpcServerFactoryPBImpl#getServer(java.lang.Class<?>, java.lang.Object, java.net.InetSocketAddress, org.apache.hadoop.conf.Configuration, org.apache.hadoop.security.token.SecretManager<? extends org.apache.hadoop.security.token.TokenIdentifier>, int, java.lang.String)

org.apache.hadoop.yarn.factories.impl.pb.RpcServerFactoryPBImpl#createServer

org.apache.hadoop.ipc.RPC.Builder#build

org.apache.hadoop.ipc.ProtobufRpcEngine#getServer

org.apache.hadoop.ipc.ProtobufRpcEngine.Server#Server







处理rpc请求

org.apache.hadoop.ipc.Server.Listener.Reader启动一个独立的线程。

```
org.apache.hadoop.ipc.Server#Server(java.lang.String, int, java.lang.Class<? extends org.apache.hadoop.io.Writable>, int, int, int, org.apache.hadoop.conf.Configuration, java.lang.String, org.apache.hadoop.security.token.SecretManager<? extends org.apache.hadoop.security.token.TokenIdentifier>, java.lang.String)

org.apache.hadoop.ipc.Server.Listener#Listener

org.apache.hadoop.ipc.Server.Listener.Reader#run

org.apache.hadoop.ipc.Server.Listener.Reader#doRunLoop

org.apache.hadoop.ipc.Server.Listener#doRead

org.apache.hadoop.ipc.Server.Connection#readAndProcess

org.apache.hadoop.ipc.Server.Connection#processOneRpc

org.apache.hadoop.ipc.Server.Connection#processRpcRequest

org.apache.hadoop.ipc.Server.Call#Call(int, int, org.apache.hadoop.io.Writable, org.apache.hadoop.ipc.Server.Connection, org.apache.hadoop.ipc.RPC.RpcKind, byte[], org.apache.htrace.Span)

org.apache.hadoop.ipc.CallQueueManager#put
```

org.apache.hadoop.ipc.Server.Listener#Listener绑定监听地址，然后启动多个Reader线程。

Listener也启动一个线程，循环从Selector选择网络连接事件。


网络连接轮训方式分发到不同的Reader。

建立的连接注册到org.apache.hadoop.ipc.Server.ConnectionManager。



org.apache.hadoop.ipc.Server.Responder是一个独立的线程，发送响应给客户端。


org.apache.hadoop.ipc.Server.Handler是一个独立的线程，从CallQueueManager获取RPC调用，执行后设置结果，然后调用org.apache.hadoop.ipc.Server.Responder#doRespond将结果放入org.apache.hadoop.ipc.Server.Connection#responseQueue队列中。



org.apache.hadoop.ipc.Server#start启动Handler，启动的线程数量由handlerCount决定。



org.apache.hadoop.ipc.Server.Listener#run启动org.apache.hadoop.ipc.Server.ConnectionManager#startIdleScan，使用Timer定时运行服务。


## org.apache.hadoop.yarn.server.resourcemanager.ResourceManager.RMActiveServices

处理RM中所有的活跃服务

org.apache.hadoop.yarn.server.resourcemanager.RMSecretManagerService#RMSecretManagerService

org.apache.hadoop.yarn.server.resourcemanager.rmcontainer.ContainerAllocationExpirer

org.apache.hadoop.yarn.server.resourcemanager.rmapp.attempt.AMLivelinessMonitor

org.apache.hadoop.yarn.server.resourcemanager.nodelabels.RMNodeLabelsManager

org.apache.hadoop.yarn.server.resourcemanager.recovery.MemoryRMStateStore

org.apache.hadoop.yarn.server.resourcemanager.security.DelegationTokenRenewer

org.apache.hadoop.yarn.server.resourcemanager.NodesListManager

org.apache.hadoop.yarn.server.resourcemanager.scheduler.capacity.CapacityScheduler

org.apache.hadoop.yarn.server.resourcemanager.ResourceManager.SchedulerEventDispatcher

org.apache.hadoop.yarn.server.resourcemanager.ResourceManager.ApplicationEventDispatcher

org.apache.hadoop.yarn.server.resourcemanager.ResourceManager.ApplicationAttemptEventDispatcher

org.apache.hadoop.yarn.server.resourcemanager.NMLivelinessMonitor

org.apache.hadoop.yarn.server.resourcemanager.ResourceTrackerService

org.apache.hadoop.yarn.server.resourcemanager.reservation.CapacityReservationSystem

org.apache.hadoop.yarn.server.resourcemanager.monitor.SchedulingMonitor

org.apache.hadoop.yarn.server.resourcemanager.ApplicationMasterService

非服务组件

org.apache.hadoop.yarn.server.security.ApplicationACLsManager

org.apache.hadoop.yarn.server.resourcemanager.security.QueueACLsManager

事件处理器

org.apache.hadoop.yarn.server.resourcemanager.RMAppManager

服务

org.apache.hadoop.yarn.server.resourcemanager.ClientRMService

org.apache.hadoop.yarn.server.resourcemanager.amlauncher.ApplicationMasterLauncher

## org.apache.hadoop.yarn.server.resourcemanager.ahs.RMApplicationHistoryWriter

## org.apache.hadoop.yarn.server.resourcemanager.metrics.SystemMetricsPublisher

这是一个组合服务

# 服务启动

org.apache.hadoop.yarn.server.resourcemanager.ResourceManager#serviceStart

## org.apache.hadoop.yarn.server.resourcemanager.ResourceManager#startActiveServices

## org.apache.hadoop.yarn.server.resourcemanager.ResourceManager#startWepApp

基于jetty实现的org.apache.hadoop.http.HttpServer2