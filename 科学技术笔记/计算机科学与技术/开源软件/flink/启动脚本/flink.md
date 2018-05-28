

```
bin/flink info examples/batch/WordCount.jar

nc -l 8000
bin/flink run examples/streaming/SocketWindowWordCount.jar --hostname localhost --port 8000

bin/flink list

bin/flink savepoint ad8e8a3277507060a073bce03a44fc7c savepoint

bin/flink cancel 671f0bd72f92835ab75aefe7c3840743

bin/flink stop 671f0bd72f92835ab75aefe7c3840743
```

## IDEA里面debug

```
org.apache.flink.client.CliFrontend

FLINK_CONF_DIR=/Users/zlq/Projects/oss/BigData/flink/build-target/conf

run --class org.apache.flink.streaming.examples.socket.SocketWindowWordCount /Users/zlq/Projects/oss/BigData/flink/build-target/examples/streaming/SocketWindowWordCount.jar --hostname localhost --port 8000
```


org.apache.flink.runtime.execution.librarycache.FlinkUserCodeClassLoaders.ParentFirstClassLoader是运行时需要的。


jobManagerRpcUrl=akka.tcp://flink@localhost:6123/user/jobmanager

resourceManagerRpcUrl=akka.tcp://flink@localhost:6123/user/resourcemanager

dispatcherRpcUrl=akka.tcp://flink@localhost:6123/user/dispatcher

