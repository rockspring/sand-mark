

## instance

org.apache.flink.runtime.instance.SimpleSlot

TaskManager的单个槽或共享槽中的一个槽。

### Slot

org.apache.flink.runtime.instance.Slot
org.apache.flink.runtime.instance.SimpleSlot
org.apache.flink.runtime.instance.SharedSlot

org.apache.flink.runtime.jobmanager.slots.SlotOwner
org.apache.flink.runtime.instance.Instance

## state

### StateObject

org.apache.flink.runtime.state.StateObject
org.apache.flink.runtime.state.StreamStateHandle
org.apache.flink.runtime.state.OperatorStateHandle

org.apache.flink.runtime.state.TaskStateHandles

一个任务的状态的所有句柄，用于恢复一个任务。Execution中有这个的引用。

## accumulators

org.apache.flink.runtime.accumulators.StringifiedAccumulatorResult

## execution

### ExecutionState

 *     CREATED  -> SCHEDULED -> DEPLOYING -> RUNNING -> FINISHED
 *            |         |            |          |
 *            |         |            |   +------+
 *            |         |            V   V
 *            |         |         CANCELLING -----+----> CANCELED
 *            |         |                         |
 *            |        +-------------------------+
 *            |
 *            |                                   ... -> FAILED
 *           V
 *    RECONCILING  -> RUNNING | FINISHED | CANCELED | FAILED

## executiongraph

org.apache.flink.runtime.executiongraph.Execution

org.apache.flink.runtime.iterative.task.IterationHeadTask#sendEventToSync
org.apache.flink.runtime.io.network.api.writer.ResultPartitionWriter#writeBufferToAllChannels
org.apache.flink.runtime.io.network.api.writer.ResultPartitionWriter#writeBuffer
org.apache.flink.runtime.io.network.partition.ResultPartition#add
org.apache.flink.runtime.io.network.partition.ResultPartition#notifyPipelinedConsumers
org.apache.flink.runtime.taskmanager.ActorGatewayResultPartitionConsumableNotifier#notifyPartitionConsumable
......actor消息队列
org.apache.flink.runtime.jobmanager.JobManager#handleMessage
org.apache.flink.runtime.messages.JobManagerMessages.ScheduleOrUpdateConsumers
org.apache.flink.runtime.jobmaster.JobMaster#scheduleOrUpdateConsumers
org.apache.flink.runtime.executiongraph.ExecutionGraph#scheduleOrUpdateConsumers
org.apache.flink.runtime.executiongraph.ExecutionVertex#scheduleOrUpdateConsumers
org.apache.flink.runtime.executiongraph.Execution#scheduleOrUpdateConsumers
org.apache.flink.runtime.executiongraph.ExecutionVertex#scheduleForExecution
org.apache.flink.runtime.executiongraph.Execution#scheduleForExecution
org.apache.flink.runtime.executiongraph.Execution#allocateSlotForExecution
org.apache.flink.runtime.jobmanager.scheduler.Scheduler#allocateSlot
org.apache.flink.runtime.jobmanager.scheduler.Scheduler#scheduleTask

表示一个计算节点vertex的单次执行，跟踪单次执行的状态。提交任务到taskmanager的方法为

