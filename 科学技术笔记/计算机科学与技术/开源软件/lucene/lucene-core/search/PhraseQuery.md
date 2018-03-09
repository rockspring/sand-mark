org/apache/lucene/search/TestPhraseQuery.java

public void testSlop1() throws Exception
 |
\|/
org/apache/lucene/search/PhraseQuery.java
public Weight createWeight(IndexSearcher searcher, boolean needsScores) throws IOException;
 |
\|/
org.apache.lucene.search.PhraseQuery.PhraseWeight
 |
\|/
ExactPhraseScorer SloppyPhraseScorer
 |					 |
\|/					\|/
ConjunctionDISI.intersectIterators


创建TwoPhaseIterator
```
at org.apache.lucene.search.SloppyPhraseScorer.twoPhaseIterator(SloppyPhraseScorer.java:565)
	  at org.apache.lucene.search.SloppyPhraseScorer.iterator(SloppyPhraseScorer.java:586)
	  at org.apache.lucene.search.Weight$DefaultBulkScorer.<init>(Weight.java:159)
	  at org.apache.lucene.search.Weight.bulkScorer(Weight.java:143)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:667)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
	  at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
	  at org.apache.lucene.search.TestPhraseQuery.testSlop1(TestPhraseQuery.java:148)
	  at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-1)
	  at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	  at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	  at java.lang.reflect.Method.invoke(Method.java:497)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner.invoke(RandomizedRunner.java:1764)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$8.evaluate(RandomizedRunner.java:871)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$9.evaluate(RandomizedRunner.java:907)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$10.evaluate(RandomizedRunner.java:921)
	  at org.apache.lucene.util.TestRuleSetupTeardownChained$1.evaluate(TestRuleSetupTeardownChained.java:49)
	  at org.apache.lucene.util.AbstractBeforeAfterRule$1.evaluate(AbstractBeforeAfterRule.java:45)
	  at org.apache.lucene.util.TestRuleThreadAndTestName$1.evaluate(TestRuleThreadAndTestName.java:48)
	  at org.apache.lucene.util.TestRuleIgnoreAfterMaxFailures$1.evaluate(TestRuleIgnoreAfterMaxFailures.java:64)
	  at org.apache.lucene.util.TestRuleMarkFailure$1.evaluate(TestRuleMarkFailure.java:47)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$StatementRunner.run(ThreadLeakControl.java:367)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl.forkTimeoutingTask(ThreadLeakControl.java:809)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$3.evaluate(ThreadLeakControl.java:460)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner.runSingleTest(RandomizedRunner.java:880)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$5.evaluate(RandomizedRunner.java:781)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$6.evaluate(RandomizedRunner.java:816)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$7.evaluate(RandomizedRunner.java:827)
	  at org.apache.lucene.util.AbstractBeforeAfterRule$1.evaluate(AbstractBeforeAfterRule.java:45)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at org.apache.lucene.util.TestRuleStoreClassName$1.evaluate(TestRuleStoreClassName.java:41)
	  at com.carrotsearch.randomizedtesting.rules.NoShadowingOrOverridesOnMethodsRule$1.evaluate(NoShadowingOrOverridesOnMethodsRule.java:40)
	  at com.carrotsearch.randomizedtesting.rules.NoShadowingOrOverridesOnMethodsRule$1.evaluate(NoShadowingOrOverridesOnMethodsRule.java:40)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at org.apache.lucene.util.TestRuleAssertionsRequired$1.evaluate(TestRuleAssertionsRequired.java:53)
	  at org.apache.lucene.util.TestRuleMarkFailure$1.evaluate(TestRuleMarkFailure.java:47)
	  at org.apache.lucene.util.TestRuleIgnoreAfterMaxFailures$1.evaluate(TestRuleIgnoreAfterMaxFailures.java:64)
	  at org.apache.lucene.util.TestRuleIgnoreTestSuites$1.evaluate(TestRuleIgnoreTestSuites.java:54)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$StatementRunner.run(ThreadLeakControl.java:367)
	  at java.lang.Thread.run(Thread.java:745)
```

