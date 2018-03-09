ByteBlockPool

byteUpto

buffer中偏移量，指示当前buffer已用到的位置，初始化时设为32768，表示当前buffer已用完。初始状态中，不会创建任何buffer，因此byteUpto设为最大值。

bufferUpto

pool中的哪一个buffer，初始状态设为-1，表示不指向人和buffer。初始状态，不会创建任何buffer，因此，bufferUpto设为-1。

byteOffset

在整个buffer池中的偏移量，初始状态设为-32768。


upto

buffer中的偏移量，指示当前buffer中分配的slice的起点偏移量。


分配一个slice

需要知道当前所在slice中的分配起始位置。

如何分配，分配多大？

根据上一次分配的级别算出本次分配的级别，根据分配级别找到分配大小。


# ByteSliceReader

## upto

一个buffer中索引已到达的位置

## bufferUpto

buffer在buffer池中的索引一到达的位置

## bufferOffset

这个buffer在整个buffer池中偏移量，buffer的0索引在整个buffer池中的偏移量

# ByteSliceWriter

## offset0

一个buffer的起始索引0在整个buffer池中得偏移量