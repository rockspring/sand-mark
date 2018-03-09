# LogMergePolicy

LogMergePolicy实现了MergePolicy，把段合并到每一层的大小按指数增长的层中去，每一层有比合并因子更少的段。无论什么时候遇到了额外的段（超出了合并因子的上限），层中的所有段被合并。你可以分别通过getMergeFactor和setMergeFactor方法获取和设置合并因子。

这个类是一个抽象类，需要子类实现size方法，size方法中指定了怎么判定段的大小。LogDocMergePolicy是一个LogMergePolicy的子类，通过文档数量测量段的大小。LogByteSizeMergePolicy是另一个LogMergePolicy的子类，通过段的文件大小测量段的大小。

## 内部类

### org.apache.lucene.index.LogMergePolicy.SegmentInfoAndLevel

## 1 字段

### 1.1 org.apache.lucene.index.LogMergePolicy#LEVEL_LOG_SPAN double

LEVEL_LOG_SPAN默认值为0.75。

为每一层的log(size)定义了一个运行的范围。通过取最大段log大小，减去LEVEL_LOG_SPAN，找出落在那个范围的所有段，计算出一个层。

### 1.2 org.apache.lucene.index.LogMergePolicy#DEFAULT_MERGE_FACTOR int

DEFAULT_MERGE_FACTOR的默认值为10。

合并因子，一次合并多少个段。

### 1.3 org.apache.lucene.index.LogMergePolicy#DEFAULT_MAX_MERGE_DOCS int

DEFAULT_MAX_MERGE_DOCS的默认值为Integer.MAX_VALUE。

最大的段大小，大于或等于这个大小的端永远不会被合并。

### 1.4 org.apache.lucene.index.LogMergePolicy#DEFAULT_NO_CFS_RATIO double

DEFAULT_NO_CFS_RATIO的默认值为0.1。

如果合并后段的大小大于或等于索引大小的DEFAULT_NO_CFS_RATIO比例部分，禁止使用复合文件。

### 1.5 org.apache.lucene.index.LogMergePolicy#mergeFactor int

一次合并多少个段，默认值为DEFAULT_MERGE_FACTOR。

控制索引中允许累积的段的总数。

决定段索引通过addDocument方式多频繁地被合并。

更小的值，建立索引过程中需要更少的RAM，搜索速度更快，但是索引创建速度比较慢。

更大的值，建立索引过程中需要更多的RAM，同时搜索速度更慢，索引创建速度更快。

因此，对批量索引创建而言，更大的值，比如大于10，是最好的；对交互式维护的索引，更小的值，比如小于10是最好的。

### 1.6 org.apache.lucene.index.LogMergePolicy#minMergeSize long

任何小于这个大小的段都被认为是这个大小，即大小四舍五入到这个大小。这个可以确保微型段被积极地合并。

### 1.7 org.apache.lucene.index.LogMergePolicy#maxMergeSize long

如果一个段的大小超过这个值，它永远不会被合并。

### 1.8 org.apache.lucene.index.LogMergePolicy#maxMergeSizeForForcedMerge long

如果一个段的大小超过这个值，在forceMerge过程中它永远不会被合并。

### 1.9 org.apache.lucene.index.LogMergePolicy#maxMergeDocs int

如果一个段的文档数量超过这个值，它永远不会被合并。

### 1.10 org.apache.lucene.index.LogMergePolicy#calibrateSizeByDeletes boolean

如果为true，我们通过非删除文档的百分比校正（pro-rate）段的大小。

选择段时，使用这个校正过的端大小。

## 2 方法

### 2.1 org.apache.lucene.index.LogMergePolicy#LogMergePolicy()

构造方法。

### 2.2 org.apache.lucene.index.LogMergePolicy#verbose(IndexWriter writer) -> boolean

如果IndexWriter的infoStream中启用了LMP（LogMergePolicy），则返回true。

### 2.3 org.apache.lucene.index.LogMergePolicy#message(String message, IndexWriter writer) -> void

给IndexWriter的infoStream打印一条调试信息。

### 2.4 org.apache.lucene.index.LogMergePolicy#sizeDocs(SegmentCommitInfo info, IndexWriter writer) -> long

获取info中的文档数量。根据calibrateSizeByDeletes是否为true对数量是否校正。如果calibrateSizeByDeletes为true，则减去删除的文档数量。

### 2.5 org.apache.lucene.index.LogMergePolicy#sizeBytes(SegmentCommitInfo info, IndexWriter writer) -> long

获取info的字节大小。根据calibrateSizeByDeletes是否为true对数量是否校正。

### 2.6 org.apache.lucene.index.LogMergePolicy#isMerged(SegmentInfos infos, int maxNumSegments, Map<SegmentCommitInfo,Boolean> segmentsToMerge, IndexWriter writer)