```
at org.apache.lucene.search.SloppyPhraseScorer.<init>(SloppyPhraseScorer.java:60)
at org.apache.lucene.search.PhraseQuery$PhraseWeight.scorer(PhraseQuery.java:442)
at org.apache.lucene.search.Weight.bulkScorer(Weight.java:135)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:667)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
at org.apache.lucene.search.TestPhraseQuery.testSlop1(TestPhraseQuery.java:148)
```

```
at org.apache.lucene.search.ConjunctionDISI.createConjunction(ConjunctionDISI.java:143)
	  at org.apache.lucene.search.ConjunctionDISI.intersectIterators(ConjunctionDISI.java:71)
	  at org.apache.lucene.search.SloppyPhraseScorer.<init>(SloppyPhraseScorer.java:72)
	  at org.apache.lucene.search.PhraseQuery$PhraseWeight.scorer(PhraseQuery.java:442)
	  at org.apache.lucene.search.Weight.bulkScorer(Weight.java:135)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:667)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
	  at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
	  at org.apache.lucene.search.TestPhraseQuery.testSlop1(TestPhraseQuery.java:148)
	  at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-1)
	  at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	  at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	  at java.lang.reflect.Method.invoke(Method.java:497)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner.invoke(RandomizedRunner.java:1764)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$8.evaluate(RandomizedRunner.java:871)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$9.evaluate(RandomizedRunner.java:907)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$10.evaluate(RandomizedRunner.java:921)
	  at org.apache.lucene.util.TestRuleSetupTeardownChained$1.evaluate(TestRuleSetupTeardownChained.java:49)
	  at org.apache.lucene.util.AbstractBeforeAfterRule$1.evaluate(AbstractBeforeAfterRule.java:45)
	  at org.apache.lucene.util.TestRuleThreadAndTestName$1.evaluate(TestRuleThreadAndTestName.java:48)
	  at org.apache.lucene.util.TestRuleIgnoreAfterMaxFailures$1.evaluate(TestRuleIgnoreAfterMaxFailures.java:64)
	  at org.apache.lucene.util.TestRuleMarkFailure$1.evaluate(TestRuleMarkFailure.java:47)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$StatementRunner.run(ThreadLeakControl.java:367)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl.forkTimeoutingTask(ThreadLeakControl.java:809)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$3.evaluate(ThreadLeakControl.java:460)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner.runSingleTest(RandomizedRunner.java:880)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$5.evaluate(RandomizedRunner.java:781)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$6.evaluate(RandomizedRunner.java:816)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$7.evaluate(RandomizedRunner.java:827)
	  at org.apache.lucene.util.AbstractBeforeAfterRule$1.evaluate(AbstractBeforeAfterRule.java:45)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at org.apache.lucene.util.TestRuleStoreClassName$1.evaluate(TestRuleStoreClassName.java:41)
	  at com.carrotsearch.randomizedtesting.rules.NoShadowingOrOverridesOnMethodsRule$1.evaluate(NoShadowingOrOverridesOnMethodsRule.java:40)
	  at com.carrotsearch.randomizedtesting.rules.NoShadowingOrOverridesOnMethodsRule$1.evaluate(NoShadowingOrOverridesOnMethodsRule.java:40)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at org.apache.lucene.util.TestRuleAssertionsRequired$1.evaluate(TestRuleAssertionsRequired.java:53)
	  at org.apache.lucene.util.TestRuleMarkFailure$1.evaluate(TestRuleMarkFailure.java:47)
	  at org.apache.lucene.util.TestRuleIgnoreAfterMaxFailures$1.evaluate(TestRuleIgnoreAfterMaxFailures.java:64)
	  at org.apache.lucene.util.TestRuleIgnoreTestSuites$1.evaluate(TestRuleIgnoreTestSuites.java:54)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$StatementRunner.run(ThreadLeakControl.java:367)
	  at java.lang.Thread.run(Thread.java:745)
```

ConjunctionDISI初始化

