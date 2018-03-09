# Scheme 1 -- Straightforward 

## START_TIMER

寻找一个内存地址

在找到的内存地址设置一个特定的时钟周期

## PER_TICK_BOOKKEEPING

每过一个tick，每一个未结束的时钟的时钟周期下降一个tick

如果有时钟的时钟周期已将降至0，调用EXPIRY_PROCESSING

## 内存占用情况

每个未完成的时钟都一个记录

# Scheme 2 -- ORDERED LIST/TIMER QUEUES

时钟存储在有序列表中

PER\_TICK\_BOOKKEEPING的延时下降至跟START_TIMER

存储每个时钟过期的绝对时间

最先过期的时钟存储在列表头，其它的时钟按序存储

由于列表是按过期时间有序排列的，PER\_TICK\_PROCESSING只需要递增当天的时间，然后比较当天的时间和列表头存储的时钟的绝对过期时间。如果当天时间大于或等于绝对过期时间，从列表删除列表头元素，调用EXPIRY_PROCESSING。一只删除到列表头元素存储的时钟绝对过期时间比当前时间大为止。

## START_TIMER

搜索列表找到一个合适的位置插入新的时钟。最坏的情形延迟为O(n)。

平均延时取决于时钟的时钟间隔和调用START_TIMER的程序的到达时间。

# Scheme 3: Tree-based Algorithms 

一个链表是实现优先级队里的一种方式

对于大n，基于树的结构更好。非平衡二叉树、堆、后序树（ post-order）、尾序树（ end-order）、最左树（leftist-trees）。

这些数据结构的目的是将START_TIMER的时间复杂度从O(n)降低至O(log(n))