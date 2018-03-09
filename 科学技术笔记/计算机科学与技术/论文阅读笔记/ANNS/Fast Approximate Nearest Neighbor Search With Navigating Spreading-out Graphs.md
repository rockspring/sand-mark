# Fast Approximate Nearest Neighbor Search With Navigating Spreading-out Graphs

1，导论

近似最邻近搜索（ANNS）已经是数十年的热门话题了，为数据挖掘、机器学习和计算机视觉的很多应用提供基础支持。如下两篇文章说明了一些应用的研究：

J. S. Beis and D. G. Lowe. Shape indexing using approximate nearest-neighbour search in high-dimensional spaces.

T. Liu, C. R. Rosenberg, and H. A. Rowley. Clustering billions of images with large scale nearest neighbor search. In 8th IEEE Workshop on Applications of Computer Vision (WACV 2007), page 28, 2007.

对稀疏数据（像文档），使用先进的索引结构（如倒排索引）可以实现高效的最邻近搜索。倒排索引的一篇文章如下：

P. R. Manning, Christopher D. and H. Schtze. Introduction to information retrieval. Cambridge: Cambridge university press, 2008.

对稠密数据，各种不同的方法已经被提出，如基于树结构的、基于散列函数的、基于图结构的。

基于树结构的方法有如下几种：

KD-树 J. L. Bentley. Multidimensional binary search trees used for associative searching. Communications of the Acm, 18(9):509–517, 1975.

随机化的KD-树 C. Silpa-Anan and R. Hartley. Optimised kd-trees for fast image descriptor matching. In Proceedings of the 2008 IEEE Conference on Computer Vision and Pattern Recognition, pages 1–8, 2008.

K-均值树 K. Fukunaga and P. M. Narendra. A branch and bound algorithm for computing k-nearest neighbors. IEEE Transactions on Computers, 100(7):750–753, 1975.

这些基于树的方法遵循同样的路线。它们先构建一棵树，然后针对给定查询点执行深度优先搜索。这些方法在低维空间数据中表现良好，但是当维数增加时性能显著下降，关于维度的影响研究文章如下：

C. Silpa-Anan and R. Hartley. Optimised kd-trees for fast image descriptor matching. In Proceedings of the 2008 IEEE Conference on Computer Vision and Pattern Recognition, pages 1–8, 2008.

基于散列函数的方法有如下几种：

局部敏感散列（LSH、locality sensitive hashing） A. Gionis, P. Indyk, and R. Motwani. Similarity search in high dimensions via hashing. In Proceedings of the 25th International Conference on Very Large Data Bases, pages 518–529, 1999.

谱散列（Spectral Hashing） Y. Weiss, A. Torralba, and R. Fergus. Spectral hashing. In Advances in neural information processing systems, pages 1753–1760, 2009.

为高维实数向量产生一个二进制字符串，同时可以使用二进制串计算原始的实数向量的相似度。散列表就用作索引结构。理想情况下，相似的实数向量应当有相似的二进制字符串（使用汉明距离（Hamming distance）度量两个二进制字符串的相似度），进而落到相同或邻近的散列桶中。但是，目前发明的方法远远未达到理想状态。为了确保一个较高的精度，它们需要在汉明空间中使用一个很大的搜索半径，这意味着大量的散列桶需要被检查，进而产生了低劣的性能，关于这一点的研究文章如下：

D. Cai. A revisit of hashing algorithms for approximate nearest neighbor search. arXiv:1612.07545, 2016.

基于图的方法有如下几种（按照使用的图结构分类）：

一个基本的思想是邻居的邻居也可能是自己的邻居，关于这一点的研究文章如下：

K. Hajebi, Y. Abbasi-Yadkori, H. Shahbazi, and H. Zhang. Fast approximate nearest-neighbor search with k-nearest neighbor graph. In IJCAI 2011, Proceedings of the International Joint Conference on Artificial Intelligence, volume 22, pages 1312–1317, 2011.

W. Dong, C. Moses, and K. Li. Efficient k-nearest neighbor graph construction for generic similarity measures. In Proceedings of the 20th international Conference on World Wide Web, pages 577–586, 2011.

依次检查每个邻居的所有邻居（这个过程称之为NN-expansion），可以高效地找到查询点的真正邻居。

研究已经证明基于图的方法显著地优胜于传统的基于树的方法和基于散列函数的方法，如下文章对这一点有对比研究：

Z. Jin, D. Zhang, Y. Hu, S. Lin, D. Cai, and X. He. Fast and accurate hashing via iterative nearest neighbors expansion. IEEE transactions on cybernetics, 44(11):2167–2177, 2014.

C. Fu and D. Cai. Efanna : An extremely fast approximate nearest neighbor search algorithm based on knn graph. arXiv:1609.07228, 2016.

