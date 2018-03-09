http://10.20.3.9:7917/solr/admin/collections?collection=collection1&shard=shard1&action=SPLITSHARD

http://localhost:8983/solr/admin/collections?collection=collection1&shard=shard1&action=SPLITSHARD


java -Dbootstrap_confdir=./solr/collection1/conf -Dcollection.configName=myconf -DzkRun -jar start.jar


curl 'http://10.20.3.9:7916/solr/admin/cores?action=CREATE&name=collection2&collection=collection2'


curl 'http://10.20.3.9:7916/solr/admin/cores?action=CREATE&name=myconf&collection=myconf'


curl 'http://10.20.3.9:7916/solr/admin/collections?collection=myconf&shard=shard1&action=SPLITSHARD'


curl 'http://10.20.3.9:7916/solr/admin/collections?action=DELETE&name=myconf'


curl 'http://10.20.3.9:7916/solr/admin/cores?action=CREATE&name=myconf&collection=myconf&numShards=2&replicationFactor=1&collection.configName=myconf&createNodeSet=10.20.3.9:7916_solr&maxShardsPerNode=2'

curl 'http://10.20.3.9:7916/solr/admin/cores?action=CREATE&name=myconf&collection=myconf&numShards=2&replicationFactor=2&collection.configName=myconf&maxShardsPerNode=1'

curl 'http://10.20.3.9:7916/solr/admin/collections?collection=myconf&shard=shard1_0&action=SPLITSHARD'


curl 'http://10.20.3.9:7890/solr/admin/cores?action=CREATE&name=myconf&collection=myconf&numShards=2&replicationFactor=1&collection.configName=myconf&createNodeSet=10.20.3.9:7890_solr&maxShardsPerNode=2'


curl 'http://10.20.3.9:7916/solr/admin/collections?collection=myconf&shard=shard2&action=SPLITSHARD'



curl 'http://10.20.3.9:7890/solr/admin/collections?collection=collection1&shard=shard1&action=SPLITSHARD&wt=json' | python -msimplejson.tool

```
{
    "responseHeader": {
        "QTime": 5399,
        "status": 0
    },
    "success": {
        "": {
            "responseHeader": {
                "QTime": 1000,
                "status": 0
            }
        },
        "http://10.20.3.9:7890/solr/collection1/": {
            "responseHeader": {
                "QTime": 59,
                "status": 0
            }
        }
    }
}
```

curl 'http://10.20.3.9:7916/solr/admin/collections?collection=collection1&shard=shard1&action=SPLITSHARD&wt=json' | python -msimplejson.tool

curl 'http://10.20.3.9:7916/solr/admin/collections?action=DELETE&name=collection1&wt=json' | python -msimplejson.tool

```
{
    "responseHeader": {
        "QTime": 601,
        "status": 0
    },
    "success": {
        "10.20.3.9:7890_solr": {
            "responseHeader": {
                "QTime": 104,
                "status": 0
            }
        },
        "10.20.3.9:7916_solr": {
            "responseHeader": {
                "QTime": 96,
                "status": 0
            }
        }
    }
}
```


curl 'http://10.20.3.9:7919/solr/admin/collections?collection=collection1&shard=shard1&action=SPLITSHARD&wt=json' | python -msimplejson.tool


```
{
    "responseHeader": {
        "QTime": 14614,
        "status": 0
    },
    "success": {
        "": {
            "responseHeader": {
                "QTime": 2001,
                "status": 0
            }
        },
        "http://10.20.3.9:7919/solr/collection1/": {
            "responseHeader": {
                "QTime": 114,
                "status": 0
            }
        }
    }
}
```

curl 'http://10.20.3.9:7916/solr/admin/collections?action=DELETE&name=collection1_shard1_0_replica1&wt=json' | python -msimplejson.tool
