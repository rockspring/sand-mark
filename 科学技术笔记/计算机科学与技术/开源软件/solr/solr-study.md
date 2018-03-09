# 版本

6.4.1

# solr启动

```
at org.apache.solr.servlet.SolrDispatchFilter.init(SolrDispatchFilter.java:136)
at org.eclipse.jetty.servlet.FilterHolder.initialize(FilterHolder.java:137)
at org.eclipse.jetty.servlet.ServletHandler.initialize(ServletHandler.java:873)
at org.eclipse.jetty.servlet.ServletContextHandler.startContext(ServletContextHandler.java:349)
at org.eclipse.jetty.webapp.WebAppContext.startWebapp(WebAppContext.java:1404)
at org.eclipse.jetty.webapp.WebAppContext.startContext(WebAppContext.java:1366)
at org.eclipse.jetty.server.handler.ContextHandler.doStart(ContextHandler.java:778)
at org.eclipse.jetty.servlet.ServletContextHandler.doStart(ServletContextHandler.java:262)
at org.eclipse.jetty.webapp.WebAppContext.doStart(WebAppContext.java:520)
at org.eclipse.jetty.util.component.AbstractLifeCycle.start(AbstractLifeCycle.java:68)
- locked <0x78d> (a java.lang.Object)
at org.eclipse.jetty.deploy.bindings.StandardStarter.processBinding(StandardStarter.java:41)
at org.eclipse.jetty.deploy.AppLifeCycle.runBindings(AppLifeCycle.java:188)
at org.eclipse.jetty.deploy.DeploymentManager.requestAppGoal(DeploymentManager.java:499)
at org.eclipse.jetty.deploy.DeploymentManager.addApp(DeploymentManager.java:147)
at org.eclipse.jetty.deploy.providers.ScanningAppProvider.fileAdded(ScanningAppProvider.java:180)
at org.eclipse.jetty.deploy.providers.WebAppProvider.fileAdded(WebAppProvider.java:458)
at org.eclipse.jetty.deploy.providers.ScanningAppProvider$1.fileAdded(ScanningAppProvider.java:64)
at org.eclipse.jetty.util.Scanner.reportAddition(Scanner.java:610)
at org.eclipse.jetty.util.Scanner.reportDifferences(Scanner.java:529)
- locked <0x781> (a org.eclipse.jetty.util.Scanner)
at org.eclipse.jetty.util.Scanner.scan(Scanner.java:392)
at org.eclipse.jetty.util.Scanner.doStart(Scanner.java:313)
at org.eclipse.jetty.util.component.AbstractLifeCycle.start(AbstractLifeCycle.java:68)
- locked <0x78e> (a java.lang.Object)
at org.eclipse.jetty.deploy.providers.ScanningAppProvider.doStart(ScanningAppProvider.java:150)
at org.eclipse.jetty.util.component.AbstractLifeCycle.start(AbstractLifeCycle.java:68)
- locked <0x78f> (a java.lang.Object)
at org.eclipse.jetty.deploy.DeploymentManager.startAppProvider(DeploymentManager.java:561)
at org.eclipse.jetty.deploy.DeploymentManager.doStart(DeploymentManager.java:236)
at org.eclipse.jetty.util.component.AbstractLifeCycle.start(AbstractLifeCycle.java:68)
- locked <0x790> (a java.lang.Object)
at org.eclipse.jetty.util.component.ContainerLifeCycle.start(ContainerLifeCycle.java:131)
at org.eclipse.jetty.server.Server.start(Server.java:422)
at org.eclipse.jetty.util.component.ContainerLifeCycle.doStart(ContainerLifeCycle.java:113)
at org.eclipse.jetty.server.handler.AbstractHandler.doStart(AbstractHandler.java:61)
at org.eclipse.jetty.server.Server.doStart(Server.java:389)
at org.eclipse.jetty.util.component.AbstractLifeCycle.start(AbstractLifeCycle.java:68)
- locked <0x791> (a java.lang.Object)
at org.eclipse.jetty.xml.XmlConfiguration$1.run(XmlConfiguration.java:1516)
at java.security.AccessController.doPrivileged(AccessController.java:-1)
at org.eclipse.jetty.xml.XmlConfiguration.main(XmlConfiguration.java:1441)
at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-1)
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.lang.reflect.Method.invoke(Method.java:497)
at org.eclipse.jetty.start.Main.invokeMain(Main.java:214)
at org.eclipse.jetty.start.Main.start(Main.java:457)
at org.eclipse.jetty.start.Main.main(Main.java:75)
```

# solr 请求处理