如果符合条件的段的数量小于或等于指定的maxNumSegments数量，返回true，表示已经合并了。

如果符合条件的数量不超过指定的maxNumSegments外，还需要满足如下条件：

	满足条件的段数量不是1
    符合条件的最后一个段不是原始段
    符合条件最后一个段已经被合并了

### 2.7 org.apache.lucene.index.LogMergePolicy#findForcedMergesSizeLimit(SegmentInfos infos, int maxNumSegments, int last, IndexWriter writer) -> MergeSpecification

考虑最大合并大小或合并文档数，这个方法返回合并索引的必要的合并操作。

这个方法尝试尊重maxNumSegments参数的限制，然后，因为大小的约束条件，在索引中可能会有多于maxNumSegments个段。更进一步，这个方法也不保证留下精确的maxNumSegments个段，而是小于或等于这个数量。

如果段的大小大于maxMergeSizeForForcedMerge或段的文档数量大于maxMergeDocs，这个段不参与合并。

遇到这种段的第一种情况，last - start - 1 > 1。

|不符合条件的端，start指向这个段|...|...|last指向尾部

segments.subList(start + 1, last)加入到合并操作中。

遇到这种段的第二种情况，last - start - 1 == 1，start != last - 1

|不符合条件的端，start指向这个段|...|last指向尾部

如果infos.info(start + 1)不是已经合并的，加入到合并操作中。

遇到这种段的第三种情况，last - start - 1 == =，start == last - 1

|不符合条件的端，start指向这个段|last指向尾部

没有断可以加入到合并操作中。

如果没有遇到不符合要求的段，如果last - start == mergeFactor，符合要求的段的数量达到要求，则加入到合并操作中。

最后处理剩余的段。last肯定要大于0，才有剩余段。

如果剩余的段数量大于或等于2，则加入到合并操作中。

如果剩余的端数量小于2，检查start指向的端是否已经合并了，如果没有，则将剩余的端加入到合并操作中。

### 2.8 org.apache.lucene.index.LogMergePolicy#findForcedMergesMaxNumSegments(SegmentInfos infos, int maxNumSegments, int last, IndexWriter writer) -> MergeSpecification

返回forceMerge方式合并索引的必要的合并操作。这个方法仅仅由maxNumSegments参数约束，并且保证索引中精确剩余maxNumSegments个段。

从尾部开始依次取走mergeFactor个加入到合并操作中，直到剩余的段数量扣除maxNumSegments-1后不够依次merge的mergeFactor数量。

如果总数没有达到maxNumSegments-1+mergeFactor，分如下两种情况。

第一种情况，maxNumSegments==1。如果段的数量超过1或者段的数量不超过1并且第一个段是一个未合并的端，则将这些段加入到合并操作中。

第二种情况，段的数量超过maxNumSegments。计算出合并的段数量last - maxNumSegments + 1。从哪一个段开始的段作为合并段的起始段呢？合并的段的总大小比起始段的前一个段的2倍大小要小。依次考察每一种起始段情况，选择满足条件的总合并大小最小的合并组合。

### 2.9 org.apache.lucene.index.LogMergePolicy#findForcedMerges(SegmentInfos infos, int maxNumSegments, Map<SegmentCommitInfo,Boolean> segmentsToMerge, IndexWriter writer) -> MergeSpecification

会调用findForcedMergesSizeLimit和findForcedMergesMaxNumSegments方法。

### 2.10 org.apache.lucene.index.LogMergePolicy#findForcedDeletesMerges(SegmentInfos segmentInfos, IndexWriter writer) -> MergeSpecification

合并邻近的有删除文档的段。

在段列表中从下标0开始，判定对应的下标是否有删除文档数大于0，如果有，记录第一个有删除文档的下标firstSegmentWithDeletions。接下来如果有删除文档的端数量达到了mergeFactor，将这些段加入到一个合并操作中。如果没达到，继续检查下一个段。如果发现一个没有删除的段，则合并截止目前检查过的段。

### 2.11 org.apache.lucene.index.LogMergePolicy#findMerges(MergeTrigger mergeTrigger, SegmentInfos infos, IndexWriter writer) -> MergeSpecification

当在给定层中有多于mergeFactor个段时，有必要产生一个合并操作。当多个层有很多段时，产生很多个合并操作。

从start下表开始往后检查所有的端，找出最大的层数记录到maxLevel。寻找与maxLevel对应的层数下界，如果maxLevel<=levelFloor，则下界levelBottom=-1.0；否则，下界levelBottom=maxLevel - LEVEL_LOG_SPAN。

然后从最后一个段开始从前检查，一旦发现有段的层不在上述层区间内，终止检查，记录upto为已经检查到的符合条件的段。