SegmentMerger

合并以IndexReader表示的两个或多个索引段


数据结构

持有一个MergeState对象，拥有段合并过程中的状态


主流程

MergeState merge() throws IOException;


分别调用如下方法完成合并，最终写入Directory

mergeFieldInfos

mergeFields

mergeTerms

mergeDocValues

mergeNorms

mergeVectors