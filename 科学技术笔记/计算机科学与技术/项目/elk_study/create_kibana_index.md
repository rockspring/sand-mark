curl -XPUT 'http://localhost:9200/.kibana/' -d '{
    "settings" : {
        "index" : {
            "index.mapper.dynamic": true
        }
    }
}'