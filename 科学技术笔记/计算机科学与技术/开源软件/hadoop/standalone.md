$ cd hadoop-2.5.1
$ mkdir input
$ cp etc/hadoop/*.xml input
$ bin/hadoop jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.5.1.jar grep input output 'dfs[a-z.]+'

输出内容如下

```
14/09/25 13:42:37 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
14/09/25 13:42:37 INFO Configuration.deprecation: session.id is deprecated. Instead, use dfs.metrics.session-id
14/09/25 13:42:37 INFO jvm.JvmMetrics: Initializing JVM Metrics with processName=JobTracker, sessionId=
14/09/25 13:42:37 WARN mapreduce.JobSubmitter: No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
14/09/25 13:42:37 INFO input.FileInputFormat: Total input paths to process : 6
14/09/25 13:42:37 INFO mapreduce.JobSubmitter: number of splits:6
14/09/25 13:42:38 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_local1419516323_0001
14/09/25 13:42:38 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/staging/zlq1419516323/.staging/job_local1419516323_0001/job.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.retry.interval;  Ignoring.
14/09/25 13:42:38 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/staging/zlq1419516323/.staging/job_local1419516323_0001/job.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.attempts;  Ignoring.
14/09/25 13:42:38 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/local/localRunner/zlq/job_local1419516323_0001/job_local1419516323_0001.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.retry.interval;  Ignoring.
14/09/25 13:42:38 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/local/localRunner/zlq/job_local1419516323_0001/job_local1419516323_0001.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.attempts;  Ignoring.
14/09/25 13:42:38 INFO mapreduce.Job: The url to track the job: http://localhost:8080/
14/09/25 13:42:38 INFO mapreduce.Job: Running job: job_local1419516323_0001
14/09/25 13:42:38 INFO mapred.LocalJobRunner: OutputCommitter set in config null
14/09/25 13:42:38 INFO mapred.LocalJobRunner: OutputCommitter is org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter
14/09/25 13:42:38 INFO mapred.LocalJobRunner: Waiting for map tasks
14/09/25 13:42:38 INFO mapred.LocalJobRunner: Starting task: attempt_local1419516323_0001_m_000000_0
14/09/25 13:42:38 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 13:42:38 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 13:42:38 INFO mapred.MapTask: Processing split: file:/Users/zlq/servers/hadoop/hadoop-2.5.1/input/hadoop-policy.xml:0+9201
14/09/25 13:42:38 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 13:42:38 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 13:42:38 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 13:42:38 INFO mapred.MapTask: soft limit at 83886080
14/09/25 13:42:38 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 13:42:38 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 13:42:38 INFO mapred.LocalJobRunner:
14/09/25 13:42:38 INFO mapred.MapTask: Starting flush of map output
14/09/25 13:42:38 INFO mapred.MapTask: Spilling map output
14/09/25 13:42:38 INFO mapred.MapTask: bufstart = 0; bufend = 17; bufvoid = 104857600
14/09/25 13:42:38 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214396(104857584); length = 1/6553600
14/09/25 13:42:38 INFO mapred.MapTask: Finished spill 0
14/09/25 13:42:38 INFO mapred.Task: Task:attempt_local1419516323_0001_m_000000_0 is done. And is in the process of committing
14/09/25 13:42:38 INFO mapred.LocalJobRunner: map
14/09/25 13:42:38 INFO mapred.Task: Task 'attempt_local1419516323_0001_m_000000_0' done.
14/09/25 13:42:38 INFO mapred.LocalJobRunner: Finishing task: attempt_local1419516323_0001_m_000000_0
14/09/25 13:42:38 INFO mapred.LocalJobRunner: Starting task: attempt_local1419516323_0001_m_000001_0
14/09/25 13:42:38 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 13:42:38 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 13:42:38 INFO mapred.MapTask: Processing split: file:/Users/zlq/servers/hadoop/hadoop-2.5.1/input/capacity-scheduler.xml:0+3589
14/09/25 13:42:38 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 13:42:38 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 13:42:38 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 13:42:38 INFO mapred.MapTask: soft limit at 83886080
14/09/25 13:42:38 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 13:42:38 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 13:42:38 INFO mapred.LocalJobRunner:
14/09/25 13:42:38 INFO mapred.MapTask: Starting flush of map output
14/09/25 13:42:38 INFO mapred.Task: Task:attempt_local1419516323_0001_m_000001_0 is done. And is in the process of committing
14/09/25 13:42:38 INFO mapred.LocalJobRunner: map
14/09/25 13:42:38 INFO mapred.Task: Task 'attempt_local1419516323_0001_m_000001_0' done.
14/09/25 13:42:38 INFO mapred.LocalJobRunner: Finishing task: attempt_local1419516323_0001_m_000001_0
14/09/25 13:42:38 INFO mapred.LocalJobRunner: Starting task: attempt_local1419516323_0001_m_000002_0
14/09/25 13:42:38 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 13:42:38 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 13:42:38 INFO mapred.MapTask: Processing split: file:/Users/zlq/servers/hadoop/hadoop-2.5.1/input/hdfs-site.xml:0+775
14/09/25 13:42:38 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 13:42:39 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 13:42:39 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 13:42:39 INFO mapred.MapTask: soft limit at 83886080
14/09/25 13:42:39 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 13:42:39 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 13:42:39 INFO mapred.LocalJobRunner:
14/09/25 13:42:39 INFO mapred.MapTask: Starting flush of map output
14/09/25 13:42:39 INFO mapred.Task: Task:attempt_local1419516323_0001_m_000002_0 is done. And is in the process of committing
14/09/25 13:42:39 INFO mapred.LocalJobRunner: map
14/09/25 13:42:39 INFO mapred.Task: Task 'attempt_local1419516323_0001_m_000002_0' done.
14/09/25 13:42:39 INFO mapred.LocalJobRunner: Finishing task: attempt_local1419516323_0001_m_000002_0
14/09/25 13:42:39 INFO mapred.LocalJobRunner: Starting task: attempt_local1419516323_0001_m_000003_0
14/09/25 13:42:39 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 13:42:39 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 13:42:39 INFO mapred.MapTask: Processing split: file:/Users/zlq/servers/hadoop/hadoop-2.5.1/input/core-site.xml:0+774
14/09/25 13:42:39 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 13:42:39 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 13:42:39 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 13:42:39 INFO mapred.MapTask: soft limit at 83886080
14/09/25 13:42:39 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 13:42:39 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 13:42:39 INFO mapred.LocalJobRunner:
14/09/25 13:42:39 INFO mapred.MapTask: Starting flush of map output
14/09/25 13:42:39 INFO mapred.Task: Task:attempt_local1419516323_0001_m_000003_0 is done. And is in the process of committing
14/09/25 13:42:39 INFO mapred.LocalJobRunner: map
14/09/25 13:42:39 INFO mapred.Task: Task 'attempt_local1419516323_0001_m_000003_0' done.
14/09/25 13:42:39 INFO mapred.LocalJobRunner: Finishing task: attempt_local1419516323_0001_m_000003_0
14/09/25 13:42:39 INFO mapred.LocalJobRunner: Starting task: attempt_local1419516323_0001_m_000004_0
14/09/25 13:42:39 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 13:42:39 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 13:42:39 INFO mapred.MapTask: Processing split: file:/Users/zlq/servers/hadoop/hadoop-2.5.1/input/yarn-site.xml:0+690
14/09/25 13:42:39 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 13:42:39 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 13:42:39 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 13:42:39 INFO mapred.MapTask: soft limit at 83886080
14/09/25 13:42:39 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 13:42:39 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 13:42:39 INFO mapred.LocalJobRunner:
14/09/25 13:42:39 INFO mapred.MapTask: Starting flush of map output
14/09/25 13:42:39 INFO mapred.Task: Task:attempt_local1419516323_0001_m_000004_0 is done. And is in the process of committing
14/09/25 13:42:39 INFO mapred.LocalJobRunner: map
14/09/25 13:42:39 INFO mapred.Task: Task 'attempt_local1419516323_0001_m_000004_0' done.
14/09/25 13:42:39 INFO mapred.LocalJobRunner: Finishing task: attempt_local1419516323_0001_m_000004_0
14/09/25 13:42:39 INFO mapred.LocalJobRunner: Starting task: attempt_local1419516323_0001_m_000005_0
14/09/25 13:42:39 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 13:42:39 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 13:42:39 INFO mapred.MapTask: Processing split: file:/Users/zlq/servers/hadoop/hadoop-2.5.1/input/httpfs-site.xml:0+620
14/09/25 13:42:39 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 13:42:39 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 13:42:39 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 13:42:39 INFO mapred.MapTask: soft limit at 83886080
14/09/25 13:42:39 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 13:42:39 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 13:42:39 INFO mapred.LocalJobRunner:
14/09/25 13:42:39 INFO mapred.MapTask: Starting flush of map output
14/09/25 13:42:39 INFO mapred.Task: Task:attempt_local1419516323_0001_m_000005_0 is done. And is in the process of committing
14/09/25 13:42:39 INFO mapred.LocalJobRunner: map
14/09/25 13:42:39 INFO mapred.Task: Task 'attempt_local1419516323_0001_m_000005_0' done.
14/09/25 13:42:39 INFO mapred.LocalJobRunner: Finishing task: attempt_local1419516323_0001_m_000005_0
14/09/25 13:42:39 INFO mapred.LocalJobRunner: map task executor complete.
14/09/25 13:42:39 INFO mapred.LocalJobRunner: Waiting for reduce tasks
14/09/25 13:42:39 INFO mapred.LocalJobRunner: Starting task: attempt_local1419516323_0001_r_000000_0
14/09/25 13:42:39 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 13:42:39 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 13:42:39 INFO mapred.ReduceTask: Using ShuffleConsumerPlugin: org.apache.hadoop.mapreduce.task.reduce.Shuffle@79243ef3
14/09/25 13:42:39 INFO mapreduce.Job: Job job_local1419516323_0001 running in uber mode : false
14/09/25 13:42:39 INFO mapreduce.Job:  map 100% reduce 0%
14/09/25 13:42:39 INFO reduce.MergeManagerImpl: MergerManager: memoryLimit=333971456, maxSingleShuffleLimit=83492864, mergeThreshold=220421168, ioSortFactor=10, memToMemMergeOutputsThreshold=10
14/09/25 13:42:39 INFO reduce.EventFetcher: attempt_local1419516323_0001_r_000000_0 Thread started: EventFetcher for fetching Map Completion Events
14/09/25 13:42:39 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1419516323_0001_m_000000_0 decomp: 21 len: 25 to MEMORY
14/09/25 13:42:39 INFO reduce.InMemoryMapOutput: Read 21 bytes from map-output for attempt_local1419516323_0001_m_000000_0
14/09/25 13:42:39 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 21, inMemoryMapOutputs.size() -> 1, commitMemory -> 0, usedMemory ->21
14/09/25 13:42:39 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1419516323_0001_m_000004_0 decomp: 2 len: 6 to MEMORY
14/09/25 13:42:39 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1419516323_0001_m_000004_0
14/09/25 13:42:39 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 2, commitMemory -> 21, usedMemory ->23
14/09/25 13:42:39 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1419516323_0001_m_000001_0 decomp: 2 len: 6 to MEMORY
14/09/25 13:42:39 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1419516323_0001_m_000001_0
14/09/25 13:42:39 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 3, commitMemory -> 23, usedMemory ->25
14/09/25 13:42:39 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1419516323_0001_m_000002_0 decomp: 2 len: 6 to MEMORY
14/09/25 13:42:39 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1419516323_0001_m_000002_0
14/09/25 13:42:39 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 4, commitMemory -> 25, usedMemory ->27
14/09/25 13:42:39 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1419516323_0001_m_000005_0 decomp: 2 len: 6 to MEMORY
14/09/25 13:42:39 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1419516323_0001_m_000005_0
14/09/25 13:42:39 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 5, commitMemory -> 27, usedMemory ->29
14/09/25 13:42:39 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local1419516323_0001_m_000003_0 decomp: 2 len: 6 to MEMORY
14/09/25 13:42:39 INFO reduce.InMemoryMapOutput: Read 2 bytes from map-output for attempt_local1419516323_0001_m_000003_0
14/09/25 13:42:39 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 2, inMemoryMapOutputs.size() -> 6, commitMemory -> 29, usedMemory ->31
14/09/25 13:42:39 INFO reduce.EventFetcher: EventFetcher is interrupted.. Returning
14/09/25 13:42:39 INFO mapred.LocalJobRunner: 6 / 6 copied.
14/09/25 13:42:39 INFO reduce.MergeManagerImpl: finalMerge called with 6 in-memory map-outputs and 0 on-disk map-outputs
14/09/25 13:42:39 INFO mapred.Merger: Merging 6 sorted segments
14/09/25 13:42:39 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 10 bytes
14/09/25 13:42:39 INFO reduce.MergeManagerImpl: Merged 6 segments, 31 bytes to disk to satisfy reduce memory limit
14/09/25 13:42:39 INFO reduce.MergeManagerImpl: Merging 1 files, 25 bytes from disk
14/09/25 13:42:39 INFO reduce.MergeManagerImpl: Merging 0 segments, 0 bytes from memory into reduce
14/09/25 13:42:39 INFO mapred.Merger: Merging 1 sorted segments
14/09/25 13:42:39 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 10 bytes
14/09/25 13:42:39 INFO mapred.LocalJobRunner: 6 / 6 copied.
14/09/25 13:42:39 INFO Configuration.deprecation: mapred.skip.on is deprecated. Instead, use mapreduce.job.skiprecords
14/09/25 13:42:39 INFO mapred.Task: Task:attempt_local1419516323_0001_r_000000_0 is done. And is in the process of committing
14/09/25 13:42:39 INFO mapred.LocalJobRunner: 6 / 6 copied.
14/09/25 13:42:39 INFO mapred.Task: Task attempt_local1419516323_0001_r_000000_0 is allowed to commit now
14/09/25 13:42:39 INFO output.FileOutputCommitter: Saved output of task 'attempt_local1419516323_0001_r_000000_0' to file:/Users/zlq/servers/hadoop/hadoop-2.5.1/grep-temp-1203053718/_temporary/0/task_local1419516323_0001_r_000000
14/09/25 13:42:39 INFO mapred.LocalJobRunner: reduce > reduce
14/09/25 13:42:39 INFO mapred.Task: Task 'attempt_local1419516323_0001_r_000000_0' done.
14/09/25 13:42:39 INFO mapred.LocalJobRunner: Finishing task: attempt_local1419516323_0001_r_000000_0
14/09/25 13:42:39 INFO mapred.LocalJobRunner: reduce task executor complete.
14/09/25 13:42:40 INFO mapreduce.Job:  map 100% reduce 100%
14/09/25 13:42:40 INFO mapreduce.Job: Job job_local1419516323_0001 completed successfully
14/09/25 13:42:40 INFO mapreduce.Job: Counters: 30
	File System Counters
		FILE: Number of bytes read=116543
		FILE: Number of bytes written=1606554
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
	Map-Reduce Framework
		Map input records=405
		Map output records=1
		Map output bytes=17
		Map output materialized bytes=55
		Input split bytes=783
		Combine input records=1
		Combine output records=1
		Reduce input groups=1
		Reduce shuffle bytes=55
		Reduce input records=1
		Reduce output records=1
		Spilled Records=2
		Shuffled Maps =6
		Failed Shuffles=0
		Merged Map outputs=6
		GC time elapsed (ms)=97
		Total committed heap usage (bytes)=2278555648
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=15649
	File Output Format Counters
		Bytes Written=123
14/09/25 13:42:40 INFO jvm.JvmMetrics: Cannot initialize JVM Metrics with processName=JobTracker, sessionId= - already initialized
14/09/25 13:42:40 WARN mapreduce.JobSubmitter: No job jar file set.  User classes may not be found. See Job or Job#setJar(String).
14/09/25 13:42:40 INFO input.FileInputFormat: Total input paths to process : 1
14/09/25 13:42:40 INFO mapreduce.JobSubmitter: number of splits:1
14/09/25 13:42:40 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_local495388153_0002
14/09/25 13:42:40 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/staging/zlq495388153/.staging/job_local495388153_0002/job.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.retry.interval;  Ignoring.
14/09/25 13:42:40 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/staging/zlq495388153/.staging/job_local495388153_0002/job.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.attempts;  Ignoring.
14/09/25 13:42:40 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/local/localRunner/zlq/job_local495388153_0002/job_local495388153_0002.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.retry.interval;  Ignoring.
14/09/25 13:42:40 WARN conf.Configuration: file:/tmp/hadoop-zlq/mapred/local/localRunner/zlq/job_local495388153_0002/job_local495388153_0002.xml:an attempt to override final parameter: mapreduce.job.end-notification.max.attempts;  Ignoring.
14/09/25 13:42:40 INFO mapreduce.Job: The url to track the job: http://localhost:8080/
14/09/25 13:42:40 INFO mapreduce.Job: Running job: job_local495388153_0002
14/09/25 13:42:40 INFO mapred.LocalJobRunner: OutputCommitter set in config null
14/09/25 13:42:40 INFO mapred.LocalJobRunner: OutputCommitter is org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter
14/09/25 13:42:40 INFO mapred.LocalJobRunner: Waiting for map tasks
14/09/25 13:42:40 INFO mapred.LocalJobRunner: Starting task: attempt_local495388153_0002_m_000000_0
14/09/25 13:42:40 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 13:42:40 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 13:42:40 INFO mapred.MapTask: Processing split: file:/Users/zlq/servers/hadoop/hadoop-2.5.1/grep-temp-1203053718/part-r-00000:0+111
14/09/25 13:42:40 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
14/09/25 13:42:40 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
14/09/25 13:42:40 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
14/09/25 13:42:40 INFO mapred.MapTask: soft limit at 83886080
14/09/25 13:42:40 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
14/09/25 13:42:40 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
14/09/25 13:42:40 INFO mapred.LocalJobRunner:
14/09/25 13:42:40 INFO mapred.MapTask: Starting flush of map output
14/09/25 13:42:40 INFO mapred.MapTask: Spilling map output
14/09/25 13:42:40 INFO mapred.MapTask: bufstart = 0; bufend = 17; bufvoid = 104857600
14/09/25 13:42:40 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214396(104857584); length = 1/6553600
14/09/25 13:42:40 INFO mapred.MapTask: Finished spill 0
14/09/25 13:42:40 INFO mapred.Task: Task:attempt_local495388153_0002_m_000000_0 is done. And is in the process of committing
14/09/25 13:42:40 INFO mapred.LocalJobRunner: map
14/09/25 13:42:40 INFO mapred.Task: Task 'attempt_local495388153_0002_m_000000_0' done.
14/09/25 13:42:40 INFO mapred.LocalJobRunner: Finishing task: attempt_local495388153_0002_m_000000_0
14/09/25 13:42:40 INFO mapred.LocalJobRunner: map task executor complete.
14/09/25 13:42:40 INFO mapred.LocalJobRunner: Waiting for reduce tasks
14/09/25 13:42:40 INFO mapred.LocalJobRunner: Starting task: attempt_local495388153_0002_r_000000_0
14/09/25 13:42:40 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
14/09/25 13:42:40 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
14/09/25 13:42:40 INFO mapred.ReduceTask: Using ShuffleConsumerPlugin: org.apache.hadoop.mapreduce.task.reduce.Shuffle@5c666399
14/09/25 13:42:40 INFO reduce.MergeManagerImpl: MergerManager: memoryLimit=333971456, maxSingleShuffleLimit=83492864, mergeThreshold=220421168, ioSortFactor=10, memToMemMergeOutputsThreshold=10
14/09/25 13:42:40 INFO reduce.EventFetcher: attempt_local495388153_0002_r_000000_0 Thread started: EventFetcher for fetching Map Completion Events
14/09/25 13:42:40 INFO reduce.LocalFetcher: localfetcher#2 about to shuffle output of map attempt_local495388153_0002_m_000000_0 decomp: 21 len: 25 to MEMORY
14/09/25 13:42:40 INFO reduce.InMemoryMapOutput: Read 21 bytes from map-output for attempt_local495388153_0002_m_000000_0
14/09/25 13:42:40 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 21, inMemoryMapOutputs.size() -> 1, commitMemory -> 0, usedMemory ->21
14/09/25 13:42:40 INFO reduce.EventFetcher: EventFetcher is interrupted.. Returning
14/09/25 13:42:40 INFO mapred.LocalJobRunner: 1 / 1 copied.
14/09/25 13:42:40 INFO reduce.MergeManagerImpl: finalMerge called with 1 in-memory map-outputs and 0 on-disk map-outputs
14/09/25 13:42:40 INFO mapred.Merger: Merging 1 sorted segments
14/09/25 13:42:40 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 11 bytes
14/09/25 13:42:40 INFO reduce.MergeManagerImpl: Merged 1 segments, 21 bytes to disk to satisfy reduce memory limit
14/09/25 13:42:40 INFO reduce.MergeManagerImpl: Merging 1 files, 25 bytes from disk
14/09/25 13:42:40 INFO reduce.MergeManagerImpl: Merging 0 segments, 0 bytes from memory into reduce
14/09/25 13:42:40 INFO mapred.Merger: Merging 1 sorted segments
14/09/25 13:42:40 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 11 bytes
14/09/25 13:42:40 INFO mapred.LocalJobRunner: 1 / 1 copied.
14/09/25 13:42:40 INFO mapred.Task: Task:attempt_local495388153_0002_r_000000_0 is done. And is in the process of committing
14/09/25 13:42:40 INFO mapred.LocalJobRunner: 1 / 1 copied.
14/09/25 13:42:40 INFO mapred.Task: Task attempt_local495388153_0002_r_000000_0 is allowed to commit now
14/09/25 13:42:40 INFO output.FileOutputCommitter: Saved output of task 'attempt_local495388153_0002_r_000000_0' to file:/Users/zlq/servers/hadoop/hadoop-2.5.1/output/_temporary/0/task_local495388153_0002_r_000000
14/09/25 13:42:40 INFO mapred.LocalJobRunner: reduce > reduce
14/09/25 13:42:40 INFO mapred.Task: Task 'attempt_local495388153_0002_r_000000_0' done.
14/09/25 13:42:40 INFO mapred.LocalJobRunner: Finishing task: attempt_local495388153_0002_r_000000_0
14/09/25 13:42:40 INFO mapred.LocalJobRunner: reduce task executor complete.
14/09/25 13:42:41 INFO mapreduce.Job: Job job_local495388153_0002 running in uber mode : false
14/09/25 13:42:41 INFO mapreduce.Job:  map 100% reduce 100%
14/09/25 13:42:41 INFO mapreduce.Job: Job job_local495388153_0002 completed successfully
14/09/25 13:42:41 INFO mapreduce.Job: Counters: 30
	File System Counters
		FILE: Number of bytes read=40428
		FILE: Number of bytes written=911918
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
	Map-Reduce Framework
		Map input records=1
		Map output records=1
		Map output bytes=17
		Map output materialized bytes=25
		Input split bytes=142
		Combine input records=0
		Combine output records=0
		Reduce input groups=1
		Reduce shuffle bytes=25
		Reduce input records=1
		Reduce output records=1
		Spilled Records=2
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=49
		Total committed heap usage (bytes)=400556032
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=123
	File Output Format Counters
		Bytes Written=23
```

$ cat output/*

输出内容如下

```
1	dfsadmin
```