D. Cai. A revisit of hashing algorithms for approximate nearest neighbor search. arXiv:1612.07545, 2016.

kNN图大类：

GNNS K. Hajebi, Y. Abbasi-Yadkori, H. Shahbazi, and H. Zhang. Fast approximate nearest-neighbor search with k-nearest neighbor graph. In IJCAI 2011, Proceedings of the International Joint Conference on Artificial Intelligence, volume 22, pages 1312–1317, 2011.

KGraph W. Dong. Kgraph, an open source library for k-nn graph construction and nearest neighbor search. www.kgraph.org, 2014.

IEH Z. Jin, D. Zhang, Y. Hu, S. Lin, D. Cai, and X. He. Fast and accurate hashing via iterative nearest neighbors expansion. IEEE transactions on cybernetics, 44(11):2167–2177, 2014.

Efanna C. Fu and D. Cai. Efanna : An extremely fast approximate nearest neighbor search algorithm based on knn graph. arXiv:1609.07228, 2016.

kNN图保存了每个点的k个最近邻点。Kiana首次提出了称之为GNNS的算法在一个kNN图中执行贪婪搜索，使用NN-expansion扩大搜索范围。KGraph与GNNS算法有同样的思想但是不同的实现。它们两个的思想是，一开始从图中选取一些顶点，然后执行NN-expansion直到算法收敛。

以上方法的缺点，当经过数据集的低密度区域时，很容易陷入局部最优情形。

IEH和Efanna使用了额外的数据结构（分别使用散列函数和截断KD树）获取更好的初始顶点，从这些顶点执行NN-expansion精细化结果。研究表明，这个改进使得IEH和Efanna方法极大地优胜于GNNS和KGraph方法。


但是，kNN图不是最优的图结构，如下文章研究了这个问题，提出了一个遮挡规则（occlusion rule）确保任何两个连接的边之间的夹角不小于60度。

H. Ben and D. Tom. FANNG: Fast approximate nearest neighbour graphs. In Proceedings of the 2016 IEEE Conference on Computer Vision and Pattern Recognition, pages 5713–5722, 2016.

直观上来看，所有的定点更广阔地伸展出去，文章根据遮挡规则（occlusion rule）提出了一个构建快速近似最邻近图（FANNG，fast approximate nearest neighbor graph）的算法。实验证明，在FANNG和kGraph的顶点平均出度一样的情况下，在FANNG上执行搜索的性能显著优胜于kGraph上执行搜索。然而，文章中提出的图构建算法非常耗时。

如下文章提出了一个层次化可导航的小词图（HNSW，hierarchical navigable small world graphs），搜索性能非常好，本论文发表之前最快的。HNSW从顶向下层次化地构建图。图的尺度从底向上逐层收缩，每一层都满足遮挡规则（occlusion rule）(称之为启发式邻居选择)。

Y. A. Malkov and D. A. Yashunin. Efficient and robust approximate nearest neighbor search using hierarchical navigable small world graphs. arXiv:1603.09320, 2016.

以上方法的一个缺点是，在上层需要额外的内存代价，这也是需要额外数据结构的通用缺点。

通过对以上方法的观察，我们提出了一个构建导航伸展图（NSG，navigating spreading-out graph）的新颖方法。一个NSG是一个从kNN图构建出来的单层图，构建过程从预先选好的导航顶点开始，收集每个顶点的非遮挡边。大量实验表明我们的方法在索引大小和搜索速度上都显著优胜于目前的最佳方法。

方法的关键点如下：

1，所有的三种图FANNG、HNSW、NSG都满足遮挡规则（occlusion rule）。然而，遮挡规则（occlusion rule）是一个非常弱的约束条件，大量图都满足，不同的图构建算法可能构建出完全不同的图结构。

2，同样构建单层图，NSG的构建速度显著优胜于FANNG。在NSG上的搜索速度也显著优胜于FANNG。

3，HNSW是一个层次化的图结构，NSG是一个单层图，NSG相比HNSW非常节省内存。然而在NSG上的搜索速度还是优胜于HNSW。

4，NSG是从近似kNN图构建出来的，这确保了NSG的每个顶点有一个特性，出边的总长度可能是同样边数所有可能的非遮挡边组合中最短的。直观上来讲，NSG的边从近到远地伸展到每个顶点的邻近区域。

## 2 基于图的近似最邻近搜索

在各种图中进行近似邻近实际上都遵循同样的探索方法，如下文章首次对此进行了研究：

K. Hajebi, Y. Abbasi-Yadkori, H. Shahbazi, and H. Zhang. Fast approximate nearest-neighbor search with k-nearest neighbor graph. In IJCAI 2011, Proceedings of the International Joint Conference on Artificial Intelligence, volume 22, pages 1312–1317, 2011.

