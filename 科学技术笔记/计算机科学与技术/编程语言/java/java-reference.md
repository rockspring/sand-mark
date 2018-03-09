java的四种引用类型，强引用(StrongReference)、软引用(SoftReference)、弱引用(WeakReference)、虚引用(PhantomReference)

# Reference

Reference的静态代码区创建一个ReferenceHandler线程并启动。Reference有一个静态字段Reference<Object> pending，用于存放需要进入ReferenceQueue的引用。Reference有一个Reference<T> discovered字段，当当前Reference处于pending状态时，这个discovered字段指向悬挂列表（pending list）或null。ReferenceHandler线程执行时，依次取出静态字段Reference<Object> pending，并摘取下来保存到局部变量Reference<Object> r，然后pending指向他的discovered字段指向的悬挂列表。对摘下来的r，放入ReferenceQueue引用队列。

pending：指向待进入队列的引用链表。

Reference是有状态的，分别为Active、Pending、Enqueued、Inactive。

Active
受制于垃圾收集器的特殊对待。一段时候后，垃圾收集器探测到被引用对象的可达性变成一个合适的状态（appropriate state）时，修改引用的状态为Pending或Inactive，这取决于引用是否注册了ReferenceQueue引用队列。如果注册了引用队列，引用同时要加入到入队悬挂列表（Reference<Object> pending）。新创建的引用状态为Active。

Pending
引用是入队悬挂列表（Reference<Object> pending）的一个元素。只有注册ReferenceQueue引用队列的引用才会有这个状态。

Enqueued
引用已经进入ReferenceQueue引用队列。当它从队列中被移除后，状态变成Inactive。只有注册ReferenceQueue引用队列的引用才会有这个状态。

Inactive
引用的最终状态。

Reference不使用单独的状态字段来记录，而是通过约定规则编码到ReferenceQueue<? super T> queue字段和Reference next字段。

如果引用Reference注册了ReferenceQueue，queue = ReferenceQueue表示Reference为Active状态。如果引用没注册ReferenceQueue，即ReferenceQueue.NULL。并且next = null，则表示Reference为Active状态。

queue = ReferenceQueue且next = this，则表示Reference为Pending状态。

queue = ReferenceQueue.ENQUEUED且next = this或next = 队列中其他的实例。则表示Reference为Enqueued状态。

queue = ReferenceQueue.NULL且next = this，则表示Reference为Inactive状态。


发现active引用的垃圾收集器线程和可能执行enqueue操作的应用程序线程是并发地执行的。为了防止互不干扰，垃圾收集器通过discovered字段链接discovered object。

discovered字段也用于入队悬挂列表（Reference<Object> pending）中链接引用对象。


java的对象垃圾收集器直接调用java.lang.ref.ReferenceQueue#enqueue(Reference<? extends T> r)方法。应用程序的引用对象调用自身的java.lang.ref.Reference#enqueue。

## SoftReference

SoftReference用于实现内存敏感的缓存

SoftReference1->object

SoftReference2->otherObject.StrongReference->chainObject.StrongReference->object

垃圾收集器判断object是一个SoftReference可达的对象，自动回收SoftReference1和SoftReference2，同时或稍后一点把SoftReference1和SoftReference2放入SoftReference注册的ReferenceQueue。

SoftReference什么时间被清理没有约束，一组指向不同对象的SoftReference被清理的顺序没有约束。java虚拟机实现偏向于不清楚最近创建的或最近使用的软引用。

在java虚拟机抛出OutOfMemoryError异常之前，确保所有的SoftReference被清理了。

# WeakReference

不能阻止被引用的对象被finalizable，执行finalize后变成finalized，被回收变成reclaimed。

垃圾收集器判断一个对象是弱可达的。清理掉这个对象的所有的弱引用。清理掉通过其他对象的强应用或软引用链路达到object的弱引用。同时申明所有弱引用可达的对象状态为finalizable。同时或稍后一点把WeakReference1和WeakReference2放入WeakReference注册的ReferenceQueue。

WeakReference1->object

WeakReference2->otherObject.SoftReference->chainObject.StrongReference->object

用途：WeakHashMap使用了WeakReference实现canonicalizing mappings。

# PhantomReference

垃圾收集器判定一个对象是PhantomReference可达时，同时或随后一段时间PhantomReference被放入ReferenceQueue引用队列。为了确保可回收对象不会再次变得不可回收，PhantomReference指向的对象不可以再次被检索出来。

PhantomReference不是自动清理的，只是进入队列。PhantomReference引用的对象只有PhantomReference被清理后才会被回收。

用途：用于安排回收前的清理动作。更灵活的方式。java对象终结机制。

# Finalizer-->FinalReference

# ReferenceQueue

# java.lang.System#gc

# WeakHashMap

