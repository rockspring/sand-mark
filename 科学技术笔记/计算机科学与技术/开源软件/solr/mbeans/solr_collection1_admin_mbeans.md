# 获取系统组件的信息


curl 'http://10.10.3.135:7803/solr/collection1/admin/mbeans?stats=true&wt=json&_=1422674046748' | python -msimplejson.tool