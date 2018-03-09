##solr缓存类型

filterCache SolrCache<Query,DocSet>
queryResultCache SolrCache<QueryResultKey,DocList>
documentCache SolrCache<Integer,Document>
fieldValueCache SolrCache<String,UnInvertedField>

##谁持有solr的缓存

SolrIndexSearcher

##queryResultCache的QueryResultKey

Query query;
List<Query> filters;
Sort sort;
int nc_flags;


接口CacheRegenerator
实现类NoOpRegenerator
所属包package org.apache.solr.search
作用：使用旧的项填充到新的缓存对象中，对新的搜索器进行自动预热


SolrCache的状态有4种
CREATED
STATICWARMING
AUTOWARMING
LIVE

调用init函数初始化后，状态为CREATED，cache的使用方改变它的状态


FastLRUCache
包装了ConcurrentLRUCache