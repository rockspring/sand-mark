# MultiTermQuery

有一个属性字段RewriteMethod rewriteMethod，MultiTermQuery的public final Query rewrite(IndexReader reader) throws IOException方法使用rewriteMethod进行query重写。rewriteMethod的值默认为CONSTANT_SCORE_REWRITE，可以通过public void setRewriteMethod(RewriteMethod method)方法修改。

## query重写方法

### CONSTANT_SCORE_REWRITE

首先，依次访问每个term的文档，标记他们为命中，对每个文档打分为query的boost值。当匹配的term数量和document数量是不平凡的情况，这个方法比BooleanQuery重写方法快。从不会遇到TooManyClauses异常。重写后query使用MultiTermQueryConstantScoreWrapper包装原始的MultiTermQuery。

### SCORING_BOOLEAN_REWRITE

定义在ScoringRewrite类里面

首先把每个term转换成BooleanQuery的BooleanClause.Occur#SHOULD查询子句，保留query计算的分数。通常的使用场景，这些分数对用户是无意义的，并且需要消耗大量CPU计算，使用CONSTANT_SCORE_REWRITE几乎总是更好的选择。如果term数量太大，会遇到TooManyClauses异常。

### CONSTANT_SCORE_BOOLEAN_REWRITE

与SCORING_BOOLEAN_REWRITE基本一样，除了不需要计算分数，直接给文档打分为query的boost值。


## TopTermsRewrite

TopTermsRewrite继承TermCollectingRewrite，TermCollectingRewrite继承MultiTermQuery.RewriteMethod

### TopTermsScoringBooleanQueryRewrite

首先把每个term转换成BooleanQuery的BooleanClause.Occur#SHOULD查询子句，保留query计算的分数。重写方法仅使用分数较大的一些term，因此不会遇到TooManyClauses异常。这是FuzzyQuery的默认重写方法。

### TopTermsBlendedFreqScoringRewrite

首先把每个term转换成BooleanQuery的BooleanClause.Occur#SHOULD查询子句，调整用于计算分数的频率，在所有term之间调和。不做出全局调和会导致最稀有的term排名最高，这在FuzzyQuery展开的所有term中通常是无用的。重写方法仅使用分数较大的一些term，因此不会遇到TooManyClauses异常。这是FuzzyQuery的默认重写方法。

### TopTermsBoostOnlyBooleanQueryRewrite

首先把每个term转换成BooleanQuery的BooleanClause.Occur#SHOULD查询子句，直接给文档打分为query的boost值。重写方法仅使用分数较大的一些term，因此不会遇到TooManyClauses异常。这是FuzzyQuery的默认重写方法。

## 方法解读

### getTermsEnum

```
protected abstract TermsEnum getTermsEnum(Terms terms, AttributeSource atts) throws IOException;
```

通过扩展term模式构建一个term枚举器。不能返回空值，使用TermsEnum#EMPTY替代。TermsEnum必须定位到第一个匹配的term。

## 子类

FuzzyQuery、AutomatonQuery、LegacyNumericRangeQuery（已经废弃）、GeoPointMultiTermQuery（已废弃）、TermsQuery、SlowFuzzyQuery（已废弃）

单元测试中TestMultiTermQueryRewrites、DumbPrefixQuery、DumbRegexpQuery
