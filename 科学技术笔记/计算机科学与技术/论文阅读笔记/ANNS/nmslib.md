
```
erikbern-ann-benchmarks

python ann_benchmarks/main.py --algo="hnsw(nmslib)"
python plot.py --input results/glove.txt --output result-graph
```


```
sudo apt install texlive-latex-base

export TEXINPUTS=.:/vagrant/pgfplots:/usr/share/texlive/texmf-dist/tex/latex/latexconfig/
export TEXMFHOME=/usr/share/texlive/texmf-dist/
kpsewhich -var-value TEXMFHOME
export TEXMFDIST=/usr/share/texlive/texmf-dist/

kpsewhich article.cls

/usr/share/texlive/texmf-dist/tex/latex/base/article.cls

release/experiment --distType float --spaceType cosinesimil --testSetQty 5 --maxNumQuery 100 --knn 1 --range 0.1 --dataFile ../sample_data/final8_10K.txt --outFilePrefix result --method proj_incsort --createIndex projType=rand,projDim=4 --queryTimeParams useCosine=1,dbScanFrac=0.01



release/experiment --distType float --spaceType l2 --testSetQty 5 --maxNumQuery 100 --knn 1 --range 0.1 --dataFile ../sample_data/final8_10K.txt --outFilePrefix result --method vptree --createIndex  bucketSize=10,chunkBucket=1 --queryTimeParams alphaLeft=2.0,alphaRight=2.0,expLeft=1,expRight=1,maxLeavesToVisit=500

../scripts/genplot_configurable.py  -n MethodName -i result_K\=1.dat -o plot_1nn -x 1~norm~Recall -y 1~log~ImprEfficiency -a  axis_desc.txt -m  meth_desc.txt -l "2~(0.96,-.2)" -t "ImprEfficiency  vs Recall" --xmin 0.01 --xmax 1.2 --ymin -2 --ymax 10

```

# maumueller-ann-benchmarks

```
cp ann_benchmarks/main.py .
mkdir results queries

修改plot.py的107行
args.dataset, int(args.limit), int(args.count), int(args.distance),

diff --git a/algorithm/base_index.hpp b/algorithm/base_index.hpp
index 4701989..00b1513 100644
--- a/algorithm/base_index.hpp
+++ b/algorithm/base_index.hpp
@@ -500,7 +500,7 @@ typedef std::vector<unsigned int> IndexVec;
                return row;
        }
 
-
+std::vector<std::vector<int> > nn_results;
 protected:
     const Matrix<DataType> features_;
     const Distance<DataType>* distance_;
@@ -512,7 +512,6 @@ protected:
     //std::vector<std::vector<int>> knn_graph;
     std::vector<CandidateHeap> knn_graph;
     std::vector<DataType> norms;
-    std::vector<std::vector<int> > nn_results;
     DataType* Radius;
   };
 #define USING_BASECLASS_SYMBOLS \
diff --git a/efanna.hpp b/efanna.hpp
index 700b2d3..377dca2 100644
--- a/efanna.hpp
+++ b/efanna.hpp
@@ -66,6 +66,10 @@ public:
                initIndex_->outputVisitBucketNum();
        }
 
+       std::vector<std::vector<int> > getResult(){
+               return initIndex_->nn_results;
+       }
+
 private:
        /** Pointer to actual index class */
        IndexType* initIndex_;


python main.py --dataset glove --distance euclidean --count 100 --limit 200000 --algorithm "hnsw(nmslib)"

python main.py --dataset glove --distance euclidean --count 100 --limit 20000 --algorithm "efanna" --definitions my_algos.yaml


usage: plot.py [-h] --dataset DATASET [--count COUNT] [--limit LIMIT]
               [--query-dataset QUERY_DATASET] [--distance DISTANCE] -o OUTPUT
               [-x {queriessize,largeepsilon,k-nn,build,rel,qps,epsilon,indexsize,candidates}]
               [-y {queriessize,largeepsilon,k-nn,build,rel,qps,epsilon,indexsize,candidates}]
               [-X] [-Y] [-G] [--raw]


"recall/time" : ("k-nn", "qps"),
"recall/buildtime" : ("k-nn", "build"),
"recall/indexsize" : ("k-nn", "indexsize"),
"rel/time" : ("rel", "qps"),
"recall/candidates" : ("k-nn", "candidates"),
"recall/qpssize" : ("k-nn", "queriessize"),
"eps/time" : ("epsilon", "qps"),
"largeeps/time" : ("largeepsilon", "qps")

python plot.py --dataset glove --count 100 --limit 200000 --distance euclidean -o recall-time  -x k-nn  -y qps
python plot.py --dataset glove --count 100 --limit 200000 --distance euclidean -o recall-buildtime  -x k-nn  -y build
python plot.py --dataset glove --count 100 --limit 200000 --distance euclidean -o recall-indexsize  -x k-nn  -y indexsize

python plot.py --dataset glove --count 100 --limit 20000 --distance euclidean -o recall-time  -x k-nn  -y qps


python main.py --dataset 30W.glove --distance euclidean --count 100  --algorithm faiss-ivf --force

python main.py --dataset 30W.glove --distance euclidean --count 100  --algorithm "efanna" --definitions my_algos.yaml

python plot.py --dataset 30W.glove --count 100 --distance euclidean -o 30W-glove-recall-time  -x k-nn  -y qps
python plot.py --dataset 30W.glove --count 100 --distance euclidean -o 30W-glove-recall-buildtime  -x k-nn  -y build
python plot.py --dataset 30W.glove --count 100 --distance euclidean -o 30W-glove-recall-indexsize  -x k-nn  -y indexsize

```