```
at org.apache.lucene.search.ConjunctionDISI.<init>(ConjunctionDISI.java:179)
	  at org.apache.lucene.search.ConjunctionDISI.createConjunction(ConjunctionDISI.java:161)
	  at org.apache.lucene.search.ConjunctionDISI.intersectIterators(ConjunctionDISI.java:71)
	  at org.apache.lucene.search.SloppyPhraseScorer.<init>(SloppyPhraseScorer.java:72)
	  at org.apache.lucene.search.PhraseQuery$PhraseWeight.scorer(PhraseQuery.java:442)
	  at org.apache.lucene.search.Weight.bulkScorer(Weight.java:135)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:667)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
	  at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
	  at org.apache.lucene.search.TestPhraseQuery.testSlop1(TestPhraseQuery.java:148)
	  at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-1)
	  at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	  at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	  at java.lang.reflect.Method.invoke(Method.java:497)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner.invoke(RandomizedRunner.java:1764)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$8.evaluate(RandomizedRunner.java:871)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$9.evaluate(RandomizedRunner.java:907)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$10.evaluate(RandomizedRunner.java:921)
	  at org.apache.lucene.util.TestRuleSetupTeardownChained$1.evaluate(TestRuleSetupTeardownChained.java:49)
	  at org.apache.lucene.util.AbstractBeforeAfterRule$1.evaluate(AbstractBeforeAfterRule.java:45)
	  at org.apache.lucene.util.TestRuleThreadAndTestName$1.evaluate(TestRuleThreadAndTestName.java:48)
	  at org.apache.lucene.util.TestRuleIgnoreAfterMaxFailures$1.evaluate(TestRuleIgnoreAfterMaxFailures.java:64)
	  at org.apache.lucene.util.TestRuleMarkFailure$1.evaluate(TestRuleMarkFailure.java:47)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$StatementRunner.run(ThreadLeakControl.java:367)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl.forkTimeoutingTask(ThreadLeakControl.java:809)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$3.evaluate(ThreadLeakControl.java:460)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner.runSingleTest(RandomizedRunner.java:880)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$5.evaluate(RandomizedRunner.java:781)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$6.evaluate(RandomizedRunner.java:816)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$7.evaluate(RandomizedRunner.java:827)
	  at org.apache.lucene.util.AbstractBeforeAfterRule$1.evaluate(AbstractBeforeAfterRule.java:45)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at org.apache.lucene.util.TestRuleStoreClassName$1.evaluate(TestRuleStoreClassName.java:41)
	  at com.carrotsearch.randomizedtesting.rules.NoShadowingOrOverridesOnMethodsRule$1.evaluate(NoShadowingOrOverridesOnMethodsRule.java:40)
	  at com.carrotsearch.randomizedtesting.rules.NoShadowingOrOverridesOnMethodsRule$1.evaluate(NoShadowingOrOverridesOnMethodsRule.java:40)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at org.apache.lucene.util.TestRuleAssertionsRequired$1.evaluate(TestRuleAssertionsRequired.java:53)
	  at org.apache.lucene.util.TestRuleMarkFailure$1.evaluate(TestRuleMarkFailure.java:47)
	  at org.apache.lucene.util.TestRuleIgnoreAfterMaxFailures$1.evaluate(TestRuleIgnoreAfterMaxFailures.java:64)
	  at org.apache.lucene.util.TestRuleIgnoreTestSuites$1.evaluate(TestRuleIgnoreTestSuites.java:54)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$StatementRunner.run(ThreadLeakControl.java:367)
	  at java.lang.Thread.run(Thread.java:745)
```

