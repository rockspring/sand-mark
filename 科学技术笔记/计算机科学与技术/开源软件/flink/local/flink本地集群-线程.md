2017-04-04 17:22:58
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.60-b23 mixed mode):

"Attach Listener" #422 daemon prio=9 os_prio=31 tid=0x00007fe6a028a800 nid=0xb327 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"flink-akka.actor.default-dispatcher-67" #418 daemon prio=5 os_prio=31 tid=0x00007fe6a0a43800 nid=0xaa23 waiting on condition [0x00007000015d5000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000007446d80b8> (a akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2075)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"flink-akka.actor.default-dispatcher-66" #417 daemon prio=5 os_prio=31 tid=0x00007fe6a0a3a800 nid=0xb703 waiting on condition [0x000070000486b000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000007446d80b8> (a akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.idleAwaitWork(ForkJoinPool.java:2135)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2067)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"flink-akka.remote.default-remote-dispatcher-115" #416 daemon prio=5 os_prio=31 tid=0x00007fe6a0a39800 nid=0x56a7 waiting on condition [0x0000700004768000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000007403b7e28> (a akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2075)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"flink-akka.remote.default-remote-dispatcher-65" #413 daemon prio=5 os_prio=31 tid=0x00007fe6a02c0000 nid=0x5573 waiting on condition [0x0000700004156000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000007405413d0> (a akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2075)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"flink-akka.remote.default-remote-dispatcher-124" #415 daemon prio=5 os_prio=31 tid=0x00007fe6a02bf800 nid=0xb41b waiting on condition [0x0000700003635000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000740217c08> (a akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2075)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"flink-akka.remote.default-remote-dispatcher-87" #414 daemon prio=5 os_prio=31 tid=0x00007fe69ab32000 nid=0xad27 waiting on condition [0x0000700002e1d000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000007403e6a78> (a akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2075)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"flink-akka.remote.default-remote-dispatcher-114" #412 daemon prio=5 os_prio=31 tid=0x00007fe69fc40000 nid=0x6b87 waiting on condition [0x00007000016d8000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000007403b7e28> (a akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.idleAwaitWork(ForkJoinPool.java:2135)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2067)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"flink-akka.remote.default-remote-dispatcher-86" #411 daemon prio=5 os_prio=31 tid=0x00007fe69a91f000 nid=0xa82b waiting on condition [0x000070000393e000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000007403e6a78> (a akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.idleAwaitWork(ForkJoinPool.java:2135)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2067)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"flink-akka.remote.default-remote-dispatcher-62" #405 daemon prio=5 os_prio=31 tid=0x00007fe69abda000 nid=0xaf33 waiting on condition [0x0000700002605000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000007405413d0> (a akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.idleAwaitWork(ForkJoinPool.java:2135)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2067)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"flink-akka.remote.default-remote-dispatcher-121" #387 daemon prio=5 os_prio=31 tid=0x00007fe69bbb5000 nid=0xb60f waiting on condition [0x000070000435c000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000740217c08> (a akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.idleAwaitWork(ForkJoinPool.java:2135)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2067)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"ForkJoinPool-1-worker-5" #329 daemon prio=5 os_prio=31 tid=0x00007fe69a9fe000 nid=0xb103 waiting on condition [0x0000700004562000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000007401812f0> (a scala.concurrent.forkjoin.ForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2075)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"Timer-1" #328 daemon prio=5 os_prio=31 tid=0x00007fe69ac2f800 nid=0x8257 in Object.wait() [0x000070000445f000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at java.util.TimerThread.mainLoop(Timer.java:552)
	- locked <0x00000007447b1340> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

   Locked ownable synchronizers:
	- None

