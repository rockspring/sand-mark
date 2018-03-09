Lucene50SkipWriter

# skipBuffer level=0

curDoc - lastSkipDoc[level] VInt

curDocPointer - lastSkipDocPointer[level] VLong

curPosPointer - lastSkipPosPointer[level] VLong

curPosBufferUpto VInt

curPayloadByteUpto VInt

curPayPointer - lastSkipPayPointer[level] VLong


# 什么将数据写入磁盘？

## void finishTerm(BlockTermState _state)

## 文件名

FSIndexOutput(path="/Users/zlq/Projects/zlq/lucene-study/target/test-classes/testIndexLucene50/_2_Lucene50_0.doc")

```
numberOfSkipLevels-1个skipBuffer的存储格式

	length VLong
	skipBuffer byte[]

skipBuffer[0] byte[]
```