# DistributedUpdateProcessor

分布式更新处理器接收到请求是属于分布式更新请求中得某个阶段的请求

分布式请求有如下三个阶段

* NONE

这是客户端发送的更新请求

* TOLEADER

这是follower发送给leader的请求

* FROMLEADER

这是leader发送给follower的请求

如何判断这个请求处在哪个阶段？

* 请求URL里没参数update.distrib

请求处在NONE阶段，solr节点直接从客户端接收到的请求

* 请求URL里有一个参数update.distrib

update.distrib=TOLEADER，solr节点从follower节点接收到的请求

update.distrib=FROMLEADER，solr节点从leader节点接收到的请求


# 实验环境部署结构

2个solr节点，1个分片，2个副本


# solr请求类型

* deleteById

* deleteByQuery


# NONE阶段的请求处理流程

## 接收请求的节点为leader

## 接收请求的节点为follower

# TOLEADER阶段的请求处理流程

# FROMLEADER阶段的请求处理流程