"mini-cluster-future-thread-1" #326 daemon prio=5 os_prio=31 tid=0x00007fe69b44b000 nid=0x714f waiting on condition [0x0000700004053000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000740180160> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1081)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"Hashed wheel timer #4" #223 daemon prio=5 os_prio=31 tid=0x00007fe69bf66000 nid=0x7253 sleeping[0x00007000023ff000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
	at java.lang.Thread.sleep(Native Method)
	at org.jboss.netty.util.HashedWheelTimer$Worker.waitForNextTick(HashedWheelTimer.java:483)
	at org.jboss.netty.util.HashedWheelTimer$Worker.run(HashedWheelTimer.java:392)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"IOManager reader thread #1" #274 daemon prio=5 os_prio=31 tid=0x00007fe69c236800 nid=0x981b waiting on condition [0x000070000383b000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000744542b40> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.flink.runtime.io.disk.iomanager.IOManagerAsync$ReaderThread.run(IOManagerAsync.java:380)

   Locked ownable synchronizers:
	- None

"IOManager writer thread #1" #273 daemon prio=5 os_prio=31 tid=0x00007fe69bf70000 nid=0x9717 waiting on condition [0x0000700003738000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000744542778> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.flink.runtime.io.disk.iomanager.IOManagerAsync$WriterThread.run(IOManagerAsync.java:486)

   Locked ownable synchronizers:
	- None

