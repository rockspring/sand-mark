```
class buffer(object)
 |  buffer(object [, offset[, size]])
 |
 |  Create a new buffer object which references the given object.
 |  The buffer will reference a slice of the target object from the
 |  start of the object (or at the specified offset). The slice will
 |  extend to the end of the target object (or with the specified size).
```

```
byteswap(...)
    a.byteswap(inplace)

    Swap the bytes of the array elements

    Toggle between low-endian and big-endian data representation by
    returning a byteswapped array, optionally swapped in-place.

    Parameters
    ----------
    inplace : bool, optional
        If ``True``, swap bytes in-place, default is ``False``.

    Returns
    -------
    out : ndarray
        The byteswapped array. If `inplace` is ``True``, this is
        a view to self.

    Examples
    --------
    >>> A = np.array([1, 256, 8755], dtype=np.int16)
    >>> map(hex, A)
    ['0x1', '0x100', '0x2233']
    >>> A.byteswap(True)
    array([  256,     1, 13090], dtype=int16)
    >>> map(hex, A)
    ['0x100', '0x1', '0x3322']

    Arrays of strings are not swapped

    >>> A = np.array(['ceg', 'fac'])
    >>> A.byteswap()
    array(['ceg', 'fac'],
          dtype='|S3')
```


0,1,2,3,4

||S1|S2|S3|S4|
|---|----|---|---|---|
|0|1|0|0|1|
|1|0|0|1|0|
|2|0|1|0|1|
|3|1|0|1|1|
|4|0|0|1|0|

3,0,1,2,4

||S1|S2|S3|S4|
|---|----|---|---|---|
|3|1|0|1|1|
|0|1|0|0|1|
|1|0|0|1|0|
|2|0|1|0|1|
|4|0|0|1|0|

4,3,2,1,0

||S1|S2|S3|S4|
|---|----|---|---|---|
|4|0|0|1|0|
|3|1|0|1|1|
|2|0|1|0|1|
|1|0|0|1|0|
|0|1|0|0|1|


随机排列计算出来的签名矩阵

||S1|S2|S3|S4|
|---|----|---|---|---|
|排列1|2|0|1|0|
|排列2|3|2|3|3|
|排列3|3|2|4|3|

生成各种排列很慢，我们随机选择n个hash函数

每个hash函数的输入为集合的


对每一行，每一列，用这个n个hash函数计算hash值

hash函数的输入为行号，映射到新的行号

minhash1=x+1 mod 5

minhash2=3x+1 mod 5

||S1|S2|S3|S4|
|---|----|---|---|---|
|hash函数1|minhash1(S1)|minhash1(S2)|minhash1(S3)|minhash1(S4)|
|hash函数1|minhash2(S1)|minhash2(S2)|minhash2(S3)|minhash2(S4)|





初始化_init_hashvalues

```
# 导入numpy包
import numpy as np

# 设置需要多少个排列
num_perm=128

# 最大hash值
_max_hash=(1 << 32) - 1

# 创建一纬数组，num_perm为数组长度，dtype指定数组元素类型为np.uint64
ones = np.ones(num_perm, dtype=np.uint64)

# 将数组的每个元素乘以_max_hash，得到一个新的元素
maxs = ones * _max_hash
```

```
# 导入时间模块
import time

# 获取当前的秒，time.time()返回的float类型，我们转换成int类型
seed = int(time.time())

# 随机值生成器
generator = np.random.RandomState(seed)

_mersenne_prime = (1 << 61) - 1

rand1 = generator.randint(1, _mersenne_prime, dtype=np.uint64)

rand1 = generator.randint(1, _mersenne_prime)

rand0 = generator.randint(0, _mersenne_prime, dtype=np.uint64)

rand0 = generator.randint(0, _mersenne_prime)


permutations = np.array([(rand1,rand0) for _ in range(num_perm)], dtype=np.uint64)

# 生成一个128行2列的随机值矩阵，第一列的值范围[1, _mersenne_prime]，第二列的值范围[0, _mersenne_prime]
permutations = np.array([(generator.randint(1, _mersenne_prime),generator.randint(0, _mersenne_prime)) for _ in range(num_perm)], dtype=np.uint64)

# 128行2列的随机值矩阵转置成2行128列的矩阵
permutations.T
```