# FLASH

```
sudo apt install ocl-icd-libopencl1
sudo apt install opencl-headers
sudo apt install clinfo

sudo apt install beignet
```

# hnsw

The post=2 adds an additional post-processing step to symmetrize the index. It is not documented yet in nmslib and do not presented in the paper on HNSW. In short, two indexes is build with different order of the data(direct and reverse), with following union of the produced connections. It does not affect directly the query time parameters, such as ef.

On overall, it leads to a roughly twice as long construction time, while in the end adding extra search performance at high recalls (up to several tens of percent in tests on 1M sift at ~0.999 recall, the gain smaller for less recall). So if you want to get maximum performance at search you should use post=2.

Index params:
For small_world_rand reasonable values for NN to try 15-50. Then search parameter efSearch would range from say 10 to 1000 (again need to check empirically how it works).
For HNSW, M would also range from 15 to 50 (or a bit larger value). Similar range for efSearch: 10 to 1000. You need to skip_optimized_index=1 unless you use dense cosine or l2.
There are a couple more parameters to try:
delaunay_type it's 2 by default, but other values to try are 0 and 3.
Values of post = 1 or 2 can improve retrieval speed albeit at the cost of doubling indexing time.

```
include/factory/init_methods.h 每种算法的名字和构建工厂映射

REGISTER_METHOD_CREATOR(float,  METH_HNSW, CreateHnsw)
```

```
include/factory/method/hnsw.h

template <typename dist_t>
Index<dist_t>* CreateHnsw(bool PrintProgress,
    const string& SpaceType,
    Space<dist_t>& space,
    const ObjectVector& DataObjects) {
    return new Hnsw<dist_t>(PrintProgress, space, DataObjects);
}
```

include/index.h

