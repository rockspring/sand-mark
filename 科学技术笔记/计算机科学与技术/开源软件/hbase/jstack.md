2017-03-22 10:56:09
Full thread dump OpenJDK 64-Bit Server VM (25.121-b13 mixed mode):

"Attach Listener" #283 daemon prio=9 os_prio=0 tid=0x00007f2a08e12800 nid=0x5619 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"Timer for 'HBase' metrics system" #280 daemon prio=5 os_prio=0 tid=0x000056530025f800 nid=0x55f9 in Object.wait() [0x00007f29ea1bb000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at java.util.TimerThread.mainLoop(Timer.java:552)
	- locked <0x000000008d56e348> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-shared--pool6-t13" #279 daemon prio=5 os_prio=0 tid=0x0000565300b82000 nid=0x55f6 waiting on condition [0x00007f29dc1e0000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9ad10> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-shared--pool6-t12" #278 daemon prio=5 os_prio=0 tid=0x0000565300b80800 nid=0x55f5 waiting on condition [0x00007f29dc2e1000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9ad10> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-shared--pool6-t11" #277 daemon prio=5 os_prio=0 tid=0x0000565300b44000 nid=0x55f4 waiting on condition [0x00007f29dc3e2000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9ad10> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-shared--pool6-t10" #276 daemon prio=5 os_prio=0 tid=0x00007f29f4b7c000 nid=0x55de waiting on condition [0x00007f29dc4e3000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9ad10> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-metaLookup-shared--pool9-t1" #275 daemon prio=5 os_prio=0 tid=0x00005653009ef800 nid=0x55dd waiting on condition [0x00007f29dc7e4000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008cf9b720> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"AM.ZK.Worker-pool2-t8" #274 daemon prio=5 os_prio=0 tid=0x00005653009ee000 nid=0x55dc waiting on condition [0x00007f29dc8e5000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a19a6d30> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"AM.ZK.Worker-pool2-t7" #273 daemon prio=5 os_prio=0 tid=0x00005653000a8800 nid=0x55db waiting on condition [0x00007f29dc9e6000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a19a6d30> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"AM.ZK.Worker-pool2-t6" #272 daemon prio=5 os_prio=0 tid=0x00005653000a6000 nid=0x55da waiting on condition [0x00007f29dcae7000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a19a6d30> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"hconnection-0x782c9e68-shared--pool8-t1" #271 daemon prio=5 os_prio=0 tid=0x00007f29f46fe000 nid=0x55d9 waiting on condition [0x00007f29dcbe8000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008cf149b8> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"AM.ZK.Worker-pool2-t5" #265 daemon prio=5 os_prio=0 tid=0x00005653001f8800 nid=0x55d0 waiting on condition [0x00007f29dcce9000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a19a6d30> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"RS_OPEN_PRIORITY_REGION-shg4873-ThinkPad-L460:40589-0" #264 prio=5 os_prio=0 tid=0x0000565300f6a800 nid=0x55cf waiting on condition [0x00007f29dcdea000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1c90b70> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"AM.ZK.Worker-pool2-t4" #263 daemon prio=5 os_prio=0 tid=0x0000565300f68000 nid=0x55ce waiting on condition [0x00007f29dceeb000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a19a6d30> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-shared--pool6-t9" #262 daemon prio=5 os_prio=0 tid=0x00007f29f416f800 nid=0x55cd waiting on condition [0x00007f29dcfec000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9ad10> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-shared--pool6-t8" #256 daemon prio=5 os_prio=0 tid=0x00007f29f4497000 nid=0x55c3 waiting on condition [0x00007f29dd0ed000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9ad10> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-shared--pool6-t7" #255 daemon prio=5 os_prio=0 tid=0x00007f29f4483800 nid=0x55c2 waiting on condition [0x00007f29dd3f0000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9ad10> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-shared--pool6-t6" #254 daemon prio=5 os_prio=0 tid=0x000056530025d800 nid=0x55c0 waiting on condition [0x00007f29dd2ef000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9ad10> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-shared--pool6-t5" #253 daemon prio=5 os_prio=0 tid=0x000056530025b000 nid=0x55bf waiting on condition [0x00007f29dd1ee000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9ad10> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-shared--pool6-t4" #250 daemon prio=5 os_prio=0 tid=0x00005653005d7000 nid=0x55bc waiting on condition [0x00007f29dd4f1000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9ad10> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-shared--pool6-t3" #249 daemon prio=5 os_prio=0 tid=0x00005653005d5800 nid=0x55bb waiting on condition [0x00007f29dd5f2000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9ad10> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-shared--pool6-t2" #248 daemon prio=5 os_prio=0 tid=0x000056530158c000 nid=0x55ba waiting on condition [0x00007f29dd6f3000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9ad10> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"IPC Client (2140275515) connection to shg4873-ThinkPad-L460/127.0.1.1:40589 from shg4873" #247 daemon prio=5 os_prio=0 tid=0x00007f29f4301000 nid=0x55b9 in Object.wait() [0x00007f29dd7f4000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at org.apache.hadoop.hbase.ipc.RpcClientImpl$Connection.waitForWork(RpcClientImpl.java:550)
	- locked <0x000000008df9afd8> (a org.apache.hadoop.hbase.ipc.RpcClientImpl$Connection)
	at org.apache.hadoop.hbase.ipc.RpcClientImpl$Connection.run(RpcClientImpl.java:565)

   Locked ownable synchronizers:
	- None

"hconnection-0x3f7788b6-shared--pool6-t1" #246 daemon prio=5 os_prio=0 tid=0x0000565301587800 nid=0x55b8 waiting on condition [0x00007f29dd8f5000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9ad10> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"AM.ZK.Worker-pool2-t3" #245 daemon prio=5 os_prio=0 tid=0x0000565300382000 nid=0x55b7 waiting on condition [0x00007f29ddbf6000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a19a6d30> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"AM.ZK.Worker-pool2-t2" #244 daemon prio=5 os_prio=0 tid=0x00005653002a2000 nid=0x55b6 waiting on condition [0x00007f29ddcf7000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a19a6d30> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"sync.4" #238 prio=5 os_prio=0 tid=0x00007f29f431d800 nid=0x55af waiting on condition [0x00007f29dddf8000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9b500> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.hadoop.hbase.regionserver.wal.FSHLog$SyncRunner.run(FSHLog.java:1247)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"sync.3" #237 prio=5 os_prio=0 tid=0x00007f29f45b9800 nid=0x55ae waiting on condition [0x00007f29ddef9000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008e0d0b80> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.hadoop.hbase.regionserver.wal.FSHLog$SyncRunner.run(FSHLog.java:1247)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"sync.2" #236 prio=5 os_prio=0 tid=0x00007f29f44ce800 nid=0x55ad waiting on condition [0x00007f29ddffa000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9b728> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.hadoop.hbase.regionserver.wal.FSHLog$SyncRunner.run(FSHLog.java:1247)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"sync.1" #235 prio=5 os_prio=0 tid=0x00007f29f4169000 nid=0x55ac waiting on condition [0x00007f29de0fb000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008e0d0da8> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.hadoop.hbase.regionserver.wal.FSHLog$SyncRunner.run(FSHLog.java:1247)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"sync.0" #234 prio=5 os_prio=0 tid=0x00007f29f4499000 nid=0x55ab waiting on condition [0x00007f29de1fc000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9b950> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.hadoop.hbase.regionserver.wal.FSHLog$SyncRunner.run(FSHLog.java:1247)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"RS_OPEN_META-shg4873-ThinkPad-L460:40589-0.append-pool5-t1" #239 prio=5 os_prio=0 tid=0x00007f29ecb5a000 nid=0x55aa waiting on condition [0x00007f29de2fd000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x000000008df9bb78> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at com.lmax.disruptor.BlockingWaitStrategy.waitFor(BlockingWaitStrategy.java:45)
	at com.lmax.disruptor.ProcessingSequenceBarrier.waitFor(ProcessingSequenceBarrier.java:55)
	at com.lmax.disruptor.BatchEventProcessor.run(BatchEventProcessor.java:123)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x000000008dfad968> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"AM.ZK.Worker-pool2-t1" #231 daemon prio=5 os_prio=0 tid=0x0000565300307800 nid=0x55a5 waiting on condition [0x00007f29de3fe000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a19a6d30> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.LinkedBlockingQueue.poll(LinkedBlockingQueue.java:467)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"RS_OPEN_META-shg4873-ThinkPad-L460:40589-0-MetaLogRoller" #230 daemon prio=5 os_prio=0 tid=0x00007f29ec0c1000 nid=0x55a4 in Object.wait() [0x00007f29de4ff000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at org.apache.hadoop.hbase.regionserver.LogRoller.run(LogRoller.java:126)
	- locked <0x000000008e0d1178> (a java.util.concurrent.atomic.AtomicBoolean)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"RS_OPEN_META-shg4873-ThinkPad-L460:40589-0" #229 prio=5 os_prio=0 tid=0x00007f29ec133000 nid=0x55a3 waiting on condition [0x00007f29de600000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1a029f0> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"IPC Client (2140275515) connection to shg4873-ThinkPad-L460/127.0.1.1:40589 from shg4873" #228 daemon prio=5 os_prio=0 tid=0x0000565300b70000 nid=0x55a2 in Object.wait() [0x00007f29de701000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at org.apache.hadoop.hbase.ipc.RpcClientImpl$Connection.waitForWork(RpcClientImpl.java:550)
	- locked <0x000000008e0d1388> (a org.apache.hadoop.hbase.ipc.RpcClientImpl$Connection)
	at org.apache.hadoop.hbase.ipc.RpcClientImpl$Connection.run(RpcClientImpl.java:565)

   Locked ownable synchronizers:
	- None