org.apache.flink.runtime.iterative.task.IterationHeadTask#sendEventToSync
org.apache.flink.runtime.io.network.api.writer.ResultPartitionWriter#writeBufferToAllChannels
org.apache.flink.runtime.io.network.api.writer.ResultPartitionWriter#writeBuffer
org.apache.flink.runtime.io.network.partition.ResultPartition#add
org.apache.flink.runtime.io.network.partition.ResultPartition#notifyPipelinedConsumers
org.apache.flink.runtime.taskmanager.ActorGatewayResultPartitionConsumableNotifier#notifyPartitionConsumable
......actor消息队列
org.apache.flink.runtime.jobmanager.JobManager#handleMessage
org.apache.flink.runtime.messages.JobManagerMessages.ScheduleOrUpdateConsumers
org.apache.flink.runtime.jobmaster.JobMaster#scheduleOrUpdateConsumers
org.apache.flink.runtime.executiongraph.ExecutionGraph#scheduleOrUpdateConsumers
org.apache.flink.runtime.executiongraph.ExecutionVertex#scheduleOrUpdateConsumers
org.apache.flink.runtime.executiongraph.Execution#scheduleOrUpdateConsumers
org.apache.flink.runtime.executiongraph.ExecutionVertex#scheduleForExecution
org.apache.flink.runtime.executiongraph.Execution#scheduleForExecution
org.apache.flink.runtime.executiongraph.Execution#deployToSlot
org.apache.flink.runtime.jobmanager.slots.TaskManagerGateway#submitTask。

org.apache.flink.runtime.executiongraph.AccessExecution 访问一次任务执行的各种信息。

org.apache.flink.runtime.executiongraph.ExecutionAttemptID

org.apache.flink.runtime.executiongraph.IOMetrics

org.apache.flink.runtime.executiongraph.ArchivedExecution 执行的归档。

org.apache.flink.runtime.executiongraph.ExecutionVertex

执行实体的一个并行的子任务。

## execution.librarycache

### BlobLibraryCacheManager

BlobLibraryCacheManager定时清理引用数小于0的BlobKey关联的blob。由定时器Timer调度执行，执行间隔为cleanupInterval。

通过JobID返回关联的ClassLoader

通过BlobKey返回表示的文件

注册一个job，jar文件和classpath类路径。jar文件由BlobKey表示。

注册一个job任务执行，jar文件和classpath类路径。ExecutionAttemptID表示job执行。

org.apache.flink.runtime.execution.librarycache.LibraryCacheManager
org.apache.flink.runtime.execution.librarycache.BlobLibraryCacheManager

org.apache.flink.runtime.execution.librarycache.BlobLibraryCacheManager.LibraryCacheEntry

## io.network.buffer

### BufferPool

org.apache.flink.runtime.io.network.buffer.BufferPool

org.apache.flink.runtime.io.network.buffer.LocalBufferPool

org.apache.flink.runtime.io.network.buffer.BufferProvider

org.apache.flink.runtime.io.network.buffer.BufferRecycler

org.apache.flink.runtime.io.network.buffer.Buffer

org.apache.flink.runtime.io.network.buffer.BufferRecycler

org.apache.flink.runtime.io.network.buffer.FreeingBufferRecycler

org.apache.flink.runtime.io.network.buffer.BufferPoolFactory

org.apache.flink.runtime.io.network.buffer.NetworkBufferPool

org.apache.flink.runtime.io.network.buffer.BufferPoolOwner

```
org.apache.flink.runtime.io.network.partition.ResultPartition
```

LocalBufferPool从NetworkBufferPool获得buffer

numberOfRequiredMemorySegments 分配的network buffers最少个数

maxNumberOfMemorySegments之间，初始值为 分配的network buffers最大个数

currentPoolSize 当前分配的network buffers数量，介于numberOfRequiredMemorySegments和maxNumberOfMemorySegments之间，初始值为numberOfRequiredMemorySegments。

availableMemorySegments 可用的内存段

numberOfRequestedMemorySegments - availableMemorySegments.size() = 已经使用的内存段


org.apache.flink.runtime.io.network.buffer.LocalBufferPool#requestBuffer(boolean)
org.apache.flink.runtime.io.network.buffer.LocalBufferPool#returnExcessMemorySegments
org.apache.flink.runtime.io.network.buffer.LocalBufferPool#returnMemorySegment
org.apache.flink.runtime.io.network.buffer.NetworkBufferPool#recycle

org.apache.flink.runtime.io.network.buffer.LocalBufferPool#requestBuffer(boolean)
org.apache.flink.runtime.io.network.buffer.NetworkBufferPool#requestMemorySegment