```
class Index {
public:
  // Create an index using given parameters
  virtual void CreateIndex(const AnyParams& indexParams) = 0;
  // SaveIndex is not necessarily implemented
  virtual void SaveIndex(const string& location) {
    throw runtime_error("SaveIndex is not implemented for method: " + StrDesc());
  }
  // LoadIndex is not necessarily implemented
  virtual void LoadIndex(const string& location) {
    throw runtime_error("LoadIndex is not implemented for method: " + StrDesc());
  }
  virtual ~Index() {}
  /*
   * There are two type of search methods: a range search and a k-Nearest Neighbor search.
   * In both cases, you can specify an optional starting data point/object. Some methods, e.g.,
   * based on proximity graphs, can use this information to make the search faster and/or more 
   * accurate. 
   */
  virtual void Search(RangeQuery<dist_t>* query, IdType startObj = -1) const = 0;
  virtual void Search(KNNQuery<dist_t>* query, IdType startObj = -1) const = 0;
  // Get the description of the method
  virtual const string StrDesc() const = 0;
  // Set query-time parameters
  virtual void SetQueryTimeParams(const AnyParams& params) = 0;
  // Reset query-time parameters so that they have default values
  virtual void ResetQueryTimeParams() { SetQueryTimeParams(getEmptyParams()); }
  /*
   * In rare cases, mostly when we wrap up 3rd party methods,
   * we simply duplicate the data set. This function
   * let the experimentation code know this, so it could
   * adjust the memory consumption of the index.
   */
  virtual bool DuplicateData() const { return false; }

  virtual void AddBatch(const ObjectVector& batchData, bool printProgress, bool checkIDs = false/* this is a debug flag only, turning it on may affect performance */) {
    throw runtime_error("AddBatch is not implemented!");
  }

  virtual void DeleteBatch(const ObjectVector& batchData, int delStrategy /* this flag is method-specific */,
                           bool checkIDs = false/* this is a debug flag only, turning it on may affect performance */) {
    throw runtime_error("DeleteBatch is not implemented!");
  }

  virtual void DeleteBatch(const vector<IdType>& batchData, int delStrategy /* this flag is method-specific */,
                           bool checkIDs = false/* this is a debug flag only, turning it on may affect performance */) {
    throw runtime_error("DeleteBatch is not implemented!");
  }
private:
  template <typename QueryType>
  void GenericSearch(QueryType* query, IdType) const;
};
```

include/method/hnsw.h

```
similarity::Hnsw

similarity::VisitedListPool 支持多线程的VisitedLists池子管理器

similarity::VisitedList

similarity::HnswNodeDistFarther
similarity::HnswNodeDistCloser HnswNode距离比较器，记录元素及距离
similarity::EvaluatedMSWNodeInt

similarity::HnswNode

Hnsw::Hnsw
Hnsw::SaveIndex
Hnsw::LoadIndex
Hnsw::StrDesc
Hnsw::Search
Hnsw::SetQueryTimeParams
Hnsw::kSearchElementsWithAttemptsLevel
Hnsw::add
Hnsw::addToElementListSynchronized
Hnsw::link

Hnsw::baseSearchAlgorithmOld
Hnsw::baseSearchAlgorithmV1Merge
Hnsw::listPassingModifiedAlgorithm
Hnsw::SearchL2CustomV1Merge
Hnsw::SearchL2CustomOld
Hnsw::SearchCosineNormalizedOld
Hnsw::SearchCosineNormalizedV1Merge
以上7个方法选择一个，使用searchMethod_、searchAlgoType_、ef_共同决定，在Hnsw<dist_t>::Search(KNNQuery<dist_t> *query, IdType)中进行选择

Hnsw::getRandomLevel

HnswNode::getNeighborsByHeuristic1
HnswNode::getNeighborsByHeuristic2
HnswNode::getNeighborsByHeuristic3
HnswNode::addFriendlevel
HnswNode::init  初始化节点的值
HnswNode::copyDataAndLevel0LinksToOptIndex
HnswNode::copyHigherLevelLinksToOptIndex
HnswNode::getData
HnswNode::getId
HnswNode::getAllFriends
```

