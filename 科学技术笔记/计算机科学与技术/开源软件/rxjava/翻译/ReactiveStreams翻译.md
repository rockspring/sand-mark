# 响应式数据流（Reactive Streams）

声明：本文翻译自[https://github.com/reactive-streams/reactive-streams-jvm/blob/master/README.md](https://github.com/reactive-streams/reactive-streams-jvm/blob/master/README.md)

2017年8月23日

Reactive Streams的目的是提供一个标准，用于规范具备非阻塞背压的异步流处理。

最新的版本maven构件如下

```
<dependency>
  <groupId>org.reactivestreams</groupId>
  <artifactId>reactive-streams</artifactId>
  <version>1.0.1</version>
</dependency>
<dependency>
  <groupId>org.reactivestreams</groupId>
  <artifactId>reactive-streams-tck</artifactId>
  <version>1.0.1</version>
  <scope>test</scope>
</dependency>
```

## 一、目标，设计和范围

流数据处理，尤其容量提前不确定的实时活动数据，需要在一个异步系统中受到特别对待。最主要的一个问题是，资源消耗需要仔细控制使得一个快速的数据源不会淹没流处理链路的目的端。为了并行地使用计算资源，如网络和多个CPU，不同时性是必要的。

Reactive Streams的主要目的是掌管流数据在异步边界之间的交换，想象一下把数据元素传递到另一个线程或线程池，然而确保接收端不会被强制缓存任意数量的数据。换句话说，背压是这个模型的一部分，允许连接两个线程的队列是有界的。如果背压信号是同步的，异步处理的好处就会被否定。因此reactive streams实现的各方面中的全非阻塞和异步行为需要仔细考虑。

这份规范的意图是允许创建很多一致性的实现，所有的实现借助于遵守同样的规则使得各自可以平滑地互操作，保留了上述横跨流处理应用的整个处理图提及的好处和特征。

应当注意到，流操作（转换、分裂、合并）的精确性质不被这份规范包含。reactive streams仅仅关注连接不同API组件之间的流数据。在系统实现开发当中，应当仔细确保所有组合流的基础方式应当能表达。

总结一下，reactive streams是一个标准和规范，用于jvm平台的面向流的代码库，如下

处理无边界的数据流序列

在组件之间异步低投递数据元素

强制要求非阻塞背压

reactive streams规范由以下几部分组成

API规范了实现reactive streams的及获得不同实现之间的互操作性的数据类型。

TCK(The Technology Compatibility Kit)是一个一致性测试实现的标准测试套件。

## 二、API组件

API由如下组件构成，需要具体的reactive streams系统实现提供。

1，发布者publisher

2，订阅者subscriber

3，订阅subscription

4，处理器processor

一个发布者是一个无边界数据序列的提供者，根据从订阅者接收到的需求推送数据给订阅者。

为了响应publisher.subscribe(Subscriber)，在subscriber上可能的调用方法序列通过如下协议提供：

onSubsribe onNext*(onError | onComplete)?

这意味着只要subscription没有被取消，onSubsribe方法总是被调用，然后是可能数量无上限的onNext（由subscriber请求）方法，然后如果这里有一个故障，调用onError，如果不再有元素了，调用onComplete方法。

注意

如下规范使用绑定词汇的大写形式，来自https://www.ietf.org/rfc/rfc2119.txt。

## 三、术语

|词条|描述|
|----|----|
|Signal|作为名字：onSubscribe, onNext, onComplete, onError, request(n) or cancel方法之一。作为动词：调用一个方法。|
|Demand|作为名字，publisher即将投递的subscriber请求的累积量。作为一个动词，请求数据元素|
|Synchronous(ly)|在调用线程执行|
|Return normally|仅仅返回一个调用者申明的类型值。唯一的报告错误给subscriber的合法方式是通过onError方法|
|Responsivity|响应敏捷性或响应能力。在这个文档中，用于表示不同的组件不应该损害彼此的响应敏捷性或响应能力|
|Non-obstructing|描述一个方法尽可能快的在一个调用线程中执行。这意味着，避免重计算或其它拖慢调用者线程的其它事情。|
|Terminal state|对于发布者：当onComplete或onError被调用之后的状态。对订阅者，当onComplete或onError已经接受了|
|NOP|对调用线程没有可探测影响的执行，可以安全地被调用无数次。|
|External synchronization|线程安全目的的访问协调在本规范定义的构件外部实现，使用技术，如atomics，monitors或locks，但不限于这些|

## 四、规范

### 1. 发布者

```
public interface Publisher<T> {
    public void subscribe(Subscriber<? super T> s);
}
```

|ID|规则|
|----|----|
|1|Publisher发送给Subscriber的onNext信号数量必须少于或等于Subscriber的Subscription全部时间内请求的元素数量|
|意图|这条规则的意图是清晰地表明发布者不能发起多于订阅者请求的数据信号数量。这条规则有一个隐含的且很重要的结果：因为需求仅仅在被接受之后得到满足，请求元素和接受元素之间存在一个先于发生关系|
|2|一个Publisher可能发起比请求更少的onNext信号，通过调用onComplete和onError方法终止Subscription|
|意图|这条规则的意图是清晰地表明一个Publisher不能保证它将产生与请求数量同样多的数据元素；它可能一个数据元素都不产生；它可能处于故障状态；它可能为空或已经完成状态|
|3|发送给Subscriber的onSubscribe, onNext, onError and onComplete信号必须是以一种线程安全的方式发起。如果由多个线程操作，必须使用外部同步|
|意图|这条规则的意图很清晰地表明了如果发布者打算从多个线程或不同的线程发起信号，必须采用外部同步机制。|
|4|如果Publisher发生故障，它必须发起一个onError信号|
|意图|这条规则的意图很清晰地表明了一个发布者在它探测到它不能继续处理时，要负责同志它的订阅者，订阅者必须给一个清理资源或处理发布者故障的机会。|
|5|如果Publisher成功终止（有限数据流），它必须发起一个onComplete信号。|
|意图|这条规则的意图很清晰地表明了一个发布者达到终止状态时负责通知他的订阅者，订阅者然后根据这个信息作出动作，清理资源等|
|6|如果一个Publisher给Subscriber发起onError或onComplete信号，Subscriber的订阅必须被取消|
|意图|这条规则的意图时确保一个订阅无论它是否被取消都要被同等对待，发布者发起onError或onComplete信号|
|7|一旦在Publisher和Subscriber之间发起了onComplete和onError信号导致各自达到了最终状态，不能再有信号被发起|
|意图|这条规则的意图是确保onError和onComplete是Publisher和Subscriber之间发起的最终信号，使得各自进入最终状态|
|8|如果一个Subscription被取消了，他的Subscriber必须最终接受信号达到停止状态。|
|意图|这条规则的意图是确保当订阅取消方法被调用后，发布者尊重一个订阅者取消订阅的请求。|
|9|Publisher调用subscribe方法时必须先调用Subscriber的onSubscribe方法，然后调用其他方法，必须正常返回。除非Subscriber为null，它必须跑出了空指针异常，其它情况，发起故障信号的合法方式是调用onError|
|意图|这条规则的意图是确保onSubsribe信号总是在任何其它信号之前被发起，进而当Subscriber收到这个信号后执行初始化逻辑。另外，onSubsribe必须至多被调用一次。如果Subscriber为null，没有地方可以发起信号，给调用者抛出空指针异常。可能的情形例子：一个有状态的发布者由于底层资源的数量限制、耗尽或处于最终状态会被压倒。|
|10|Publisher的subscribe可能会被调用很多次，但是每次必须使用不同的Subscriber。|
|意图|这条规则的意图是让subscribe的调用者意识到同一个通用的Publisher和同一个通用的Subscriber不能支持被使用多次。更进一步，它要求无论subscribe被调用多少次，它的语义要保持不变|
|11|一个Publisher可能支持多个Subscriber，能决定每一个Subscription是否是单播还是多播。|
|意图|这条规则的意图是给发布者的实现灵活性，决定支持多少订阅者及数据元素如何分发。|

### 2. 订阅者


```
public interface Subscriber<T> {
    public void onSubscribe(Subscription s);
    public void onNext(T t);
    public void onError(Throwable t);
    public void onComplete();
}
```

|ID|规则|
|----|----|
|1|一个Subscriber在接受onNext信号之前通过Subscription.request(long n)发起需求信号。|
|意图|这条规则的意图是陈述这样一个事实，订阅者负责发起请求信号决定什么时候能够并且愿意接受多少数量的数据。|
|2|如果一个Subscriber怀疑它的信号处理将对Publisher的响应能力产生负面影响，推荐Subscriber异步地派发信号。|
|意图|这条规则的意图是从执行视角看，一个订阅者不应该妨碍发布者的进度。换句话说，订阅者不应当发布者在CPU资源上处于饥饿状态。|
|3|Subscriber的onComplete()和onError(Throwable t)方法必须不能调用Subscription或Publisher的任何方法。|
|意图|这条规则的意图是阻止在完成信号处理过程中发布者、订阅和订阅者三者之间发生循环及竞争条件|
|4|在Subscriber接受到onComplete()和onError(Throwable t)信号之后，必须认为Subscription已经被取消了|
|意图|这条规则的意图是确保订阅者尊重发布者的终止信号。一个订阅在订阅者收到onComplete和onError信号之后就简单地处于无效状态了。|
|5|如果一个Subscriber先前有一个活跃度Subscription，它在接受到onSubscribe信号之后必须调用Subscription.cancel()。|
|意图|这条规则的意图是阻止两个或更多个独立的订阅者认为她们能够与同一个订阅者交互。强调这条规则意味着资源泄漏能够被阻止，因为额外的订阅将会被取消。|
|6|如果Subscription不再需要了，一个Subscriber必须调用Subscription.cancel()|
|意图|这条规则的意图是建立这样一个事实，订阅者不能在当订阅不再需要时就仅仅丢掉它，它必须调用cancel方法是的订阅拥有的资源能够被安全地、及时地回收。一个这样的例子是一个仅对一个特定元素感兴趣的订阅者将调用取消订阅并给发布者发起完成信号。|
|7|一个Subscriber必须确保Subscription上的所有调用发生自同一个线程或有响应的外部同步机制。|
|意图|这条规则的意图是如果订阅者通过两个或更多线程并发地使用订阅，必须添加一个外部同步机制。|
|8|一个Subscriber在调用了Subscription的cancel方法之后，如果这里依然悬挂着已经请求的数据，必须准备接受一个或多个onNext信号。Subscription的cancel方法不保证立即清理底层的资源。|
|意图|这条规则的意图是强调在cancel被调用和发布者看到这个调用之间存在一个延迟。|
|9|一个Subscriber必须在Subscription的request(long n)方法有没有调用之前准备接受onComplete信号。|
|意图|这条规则的意图是建立这样一个事实，完成与数据需求流程是无关的，允许过早完成，避免需要轮训方式去完成。|
|10|一个Subscriber必须在Subscription的request(long n)方法有没有调用之前准备接受onError信号。|
|意图|这条规则的意图是建立这样一个事实，发布者发生故障可能完全与接受的数据需求信号无关。这意味订阅者不必以轮询的方式找出不能履行它的请求的发布者。|
|11|一个Subscriber必须确保它的所有信号方法的调用发生在相应的信号处理之前。一个Subscriber必须仔细合理地发布信号给它的处理逻辑。|
|意图|这条规则的意图是建立这样一个事实，确保异步信号处理的的线程安全性是订阅者实现的责任。|
|12|Subscriber的onSubscribe方法在给定Subscriber（基于对象相等判定是否为同一个对象）上必须之多调用一次。|
|意图|这条规则的意图是建立这样一个事实，必须嘉定同一个订阅者仅仅能够被订阅最多一次。使用a.equals(b)方式判定是否为同一个订阅者。|
|13|调用onSubscribe, onNext, onError or onComplete方法必须正常返回，除非当它们接受到的参数是null，这时候必须抛出一个空指针异常给调用者。任何其它情形，订阅者发起故障信号的唯一合法方式通过取消订阅。违反本规则的情形下，任何与订阅者关联的订阅必须取消，调用者必须制造满足运行时环境的错误条件|
|意图|这条规则的意图是建立这样一种用于订阅者的方法语义和发布者在哪种情形下违反规则时允许做什么。制造满足运行时环境的错误条件将意味着记录错误或使得其它组件意识到这个情形，因为这个错误不能向有错误的订阅者发起。|

### 3. 订阅

```
public interface Subscription {
    public void request(long n);
    public void cancel();
}
```

|ID|规则|
|----|----|
|1|Subscription的request和cancel方法必须仅能在它的Subscriber上下文中调用。|
|意图|这条规则的意图是建立这样一个事实，一个订阅表示一个订阅者和一个发布者之间的唯一关系。订阅者控制什么时候请求数据元素和什么时候不再需要更多数据元素。|
|2|Subscription必须允许Subscriber同步地从onNext或onSubscribe方法调用Subscription的request。|
|意图|这条规则的意图是清楚地表明request的实现必须是可重入的，这可在request和onNext之间互相递归调用及最终的onComplete或onError调用时避免栈溢出。者意味着发布者能够是同步的，也就是在调用request的线程发起onNext信号。|
|3|Subscription的request必须为Publisher和Subscriber之间的同步递归调用安置一个调用次数上界。|
|意图|这条规则的意图是给3.2做一个补充，在request和noNext（及最终的onComplete或onError）方法之间的互相递归调用安置一个调用次数上限。为了保护栈空间，给实现的推荐值是1。一个不期待发生的同步、打开递归的例子是“Subscriber.onNext -> Subscription.request -> Subscriber.onNext -> …”，这将充满整个调用线程栈。|
|4|Subscription的request方法应当在一个较短的时限内返回，以提高它的调用者的响应性。|
|意图|这条规则的意图是建立这样一个事实，一个request成为一个没有妨碍性的方法，应当在调用线程中尽快执行，避免繁重的计算和其它拖慢调用者线程执行的事情。|
|5|Subscription的cancel方法必须在一个较短的时限内返回以提高它的调用者的响应性，并且必须具备幂等性和线程安全性。|
|意图|这条规则的意图是建立这样一个事实，一个cancel成为一个没有妨碍性的方法，应当在调用线程中尽快执行，避免繁重的计算和其它拖慢调用者线程执行的事情。更进一步，它能够被调用多次不产生任何负面影响。|
|6|在Subscription被取消之后，对它的额外request请求必须无任何作用。|
|意图|这条规则的意图是在订阅取消和后续的无作用的更多元素请求之间建立一个因果关系。|
|7|在Subscription被取消之后，对它的额外cancel请求必须无任何作用。|
|意图|这条规则的意图被3.5取代。|
|8|当Subscription没有被取消，Subscription的request(long n)必须注册给定数量的数据元素以待生产给响应的订阅者。|
|意图|这条规则的意图是确保request是一个叠加操作，同时确保已请求的一批数据元素被投递到订阅者。|
|9|当Subscription没有被取消，Subscription的request(long n)必须在参数值小于或等于0时发起onError信号，携带java.lang.IllegalArgumentException异常。这个错误原因信息应当能解释非负数请求信号是不合法的。|
|意图|这条规则的意图是阻止有错误的实现继续处理而不引起任何异常。因为请求具有叠加性，请求负数数量或0数量数据元素，很有可能在代表订阅者中导致错误计算。|
|10|当Subscription没有被取消，Subscription的request(long n)可能在这个或其它订阅者身上同步调用onNext方法|
|意图|这条规则的意图是建立这样一个事实，它允许创建同步发布者，也就是在调用线程执行它们的逻辑的发布者。|
|11|当Subscription没有被取消，Subscription的request(long n)可能在这个或其它订阅者身上同步调用onComplete或onError方法|
|意图|这条规则的意图是建立这样一个事实，它允许创建同步发布者，也就是在调用线程执行它们的逻辑的发布者。|
|12|当Subscription没有被取消，Subscription的cancel方法必须请求发布者终究要停止给订阅者发信号。这个操作不必立即影响订阅。|
|意图|这条规则的意图是建立这样一个事实，取消一个订阅的期待最终要受到发布者的尊重，但不可否认，它可能需要一段时间后才能接收到信号。|
|13|当Subscription没有被取消，Subscription的cancel方法必须请求发布者终究要丢掉任何与订阅者相关的引用。|
|意图|这条规则的意图是确保订阅者在订阅不再有效后要被恰当地当作垃圾回收。重新订阅同样的订阅者是不受鼓励的，但是规范没有指示它是不允许的，因为那样将意味着必须用就保存已经取消的订阅|
|14|当Subscription没有被取消，如果没有其它的Subscription存在并且发布者是有状态的，Subscription的cancel方法可能引起发布者转入到shut-down状态。|
|意图|这条规则的意图是允许发布者在应对现有订阅者取消信号之后紧接着onSubscribe为新的订阅者发起onComplete或onError信号|
|15|调用Subscription的cancel必须正常返回。|
|意图|这条规则的意图是不允许实现在cancel被调用之后抛出异常。|
|16|调用Subscription的request必须正常返回。|
|意图|这条规则的意图是不允许实现在request被调用之后抛出异常。|
|17|一个Subscription必须支持无限数量的request调用，并且必须支持多达2^63-1 (java.lang.Long.MAX_VALUE)的数据请求需求量。一个数据需求请求量等于或大于2^63-1 (java.lang.Long.MAX_VALUE)被发布者认为是有效无界。|
|意图|这条规则的意图是一个Subscription必须支持任何大于0的增量，任何数量调用request方法请求无限数量数的数据元素。由于在当前或可预见的未来之内的硬件水平下在一个合理的时间内（每个元素需要1纳秒，需要292年）不容易达到填满2^63-1这个需求量，允许发布者在这点上停止跟踪需求量。|


一个Subscription被一个Publisher和一个Subscriber者唯一共享，用于在两者之间调解数据传递。这解释了为什么subscribe不返回创建好的Subscription而是返回void是合理的。Subscription仅通过onSubscribe回掉方法传递到Subscriber。

### 4.处理器（Processor）

```
public interface Processor<T, R> extends Subscriber<T>, Publisher<R> {
}
```

|ID|规则|
|----|----|
|1|一个Processor表示一个处理状态，它既是一个Subscriber也是一个Publisher，必须遵循两者的合约。|
|意图|这条规则的意图是建立这样一个事实，处理器的行为同时受到发布者规范和订阅者规范限制。|
|2|一个Processor可能会选择从onError信号中恢复。如果它选择这么做，它必须认为Subscription已经取消，否则它必须立即传递onError信号到她的所有订阅者。|
|意图|这条规则的意图是表明实现不仅仅简单地转换数据是可能的。|

尽管没有指示，当它的最后一个订阅者取消了它的订阅，取消一个处理的上游订阅进而让取消信号传递到上游是个好主意。

## 五、异步对比同步处理

Reactive Streams API规定所欲的数据元素处理（onNext）或终止信号（onError、onComplete）必须不能阻塞发布者。然后，每一个on*处理器即能够同步也能够异步地处理事件。看如下例子：

```
nioSelectorThreadOrigin map(f) filter(p) consumeTo(toNioSelectorOutput)
```

它又一个异步数据源头和一个异步数据终点。我们假设源头和终点都是selector事件循环。Subscription.request(n)必须能够从终点链接到源头。现在就是每个系统实现选择如何做到这点。

接下来我们使用管道符号“|”表示异步边界（队列和调度器的边界），使用R#表示资源（线程）

```
nioSelectorThreadOrigin | map(f) | filter(p) | consumeTo(toNioSelectorOutput)
-------------- R1 ----  | - R2 - | -- R3 --- | ---------- R4 ----------------
```

在这个例子中，三个消费者中每一个，map、filter和consumeTo异步地调度工作。可能在同样的事件循环（使用trampoline调度器），可能是独立的线程。

```
nioSelectorThreadOrigin map(f) filter(p) | consumeTo(toNioSelectorOutput)
------------------- R1 ----------------- | ---------- R2 ----------------
```

以上例子中，唯一的异步调度发生在最后一步，它将工作加入到NioSelectorOutput事件循环。map和filter是同步地在原线程执行。

再来看一下另一个例子，实现体将操作融合到最后的消费者。

```
nioSelectorThreadOrigin | map(f) filter(p) consumeTo(toNioSelectorOutput)
--------- R1 ---------- | ------------------ R2 -------------------------
```

所有的以上变体是“异步数据流”。它们都有他们的定位，每一个在性能和实现复杂度面前有不同的权衡。

Reactive Streams合约允许实现体在非阻塞、异步、动态推拉数据流的范围内具备管理资源和调度及混合异步兼同步处理的弹性。

为了允许Publisher/Subscription/Subscriber/Processor的API元素全异步实现，定义在这些接口的所有的方法返回void。

## 六、受订阅者控制的队列边界

一个底层设计原则之一是所有的缓冲区大小是有界的，这些边界必须被订阅者可知且可控。这些边界使用数据元素数量（转换成调用onNext的次数）这种术语表达。任何又支持无限数据流（尤其高吞吐量）的实现体需要以避免内存匮乏错误和限制资源使用的方式实施边界。

因为背压是强制性的，可以避免使用无边界的缓冲区。通常，唯一可能需要无边界地增长队列的时刻是当发布者比订阅者在一段时间内维持了一个更高的数据速率，但是这种场景被背压替代处理了。

队列边界可以通过订阅者为恰当的数据量发起数据需求信号控制。订阅者在任何时间点知道如下信息：

*** 总共请求的数据元素量：P

*** 已经处理的数据元素数量：N

然后直到更多的数据需求发起到发布者前，可能达到的最大的数据元素数量是P-N。在订阅者知道她的输入队列中有B数量的数据元素后，这个边界可以精确计算为P-B-N。

无论源头是否能够背压，这些边界必须能够独立地被发布者尊重。在一些源头生产率不能被影响的情形，如时钟的嘀嗒或鼠标移动，发布者必须在缓存数据或丢弃数据元素之间做出选择，以遵循强加的边界。

订阅者在接收一个元素之后发起一个元素的需求信号有效地实现了“停-等”协议，这个协议里需求信号数量与回答确认数量相等。回答确认的成本可以通过提供多个数据元素需求摊销。值得注意的是，订阅者允许在任何时候发起数据需求信号，这可以避免发布者和订阅者之间不必要的延迟（也就是在不比等待全来回的时候保持它的输入缓冲区填满）。

## 七、法律信息

这个项目是来自Kaazing, Lightbend, Netflix, Pivotal, Red Hat, Twitter集更多其它公司的工程师协作的项目。代码发不到公共领域是为了让有兴趣创建兼容的实现体的组织和个人自由使用。详细情况请看版权声明。

http://creativecommons.org/publicdomain/zero/1.0/

为了在法律下伸展可能性，[Reactive Streams Special Interest Group](http://www.reactive-streams.org/)放弃了所有版权及Reactive Streams JVM相关的权利。这份工作发布自：美国。
