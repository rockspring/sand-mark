
[http://localhost:8983/solr/admin/cores?action=RENAME&core=collection1&other=core0](http://localhost:8983/solr/admin/cores?action=RENAME&core=collection1&other=core0)

core.properties文件内容变为如下内容

```
#Written by CorePropertiesLocator
#Sun Jan 25 12:13:37 CST 2015
name=core0
coreNodeName=core_node1
```

http://localhost:8983/solr/admin/cores?action=RELOAD&core=core0


http://localhost:8983/solr/admin/collections?action=CREATEALIAS&name=name&collections=collection1

http://localhost:8984/solr/admin/collections?action=CREATEALIAS&name=name&collections=collection1
