public class NioSocketChannel extends AbstractNioByteChannel implements io.netty.channel.socket.SocketChannel;



```
"nioEventLoopGroup-2-1@1059" prio=10 tid=0xd nid=NA runnable
  java.lang.Thread.State: RUNNABLE
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:357)
	  at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:350)
	  at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1334)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:372)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:358)
	  at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:926)
	  at io.netty.channel.nio.AbstractNioMessageChannel$NioMessageUnsafe.read(AbstractNioMessageChannel.java:93)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:610)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:551)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:465)
	  at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:437)
	  at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:873)
	  at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:144)
	  at java.lang.Thread.run(Thread.java:745)
```



Acceptor创建好来自客户端的连接后，将通道对象注册到孩子事件循环处理器群组里，在这个点acceptor线程的任务结束，任务投递到worker线程中。

public ChannelFuture register(Channel channel)方法从线程池中选择一个线程，使用PowerOfTowEventExecutorChooser选择器选择，选择算法为轮替算法。

```
try {
    childGroup.register(child).addListener(new ChannelFutureListener() {
        @Override
        public void operationComplete(ChannelFuture future) throws Exception {
            if (!future.isSuccess()) {
                forceClose(child, future.cause());
            }
        }
    });
} catch (Throwable t) {
    forceClose(child, t);
}
```

投递任务到worker线程的代码如下


io/netty/channel/AbstractChannel.java的子类AbstractUnsafe，register0方法为AbstractChannel的私有方法，promise为acceptor线程创建的对象，在io/netty/bootstrap/ServerBootstrap.java的子类ServerBootstrapAcceptor的channelRead方法中添加监听器到promise。
```
eventLoop.execute(new Runnable() {
    @Override
    public void run() {
        register0(promise);
    }
});
```


"nioEventLoopGroup-2-1@1059" prio=10 tid=0xd nid=NA runnable
  java.lang.Thread.State: RUNNABLE
	  at io.netty.channel.AbstractChannel$AbstractUnsafe.register(AbstractChannel.java:475)
	  at io.netty.channel.SingleThreadEventLoop.register(SingleThreadEventLoop.java:80)
	  at io.netty.channel.SingleThreadEventLoop.register(SingleThreadEventLoop.java:74)
	  at io.netty.channel.MultithreadEventLoopGroup.register(MultithreadEventLoopGroup.java:85)
	  at io.netty.bootstrap.ServerBootstrap$ServerBootstrapAcceptor.channelRead(ServerBootstrap.java:254)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:372)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:358)
	  at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:350)
	  at io.netty.handler.logging.LoggingHandler.channelRead(LoggingHandler.java:233)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:372)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:358)
	  at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:350)
	  at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1334)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:372)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:358)
	  at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:926)
	  at io.netty.channel.nio.AbstractNioMessageChannel$NioMessageUnsafe.read(AbstractNioMessageChannel.java:93)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:610)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:551)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:465)
	  at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:437)
	  at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:873)
	  at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:144)
	  at java.lang.Thread.run(Thread.java:745)


acceptor接收连接自后

```
"nioEventLoopGroup-2-1@1059" prio=10 tid=0xd nid=NA runnable
  java.lang.Thread.State: RUNNABLE
	  at io.netty.channel.DefaultChannelPipeline$TailContext.channelReadComplete(DefaultChannelPipeline.java:1225)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:408)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:390)
	  at io.netty.channel.AbstractChannelHandlerContext.fireChannelReadComplete(AbstractChannelHandlerContext.java:383)
	  at io.netty.channel.ChannelInboundHandlerAdapter.channelReadComplete(ChannelInboundHandlerAdapter.java:97)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:408)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:390)
	  at io.netty.channel.AbstractChannelHandlerContext.fireChannelReadComplete(AbstractChannelHandlerContext.java:383)
	  at io.netty.channel.ChannelInboundHandlerAdapter.channelReadComplete(ChannelInboundHandlerAdapter.java:97)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:408)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:390)
	  at io.netty.channel.AbstractChannelHandlerContext.fireChannelReadComplete(AbstractChannelHandlerContext.java:383)
	  at io.netty.channel.DefaultChannelPipeline$HeadContext.channelReadComplete(DefaultChannelPipeline.java:1339)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:408)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:390)
	  at io.netty.channel.DefaultChannelPipeline.fireChannelReadComplete(DefaultChannelPipeline.java:932)
	  at io.netty.channel.nio.AbstractNioMessageChannel$NioMessageUnsafe.read(AbstractNioMessageChannel.java:97)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:610)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:551)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:465)
	  at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:437)
	  at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:873)
	  at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:144)
	  at java.lang.Thread.run(Thread.java:745)

```