Buffer包装一个MemorySegment。

org.apache.flink.runtime.io.network.partition.SpilledSubpartitionView#getNextBuffer
org.apache.flink.runtime.io.network.partition.SpilledSubpartitionView.SpillReadBufferPool#requestBufferBlocking
org.apache.flink.runtime.io.disk.iomanager.AsynchronousBufferFileReader#readInto
org.apache.flink.runtime.io.disk.iomanager.AsynchronousFileIOChannel#addRequest

## io.network.partition

### ResultPartition

org.apache.flink.runtime.io.network.buffer.BufferPoolOwner
org.apache.flink.runtime.io.network.partition.ResultPartition

org.apache.flink.runtime.io.network.partition.ResultSubpartition

## io.network.partition.consumer

### InputChannel

org.apache.flink.runtime.io.network.partition.consumer.InputChannel

org.apache.flink.runtime.io.network.partition.consumer.LocalInputChannel

org.apache.flink.runtime.io.network.partition.consumer.RemoteInputChannel

org.apache.flink.runtime.io.network.partition.consumer.UnknownInputChannel

org.apache.flink.runtime.io.network.partition.consumer.InputChannelID

org.apache.flink.runtime.io.network.partition.consumer.BufferOrEvent

org.apache.flink.runtime.io.network.partition.consumer.InputGate

org.apache.flink.runtime.io.network.partition.consumer.SingleInputGate

org.apache.flink.runtime.io.network.partition.consumer.InputGateListener

org.apache.flink.runtime.io.network.partition.consumer.UnionInputGate


org.apache.flink.runtime.io.network.api.reader.RecordReader#next
org.apache.flink.runtime.io.network.api.reader.RecordReader#hasNext
org.apache.flink.runtime.io.network.api.reader.AbstractRecordReader#getNextRecord

## io.network.api

org.apache.flink.runtime.io.network.api.TaskEventHandler

org.apache.flink.runtime.io.network.api.reader.RecordReader#next
org.apache.flink.runtime.io.network.api.reader.RecordReader#hasNext
org.apache.flink.runtime.io.network.api.reader.AbstractRecordReader#getNextRecord
org.apache.flink.runtime.io.network.api.reader.AbstractReader#handleEvent
org.apache.flink.runtime.io.network.api.TaskEventHandler#publish
org.apache.flink.runtime.util.event.EventListener#onEvent

org.apache.flink.runtime.taskmanager.Task#run
org.apache.flink.runtime.iterative.task.IterationSynchronizationSinkTask#invoke
org.apache.flink.runtime.io.network.api.reader.AbstractReader#registerTaskEventListener
org.apache.flink.runtime.io.network.api.TaskEventHandler#subscribe

org.apache.flink.runtime.io.network.api.EndOfPartitionEvent

org.apache.flink.runtime.io.network.api.EndOfSuperstepEvent

org.apache.flink.runtime.io.network.api.CheckpointBarrier

org.apache.flink.runtime.io.network.api.CancelCheckpointMarker

以上四个事件全部继承org.apache.flink.runtime.event.RuntimeEvent

## network.api.serialization

org.apache.flink.runtime.io.network.api.serialization.RecordSerializer

org.apache.flink.runtime.io.network.api.serialization.SpanningRecordSerializer

org.apache.flink.runtime.io.network.api.serialization.RecordDeserializer

org.apache.flink.runtime.io.network.api.serialization.SpillingAdaptiveSpanningRecordDeserializer

org.apache.flink.runtime.io.network.api.serialization.AdaptiveSpanningRecordDeserializer

org.apache.flink.runtime.io.network.api.serialization.EventSerializer

### SpanningRecordSerializer

将一个完整的记录序列化一个中转的序列化缓冲区（buffer），使用setNextBuffer方法将中转的序列化缓冲区（buffer）一个一个复制到目标缓冲区（buffer）


