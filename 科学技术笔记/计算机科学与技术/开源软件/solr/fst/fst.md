Outputs

* ByteSequenceOutputs

* CharSequenceOutputs

* IntSequenceOutputs

* PairOutputs

* PositiveIntOutputs


BytesStore

持有多个byte块

blockSize 每个块的大小
blockBits 记录块大小所用的二进制位长度，故块长度为2**blockBits
blockMask blockBits个位为1的位串

例子：blockSize=4 blockBits=2 blockMask=11

nextWrite 最后一个byte块的长度


FST

BytesStore

Outputs

PackedInts.Reader

Arc

GrowableWriter nodeAddress

GrowableWriter inCounts
