#ØMQ安装及简单实例实战

>会用到的一些工具
>libtool,autoconf,automake

##1.下载ØMQ的源代码

打开网站http://zeromq.org/intro:get-the-software

下载稳定版3.2.3的源代码文件包zeromq-3.2.3.tar.gz

##2.安装依赖库

	sudo apt-get install uuid-dev

##3.配置，编译，安装ØMQ的链接库
	进入zeromq-3.2.3.tar.gz所在目录
	tar -zxvf zeromq-3.2.3.tar.gz
	./configure
	make
	sudo make install

##4.编写构建在ØMQ之上的服务器

```
//  Hello server

#include <zmq.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <assert.h>

int main (void)
{
    void *context = zmq_ctx_new ();
    // Socket to talk to clients
    void *responder = zmq_socket (context, ZMQ_REP);
    int rc = zmq_bind (responder, "tcp://*:5555");
    assert (rc == 0);

    while (1) {
        char buffer [20]={'\0'};
        zmq_recv (responder, buffer, 20, 0);
        printf ("Received: %s\n",buffer);
        zmq_send (responder, "Hello, I'm server!", 18, 0);
        printf ("Sending: %s\n","Hello, I'm server!");
        sleep (1);
    }
    return 0;
}
```

构建服务器

	gcc zmqserver.c -lzmq -o zmqserver

运行服务器

	./zmqserver

##5.编写构建在ØMQ之上的客户端

```
//  Hello World client
#include <zmq.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>

int main (void)
{
    printf ("Connecting to hello server…\n");
    void *context = zmq_ctx_new ();
    void *requester = zmq_socket (context, ZMQ_REQ);
    zmq_connect (requester, "tcp://localhost:5555");

    char buffer [20]={'\0'};
    printf ("Sending: Hello, I'm client!\n");
    zmq_send (requester, "Hello, I'm client!", 18, 0);
    zmq_recv (requester, buffer, 20, 0);
    printf ("Received: %s\n",buffer);

    zmq_close (requester);
    zmq_ctx_destroy (context);
    return 0;
}
```

构建客户端

	gcc zmqclient.c -lzmq -o zmqclient

运行客户端

	./zmqclient

运行后输出

	Connecting to hello world server…
	Sending: Hello, I'm client!
	Received: Hello, I'm server!

