mvn package

cd /home/www/release/wordcount-hadoop1.x

hadoop dfs -put file01 /tmp/zlq/example/input

hadoop dfs -put file02 /tmp/zlq/example/input




cd /home/www/release/wordcount-hadoop1.x/target

hadoop dfs -rmr /tmp/zlq/example/output

需要使用GenericOptionsParser处理-fs -jt参数

hadoop jar wordcount-hadoop1.x-1.0-SNAPSHOT.jar -fs 10.10.6.99:8020 -jt 10.10.6.99:8021 /tmp/zlq/example/input /tmp/zlq/example/output

hadoop jar wordcount-hadoop1.x-1.0-SNAPSHOT.jar /tmp/zlq/example/input /tmp/zlq/example/output

hadoop dfs -ls /tmp/zlq/example/output

hadoop dfs -cat /tmp/zlq/example/output/part-00000

