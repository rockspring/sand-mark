# 1 solr core状态接口

action='STATUS'

## 获取所有core的状态

### curl请求

```
curl 'http://localhost:8983/solr/admin/cores' \
--data-urlencode wt='json' --data-urlencode action='STATUS' | python -mjson.tool
```

### 请求结果
```
{
    "defaultCoreName": "collection1",
    "initFailures": {},
    "responseHeader": {
        "QTime": 11,
        "status": 0
    },
    "status": {
        "collection1": {
            "config": "solrconfig.xml",
            "dataDir": "/private/tmp/solr-4.10.3/example/solr/collection1/data/",
            "index": {
                "current": true,
                "deletedDocs": 0,
                "directory": "org.apache.lucene.store.NRTCachingDirectory:NRTCachingDirectory(MMapDirectory@/private/tmp/solr-4.10.3/example/solr/collection1/data/index lockFactory=NativeFSLockFactory@/private/tmp/solr-4.10.3/example/solr/collection1/data/index; maxCacheMB=48.0 maxMergeSizeMB=4.0)",
                "hasDeletions": false,
                "indexHeapUsageBytes": 0,
                "maxDoc": 0,
                "numDocs": 0,
                "segmentCount": 0,
                "size": "89 bytes",
                "sizeInBytes": 89,
                "userData": {},
                "version": 1
            },
            "instanceDir": "/private/tmp/solr-4.10.3/example/solr/collection1/",
            "isDefaultCore": true,
            "name": "collection1",
            "schema": "schema.xml",
            "startTime": "2015-02-03T13:53:14.268Z",
            "uptime": 137759
        }
    }
}
```


## 获取指定core的状态，通过参数core=collection1

### curl请求

```
curl 'http://localhost:8983/solr/admin/cores' \
--data-urlencode wt='json' --data-urlencode core='collection1' --data-urlencode action='STATUS' | python -mjson.tool
```

### curl请求结果
```
{
    "initFailures": {},
    "responseHeader": {
        "QTime": 5,
        "status": 0
    },
    "status": {
        "collection1": {
            "config": "solrconfig.xml",
            "dataDir": "/private/tmp/solr-4.10.3/example/solr/collection1/data/",
            "index": {
                "current": true,
                "deletedDocs": 0,
                "directory": "org.apache.lucene.store.NRTCachingDirectory:NRTCachingDirectory(MMapDirectory@/private/tmp/solr-4.10.3/example/solr/collection1/data/index lockFactory=NativeFSLockFactory@/private/tmp/solr-4.10.3/example/solr/collection1/data/index; maxCacheMB=48.0 maxMergeSizeMB=4.0)",
                "hasDeletions": false,
                "indexHeapUsageBytes": 0,
                "maxDoc": 0,
                "numDocs": 0,
                "segmentCount": 0,
                "size": "89 bytes",
                "sizeInBytes": 89,
                "userData": {},
                "version": 1
            },
            "instanceDir": "/private/tmp/solr-4.10.3/example/solr/collection1/",
            "isDefaultCore": true,
            "name": "collection1",
            "schema": "schema.xml",
            "startTime": "2015-02-03T13:53:14.268Z",
            "uptime": 349653
        }
    }
}
```

# 2创建solr core并注册

前提条件：

instanceDir/solrconfig.xml/schema.xml已经存在


```
curl 'http://127.0.0.1:8983/solr/admin/cores' \
--data-urlencode wt='json' \
--data-urlencode action='CREATE' \
--data-urlencode name='coreX' \
--data-urlencode instanceDir='/tmp/solr_core_create' \
--data-urlencode config='/tmp/solr_core_create/conf/solrconfig.xml' \
--data-urlencode schema='/tmp/solr_core_create/conf/schema.xml' \
--data-urlencode dataDir='/tmp/solr_core_create/data' \
--data-urlencode persist='true' \
 | python -mjson.tool
```

```
{
    "core": "coreX",
    "responseHeader": {
        "QTime": 10875,
        "status": 0
    }
}
```

# 3 重载如solr core

使用新的配置重新在一个solr core，替换现有的solr core，载入过程中，现有的solr core继续接收请求

载入新的solr core才使用重用技术，SolrIndexWriter对象重用，因此indexConfig、dataDir配置的改动不能生效

```
curl 'http://127.0.0.1:8983/solr/admin/cores' \
--data-urlencode wt='json' \
--data-urlencode action='RELOAD' \
--data-urlencode core='collection1' \
 | python -mjson.tool
```

```
{
    "responseHeader": {
        "QTime": 6331,
        "status": 0
    }
}
```

# 4 重命名solr core

```
curl 'http://127.0.0.1:8983/solr/admin/cores' \
--data-urlencode wt='json' \
--data-urlencode action='RENAME' \
--data-urlencode core='coreX' \
--data-urlencode other='collection1' \
 | python -mjson.tool
```

