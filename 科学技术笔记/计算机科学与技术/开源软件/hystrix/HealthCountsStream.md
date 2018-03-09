# com.netflix.hystrix.metric.consumer.HealthCountsStream

```
BucketedCounterStream<Event extends HystrixEvent, Bucket, Output>
/|\
 |
 |
BucketedRollingCounterStream<HystrixCommandCompletion, long[], HystrixCommandMetrics.HealthCounts>
/|\
 |
 |
HealthCountsStream
```

健康数据快照的时间间隔，metricsHealthSnapshotIntervalInMilliseconds，单位为ms。healthCountBucketSizeInMs与快照时间间隔相等。统计桶的时间长度，桶的大小由时间这个时间长度内产生的数据决定。

metricsRollingStatisticalWindowInMilliseconds，用于统计的滚动窗口长度。numHealthCountBuckets = metricsRollingStatisticalWindowInMilliseconds / healthCountBucketSizeInMs;计算得出桶的数量。


com.netflix.hystrix.metric.consumer.HealthCountsStream#streams是一个ConcurrentHashMap<String, HealthCountsStream>()，存储在静态内存区，记录了所有命令的HealthCountsStream。key为HystrixCommandKey的名称。

com.netflix.hystrix.HystrixCommandMetrics#appendEventToBucket负责将数据从com.netflix.hystrix.metric.HystrixCommandCompletion获取com.netflix.hystrix.ExecutionResult.EventCounts

long[] initialCountArray保存每类事件的发生次数，事件类型的枚举值作为数组的下标索引。


com.netflix.hystrix.AbstractCommand#toObservable里定义的terminateCommandCleanup动作或unsubscribeCommandCleanup动作调用com.netflix.hystrix.AbstractCommand#handleCommandEnd，它调用com.netflix.hystrix.HystrixCommandMetrics#markCommandDone，它调用com.netflix.hystrix.metric.HystrixThreadEventStream#executionDone，它创建一个HystrixCommandCompletion，放入com.netflix.hystrix.metric.HystrixThreadEventStream#writeOnlyCommandCompletionSubject。

使用HystrixCommandCompletionStream


BucketedCounterStream的子类

public abstract class BucketedCumulativeCounterStream<Event extends HystrixEvent, Bucket, Output> extends BucketedCounterStream<Event, Bucket, Output>

public abstract class BucketedRollingCounterStream<Event extends HystrixEvent, Bucket, Output> extends BucketedCounterStream<Event, Bucket, Output>


BucketedCumulativeCounterStream的子类

public class CumulativeCollapserEventCounterStream extends BucketedCumulativeCounterStream<HystrixCollapserEvent, long[], long[]>

public class CumulativeCommandEventCounterStream extends BucketedCumulativeCounterStream<HystrixCommandCompletion, long[], long[]>

public class CumulativeThreadPoolEventCounterStream extends BucketedCumulativeCounterStream<HystrixCommandCompletion, long[], long[]>

BucketedRollingCounterStream的子类

public class HealthCountsStream extends BucketedRollingCounterStream<HystrixCommandCompletion, long[], HystrixCommandMetrics.HealthCounts>

public class RollingCollapserEventCounterStream extends BucketedRollingCounterStream<HystrixCollapserEvent, long[], long[]>

public class RollingCommandEventCounterStream extends BucketedRollingCounterStream<HystrixCommandCompletion, long[], long[]>

public class RollingThreadPoolEventCounterStream extends BucketedRollingCounterStream<HystrixCommandCompletion, long[], long[]>


它的输入源为HystrixEventStream<E extends HystrixEvent>

public class HystrixCollapserEventStream implements HystrixEventStream<HystrixCollapserEvent>

public class HystrixCommandCompletionStream implements HystrixEventStream<HystrixCommandCompletion>

public class HystrixCommandStartStream implements HystrixEventStream<HystrixCommandExecutionStarted>

public class HystrixThreadPoolCompletionStream implements HystrixEventStream<HystrixCommandCompletion>

public class HystrixThreadPoolStartStream implements HystrixEventStream<HystrixCommandExecutionStarted>