```
at org.apache.lucene.codecs.lucene50.Lucene50PostingsReader$BlockPostingsEnum.advance(Lucene50PostingsReader.java:666)
	  at org.apache.lucene.search.ConjunctionDISI.doNext(ConjunctionDISI.java:200)
	  at org.apache.lucene.search.ConjunctionDISI.nextDoc(ConjunctionDISI.java:240)
	  at org.apache.lucene.search.Weight$DefaultBulkScorer.scoreAll(Weight.java:227)
	  at org.apache.lucene.search.Weight$DefaultBulkScorer.score(Weight.java:172)
	  at org.apache.lucene.search.BulkScorer.score(BulkScorer.java:39)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:670)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
	  at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
	  at org.apache.lucene.search.TestPhraseQuery.testSlop1(TestPhraseQuery.java:148)
	  at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-1)
	  at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	  at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	  at java.lang.reflect.Method.invoke(Method.java:497)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner.invoke(RandomizedRunner.java:1764)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$8.evaluate(RandomizedRunner.java:871)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$9.evaluate(RandomizedRunner.java:907)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$10.evaluate(RandomizedRunner.java:921)
	  at org.apache.lucene.util.TestRuleSetupTeardownChained$1.evaluate(TestRuleSetupTeardownChained.java:49)
	  at org.apache.lucene.util.AbstractBeforeAfterRule$1.evaluate(AbstractBeforeAfterRule.java:45)
	  at org.apache.lucene.util.TestRuleThreadAndTestName$1.evaluate(TestRuleThreadAndTestName.java:48)
	  at org.apache.lucene.util.TestRuleIgnoreAfterMaxFailures$1.evaluate(TestRuleIgnoreAfterMaxFailures.java:64)
	  at org.apache.lucene.util.TestRuleMarkFailure$1.evaluate(TestRuleMarkFailure.java:47)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$StatementRunner.run(ThreadLeakControl.java:367)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl.forkTimeoutingTask(ThreadLeakControl.java:809)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$3.evaluate(ThreadLeakControl.java:460)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner.runSingleTest(RandomizedRunner.java:880)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$5.evaluate(RandomizedRunner.java:781)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$6.evaluate(RandomizedRunner.java:816)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$7.evaluate(RandomizedRunner.java:827)
	  at org.apache.lucene.util.AbstractBeforeAfterRule$1.evaluate(AbstractBeforeAfterRule.java:45)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at org.apache.lucene.util.TestRuleStoreClassName$1.evaluate(TestRuleStoreClassName.java:41)
	  at com.carrotsearch.randomizedtesting.rules.NoShadowingOrOverridesOnMethodsRule$1.evaluate(NoShadowingOrOverridesOnMethodsRule.java:40)
	  at com.carrotsearch.randomizedtesting.rules.NoShadowingOrOverridesOnMethodsRule$1.evaluate(NoShadowingOrOverridesOnMethodsRule.java:40)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at org.apache.lucene.util.TestRuleAssertionsRequired$1.evaluate(TestRuleAssertionsRequired.java:53)
	  at org.apache.lucene.util.TestRuleMarkFailure$1.evaluate(TestRuleMarkFailure.java:47)
	  at org.apache.lucene.util.TestRuleIgnoreAfterMaxFailures$1.evaluate(TestRuleIgnoreAfterMaxFailures.java:64)
	  at org.apache.lucene.util.TestRuleIgnoreTestSuites$1.evaluate(TestRuleIgnoreTestSuites.java:54)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$StatementRunner.run(ThreadLeakControl.java:367)
	  at java.lang.Thread.run(Thread.java:745)
```

