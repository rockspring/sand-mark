mkdir -p /tmp/docker-mongo


zlq@Apples-MacBook-Pro-2:~$ boot2docker start
Waiting for VM and Docker daemon to start...
.........o
Started.
Writing /Users/zlq/.boot2docker/certs/boot2docker-vm/ca.pem
Writing /Users/zlq/.boot2docker/certs/boot2docker-vm/cert.pem
Writing /Users/zlq/.boot2docker/certs/boot2docker-vm/key.pem

To connect the Docker client to the Docker daemon, please set:
    export DOCKER_HOST=tcp://192.168.59.103:2376
    export DOCKER_CERT_PATH=/Users/zlq/.boot2docker/certs/boot2docker-vm
    export DOCKER_TLS_VERIFY=1

zlq@Apples-MacBook-Pro-2:~$ docker run -v /tmp/docker/mongodb:/data:rw --name mongodb -p 27017:27017 -d mongo --smallfiles

zlq@Apples-MacBook-Pro-2:~$ docker run -v /home:/data:rw --name mongodb -p 27017:27017 -d mongo --smallfiles

zlq@Apples-MacBook-Pro-2:~$ docker run -v /Users/zlq/Tmp:/data:rw --name mongodb -p 27017:27017 -d mongo --smallfiles

docker run -v /data1/data/docker/mongodb/27017:/data --name mongodb_27017 -p 27017:27017 -d mongo

查看mongo的日志

docker logs mongodb


VBoxManage sharedfolder add "boot2docker-vm" --name "Users" --hostpath /Users

VBoxManage sharedfolder remove "boot2docker-vm" --name "Users"

boot2docker start


https://docker.cn/docker/mongo


mongod --dbpath /data1/data/mongodb/27017/db

mongod --dbpath /data1/data/mongodb/27017/db --fork --logpath=/data1/logs/mongodb/27017/mongodb.log



./mongod --replSet rs0

./mongo

rs.initiate()

db.oplog.rs.find()


```
{ "ts" : Timestamp(1421065473, 1), "h" : NumberLong(0), "v" : 2, "op" : "n", "ns" : "", "o" : { "msg" : "initiating set" } }
{ "ts" : Timestamp(1421066650, 1), "h" : NumberLong("-6922073060090576879"), "v" : 2, "op" : "i", "ns" : "search_community.community", "o" : { "_id" : ObjectId("54b3c19a5b662af5f32a29d3"), "id" : 1, "comm_id" : 1, "city_id" : 11, "area_code" : "000100070077", "name" : "莲园路488弄", "default_name" : "莲园路488弄", "address" : "莲园路488弄", "located" : true, "soso_location" : "31.18562174,121.55784168", "baidu_location" : "31.19197795355,121.56423779068", "who_add" : 0, "complete" : true, "enabled" : 1, "locked" : 1, "is_merge" : 1, "distance_error" : 12, "update_time" : ISODate("2015-01-09T15:11:21Z"), "index_update_time" : ISODate("2015-01-12T20:44:10.402Z") } }



{
  "ts": Timestamp(1421066650, 1),
  "h": NumberLong("-6922073060090576879"),
  "v": 2,
  "op": "i",
  "ns": "search_community.community",
  "o": {
    "_id": ObjectId("54b3c19a5b662af5f32a29d3"),
    "id": 1,
    "comm_id": 1,
    "city_id": 11,
    "area_code": "000100070077",
    "name": "莲园路488弄",
    "default_name": "莲园路488弄",
    "address": "莲园路488弄",
    "located": true,
    "soso_location": "31.18562174,121.55784168",
    "baidu_location": "31.19197795355,121.56423779068",
    "who_add": 0,
    "complete": true,
    "enabled": 1,
    "locked": 1,
    "is_merge": 1,
    "distance_error": 12,
    "update_time": ISODate("2015-01-09T15:11:21Z"),
    "index_update_time": ISODate("2015-01-12T20:44:10.402Z")
  }
}
```




curl -XPUT "localhost:9200/_river/mongdb/_meta" -d '
  {
    "type": "mongodb",
    "mongodb": { 
      "servers":
      [
        { "host": "127.0.0.1", "port": "27017" }
      ],
      "options": { 
        "skip_initial_import" : false
      },
      "db": "mydb", 
      "collection": "solrlog"
    }, 
    "index": { 
      "name": "solrlog_index",
      "type": "solrlog"
    }
  }'



http://localhost:9200/solrlog_index/_search?q=*:*










curl -X POST "http://localhost:9200/solrlog_index/_search?pretty=true" -d '
  {
    "query" : { "query_string" : {"query" : "*"} },
    "facets" : {
      "params" : { "terms" : {"field" : "params"} }
    }
  }
'



curl -X POST "http://localhost:9200/solrlog_index/_search?pretty=true" -d '
  {
    "query" : { "query_string" : {"query" : "qt=dismax"} },
    "facets" : {
      "params" : { "terms" : {"field" : "params"} }
    }
  }
'

curl -X POST "http://localhost:9200/solrlog_index/_search?pretty=true" -d '
  {
    "query" : { 
      "match" : {
          "action" : "select"
        } 
    },
    "facets" : {
      "params" : { "terms" : {"field" : "params"} }
    }
  }
'


curl -X POST "http://localhost:9200/solrlog_index/_search?pretty=true" -d '
{
    "query": {
      "match" : {
        "action" : "select"
      }
    }
}
'

curl -X POST "http://localhost:9200/solrlog_index/_search?pretty=true" -d '
{
    "query": {
      "prefix" : { "action" : "select" }
    }
}
'

