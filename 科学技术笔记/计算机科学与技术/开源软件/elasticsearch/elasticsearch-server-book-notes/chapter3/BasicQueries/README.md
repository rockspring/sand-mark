# 11 模糊匹配查询

`fuzzy_like_this`

查找所有与提供的文本相似的文档

```
{
  "query": {
    "fuzzy_like_this": {
      "fields": [
        "title",
        "otitle"
      ],
      "like_text": "crime punishment"
    }
  }
}

curl -XGET 'localhost:9200/library/book/_search?pretty=true' -d '
{
  "query": {
    "fuzzy_like_this": {
      "fields": [
        "title",
        "otitle"
      ],
      "like_text": "crime punishment"
    }
  }
}'
```