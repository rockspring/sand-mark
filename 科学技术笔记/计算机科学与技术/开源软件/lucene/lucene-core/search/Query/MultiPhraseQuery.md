MultiPhraseQuery

```
at org.apache.lucene.search.ExactPhraseScorer.phraseFreq(ExactPhraseScorer.java:125)
at org.apache.lucene.search.ExactPhraseScorer.access$000(ExactPhraseScorer.java:27)
at org.apache.lucene.search.ExactPhraseScorer$1.matches(ExactPhraseScorer.java:73)
at org.apache.lucene.search.Weight$DefaultBulkScorer.scoreAll(Weight.java:228)
at org.apache.lucene.search.Weight$DefaultBulkScorer.score(Weight.java:172)
at org.apache.lucene.search.BulkScorer.score(BulkScorer.java:39)
at org.apache.lucene.search.AssertingBulkScorer.score(AssertingBulkScorer.java:69)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:670)
at org.apache.lucene.search.AssertingIndexSearcher.search(AssertingIndexSearcher.java:91)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
at org.apache.lucene.search.TestMultiPhraseQuery.testPhrasePrefix(TestMultiPhraseQuery.java:95)
```

org.apache.lucene.search.ExactPhraseScorer#advancePosition

private static boolean advancePosition(PostingsAndPosition posting, int target)

步进式枚举文档中词条出现的位置，直到一个位置刚好就是目标位置或者一个位置刚刚好大于目标位置。

posting为指向一个文档的文档列表，target为要寻找的目标位置。


private int phraseFreq() throws IOException

final int phrasePos = lead.pos - lead.offset;

phrasePos为领导者词条的第一个位置的偏离度

final int expectedPos = phrasePos + posting.offset;

因为是精准匹配，所以第二个词条的偏离度与领导者词条的偏离度一样，加上词条在短语中的偏移量，得出绝对词条位置expectedPos，然后去第二个词条指向的文档中寻找是否存在这个词条位置，如果存在，则这个词条也精准匹配。