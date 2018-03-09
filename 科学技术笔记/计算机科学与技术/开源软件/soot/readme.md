# soot

```
java -cp sootclasses-trunk-jar-with-dependencies.jar soot.tools.CFGViewer --soot-classpath .:"$JAVA_HOME"/jre/lib/rt.jar:/Users/zlq/Servers/solr-7.2.0/server/solr-webapp/webapp/WEB-INF/lib/lucene-core-7.2.0.jar org.apache.lucene.util.bkd.BKDReader

dot -Tpng -o BKDReader.intersect.png sootOutput/org.apache.lucene.util.bkd.BKDReader\ void\ intersect\(org.apache.lucene.util.bkd.BKDReader\$IntersectState\,byte\[\]\,byte\[\]\).dot

dot -Tgif -o BKDReader.intersect.gif sootOutput/org.apache.lucene.util.bkd.BKDReader\ void\ intersect\(org.apache.lucene.util.bkd.BKDReader\$IntersectState\,byte\[\]\,byte\[\]\).dot
```