"sync.4" #226 prio=5 os_prio=0 tid=0x00007f29f401a000 nid=0x55a1 waiting on condition [0x00007f29de802000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1a02ac8> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.hadoop.hbase.regionserver.wal.FSHLog$SyncRunner.run(FSHLog.java:1247)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"sync.3" #225 prio=5 os_prio=0 tid=0x00007f29f4018800 nid=0x55a0 waiting on condition [0x00007f29de903000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1c01820> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.hadoop.hbase.regionserver.wal.FSHLog$SyncRunner.run(FSHLog.java:1247)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"sync.2" #224 prio=5 os_prio=0 tid=0x00007f29f4016800 nid=0x559f waiting on condition [0x00007f29dea04000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1c01868> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.hadoop.hbase.regionserver.wal.FSHLog$SyncRunner.run(FSHLog.java:1247)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"sync.1" #223 prio=5 os_prio=0 tid=0x00007f29f4015800 nid=0x559e waiting on condition [0x00007f29deb05000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1c018b0> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.hadoop.hbase.regionserver.wal.FSHLog$SyncRunner.run(FSHLog.java:1247)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"sync.0" #222 prio=5 os_prio=0 tid=0x00007f29f4015000 nid=0x559d waiting on condition [0x00007f29dee14000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1c018f8> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.hadoop.hbase.regionserver.wal.FSHLog$SyncRunner.run(FSHLog.java:1247)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"RS:0;shg4873-ThinkPad-L460:40589.append-pool4-t1" #227 prio=5 os_prio=0 tid=0x00005653010aa000 nid=0x559c waiting on condition [0x00007f29df115000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1c01940> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at com.lmax.disruptor.BlockingWaitStrategy.waitFor(BlockingWaitStrategy.java:45)
	at com.lmax.disruptor.ProcessingSequenceBarrier.waitFor(ProcessingSequenceBarrier.java:55)
	at com.lmax.disruptor.BatchEventProcessor.run(BatchEventProcessor.java:123)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a1c0adf8> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"process reaper" #220 daemon prio=10 os_prio=0 tid=0x0000565300712800 nid=0x559a waiting on condition [0x00007f29f0069000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a0d475b0> (a java.util.concurrent.SynchronousQueue$TransferStack)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"SplitLogWorker-shg4873-ThinkPad-L460:40589" #218 prio=5 os_prio=0 tid=0x000056530039a000 nid=0x5581 in Object.wait() [0x00007f29dec06000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at org.apache.hadoop.hbase.coordination.ZkSplitLogWorkerCoordination.taskLoop(ZkSplitLogWorkerCoordination.java:445)
	- locked <0x00000000a17f9388> (a java.lang.Object)
	at org.apache.hadoop.hbase.regionserver.SplitLogWorker.run(SplitLogWorker.java:142)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"shg4873-ThinkPad-L460:40589Replication Statistics #0" #217 daemon prio=5 os_prio=0 tid=0x000056530108a800 nid=0x5580 waiting on condition [0x00007f29ded07000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1a03110> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"regionserver/shg4873-ThinkPad-L460/127.0.1.1:0.leaseChecker" #197 daemon prio=5 os_prio=0 tid=0x000056530046c000 nid=0x557f waiting on condition [0x00007f29df216000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
	at java.lang.Thread.sleep(Native Method)
	at org.apache.hadoop.hbase.regionserver.Leases.run(Leases.java:95)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"MemStoreFlusher.1" #214 prio=5 os_prio=0 tid=0x0000565300686000 nid=0x557e waiting on condition [0x00007f29df317000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a183f3c8> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.DelayQueue.poll(DelayQueue.java:259)
	at java.util.concurrent.DelayQueue.poll(DelayQueue.java:70)
	at org.apache.hadoop.hbase.regionserver.MemStoreFlusher$FlushHandler.run(MemStoreFlusher.java:239)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"MemStoreFlusher.0" #212 prio=5 os_prio=0 tid=0x0000565300684800 nid=0x557d waiting on condition [0x00007f29df418000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a183f3c8> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.DelayQueue.poll(DelayQueue.java:259)
	at java.util.concurrent.DelayQueue.poll(DelayQueue.java:70)
	at org.apache.hadoop.hbase.regionserver.MemStoreFlusher$FlushHandler.run(MemStoreFlusher.java:239)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"regionserver/shg4873-ThinkPad-L460/127.0.1.1:0.logRoller" #175 daemon prio=5 os_prio=0 tid=0x00005653010b1000 nid=0x557c in Object.wait() [0x00007f29df519000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at org.apache.hadoop.hbase.regionserver.LogRoller.run(LogRoller.java:126)
	- locked <0x00000000a1774ed8> (a java.util.concurrent.atomic.AtomicBoolean)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"HBase-Metrics2-1" #211 daemon prio=5 os_prio=0 tid=0x0000565300d08000 nid=0x557b waiting on condition [0x00007f29df61a000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1a20500> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"IPC Client (2140275515) connection to shg4873-ThinkPad-L460/127.0.1.1:44943 from shg4873" #210 daemon prio=5 os_prio=0 tid=0x0000565300f9d800 nid=0x557a in Object.wait() [0x00007f29df71b000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at org.apache.hadoop.hbase.ipc.RpcClientImpl$Connection.waitForWork(RpcClientImpl.java:550)
	- locked <0x00000000a186bbb0> (a org.apache.hadoop.hbase.ipc.RpcClientImpl$Connection)
	at org.apache.hadoop.hbase.ipc.RpcClientImpl$Connection.run(RpcClientImpl.java:565)

   Locked ownable synchronizers:
	- None

"snapshot-hfile-cleaner-cache-refresher" #209 daemon prio=5 os_prio=0 tid=0x0000565300ec2000 nid=0x5579 in Object.wait() [0x00007f29df81c000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x00000000a10bed80> (a java.util.TaskQueue)
	at java.util.TimerThread.mainLoop(Timer.java:552)
	- locked <0x00000000a10bed80> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

   Locked ownable synchronizers:
	- None

"shg4873-ThinkPad-L460:44943.activeMasterManager-EventThread" #208 daemon prio=5 os_prio=0 tid=0x0000565300c5d000 nid=0x5578 waiting on condition [0x00007f29df91d000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a10bedb0> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.zookeeper.ClientCnxn$EventThread.run(ClientCnxn.java:494)

   Locked ownable synchronizers:
	- None

"shg4873-ThinkPad-L460:44943.activeMasterManager-SendThread(localhost:2181)" #207 daemon prio=5 os_prio=0 tid=0x0000565300fc8800 nid=0x5577 runnable [0x00007f29dfa1e000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a10bee10> (a sun.nio.ch.Util$3)
	- locked <0x00000000a10bedf8> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a12da440> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.apache.zookeeper.ClientCnxnSocketNIO.doTransport(ClientCnxnSocketNIO.java:349)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1081)

   Locked ownable synchronizers:
	- None

"ProcedureExecutorTimeout" #204 daemon prio=5 os_prio=0 tid=0x0000565300c5a000 nid=0x5576 waiting on condition [0x00007f29dfb1f000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1842f50> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at org.apache.hadoop.hbase.procedure2.util.TimeoutBlockingQueue.poll(TimeoutBlockingQueue.java:106)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor.timeoutLoop(ProcedureExecutor.java:972)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor.access$500(ProcedureExecutor.java:78)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor$3.run(ProcedureExecutor.java:507)

   Locked ownable synchronizers:
	- None

