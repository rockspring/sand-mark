# HystrixCircuitBreaker

断路器

## 断路器接口

```
/**
 * Circuit-breaker logic that is hooked into {@link HystrixCommand} execution and will stop allowing executions if failures have gone past the defined threshold.
 * <p>
 * The default (and only) implementation  will then allow a single retry after a defined sleepWindow until the execution
 * succeeds at which point it will again close the circuit and allow executions again.
 */
public interface HystrixCircuitBreaker {

    /**
     * Every {@link HystrixCommand} requests asks this if it is allowed to proceed or not.  It is idempotent and does
     * not modify any internal state, and takes into account the half-open logic which allows some requests through
     * after the circuit has been opened
     * 
     * @return boolean whether a request should be permitted
     */
    boolean allowRequest();

    /**
     * Whether the circuit is currently open (tripped).
     * 
     * @return boolean state of circuit breaker
     */
    boolean isOpen();

    /**
     * Invoked on successful executions from {@link HystrixCommand} as part of feedback mechanism when in a half-open state.
     */
    void markSuccess();

    /**
     * Invoked on unsuccessful executions from {@link HystrixCommand} as part of feedback mechanism when in a half-open state.
     */
    void markNonSuccess();

    /**
     * Invoked at start of command execution to attempt an execution.  This is non-idempotent - it may modify internal
     * state.
     */
    boolean attemptExecution();
}
```

## markSuccess

如果当前的状态是HALF_OPEN，则改成CLOSED

使用com.netflix.hystrix.HystrixCommandMetrics#resetStream方法重置统计模块的数据。

如果当前状态是OPEN，不用管。

如果当前状态是CLOSED，则保持。

## markNonSuccess

如果当前的状态是HALF_OPEN，则改成OPEN。

circuitOpened设置为当前时间。

## attemptExecution

命令开始执行时首先调用attemptExecution方法判定是否可以尝试执行。

如果circuitBreaker.forceOpen属性设置为true，则不能执行。

如果circuitBreaker.forceClosed属性设置为true，则可以执行。

如果circuitOpened的值为-1，则可以执行。circuitOpened记录断路器断开的时间，-1表示已经关闭。

如果circuitOpened的值为大于或等于0，则表示断路器在某个时间点断开了。调用isAfterSleepWindow方法检查是否一个休眠窗口期内。休眠多长时间由“circuitBreaker.sleepWindowInMilliseconds”属性配置决定。如果还在休眠期，则不能执行。如果已经过了休眠期并且断路器在OPEN状态，则将状态改成HALF_OPEN，本次执行可以尝试。如果已经过了休眠期但断路器不在OPEN状态，则不能执行。

## com.netflix.hystrix.HystrixCommandMetrics.HealthCounts

滚动窗口（rolling window）的统计数据。

```
totalCount = successCount + failureCount + timeoutCount + threadPoolRejectedCount + semaphoreRejectedCount

errorCount = failureCount + timeoutCount + threadPoolRejectedCount + semaphoreRejectedCount

errorPercentage = errorCount / totalCount * 100
```