```
at org.apache.solr.servlet.SolrDispatchFilter.doFilter(SolrDispatchFilter.java:300)
at org.apache.solr.servlet.SolrDispatchFilter.doFilter(SolrDispatchFilter.java:351)
at org.apache.solr.servlet.SolrDispatchFilter.doFilter(SolrDispatchFilter.java:296)
at org.eclipse.jetty.servlet.ServletHandler$CachedChain.doFilter(ServletHandler.java:1691)
at org.eclipse.jetty.servlet.ServletHandler.doHandle(ServletHandler.java:582)
at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:143)
at org.eclipse.jetty.security.SecurityHandler.handle(SecurityHandler.java:548)
at org.eclipse.jetty.server.session.SessionHandler.doHandle(SessionHandler.java:226)
at org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:1180)
at org.eclipse.jetty.servlet.ServletHandler.doScope(ServletHandler.java:512)
at org.eclipse.jetty.server.session.SessionHandler.doScope(SessionHandler.java:185)
at org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:1112)
at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:141)
at org.eclipse.jetty.server.handler.ContextHandlerCollection.handle(ContextHandlerCollection.java:213)
at org.eclipse.jetty.server.handler.HandlerCollection.handle(HandlerCollection.java:119)
at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:134)
at org.eclipse.jetty.server.Server.handle(Server.java:534)
at org.eclipse.jetty.server.HttpChannel.handle(HttpChannel.java:320)
at org.eclipse.jetty.server.HttpConnection.onFillable(HttpConnection.java:251)
at org.eclipse.jetty.io.AbstractConnection$ReadCallback.succeeded(AbstractConnection.java:273)
at org.eclipse.jetty.io.FillInterest.fillable(FillInterest.java:95)
at org.eclipse.jetty.io.SelectChannelEndPoint$2.run(SelectChannelEndPoint.java:93)
at org.eclipse.jetty.util.thread.strategy.ExecuteProduceConsume.executeProduceConsume(ExecuteProduceConsume.java:303)
at org.eclipse.jetty.util.thread.strategy.ExecuteProduceConsume.produceConsume(ExecuteProduceConsume.java:148)
at org.eclipse.jetty.util.thread.strategy.ExecuteProduceConsume.run(ExecuteProduceConsume.java:136)
at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:671)
at org.eclipse.jetty.util.thread.QueuedThreadPool$2.run(QueuedThreadPool.java:589)
at java.lang.Thread.run(Thread.java:745)
```

# QParserPlugin

```
bbox org.apache.solr.search.SpatialBoxQParserPlugin
boost org.apache.solr.search.BoostQParserPlugin
child org.apache.solr.search.join.BlockJoinChildQParserPlugin
collapse org.apache.solr.search.CollapsingQParserPlugin
complexphrase org.apache.solr.search.ComplexPhraseQParserPlugin
dismax org.apache.solr.search.DisMaxQParserPlugin
edismax org.apache.solr.search.ExtendedDismaxQParserPlugin
field org.apache.solr.search.FieldQParserPlugin
frange org.apache.solr.search.FunctionRangeQParserPlugin
func org.apache.solr.search.FunctionQParserPlugin
geofilt org.apache.solr.search.SpatialFilterQParserPlugin
graph org.apache.solr.search.join.GraphQParserPlugin
graphTerms org.apache.solr.search.GraphTermsQParserPlugin
hash org.apache.solr.search.HashQParserPlugin
igain org.apache.solr.search.IGainTermsQParserPlugin
join org.apache.solr.search.JoinQParserPlugin
lucene org.apache.solr.search.LuceneQParserPlugin
lucenePlusSort org.apache.solr.search.OldLuceneQParserPlugin
maxscore org.apache.solr.search.MaxScoreQParserPlugin
mlt org.apache.solr.search.mlt.MLTQParserPlugin
parent org.apache.solr.search.join.BlockJoinParentQParserPlugin
prefix org.apache.solr.search.PrefixQParserPlugin
query org.apache.solr.search.NestedQParserPlugin
raw org.apache.solr.search.RawQParserPlugin
rerank org.apache.solr.search.ReRankQParserPlugin
simple org.apache.solr.search.SimpleQParserPlugin
surround org.apache.solr.search.SurroundQParserPlugin
switch org.apache.solr.search.SwitchQParserPlugin
term org.apache.solr.search.TermQParserPlugin
terms org.apache.solr.search.TermsQParserPlugin
tlogit org.apache.solr.search.TextLogisticRegressionQParserPlugin
xmlparser org.apache.solr.search.XmlQParserPlugin
xport org.apache.solr.search.ExportQParserPlugin
```

# QParser

org.apache.solr.search.QParser，一个抽象类。

QParser有静态接口方法getParser可以得到具体的QParser。具体QParser是在具体类QParserPlugin的createParser方法中创建的匿名类。

org.apache.solr.servlet.SolrDispatchFilter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain, boolean)
   |
   |
（调用）
   |
  \|/
org.apache.solr.servlet.HttpSolrCall#call
   |
   |
（调用）
   |
  \|/
org.apache.solr.servlet.HttpSolrCall#execute
   |
   |
（调用）
   |
  \|/
org.apache.solr.handler.component.QueryComponent#process
   |
   |
（调用）
   |
  \|/
org.apache.solr.core.SolrCore#getSearcher(boolean, boolean, java.util.concurrent.Future[], boolean)
   |
   |
（调用）
   |
  \|/
org.apache.solr.core.QuerySenderListener#newSearcher
   |
   |
（调用）
   |
  \|/
org.apache.solr.core.SolrCore#execute
   |
   |
（调用）
   |
  \|/
org.apache.solr.handler.RequestHandlerBase#handleRequest
   |
   |
（调用）
   |
  \|/
org.apache.solr.handler.component.SearchHandler#handleRequestBody
   |
   |
（调用）
   |
  \|/
org.apache.solr.handler.component.QueryComponent#prepare
   |
   |
（调用）
   |
  \|/
org.apache.solr.search.QParser#getParser(java.lang.String, java.lang.String, org.apache.solr.request.SolrQueryRequest)
   |
   |
（调用）
   |
  \|/
org.apache.solr.search.LuceneQParserPlugin#createParser
   |
   |
（调用）
   |
  \|/
org.apache.solr.search.LuceneQParser#LuceneQParser



# 短语查询

org.apache.solr.search.ComplexPhraseQParserPlugin.ComplexPhraseQParser