"ProcedureExecutor-3" #203 daemon prio=5 os_prio=0 tid=0x00005653009ea000 nid=0x5575 waiting on condition [0x00007f29dfc20000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1843028> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at org.apache.hadoop.hbase.master.procedure.MasterProcedureScheduler.poll(MasterProcedureScheduler.java:149)
	at org.apache.hadoop.hbase.master.procedure.MasterProcedureScheduler.poll(MasterProcedureScheduler.java:139)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor.execLoop(ProcedureExecutor.java:891)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor.access$400(ProcedureExecutor.java:78)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor$2.run(ProcedureExecutor.java:498)

   Locked ownable synchronizers:
	- None

"ProcedureExecutor-2" #202 daemon prio=5 os_prio=0 tid=0x00005653009b1000 nid=0x5574 waiting on condition [0x00007f29dfd21000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1843028> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at org.apache.hadoop.hbase.master.procedure.MasterProcedureScheduler.poll(MasterProcedureScheduler.java:149)
	at org.apache.hadoop.hbase.master.procedure.MasterProcedureScheduler.poll(MasterProcedureScheduler.java:139)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor.execLoop(ProcedureExecutor.java:891)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor.access$400(ProcedureExecutor.java:78)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor$2.run(ProcedureExecutor.java:498)

   Locked ownable synchronizers:
	- None

"ProcedureExecutor-1" #201 daemon prio=5 os_prio=0 tid=0x0000565300c59000 nid=0x5573 waiting on condition [0x00007f29dfe22000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1843028> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at org.apache.hadoop.hbase.master.procedure.MasterProcedureScheduler.poll(MasterProcedureScheduler.java:149)
	at org.apache.hadoop.hbase.master.procedure.MasterProcedureScheduler.poll(MasterProcedureScheduler.java:139)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor.execLoop(ProcedureExecutor.java:891)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor.access$400(ProcedureExecutor.java:78)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor$2.run(ProcedureExecutor.java:498)

   Locked ownable synchronizers:
	- None

"ProcedureExecutor-0" #200 daemon prio=5 os_prio=0 tid=0x0000565300767800 nid=0x5572 waiting on condition [0x00007f29e0123000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1843028> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at org.apache.hadoop.hbase.master.procedure.MasterProcedureScheduler.poll(MasterProcedureScheduler.java:149)
	at org.apache.hadoop.hbase.master.procedure.MasterProcedureScheduler.poll(MasterProcedureScheduler.java:139)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor.execLoop(ProcedureExecutor.java:891)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor.access$400(ProcedureExecutor.java:78)
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor$2.run(ProcedureExecutor.java:498)

   Locked ownable synchronizers:
	- None

"WALProcedureStoreSyncThread" #199 daemon prio=5 os_prio=0 tid=0x000056530077f800 nid=0x556d waiting on condition [0x00007f29e0224000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1843130> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2163)
	at org.apache.hadoop.hbase.procedure2.store.wal.WALProcedureStore.syncLoop(WALProcedureStore.java:578)
	at org.apache.hadoop.hbase.procedure2.store.wal.WALProcedureStore.access$000(WALProcedureStore.java:67)
	at org.apache.hadoop.hbase.procedure2.store.wal.WALProcedureStore$1.run(WALProcedureStore.java:215)

   Locked ownable synchronizers:
	- None

"RS:0;shg4873-ThinkPad-L460:40589-longCompactions-1490151329979" #196 prio=5 os_prio=0 tid=0x0000565300473000 nid=0x556c waiting on condition [0x00007f29e0325000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a10bee28> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at org.apache.hadoop.hbase.util.StealJobQueue.take(StealJobQueue.java:90)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"shg4873-ThinkPad-L460:44943.activeMasterManager-EventThread" #195 daemon prio=5 os_prio=0 tid=0x000056530045d000 nid=0x556b waiting on condition [0x00007f29e0426000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a14ff2f8> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.zookeeper.ClientCnxn$EventThread.run(ClientCnxn.java:494)

   Locked ownable synchronizers:
	- None

"shg4873-ThinkPad-L460:44943.activeMasterManager-SendThread(localhost:2181)" #194 daemon prio=5 os_prio=0 tid=0x000056530053e000 nid=0x556a runnable [0x00007f29e0527000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1488500> (a sun.nio.ch.Util$3)
	- locked <0x00000000a14884e8> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a14ffd38> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.apache.zookeeper.ClientCnxnSocketNIO.doTransport(ClientCnxnSocketNIO.java:349)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1081)

   Locked ownable synchronizers:
	- None

"shg4873-thinkpad-l460,44943,1490151328101_splitLogManager__ChoreService_1" #193 daemon prio=5 os_prio=0 tid=0x000056530050f800 nid=0x5569 waiting on condition [0x00007f29e0828000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a0d95238> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"JvmPauseMonitor" #187 daemon prio=5 os_prio=0 tid=0x000056530051b000 nid=0x555f waiting on condition [0x00007f29e0929000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
	at java.lang.Thread.sleep(Native Method)
	at org.apache.hadoop.hbase.util.JvmPauseMonitor$Monitor.run(JvmPauseMonitor.java:158)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"JvmPauseMonitor" #186 daemon prio=5 os_prio=0 tid=0x00007f2a0943c000 nid=0x555e waiting on condition [0x00007f29e1030000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
	at java.lang.Thread.sleep(Native Method)
	at org.apache.hadoop.hbase.util.JvmPauseMonitor$Monitor.run(JvmPauseMonitor.java:158)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"M:0;shg4873-ThinkPad-L460:44943-EventThread" #185 daemon prio=5 os_prio=0 tid=0x00007f2a09414800 nid=0x555d waiting on condition [0x00007f29e0a2a000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a0d94fc8> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.zookeeper.ClientCnxn$EventThread.run(ClientCnxn.java:494)

   Locked ownable synchronizers:
	- None

"M:0;shg4873-ThinkPad-L460:44943-SendThread(localhost:2181)" #184 daemon prio=5 os_prio=0 tid=0x00007f2a0941a000 nid=0x555c runnable [0x00007f29e0b2b000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a14321f8> (a sun.nio.ch.Util$3)
	- locked <0x00000000a14321e0> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a14fff30> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.apache.zookeeper.ClientCnxnSocketNIO.doTransport(ClientCnxnSocketNIO.java:349)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1081)

   Locked ownable synchronizers:
	- None

"RS:0;shg4873-ThinkPad-L460:40589-EventThread" #183 daemon prio=5 os_prio=0 tid=0x0000565300532000 nid=0x555b waiting on condition [0x00007f29e0c2c000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144a410> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.zookeeper.ClientCnxn$EventThread.run(ClientCnxn.java:494)

   Locked ownable synchronizers:
	- None

"RS:0;shg4873-ThinkPad-L460:40589-SendThread(localhost:2181)" #182 daemon prio=5 os_prio=0 tid=0x000056530039d800 nid=0x555a runnable [0x00007f29e0d2d000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a144a1a0> (a sun.nio.ch.Util$3)
	- locked <0x00000000a144a188> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a13a1810> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.apache.zookeeper.ClientCnxnSocketNIO.doTransport(ClientCnxnSocketNIO.java:349)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1081)

   Locked ownable synchronizers:
	- None