update方法，输入参数为集合的一个元素（字符串）

```
import hashlib
import struct

item='b'

# type(unpacked)=tuple
unpacked = struct.unpack('<I', hashlib.sha1(item).digest()[:4])

hv = unpacked[0]

求得item得hash值
```

```
# 用于随机排列的hash函数 ( a * i + b ) % _mersenne_prime


# 最大的hash值 np.uint64(_max_hash)

np.bitwise_and

np.binary_repr(14)
np.binary_repr(3)
np.binary_repr(13)
np.bitwise_and([14,3],13)
# 将14与13进行and操作，将3和13进行and操作
# array([12,  1])
np.binary_repr(12)
np.binary_repr(1)

_max_hash=4294967295
np.binary_repr(_max_hash)
# 11111111111111111111111111111111 32位长度

n.minimum

求两个数组中每个元素的最小值
self.hashvalues = np.minimum(phv, self.hashvalues)

```


计算最优的b和r

```
_integration_precision = 0.001
def _integration(f, a, b):
    p = _integration_precision
    area = 0.0
    x = a
    while x < b:
        area += f(x+0.5*p)*p
        x += p
    return area, None

def _false_positive_probability(threshold, b, r):
    _probability = lambda s : 1 - (1 - s**float(r))**float(b)
    a, err = integrate(_probability, 0.0, threshold) 
    return a


def _false_negative_probability(threshold, b, r):
    _probability = lambda s : 1 - (1 - (1 - s**float(r))**float(b))
    a, err = integrate(_probability, threshold, 1.0)
    return a

def _optimal_param(threshold, num_perm, false_positive_weight,
        false_negative_weight):
    '''
    Compute the optimal `MinHashLSH` parameter that minimizes the weighted sum
    of probabilities of false positive and false negative.
    '''
    min_error = float("inf")
    opt = (0, 0)
    for b in range(1, num_perm+1):
        max_r = int(num_perm / b)
        for r in range(1, max_r+1):
            fp = _false_positive_probability(threshold, b, r)
            fn = _false_negative_probability(threshold, b, r)
            error = fp*false_positive_weight + fn*false_negative_weight
            if error < min_error:
                min_error = error
                opt = (b, r)
    return opt
```


构建b个hashtable

```
self.hashtables = [defaultdict(list) for _ in range(self.b)]
```

记录每个hash表负责的行号范围

```
self.hashranges = [(i*self.r, (i+1)*self.r) for i in range(self.b)]
```

```
<type 'list'>: [(0, 5), (5, 10), (10, 15), (15, 20), (20, 25), (25, 30), (30, 35), (35, 40), (40, 45), (45, 50), (50, 55), (55, 60), (60, 65), (65, 70), (70, 75), (75, 80), (80, 85), (85, 90), (90, 95), (95, 100), (100, 105), (105, 110), (110, 115), (115, 120), (120, 125)]
```


记录一个item落在哪些hash桶，即使用哪些字节段作为hash桶的key

```
self.keys[key] = [self._H(minhash.hashvalues[start:end]) 
                for start, end in self.hashranges]
```

keys记录每个带在hashtable中使用的key，b个

把每个key及key对应的文档值，插入到对应的hash表中

hashtables为一个hash表列表，b个元素

[hashtable,hashtable,...]


每个集合的minhash列表是一个数字数组，将列表划分成b段，每段r行。

把每一段的r个数字的字节表示拼接成一个字节数组，作为hash表的key。

```
self._H(minhash.hashvalues[start:end]

# _H函数的实现如下
bytes(hs.byteswap().data)

#bytes就是str函数，将对象转换成字节数组
# byteswap对ndarray的每个元素进行小端序和大端序交换
# ndarray的data方法创建一个buffer对象，引用ndarray的数据
```

