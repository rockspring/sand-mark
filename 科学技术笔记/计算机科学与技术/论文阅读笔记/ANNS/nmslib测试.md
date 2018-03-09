```
cmake -DCMAKE_BUILD_TYPE=Debug
make
```

然后用IDE打开，就是Debug版本

```
cmake -DCMAKE_BUILD_TYPE=Release
make
```

## 不进行索引优化

```
debug/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.100 --maxNumData 100 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.1 --maxNumQuery 1 --threadTestQty 1 --knn 10 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=2,searchMethod=0,skip_optimized_index=0 --queryTimeParams efSearch=400,algoType=hybrid,searchMethod=0 --cachePrefixGS glove --maxCacheGSRelativeQty 10 --outFilePrefix glove --appendToResFile 0 --saveIndex index.hnsw

debug/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.100 --maxNumData 100 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.1 --maxNumQuery 1 --threadTestQty 1 --knn 10 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=2,searchMethod=0,skip_optimized_index=0 --queryTimeParams efSearch=400,algoType=hybrid,searchMethod=0 --cachePrefixGS glove --maxCacheGSRelativeQty 10 --outFilePrefix glove --appendToResFile 0 --loadIndex /Users/zlq/Projects/oss/AI/swimmingsand-nmslib/similarity_search/index.hnsw
```

cachePrefixGS控制黄金标准结果文件

```
glove_ctrl.txt
glove_data.bin
```

outFilePrefix 控制结果文件

```
glove_K=10.dat
glove_K=10.rep
```

最终 searchMethod_ = 0，参数中设置的searchMethod是不起作用的，Hnsw<dist_t>::CreateIndex方法执行时候设置初值为0。

搜索方法 src/method/hnsw.cc::Hnsw<dist_t>::baseSearchAlgorithmV1Merge

距离函数 src/distcomp_lp.cc::similarity::L2NormSIMD

M_ = maxM_

maxM0_ = 2 * M_

mult_ = 1 / log(1.0 * M_)

## 进行了索引优化存储

搜索方法

如果向量维度是16的倍数，查询时使用如下查询方法

src/method/hnsw_distfunc_opt.cc::Hnsw<dist_t>::SearchL2CustomV1Merge

如果定义了SSE

Euclidean距离函数

如果向量维度不是16的倍数，查询时使用如下距离函数

```
src/method/hnsw_distfunc_opt.cc::similarity::L2SqrSIMD16Ext
```

向量维度是4的倍数，查询时使用如下距离

```
src/method/hnsw_distfunc_opt.cc::similarity::L2SqrSIMDExt
```


## 处理数据集

```
cat glove.42B.300d.txt | cut -d ' ' -f -1 | awk '{print NR-1, $1}' > glove.42B.300d.txt.id.name.txt

# 切分数据集
cat glove.42B.300d.txt | head -n 10000 > glove.42B.300d.txt.head10000.txt

cat glove.42B.300d.txt | tail -n 1907495 > glove.42B.300d.txt.tail1907495.txt

cat glove.42B.300d.txt.head10000.txt | cut -d ' ' -f 2- > glove.42B.300d.txt.head10000.txt.query.txt

cat glove.42B.300d.txt.tail1907495.txt  | cut -d ' ' -f 2- > glove.42B.300d.txt.tail1907495.txt.data.txt
```

release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_10K.txt --maxNumData 10000 --queryFile /Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_query1K.txt --maxNumQuery 10 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=0,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=8,post=2 --queryTimeParams efSearch=200,searchMethod=0,algoType=hybrid

release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_10K.txt --maxNumData 10000 --queryFile /Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_query1K.txt --maxNumQuery 10 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=1,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=8,post=2 --queryTimeParams efSearch=200,searchMethod=0,algoType=hybrid

nohup debug/experiment --spaceType l2 --distType double --dataFile /Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_10K.txt --maxNumData 10000 --queryFile /Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_query1K.txt --maxNumQuery 10 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=0,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=8,post=2 --queryTimeParams efSearch=200,searchMethod=0,algoType=hybrid &


## 缓存黄金标准结果

--cachePrefixGS final128_query1K

--maxCacheGSRelativeQty 100

nohup debug/experiment --spaceType l2 --distType double --dataFile /Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_10K.txt --maxNumData 10000 --queryFile /Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_query1K.txt --maxNumQuery 10 --cachePrefixGS final128_query1K --maxCacheGSRelativeQty 100 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=1,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=8,post=2 --queryTimeParams efSearch=200,searchMethod=0,algoType=hybrid &

## 生成黄金标准结果相关的文件

final128_query1K_ctrl.txt