```
src/method/hnsw.cc
template <typename dist_t>
Hnsw<dist_t>::Hnsw(bool PrintProgress, const Space<dist_t> &space, const ObjectVector &data)
    : space_(space)
    , PrintProgress_(PrintProgress)
    , data_(data)
    , visitedlistpool(nullptr)
    , enterpoint_(nullptr)
    , data_level0_memory_(nullptr)
    , linkLists_(nullptr)
    , fstdistfunc_(nullptr)
{
}

data 是向量数据

similarity::L2SqrSIMDExt
similarity::L2SqrSIMD16Ext
similarity::NormScalarProductSIMD
similarity::checkList1
similarity::getDegreeDistr

Hnsw<dist_t>::Hnsw
Hnsw<dist_t>::CreateIndex 创建索引
Hnsw<dist_t>::SetQueryTimeParams 设置查询参数
Hnsw<dist_t>::StrDesc
Hnsw<dist_t>::~Hnsw
Hnsw<dist_t>::add
Hnsw<dist_t>::kSearchElementsWithAttemptsLevel
Hnsw<dist_t>::addToElementListSynchronized
Hnsw<dist_t>::Search
Hnsw<dist_t>::SaveIndex
Hnsw<dist_t>::LoadIndex
Hnsw<dist_t>::baseSearchAlgorithmOld
Hnsw<dist_t>::baseSearchAlgorithmV1Merge
Hnsw<dist_t>::listPassingModifiedAlgorithm
```

include/space.h

向量空间

```
similarity::Space

Space::IndexTimeDistance(const Object* obj1, const Object* obj2) 建立索引时计算距离
```

include/space/space_vector.h

```
similarity::VectorSpace
similarity::VectorSpaceSimpleStorage
```

include/space/space_lp.h

```
#define SPACE_L     "lp"
#define SPACE_LINF  "linf"
#define SPACE_L1    "l1"
#define SPACE_L2    "l2"

similarity::SpaceLpDist
similarity::SpaceLp
```

src/distcomp_lp.cc

```
similarity::L2NormSIMD(const float* pVect1, const float* pVect2, size_t qty)
similarity::L2SqrSIMD(const float* pVect1, const float* pVect2, size_t qty)
```

src/method/hnsw_distfunc_opt.cc

```
similarity::L2SqrSIMD16Ext(const float *pVect1, const float *pVect2, size_t &qty, float *TmpRes)
```

include/object.h

```
Object::Object 优化存储空间的数据存储对象
```

include/params_def.h

参数名称定义

include/cmd_options.h

解析命令行参数

```
void CmdOptions::Parse(int argc, char* argv[]) 解析命令行参数

similarity::CmdParam 描述一个参数，有一个解析参数值的方法
```

include/params.h

定义参数类型

similarity::AnyParams key-value参数

include/thread_pool.h 提交任务到线程池并行执行

template <class T> bool GetNextQueueObj(std::mutex &mtx, std::queue<T>& queue, T& obj)
template <class Function> inline void ParallelFor(size_t start, size_t end, size_t numThreads, Function fn)

include/query_creator.h

```
similarity::KNNCreator
```

src/knnquery.cc

```
KNNQuery<dist_t>::KNNQuery(const Space<dist_t>& space, const Object* query_object, const unsigned K, float eps)

template <typename dist_t> bool KNNQuery<dist_t>::CheckAndAddToResult(const dist_t distance, const Object* object) 收集查询结果
```

src/query.cc

```
dist_t Query<dist_t>::DistanceObjLeft(const Object* object) const
```

include/sort_arr_bi.h

```
This is not a fully functional heap and this is done on purpose.
SortArrBI

class Item {
 public:
  KeyType   key;
  bool      used = false;
  DataType  data;

  Item() {}
  Item(const KeyType& k) : key(k) {}
  Item(const KeyType& k, const DataType& d) : key(k), data(d) {}

  bool operator < (const Item& i2) const {
    return key < i2.key;
  }
};
class SortArrBI {
  std::vector<Item> v_;
  size_t num_elems_ = 0;
}

SortArrBI(size_t max_elem) :  v_(max_elem)
void resize(size_t max_elem)
void push_unsorted_grow(const KeyType& key, const DataType& data) 往列表尾部添加一个元素
KeyType top_key() 返回列表尾部的元素的key
const Item& top_item() 返回列表尾部的元素
void sort() 对列表进行排序，使用Item大小比较方法
void swap(size_t x, size_t y) 交换列表中2个元素
size_t push_or_replace_non_empty(const KeyType& key, const DataType& data)
size_t merge_with_sorted_items(Item* items, size_t item_qty) 原地合并item_qty个Item，都是排序过的列表
size_t push_or_replace_non_empty_exp(const KeyType& key, const DataType& data) 添加或替换一个元素，现有列表是排序过的
std::vector<Item>& get_data()
size_t size()
```

