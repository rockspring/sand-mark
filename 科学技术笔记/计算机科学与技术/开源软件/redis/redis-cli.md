help.h

commandGroups

变量

字符串数组

commandHelp

变量

结构体数组

name、params、summary、group、since


redis-cli.c

helpEntry

结构体定义

type(int)、argc(int)、argv(sds *)、full(sds)、org(commandHelp *)


启动流程


解析命令行参数

连接服务器

不同的模式，连接服务器后进入不同的状态

客户端连接服务端后的连接信息保存在哪里呢？

hiredis.h

```
/* Context for a connection to Redis */
typedef struct redisContext {
    int err; /* Error flags, 0 when there is no error */
    char errstr[128]; /* String representation of error when applicable */
    int fd;
    int flags;
    char *obuf; /* Write buffer */
    redisReader *reader; /* Protocol reader */
} redisContext;
```

连接流程

redisConnect

redisContextConnectTcp

协议解析器的状态保存在哪里？

hiredis.h

```
/* State for the protocol parser */
typedef struct redisReader {
    int err; /* Error flags, 0 when there is no error */
    char errstr[128]; /* String representation of error when applicable */

    char *buf; /* Read buffer */
    size_t pos; /* Buffer cursor */
    size_t len; /* Buffer length */
    size_t maxbuf; /* Max length of unused buffer */

    redisReadTask rstack[9];
    int ridx; /* Index of current read task */
    void *reply; /* Temporary reply pointer */

    redisReplyObjectFunctions *fn;
    void *privdata;
} redisReader;
```


```
typedef struct redisReadTask {
    int type;
    int elements; /* number of elements in multibulk container */
    int idx; /* index in parent (array) object */
    void *obj; /* holds user-generated value for a read task */
    struct redisReadTask *parent; /* parent task */
    void *privdata; /* user-settable arbitrary field */
} redisReadTask;
```


```
typedef struct redisReplyObjectFunctions {
    void *(*createString)(const redisReadTask*, char*, size_t);
    void *(*createArray)(const redisReadTask*, int);
    void *(*createInteger)(const redisReadTask*, long long);
    void *(*createNil)(const redisReadTask*);
    void (*freeObject)(void*);
} redisReplyObjectFunctions;
```


