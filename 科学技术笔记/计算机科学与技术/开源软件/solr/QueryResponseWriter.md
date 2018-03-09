#QueryResponseWriter

QueryResponseWriter以solr插件的形式插入到solr
在solrconfig.xml里配置相关参数

分写二进制数据和写文本数据量写者
BinaryQueryResponseWriter
TextResponseWriter

BinaryQueryResponseWriter
1，BinaryResponseWriter
2，RawResponseWriter

TextResponseWriter
1，CSVWriter
2，JSONWriter
	2.1，NaNFloatWriter
		2.1.1，PythonWriter
		2.1.2，RubyWriter
	2.2，PHPSerializedWriter
	2.3，PHPWriter
3，SchemaXmlWriter
4，XMLWriter

操作接口
public void write(Writer writer, SolrQueryRequest request, SolrQueryResponse response)
传入一个实现了Writer接口的对象，有如下两种：
org.apache.solr.util.FastWriter

SolrDispatchFilter的writeResponse方法调用上面的方法，通过包装response的ServletOutputStream创建一个OutputStreamWriter对象，然后使用FastWriter包装
void writeResponse(SolrQueryResponse solrRsp,
ServletResponse response,
QueryResponseWriter responseWriter,
SolrQueryRequest solrReq,
Method reqMethod)