```
at org.apache.lucene.codecs.lucene50.Lucene50PostingsReader$BlockPostingsEnum.advance(Lucene50PostingsReader.java:666)
	  at org.apache.lucene.search.ConjunctionDISI.doNext(ConjunctionDISI.java:200)
	  at org.apache.lucene.search.ConjunctionDISI.advance(ConjunctionDISI.java:230)
	  at org.apache.lucene.search.TwoPhaseIterator$TwoPhaseIteratorAsDocIdSetIterator.advance(TwoPhaseIterator.java:82)
	  at org.apache.lucene.search.QueryUtils$4.collect(QueryUtils.java:490)
	  at org.apache.lucene.search.Weight$DefaultBulkScorer.scoreAll(Weight.java:229)
	  at org.apache.lucene.search.Weight$DefaultBulkScorer.score(Weight.java:172)
	  at org.apache.lucene.search.BulkScorer.score(BulkScorer.java:39)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:670)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
	  at org.apache.lucene.search.QueryUtils.checkFirstSkipTo(QueryUtils.java:475)
	  at org.apache.lucene.search.QueryUtils.check(QueryUtils.java:124)
	  at org.apache.lucene.search.QueryUtils.check(QueryUtils.java:118)
	  at org.apache.lucene.search.TestPhraseQuery.testSlop1(TestPhraseQuery.java:150)
	  at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-1)
	  at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	  at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	  at java.lang.reflect.Method.invoke(Method.java:497)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner.invoke(RandomizedRunner.java:1764)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$8.evaluate(RandomizedRunner.java:871)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$9.evaluate(RandomizedRunner.java:907)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$10.evaluate(RandomizedRunner.java:921)
	  at org.apache.lucene.util.TestRuleSetupTeardownChained$1.evaluate(TestRuleSetupTeardownChained.java:49)
	  at org.apache.lucene.util.AbstractBeforeAfterRule$1.evaluate(AbstractBeforeAfterRule.java:45)
	  at org.apache.lucene.util.TestRuleThreadAndTestName$1.evaluate(TestRuleThreadAndTestName.java:48)
	  at org.apache.lucene.util.TestRuleIgnoreAfterMaxFailures$1.evaluate(TestRuleIgnoreAfterMaxFailures.java:64)
	  at org.apache.lucene.util.TestRuleMarkFailure$1.evaluate(TestRuleMarkFailure.java:47)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$StatementRunner.run(ThreadLeakControl.java:367)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl.forkTimeoutingTask(ThreadLeakControl.java:809)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$3.evaluate(ThreadLeakControl.java:460)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner.runSingleTest(RandomizedRunner.java:880)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$5.evaluate(RandomizedRunner.java:781)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$6.evaluate(RandomizedRunner.java:816)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$7.evaluate(RandomizedRunner.java:827)
	  at org.apache.lucene.util.AbstractBeforeAfterRule$1.evaluate(AbstractBeforeAfterRule.java:45)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at org.apache.lucene.util.TestRuleStoreClassName$1.evaluate(TestRuleStoreClassName.java:41)
	  at com.carrotsearch.randomizedtesting.rules.NoShadowingOrOverridesOnMethodsRule$1.evaluate(NoShadowingOrOverridesOnMethodsRule.java:40)
	  at com.carrotsearch.randomizedtesting.rules.NoShadowingOrOverridesOnMethodsRule$1.evaluate(NoShadowingOrOverridesOnMethodsRule.java:40)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at org.apache.lucene.util.TestRuleAssertionsRequired$1.evaluate(TestRuleAssertionsRequired.java:53)
	  at org.apache.lucene.util.TestRuleMarkFailure$1.evaluate(TestRuleMarkFailure.java:47)
	  at org.apache.lucene.util.TestRuleIgnoreAfterMaxFailures$1.evaluate(TestRuleIgnoreAfterMaxFailures.java:64)
	  at org.apache.lucene.util.TestRuleIgnoreTestSuites$1.evaluate(TestRuleIgnoreTestSuites.java:54)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$StatementRunner.run(ThreadLeakControl.java:367)
	  at java.lang.Thread.run(Thread.java:745)
```



PhrasePositions

构建时基于短语中的一个词，短语中每个词建立了一个PhrasePositions实例。

传入的参数例子

```
postings = {org.apache.lucene.codecs.lucene50.Lucene50PostingsReader$BlockPostingsEnum@2448} 
o = 0
o为词在短语中的位置
ord = 0 o为词在短语中的所有词中的序号。默认情况下o与ord是一致的。在调用org.apache.lucene.search.PhraseQuery#rewrite方法后可能这两者不一致了。
terms = {org.apache.lucene.index.Term[1]@2479} 
```

管理一个词在文档中的位置，一个词在文档重复出现多次，就会有多个位置。PhrasePositions实例的某个内部状态表示一个词在文档中的一个位置。同时存储了这个词在查询短语中的位置。

position：词在文档中的位置减去词在短语中的位置。
count：文档中剩余的词位置个数，PhrasePositions会不停地迭代位置。用词频进行初始化。
offset：词在短语中的位置。
ord：当前PhrasePositions实例在所有PhrasePositions中的序号。
postings：文档集词在每个文档中的位置列表枚举器。
next：指向下一个PhrasePositions。
rptGroup：>=0表示这是一个重复的PhrasePositions。
rptInd：rptGroup中的索引。
terms：用于重复项初始化。