"LruBlockCacheStatsExecutor" #181 daemon prio=5 os_prio=0 tid=0x00007f29ec1b6800 nid=0x5559 waiting on condition [0x00007f29e0e2e000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a10c0070> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"StoreOpener-1588230740-1.LruBlockCache.EvictionThread" #179 daemon prio=5 os_prio=0 tid=0x00007f29ec1b4000 nid=0x5558 in Object.wait() [0x00007f29e0f2f000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at org.apache.hadoop.hbase.io.hfile.LruBlockCache$EvictionThread.run(LruBlockCache.java:855)
	- locked <0x00000000a10c09a0> (a org.apache.hadoop.hbase.io.hfile.LruBlockCache$EvictionThread)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"RS:0;shg4873-ThinkPad-L460:40589" #177 prio=5 os_prio=0 tid=0x00007f2a093fc000 nid=0x5556 in Object.wait() [0x00007f29e1131000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at org.apache.hadoop.hbase.util.Sleeper.sleep(Sleeper.java:92)
	- locked <0x00000000a13855d0> (a java.lang.Object)
	at org.apache.hadoop.hbase.util.Sleeper.sleep(Sleeper.java:56)
	at org.apache.hadoop.hbase.regionserver.HRegionServer.run(HRegionServer.java:986)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"M:0;shg4873-ThinkPad-L460:44943" #95 prio=5 os_prio=0 tid=0x00007f2a093fb000 nid=0x5555 in Object.wait() [0x00007f29e1232000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at org.apache.hadoop.hbase.util.Sleeper.sleep(Sleeper.java:92)
	- locked <0x00000000a11abfa8> (a java.lang.Object)
	at org.apache.hadoop.hbase.util.Sleeper.sleep(Sleeper.java:56)
	at org.apache.hadoop.hbase.master.HMaster.waitForMasterActive(HMaster.java:520)
	at org.apache.hadoop.hbase.regionserver.HRegionServer.initializeZooKeeper(HRegionServer.java:810)
	at org.apache.hadoop.hbase.regionserver.HRegionServer.preRegistrationInitialization(HRegionServer.java:763)
	at org.apache.hadoop.hbase.regionserver.HRegionServer.run(HRegionServer.java:909)
	at org.apache.hadoop.hbase.master.HMasterCommandLine$LocalHMaster.run(HMasterCommandLine.java:317)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"shg4873-thinkpad-l460,40589,1490151329323_ChoreService_1" #176 daemon prio=5 os_prio=0 tid=0x00007f2a093fa800 nid=0x5554 waiting on condition [0x00007f29e1333000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a15759d8> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"Timer-1" #174 daemon prio=5 os_prio=0 tid=0x00007f2a09341000 nid=0x5553 in Object.wait() [0x00007f29e1634000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at java.util.TimerThread.mainLoop(Timer.java:552)
	- locked <0x00000000a15c5e08> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

   Locked ownable synchronizers:
	- None

"429058804@qtp-1429616542-1 - Acceptor0 SelectChannelConnector@0.0.0.0:43515" #167 daemon prio=5 os_prio=0 tid=0x00007f2a0933e800 nid=0x5547 runnable [0x00007f29e1735000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1640ba0> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1640b88> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a13a16f0> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.mortbay.io.nio.SelectorManager$SelectSet.doSelect(SelectorManager.java:498)
	at org.mortbay.io.nio.SelectorManager.doSelect(SelectorManager.java:192)
	at org.mortbay.jetty.nio.SelectChannelConnector.accept(SelectChannelConnector.java:124)
	at org.mortbay.jetty.AbstractConnector$Acceptor.run(AbstractConnector.java:708)
	at org.mortbay.thread.QueuedThreadPool$PoolThread.run(QueuedThreadPool.java:582)

   Locked ownable synchronizers:
	- None

"2109219177@qtp-1429616542-0" #166 daemon prio=5 os_prio=0 tid=0x00007f2a0933d800 nid=0x5545 in Object.wait() [0x00007f29e1836000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x00000000a146e530> (a org.mortbay.thread.QueuedThreadPool$PoolThread)
	at org.mortbay.thread.QueuedThreadPool$PoolThread.run(QueuedThreadPool.java:626)
	- locked <0x00000000a146e530> (a org.mortbay.thread.QueuedThreadPool$PoolThread)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.replication.handler=2,queue=0,port=40589" #165 daemon prio=5 os_prio=0 tid=0x00007f2a0933a800 nid=0x5544 waiting on condition [0x00007f29e1937000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650ac0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.replication.handler=1,queue=0,port=40589" #164 daemon prio=5 os_prio=0 tid=0x00007f2a09338800 nid=0x5543 waiting on condition [0x00007f29e1a38000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650b20> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.replication.handler=0,queue=0,port=40589" #163 daemon prio=5 os_prio=0 tid=0x00007f2a09336800 nid=0x5542 waiting on condition [0x00007f29e1b39000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650b80> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=19,queue=1,port=40589" #162 daemon prio=5 os_prio=0 tid=0x00007f2a09334800 nid=0x5541 waiting on condition [0x00007f29e1c3a000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650be0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=18,queue=0,port=40589" #161 daemon prio=5 os_prio=0 tid=0x00007f2a09332800 nid=0x5540 waiting on condition [0x00007f29e1d3b000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650c40> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=17,queue=1,port=40589" #160 daemon prio=5 os_prio=0 tid=0x00007f2a09330800 nid=0x553f waiting on condition [0x00007f29e1e3c000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650ca0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=16,queue=0,port=40589" #159 daemon prio=5 os_prio=0 tid=0x00007f2a0932e800 nid=0x553e waiting on condition [0x00007f29e1f3d000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650d00> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=15,queue=1,port=40589" #158 daemon prio=5 os_prio=0 tid=0x00007f2a0932c800 nid=0x553d waiting on condition [0x00007f29e203e000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650d60> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=14,queue=0,port=40589" #157 daemon prio=5 os_prio=0 tid=0x00007f2a0932a800 nid=0x553c waiting on condition [0x00007f29e213f000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650dc0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=13,queue=1,port=40589" #156 daemon prio=5 os_prio=0 tid=0x00007f2a09328800 nid=0x553b waiting on condition [0x00007f29e2240000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650e20> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=12,queue=0,port=40589" #155 daemon prio=5 os_prio=0 tid=0x00007f2a09326800 nid=0x553a waiting on condition [0x00007f29e2341000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650e80> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=11,queue=1,port=40589" #154 daemon prio=5 os_prio=0 tid=0x00007f2a09325000 nid=0x5539 waiting on condition [0x00007f29e2442000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650ee0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=10,queue=0,port=40589" #153 daemon prio=5 os_prio=0 tid=0x00007f2a09323000 nid=0x5538 waiting on condition [0x00007f29e2543000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650f40> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=9,queue=1,port=40589" #152 daemon prio=5 os_prio=0 tid=0x00007f2a09321000 nid=0x5537 waiting on condition [0x00007f29e2644000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1650fa0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=8,queue=0,port=40589" #151 daemon prio=5 os_prio=0 tid=0x00007f2a0931f000 nid=0x5536 waiting on condition [0x00007f29e2745000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1651000> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=7,queue=1,port=40589" #150 daemon prio=5 os_prio=0 tid=0x00007f2a0931d800 nid=0x5535 waiting on condition [0x00007f29e2846000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1651060> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=6,queue=0,port=40589" #149 daemon prio=5 os_prio=0 tid=0x00007f2a0931b000 nid=0x5534 waiting on condition [0x00007f29e2947000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a16510c0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=5,queue=1,port=40589" #148 daemon prio=5 os_prio=0 tid=0x00007f2a09319000 nid=0x5533 waiting on condition [0x00007f29e2a48000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1651120> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=4,queue=0,port=40589" #147 daemon prio=5 os_prio=0 tid=0x00007f2a09317000 nid=0x5532 waiting on condition [0x00007f29e2b49000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1651180> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=3,queue=1,port=40589" #146 daemon prio=5 os_prio=0 tid=0x00007f2a09315800 nid=0x5531 waiting on condition [0x00007f29e2c4a000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a16511e0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=2,queue=0,port=40589" #145 daemon prio=5 os_prio=0 tid=0x00007f2a09313000 nid=0x5530 waiting on condition [0x00007f29e2d4b000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1651240> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=1,queue=1,port=40589" #144 daemon prio=5 os_prio=0 tid=0x00007f2a09311000 nid=0x552f waiting on condition [0x00007f29e2e4c000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a16512a0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=0,queue=0,port=40589" #143 daemon prio=5 os_prio=0 tid=0x00007f2a0930f000 nid=0x552e waiting on condition [0x00007f29e2f4d000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1651300> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=29,queue=2,port=40589" #142 daemon prio=5 os_prio=0 tid=0x00007f2a0930d800 nid=0x552d waiting on condition [0x00007f29e304e000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1651360> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=28,queue=1,port=40589" #141 daemon prio=5 os_prio=0 tid=0x00007f2a0930b000 nid=0x552c waiting on condition [0x00007f29e314f000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a16513c0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=27,queue=0,port=40589" #140 daemon prio=5 os_prio=0 tid=0x00007f2a09309800 nid=0x552b waiting on condition [0x00007f29e3250000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1651420> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=26,queue=2,port=40589" #139 daemon prio=5 os_prio=0 tid=0x00007f2a09307800 nid=0x552a waiting on condition [0x00007f29e3351000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1651480> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=25,queue=1,port=40589" #138 daemon prio=5 os_prio=0 tid=0x00007f2a09305800 nid=0x5529 waiting on condition [0x00007f29e3452000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a16514e0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=24,queue=0,port=40589" #137 daemon prio=5 os_prio=0 tid=0x00007f2a09303800 nid=0x5528 waiting on condition [0x00007f29e3553000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1679c50> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=23,queue=2,port=40589" #136 daemon prio=5 os_prio=0 tid=0x00007f2a09301800 nid=0x5527 waiting on condition [0x00007f29e3654000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1679cb0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=22,queue=1,port=40589" #135 daemon prio=5 os_prio=0 tid=0x00007f2a092ff800 nid=0x5526 waiting on condition [0x00007f29e3755000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1679d10> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=21,queue=0,port=40589" #134 daemon prio=5 os_prio=0 tid=0x00007f2a092fd800 nid=0x5525 waiting on condition [0x00007f29e3856000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1679d70> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=20,queue=2,port=40589" #133 daemon prio=5 os_prio=0 tid=0x00007f2a092fb800 nid=0x5524 waiting on condition [0x00007f29e3957000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1679dd0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=19,queue=1,port=40589" #132 daemon prio=5 os_prio=0 tid=0x00007f2a092f9800 nid=0x5523 waiting on condition [0x00007f29e3a58000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1679e30> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=18,queue=0,port=40589" #131 daemon prio=5 os_prio=0 tid=0x00007f2a092f7800 nid=0x5522 waiting on condition [0x00007f29e3b59000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1679e90> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=17,queue=2,port=40589" #130 daemon prio=5 os_prio=0 tid=0x00007f2a092f5800 nid=0x5521 waiting on condition [0x00007f29e3c5a000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1679ef0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=16,queue=1,port=40589" #129 daemon prio=5 os_prio=0 tid=0x00007f2a092f3800 nid=0x5520 waiting on condition [0x00007f29e3d5b000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1679f50> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=15,queue=0,port=40589" #128 daemon prio=5 os_prio=0 tid=0x00007f2a092f1800 nid=0x551f waiting on condition [0x00007f29e3e5c000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1679fb0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=14,queue=2,port=40589" #127 daemon prio=5 os_prio=0 tid=0x00007f2a092ef800 nid=0x551e waiting on condition [0x00007f29e3f5d000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a010> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=13,queue=1,port=40589" #126 daemon prio=5 os_prio=0 tid=0x00007f2a092ed800 nid=0x551d waiting on condition [0x00007f29e405e000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a070> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=12,queue=0,port=40589" #125 daemon prio=5 os_prio=0 tid=0x00007f2a092eb800 nid=0x551c waiting on condition [0x00007f29e415f000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a0d0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=11,queue=2,port=40589" #124 daemon prio=5 os_prio=0 tid=0x00007f2a092ea000 nid=0x551b waiting on condition [0x00007f29e4260000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a130> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=10,queue=1,port=40589" #123 daemon prio=5 os_prio=0 tid=0x00007f2a092e8800 nid=0x551a waiting on condition [0x00007f29e4361000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a190> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=9,queue=0,port=40589" #122 daemon prio=5 os_prio=0 tid=0x00007f2a092e6800 nid=0x5519 waiting on condition [0x00007f29e4462000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a1f0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=8,queue=2,port=40589" #121 daemon prio=5 os_prio=0 tid=0x00007f2a092e4800 nid=0x5518 waiting on condition [0x00007f29e4563000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a250> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=7,queue=1,port=40589" #120 daemon prio=5 os_prio=0 tid=0x00007f2a092e3000 nid=0x5517 waiting on condition [0x00007f29e4664000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a2b0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=6,queue=0,port=40589" #119 daemon prio=5 os_prio=0 tid=0x00007f2a092e1000 nid=0x5516 waiting on condition [0x00007f29e4765000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a310> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=5,queue=2,port=40589" #118 daemon prio=5 os_prio=0 tid=0x00007f2a092df000 nid=0x5515 waiting on condition [0x00007f29e4866000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a370> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=4,queue=1,port=40589" #117 daemon prio=5 os_prio=0 tid=0x00007f2a092dd000 nid=0x5514 waiting on condition [0x00007f29e4967000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a3d0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=3,queue=0,port=40589" #116 daemon prio=5 os_prio=0 tid=0x00007f2a092db800 nid=0x5513 waiting on condition [0x00007f29e4a68000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a430> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=2,queue=2,port=40589" #115 daemon prio=5 os_prio=0 tid=0x00007f2a092da000 nid=0x5512 waiting on condition [0x00007f29e4b69000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a490> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=1,queue=1,port=40589" #114 daemon prio=5 os_prio=0 tid=0x00007f2a092d8000 nid=0x5511 waiting on condition [0x00007f29e4c6a000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a4f0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=0,queue=0,port=40589" #113 daemon prio=5 os_prio=0 tid=0x00007f2a092d6800 nid=0x5510 waiting on condition [0x00007f29e4d6b000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a167a550> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.listener,port=40589" #97 daemon prio=5 os_prio=0 tid=0x00007f2a092d4800 nid=0x550f runnable [0x00007f29e4e6c000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1390e98> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1390ec8> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a137ee58> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener.run(RpcServer.java:804)

   Locked ownable synchronizers:
	- None

