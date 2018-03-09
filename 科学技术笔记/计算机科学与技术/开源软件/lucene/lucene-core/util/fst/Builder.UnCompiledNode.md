Builder.UnCompiledNode

```
final Builder<T> owner;
public int numArcs;
public Arc<T>[] arcs;
// TODO: instead of recording isFinal/output on the
// node, maybe we should use -1 arc to mean "end" (like
// we do when reading the FST).  Would simplify much
// code here...
public T output;
public boolean isFinal;
public long inputCount;

/** This node's depth, starting from the automaton root. */
public final int depth;
```

# owner

FST的建造者

# numArcs

这个节点上有多少个弧

# arcs

这个节点上得所有弧，一个元素为弧（Arc）的数组

# output

从根到当前节点对应的输出

# isFinal

是不是终止节点

# inputCount

输入的边数

# depth

节点的深度