PhrasePositions初始化过程代码调用链路
```
at org.apache.lucene.search.PhrasePositions.<init>(PhrasePositions.java:38)
at org.apache.lucene.search.SloppyPhraseScorer.<init>(SloppyPhraseScorer.java:70)
at org.apache.lucene.search.PhraseQuery$PhraseWeight.scorer(PhraseQuery.java:442)
at org.apache.lucene.search.Weight.bulkScorer(Weight.java:135)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:667)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
at org.apache.lucene.search.TestPhraseQuery.testMultipleTerms(TestPhraseQuery.java:185)
at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-1)
at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
at java.lang.reflect.Method.invoke(Method.java:497)

```


SloppyPhraseScorer -(依赖)-> PhrasePositions
SloppyPhraseScorer -(依赖)-> PhraseQueue
SloppyPhraseScorer -(依赖)-> ConjunctionDISI
SloppyPhraseScorer -(依赖)-> org.apache.lucene.search.PhraseQuery.PhraseWeight
SloppyPhraseScorer -(依赖)-> org.apache.lucene.search.similarities.BM25Similarity.BM25DocScorer

TwoPhaseIterator

用一个DocIdSetIterator作为一个近似精确迭代器。近似是指可能迭代出来的id不是满足要求的。

对近似精准迭代器DocIdSetIterator迭代出来的id，使用TwoPhaseIterator的matches方法校验是否满足要求。

TwoPhaseIterator的public static DocIdSetIterator asDocIdSetIterator(TwoPhaseIterator twoPhaseIterator)方法将一个TwoPhaseIterator迭代器转换成一个DocIdSetIterator迭代器，DocIdSetIterator迭代器的具体实现类为TwoPhaseIteratorAsDocIdSetIterator。



ConjunctionTwoPhaseIterator -(继承)-> TwoPhaseIterator
org.apache.lucene.search.ConjunctionDISI.ConjunctionTwoPhaseIterator

org.apache.lucene.search.SloppyPhraseScorer#twoPhaseIterator

SloppyPhraseScorer使用org.apache.lucene.search.SloppyPhraseScorer#twoPhaseIterator
方法创建一个匿名内部类TwoPhaseIterator，以ConjunctionDISI类方法创建的DocIdSetIterator作为TwoPhaseIterator的近似精准迭代器。

SloppyPhraseScorer通过ConjunctionDISI的public static DocIdSetIterator intersectIterators(List<DocIdSetIterator> iterators)方法创建DocIdSetIterator

org.apache.lucene.search.ConjunctionDISI.BitSetConjunctionDISI
org.apache.lucene.search.ConjunctionDISI.ConjunctionTwoPhaseIterator



org.apache.lucene.search.IndexSearcher#search(java.util.List<org.apache.lucene.index.LeafReaderContext>, org.apache.lucene.search.Weight, org.apache.lucene.search.Collector)
使用org.apache.lucene.search.PhraseQuery.PhraseWeight创建DefaultBulkScorer
 |
\|/
DefaultBulkScorer
org.apache.lucene.search.Weight#bulkScorer方法使用org.apache.lucene.search.PhraseQuery.PhraseWeight#scorer创建SloppyPhraseScorer或ExactPhraseScorer
 |
\|/
SloppyPhraseScorer或ExactPhraseScorer
 |
\|/
DocIdSetIterator（具体类TwoPhaseIteratorAsDocIdSetIterator）
 |
\|/
匿名内部类TwoPhaseIterator（org.apache.lucene.search.SloppyPhraseScorer#twoPhaseIterator创建）
 |
\|/
DocIdSetIterator（org.apache.lucene.search.ConjunctionDISI#intersectIterators方法创建）
 |
\|/
DocIdSetIterator，DocIdSetIterator，DocIdSetIterator...
 |
\|/
PostingsAndFreq
 |
\|/
PostingsEnum



短语的match校验过程
对近似精准迭代器DocIdSetIterator迭代出来的id，使用TwoPhaseIterator的matches方法校验是否满足要求。


