

channelRead方法什么时候被调用？

This method is called with the received message, whenever new data is received from a client.


exceptionCaught方法什么时候被调用？

The exceptionCaught() event handler method is called with a Throwable when an exception was raised by Netty due to an I/O error or by a handler implementation due to the exception thrown while processing events. 

# netty使用规范

Please keep in mind that it is the handler's responsibility to release any reference-counted object passed to the handler.

```
@Override
public void channelRead(ChannelHandlerContext ctx, Object msg) {
    try {
        // Do something with msg
    } finally {
        ReferenceCountUtil.release(msg);
    }
}
```

如果调用了ctx.write方法，不需要调用release方法，因为netty将写入到网络协议线后回释放msg对象

ctx.write方法只是吧数据写入到netty的buffer，还需要调用ctx.flush将buffer的数据写入到网络协议栈

## 在exceptionCaught方法中把连接关闭

```
// Close the connection when an exception is raised.
cause.printStackTrace();
ctx.close();
```

# 如何处理基于流的数据传输

TCP/IP这类基于流的传输，接收的数据保存在一个socket接收缓冲区。然后，很不幸，缓冲区不是一个包（packet）组成的队列，而是一个字节（byte）组成的队列

这意味着什么？你发送了两个独立的消息包（packet），操作系统不会把它们看成两个消息包，而是一捆字节。这就没法保证你读取数据刚好是远程客户端发送的一个消息包

ByteToMessageDecoder使得netty很容易处理数据分段问题