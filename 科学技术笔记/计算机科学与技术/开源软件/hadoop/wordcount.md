需要先执行sudo ln -s $JAVA_HOME/bin/java /bin/java


Apples-MacBook-Pro-2:Tmp zlq$ /Users/zlq/servers/hadoop/hadoop-2.5.1/bin/hadoop jar wc.jar WordCount /user/zlq/wordcount/input /user/zlq/wordcount/output
14/09/25 16:43:18 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
14/09/25 16:43:19 INFO client.RMProxy: Connecting to ResourceManager at /0.0.0.0:8032
14/09/25 16:43:20 WARN mapreduce.JobSubmitter: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
14/09/25 16:43:20 INFO input.FileInputFormat: Total input paths to process : 2
14/09/25 16:43:20 INFO mapreduce.JobSubmitter: number of splits:2
14/09/25 16:43:20 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1411627289376_0003
14/09/25 16:43:20 INFO impl.YarnClientImpl: Submitted application application_1411627289376_0003
14/09/25 16:43:20 INFO mapreduce.Job: The url to track the job: http://Apples-MacBook-Pro-2.local:8088/proxy/application_1411627289376_0003/
14/09/25 16:43:20 INFO mapreduce.Job: Running job: job_1411627289376_0003
14/09/25 16:43:26 INFO mapreduce.Job: Job job_1411627289376_0003 running in uber mode : false
14/09/25 16:43:26 INFO mapreduce.Job:  map 0% reduce 0%
14/09/25 16:43:32 INFO mapreduce.Job:  map 100% reduce 0%
14/09/25 16:43:38 INFO mapreduce.Job:  map 100% reduce 100%
14/09/25 16:43:38 INFO mapreduce.Job: Job job_1411627289376_0003 completed successfully
14/09/25 16:43:39 INFO mapreduce.Job: Counters: 49
	File System Counters
		FILE: Number of bytes read=79
		FILE: Number of bytes written=290314
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=286
		HDFS: Number of bytes written=41
		HDFS: Number of read operations=9
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters
		Launched map tasks=2
		Launched reduce tasks=1
		Data-local map tasks=2
		Total time spent by all maps in occupied slots (ms)=8039
		Total time spent by all reduces in occupied slots (ms)=3080
		Total time spent by all map tasks (ms)=8039
		Total time spent by all reduce tasks (ms)=3080
		Total vcore-seconds taken by all map tasks=8039
		Total vcore-seconds taken by all reduce tasks=3080
		Total megabyte-seconds taken by all map tasks=8231936
		Total megabyte-seconds taken by all reduce tasks=3153920
	Map-Reduce Framework
		Map input records=2
		Map output records=8
		Map output bytes=82
		Map output materialized bytes=85
		Input split bytes=236
		Combine input records=8
		Combine output records=6
		Reduce input groups=5
		Reduce shuffle bytes=85
		Reduce input records=6
		Reduce output records=5
		Spilled Records=12
		Shuffled Maps =2
		Failed Shuffles=0
		Merged Map outputs=2
		GC time elapsed (ms)=108
		CPU time spent (ms)=0
		Physical memory (bytes) snapshot=0
		Virtual memory (bytes) snapshot=0
		Total committed heap usage (bytes)=563085312
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=50
	File Output Format Counters
		Bytes Written=41



Apples-MacBook-Pro-2:Tmp zlq$ /Users/zlq/servers/hadoop/hadoop-2.5.1/bin/hdfs dfs -cat /user/zlq/wordcount/output/part-r-00000
14/09/25 16:46:22 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Bye	1
Goodbye	1
Hadoop	2
Hello	2
World	2