将coreX重命名为collection1

```
{
    "responseHeader": {
        "QTime": 51,
        "status": 0
    }
}
```

# 5 交换solr core

将一个solr core的名字映射到另一个solr core

```
curl 'http://127.0.0.1:8983/solr/admin/cores' \
--data-urlencode wt='json' \
--data-urlencode action='SWAP' \
--data-urlencode core='coreX' \
--data-urlencode other='collection1' \
 | python -mjson.tool
```

coreX指向collection1

```
{
    "responseHeader": {
        "QTime": 7,
        "status": 0
    }
}
```

# 6 卸载solr core

```
curl 'http://127.0.0.1:8983/solr/admin/cores' \
--data-urlencode wt='json' \
--data-urlencode action='UNLOAD' \
--data-urlencode core='coreX' \
--data-urlencode deleteIndex='true' \
--data-urlencode deleteDataDir='true' \
--data-urlencode deleteInstanceDir='true' \
 | python -mjson.tool
```

```
{
    "responseHeader": {
        "QTime": 108,
        "status": 0
    }
}
```

# 7 合并索引

前提条件，先创建两个solr core，分别为coreX、coreY
```
mkdir -p /tmp/coreX/conf

cp -r /tmp/solr-4.10.3/example/solr/collection1/conf/ /tmp/coreX/conf/

curl 'http://127.0.0.1:8983/solr/admin/cores' \
--data-urlencode wt='json' \
--data-urlencode action='CREATE' \
--data-urlencode name='coreX' \
--data-urlencode instanceDir='/tmp/coreX' \
--data-urlencode config='/tmp/coreX/conf/solrconfig.xml' \
--data-urlencode schema='/tmp/coreX/conf/schema.xml' \
--data-urlencode dataDir='/tmp/coreX/data' \
--data-urlencode persist='true' \
 | python -mjson.tool

mkdir -p /tmp/coreY/conf

cp -r /tmp/solr-4.10.3/example/solr/collection1/conf/ /tmp/coreY/conf/

curl 'http://127.0.0.1:8983/solr/admin/cores' \
--data-urlencode wt='json' \
--data-urlencode action='CREATE' \
--data-urlencode name='coreY' \
--data-urlencode instanceDir='/tmp/coreY' \
--data-urlencode config='/tmp/coreY/conf/solrconfig.xml' \
--data-urlencode schema='/tmp/coreY/conf/schema.xml' \
--data-urlencode dataDir='/tmp/coreY/data' \
--data-urlencode persist='true' \
 | python -mjson.tool
```

将coreX、coreY合并到collection1，通过指定索引目录实现

```
curl 'http://127.0.0.1:8983/solr/admin/cores' \
--data-urlencode wt='json' \
--data-urlencode action='mergeindexes' \
--data-urlencode core='collection1' \
--data-urlencode indexDir='/tmp/coreX/data/index' \
--data-urlencode indexDir='/tmp/coreY/data/index' \
 | python -mjson.tool
```

```
{
    "responseHeader": {
        "QTime": 2,
        "status": 0
    }
}
```

将coreX、coreY合并到collection1，通过solr core的名称指定要合并的solr core
```
curl 'http://127.0.0.1:8983/solr/admin/cores' \
--data-urlencode wt='json' \
--data-urlencode action='mergeindexes' \
--data-urlencode core='collection1' \
--data-urlencode srcCore='coreX' \
--data-urlencode srcCore='coreY' \
 | python -mjson.tool
```

```
{
    "responseHeader": {
        "QTime": 2,
        "status": 0
    }
}
```

所有的solr core必须已经存在

通过Lucene自带的工具合并

```
java -cp /path/to/lucene-core-VERSION.jar:/path/to/lucene-misc-VERSION.jar org.apache.lucene.misc.IndexMergeTool /path/to/newindex /path/to/index1 /path/to/index2
```

# 8 分裂索引

指定分裂后的索引存放路径，不能是已有solr core的索引目录

```
curl 'http://127.0.0.1:8983/solr/admin/cores' \
--data-urlencode wt='json' \
--data-urlencode action='SPLIT' \
--data-urlencode core='collection1' \
--data-urlencode path='/tmp/coreX/data/index1' \
--data-urlencode path='/tmp/coreY/data/index1' \
 | python -mjson.tool
```

```
{
    "responseHeader": {
        "QTime": 2,
        "status": 0
    }
}
```

将coreX、coreY合并到collection1，通过solr core的名称指定分裂后的索引存放solr core
```
curl 'http://127.0.0.1:8983/solr/admin/cores' \
--data-urlencode wt='json' \
--data-urlencode action='SPLIT' \
--data-urlencode core='collection1' \
--data-urlencode targetCore='coreX' \
--data-urlencode targetCore='coreY' \
 | python -mjson.tool
```

```
{
    "responseHeader": {
        "QTime": 2,
        "status": 0
    }
}
```