客户端输入内容后，worker线程READ事件发生，处理READ事件

```
"nioEventLoopGroup-3-1@2154" prio=10 tid=0xe nid=NA runnable
  java.lang.Thread.State: RUNNABLE
	  at io.netty.buffer.AbstractByteBuf.writeBytes(AbstractByteBuf.java:1100)
	  at io.netty.buffer.WrappedByteBuf.writeBytes(WrappedByteBuf.java:813)
	  at io.netty.channel.socket.nio.NioSocketChannel.doReadBytes(NioSocketChannel.java:367)
	  at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:118)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:610)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:551)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:465)
	  at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:437)
	  at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:873)
	  at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:144)
	  at java.lang.Thread.run(Thread.java:745)

```

数据读取完毕后，fireChannelRead方法

```
"nioEventLoopGroup-3-1@1302" prio=10 tid=0xe nid=NA runnable
  java.lang.Thread.State: RUNNABLE
	  at io.github.swimmingsand.EchoServerHandler.channelRead(EchoServerHandler.java:15)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:372)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:358)
	  at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:350)
	  at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1334)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:372)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:358)
	  at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:926)
	  at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:129)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:610)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:551)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:465)
	  at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:437)
	  at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:873)
	  at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:144)
	  at java.lang.Thread.run(Thread.java:745)
```

处理完数据读取后，发起fireChannelReadComplete方法

```
"nioEventLoopGroup-3-1@2154" prio=10 tid=0xe nid=NA runnable
  java.lang.Thread.State: RUNNABLE
	  at io.netty.channel.DefaultChannelPipeline$TailContext.channelReadComplete(DefaultChannelPipeline.java:1225)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:408)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:390)
	  at io.netty.channel.AbstractChannelHandlerContext.fireChannelReadComplete(AbstractChannelHandlerContext.java:383)
	  at io.netty.channel.DefaultChannelPipeline$HeadContext.channelReadComplete(DefaultChannelPipeline.java:1339)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:408)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:390)
	  at io.netty.channel.DefaultChannelPipeline.fireChannelReadComplete(DefaultChannelPipeline.java:932)
	  at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:134)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:610)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:551)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:465)
	  at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:437)
	  at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:873)
	  at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:144)
	  at java.lang.Thread.run(Thread.java:745)
```


数据写回到客户端

```
"nioEventLoopGroup-3-1@1302" prio=10 tid=0xe nid=NA runnable
  java.lang.Thread.State: RUNNABLE
	  at io.netty.channel.ChannelOutboundBuffer.incrementPendingOutboundBytes(ChannelOutboundBuffer.java:177)
	  at io.netty.channel.ChannelOutboundBuffer.addMessage(ChannelOutboundBuffer.java:131)
	  at io.netty.channel.AbstractChannel$AbstractUnsafe.write(AbstractChannel.java:810)
	  at io.netty.channel.DefaultChannelPipeline$HeadContext.write(DefaultChannelPipeline.java:1291)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeWrite0(AbstractChannelHandlerContext.java:748)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeWrite(AbstractChannelHandlerContext.java:740)
	  at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:826)
	  at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:733)
	  at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:714)
	  at io.github.swimmingsand.EchoServerHandler.channelRead(EchoServerHandler.java:15)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:372)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:358)
	  at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:350)
	  at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1334)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:372)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:358)
	  at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:926)
	  at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:129)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:610)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:551)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:465)
	  at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:437)
	  at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:873)
	  at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:144)
	  at java.lang.Thread.run(Thread.java:745)
```


