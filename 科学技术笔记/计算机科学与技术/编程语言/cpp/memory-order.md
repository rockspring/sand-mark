# memory_order_relaxed

store a;
load b;

store memory_order_relaxed

store c;
load d;


# memory_order_consume


store a;
load b;

load m; memory_order_consume

store c;
load d;

load m;

store m;

当前线程中，原子操作之后的load m;和store m;不可以重排序到load m; memory_order_consume前面。

在其他线程中，原子操作写入的m对当前线程可见。

# memory_order_acquire

store a;
load b;

load m; memory_order_acquire

store c;
load d;

load m;

store m;

在当前线程中，原子操作之后的读或写操作store c;load d;不能重排序到load m; memory_order_acquire前面。阻止任何读写。

在其他线程中，原子操作写入的m对当前线程可见。只要其他线程中原子操作写入的m完成了，原子操作之前的写入也完成了。

# memory_order_release

store a;
load b;

store m; memory_order_acquire

store c;
load d;

load m;

store m;


在当前线程中，原子操作之前的读或者写store a;load b;不能重排序到store m; memory_order_acquire之后。阻止任何读写。

当前线程的原子写入及原子写入前面的写入对其他线程可见。


# memory_order_acq_rel

读-修改-写

结合了acquire和release操作

原子操作之前的读、写不能重排序到原子操作之后。

原子操作之后的读、写不能重排序到原子操作之前。

当前线程的写操作结果对其他线程可见。

# memory_order_seq_cst

读-修改-写

结合了acquire和release操作

所有的线程看到的操作顺序是一样的。






# store

memory_order_release, memory_order_acq_rel, or memory_order_ seq_cst


# load

memory_order_consume, memory_order_acquire, or memory_order_seq_cst


操作链构成了一个发布序列release sequence

初始的store与最终的load构成了synchronizes-with关系。

memory_order_acquire or memory_order_ seq_cst

初始的store与最终的load构成了dependency-ordered-before关系。

memory_order_consume