"RpcServer.responder" #108 daemon prio=5 os_prio=0 tid=0x00007f2a092d3000 nid=0x550e runnable [0x00007f29e4f6d000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a16753c8> (a sun.nio.ch.Util$3)
	- locked <0x00000000a16753b0> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1681c20> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.apache.hadoop.hbase.ipc.RpcServer$Responder.doRunLoop(RpcServer.java:1044)
	at org.apache.hadoop.hbase.ipc.RpcServer$Responder.run(RpcServer.java:991)

   Locked ownable synchronizers:
	- None

"main-EventThread" #110 daemon prio=5 os_prio=0 tid=0x00007f2a0918a800 nid=0x550c waiting on condition [0x00007f29e516f000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a16754d0> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.zookeeper.ClientCnxn$EventThread.run(ClientCnxn.java:494)

   Locked ownable synchronizers:
	- None

"main-SendThread(localhost:2181)" #109 daemon prio=5 os_prio=0 tid=0x00007f2a09188800 nid=0x550b runnable [0x00007f29e5270000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1675800> (a sun.nio.ch.Util$3)
	- locked <0x00000000a16757e8> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1681cf8> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.apache.zookeeper.ClientCnxnSocketNIO.doTransport(ClientCnxnSocketNIO.java:349)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1081)

   Locked ownable synchronizers:
	- None

"RpcServer.reader=9,bindAddress=shg4873-ThinkPad-L460,port=40589" #107 daemon prio=5 os_prio=0 tid=0x00007f2a09186800 nid=0x550a runnable [0x00007f29e5371000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1675d58> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1675d40> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1681e60> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1675dd0> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a1692650> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=8,bindAddress=shg4873-ThinkPad-L460,port=40589" #106 daemon prio=5 os_prio=0 tid=0x00007f2a09185000 nid=0x5509 runnable [0x00007f29e5472000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1646670> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1646658> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1549120> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a16466e8> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a1672260> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=7,bindAddress=shg4873-ThinkPad-L460,port=40589" #105 daemon prio=5 os_prio=0 tid=0x00007f2a09182800 nid=0x5508 runnable [0x00007f29e5573000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1675ea8> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1675e90> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1681ef0> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1675f20> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a1692740> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=6,bindAddress=shg4873-ThinkPad-L460,port=40589" #104 daemon prio=5 os_prio=0 tid=0x00007f2a09180800 nid=0x5507 runnable [0x00007f29e5674000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a16467c0> (a sun.nio.ch.Util$3)
	- locked <0x00000000a16467a8> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a15491b0> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1646838> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a1672350> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=5,bindAddress=shg4873-ThinkPad-L460,port=40589" #103 daemon prio=5 os_prio=0 tid=0x00007f2a0917f000 nid=0x5506 runnable [0x00007f29e5775000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1646910> (a sun.nio.ch.Util$3)
	- locked <0x00000000a16468f8> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1549240> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1646988> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a1672440> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=4,bindAddress=shg4873-ThinkPad-L460,port=40589" #102 daemon prio=5 os_prio=0 tid=0x00007f2a0917d800 nid=0x5505 runnable [0x00007f29e5876000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a0d9e598> (a sun.nio.ch.Util$3)
	- locked <0x00000000a0d9e580> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a0d09308> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a13842c8> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a1692830> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=3,bindAddress=shg4873-ThinkPad-L460,port=40589" #101 daemon prio=5 os_prio=0 tid=0x00007f2a0917b800 nid=0x5504 runnable [0x00007f29e5977000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a0d9e370> (a sun.nio.ch.Util$3)
	- locked <0x00000000a0d9e358> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a137eee8> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a13842b0> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a0da7030> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=2,bindAddress=shg4873-ThinkPad-L460,port=40589" #100 daemon prio=5 os_prio=0 tid=0x00007f2a09179800 nid=0x5503 runnable [0x00007f29e5a78000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1384010> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1383ff8> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a0d09350> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1384298> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a13727a0> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=1,bindAddress=shg4873-ThinkPad-L460,port=40589" #99 daemon prio=5 os_prio=0 tid=0x00007f2a09177800 nid=0x5502 runnable [0x00007f29e5b79000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1384148> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1384130> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a0d093e0> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1384280> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a1372710> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=0,bindAddress=shg4873-ThinkPad-L460,port=40589" #98 daemon prio=5 os_prio=0 tid=0x00007f2a0916d000 nid=0x5501 runnable [0x00007f29e5c7a000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a0d9e4a8> (a sun.nio.ch.Util$3)
	- locked <0x00000000a0d9e490> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a137ef78> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1384268> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a0da7120> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"shg4873-thinkpad-l460,44943,1490151328101_ChoreService_1" #93 daemon prio=5 os_prio=0 tid=0x00007f2a0910e000 nid=0x54ff waiting on condition [0x00007f29e5e7c000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1390fa0> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.awaitNanos(AbstractQueuedSynchronizer.java:2078)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:1093)
	at java.util.concurrent.ScheduledThreadPoolExecutor$DelayedWorkQueue.take(ScheduledThreadPoolExecutor.java:809)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"Timer-0" #91 daemon prio=5 os_prio=0 tid=0x00007f2a090e5000 nid=0x54fe in Object.wait() [0x00007f29e5f7d000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at java.util.TimerThread.mainLoop(Timer.java:552)
	- locked <0x00000000a13910d8> (a java.util.TaskQueue)
	at java.util.TimerThread.run(Timer.java:505)

   Locked ownable synchronizers:
	- None

