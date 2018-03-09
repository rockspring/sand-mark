zlq@Apples-MacBook-Pro-2:zookeeper-3.4.6-server-001$ java -cp lib/log4j-1.2.16.jar:lib/slf4j-api-1.6.1.jar:lib/slf4j-log4j12-1.6.1.jar:zookeeper-3.4.6.jar org.apache.zookeeper.server.auth.DigestAuthenticationProvider leqinzhou:zlq2016
leqinzhou:zlq2016->leqinzhou:a5O0YYWmkQUokRTM6atmbG/mPa8=



[zk: localhost:2181(CONNECTED) 1] create /mynode content digest:leqinzhou:a5O0YYWmkQUokRTM6atmbG/mPa8=:cdrwa
Created /mynode


[zk: localhost:2181(CONNECTED) 2] getAcl /mynode
'digest,'leqinzhou:a5O0YYWmkQUokRTM6atmbG/mPa8=
: cdrwa