```
at org.apache.lucene.search.PhrasePositions.nextPosition(PhrasePositions.java:56)
	  at org.apache.lucene.search.PhrasePositions.firstPosition(PhrasePositions.java:46)
	  at org.apache.lucene.search.SloppyPhraseScorer.placeFirstPositions(SloppyPhraseScorer.java:264)
	  at org.apache.lucene.search.SloppyPhraseScorer.initFirstTime(SloppyPhraseScorer.java:339)
	  at org.apache.lucene.search.SloppyPhraseScorer.initPhrasePositions(SloppyPhraseScorer.java:227)
	  at org.apache.lucene.search.SloppyPhraseScorer.phraseFreq(SloppyPhraseScorer.java:96)
	  at org.apache.lucene.search.SloppyPhraseScorer.access$100(SloppyPhraseScorer.java:32)
	  at org.apache.lucene.search.SloppyPhraseScorer$2.matches(SloppyPhraseScorer.java:568)
	  at org.apache.lucene.search.Weight$DefaultBulkScorer.scoreAll(Weight.java:228)
	  at org.apache.lucene.search.Weight$DefaultBulkScorer.score(Weight.java:172)
	  at org.apache.lucene.search.BulkScorer.score(BulkScorer.java:39)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:670)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
	  at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
	  at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
	  at org.apache.lucene.search.TestPhraseQuery.testSlop1(TestPhraseQuery.java:148)
	  at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-1)
	  at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	  at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	  at java.lang.reflect.Method.invoke(Method.java:497)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner.invoke(RandomizedRunner.java:1764)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$8.evaluate(RandomizedRunner.java:871)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$9.evaluate(RandomizedRunner.java:907)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$10.evaluate(RandomizedRunner.java:921)
	  at org.apache.lucene.util.TestRuleSetupTeardownChained$1.evaluate(TestRuleSetupTeardownChained.java:49)
	  at org.apache.lucene.util.AbstractBeforeAfterRule$1.evaluate(AbstractBeforeAfterRule.java:45)
	  at org.apache.lucene.util.TestRuleThreadAndTestName$1.evaluate(TestRuleThreadAndTestName.java:48)
	  at org.apache.lucene.util.TestRuleIgnoreAfterMaxFailures$1.evaluate(TestRuleIgnoreAfterMaxFailures.java:64)
	  at org.apache.lucene.util.TestRuleMarkFailure$1.evaluate(TestRuleMarkFailure.java:47)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$StatementRunner.run(ThreadLeakControl.java:367)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl.forkTimeoutingTask(ThreadLeakControl.java:809)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$3.evaluate(ThreadLeakControl.java:460)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner.runSingleTest(RandomizedRunner.java:880)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$5.evaluate(RandomizedRunner.java:781)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$6.evaluate(RandomizedRunner.java:816)
	  at com.carrotsearch.randomizedtesting.RandomizedRunner$7.evaluate(RandomizedRunner.java:827)
	  at org.apache.lucene.util.AbstractBeforeAfterRule$1.evaluate(AbstractBeforeAfterRule.java:45)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at org.apache.lucene.util.TestRuleStoreClassName$1.evaluate(TestRuleStoreClassName.java:41)
	  at com.carrotsearch.randomizedtesting.rules.NoShadowingOrOverridesOnMethodsRule$1.evaluate(NoShadowingOrOverridesOnMethodsRule.java:40)
	  at com.carrotsearch.randomizedtesting.rules.NoShadowingOrOverridesOnMethodsRule$1.evaluate(NoShadowingOrOverridesOnMethodsRule.java:40)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at org.apache.lucene.util.TestRuleAssertionsRequired$1.evaluate(TestRuleAssertionsRequired.java:53)
	  at org.apache.lucene.util.TestRuleMarkFailure$1.evaluate(TestRuleMarkFailure.java:47)
	  at org.apache.lucene.util.TestRuleIgnoreAfterMaxFailures$1.evaluate(TestRuleIgnoreAfterMaxFailures.java:64)
	  at org.apache.lucene.util.TestRuleIgnoreTestSuites$1.evaluate(TestRuleIgnoreTestSuites.java:54)
	  at com.carrotsearch.randomizedtesting.rules.StatementAdapter.evaluate(StatementAdapter.java:36)
	  at com.carrotsearch.randomizedtesting.ThreadLeakControl$StatementRunner.run(ThreadLeakControl.java:367)
	  at java.lang.Thread.run(Thread.java:745)
```


构造PhraseQuery

调用链路

```
org.apache.lucene.search.TestPhraseQuery#testMultipleTerms
org.apache.lucene.search.PhraseQuery#PhraseQuery(int, java.lang.String, java.lang.String...)
org.apache.lucene.search.PhraseQuery#PhraseQuery(int, org.apache.lucene.index.Term[], int[])
```

