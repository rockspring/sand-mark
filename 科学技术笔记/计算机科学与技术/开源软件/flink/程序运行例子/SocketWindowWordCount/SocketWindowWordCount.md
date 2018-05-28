## 客户端段代码执行过程


### org.apache.flink.streaming.api.graph.StreamingJobGraphGenerator#createJobGraph(org.apache.flink.streaming.api.graph.StreamGraph)

将StreamGraph转换成JobGraph


### org.apache.flink.client.program.StandaloneClusterClient#submitJob

提交JobGraph到集群

创建org.apache.flink.runtime.messages.JobClientMessages.SubmitJobAndWait消息，发送到集群的Actor系统中。

org.apache.flink.runtime.client.JobSubmissionClientActor处理这个条消息。

org.apache.flink.runtime.client.JobSubmissionClientActor#tryToSubmitJob将jobGraph提交到JobManager。

```
at org.apache.flink.runtime.client.JobClient.submitJob(JobClient.java:116)
at org.apache.flink.runtime.client.JobClient.submitJobAndWait(JobClient.java:378)
at org.apache.flink.client.program.ClusterClient.run(ClusterClient.java:481)
at org.apache.flink.client.program.StandaloneClusterClient.submitJob(StandaloneClusterClient.java:105)
at org.apache.flink.client.program.ClusterClient.run(ClusterClient.java:456)
at org.apache.flink.streaming.api.environment.StreamContextEnvironment.execute(StreamContextEnvironment.java:66)
at org.apache.flink.streaming.examples.socket.SocketWindowWordCount.main(SocketWindowWordCount.java:92)
at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-1)
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.lang.reflect.Method.invoke(Method.java:498)
at org.apache.flink.client.program.PackagedProgram.callMainMethod(PackagedProgram.java:525)
at org.apache.flink.client.program.PackagedProgram.invokeInteractiveModeForExecution(PackagedProgram.java:417)
at org.apache.flink.client.program.ClusterClient.run(ClusterClient.java:396)
at org.apache.flink.client.CliFrontend.executeProgram(CliFrontend.java:802)
at org.apache.flink.client.CliFrontend.run(CliFrontend.java:282)
at org.apache.flink.client.CliFrontend.parseParameters(CliFrontend.java:1054)
at org.apache.flink.client.CliFrontend$1.call(CliFrontend.java:1101)
at org.apache.flink.client.CliFrontend$1.call(CliFrontend.java:1098)
at org.apache.flink.runtime.security.HadoopSecurityContext$$Lambda$6.1916700921.run(Unknown Source:-1)
at java.security.AccessController.doPrivileged(AccessController.java:-1)
at javax.security.auth.Subject.doAs(Subject.java:422)
at org.apache.hadoop.security.UserGroupInformation.doAs(UserGroupInformation.java:1556)
at org.apache.flink.runtime.security.HadoopSecurityContext.runSecured(HadoopSecurityContext.java:41)
at org.apache.flink.client.CliFrontend.main(CliFrontend.java:1098)
```
