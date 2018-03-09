
curl -XPUT 'localhost:9200/my_index?pretty' -d@create_index_my_index.json

curl -XDELETE 'localhost:9200/my_index?pretty'


http://127.0.0.1:9200/_search?index=twitter