```
Space:SpaceLp: p = 2 do we have a special implementation for this p? : 1
DataFile:/Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_10K.txt
DataFileQty:10000
QueryFile:/Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_query1K.txt
TestSetQty:0
RangeQty:0
KNNQty:1
QueryQty:10
TestSetId:0
ThreadTestQty:1
Note:k=100eps=0
SeqSearchTime:3783
GoldStandQty:10000
SeqSearchTime:3755
GoldStandQty:10000
SeqSearchTime:4951
GoldStandQty:10000
SeqSearchTime:5854
GoldStandQty:10000
SeqSearchTime:3862
GoldStandQty:10000
SeqSearchTime:3847
GoldStandQty:10000
SeqSearchTime:4005
GoldStandQty:10000
SeqSearchTime:3545
GoldStandQty:10000
SeqSearchTime:5290
GoldStandQty:10000
SeqSearchTime:4210
GoldStandQty:10000
```

每一个都是一对字段名和字段值
include/utils.h::similarity::ReadField

final128_query1K_data.bin

二进制文件，无法直接查看



final128_query1K_data.bin

第一个整数位knn的值


release/experiment --spaceType l2 --distType double --dataFile /Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_10K.txt --maxNumData 10000 --queryFile /Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_query1K.txt --maxNumQuery 10 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=1,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=8,post=2 --queryTimeParams efSearch=200,searchMethod=0,algoType=hybrid

2017-11-26 13:56:04 main.cc:486 (RunExper) [INFO] Data: MethodName  Recall  Recall@1    PrecisionOfApprox   RelPosError NumCloser   ClassAccuracy   QueryTime   DistComp    ImprEfficiency  ImprDistComp    Mem IndexTime   IndexLoadTime   IndexSaveTime   QueryPerSec IndexParams QueryTimeParams NumData
"hnsw"  1   1   1   1   0   0   0.2214  1540.4  2.6026  6.49182 4   0.925851    0   0   4490.35 "M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=1,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=8,post=2"  "efSearch=200,searchMethod=0,algoType=hybrid"   10000

"hnsw"  1   0   0   1   0   0   0.3252  1526.3  3.47594 6.55179 9   1.15492 0   1e-06   3064.66 "M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=1,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=8,post=2"  "efSearch=200,searchMethod=0,algoType=hybrid"   10000



/Users/zlq/Projects/data/glove.42B.300d.txt.100
/Users/zlq/Projects/data/glove.42B.300d.txt.1

release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.100 --maxNumData 100 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.1 --maxNumQuery 1 --threadTestQty 1 --knn 10 --method hnsw --createIndex M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=0,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=8,post=2 --queryTimeParams efSearch=200,searchMethod=0,algoType=hybrid

release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.1917495  --maxNumData 1917495 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.100 --maxNumQuery 1 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=0,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=8,post=2 --queryTimeParams efSearch=200,searchMethod=0,algoType=hybrid

cat glove.42B.300d.txt | cut -d ' ' -f 2- > glove.42B.300d.1917495

## 随机选取10000条数据

sort -R glove.42B.300d.txt | head -n 10000 glove.42B.300d.txt | cut -d ' ' -f 2- > glove.42B.300d.txt.random.10000

echo "MethodName    Recall  Recall@1    PrecisionOfApprox   RelPosError NumCloser   ClassAccuracy   QueryTime   DistComp    ImprEfficiency  ImprDistComp    Mem IndexTime   IndexLoadTime   IndexSaveTime   QueryPerSec IndexParam  QueryTimeParams   NumData" | sed 's/ \+/\n/g' > field_name.txt

echo ""hnsw"    1   1   1   1   0   0   387.703 0   7.08409 inf 2194    1469.15 0   3.8e-05 2.57742 "M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=0,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=8,post=2"  "efSearch=200,searchMethod=0,algoType=hybrid"   1917495"  | sed 's/ \+/\n/g' > field_value.txt

```
MethodName  hnsw
Recall  1
Recall@1    1
PrecisionOfApprox   1
RelPosError 1
NumCloser   0
ClassAccuracy   0
QueryTime   387.703
DistComp    0
ImprEfficiency  7.08409
ImprDistComp    inf
Mem 2194
IndexTime   1469.15
IndexLoadTime   0
IndexSaveTime   3.8e-05
QueryPerSec 2.57742
IndexParam  M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=0,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=8,post=2
QueryTimeParams efSearch=200,searchMethod=0,algoType=hybrid
NumData 1917495
```

# 使用SIMD指令计算距离、不使用为存储设计的内存格式

