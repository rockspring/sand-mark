shouldExpand

是不是应当用数组来存储弧

用数组存储弧，根据弧标签进行二分查找时速度快

# 两个条件

深度小于等于3，且弧的数量大于5

弧的数量大于等于10





# 数据存储格式

flag Byte
label Byte | Short | VInt
output bytes
nextFinalOutput bytes
target.node VLong

倒序存储该节点的数据

addNode的返回值为节点的地址





# CompiledNode

addNode返回节点存储的位置，即地址

地址保存在CompiledNode对象