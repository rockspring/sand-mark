方法1，自动创建索引结构
```
curl -XPUT http://localhost:9200/blog/article/1 -d '
{
  "title": "New version of Elasticsearch released!",
  "content": "...",
  "tags": [
    "announce",
    "elasticsearch",
    "release"
  ]
}' | python -msimplejson.tool
```

```
{
    "_id": "1",
    "_index": "blog",
    "_type": "article",
    "_version": 1,
    "created": true
}
```

方法2，使用默认参数手动创建索引

```
curl -XPUT http://localhost:9200/blog/ | python -msimplejson.tool
```

创建成功的返回值

```
{
    "acknowledged": true
}
```

方法3
```
curl -XPUT http://localhost:9200/blog/ -d '
{
    "settings" : {
        "number_of_shards" : 1,
        "number_of_replicas" : 2
    }
}' | python -msimplejson.tool
```

如果索引已经存在，返回如下错误

```
{
    "error": "IndexAlreadyExistsException[[blog] already exists]",
    "status": 400
}
```

禁掉自动创建索引结构的功能

action.auto_create_index: false

如果往不存在的索引中创建文档，会返回如下错误

```
curl -XPUT http://localhost:9200/blog/article/1 -d '
{
  "title": "New version of Elasticsearch released!",
  "content": "...",
  "tags": [
    "announce",
    "elasticsearch",
    "release"
  ]
}' | python -msimplejson.tool
```

```
{
    "error": "IndexMissingException[[blog] missing]",
    "status": 404
}
```

只禁掉部分名称的索引结构创建

action.auto_create_index: -an*,+a*,-*

规则的先后顺序是有关系的

1 尝试自动创建名称为blog的索引

```
curl -XPUT http://localhost:9200/blog/article/1 -d '
{
  "title": "New version of Elasticsearch released!",
  "content": "...",
  "tags": [
    "announce",
    "elasticsearch",
    "release"
  ]
}' | python -msimplejson.tool
```

```
{
    "error": "IndexMissingException[[blog] missing]",
    "status": 404
}
```

2 尝试自动创建名称为anblog的索引

```
curl -XPUT http://localhost:9200/anblog/article/1 -d '
{
  "title": "New version of Elasticsearch released!",
  "content": "...",
  "tags": [
    "announce",
    "elasticsearch",
    "release"
  ]
}' | python -msimplejson.tool
```

```
{
    "error": "IndexMissingException[[anblog] missing]",
    "status": 404
}
```

3 尝试自动创建名称为ablog的索引

```
curl -XPUT http://localhost:9200/ablog/article/1 -d '
{
  "title": "New version of Elasticsearch released!",
  "content": "...",
  "tags": [
    "announce",
    "elasticsearch",
    "release"
  ]
}' | python -msimplejson.tool
```

```
{
    "_id": "1",
    "_index": "ablog",
    "_type": "article",
    "_version": 1,
    "created": true
}
```

```
curl -XDELETE http://localhost:9200/blog/ | python -msimplejson.tool
```

```
curl -XPOST 'http://localhost:9200/posts' -d '
{
  "mappings": {
    "post": {
      "properties": {
        "id": {
          "type": "long",
          "store": "yes",
          "precision_step": "0"
        },
        "name": {
          "type": "string",
          "store": "yes",
          "index": "analyzed"
        },
        "contents": {
          "type": "string",
          "store": "no",
          "index": "analyzed"
        },
        "votes": {
          "type": "integer",
          "doc_values_format": "memory"
        }
      }
    }
  }
}' | python -msimplejson.tool
```

```
{
    "error": "MapperParsingException[mapping [post]]; nested: IllegalArgumentException[precisionStep must be >= 1 (got 0)]; ",
    "status": 400
}
```

doc_values_format的支持，当前版本只支持default类型

```
curl -XPOST 'http://localhost:9200/posts' -d '
{
  "mappings": {
    "post": {
      "properties": {
        "id": {
          "type": "long",
          "store": "yes",
          "precision_step": "1"
        },
        "name": {
          "type": "string",
          "store": "yes",
          "index": "analyzed"
        },
        "contents": {
          "type": "string",
          "store": "no",
          "index": "analyzed"
        },
        "votes": {
          "type": "integer",
          "doc_values_format": "memory"
        }
      }
    }
  }
}' | python -msimplejson.tool
```

```
{
    "error": "MapperParsingException[mapping [post]]; nested: ElasticsearchIllegalArgumentException[failed to find doc_values_format [memory]]; ",
    "status": 400
}
```

```
curl -XPOST 'http://localhost:9200/posts' -d '
{
  "mappings": {
    "post": {
      "properties": {
        "id": {
          "type": "long",
          "store": "yes",
          "precision_step": "1"
        },
        "name": {
          "type": "string",
          "store": "yes",
          "index": "analyzed"
        },
        "contents": {
          "type": "string",
          "store": "no",
          "index": "analyzed"
        },
        "votes": {
          "type": "integer",
          "doc_values_format": "default"
        }
      }
    }
  }
}' | python -msimplejson.tool
```

```
{
    "acknowledged": true
}
```


捆绑请求

第一行描述操作，第二行描述数据

```
curl -XPOST 'localhost:9200/_bulk?pretty' -d '
{ "index": { "_index": "addr", "_type": "contact", "_id": 1 }}
{ "name": "Fyodor Dostoevsky", "country": "RU" }
{ "create": { "_index": "addr", "_type": "contact", "_id": 2 }}
{ "name": "Erich Maria Remarque", "country": "DE" }
{ "create": { "_index": "addr", "_type": "contact", "_id": 2 }}
{ "name": "Joseph Heller", "country": "US" }
{ "delete": { "_index": "addr", "_type": "contact", "_id": 4 }}
{ "delete": { "_index": "addr", "_type": "contact", "_id": 1 }}'  | python -msimplejson.tool
```

```
{
    "errors": true,
    "items": [
        {
            "index": {
                "_id": "1",
                "_index": "addr",
                "_type": "contact",
                "_version": 1,
                "status": 201
            }
        },
        {
            "create": {
                "_id": "2",
                "_index": "addr",
                "_type": "contact",
                "_version": 1,
                "status": 201
            }
        },
        {
            "create": {
                "_id": "2",
                "_index": "addr",
                "_type": "contact",
                "error": "DocumentAlreadyExistsException[[addr][3] [contact][2]: document already exists]",
                "status": 409
            }
        },
        {
            "delete": {
                "_id": "4",
                "_index": "addr",
                "_type": "contact",
                "_version": 1,
                "found": false,
                "status": 404
            }
        }
    ],
    "took": 711
}
```


每一行描述一个JSON对象，不能换行

```
curl -XPOST 'localhost:9200/_bulk?pretty' -d '
{ "index": { "_index": "addr", "_type": "contact", "_id": 1
 }}
{ "name": "Fyodor Dostoevsky", "country": "RU" }
{ "create": { "_index": "addr", "_type": "contact", "_id": 2 }}
{ "name": "Erich Maria Remarque", "country": "DE" }
{ "create": { "_index": "addr", "_type": "contact", "_id": 2 }}
{ "name": "Joseph Heller", "country": "US" }
{ "delete": { "_index": "addr", "_type": "contact", "_id": 4 }}
{ "delete": { "_index": "addr", "_type": "contact", "_id": 1 }}'  | python -msimplejson.tool
```

```
{
    "error": "JsonParseException[Unexpected end-of-input: expected close marker for OBJECT (from [Source: [B@56e9566e; line: 1, column: 2])\n at [Source: [B@56e9566e; line: 1, column: 180]]",
    "status": 500
}
```