对一个给定查询点，算法从给定顶点开始，迭代地依次检查邻居的邻居，持有最近的一个点，直到在图中无法继续前进为止。这个算法（NHGSearch，naive heuristic greedy search）描述如下：

```
Algorithm 1 NHGsearch(G, p, q, l)
Require: graph G, start vertex p, query point q, candidate pool size l
Ensure: k nearest neighbors of query point q
1: candidate pool S = ∅
2: S.add(p)
3: while S still changes do
4:   add all neighbors of vertex S[0] into S.
5:   sort S in ascending order of distance to q.
6:   remove the distant vertices in S to keep its size no larger than l
7: end while
8: return the first k vertices in S.
```

K. Hajebi, Y. Abbasi-Yadkori, H. Shahbazi, and H. Zhang在其文章中描述的方法GNNS是重复Algorithm 1 R次，获取最好的结果。

然而，Algorithm 1实在太朴素了，很容易陷入局部最优。一个改进版被提出，称之为IHGSearch（improved heuristic greedy search algorithm）。维持一个固定大小的候选集池子，保持里面的点按离查询点的距离由近到远有序。这个池子频繁更新确保里面的点是离查询点最近的。另外维持一个记录本，记录那些点已经检查过了。

```
Algorithm 2 IHGsearch(G, p, q, l)
Require: graph G, start vertex p, query point q, candidate pool size l
Ensure: k nearest neighbors of q
1: i=0
2: candidate pool S = ∅
3: S.add(p)
4: while i < l do
5:   pi = first unchecked vertex in S
6:   i = position of pi in S
7:   mark pi as checked
8:   for all neighbor n of pi in G do
9:     S.add(n)
10:  end for
11:  sort S in ascending order of distance to q
12:  remove the distant vertices in S to keep its size no larger than l
13:end while
14:return the first k vertices in S
```

如下文章在kNN图中使用了Algorithm 2算法：

KGraph W. Dong. Kgraph, an open source library for k-nn graph construction and nearest neighbor search. www.kgraph.org, 2014.

IEH Z. Jin, D. Zhang, Y. Hu, S. Lin, D. Cai, and X. He. Fast and accurate hashing via iterative nearest neighbors expansion. IEEE transactions on cybernetics, 44(11):2167–2177, 2014.

Efanna C. Fu and D. Cai. Efanna : An extremely fast approximate nearest neighbor search algorithm based on knn graph. arXiv:1609.07228, 2016.

如下文章在FANNG图中使用了Algorithm 2算法：

H. Ben and D. Tom. FANNG: Fast approximate nearest neighbour graphs. In Proceedings of the 2016 IEEE Conference on Computer Vision and Pattern Recognition, pages 5713–5722, 2016.

如下文章在HNSW图的底层使用了Algorithm 2算法，上层使用了Algorithm 1算法：

Y. A. Malkov and D. A. Yashunin. Efficient and robust approximate nearest neighbor search using hierarchical navigable small world graphs. arXiv:1603.09320, 2016.

Ben Harwood和Tom Drummond等研究人员发现kNN图不是最优的搜索图。他们相信存在一种理想结构的图，我们可以使用Algorithm 1算法从每一个顶点出发到达任意其它顶点，期间，总的边数应当最小化。我们称这个特性为贪婪可达特性（greedy reachable property）。

Ben Harwood和Tom Drummond研究人员也给出了一个遮挡规则（occlusion rule），用于移除冗余的边，在kNN图中执行Algorithm 1算法时这些边实际上不需要被检查。

Ben Harwood和Tom Drummond研究人员发现kNN图和FANNG图在有同样的平均出度时，对一个给定顶点，FANNG确保她的出边覆盖了一个更广的范围。

Ben Harwood和Tom Drummond研究人员发现在同等出度条件下，在FANNG上执行搜索优胜于在kNN上执行搜索。

FANNG的构图过程是先从空图构建，然后一边修正图一边收集非遮挡的边。

他们用这种启发的方式尝试构建了一个理想图结构，然而，这个索引构建非常耗时。

Y. A. Malkov and D. A. Yashunin研究员使用层次化可导航的小词图（HNSW，hierarchical navigable small world graphs）执行高效的搜索。通过采用一个启发式邻居选择策略，这个策略就是遮挡规则，SW的每一层结构与FANNG非常像。

HNSW从空图开始构建，使用贪婪的启发式方法。

HNSW是目前为止发现最快的，然而，它的索引占用内存太大，这是由于它有多层图结构。

# 3 导航伸出图

NSG由两部分组成，一个导航顶点，一个满足遮挡规则的图。导航顶点是给定数据集的中心点。

如何求得中心点：

第一步，计算数据集的平均值。
第二步，用平均值作为查询点，使用Algorithm 2算法在预先构建的近似kNN图中搜索最邻近点。

