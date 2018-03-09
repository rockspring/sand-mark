#solr日志系统

##1 jetty日志模块
1.1 请求日志
添加一个RequestLogHandler
NCSARequestLog

1.2 系统运行日志
org.eclipse.jetty.util.log.Logger接口，org.eclipse.jetty.util.log.Log为具体类的，有一个方法getLogger()获取Logger的具体实现类

a,使用org.eclipse.jetty.util.log.Slf4jLog加载一个具体日志实现类，如log4j

b,直接使用org.eclipse.jetty.util.log.StdErrLog

##2，solr日志模块
使用slf4j的API，具体实现默认使用log4j

##3，Lucene日志信息
InfoStream抽象类，具体实现类PrintStreamInfoStream

参考资料
http://zh.wikipedia.org/wiki/Apache_HTTP_Server