"New I/O server boss #24" #227 daemon prio=5 os_prio=31 tid=0x00007fe69b1cf000 nid=0xa403 runnable [0x0000700003f50000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000007405953d0> (a sun.nio.ch.Util$2)
	- locked <0x00000007405953c0> (a java.util.Collections$UnmodifiableSet)
	- locked <0x0000000740594fb0> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.jboss.netty.channel.socket.nio.NioServerBoss.select(NioServerBoss.java:163)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.NioServerBoss.run(NioServerBoss.java:42)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000740594c90> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #23" #226 daemon prio=5 os_prio=31 tid=0x00007fe69bfa7800 nid=0xa203 runnable [0x0000700003e4d000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x0000000740595838> (a sun.nio.ch.Util$2)
	- locked <0x0000000740595828> (a java.util.Collections$UnmodifiableSet)
	- locked <0x0000000740595708> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000740595568> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #22" #225 daemon prio=5 os_prio=31 tid=0x00007fe69c50f000 nid=0xa003 runnable [0x0000700003d4a000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000007445366d0> (a sun.nio.ch.Util$2)
	- locked <0x00000007445366c0> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000007445365a0> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000744536250> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O boss #21" #224 daemon prio=5 os_prio=31 tid=0x00007fe69c225800 nid=0x9e03 runnable [0x0000700003c47000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x000000074450ee70> (a sun.nio.ch.Util$2)
	- locked <0x000000074450ee60> (a java.util.Collections$UnmodifiableSet)
	- locked <0x000000074450ed30> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.NioClientBoss.run(NioClientBoss.java:42)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x000000074450e9e8> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #20" #222 daemon prio=5 os_prio=31 tid=0x00007fe69bf85000 nid=0x9c03 runnable [0x0000700003b44000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x0000000740595dd8> (a sun.nio.ch.Util$2)
	- locked <0x0000000740595dc8> (a java.util.Collections$UnmodifiableSet)
	- locked <0x0000000740595ca8> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000740595938> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #19" #221 daemon prio=5 os_prio=31 tid=0x00007fe69bdda000 nid=0x9a03 runnable [0x0000700003a41000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x0000000740596178> (a sun.nio.ch.Util$2)
	- locked <0x0000000740596168> (a java.util.Collections$UnmodifiableSet)
	- locked <0x0000000740596048> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000740595ad0> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"flink-scheduler-1" #215 daemon prio=5 os_prio=31 tid=0x00007fe69b1c1000 nid=0x5743 sleeping[0x0000700002d1a000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
	at java.lang.Thread.sleep(Native Method)
	at akka.actor.LightArrayRevolverScheduler.waitNanos(Scheduler.scala:231)
	at akka.actor.LightArrayRevolverScheduler$$anon$8.nextTick(Scheduler.scala:411)
	at akka.actor.LightArrayRevolverScheduler$$anon$8.run(Scheduler.scala:381)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"flink-akka.actor.default-dispatcher-30" #197 daemon prio=5 os_prio=31 tid=0x00007fe69c226000 nid=0x696b waiting on condition [0x0000700001ef0000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000074049b628> (a akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2075)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"New I/O server boss #18" #148 daemon prio=5 os_prio=31 tid=0x00007fe69ab7f000 nid=0x8e03 runnable [0x000070000342f000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000007404dc7e0> (a sun.nio.ch.Util$2)
	- locked <0x00000007404dc7d0> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000007404dc630> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.jboss.netty.channel.socket.nio.NioServerBoss.select(NioServerBoss.java:163)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.NioServerBoss.run(NioServerBoss.java:42)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000007404dc598> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #17" #147 daemon prio=5 os_prio=31 tid=0x00007fe69a926000 nid=0x8c03 runnable [0x000070000332c000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000007404dc0d8> (a sun.nio.ch.Util$2)
	- locked <0x00000007404dc0c8> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000007404dbf98> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000007404dbf00> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #16" #146 daemon prio=5 os_prio=31 tid=0x00007fe69c23b800 nid=0x8a03 runnable [0x0000700003229000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000007403bbfb0> (a sun.nio.ch.Util$2)
	- locked <0x00000007403bbfa0> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000007403bbe80> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000007403bbb30> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O boss #15" #145 daemon prio=5 os_prio=31 tid=0x00007fe69c23b000 nid=0x8803 runnable [0x0000700003126000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x0000000740408100> (a sun.nio.ch.Util$2)
	- locked <0x00000007404080f0> (a java.util.Collections$UnmodifiableSet)
	- locked <0x0000000740407fc0> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.NioClientBoss.run(NioClientBoss.java:42)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000740407c78> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #14" #143 daemon prio=5 os_prio=31 tid=0x00007fe69a925800 nid=0x8603 runnable [0x0000700003023000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000007404939e8> (a sun.nio.ch.Util$2)
	- locked <0x00000007404939d8> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000007404938b8> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000740493568> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #13" #142 daemon prio=5 os_prio=31 tid=0x00007fe69b1c5800 nid=0x8403 runnable [0x0000700002f20000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x0000000740493f50> (a sun.nio.ch.Util$2)
	- locked <0x0000000740493f40> (a java.util.Collections$UnmodifiableSet)
	- locked <0x0000000740493e20> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000740493ad0> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"flink-scheduler-1" #137 daemon prio=5 os_prio=31 tid=0x00007fe69b19e000 nid=0x6e27 sleeping[0x00007000021f9000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
	at java.lang.Thread.sleep(Native Method)
	at akka.actor.LightArrayRevolverScheduler.waitNanos(Scheduler.scala:231)
	at akka.actor.LightArrayRevolverScheduler$$anon$8.nextTick(Scheduler.scala:411)
	at akka.actor.LightArrayRevolverScheduler$$anon$8.run(Scheduler.scala:381)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"New I/O server boss #12" #69 daemon prio=5 os_prio=31 tid=0x00007fe69bddb800 nid=0x7e03 runnable [0x0000700002c17000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000007403d0790> (a sun.nio.ch.Util$2)
	- locked <0x00000007403d0780> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000007403d0370> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.jboss.netty.channel.socket.nio.NioServerBoss.select(NioServerBoss.java:163)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.NioServerBoss.run(NioServerBoss.java:42)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000007403d0018> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #11" #68 daemon prio=5 os_prio=31 tid=0x00007fe69a973000 nid=0x7c03 runnable [0x0000700002b14000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000007403b92e0> (a sun.nio.ch.Util$2)
	- locked <0x00000007403b92d0> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000007403b91b0> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000007403b8e60> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #10" #67 daemon prio=5 os_prio=31 tid=0x00007fe69b55a000 nid=0x7a03 runnable [0x0000700002a11000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000007403cf6c0> (a sun.nio.ch.Util$2)
	- locked <0x00000007403cf6b0> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000007403cf590> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000007403cf240> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O boss #9" #66 daemon prio=5 os_prio=31 tid=0x00007fe69ba70000 nid=0x7803 runnable [0x000070000290e000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000007403d4368> (a sun.nio.ch.Util$2)
	- locked <0x00000007403d4358> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000007403d4228> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.NioClientBoss.run(NioClientBoss.java:42)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000007403d3ee0> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #8" #64 daemon prio=5 os_prio=31 tid=0x00007fe69a887800 nid=0x7603 runnable [0x000070000280b000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x0000000740490a80> (a sun.nio.ch.Util$2)
	- locked <0x0000000740490a70> (a java.util.Collections$UnmodifiableSet)
	- locked <0x0000000740490940> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000007404908a8> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #7" #63 daemon prio=5 os_prio=31 tid=0x00007fe69c239800 nid=0x7403 runnable [0x0000700002708000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x0000000740490da8> (a sun.nio.ch.Util$2)
	- locked <0x0000000740490d98> (a java.util.Collections$UnmodifiableSet)
	- locked <0x0000000740490c68> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000740490858> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"flink-akka.actor.default-dispatcher-3" #59 daemon prio=5 os_prio=31 tid=0x00007fe69c43e000 nid=0x6c03 waiting on condition [0x00007000022fc000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x0000000740497598> (a akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2075)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"flink-scheduler-1" #57 daemon prio=5 os_prio=31 tid=0x00007fe69a974000 nid=0x3b3b sleeping[0x00007000020f6000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
	at java.lang.Thread.sleep(Native Method)
	at akka.actor.LightArrayRevolverScheduler.waitNanos(Scheduler.scala:231)
	at akka.actor.LightArrayRevolverScheduler$$anon$8.nextTick(Scheduler.scala:411)
	at akka.actor.LightArrayRevolverScheduler$$anon$8.run(Scheduler.scala:381)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"flink-akka.actor.default-dispatcher-33" #48 daemon prio=5 os_prio=31 tid=0x00007fe69c43e800 nid=0x6533 waiting on condition [0x0000700001ff3000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000074021a278> (a akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinPool)
	at scala.concurrent.forkjoin.ForkJoinPool.scan(ForkJoinPool.java:2075)
	at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
	at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)

   Locked ownable synchronizers:
	- None