```
2017-11-07 02:11:07 hnsw.cc:178 (CreateIndex) [INFO] M                   = 12
2017-11-07 02:11:07 hnsw.cc:179 (CreateIndex) [INFO] indexThreadQty      = 6
2017-11-07 02:11:07 hnsw.cc:180 (CreateIndex) [INFO] efConstruction      = 400
2017-11-07 02:11:07 hnsw.cc:181 (CreateIndex) [INFO] maxM               = 12
2017-11-07 02:11:07 hnsw.cc:182 (CreateIndex) [INFO] maxM0                = 24
2017-11-07 02:11:07 hnsw.cc:184 (CreateIndex) [INFO] mult                = 0.40243
2017-11-07 02:11:07 hnsw.cc:185 (CreateIndex) [INFO] skip_optimized_index= 0
2017-11-07 02:11:07 hnsw.cc:186 (CreateIndex) [INFO] delaunay_type       = 2
2017-11-07 02:11:07 hnsw.cc:449 (SetQueryTimeParams) [INFO] Set HNSW query-time parameters:
2017-11-07 02:11:07 hnsw.cc:450 (SetQueryTimeParams) [INFO] ef(Search)         =20
2017-11-07 02:11:07 hnsw.cc:451 (SetQueryTimeParams) [INFO] algoType           =2
```

searchMethod 参数已经不起作用

```
release/experiment --spaceType l2 --distType float \
--dataFile ../sample_data/final128_10K.txt --maxNumData 10000 --queryFile ../sample_data/final128_query1K.txt --maxNumQuery 10 --threadTestQty 1 \
--knn 100 \
--method hnsw --createIndex M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=0,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=1,post=2 --queryTimeParams efSearch=20,searchMethod=0,algoType=hybrid \
--saveIndex hnsw_index

```

使用baseSearchAlgorithmV1Merge方法进行搜索

```
release/experiment --spaceType l2 --distType float \
--dataFile ../sample_data/final128_10K.txt --maxNumData 10000 --queryFile ../sample_data/final128_query1K.txt --maxNumQuery 10 --threadTestQty 1 \
--knn 100 \
--method hnsw --createIndex M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=0,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=1,post=2 --queryTimeParams efSearch=20,searchMethod=0,algoType=hybrid \
--saveIndex hnsw_index
```

不使用优化过的索引

```
release/experiment --spaceType l2 --distType float \
--dataFile ../sample_data/final128_10K.txt --maxNumData 10000 --queryFile ../sample_data/final128_query1K.txt --maxNumQuery 10 --threadTestQty 1 \
--knn 100 \
--method hnsw --createIndex M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=1,efConstruction=200,delaunay_type=2,searchMethod=0,indexThreadQty=1,post=2 --queryTimeParams efSearch=20,searchMethod=0,algoType=hybrid \
--saveIndex hnsw_index
```

使用Clion集成开发工具调试nmslib

```
--spaceType
l2
--distType
float
--dataFile
/Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_10K.txt
--maxNumData
10000
--queryFile
/Users/zlq/Projects/oss/AI/nmslib/sample_data/final128_query1K.txt
--maxNumQuery
10
--threadTestQty
1
--knn
100
--method
hnsw
--createIndex
M=16,maxM=16,maxM0=32,mult=0.36,skip_optimized_index=1,efConstruction=200,delaunay_type=3,searchMethod=0,indexThreadQty=1,post=2
--queryTimeParams
efSearch=20,searchMethod=0,algoType=hybrid
--saveIndex
hnsw_index
```

