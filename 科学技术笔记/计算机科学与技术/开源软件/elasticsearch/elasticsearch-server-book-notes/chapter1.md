## 创建文档

```
curl -XPUT http://127.0.0.1:9200/blog/article/1?pretty -d '
{
     "id": "1",
     "title": "New version of Elasticsearch released!",
     "content": "Version 1.0 released today!",
     "priority": 10,
     "tags": ["announce", "elasticsearch", "release"]
}'
```

```
{
  "_index" : "blog",
  "_type" : "article",
  "_id" : "1",
  "_version" : 1,
  "created" : true
}
```

## 获取文档

```
curl -XGET http://127.0.0.1:9200/blog/article/1?pretty | python -msimplejson.tool
```

```
{
    "_id": "1",
    "_index": "blog",
    "_source": {
        "content": "Version 1.0 released today!",
        "id": "1",
        "priority": 10,
        "tags": [
            "announce",
            "elasticsearch",
            "release"
        ],
        "title": "New version of Elasticsearch released!"
    },
    "_type": "article",
    "_version": 1,
    "found": true
}
```

## 更新文档

自动生成一个唯一字段_id

```
curl -XPOST http://127.0.0.1:9200/blog/article?pretty -d '
{
     "id": "1",
     "title": "New version of Elasticsearch released!",
     "content": "Version 1.0 released today!",
     "priority": 10,
     "tags": ["announce", "elasticsearch", "release"]
}' | python -msimplejson.tool
```

```
{
    "_id": "AUr71_jeKgd9BTIn_GSU",
    "_index": "blog",
    "_type": "article",
    "_version": 1,
    "created": true
}
```

```
curl -XGET http://127.0.0.1:9200/blog/article/AUr71_jeKgd9BTIn_GSU?pretty | python -msimplejson.tool
```

```
curl -XPOST http://127.0.0.1:9200/blog/article/AUr71_jeKgd9BTIn_GSU?pretty -d '
{
     "id": "1",
     "title": "New version of Elasticsearch released!",
     "content": "Version 1.0 released today!",
     "priority": 10,
     "tags": ["announce", "elasticsearch", "release", "lucene"]
}' | python -msimplejson.tool
```


```
curl -XGET http://127.0.0.1:9200/blog/article/AUr71_jeKgd9BTIn_GSU?pretty | python -msimplejson.tool
```

## 删除文档

```
curl -XDELETE http://127.0.0.1:9200/blog/article/AUr71_jeKgd9BTIn_GSU?pretty | python -msimplejson.tool
```


# 搜索

## 全匹配搜索

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty'
```

所有index和所有document type
```
curl -XGET '127.0.0.1:9200/_search?pretty'
```

## term查询

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:elasticsearch' | python -msimplejson.tool
```

```
{
    "_shards": {
        "failed": 0,
        "successful": 5,
        "total": 5
    },
    "hits": {
        "hits": [
            {
                "_id": "1",
                "_index": "blog",
                "_score": 0.13424811,
                "_source": {
                    "content": "Version 1.0 released today!",
                    "id": "1",
                    "priority": 10,
                    "tags": [
                        "announce",
                        "elasticsearch",
                        "release"
                    ],
                    "title": "New version of Elasticsearch released!"
                },
                "_type": "article"
            }
        ],
        "max_score": 0.13424811,
        "total": 1
    },
    "timed_out": false,
    "took": 54
}
```

# 文本分析

## title字段

```
curl -XGET '127.0.0.1:9200/blog/_analyze?pretty&field=title' -d 'Elasticserach Server' | python -msimplejson.tool
```

```
{
    "tokens": [
        {
            "end_offset": 13,
            "position": 1,
            "start_offset": 0,
            "token": "elasticserach",
            "type": "<ALPHANUM>"
        },
        {
            "end_offset": 20,
            "position": 2,
            "start_offset": 14,
            "token": "server",
            "type": "<ALPHANUM>"
        }
    ]
}
```

```
curl -XGET '127.0.0.1:9200/blog/_analyze?pretty&field=title' -d 'elasticserach' | python -msimplejson.tool
```

```
{
    "tokens": [
        {
            "end_offset": 13,
            "position": 1,
            "start_offset": 0,
            "token": "elasticserach",
            "type": "<ALPHANUM>"
        }
    ]
}
```


# URI查询字符串参数

## query参数q

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:elasticsearch' | python -msimplejson.tool
```

## 默认搜索字段参数df

df默认值为_all

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=elasticsearch&df=title' | python -msimplejson.tool
```

## 查询参数文本分析器参数analyzer

## 默认布尔操作符参数default_operator

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=elasticsearch&df=title&default_operator=AND' | python -msimplejson.tool
```

## 查询结果解释参数explain

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:elasticsearch&explain=true' | python -msimplejson.tool
```