"Timer-0" #36 daemon prio=5 os_prio=31 tid=0x00007fe69b1e4800 nid=0x533b in Object.wait() [0x00007000017db000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at java.util.TimerThread.mainLoop(Timer.java:552)
	- locked <0x00000007403a33c0> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

   Locked ownable synchronizers:
	- None

"BLOB Server listener at 54375" #34 daemon prio=5 os_prio=31 tid=0x00007fe69a86f000 nid=0x3573 runnable [0x00007000014d2000]
   java.lang.Thread.State: RUNNABLE
	at java.net.PlainSocketImpl.socketAccept(Native Method)
	at java.net.AbstractPlainSocketImpl.accept(AbstractPlainSocketImpl.java:409)
	at java.net.ServerSocket.implAccept(ServerSocket.java:545)
	at java.net.ServerSocket.accept(ServerSocket.java:513)
	at org.apache.flink.runtime.blob.BlobServer.run(BlobServer.java:249)

   Locked ownable synchronizers:
	- None

"New I/O server boss #6" #24 daemon prio=5 os_prio=31 tid=0x00007fe69c429800 nid=0x6203 runnable [0x0000700001ded000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x0000000740216238> (a sun.nio.ch.Util$2)
	- locked <0x0000000740216228> (a java.util.Collections$UnmodifiableSet)
	- locked <0x0000000740216098> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.jboss.netty.channel.socket.nio.NioServerBoss.select(NioServerBoss.java:163)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.NioServerBoss.run(NioServerBoss.java:42)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000740215d40> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #5" #23 daemon prio=5 os_prio=31 tid=0x00007fe69aa0b000 nid=0x6003 runnable [0x0000700001cea000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000007402136c8> (a sun.nio.ch.Util$2)
	- locked <0x00000007402136b8> (a java.util.Collections$UnmodifiableSet)
	- locked <0x0000000740213598> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000740213248> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #4" #22 daemon prio=5 os_prio=31 tid=0x00007fe69a8bd800 nid=0x5e03 runnable [0x0000700001be7000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x0000000740213160> (a sun.nio.ch.Util$2)
	- locked <0x0000000740213150> (a java.util.Collections$UnmodifiableSet)
	- locked <0x0000000740213030> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000740212a28> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O boss #3" #21 daemon prio=5 os_prio=31 tid=0x00007fe69c428000 nid=0x5c03 runnable [0x0000700001ae4000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x000000074021cbd8> (a sun.nio.ch.Util$2)
	- locked <0x000000074021cbc8> (a java.util.Collections$UnmodifiableSet)
	- locked <0x000000074021ca98> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.NioClientBoss.run(NioClientBoss.java:42)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000740211d40> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #2" #19 daemon prio=5 os_prio=31 tid=0x00007fe69b341000 nid=0x5a03 runnable [0x00007000019e1000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x0000000740211c48> (a sun.nio.ch.Util$2)
	- locked <0x0000000740211c38> (a java.util.Collections$UnmodifiableSet)
	- locked <0x0000000740211b18> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000007402115c0> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"New I/O worker #1" #18 daemon prio=5 os_prio=31 tid=0x00007fe69bbc6000 nid=0x5803 runnable [0x00007000018de000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.KQueueArrayWrapper.kevent0(Native Method)
	at sun.nio.ch.KQueueArrayWrapper.poll(KQueueArrayWrapper.java:198)
	at sun.nio.ch.KQueueSelectorImpl.doSelect(KQueueSelectorImpl.java:103)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000007402118a8> (a sun.nio.ch.Util$2)
	- locked <0x0000000740211898> (a java.util.Collections$UnmodifiableSet)
	- locked <0x0000000740211778> (a sun.nio.ch.KQueueSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.jboss.netty.channel.socket.nio.SelectorUtil.select(SelectorUtil.java:68)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.select(AbstractNioSelector.java:415)
	at org.jboss.netty.channel.socket.nio.AbstractNioSelector.run(AbstractNioSelector.java:212)
	at org.jboss.netty.channel.socket.nio.AbstractNioWorker.run(AbstractNioWorker.java:89)
	at org.jboss.netty.channel.socket.nio.NioWorker.run(NioWorker.java:178)
	at org.jboss.netty.util.ThreadRenamingRunnable.run(ThreadRenamingRunnable.java:108)
	at org.jboss.netty.util.internal.DeadLockProofWorker$1.run(DeadLockProofWorker.java:42)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x0000000740211408> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"flink-scheduler-1" #13 daemon prio=5 os_prio=31 tid=0x00007fe69a978000 nid=0x1307 sleeping[0x00007000013cf000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
	at java.lang.Thread.sleep(Native Method)
	at akka.actor.LightArrayRevolverScheduler.waitNanos(Scheduler.scala:231)
	at akka.actor.LightArrayRevolverScheduler$$anon$8.nextTick(Scheduler.scala:411)
	at akka.actor.LightArrayRevolverScheduler$$anon$8.run(Scheduler.scala:381)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"Service Thread" #11 daemon prio=9 os_prio=31 tid=0x00007fe69b063000 nid=0x4e03 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"C1 CompilerThread2" #10 daemon prio=9 os_prio=31 tid=0x00007fe69a826800 nid=0x4c03 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"C2 CompilerThread1" #9 daemon prio=9 os_prio=31 tid=0x00007fe69a823000 nid=0x4a03 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"C2 CompilerThread0" #8 daemon prio=9 os_prio=31 tid=0x00007fe69b05a800 nid=0x4803 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"JDWP Command Reader" #7 daemon prio=10 os_prio=31 tid=0x00007fe69b059800 nid=0x4603 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"JDWP Event Helper Thread" #6 daemon prio=10 os_prio=31 tid=0x00007fe69a822000 nid=0x4403 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"JDWP Transport Listener: dt_socket" #5 daemon prio=10 os_prio=31 tid=0x00007fe69b059000 nid=0x4203 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"Signal Dispatcher" #4 daemon prio=9 os_prio=31 tid=0x00007fe69b003800 nid=0x380f runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"Finalizer" #3 daemon prio=8 os_prio=31 tid=0x00007fe69b800800 nid=0x3003 in Object.wait() [0x000070000092e000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
	- locked <0x0000000740008088> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
	at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)

   Locked ownable synchronizers:
	- None