## io.network.api.reader

### Reader

org.apache.flink.runtime.io.network.api.reader.Reader

org.apache.flink.runtime.io.network.api.reader.ReaderBase

org.apache.flink.runtime.io.network.api.reader.AbstractReader

org.apache.flink.runtime.io.network.api.reader.AbstractRecordReader

org.apache.flink.runtime.io.network.api.reader.RecordReader

org.apache.flink.runtime.io.network.api.reader.MutableReader

org.apache.flink.runtime.io.network.api.reader.MutableRecordReader


org.apache.flink.runtime.iterative.task.IterationSynchronizationSinkTask#invoke
org.apache.flink.runtime.iterative.task.IterationSynchronizationSinkTask#sendToAllWorkers
org.apache.flink.runtime.io.network.api.reader.AbstractReader#sendTaskEvent
org.apache.flink.runtime.io.network.partition.consumer.SingleInputGate#sendTaskEvent
org.apache.flink.runtime.io.network.partition.consumer.RemoteInputChannel#sendTaskEvent
org.apache.flink.runtime.io.network.netty.PartitionRequestClient#sendTaskEvent
io.netty.channel.Channel#writeAndFlush(java.lang.Object)


## io.network.api.writer

### RecordWriter

面向记录的运行时结果写入器

RecordWriter包装了ResultPartitionWriter

掌管好记录序列化到缓冲区（buffer）。

org.apache.flink.runtime.io.network.api.writer.RecordWriter#sendToTarget

org.apache.flink.runtime.io.network.api.writer.RecordWriter#writeAndClearBuffer

```
org.apache.flink.runtime.taskmanager.Task#run
org.apache.flink.runtime.operators.BatchTask#invoke
org.apache.flink.runtime.operators.BatchTask#initOutputs()
org.apache.flink.runtime.operators.BatchTask#initOutputs(org.apache.flink.runtime.jobgraph.tasks.AbstractInvokable, java.lang.ClassLoader, org.apache.flink.runtime.operators.util.TaskConfig, java.util.List<org.apache.flink.runtime.operators.chaining.ChainedDriver<?,?>>, java.util.List<org.apache.flink.runtime.io.network.api.writer.RecordWriter<?>>, org.apache.flink.api.common.ExecutionConfig, java.util.Map<java.lang.String,org.apache.flink.api.common.accumulators.Accumulator<?,?>>)
org.apache.flink.runtime.operators.BatchTask#getOutputCollector(org.apache.flink.runtime.jobgraph.tasks.AbstractInvokable, org.apache.flink.runtime.operators.util.TaskConfig, java.lang.ClassLoader, java.util.List<org.apache.flink.runtime.io.network.api.writer.RecordWriter<?>>, int, int)
org.apache.flink.runtime.operators.shipping.OutputCollector#collect
org.apache.flink.runtime.io.network.api.writer.RecordWriter#emit
org.apache.flink.runtime.io.network.api.writer.RecordWriter#sendToTarget
org.apache.flink.runtime.io.network.api.writer.RecordWriter#writeAndClearBuffer
org.apache.flink.runtime.io.network.api.writer.ResultPartitionWriter#writeBuffer
org.apache.flink.runtime.io.network.partition.ResultPartition#add
org.apache.flink.runtime.io.network.partition.SpillableSubpartition#add
org.apache.flink.runtime.io.disk.iomanager.AsynchronousBlockWriterWithCallback#writeBlock
```

