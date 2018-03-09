得到path对应的处理器

调用SolrDispatchFilter的doFilter方法
handler = core.getRequestHandler( path );

解析HttpServletRequest并创建SolrQueryRequest对象，设置

solrReq = parser.parse( core, path, req );

SolrQueryRequestBase q = new SolrQueryRequestBase( core, params ) { };

在SolrQueryRequestBase对象构造过程中设置请求开始时间startTime为当前系统时间

* 调用LogUpdateProcessor的finish方法

该方法执行时会打印一个日志

这个方法里设置SolrQueryResponse的endtime

然后打印如下日志，最后一列为处理请求流失的时间，endtime-startTime
```
INFO  - 2014-12-08 15:48:39.944; [qtp524450165-15 - /solr/update] org.apache.solr.update.processor.LogUpdateProcessor.finish(LogUpdateProcessorFactory.java:198); [collection1] webapp=/solr path=/update params={} {delete=[SP2514N583 (-1486906898454151168)]} 0 1
```

组装数据并写入网络通道，写完结束会记录如下日志

```
DEBUG - 2014-12-08 15:48:39.944; [qtp524450165-15 - /solr/update] org.apache.solr.servlet.SolrDispatchFilter.doFilter(SolrDispatchFilter.java:444); Closing out SolrRequest: {{params(),defaults(wt=xml)}}
```

Server的handle方法处理完毕，会记录如下日志

```
DEBUG - 2014-12-08 15:48:39.944; [qtp524450165-15 - /solr/update] org.eclipse.jetty.server.Server.handle(Server.java:365); RESPONSE /solr/update  200 handled=true
```