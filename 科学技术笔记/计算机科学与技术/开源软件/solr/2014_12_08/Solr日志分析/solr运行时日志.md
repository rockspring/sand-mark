solr运行时日志如下
```
INFO  - 2014-12-08 15:48:39.944; [qtp524450165-15 - /solr/update] org.apache.solr.update.processor.LogUpdateProcessor.finish(LogUpdateProcessorFactory.java:198); [collection1] webapp=/solr path=/update params={} {delete=[SP2514N583 (-1486906898454151168)]} 0 1
```

最后一列是流失的时间

开始时间是什么？

SolrQueryRequestBase被创建时系统时间

结束时间是什么？

从SolrQueryResponse对象获取

	* 设置了endtime字段的值，则返回该值
	* 没有设置endtime字段的值，则使用当前系统时间设置endtime字段