NSG也是从kNN图构建出来的。
kNN图的构建我们使用efanna方法构建，这是我们已知的最快方法。

## 3.1 导航伸出图的构建

在ANNS问题上，FANNG优胜于kNN图，但是构建FANNG图很耗时，我们希望根据遮挡规则构建一个图花费很短的时间。

下面分析一下慢的原因：

如果所有的搜索从同一个顶点出发，我们不需要每一个顶点满足贪婪可达特性。

FANNG从零开始构建图，初始化时随机将一些顶点链接到一起，然后使用Algorithm 2算法修正图。

它们希望沿着图的收敛过程为每一个顶点收集非遮挡边。

但是，在图收敛过程中，无论何时一个新的边来了，在这条边和旧的边之间的遮挡特性被破坏了。

在漫长的收敛过程中，太多的边先被吸收进来，之后又被抛弃，这是它慢的主要原因。

如何改进：

在早期阶段，我们不让算法在一个粗糙的图中盲目地沿着顶点行走，我们从一个高质量的近似kNN图构建一个NSG图。

同时，想一下贪婪可达特性，如果我们在近似kNN图执行Algorithm 2算法从顶点p到q，计算任务非常繁重，因为存在大量的边仅有一点点甚至没有贡献。

在覆盖到的所有边中，肯定存在一条满足贪婪可达特性的路径。我们必须使用遮挡规则将其切分出来。我们仅仅从导航顶点到所有其他顶点执行这个过程。如果在NSG图中，所有的顶点从导航顶点贪婪可达，一个给定查询点的所有最邻近邻居点从导航顶点贪婪可达。

下面描述我们的算法：

首先，选择一个导航顶点N，在我们的实现中，选择数据集中的中心点。

其次，从N点出发到所有点执行启发式贪婪搜索。我们对Algorithm 2算法做了一点点修改，添加一个候选集剪切池子记录所有被遮盖的顶点，使得其更高效。

然后，我们将这个池子与引导本kNN图中的邻居合并。

最后，我们根据遮挡规则剪掉多余的边，保留k个边，k是一个参数。

```
Algorithm 3 NSGbuild(G, l, k)
Require: kNN Graph G, candidate pool size l for greedy search, maximum out-degree k of NSG.
Ensure: NSG with navigating vertex n
1: n = medoid of vertices in G.
2: for all vertex v in G do
3:   %%heuristic greedy search with additional candidate cutting pool recording visited vertices%%
4:   cutting pool E =IHGsearch(G,n,v,l)
5:   merge E with v’s neighbors in G
6:   sort E in ascending order of distance to v
7:   result set R = ∅, p0 = E[0]
8:   R.add(p0)
9:   while R.size() < k && !E.empty() do
10:    p = E.front()
11:    E.remove(E.front())
12:    for all vertex r in R do
13:      if edge pv occluded by rv then
14:         break
15:      end if
16:    end for
17:    if no occlusion occurs then
18:      R.add(p)
19:    end if
20:  end while
21:end for
```

3.2 层次化NSG

虽然我们尽我们最大可能为导航节点满足贪婪可达特性，产生的NSG仍然不能在参数配置及kNN图的质量的限制下大道100%的贪婪可达性。

为了进一步改进搜索性能，一个直观的方式是层次化构建NSG。

HNSW是一种层次化方法，从上往下构建索引，随机选择一些顶点放到每一层，我们不同于它。下面描述我们的算法：

首先，我们在NSG图中执行Algorithm 1算法，记录顶点对，包括我们搜索的目标顶点和我们最终搜索停在的顶点。

其次，所有被记录的顶点及导航顶点被选做上层的顶点。

直观上来讲，在这个子集上执行NSG构建算法将强制不可达的遥远的顶点链接到一起。

为了灵活性，每一层的最大出度可以不同。

```
Algorithm 4 HNSGbuild(V , level, k, p)
Require: Vertex set V , maximum level level, maximum out-degree k of NSG, candidate pool size p for greedy search.
Ensure: HNSG with navigating vertex n
1: Vtemp = V
2: for l = 1 : level do
3:   build kNN Graph Gl on Vtemp
4:   HNSG[l] = NSGbuild(Gl,p,k)
5:   Vtemp = ∅
6:   Vtemp.add(n)
7:   for all vertex v in HNSG[l] do
8:     nearest neighbors Vnn =NHGSearch(HNSG[l], n, v, p)
9:     vs = Vnn[0]
10:    if vs ! = v then
11:      Vtemp.add(v)
12:      Vtemp.add(vs)
13:    end if
14:  end for
15:end for
```

3.3 在NSG图中搜索

对任何查询点，我从导航顶点开始，应用Algorithm 2算法就可以了。