文档

doc = one two three four five

query = field:"one three five"~2

```
this.slop=2

this.terms = {org.apache.lucene.index.Term[3]@1969} 
 0 = {org.apache.lucene.index.Term@2001} "field:one"
 1 = {org.apache.lucene.index.Term@2002} "field:three"
 2 = {org.apache.lucene.index.Term@2009} "field:five"

this.positions = {int[3]@1970} 
 0 = 0
 1 = 1
 2 = 2

this.field = "field"
```

构造scorer

调用链路

```
at org.apache.lucene.search.PhraseQuery$PhraseWeight.scorer(PhraseQuery.java:401)
at org.apache.lucene.search.Weight.bulkScorer(Weight.java:135)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:667)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
at org.apache.lucene.search.TestPhraseQuery.testMultipleTerms(TestPhraseQuery.java:185)
```


对每个词，scorer方法会在词典中找查询词的位置

```
at org.apache.lucene.codecs.blocktree.SegmentTermsEnum.seekExact(SegmentTermsEnum.java:1010)
at org.apache.lucene.search.PhraseQuery$PhraseWeight.scorer(PhraseQuery.java:425)
at org.apache.lucene.search.Weight.bulkScorer(Weight.java:135)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:667)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
at org.apache.lucene.search.TestPhraseQuery.testMultipleTerms(TestPhraseQuery.java:185)
```

在词典中找到词之后，获取其倒排索引文档列表

```
at org.apache.lucene.codecs.blocktree.SegmentTermsEnum.postings(SegmentTermsEnum.java:994)
at org.apache.lucene.search.PhraseQuery$PhraseWeight.scorer(PhraseQuery.java:426)
at org.apache.lucene.search.Weight.bulkScorer(Weight.java:135)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:667)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
at org.apache.lucene.search.TestPhraseQuery.testMultipleTerms(TestPhraseQuery.java:185)
```

将词本身，词在短语中位置，词对应的倒排索引文档列表综合到一起，构造PostingsAndFreq

使用org.apache.lucene.search.PhraseQuery$PhraseWeight、org.apache.lucene.search.PhraseQuery$PostingsAndFreq[3]、slop、org.apache.lucene.search.similarities.BM25Similarity$BM25DocScorer、needsScores、matchCost构造SloppyPhraseScorer

代码调用链路

```
at org.apache.lucene.search.SloppyPhraseScorer.<init>(SloppyPhraseScorer.java:60)
at org.apache.lucene.search.PhraseQuery$PhraseWeight.scorer(PhraseQuery.java:442)
at org.apache.lucene.search.Weight.bulkScorer(Weight.java:135)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:667)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:474)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:593)
at org.apache.lucene.search.IndexSearcher.searchAfter(IndexSearcher.java:451)
at org.apache.lucene.search.IndexSearcher.search(IndexSearcher.java:462)
at org.apache.lucene.search.TestPhraseQuery.testMultipleTerms(TestPhraseQuery.java:185)
```

ConjunctionDISI -（继承）-> DocIdSetIterator

ConjunctionDISI.BitSetConjunctionDISI -（继承）-> DocIdSetIterator

ConjunctionDISI.ConjunctionTwoPhaseIterator  -（继承）-> TwoPhaseIterator

TwoPhaseIterator.TwoPhaseIteratorAsDocIdSetIterator -（继承）-> DocIdSetIterator


private static DocIdSetIterator createConjunction(
      List<DocIdSetIterator> allIterators,
      List<TwoPhaseIterator> twoPhaseIterators);

将allIterators分成两份，一份cost大于minCost且类型为BitSetIterator的迭代器放入bitSetIterators，剩余的另一份放入iterators。

BitSetConjunctionDISI disi-(构造方法接收依赖)-> ConjunctionDISI disi -(构造方法接收依赖)-> List<DocIdSetIterator> iterators

List<BitSetIterator> bitSetIterators

List<TwoPhaseIterator> twoPhaseIterators

ConjunctionTwoPhaseIterator

TwoPhaseIteratorAsDocIdSetIterator

