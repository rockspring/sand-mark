# IndexWriter调用MergeScheduler的方法merge(this, trigger, newMergesFound)的方法



private final void maybeMerge(MergePolicy mergePolicy, MergeTrigger trigger, int maxNumSegments) throws IOException {
    ensureOpen(false);
    boolean newMergesFound = updatePendingMerges(mergePolicy, trigger, maxNumSegments);
    mergeScheduler.merge(this, trigger, newMergesFound);
  }


public void forceMergeDeletes(boolean doWait);

void waitForMerges() throws IOException;

# IndexWriter调用自身的maybeMerge(MergePolicy mergePolicy, MergeTrigger trigger, int maxNumSegments)的方法的方法

final void applyDeletesAndPurge(boolean forcePurge) throws IOException;

final void doAfterSegmentFlushed(boolean triggerMerge, boolean forcePurge);

protected final void flush(boolean triggerMerge, boolean applyAllDeletes) throws IOException;

public void forceMerge(int maxNumSegments, boolean doWait) throws IOException;

DirectoryReader getReader(boolean applyAllDeletes) throws IOException;

public final void maybeMerge() throws IOException;

private void prepareCommitInternal(MergePolicy mergePolicy) throws IOException;

IndexWriter调用自身的maybeMerge()的方法的方法

public void addIndexes(CodecReader... readers) throws IOException;

public void addIndexes(Directory... dirs) throws IOException;


下面这个类执行实际的merge操作

protected class MergeThread extends Thread implements Comparable<MergeThread>;



打印的日志

INFO  - 2015-08-13 11:41:50.215; [Lucene Merge Thread #1825] org.apache.solr.update.LoggingInfoStream; [CMS][Lucene Merge Thread #1825]:   merge thread: start



IndexWriter有一个pendingMerges字段，类型为LinkedList<MergePolicy.OneMerge>，记录找到的要执行的合并操作

# private final void maybeMerge(MergePolicy mergePolicy, MergeTrigger trigger, int maxNumSegments) throws IOException方法的流程

使用MergePolicy查找需要合并的段
使用MergeScheduler从IndexWriter的pendingMerges列表中获取一个待合并的操作，从MergeScheduler获取一个合并线程，启动合并线程