索引合并

public void merge(MergePolicy.OneMerge merge) throws IOException;

主流程

mergeInit

mergeMiddle
	* 使用SegmentMerger进行合并
	
mergeSuccess