```
org.apache.flink.runtime.io.network.api.writer.RecordWriter#sendToTarget
org.apache.flink.runtime.io.network.api.writer.RecordWriter#writeAndClearBuffer
org.apache.flink.runtime.io.network.api.writer.ResultPartitionWriter#writeBuffer
org.apache.flink.runtime.io.network.partition.ResultPartition#add
org.apache.flink.runtime.io.network.partition.PipelinedSubpartition#add
org.apache.flink.runtime.io.network.partition.ResultPartition#notifyPipelinedConsumers
org.apache.flink.runtime.taskexecutor.rpc.RpcResultPartitionConsumableNotifier#notifyPartitionConsumable
org.apache.flink.runtime.jobmaster.JobMasterGateway#scheduleOrUpdateConsumers
```

```
org.apache.flink.runtime.io.network.api.writer.RecordWriter#sendToTarget
org.apache.flink.runtime.io.network.api.writer.RecordWriter#writeAndClearBuffer
org.apache.flink.runtime.io.network.api.writer.ResultPartitionWriter#writeBuffer
org.apache.flink.runtime.io.network.partition.ResultPartition#add
org.apache.flink.runtime.io.network.partition.PipelinedSubpartition#add
org.apache.flink.runtime.io.network.partition.ResultPartition#notifyPipelinedConsumers
org.apache.flink.runtime.taskmanager.ActorGatewayResultPartitionConsumableNotifier#notifyPartitionConsumable
org.apache.flink.runtime.messages.JobManagerMessages.ScheduleOrUpdateConsumers
org.apache.flink.runtime.instance.ActorGateway#ask
```

### ResultPartitionWriter

面向缓冲区（buffer）的运行时结果写入器。

org.apache.flink.runtime.io.network.api.writer.ResultPartitionWriter#writeBuffer

### ChannelSelector

决定一条记录应该写入哪个逻辑通道。

org.apache.flink.runtime.io.network.api.writer.RoundRobinChannelSelector



## tasks

### StreamTask

```
org.apache.flink.streaming.runtime.tasks.StreamTask#invoke
org.apache.flink.streaming.runtime.tasks.OneInputStreamTask#run
org.apache.flink.streaming.runtime.io.StreamInputProcessor#processInput
org.apache.flink.runtime.io.network.api.serialization.SpillingAdaptiveSpanningRecordDeserializer#getNextRecord
org.apache.flink.runtime.io.network.api.serialization.SpillingAdaptiveSpanningRecordDeserializer.NonSpanningWrapper#read(byte[], int, int)
org.apache.flink.runtime.io.network.api.serialization.SpillingAdaptiveSpanningRecordDeserializer.SpanningWrapper#initializeWithPartialRecord
org.apache.flink.runtime.io.network.api.serialization.SpillingAdaptiveSpanningRecordDeserializer.SpanningWrapper#createSpillingChannel
sun.nio.ch.FileChannelImpl#write(java.nio.ByteBuffer)
org.apache.flink.runtime.io.network.api.serialization.SpillingAdaptiveSpanningRecordDeserializer.SpanningWrapper#initializeWithPartialLength
org.apache.flink.runtime.io.network.api.serialization.SpillingAdaptiveSpanningRecordDeserializer.SpanningWrapper#getInputView
org.apache.flink.runtime.util.DataInputDeserializer
org.apache.flink.core.memory.DataInputViewStreamWrapper
org.apache.flink.runtime.io.network.api.serialization.SpillingAdaptiveSpanningRecordDeserializer.SpanningWrapper#moveRemainderToNonSpanningDeserializer
org.apache.flink.runtime.io.network.api.serialization.SpillingAdaptiveSpanningRecordDeserializer.NonSpanningWrapper#initializeFromMemorySegment
```

```
org.apache.flink.streaming.runtime.tasks.StreamTask#invoke
org.apache.flink.streaming.runtime.tasks.OneInputStreamTask#run
org.apache.flink.streaming.runtime.io.StreamInputProcessor#processInput
org.apache.flink.streaming.runtime.operators.windowing.WindowOperator#processElement
org.apache.flink.streaming.runtime.operators.windowing.WindowOperator.Context#onElement
org.apache.flink.streaming.api.windowing.triggers.EventTimeTrigger#onElement
```