"1252540239@qtp-1716932897-1 - Acceptor0 SelectChannelConnector@0.0.0.0:16010" #90 daemon prio=5 os_prio=0 tid=0x00007f2a08fa9000 nid=0x54fd runnable [0x00007f29e607e000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a14561a0> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1456188> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a13c5f50> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.mortbay.io.nio.SelectorManager$SelectSet.doSelect(SelectorManager.java:498)
	at org.mortbay.io.nio.SelectorManager.doSelect(SelectorManager.java:192)
	at org.mortbay.jetty.nio.SelectChannelConnector.accept(SelectChannelConnector.java:124)
	at org.mortbay.jetty.AbstractConnector$Acceptor.run(AbstractConnector.java:708)
	at org.mortbay.thread.QueuedThreadPool$PoolThread.run(QueuedThreadPool.java:582)

   Locked ownable synchronizers:
	- None

"1338905451@qtp-1716932897-0" #89 daemon prio=5 os_prio=0 tid=0x00007f2a08f9c000 nid=0x54fc in Object.wait() [0x00007f29e617f000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	- waiting on <0x00000000a141fc30> (a org.mortbay.thread.QueuedThreadPool$PoolThread)
	at org.mortbay.thread.QueuedThreadPool$PoolThread.run(QueuedThreadPool.java:626)
	- locked <0x00000000a141fc30> (a org.mortbay.thread.QueuedThreadPool$PoolThread)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.replication.handler=2,queue=0,port=44943" #87 daemon prio=5 os_prio=0 tid=0x00007f2a08f61000 nid=0x54fb waiting on condition [0x00007f29e6480000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d4b0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.replication.handler=1,queue=0,port=44943" #86 daemon prio=5 os_prio=0 tid=0x00007f2a08f5f000 nid=0x54fa waiting on condition [0x00007f29e6581000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d510> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.replication.handler=0,queue=0,port=44943" #85 daemon prio=5 os_prio=0 tid=0x00007f2a08f5d000 nid=0x54f9 waiting on condition [0x00007f29e6682000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d570> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=19,queue=1,port=44943" #84 daemon prio=5 os_prio=0 tid=0x00007f2a08f5b800 nid=0x54f8 waiting on condition [0x00007f29e6783000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d5d0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=18,queue=0,port=44943" #83 daemon prio=5 os_prio=0 tid=0x00007f2a08f59800 nid=0x54f7 waiting on condition [0x00007f29e6884000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d630> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=17,queue=1,port=44943" #82 daemon prio=5 os_prio=0 tid=0x00007f2a08f58000 nid=0x54f6 waiting on condition [0x00007f29e6985000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d690> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=16,queue=0,port=44943" #81 daemon prio=5 os_prio=0 tid=0x00007f2a08f56000 nid=0x54f5 waiting on condition [0x00007f29e6a86000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d6f0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=15,queue=1,port=44943" #80 daemon prio=5 os_prio=0 tid=0x00007f2a08f54000 nid=0x54f4 waiting on condition [0x00007f29e6b87000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d750> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=14,queue=0,port=44943" #79 daemon prio=5 os_prio=0 tid=0x00007f2a08f52800 nid=0x54f3 waiting on condition [0x00007f29e6c88000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d7b0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=13,queue=1,port=44943" #78 daemon prio=5 os_prio=0 tid=0x00007f2a08f50800 nid=0x54f2 waiting on condition [0x00007f29e6d89000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447350> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=12,queue=0,port=44943" #77 daemon prio=5 os_prio=0 tid=0x00007f2a08f4e800 nid=0x54f1 waiting on condition [0x00007f29e6e8a000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d810> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=11,queue=1,port=44943" #76 daemon prio=5 os_prio=0 tid=0x00007f2a08f4c800 nid=0x54f0 waiting on condition [0x00007f29e6f8b000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d870> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=10,queue=0,port=44943" #75 daemon prio=5 os_prio=0 tid=0x00007f2a08f4a800 nid=0x54ef waiting on condition [0x00007f29e708c000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a14473b0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=9,queue=1,port=44943" #74 daemon prio=5 os_prio=0 tid=0x00007f2a08f48800 nid=0x54ee waiting on condition [0x00007f29e718d000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d8d0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=8,queue=0,port=44943" #73 daemon prio=5 os_prio=0 tid=0x00007f2a08f46800 nid=0x54ed waiting on condition [0x00007f29e728e000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447410> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=7,queue=1,port=44943" #72 daemon prio=5 os_prio=0 tid=0x00007f2a08f44800 nid=0x54ec waiting on condition [0x00007f29e738f000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d930> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=6,queue=0,port=44943" #71 daemon prio=5 os_prio=0 tid=0x00007f2a08f42800 nid=0x54eb waiting on condition [0x00007f29e7490000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447470> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=5,queue=1,port=44943" #70 daemon prio=5 os_prio=0 tid=0x00007f2a08f40800 nid=0x54ea waiting on condition [0x00007f29e7591000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a14474d0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=4,queue=0,port=44943" #69 daemon prio=5 os_prio=0 tid=0x00007f2a08f3e800 nid=0x54e9 waiting on condition [0x00007f29e7692000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d990> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=3,queue=1,port=44943" #68 daemon prio=5 os_prio=0 tid=0x00007f2a08f3c800 nid=0x54e8 waiting on condition [0x00007f29e7793000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447530> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=2,queue=0,port=44943" #67 daemon prio=5 os_prio=0 tid=0x00007f2a08f3a800 nid=0x54e7 waiting on condition [0x00007f29e7894000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144d9f0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=1,queue=1,port=44943" #66 daemon prio=5 os_prio=0 tid=0x00007f2a08f38800 nid=0x54e6 waiting on condition [0x00007f29e7995000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447590> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.priority.handler=0,queue=0,port=44943" #65 daemon prio=5 os_prio=0 tid=0x00007f2a08f36800 nid=0x54e5 waiting on condition [0x00007f29e7a96000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144da50> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=29,queue=2,port=44943" #64 daemon prio=5 os_prio=0 tid=0x00007f2a08f34800 nid=0x54e4 waiting on condition [0x00007f29e7b97000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a14475f0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=28,queue=1,port=44943" #63 daemon prio=5 os_prio=0 tid=0x00007f2a08f32800 nid=0x54e3 waiting on condition [0x00007f29e7c98000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144dab0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=27,queue=0,port=44943" #62 daemon prio=5 os_prio=0 tid=0x00007f2a08f31000 nid=0x54e2 waiting on condition [0x00007f29e7d99000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447650> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=26,queue=2,port=44943" #61 daemon prio=5 os_prio=0 tid=0x00007f2a08f2f800 nid=0x54e1 waiting on condition [0x00007f29e7e9a000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144db10> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=25,queue=1,port=44943" #60 daemon prio=5 os_prio=0 tid=0x00007f2a08f2d800 nid=0x54e0 waiting on condition [0x00007f29e7f9b000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a14476b0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=24,queue=0,port=44943" #59 daemon prio=5 os_prio=0 tid=0x00007f2a08f2b000 nid=0x54df waiting on condition [0x00007f29e809c000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447710> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=23,queue=2,port=44943" #58 daemon prio=5 os_prio=0 tid=0x00007f2a08f29800 nid=0x54de waiting on condition [0x00007f29e819d000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144db70> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=22,queue=1,port=44943" #57 daemon prio=5 os_prio=0 tid=0x00007f2a08f27800 nid=0x54dd waiting on condition [0x00007f29e829e000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144dbd0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=21,queue=0,port=44943" #56 daemon prio=5 os_prio=0 tid=0x00007f2a08f25800 nid=0x54dc waiting on condition [0x00007f29e839f000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447770> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=20,queue=2,port=44943" #55 daemon prio=5 os_prio=0 tid=0x00007f2a08f23000 nid=0x54db waiting on condition [0x00007f29e84a0000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144dc30> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=19,queue=1,port=44943" #54 daemon prio=5 os_prio=0 tid=0x00007f2a08f21800 nid=0x54da waiting on condition [0x00007f29e85a1000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a14477d0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=18,queue=0,port=44943" #53 daemon prio=5 os_prio=0 tid=0x00007f2a08f1f800 nid=0x54d9 waiting on condition [0x00007f29e86a2000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144dc90> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=17,queue=2,port=44943" #52 daemon prio=5 os_prio=0 tid=0x00007f2a08f1d000 nid=0x54d8 waiting on condition [0x00007f29e87a3000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447830> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=16,queue=1,port=44943" #51 daemon prio=5 os_prio=0 tid=0x00007f2a08f1b800 nid=0x54d7 waiting on condition [0x00007f29e88a4000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144dcf0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=15,queue=0,port=44943" #50 daemon prio=5 os_prio=0 tid=0x00007f2a08f19800 nid=0x54d6 waiting on condition [0x00007f29e89a5000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447890> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=14,queue=2,port=44943" #49 daemon prio=5 os_prio=0 tid=0x00007f2a08f17800 nid=0x54d5 waiting on condition [0x00007f29e8aa6000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144dd50> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=13,queue=1,port=44943" #48 daemon prio=5 os_prio=0 tid=0x00007f2a08f15000 nid=0x54d4 waiting on condition [0x00007f29e8ba7000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a14478f0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=12,queue=0,port=44943" #47 daemon prio=5 os_prio=0 tid=0x00007f2a08f13800 nid=0x54d3 waiting on condition [0x00007f29e8ca8000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144ddb0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=11,queue=2,port=44943" #46 daemon prio=5 os_prio=0 tid=0x00007f2a08f11800 nid=0x54d2 waiting on condition [0x00007f29e8da9000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447950> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=10,queue=1,port=44943" #45 daemon prio=5 os_prio=0 tid=0x00007f2a08f0f800 nid=0x54d1 waiting on condition [0x00007f29e8eaa000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144de10> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=9,queue=0,port=44943" #44 daemon prio=5 os_prio=0 tid=0x00007f2a08f0d000 nid=0x54d0 waiting on condition [0x00007f29e8fab000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144de70> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=8,queue=2,port=44943" #43 daemon prio=5 os_prio=0 tid=0x00007f2a08f0b800 nid=0x54cf waiting on condition [0x00007f29e90ac000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a14479b0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=7,queue=1,port=44943" #42 daemon prio=5 os_prio=0 tid=0x00007f2a08f09800 nid=0x54ce waiting on condition [0x00007f29e91ad000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144ded0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=6,queue=0,port=44943" #41 daemon prio=5 os_prio=0 tid=0x00007f2a08f08000 nid=0x54cd waiting on condition [0x00007f29e92ae000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447a10> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=5,queue=2,port=44943" #40 daemon prio=5 os_prio=0 tid=0x00007f2a08f06000 nid=0x54cc waiting on condition [0x00007f29e93af000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144df30> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=4,queue=1,port=44943" #39 daemon prio=5 os_prio=0 tid=0x00007f2a08f04800 nid=0x54cb waiting on condition [0x00007f29e94b0000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447a70> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=3,queue=0,port=44943" #38 daemon prio=5 os_prio=0 tid=0x00007f2a08f02800 nid=0x54ca waiting on condition [0x00007f29e95b1000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144df90> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=2,queue=2,port=44943" #37 daemon prio=5 os_prio=0 tid=0x00007f2a08f01000 nid=0x54c9 waiting on condition [0x00007f29e96b2000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447ad0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=1,queue=1,port=44943" #36 daemon prio=5 os_prio=0 tid=0x00007f2a08eff000 nid=0x54c8 waiting on condition [0x00007f29e97b3000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a144dff0> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.FifoWFPBQ.default.handler=0,queue=0,port=44943" #35 daemon prio=5 os_prio=0 tid=0x00007f2a08efd800 nid=0x54c7 waiting on condition [0x00007f29e98b4000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1447b30> (a java.util.concurrent.Semaphore$NonfairSync)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.parkAndCheckInterrupt(AbstractQueuedSynchronizer.java:836)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.doAcquireSharedInterruptibly(AbstractQueuedSynchronizer.java:997)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer.acquireSharedInterruptibly(AbstractQueuedSynchronizer.java:1304)
	at java.util.concurrent.Semaphore.acquire(Semaphore.java:312)
	at org.apache.hadoop.hbase.ipc.FastPathBalancedQueueRpcExecutor$FastPathHandler.getCallRunner(FastPathBalancedQueueRpcExecutor.java:105)
	at org.apache.hadoop.hbase.ipc.RpcExecutor$Handler.run(RpcExecutor.java:168)

   Locked ownable synchronizers:
	- None