是不是还有自动继续读

```
"nioEventLoopGroup-3-1@2154" prio=10 tid=0xe nid=NA runnable
  java.lang.Thread.State: RUNNABLE
	  at io.netty.channel.nio.AbstractNioChannel.doBeginRead(AbstractNioChannel.java:423)
	  at io.netty.channel.AbstractChannel$AbstractUnsafe.beginRead(AbstractChannel.java:769)
	  at io.netty.channel.DefaultChannelPipeline$HeadContext.read(DefaultChannelPipeline.java:1286)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeRead(AbstractChannelHandlerContext.java:703)
	  at io.netty.channel.AbstractChannelHandlerContext.read(AbstractChannelHandlerContext.java:683)
	  at io.netty.channel.DefaultChannelPipeline.read(DefaultChannelPipeline.java:1011)
	  at io.netty.channel.AbstractChannel.read(AbstractChannel.java:280)
	  at io.netty.channel.DefaultChannelPipeline$HeadContext.readIfIsAutoRead(DefaultChannelPipeline.java:1346)
	  at io.netty.channel.DefaultChannelPipeline$HeadContext.channelReadComplete(DefaultChannelPipeline.java:1341)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:408)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:390)
	  at io.netty.channel.DefaultChannelPipeline.fireChannelReadComplete(DefaultChannelPipeline.java:932)
	  at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:134)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:610)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:551)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:465)
	  at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:437)
	  at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:873)
	  at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:144)
	  at java.lang.Thread.run(Thread.java:745)
```


数据刷新到客户端

```
"nioEventLoopGroup-3-1@1302" prio=10 tid=0xe nid=NA runnable
  java.lang.Thread.State: RUNNABLE
	  at io.netty.channel.socket.nio.NioSocketChannel.doWrite(NioSocketChannel.java:413)
	  at io.netty.channel.AbstractChannel$AbstractUnsafe.flush0(AbstractChannel.java:856)
	  at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.flush0(AbstractNioChannel.java:362)
	  at io.netty.channel.AbstractChannel$AbstractUnsafe.flush(AbstractChannel.java:823)
	  at io.netty.channel.DefaultChannelPipeline$HeadContext.flush(DefaultChannelPipeline.java:1296)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeFlush0(AbstractChannelHandlerContext.java:786)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeFlush(AbstractChannelHandlerContext.java:778)
	  at io.netty.channel.AbstractChannelHandlerContext.flush(AbstractChannelHandlerContext.java:759)
	  at io.github.swimmingsand.EchoServerHandler.channelReadComplete(EchoServerHandler.java:20)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:408)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:390)
	  at io.netty.channel.AbstractChannelHandlerContext.fireChannelReadComplete(AbstractChannelHandlerContext.java:383)
	  at io.netty.channel.DefaultChannelPipeline$HeadContext.channelReadComplete(DefaultChannelPipeline.java:1339)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:408)
	  at io.netty.channel.AbstractChannelHandlerContext.invokeChannelReadComplete(AbstractChannelHandlerContext.java:390)
	  at io.netty.channel.DefaultChannelPipeline.fireChannelReadComplete(DefaultChannelPipeline.java:932)
	  at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:134)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:610)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:551)
	  at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:465)
	  at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:437)
	  at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:873)
	  at io.netty.util.concurrent.DefaultThreadFactory$DefaultRunnableDecorator.run(DefaultThreadFactory.java:144)
	  at java.lang.Thread.run(Thread.java:745)
```