```
nohup release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.tail1907495.txt.data.txt --maxNumData 1907495 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.head10000.txt.query.txt --maxNumQuery 10000 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=2,searchMethod=0,skip_optimized_index=1 --queryTimeParams efSearch=200,algoType=hybrid,searchMethod=0 2>&1 1>test1.txt &

release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.tail1907495.txt.data.txt --maxNumData 1907495 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.head10000.txt.query.txt --maxNumQuery 10000 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=2,searchMethod=0,skip_optimized_index=1 --queryTimeParams efSearch=100,algoType=hybrid,searchMethod=0 --cachePrefixGS glove --maxCacheGSRelativeQty 10 2>&1 1>test1a.txt

release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.tail1907495.txt.data.txt --maxNumData 1907495 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.head10000.txt.query.txt --maxNumQuery 10000 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=2,searchMethod=0,skip_optimized_index=1 --queryTimeParams efSearch=200,algoType=hybrid,searchMethod=0 --cachePrefixGS glove --maxCacheGSRelativeQty 10 2>&1 1>test1b.txt

release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.tail1907495.txt.data.txt --maxNumData 1907495 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.head10000.txt.query.txt --maxNumQuery 10000 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=2,searchMethod=0,skip_optimized_index=1 --queryTimeParams efSearch=300,algoType=hybrid,searchMethod=0 --cachePrefixGS glove --maxCacheGSRelativeQty 10 2>&1 1>test1c.txt

release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.tail1907495.txt.data.txt --maxNumData 1907495 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.head10000.txt.query.txt --maxNumQuery 10000 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=2,searchMethod=0,skip_optimized_index=1 --queryTimeParams efSearch=400,algoType=hybrid,searchMethod=0 --cachePrefixGS glove --maxCacheGSRelativeQty 10 2>&1 1>test1d.txt
```

echo "\"hnsw\"  0.9979  1   0.99896 1.00106 0   0   0.8555  0   4113.81 inf 2194    5898.25 0   1e-06   1163.93 \"M=48,maxM=48,maxM0=96,mult=0.258318,skip_optimized_index=0,efConstruction=400,delaunay_type=2,searchMethod=0,indexThreadQty=8,post=2\"  \"efSearch=200,searchMethod=0,algoType=hybrid\" 1917495" | sed 's/ \+/\n/g' > field_value2.txt



# 使用SIMD指令计算距离、使用为存储设计的内存格式

```
release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.tail1907495.txt.data.txt --maxNumData 1907495 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.head10000.txt.query.txt --maxNumQuery 10000 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=2,searchMethod=0,skip_optimized_index=0 --queryTimeParams efSearch=200,algoType=hybrid,searchMethod=0 2>&1 1>test2.txt

release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.tail1907495.txt.data.txt --maxNumData 1907495 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.head10000.txt.query.txt --maxNumQuery 10000 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=2,searchMethod=0,skip_optimized_index=0 --queryTimeParams efSearch=100,algoType=hybrid,searchMethod=0 --cachePrefixGS glove --maxCacheGSRelativeQty 10 2>&1 1>test2a.txt

release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.tail1907495.txt.data.txt --maxNumData 1907495 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.head10000.txt.query.txt --maxNumQuery 10000 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=2,searchMethod=0,skip_optimized_index=0 --queryTimeParams efSearch=200,algoType=hybrid,searchMethod=0 --cachePrefixGS glove --maxCacheGSRelativeQty 10 2>&1 1>test2b.txt

release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.tail1907495.txt.data.txt --maxNumData 1907495 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.head10000.txt.query.txt --maxNumQuery 10000 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=2,searchMethod=0,skip_optimized_index=0 --queryTimeParams efSearch=300,algoType=hybrid,searchMethod=0 --cachePrefixGS glove --maxCacheGSRelativeQty 10 2>&1 1>test2c.txt

release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.tail1907495.txt.data.txt --maxNumData 1907495 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.head10000.txt.query.txt --maxNumQuery 10000 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=2,searchMethod=0,skip_optimized_index=0 --queryTimeParams efSearch=400,algoType=hybrid,searchMethod=0 --cachePrefixGS glove --maxCacheGSRelativeQty 10 2>&1 1>test2d.txt
```


# 测试结果统计绘图分析

```
cat nohup.out | grep MethodName | head -n 1 > test_result_head.txt

cat nohup.out | grep "\"hnsw\"" > test_result_value.txt

cat test_result_head.txt test_result_value.txt > test_result.txt
```


```
setwd("/Users/zlq/Projects/oss/AI/swimmingsand-nmslib/similarity_search")
hnsw_test_result <- read.table("test_result.txt", header = TRUE, sep = "\t")

hnsw_test_result[c("MethodName", "DistComp")]

ggplot(data=hnsw_test_result, mapping=aes(x=Recall,y=QueryPerSec, colour=MethodName)) + geom_line() + geom_point() + geom_text(aes(label=paste(round(Recall, 3), round(QueryPerSec,0), sep = ", "), vjust=-1), size=3, parse = FALSE) + xlim(0.5, 1) + ylim(0, 2000)

ggplot(data=hnsw_test_result, mapping=aes(x=Recall,y=DistComp, colour=MethodName)) + geom_line() + geom_point() + geom_text(aes(label=paste(round(Recall, 3), round(DistComp,0), sep = ", "), vjust=-1), size=3, parse = FALSE) + xlim(0.5, 1) + ylim(0, 15000) + facet_wrap(~MethodName)


```

