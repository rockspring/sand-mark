# 1 创建一个索引

```
curl -XPOST 'localhost:9200/library'
```

# 2 创建一个mapping

```
curl -XPUT 'localhost:9200/library/book/_mapping' -d @mapping.json
```

# 3 保存文档

```
curl -s -XPOST 'localhost:9200/_bulk' --data-binary @documents.json
```

# 4 简单的查询

```
curl -XGET 'localhost:9200/library/book/_search?q=title:crime&pretty=true'

以上查询是一种成为query_string的query，改写成query DSL，如下所示

curl -XGET 'localhost:9200/library/book/_search?pretty=true' -d '{
  "query" : {
    "query_string" : { "query" : "title:crime" }
  }
￼}'

{
  "query": {
    "query_string": {"query": "title:crime"}
  }
}
```

# 5 分页与结果大小

`from`：从哪一篇文档开始返回结果，默认值为`0`
`size`：返回的最大文档数，默认值为`10`

```
{
  "from": 9,
  "size": 20,
  "query": {
    "query_string": {"query": "title:crime"}
  }
}

curl -XGET 'localhost:9200/library/book/_search?pretty=true' -d '{
  "from": 9,
  "size": 20,
  "query": {
    "query_string": {"query": "title:crime"}
  }
}
'
```

# 6 返回版本号

`version`：控制是否返回版本号，取值为`true`或`false`，默认为false

```
{
  "version": true,
  "query": {
    "query_string": {"query": "title:crime"}
  }
}

curl -XGET 'localhost:9200/library/book/_search?pretty=true' -d '{
  "version": true,
  "query": {
    "query_string": {"query": "title:crime"}
  }
}
'
```

# 7 限制最低分数

`min_score`：返回的文档中最低分数

```
{
  "min_score": 0.75,
  "query": {
    "query_string": {"query": "title:crime"}
  }
}

curl -XGET 'localhost:9200/library/book/_search?pretty=true' -d '{
  "min_score": 0.75,
  "query": {
    "query_string": {"query": "title:crime"}
  }
}
'
```

# 8 选择我们想要返回的字段

`fields`：我们想要返回的字段列表

```
{
  "fields": ["title", "year"],
  "query": {
    "query_string": {"query": "title:crime"}
  }
}

curl -XGET 'localhost:9200/library/book/_search?pretty=true' -d '{
  "fields": ["title", "year"],
  "query": {
    "query_string": {"query": "title:crime"}
  }
}
'
```

如果没有设置fields，如果_source字段可用，默认返回_source字段的内容

如果fields中得字段不是stored，如果_source字段可用，则从_source字段抽取fields中得字段的值

`*`为字段通配符，即返回所有stored字段

从性能角度看，返回_source字段的值比返回多个stored字段的值更优

## 8.1 部分字段

控制如何从_source字段加载需要的字段

`include`：需要的字段，支持通配符
`exclude`：不需要的字段，支持通配符

```
{
  "partial_fields": {
    "partial1": {
    "include": ["titl*"],
    "exclude": ["chara*"]
    }
  },
  "query": {
    "query_string": {"query": "title:crime"}
  }
}

curl -XGET 'localhost:9200/library/book/_search?pretty=true' -d '{
  "partial_fields": {
    "partial1": {
    "include": ["titl*"],
    "exclude": ["chara*"]
    }
  },
  "query": {
    "query_string": {"query": "title:crime"}
  }
}
'
```

# 9200 使用脚本字段

```
{
  "script_fields": {
    "correctYear": {
      "script": "doc['year'].value - 1800"
    }
  },
  "query": {
    "query_string": {"query": "title:crime"}
  }
}

curl -XGET 'localhost:9200/library/book/_search?pretty=true' -d '{
  "script_fields": {
    "correctYear": {
      "script": "doc['year'].value - 1800"
    }
  },
  "query": {
    "query_string": {"query": "title:crime"}
  }
}
'
```

doc保存了返回的结果，脚本执行速度快，但是内存消耗高

可以使用_source字段获取单个字段的值，节省内存使用

```
{
  "script_fields": {
    "correctYear": {
      "script": "_source.year - 1800"
    }
  },
  "query": {
    "query_string": {"query": "title:crime"}
  }
}

curl -XGET 'localhost:9200/library/book/_search?pretty=true' -d '{
  "script_fields": {
    "correctYear": {
      "script": "_source.year - 1800"
    }
  },
  "query": {
    "query_string": {"query": "title:crime"}
  }
}
'
```

## 9.1 往脚本字段传递参数

```
{
  "script_fields": {
    "correctYear": {
      "script": "_source.year - paramYear",
      "params": {
        "paramYear": 1800
      }
    }
  },
  "query": {
    "query_string": {"query": "title:crime"}
  }
}


curl -XGET 'localhost:9200/library/book/_search?pretty=true' -d '{
  "script_fields": {
    "correctYear": {
      "script": "_source.year - paramYear",
      "params": {
        "paramYear": 1800
      }
    }
  },
  "query": {
    "query_string": {"query": "title:crime"}
  }
}
'
```



