# nested object

curl -XPUT 'http://127.0.0.1:9200/nested_object/'

curl -XPUT 'http://127.0.0.1:9200/nested_object/_mapping/type1' -d @nested_type_mapping.json  | python -mjson.tool

curl -XPOST 'http://127.0.0.1:9200/nested_object/type1' -d @nested_type_data.json  | python -mjson.tool


curl -XDELETE 'http://127.0.0.1:9200/nested_object/_mapping/type1' | python -mjson.tool

curl -XPUT 'http://127.0.0.1:9200/nested_object/_mapping/type2' -d @nested_type_mapping2.json  | python -mjson.tool

curl -XDELETE 'http://127.0.0.1:9200/nested_object/_mapping/type2' | python -mjson.tool

curl -XPOST 'http://127.0.0.1:9200/nested_object/type2' -d @nested_type_data.json  | python -mjson.tool

curl -XGET 'http://127.0.0.1:9200/nested_object/type2/_search?pretty=true' -d @nested_type_query_dsl.json | python -mjson.tool

curl -XGET 'http://127.0.0.1:9200/nested_object/type2/_search?pretty=true' -d @nested_type_query2_dsl.json | python -mjson.tool