```
library(ggplot2)
setwd("/Users/zlq/Projects/vagrant/vagrant-xenial64/vector-knn/docs/2017-11-27-hnsw测试")
hnsw_test_result <- read.table("2017-11-27-hnsw-cpp版本-java版本测试结果对比.txt", header = TRUE, sep = " ")

p <- ggplot(data=hnsw_test_result, mapping=aes(x=Recall,y=QueryPerSec, colour=MethodName))
p <- p + theme(text = element_text(family = "STHeiti"))
p <- p + geom_line()
p <- p + geom_point()
p <- p + xlim(0.5, 1) + ylim(0, 2000)
p <- p + geom_text(aes(label=paste(round(Recall, 3), round(QueryPerSec,0), sep = ", "), vjust=0,hjust=4), size=2.5, parse = FALSE)
p <- p + labs(title = "2017-11-27-hnsw-cpp版本-java版本测试结果对比", subtitle = "data=1907495条,test=10000条,d=300,k=100")

# ggsave("2017-11-27-hnsw-cpp版本-java版本测试结果对比2.png", width = 12, height = 7.75)
ggsave("2017-11-27-hnsw-cpp版本-java版本测试结果对比.png", limitsize = FALSE)
ggsave("2017-11-27-hnsw-cpp版本-java版本测试结果对比.jpeg", limitsize = FALSE)

```


## 保存索引文件

```
nohup ../release/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.tail1907495.txt.data.txt --maxNumData 1907495 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.head10000.txt.query.txt --maxNumQuery 10000 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=0,searchMethod=0,skip_optimized_index=0 --queryTimeParams efSearch=100,algoType=hybrid,searchMethod=0 --cachePrefixGS 20171130glove --maxCacheGSRelativeQty 10 --outFilePrefix 20171130glove --appendToResFile 1 --saveIndex 20171130glove_index.hnsw 2>&1 1>test2a.txt &
```

```
debug/experiment --spaceType l2 --distType float --dataFile /Users/zlq/Projects/data/glove.42B.300d.txt.tail1907495.txt.data.txt --maxNumData 1907495 --queryFile /Users/zlq/Projects/data/glove.42B.300d.txt.head10000.txt.query.txt --maxNumQuery 10000 --threadTestQty 1 --knn 100 --method hnsw --createIndex M=48,maxM=48,maxM0=96,mult=0.258318,efConstruction=400,delaunay_type=2,indexThreadQty=8,post=0,searchMethod=0,skip_optimized_index=0 --queryTimeParams efSearch=100,algoType=hybrid,searchMethod=0 --cachePrefixGS 20171130glove --maxCacheGSRelativeQty 10 --outFilePrefix 20171130glove --appendToResFile 1 --loadIndex 20171130glove_index.hnsw
```

```
library(igraph)

setwd("/Users/zlq/Projects/oss/AI/swimmingsand-nmslib/similarity_search/debug")

graph_data <- read.table("hnsw_graph.txt")
g = graph.data.frame(graph_data)

layout_community <-
  function(graph,
           community_algorithm,
           layout_desired) {
    if (!is_igraph(graph)) {
      stop("Not a graph object")
    }
    
    ## detect the community
    graph_commmunity <- community_algorithm(graph)
    
    ## get the membership
    graph_membership <- membership(graph_commmunity)
    
    ## get the vertex label in each membership
    graph_vertex_list <-
      lapply(1:max(graph_membership), function(x) {
        which(graph_membership == x)
      })
    
    ## split the network according to the community structure
    split_community <-
      lapply(graph_vertex_list, function(x) {
        induced_subgraph(graph, x)
      }) ## the vertex name will be renamed
    
    ## get the layout for each sub network
    layouts <- lapply(split_community, layout_desired)
    
    ## combine the layout all the sub network
    lay <- merge_coords(split_community, layouts)
    
    ## the final outputs
    lay <- cbind(unlist(graph_vertex_list), sort(graph_membership), lay)
    colnames(lay) <-
      c("vertex_label", "community_mem", "coord1", "coord2")
    lay <- lay[order(lay[, 1]), ]
    return(lay)
  }

lay = layout_community(g, infomap.community, layout.star)

plot(
  g,
  layout = lay[, 3:4],
  vertex.size = 8,
  edge.color = "red",
  vertex.color = lay[, 2]
)
```

