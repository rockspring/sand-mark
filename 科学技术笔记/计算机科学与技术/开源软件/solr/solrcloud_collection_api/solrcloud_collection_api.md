# 1 给节点添加角色

http://localhost:8983/solr/admin/collections?action=ADDROLE&role=overseer&node=192.168.196.157:8983_solr

### curl请求

```
curl 'http://localhost:8983/solr/admin/collections' \
--data-urlencode wt='json' --data-urlencode action='ADDROLE' \
--data-urlencode role='overseer' --data-urlencode node='192.168.196.157:8983_solr' \
| python -mjson.tool
```

### 请求结果
```
{
    "responseHeader": {
        "QTime": 42,
        "status": 0
    }
}
```

OverseerCollectionProcessor.processRoleCommand方法处理这个API请求，启动独立的线程执行prioritizing任务


# [Overseer-93298547936198657-192.168.196.157:8983_solr-n_0000000000]线程

主函数OverseerCollectionProcessor.run()方法

由Overseer.start()方法创建并启动


Overseer.start()方法同时启动ClusterStateUpdater线程，线程名称为Thread-id


```
main-EventThread@2147 daemon, prio=5, in group 'main', status: 'RUNNING'
	  at org.apache.solr.cloud.OverseerCollectionProcessor.<init>(OverseerCollectionProcessor.java:159)
	  at org.apache.solr.cloud.Overseer.start(Overseer.java:1017)
	  at org.apache.solr.cloud.OverseerElectionContext.runLeaderProcess(ElectionContext.java:470)
	  at org.apache.solr.cloud.LeaderElector.runIamLeaderProcess(LeaderElector.java:164)
	  at org.apache.solr.cloud.LeaderElector.checkIfIamLeader(LeaderElector.java:108)
	  at org.apache.solr.cloud.LeaderElector.access$000(LeaderElector.java:55)
	  at org.apache.solr.cloud.LeaderElector$1.process(LeaderElector.java:137)
	  at org.apache.zookeeper.ClientCnxn$EventThread.processEvent(ClientCnxn.java:519)
	  at org.apache.zookeeper.ClientCnxn$EventThread.run(ClientCnxn.java:495)
```

# 创建一个索引集合

/admin/collections?action=CREATE&name= name &numShards= number &replicationFactor= number &maxShardsPerNode= number &createNodeSet= nodelist &collection.configName= configname

### curl请求

请求发送到leader节点

```
curl 'http://localhost:8983/solr/admin/collections' \
--data-urlencode wt='json' --data-urlencode action='CREATE' \
--data-urlencode name='collection2' \
--data-urlencode numShards=2 \
--data-urlencode replicationFactor='2' \
--data-urlencode maxShardsPerNode='2' \
--data-urlencode createNodeSet='192.168.2.4:8983_solr,192.168.2.4:8984_solr' \
--data-urlencode collection.configName='collection1' \
| python -mjson.tool
```

### 请求结果
```
{
    "responseHeader": {
        "QTime": 4146,
        "status": 0
    },
    "success": {
        "": {
            "core": "collection2_shard2_replica1",
            "responseHeader": {
                "QTime": 3992,
                "status": 0
            }
        }
    }
}
```

8983节点solr home目录结构

```
.
├── README.txt
├── bin
├── collection1
├── collection2_shard1_replica2
├── collection2_shard2_replica2
├── solr.xml
└── zoo.cfg
```

collection2_shard1_replica2核心描述符
```
#Written by CorePropertiesLocator
#Thu Feb 12 11:40:21 CST 2015
numShards=2
name=collection2_shard1_replica2
shard=shard1
collection=collection2
coreNodeName=core_node2
```

collection2_shard2_replica2核心描述符
```
#Written by CorePropertiesLocator
#Thu Feb 12 11:40:21 CST 2015
numShards=2
name=collection2_shard2_replica2
shard=shard2
collection=collection2
coreNodeName=core_node1
```

8984节点solr home目录结构

```
.
├── README.txt
├── bin
├── collection1
├── collection2_shard1_replica1
├── collection2_shard2_replica1
├── solr.xml
└── zoo.cfg
```

collection2_shard1_replica1核心描述符
```
#Written by CorePropertiesLocator
#Thu Feb 12 11:40:21 CST 2015
numShards=2
name=collection2_shard1_replica1
shard=shard1
collection=collection2
coreNodeName=core_node3
```

collection2_shard2_replica1核心描述符
```
#Written by CorePropertiesLocator
#Thu Feb 12 11:40:21 CST 2015
numShards=2
name=collection2_shard2_replica1
shard=shard2
collection=collection2
coreNodeName=core_node4
```

索引核心所在目录中是没有配置文件的，配置文件在zookeeper里面

请求发送到leader节点

```
curl 'http://localhost:8983/solr/admin/collections' \
--data-urlencode wt='json' --data-urlencode action='CREATE' \
--data-urlencode name='collection8' \
--data-urlencode router.name='implicit' \
--data-urlencode numShards=2 \
--data-urlencode shards='shardx,shardy' \
--data-urlencode replicationFactor=2 \
--data-urlencode maxShardsPerNode=2 \
--data-urlencode createNodeSet='192.168.196.37:8983_solr,192.168.196.37:8984_solr' \
--data-urlencode createNodeSet.shuffle=true \
--data-urlencode collection.configName='collection1' \
| python -mjson.tool
```

