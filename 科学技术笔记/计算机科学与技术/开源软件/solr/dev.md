使用maven构建

## solr4.7.2

ant ivy-bootstrap

ant -Dversion=4.7.2 get-maven-poms

cp -r maven-build/ .


mvn -U idea:idea

import project

# solr-4.9.0

移除/Users/zlq/Projects/oss/solr/solr-4.9.0/lucene/tools/forbiddenApis/rue.txt配置

https://issues.apache.org/jira/browse/LUCENE-5757


solr-4.10.1

cd solr-4.10.1

ant idea

使用IntelliJ IDEA打开项目

cd solr

ant dist

cp /Users/zlq/Projects/oss/solr/solr-4.10.1/solr/dist/solr-4.10.1-SNAPSHOT.war example/solr/solr.war

cd example

java -jar start.jar

## solr4.10.2

ant ivy-bootstrap

ant get-maven-poms

cd maven-build/

cp -r . ../

使用IntelliJ IDEA打开项目
