#TopFieldCollector是一个抽象类

创建具体类实例的静态方法如下

```
public static TopFieldCollector create(Sort sort, int numHits, FieldDoc after,
      boolean fillFields, boolean trackDocScores, boolean trackMaxScore,
      boolean docsScoredInOrder)
      throws IOException;
```

# 不分页FieldDoc after=null

## 具有一个比较器

### docsScoredInOrder为true

#### 跟踪最大分数

OneComparatorScoringMaxScoreCollector

#### 跟踪所有文档的分数

OneComparatorScoringNoMaxScoreCollector

#### 不跟踪分数

OneComparatorNonScoringCollector

### docsScoredInOrder为false

#### 跟踪最大分数

OutOfOrderOneComparatorScoringMaxScoreCollector

#### 跟踪所有文档的分数

OutOfOrderOneComparatorScoringNoMaxScoreCollector

#### 不跟踪分数

OutOfOrderOneComparatorNonScoringCollector

## 具有多个比较器

### docsScoredInOrder为true

#### 跟踪最大分数

MultiComparatorScoringMaxScoreCollector

#### 跟踪所有文档的分数

MultiComparatorScoringNoMaxScoreCollector

#### 不跟踪分数

MultiComparatorNonScoringCollector

### docsScoredInOrder为false

#### 跟踪最大分数

OutOfOrderMultiComparatorScoringMaxScoreCollector

#### 跟踪所有文档的分数

OutOfOrderMultiComparatorScoringNoMaxScoreCollector

#### 不跟踪分数

OutOfOrderMultiComparatorNonScoringCollector

# 分页FieldDoc after!=null

PagingFieldCollector