```
{
    "_shards": {
        "failed": 0,
        "successful": 5,
        "total": 5
    },
    "hits": {
        "hits": [
            {
                "_explanation": {
                    "description": "weight(title:elasticsearch in 0) [PerFieldSimilarity], result of:",
                    "details": [
                        {
                            "description": "fieldWeight in 0, product of:",
                            "details": [
                                {
                                    "description": "tf(freq=1.0), with freq of:",
                                    "details": [
                                        {
                                            "description": "termFreq=1.0",
                                            "value": 1.0
                                        }
                                    ],
                                    "value": 1.0
                                },
                                {
                                    "description": "idf(docFreq=1, maxDocs=1)",
                                    "value": 0.30685282
                                },
                                {
                                    "description": "fieldNorm(doc=0)",
                                    "value": 0.4375
                                }
                            ],
                            "value": 0.13424811
                        }
                    ],
                    "value": 0.13424811
                },
                "_id": "1",
                "_index": "blog",
                "_node": "yqUAjwGRQR-RYFjPTSF7kQ",
                "_score": 0.13424811,
                "_shard": 2,
                "_source": {
                    "content": "Version 1.0 released today!",
                    "id": "1",
                    "priority": 10,
                    "tags": [
                        "announce",
                        "elasticsearch",
                        "release"
                    ],
                    "title": "New version of Elasticsearch released!"
                },
                "_type": "article"
            }
        ],
        "max_score": 0.13424811,
        "total": 1
    },
    "timed_out": false,
    "took": 3
}
```

## 返回字段参数fields

默认情况下，每个返回的文档包含_id、_index、_score、_type、_source 5个字段，其中_source包含了文档的原始值，返回所有字段的值

通过fields参数，可以指定返回哪些文档字段

字段值从存储的字段或_source字段获取值

fields参数默认值为_source

通过参数_source=false禁止从_source字段获取文档值

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:elasticsearch&fields=title' | python -msimplejson.tool
```

```
{
    "_shards": {
        "failed": 0,
        "successful": 5,
        "total": 5
    },
    "hits": {
        "hits": [
            {
                "_id": "1",
                "_index": "blog",
                "_score": 0.13424811,
                "_type": "article",
                "fields": {
                    "title": [
                        "New version of Elasticsearch released!"
                    ]
                }
            }
        ],
        "max_score": 0.13424811,
        "total": 1
    },
    "timed_out": false,
    "took": 3
}
```

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:elasticsearch&_source=false' | python -msimplejson.tool
```

```
{
    "_shards": {
        "failed": 0,
        "successful": 5,
        "total": 5
    },
    "hits": {
        "hits": [
            {
                "_id": "1",
                "_index": "blog",
                "_score": 0.13424811,
                "_type": "article"
            }
        ],
        "max_score": 0.13424811,
        "total": 1
    },
    "timed_out": false,
    "took": 2
}
```

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:elasticsearch&fields=title&_source=false' | python -msimplejson.tool
```

```
{
    "_shards": {
        "failed": 0,
        "successful": 5,
        "total": 5
    },
    "hits": {
        "hits": [
            {
                "_id": "1",
                "_index": "blog",
                "_score": 0.13424811,
                "_type": "article",
                "fields": {
                    "title": [
                        "New version of Elasticsearch released!"
                    ]
                }
            }
        ],
        "max_score": 0.13424811,
        "total": 1
    },
    "timed_out": false,
    "took": 3
}
```

## 排序参数sort

默认排序规则为按分数降序

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:elasticsearch&sort=priority:desc' | python -msimplejson.tool
```

```
{
    "_shards": {
        "failed": 0,
        "successful": 5,
        "total": 5
    },
    "hits": {
        "hits": [
            {
                "_id": "1",
                "_index": "blog",
                "_score": null,
                "_source": {
                    "content": "Version 1.0 released today!",
                    "id": "1",
                    "priority": 10,
                    "tags": [
                        "announce",
                        "elasticsearch",
                        "release"
                    ],
                    "title": "New version of Elasticsearch released!"
                },
                "_type": "article",
                "sort": [
                    10
                ]
            }
        ],
        "max_score": null,
        "total": 1
    },
    "timed_out": false,
    "took": 52
}
```

