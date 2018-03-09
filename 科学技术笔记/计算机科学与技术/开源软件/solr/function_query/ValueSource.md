抽象类ValueSource

source具有源头的含义，顾名思义ValueSource就是值的源头

用来实例化函数值FunctionValues，具有一个抽象方法如下

public abstract FunctionValues getValues(Map context, AtomicReaderContext readerContext) throws IOException;

不同ValueSource具体类实现了上面这个方法获取函数值


具体类ValueSourceComparator，是一个ValueSource的内部类，持有函数值FunctionValues，通过ValueSource的getValues方法获取到

比较ValueSource源头产生的值


FieldComparatorSource

字段比较器的源头

```
public abstract FieldComparator<?> newComparator(String fieldname, int numHits, int sortPos, boolean reversed) throws IOException;

```



FloatFieldSource 继承于 FieldCacheSource

FieldCacheSource 继承于 ValueSource