### 请求结果
```
{
    "responseHeader": {
        "QTime": 3661,
        "status": 0
    },
    "success": {
        "": {
            "core": "collection8_shardy_replica2",
            "responseHeader": {
                "QTime": 3522,
                "status": 0
            }
        }
    }
}
```

指定了router.name='implicit'时shards参数才生效，且shards指定的分片数量优先级比numShards参数高

```
curl 'http://localhost:8983/solr/admin/collections' \
--data-urlencode wt='json' --data-urlencode action='CREATE' \
--data-urlencode name='collection1' \
--data-urlencode router.name='implicit' \
--data-urlencode router.field='id' \
--data-urlencode numShards=2 \
--data-urlencode shards='shardx,shardy' \
--data-urlencode replicationFactor=2 \
--data-urlencode maxShardsPerNode=2 \
--data-urlencode createNodeSet='192.168.196.37:8983_solr,192.168.196.37:8984_solr' \
--data-urlencode createNodeSet.shuffle=true \
--data-urlencode collection.configName='collection1' \
| python -mjson.tool
```


# 重载索引集合

http://localhost:8983/solr/admin/collections?action=RELOAD&name=newCollection

### curl请求

请求发送到leader节点

```
curl 'http://localhost:8983/solr/admin/collections' \
--data-urlencode wt='json' --data-urlencode action='RELOAD' \
--data-urlencode name='collection1' \
| python -mjson.tool
```

### 请求结果
```
{
    "responseHeader": {
        "QTime": 1706,
        "status": 0
    },
    "success": {
        "192.168.196.37:8983_solr": {
            "responseHeader": {
                "QTime": 1454,
                "status": 0
            }
        },
        "192.168.196.37:8984_solr": {
            "responseHeader": {
                "QTime": 1493,
                "status": 0
            }
        }
    }
}
```

修改schema等配置，只要上传到zookeeper，可通过reload方式使其生效

# 创建索引集合别名，指向一组索引集合

http://localhost:8983/solr/admin/collections?action=CREATEALIAS&collections=collectionlist

### curl请求

请求发送到leader节点

```
curl 'http://localhost:8983/solr/admin/collections' \
--data-urlencode wt='json' --data-urlencode action='CREATEALIAS' \
--data-urlencode name='alias_test' \
--data-urlencode collections='collection1,collection2,collection3' \
| python -mjson.tool
```

### 请求结果
```
{
    "responseHeader": {
        "QTime": 117,
        "status": 0
    }
}
```

再创建一个alias

```
curl 'http://localhost:8983/solr/admin/collections' \
--data-urlencode wt='json' --data-urlencode action='CREATEALIAS' \
--data-urlencode name='alias_test2' \
--data-urlencode collections='collection1,collection2,collection3' \
| python -mjson.tool
```

alias.json

```
{"collection":{
    "alias_test2":"collection1,collection2,collection3",
    "alias_test":"collection1,collection2,collection3"}}
```

如何查询

http://localhost:8983/solr/collection2/select?collection=alias_test2&q=*%3A*&fq=my_id:1&wt=json&indent=true

# 删除索引集合别名

### curl请求

请求发送到leader节点

```
curl 'http://localhost:8983/solr/admin/collections' \
--data-urlencode wt='json' --data-urlencode action='DELETEALIAS' \
--data-urlencode name='alias_test' \
| python -mjson.tool
```

### 请求结果
```
{
    "responseHeader": {
        "QTime": 113,
        "status": 0
    }
}
```

# 删除一个索引集合

请求发送到leader节点

```
curl 'http://localhost:8983/solr/admin/collections' \
--data-urlencode wt='json' --data-urlencode action='DELETE' \
--data-urlencode name='collection1' \
| python -mjson.tool
```

### 请求结果
```
{
    "responseHeader": {
        "QTime": 581,
        "status": 0
    },
    "success": {
        "192.168.196.37:8983_solr": {
            "responseHeader": {
                "QTime": 112,
                "status": 0
            }
        },
        "192.168.196.37:8984_solr": {
            "responseHeader": {
                "QTime": 89,
                "status": 0
            }
        }
    }
}
```

# 删除一个索引集合的分片的一个副本

请求发送到leader节点

```
curl 'http://localhost:8983/solr/admin/collections' \
--data-urlencode wt='json' --data-urlencode action='DELETEREPLICA' \
--data-urlencode collection='collection2' \
--data-urlencode shard='shard1' \
--data-urlencode replica='core_node3' \
| python -mjson.tool
```

### 请求结果
```
{
    "responseHeader": {
        "QTime": 2589,
        "status": 0
    },
    "success": {
        "": {
            "responseHeader": {
                "QTime": 49,
                "status": 0
            }
        }
    }
}
```

# 编辑集群的属性（添加，修改，删除）

请求发送到leader节点

```
curl 'http://localhost:8983/solr/admin/collections' \
--data-urlencode wt='json' --data-urlencode action='CLUSTERPROP' \
--data-urlencode name='urlScheme' \
--data-urlencode val='http://' \
| python -mjson.tool
```

### 请求结果
```
{
    "responseHeader": {
        "QTime": 18,
        "status": 0
    }
}
```

clusterprops.json
```
{"urlScheme":"https://"}
```