"Reference Handler" #2 daemon prio=10 os_prio=31 tid=0x00007fe69a818000 nid=0x2e03 in Object.wait() [0x000070000082b000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at java.lang.Object.wait(Object.java:502)
	at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:157)
	- locked <0x0000000740009ec0> (a java.lang.ref.Reference$Lock)

   Locked ownable synchronizers:
	- None

"main" #1 prio=5 os_prio=31 tid=0x00007fe69b00a000 nid=0x1703 runnable [0x0000700000218000]
   java.lang.Thread.State: RUNNABLE
	at java.io.FileInputStream.read0(Native Method)
	at java.io.FileInputStream.read(FileInputStream.java:207)
	at scala.tools.jline.TerminalSupport.readCharacter(TerminalSupport.java:152)
	at scala.tools.jline.UnixTerminal.readVirtualKey(UnixTerminal.java:125)
	at scala.tools.jline.console.ConsoleReader.readVirtualKey(ConsoleReader.java:933)
	at scala.tools.jline.console.ConsoleReader.readBinding(ConsoleReader.java:1136)
	at scala.tools.jline.console.ConsoleReader.readLine(ConsoleReader.java:1218)
	at scala.tools.jline.console.ConsoleReader.readLine(ConsoleReader.java:1170)
	at scala.tools.nsc.interpreter.JLineReader.readOneLine(JLineReader.scala:74)
	at scala.tools.nsc.interpreter.InteractiveReader$$anonfun$readLine$2.apply(InteractiveReader.scala:42)
	at scala.tools.nsc.interpreter.InteractiveReader$$anonfun$readLine$2.apply(InteractiveReader.scala:42)
	at scala.tools.nsc.interpreter.InteractiveReader$.restartSysCalls(InteractiveReader.scala:49)
	at scala.tools.nsc.interpreter.InteractiveReader$class.readLine(InteractiveReader.scala:42)
	at scala.tools.nsc.interpreter.JLineReader.readLine(JLineReader.scala:19)
	at scala.tools.nsc.interpreter.ILoop.readOneLine$1(ILoop.scala:572)
	at scala.tools.nsc.interpreter.ILoop.innerLoop$1(ILoop.scala:588)
	at scala.tools.nsc.interpreter.ILoop.loop(ILoop.scala:591)
	at scala.tools.nsc.interpreter.ILoop$$anonfun$process$1.apply$mcZ$sp(ILoop.scala:882)
	at scala.tools.nsc.interpreter.ILoop$$anonfun$process$1.apply(ILoop.scala:837)
	at scala.tools.nsc.interpreter.ILoop$$anonfun$process$1.apply(ILoop.scala:837)
	at scala.tools.nsc.util.ScalaClassLoader$.savingContextLoader(ScalaClassLoader.scala:135)
	at scala.tools.nsc.interpreter.ILoop.process(ILoop.scala:837)
	at org.apache.flink.api.scala.FlinkShell$.startShell(FlinkShell.scala:217)
	at org.apache.flink.api.scala.FlinkShell$.main(FlinkShell.scala:136)
	at org.apache.flink.api.scala.FlinkShell.main(FlinkShell.scala)

   Locked ownable synchronizers:
	- None

"VM Thread" os_prio=31 tid=0x00007fe69c026000 nid=0x2c03 runnable

"GC task thread#0 (ParallelGC)" os_prio=31 tid=0x00007fe69a811800 nid=0x2403 runnable

"GC task thread#1 (ParallelGC)" os_prio=31 tid=0x00007fe69a812000 nid=0x2603 runnable

"GC task thread#2 (ParallelGC)" os_prio=31 tid=0x00007fe69a812800 nid=0x2803 runnable

"GC task thread#3 (ParallelGC)" os_prio=31 tid=0x00007fe69a813800 nid=0x2a03 runnable

"VM Periodic Task Thread" os_prio=31 tid=0x00007fe69c023800 nid=0x5003 waiting on condition

JNI global references: 61906