"RpcServer.listener,port=44943" #19 daemon prio=5 os_prio=0 tid=0x00007f2a08ef8800 nid=0x54c6 runnable [0x00007f29e99b5000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1278648> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1278630> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a12268e8> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener.run(RpcServer.java:804)

   Locked ownable synchronizers:
	- None

"RpcServer.responder" #31 daemon prio=5 os_prio=0 tid=0x00007f2a08ece800 nid=0x54c5 runnable [0x00007f29e9ab6000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a122ed00> (a sun.nio.ch.Util$3)
	- locked <0x00000000a122ece8> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1226930> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.apache.hadoop.hbase.ipc.RpcServer$Responder.doRunLoop(RpcServer.java:1044)
	at org.apache.hadoop.hbase.ipc.RpcServer$Responder.run(RpcServer.java:991)

   Locked ownable synchronizers:
	- None

"main-EventThread" #34 daemon prio=5 os_prio=0 tid=0x00007f2a08edb800 nid=0x54c4 waiting on condition [0x00007f29e9bb7000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a10eb728> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.zookeeper.ClientCnxn$EventThread.run(ClientCnxn.java:494)

   Locked ownable synchronizers:
	- None

"main-SendThread(localhost:2181)" #33 daemon prio=5 os_prio=0 tid=0x00007f2a08eda800 nid=0x54c3 runnable [0x00007f29e9cb8000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a10eb3f8> (a sun.nio.ch.Util$3)
	- locked <0x00000000a10eb3e0> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a0cf90e8> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.apache.zookeeper.ClientCnxnSocketNIO.doTransport(ClientCnxnSocketNIO.java:349)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1081)

   Locked ownable synchronizers:
	- None

