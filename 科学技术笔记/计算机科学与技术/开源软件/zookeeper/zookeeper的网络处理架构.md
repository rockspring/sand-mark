org.apache.zookeeper.server.quorum.QuorumPeerMain

集群模式启动入口


NIOServerCnxnFactory

这是Runnable的类，run方法有一个循环，循环地从selector选择事件，

配置

public void configure(InetSocketAddress addr, int maxcc) throws IOException;

创建连接工厂线程

打开服务器客户端请求监听端口，并把这个端口注册到Selector中，对OP_ACCEPT操作感兴趣

启动



FollowerZooKeeperServer

处理器链

FollowerRequestProcessor -> CommitProcessor -> FinalRequestProcessor

FollowerRequestProcessor是一个线程，有一个循环，从请求队列里获取请求，处理请求

CommitProcessor是一个线程，有一个循环，从请求队列里获取请求，处理请求


FinalRequestProcessor不是一个线程，直接操作zookeeper引擎


网络处理事件循环处理线程，将请求传到FollowerZooKeeperServer的第一个处理器FollowerRequestProcessor的队列中

NIOServerCnxnFactory每次处理端口接收事件后创建一个NIOServerCnxn，NIOServerCnxn负责处理IO读写请求

NIOServerCnxn的readLength方法读取请求头的长度，检查zookeeper的引擎ZooKeeperServer是否已经创建并在运行，如果不在运行，抛出异常，异常处理流程中关闭本次连接