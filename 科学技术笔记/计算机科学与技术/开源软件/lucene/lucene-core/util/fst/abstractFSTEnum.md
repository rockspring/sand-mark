doSeekCeil依赖的函数

void rewindPrefix()

FST.Arc<T> getArc(int idx)

abstract int getTargetLabel()


弧的数据通过FST.BytesReader读取

Arc.posArcsStart保存了第一个弧在FST.BytesReader中的地址

Arc.bytesPerArc保存了每个弧所占的字节数