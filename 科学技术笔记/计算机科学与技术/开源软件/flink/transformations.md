this.transformations = {java.util.ArrayList@1009}  size = 4
 0 = {org.apache.flink.streaming.api.transformations.OneInputTransformation@1008} "OneInputTransformation{id=2, name='Split Reader: Custom File Source', outputType=String, parallelism=-1}"
  input: org.apache.flink.streaming.api.transformations.StreamTransformation  = {org.apache.flink.streaming.api.transformations.SourceTransformation@1513} "SourceTransformation{id=1, name='Custom File Source', outputType=GenericType<org.apache.flink.streaming.api.functions.source.TimestampedFileInputSplit>, parallelism=1}"
  operator: org.apache.flink.streaming.api.operators.OneInputStreamOperator  = {org.apache.flink.streaming.api.functions.source.ContinuousFileReaderOperator@1022} 
  stateKeySelector: org.apache.flink.api.java.functions.KeySelector  = null
  stateKeyType: org.apache.flink.api.common.typeinfo.TypeInformation  = null
  idCounter: java.lang.Integer  = {java.lang.Integer@1488} "6"
  id: int  = 2
  name: java.lang.String  = "Split Reader: Custom File Source"
  outputType: org.apache.flink.api.common.typeinfo.TypeInformation  = {org.apache.flink.api.common.typeinfo.BasicTypeInfo@1021} "String"
  typeUsed: boolean  = true
  parallelism: int  = -1
  maxParallelism: int  = -1
  minResources: org.apache.flink.api.common.operators.ResourceSpec  = {org.apache.flink.api.common.operators.ResourceSpec@1293} "ResourceSpec{cpuCores=0.0, heapMemoryInMB=0, directMemoryInMB=0, nativeMemoryInMB=0, stateSizeInMB=0}"
  preferredResources: org.apache.flink.api.common.operators.ResourceSpec  = {org.apache.flink.api.common.operators.ResourceSpec@1293} "ResourceSpec{cpuCores=0.0, heapMemoryInMB=0, directMemoryInMB=0, nativeMemoryInMB=0, stateSizeInMB=0}"
  uid: java.lang.String  = null
  userProvidedNodeHash: java.lang.String  = null
  bufferTimeout: long  = -1
  slotSharingGroup: java.lang.String  = null
 1 = {org.apache.flink.streaming.api.transformations.OneInputTransformation@1223} "OneInputTransformation{id=3, name='Flat Map', outputType=Java Tuple2<String, Integer>, parallelism=-1}"
  input: org.apache.flink.streaming.api.transformations.StreamTransformation  = {org.apache.flink.streaming.api.transformations.OneInputTransformation@1008} "OneInputTransformation{id=2, name='Split Reader: Custom File Source', outputType=String, parallelism=-1}"
  operator: org.apache.flink.streaming.api.operators.OneInputStreamOperator  = {org.apache.flink.streaming.api.operators.StreamFlatMap@1520} 
  stateKeySelector: org.apache.flink.api.java.functions.KeySelector  = null
  stateKeyType: org.apache.flink.api.common.typeinfo.TypeInformation  = null
  idCounter: java.lang.Integer  = {java.lang.Integer@1488} "6"
  id: int  = 3
  name: java.lang.String  = "Flat Map"
  outputType: org.apache.flink.api.common.typeinfo.TypeInformation  = {org.apache.flink.api.java.typeutils.TupleTypeInfo@1185} "Java Tuple2<String, Integer>"
  typeUsed: boolean  = true
  parallelism: int  = -1
  maxParallelism: int  = -1
  minResources: org.apache.flink.api.common.operators.ResourceSpec  = {org.apache.flink.api.common.operators.ResourceSpec@1293} "ResourceSpec{cpuCores=0.0, heapMemoryInMB=0, directMemoryInMB=0, nativeMemoryInMB=0, stateSizeInMB=0}"
  preferredResources: org.apache.flink.api.common.operators.ResourceSpec  = {org.apache.flink.api.common.operators.ResourceSpec@1293} "ResourceSpec{cpuCores=0.0, heapMemoryInMB=0, directMemoryInMB=0, nativeMemoryInMB=0, stateSizeInMB=0}"
  uid: java.lang.String  = null
  userProvidedNodeHash: java.lang.String  = null
  bufferTimeout: long  = -1
  slotSharingGroup: java.lang.String  = null
 2 = {org.apache.flink.streaming.api.transformations.OneInputTransformation@1359} "OneInputTransformation{id=5, name='Keyed Aggregation', outputType=Java Tuple2<String, Integer>, parallelism=-1}"
  input: org.apache.flink.streaming.api.transformations.StreamTransformation  = {org.apache.flink.streaming.api.transformations.PartitionTransformation@1305} "PartitionTransformation{id=4, name='Partition', outputType=Java Tuple2<String, Integer>, parallelism=-1}"
  operator: org.apache.flink.streaming.api.operators.OneInputStreamOperator  = {org.apache.flink.streaming.api.operators.StreamGroupedReduce@1363} 
  stateKeySelector: org.apache.flink.api.java.functions.KeySelector  = {org.apache.flink.streaming.util.keys.KeySelectorUtil$ComparableKeySelector@1287} 
  stateKeyType: org.apache.flink.api.common.typeinfo.TypeInformation  = {org.apache.flink.api.java.typeutils.TupleTypeInfo@1288} "Java Tuple1<String>"
  idCounter: java.lang.Integer  = {java.lang.Integer@1488} "6"
  id: int  = 5
  name: java.lang.String  = "Keyed Aggregation"
  outputType: org.apache.flink.api.common.typeinfo.TypeInformation  = {org.apache.flink.api.java.typeutils.TupleTypeInfo@1185} "Java Tuple2<String, Integer>"
  typeUsed: boolean  = true
  parallelism: int  = -1
  maxParallelism: int  = -1
  minResources: org.apache.flink.api.common.operators.ResourceSpec  = {org.apache.flink.api.common.operators.ResourceSpec@1293} "ResourceSpec{cpuCores=0.0, heapMemoryInMB=0, directMemoryInMB=0, nativeMemoryInMB=0, stateSizeInMB=0}"
  preferredResources: org.apache.flink.api.common.operators.ResourceSpec  = {org.apache.flink.api.common.operators.ResourceSpec@1293} "ResourceSpec{cpuCores=0.0, heapMemoryInMB=0, directMemoryInMB=0, nativeMemoryInMB=0, stateSizeInMB=0}"
  uid: java.lang.String  = null
  userProvidedNodeHash: java.lang.String  = null
  bufferTimeout: long  = -1
  slotSharingGroup: java.lang.String  = null
 3 = {org.apache.flink.streaming.api.transformations.SinkTransformation@1482} "SinkTransformation{id=6, name='Unnamed', outputType=GenericType<java.lang.Object>, parallelism=-1}"
  input: org.apache.flink.streaming.api.transformations.StreamTransformation  = {org.apache.flink.streaming.api.transformations.OneInputTransformation@1359} "OneInputTransformation{id=5, name='Keyed Aggregation', outputType=Java Tuple2<String, Integer>, parallelism=-1}"
  operator: org.apache.flink.streaming.api.operators.StreamSink  = {org.apache.flink.streaming.api.operators.StreamSink@1477} 
  stateKeySelector: org.apache.flink.api.java.functions.KeySelector  = null
  stateKeyType: org.apache.flink.api.common.typeinfo.TypeInformation  = null
  idCounter: java.lang.Integer  = {java.lang.Integer@1488} "6"
  id: int  = 6
  name: java.lang.String  = "Unnamed"
  outputType: org.apache.flink.api.common.typeinfo.TypeInformation  = {org.apache.flink.api.java.typeutils.GenericTypeInfo@1490} "GenericType<java.lang.Object>"
  typeUsed: boolean  = false
  parallelism: int  = -1
  maxParallelism: int  = -1
  minResources: org.apache.flink.api.common.operators.ResourceSpec  = {org.apache.flink.api.common.operators.ResourceSpec@1293} "ResourceSpec{cpuCores=0.0, heapMemoryInMB=0, directMemoryInMB=0, nativeMemoryInMB=0, stateSizeInMB=0}"
  preferredResources: org.apache.flink.api.common.operators.ResourceSpec  = {org.apache.flink.api.common.operators.ResourceSpec@1293} "ResourceSpec{cpuCores=0.0, heapMemoryInMB=0, directMemoryInMB=0, nativeMemoryInMB=0, stateSizeInMB=0}"
  uid: java.lang.String  = null
  userProvidedNodeHash: java.lang.String  = null
  bufferTimeout: long  = -1
  slotSharingGroup: java.lang.String  = null