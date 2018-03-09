有一个名称为readTask，类型为Runnable的字段，用于从socket读取数据

```
private final Runnable readTask = new Runnable() {
    @Override
    public void run() {
        if (!isReadPending() && !config().isAutoRead()) {
            // ChannelConfig.setAutoRead(false) was called in the meantime so just return
            return;
        }

        setReadPending(false);
        doRead();
    }
};
```

AbstractOioByteChannel.doRead方法有一个循环，循环读取数据，直到没有数据可读，循环中读取的数据放入PooledUnsafeDirectByteBuf类型的byteBuf

然后pipeline.fireChannelRead(byteBuf);

在后pipeline.fireChannelReadComplete();

```
    public ChannelPipeline fireChannelReadComplete() {
        head.fireChannelReadComplete();
        if (channel.config().isAutoRead()) {
            read();
        }
        return this;
    }
```

```
at io.netty.util.concurrent.SingleThreadEventExecutor.execute(SingleThreadEventExecutor.java:652)
at io.netty.channel.PausableChannelEventExecutor.execute(PausableChannelEventExecutor.java:326)
at io.netty.channel.oio.AbstractOioChannel.doBeginRead(AbstractOioChannel.java:101)
at io.netty.channel.AbstractChannel$AbstractUnsafe.beginRead(AbstractChannel.java:756)
at io.netty.channel.DefaultChannelPipeline$HeadContext.read(DefaultChannelPipeline.java:1273)
at io.netty.channel.ChannelHandlerInvokerUtil.invokeReadNow(ChannelHandlerInvokerUtil.java:150)
at io.netty.channel.DefaultChannelHandlerInvoker.invokeRead(DefaultChannelHandlerInvoker.java:309)
at io.netty.channel.PausableChannelEventExecutor.invokeRead(PausableChannelEventExecutor.java:127)
at io.netty.channel.AbstractChannelHandlerContext.read(AbstractChannelHandlerContext.java:526)
at io.netty.channel.DefaultChannelPipeline.read(DefaultChannelPipeline.java:1043)
at io.netty.channel.DefaultChannelPipeline.fireChannelReadComplete(DefaultChannelPipeline.java:964)
at io.netty.channel.oio.AbstractOioByteChannel.doRead(AbstractOioByteChannel.java:153)
at io.netty.channel.oio.AbstractOioChannel$1.run(AbstractOioChannel.java:44)
at io.netty.channel.ThreadPerChannelEventLoop.run(ThreadPerChannelEventLoop.java:52)
at io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:116)
at java.lang.Thread.run(Thread.java:745)
```

doBeginRead方法再次将readTask任务加入任务队列


ThreadPerChannelEventLoop.run()方法

一个无限循环。循环从任务队列取任务，然后执行任务



OioSocketChannel extends OioByteStreamChannel extends AbstractOioByteChannel



OioSocketChannel.doReadBytes --> OioByteStreamChannel.doReadBytes --> PooledUnsafeDirectByteBuf.writeBytes(InputStream in, int length) --> SocketInputStream.read(byte b[])