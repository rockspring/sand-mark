插件数据结构

```
public class PluginInfo {
    public final String name, className, type;
    public final NamedList initArgs;
    public final Map<String, String> attributes;
    public final List<PluginInfo> children;
}
```

solrconfig.xml中得片段

```
<valueSourceParser name="myfunc" class="com.mycompany.MyValueSourceParser">
    <int name="intArgOne">1000</int>
</valueSourceParser>
```

`name`对应于`myfunc`

`className`对应于`com.mycompany.MyValueSourceParser`

`type`对应于`valueSourceParser`

`initArgs`对应于`<int name="intArgOne">1000</int>`

`attributes`对应于`name="myfunc" class="com.mycompany.MyValueSourceParser"`

`children`对应的XML如何写？


插件数据结构加载流程

1 SolrDispatchFilter执行init方法

2 CoreContainer执行load方法

    使用CoresLocator定位到solrCore，对每个solrCore创建一个CoreDescriptor对象

    根据每个solrCore的CoreDescriptor对象并行地创建solrCore

3 CoreContainer执行createFromLocal方法

    创建SolrConfig对象

4 SolrConfig构造函数从配置文件读取插件信息PluginInfo，创建插件信息对象

5 CoreContainer执行createFromLocalSolrCore方法构造SolrCore对象

6 SolrCore构造函数调用SolrCore的initValueSourceParsers方法初始化valueSourceParser

7 SolrCore的initValueSourceParsers方法调用SolrCore的initPlugins方法初始化solrconfig.xml文件中配置的valueSourceParser插件

8 SolrCore调用createInstance通过插件权限定类型执行默认无参数构造方法构造插件对象

9 如果插件实现了NamedListInitializedPlugin接口，即可以通过NamedList参数初始化，调用NamedListInitializedPlugin的init方法初始化插件

10 SolrCore的initValueSourceParsers方法初始化solr自带的标准valueSourceParser

11 SolrCore将所有初始化好的valueSourceParser保存在一个HashMap<String, ValueSourceParser>结构的属性valueSourceParsers中


如何开发ValueSourceParser插件？

已知信息

ValueSourceParser抽象类实现了NamedListInitializedPlugin接口，但是实现的init方法什么都不做

ValueSourceParser启动时进行初始化，启动后整个solr进程中每个SolrCore中只有一个实例

ValueSourceParser有一个parse方法，每次请求都会根据查询字符串中的信息调用这个方法，创建ValueSource对象


FunctionQParser继承了QParser，是一个带状态的解析器

```
public abstract class QParser {
  protected String qstr;
  protected SolrParams params;
  protected SolrParams localParams;
  protected SolrQueryRequest req;
  protected int recurseCount;

  protected Query query;

  protected String stringIncludingLocalParams;   // the original query string including any local params
  protected boolean valFollowedParams;           // true if the value "qstr" followed the localParams
  protected int localParamsEnd;                  // the position one past where the localParams ended
}

public class FunctionQParser extends QParser {

  /** @lucene.internal */
  public QueryParsing.StrParser sp;
  boolean parseMultipleSources = true;
  boolean parseToEnd = true;
}
```

FunctionQParser是请求解析层的解析器，只要遇到函数查询语法，就创建一个FunctionQParser实例

FunctionQParser会使用SolrCore中的ValueSourceParser解析查询语句，创建相应的ValueSource供本次请求使用


函数查询可以用在哪里呢？

返回字段

返回的字段值是通过一个函数得来的，而不是某个已有的字段的值

排序

排序字段是通过一个函数得来的，而不是某个已有的字段值