如果指定排序规则，elastsearch忽略_score字段值的计算，通过track_scores参数使其计算_score字段值

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:elasticsearch&sort=priority:desc&track_scores=true' | python -msimplejson.tool
```

```
{
    "_shards": {
        "failed": 0,
        "successful": 5,
        "total": 5
    },
    "hits": {
        "hits": [
            {
                "_id": "1",
                "_index": "blog",
                "_score": 0.13424811,
                "_source": {
                    "content": "Version 1.0 released today!",
                    "id": "1",
                    "priority": 10,
                    "tags": [
                        "announce",
                        "elasticsearch",
                        "release"
                    ],
                    "title": "New version of Elasticsearch released!"
                },
                "_type": "article",
                "sort": [
                    10
                ]
            }
        ],
        "max_score": 0.13424811,
        "total": 1
    },
    "timed_out": false,
    "took": 1
}
```

## 搜索超时参数timeout

一个查询最多执行多长时间，最小单位是s

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:elasticsearch&timeout=1s' | python -msimplejson.tool
```

```
{
    "_shards": {
        "failed": 0,
        "successful": 5,
        "total": 5
    },
    "hits": {
        "hits": [
            {
                "_id": "1",
                "_index": "blog",
                "_score": 0.13424811,
                "_source": {
                    "content": "Version 1.0 released today!",
                    "id": "1",
                    "priority": 10,
                    "tags": [
                        "announce",
                        "elasticsearch",
                        "release"
                    ],
                    "title": "New version of Elasticsearch released!"
                },
                "_type": "article"
            }
        ],
        "max_score": 0.13424811,
        "total": 1
    },
    "timed_out": false,
    "took": 2
}
```

## 返回结果窗口参数size和from

返回所有匹配结果中得哪一部分

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:elasticsearch&size=1&from=0' | python -msimplejson.tool
```

```
{
    "_shards": {
        "failed": 0,
        "successful": 5,
        "total": 5
    },
    "hits": {
        "hits": [
            {
                "_id": "1",
                "_index": "blog",
                "_score": 0.13424811,
                "_source": {
                    "content": "Version 1.0 released today!",
                    "id": "1",
                    "priority": 10,
                    "tags": [
                        "announce",
                        "elasticsearch",
                        "release"
                    ],
                    "title": "New version of Elasticsearch released!"
                },
                "_type": "article"
            }
        ],
        "max_score": 0.13424811,
        "total": 1
    },
    "timed_out": false,
    "took": 1
}
```

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:elasticsearch&size=1&from=1' | python -msimplejson.tool
```

## 搜索类型参数search_type

取值为dfs_query_then_fetch, dfs_query_and_fetch, query_then_fetch, query_and_fetch, count, scan

默认值为query_then_fetch

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:elasticsearch&search_type=scan' | python -msimplejson.tool
```

```
{
    "error": "SearchPhaseExecutionException[Failed to execute phase [init_scan], all shards failed; shardFailures {[yqUAjwGRQR-RYFjPTSF7kQ][blog][0]: ElasticsearchException[Scroll must be provided when scanning...]}{[yqUAjwGRQR-RYFjPTSF7kQ][blog][1]: ElasticsearchException[Scroll must be provided when scanning...]}{[yqUAjwGRQR-RYFjPTSF7kQ][blog][2]: ElasticsearchException[Scroll must be provided when scanning...]}{[yqUAjwGRQR-RYFjPTSF7kQ][blog][3]: ElasticsearchException[Scroll must be provided when scanning...]}{[yqUAjwGRQR-RYFjPTSF7kQ][blog][4]: ElasticsearchException[Scroll must be provided when scanning...]}]",
    "status": 500
}
```

## 扩展的词条全部小写控制参数lowercase_expanded_terms

默认值为true

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:Elastic*&lowercase_expanded_terms=true' | python -msimplejson.tool
```

```
{
    "_shards": {
        "failed": 0,
        "successful": 5,
        "total": 5
    },
    "hits": {
        "hits": [
            {
                "_id": "1",
                "_index": "blog",
                "_score": 1.0,
                "_source": {
                    "content": "Version 1.0 released today!",
                    "id": "1",
                    "priority": 10,
                    "tags": [
                        "announce",
                        "elasticsearch",
                        "release"
                    ],
                    "title": "New version of Elasticsearch released!"
                },
                "_type": "article"
            }
        ],
        "max_score": 1.0,
        "total": 1
    },
    "timed_out": false,
    "took": 2
}
```

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:Elastic*&lowercase_expanded_terms=false' | python -msimplejson.tool
```

```
{
    "_shards": {
        "failed": 0,
        "successful": 5,
        "total": 5
    },
    "hits": {
        "hits": [],
        "max_score": null,
        "total": 0
    },
    "timed_out": false,
    "took": 2
}
```

## 分析通配符和前缀

默认情况：通配符和前缀不分析

```
curl -XGET '127.0.0.1:9200/blog/_search?pretty&q=title:Elastic*&analyze_wildcard=true' | python -msimplejson.tool
```

