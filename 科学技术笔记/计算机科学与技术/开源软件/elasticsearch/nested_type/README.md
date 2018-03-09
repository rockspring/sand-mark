curl -XPOST 'http://127.0.0.1:9200/my_index/blogpost/1' -d @blogpost.json

curl -XGET 'http://127.0.0.1:9200/_search' -d @_search.json


curl -XPUT 'http://127.0.0.1:9200/my_index/blogpost/_mappings' -d @blogpost_mapping.json

curl -XDELETE 'http://127.0.0.1:9200/my_index/blogpost/'


curl -XGET 'http://127.0.0.1:9200/_search' -d @blogpost_nested.json

