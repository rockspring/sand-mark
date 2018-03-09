# TieredMergePolicy

继承MergePolicy。

合并近似相等大小的段，受限制于每一层允许的段数量。除了能够合并非邻近的段，区分开每一层允许多少段和一次合并多少段，它与LogByteSizeMergePolicy相似。它同样不做级联合并。

对普通的合并，这个策略首先计算出一个预算，允许索引中有多少个段。如果索引超出预算，这个策略对段从大到小排序（计算大小时排除删除的文档），然后找出最低成本的合并。合并成本通过计算合并的倾斜度（最大的段大小除以最小的段大小）、总合并大小和回收删除的比例综合获得，因此低倾斜度、小尺寸、回收大量删除的合并很受欢迎。

如果合并产生一个比setMaxMergedSegmentMB设置的大的端，合并策略将合并更少的段（如果那个短有删除，下降到一个段做合并）保持段大小在预算内。

这个策略合并非邻近的端，如果这个一个问题，使用LogMergePolicy。

这个策略总是通过段的字节数合并，总是按删除比例分配，在forceMerge中不使用任何最大段大小（这一点与LogByteSizeMergePolicy不像）。

## 内部类

### org.apache.lucene.index.TieredMergePolicy.SegmentByteSizeDescending

比较两个SegmentCommitInfo，先以大小从大小到小排序，大小一样则按名称排序。

### org.apache.lucene.index.TieredMergePolicy.MergeScore

单个候选合并的分数和解释文字。

## 字段

### org.apache.lucene.index.TieredMergePolicy#DEFAULT_NO_CFS_RATIO double

默认值1.0，如果合并的大小大于索引的这个比例，我们禁用复合文件。

### org.apache.lucene.index.TieredMergePolicy#maxMergeAtOnce int

普通合并时，一次合并的最大段数量，默认为10。非普通合并称之为显示合并，如forceMerge和forceMergeDeletes方法被调用触发的合并。

### org.apache.lucene.index.TieredMergePolicy#maxMergedSegmentBytes long

最大合并的段大小，普通合并中产生的最大段大小，单位为字节，默认为5\*1024\*1024\*1024L。这个一个估算，通过累加所有参与合并的段的大小。

### org.apache.lucene.index.TieredMergePolicy#maxMergeAtOnceExplicit

非普通合并称之为显示合并，如forceMerge和forceMergeDeletes方法被调用触发的合并。一次合并的最大段数量，默认值为30。

### org.apache.lucene.index.TieredMergePolicy#floorSegmentBytes long

默认值为2\*1024\*1024L。

小于这个大小的段被四舍五入到这个大小，即在选择时看做相等的大小。这在允许长尾分布的索引中阻止频繁的刷新微型段。

### org.apache.lucene.index.TieredMergePolicy#segsPerTier double

默认值为10.0。

每一层允许的段的数量。更小值意味着更多的合并、更少的段。这个值应当大于等于setMaxMergeAtOnce设定的值。

### org.apache.lucene.index.TieredMergePolicy#forceMergeDeletesPctAllowed double

默认值为10.0。

当forceMergeDeletes被调用时，我们仅仅合并删除比例超过这个阈值的段。

### org.apache.lucene.index.TieredMergePolicy#reclaimDeletesWeight double

默认值为2.0。

控制回收删除的合并多积极地要求被选中。这个值越高，回收删除的合并越容易被选中，但是注意不要太高，3.0可能已经太高了。0.0意味着删除不影响合并的选择。

## 方法

### org.apache.lucene.index.TieredMergePolicy#TieredMergePolicy()

默认构造函数。

### org.apache.lucene.index.TieredMergePolicy#getSegmentSizes(IndexWriter writer, Collection<SegmentCommitInfo> infos) throws IOException

计算每个段的大小，记录到Map<SegmentCommitInfo,Long>中。

### org.apache.lucene.index.TieredMergePolicy#findMerges(MergeTrigger mergeTrigger, SegmentInfos infos, IndexWriter writer) -> MergeSpecification

minSegmentBytes 最小的段大小。

>= maxMergedSegmentBytes/2.0的段排除出去

tooBigCount 排除的段数量

minSegmentBytes 最小的端大小如果比floorSegmentBytes小，四舍五入到floorSegmentBytes

segCountLevel表示levelSize大小一个段，有多少段

levelSize提升maxMergeAtOnce倍，第一层段的大小为levelSize，第二层为levelSize\*maxMergeAtOnce

allowedSegCountInt 所有层的段数量之和

从每一个段开始找合并的端，最后用作开始的端为倒数第maxMergeAtOnce个段

### org.apache.lucene.index.TieredMergePolicy#score(List<SegmentCommitInfo> candidate, boolean hitTooLarge, long mergingBytes, IndexWriter writer, Map<SegmentCommitInfo, Long> sizeInBytes) -> MergeScore

我们不想使得整个指数太大，否则，我们因为避免大的合并而以很差的小合并告终。

### org.apache.lucene.index.TieredMergePolicy#findForcedMerges(SegmentInfos infos, int maxSegmentCount, Map<SegmentCommitInfo,Boolean> segmentsToMerge, IndexWriter writer) -> MergeSpecification

// 1 如果最大段数量maxSegmentCount大于1，符合条件的段数量小于或等于最大段数量，认为已经合并了
// 2 如果最大段数量maxSegmentCount等于1，符合条件的端数量等于1，并且不是原始段，认为已经合并了
// 3 如果最大段数量maxSegmentCount等于1，符合条件的端数量等于1，并且已经合并了，认为已经合并了

最多剩余maxMergeAtOnceExplicit + maxSegmentCount - 2个段，最少剩余maxSegmentCount - 1个段

每次合并倒数的maxMergeAtOnceExplicit个段

段的数量没有达到maxMergeAtOnceExplicit + maxSegmentCount - 1个，除了maxSegmentCount - 1个段外，其他段一起合并
### org.apache.lucene.index.TieredMergePolicy#findForcedDeletesMerges(SegmentInfos infos, IndexWriter writer) -> MergeSpecification