"RpcServer.reader=9,bindAddress=shg4873-ThinkPad-L460,port=44943" #29 daemon prio=5 os_prio=0 tid=0x00007f2a08d25000 nid=0x54c1 runnable [0x00007f29ea2bc000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a12257a8> (a sun.nio.ch.Util$3)
	- locked <0x00000000a12257c0> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a12266a8> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a12257d8> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a113b9e8> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=8,bindAddress=shg4873-ThinkPad-L460,port=44943" #28 daemon prio=5 os_prio=0 tid=0x00007f2a08d0a000 nid=0x54c0 runnable [0x00007f29ea3bd000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a12257f0> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1225808> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1226780> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1225820> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a113ba18> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=7,bindAddress=shg4873-ThinkPad-L460,port=44943" #27 daemon prio=5 os_prio=0 tid=0x00007f2a08cef000 nid=0x54bf runnable [0x00007f29ea4be000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1225838> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1225850> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1226810> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1225868> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a113b8c8> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=6,bindAddress=shg4873-ThinkPad-L460,port=44943" #26 daemon prio=5 os_prio=0 tid=0x00007f2a08cd4000 nid=0x54be runnable [0x00007f29ea5bf000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1225958> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1225940> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1226858> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a12259d0> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a113b8f8> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=5,bindAddress=shg4873-ThinkPad-L460,port=44943" #25 daemon prio=5 os_prio=0 tid=0x00007f2a08cb9800 nid=0x54bd runnable [0x00007f29ea6c0000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1278db0> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1278d98> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a12269c0> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1278d08> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a12ba658> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=4,bindAddress=shg4873-ThinkPad-L460,port=44943" #24 daemon prio=5 os_prio=0 tid=0x00007f2a08c9e800 nid=0x54bc runnable [0x00007f29ea7c1000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1278eb8> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1278ea0> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1226a50> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1278cf0> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a12ba688> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=3,bindAddress=shg4873-ThinkPad-L460,port=44943" #23 daemon prio=5 os_prio=0 tid=0x00007f2a08c84000 nid=0x54bb runnable [0x00007f29ea8c2000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1278240> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1278228> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1226ae0> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1278cd8> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a12ba6b8> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=2,bindAddress=shg4873-ThinkPad-L460,port=44943" #22 daemon prio=5 os_prio=0 tid=0x00007f2a08c69000 nid=0x54ba runnable [0x00007f29ea9c3000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1278348> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1278330> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1226b70> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1278cc0> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a12ba6e8> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=1,bindAddress=shg4873-ThinkPad-L460,port=44943" #21 daemon prio=5 os_prio=0 tid=0x00007f2a08bfa800 nid=0x54b9 runnable [0x00007f29eaac4000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1278450> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1278438> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1226c00> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1278ca8> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a12ba718> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"RpcServer.reader=0,bindAddress=shg4873-ThinkPad-L460,port=44943" #20 daemon prio=5 os_prio=0 tid=0x00007f2a08bfa000 nid=0x54b8 runnable [0x00007f29eb1c5000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a1278558> (a sun.nio.ch.Util$3)
	- locked <0x00000000a1278540> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a1226c90> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:101)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.doRunLoop(RpcServer.java:698)
	- locked <0x00000000a1278c90> (a org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader)
	at org.apache.hadoop.hbase.ipc.RpcServer$Listener$Reader.run(RpcServer.java:685)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- <0x00000000a12ba748> (a java.util.concurrent.ThreadPoolExecutor$Worker)

"ProcessThread(sid:0 cport:-1):" #16 prio=5 os_prio=0 tid=0x00007f2a0895a800 nid=0x54b5 waiting on condition [0x00007f29eb6d0000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1033180> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.zookeeper.server.PrepRequestProcessor.run(PrepRequestProcessor.java:120)

   Locked ownable synchronizers:
	- None

"SyncThread:0" #15 prio=5 os_prio=0 tid=0x00007f2a08981800 nid=0x54b4 waiting on condition [0x00007f29eb7d1000]
   java.lang.Thread.State: WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a1062368> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
	at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
	at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
	at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
	at org.apache.zookeeper.server.SyncRequestProcessor.run(SyncRequestProcessor.java:127)

   Locked ownable synchronizers:
	- None

"SessionTracker" #14 prio=5 os_prio=0 tid=0x00007f2a08957000 nid=0x54b3 in Object.wait() [0x00007f29eb8d2000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at org.apache.zookeeper.server.SessionTrackerImpl.run(SessionTrackerImpl.java:146)
	- locked <0x00000000a100e4b0> (a org.apache.zookeeper.server.SessionTrackerImpl)

   Locked ownable synchronizers:
	- None

"NIOServerCxn.Factory:0.0.0.0/0.0.0.0:2181" #13 daemon prio=5 os_prio=0 tid=0x00007f2a0894a000 nid=0x54b2 runnable [0x00007f29f0171000]
   java.lang.Thread.State: RUNNABLE
	at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
	at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
	at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
	at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
	- locked <0x00000000a10331c8> (a sun.nio.ch.Util$3)
	- locked <0x00000000a10331e0> (a java.util.Collections$UnmodifiableSet)
	- locked <0x00000000a0dc2cd8> (a sun.nio.ch.EPollSelectorImpl)
	at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
	at org.apache.zookeeper.server.NIOServerCnxnFactory.run(NIOServerCnxnFactory.java:178)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"process reaper" #11 daemon prio=10 os_prio=0 tid=0x00007f2a08901000 nid=0x54b0 waiting on condition [0x00007f29f01aa000]
   java.lang.Thread.State: TIMED_WAITING (parking)
	at sun.misc.Unsafe.park(Native Method)
	- parking to wait for  <0x00000000a0d475b0> (a java.util.concurrent.SynchronousQueue$TransferStack)
	at java.util.concurrent.locks.LockSupport.parkNanos(LockSupport.java:215)
	at java.util.concurrent.SynchronousQueue$TransferStack.awaitFulfill(SynchronousQueue.java:460)
	at java.util.concurrent.SynchronousQueue$TransferStack.transfer(SynchronousQueue.java:362)
	at java.util.concurrent.SynchronousQueue.poll(SynchronousQueue.java:941)
	at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1066)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

   Locked ownable synchronizers:
	- None

"Service Thread" #9 daemon prio=9 os_prio=0 tid=0x00007f2a080fd000 nid=0x54ad runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"C1 CompilerThread2" #8 daemon prio=9 os_prio=0 tid=0x00007f2a080f8800 nid=0x54ac waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"C2 CompilerThread1" #7 daemon prio=9 os_prio=0 tid=0x00007f2a080f3800 nid=0x54ab waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"C2 CompilerThread0" #6 daemon prio=9 os_prio=0 tid=0x00007f2a080f1800 nid=0x54aa waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"Signal Dispatcher" #5 daemon prio=9 os_prio=0 tid=0x00007f2a080ef800 nid=0x54a9 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"Surrogate Locker Thread (Concurrent GC)" #4 daemon prio=9 os_prio=0 tid=0x00007f2a080ed800 nid=0x54a8 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

   Locked ownable synchronizers:
	- None

"Finalizer" #3 daemon prio=8 os_prio=0 tid=0x00007f2a080c6000 nid=0x54a7 in Object.wait() [0x00007f29f8daf000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
	- locked <0x00000000a0d475e0> (a java.lang.ref.ReferenceQueue$Lock)
	at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
	at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)

   Locked ownable synchronizers:
	- None

"Reference Handler" #2 daemon prio=10 os_prio=0 tid=0x00007f2a080c1800 nid=0x54a6 in Object.wait() [0x00007f29f8eb0000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at java.lang.Object.wait(Object.java:502)
	at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
	- locked <0x00000000a0d47610> (a java.lang.ref.Reference$Lock)
	at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)

   Locked ownable synchronizers:
	- None

"main" #1 prio=5 os_prio=0 tid=0x00007f2a0800e800 nid=0x549f in Object.wait() [0x00007f2a11946000]
   java.lang.Thread.State: WAITING (on object monitor)
	at java.lang.Object.wait(Native Method)
	at java.lang.Thread.join(Thread.java:1249)
	- locked <0x00000000a142afd8> (a org.apache.hadoop.hbase.util.JVMClusterUtil$MasterThread)
	at java.lang.Thread.join(Thread.java:1323)
	at org.apache.hadoop.hbase.master.HMasterCommandLine.waitOnMasterThreads(HMasterCommandLine.java:288)
	at org.apache.hadoop.hbase.master.HMasterCommandLine.startMaster(HMasterCommandLine.java:226)
	at org.apache.hadoop.hbase.master.HMasterCommandLine.run(HMasterCommandLine.java:137)
	at org.apache.hadoop.util.ToolRunner.run(ToolRunner.java:70)
	at org.apache.hadoop.hbase.util.ServerCommandLine.doMain(ServerCommandLine.java:126)
	at org.apache.hadoop.hbase.master.HMaster.main(HMaster.java:2573)

   Locked ownable synchronizers:
	- None

"VM Thread" os_prio=0 tid=0x00007f2a080ba000 nid=0x54a5 runnable

"Gang worker#0 (Parallel GC Threads)" os_prio=0 tid=0x00007f2a08020000 nid=0x54a0 runnable

"Gang worker#1 (Parallel GC Threads)" os_prio=0 tid=0x00007f2a08021000 nid=0x54a1 runnable

"Gang worker#2 (Parallel GC Threads)" os_prio=0 tid=0x00007f2a08023000 nid=0x54a2 runnable

"Gang worker#3 (Parallel GC Threads)" os_prio=0 tid=0x00007f2a08024800 nid=0x54a3 runnable

"Concurrent Mark-Sweep GC Thread" os_prio=0 tid=0x00007f2a08067800 nid=0x54a4 runnable

"VM Periodic Task Thread" os_prio=0 tid=0x00007f2a08100000 nid=0x54ae waiting on condition

JNI global references: 307