

# SolrDispatchFilter doFilter处理流程

根据path解析出处理器SearchHandler

StandardRequestParser将URL参数解析成一个SolrParams对象，然后构造出SolrQueryRequest（实现类SolrQueryRequestBase）对象

调用execute( HttpServletRequest req, SolrRequestHandler handler, SolrQueryRequest sreq, SolrQueryResponse rsp)，这个方法调用SolrCore的execute(SolrRequestHandler handler, SolrQueryRequest req, SolrQueryResponse rsp)方法，该方法依次调用preDecorateResponse(req, rsp);handler.handleRequest(req,rsp);postDecorateResponse(handler, req, rsp);


# 处理器
RequestHandlerBase的处理为处理器的基类

select的处理器为org.apache.solr.handler.component.SearchHandler

# RequestHandlerBase的处理流程（handleRequest方法的流程）

调用具体实现类的handleRequestBody( SolrQueryRequest req, SolrQueryResponse rsp )方法


#SearchHandler的handleRequestBody(SolrQueryRequest req, SolrQueryResponse rsp)方法处理流程

构造一个ResponseBuilder对象，这个对象会传递到所有调用的SearchComponent，这些SearchComponent的prepare;process;

### prepare阶段处理流程
根据defType获取语法解析器

defType为lucene时org.apache.solr.search.LuceneQParser

语法解析器将q=xxx解析成一个Query对象

将sort，start，limit参数解析成SortSpec对象

解析fq参数，同样使用LuceneQParser解析，首先将其解析成一个Query对象，最后将这个Query对象放到List<Query>类型的filters变量中

### process阶段处理流程

#### 第一个组件QueryComponent

获取一个SolrIndexSearcher对象

从ResponseBuilder对象创建一个SolrIndexSearcher.QueryCommand对象，QueryCommand保存了Query对象和filters（List<Query>）

调用searcher.search(QueryResult qr, QueryCommand cmd);方法，这个方法处理查询，将结果注入到QueryResult类型的对象


# SolrIndexSearcher类

## getDocListC(QueryResult qr, QueryCommand cmd)方法，该方法会使用和填充query 和 filter缓存

### queryResultCache的key设置，1344行key = new QueryResultKey(q, cmd.getFilterList(), cmd.getSort(), flags);
