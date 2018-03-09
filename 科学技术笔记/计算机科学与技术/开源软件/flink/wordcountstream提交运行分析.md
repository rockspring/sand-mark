org.apache.flink.runtime.client.JobClient#submitJob

在[main]线程执行

创建org.apache.flink.runtime.client.JobSubmissionClientActor

然后发送消息org.apache.flink.runtime.messages.JobClientMessages.SubmitJobAndWait到org.apache.flink.runtime.client.JobSubmissionClientActor。

actor系统为akka://flink



org.apache.flink.runtime.client.JobSubmissionClientActor#tryToSubmitJob

org.apache.flink.runtime.client.JobSubmissionClientActor消息处理

org.apache.flink.runtime.client.JobSubmissionClientActor收到消息后使用方法org.apache.flink.runtime.client.JobSubmissionClientActor#handleCustomMessage处理org.apache.flink.runtime.messages.JobClientMessages.SubmitJobAndWait

创建actor网关AkkaActorGateway

上传uploadUserJars


往akka://flink/user/jobmanager_1系统的jobmanager这个actor发送消息org.apache.flink.runtime.messages.JobManagerMessages.SubmitJob


往jobmanager这个actor发送消息事在当前actor的线程池中的线程中执行的

JobManager处理消息org.apache.flink.runtime.messages.JobManagerMessages.SubmitJob

org.apache.flink.runtime.FlinkActor#receive
org.apache.flink.runtime.jobmanager.JobManager#handleMessage
org.apache.flink.runtime.jobmanager.JobManager#submitJob
