StoredFieldsWriter(abstract)

# 对每一个文档

调用startDocument()方法，写入一段数据，标志着一个新的文档开始了

## 对文档中得每个字段

调用writeField(FieldInfo, IndexableField)方法

调用finishDocument()

# 所有文档完成后

finish(FieldInfos, int)

# 调用close()方法关闭文件