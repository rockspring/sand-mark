# MutablePointValues

public abstract void getValue(int i, BytesRef packedValue);

将第i个值对应的打包的字节串引用设置到packedValue。

public abstract byte getByteAt(int i, int k);

获取第i个值对应的字节串中的第k个字节。

public abstract int getDocID(int i);

获取第i个值对应的文档id。

public abstract void swap(int i, int j);

交换第i个值和第j个值。