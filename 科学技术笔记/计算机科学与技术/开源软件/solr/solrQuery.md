/select
实现类org.apache.solr.handler.component.SearchHandler


调用SolrCore构造函数
>>调用RequestHandlers的initHandlersFromConfig(SolrConfig config)方法
initHandlersFromConfig处理步骤：
取得SolrRequestHandler类型的插件信息
对每一个插件，作如下事情：
	对于延迟启动的handler，创建LazyRequestHandlerWrapper
	对于非延迟启动的handler，直接创建handler
	注册handler
对每一个已注册的handler，做如下事情：
	进行初始化操作

##SearchHandler处理器初始化

init(PluginInfo info)方法
>>调用init(NamedList args)方法
	将配置文件中的defaults,appends,invariants信息转换成solr参数类型

##SearchHandler请求处理流程

请求依次流经下列对象
SolrDispatchFilter
SolrCore
SearchHandler


handleRequest方法
	调用handleRequestBody方法
	调用SolrQueryResponse的getResponseHeader方法
handleRequestBody方法，做如下事情
准备每个搜索组件：QueryComponent、FacetComponent、MoreLikeThisComponent、HighlightComponent、StatsComponent、DebugComponent

对每个搜索组件，执行process方法，传入ResponseBuilder给这个方法


##查询缓存
SolrIndexSearcher的void getDocListC(QueryResult qr, QueryCommand cmd)方法中查询缓存
key = new QueryResultKey(q, cmd.getFilterList(), cmd.getSort(), flags);


SolrIndexSearcher.search 这里是SolrIndexSearcher的入口函数
SolrIndexSearcher.getDocListC
SolrIndexSearcher.getDocListNC
SolrIndexSearcher.getProcessedFilter
SolrIndexSearcher.getPositiveDocSet
	filterCache.get(Query q)查询成功，则返回结果；查询失败，调用SolrIndexSearcher.getDocSetNC(q,null)，然后将结果放入filterCache
缓存的key为q，q为fq解析的结果：如fq=id:1
