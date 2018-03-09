# neo4j

```
cd neo4j
mvn clean install


cd /Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT

bin/neo4j start

/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home/bin/java -cp /Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT/plugins:/Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT/conf:/Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT/lib/*:/Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT/plugins/*:/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home/lib/tools.jar -server -XX:+UseG1GC -XX:-OmitStackTraceInFastThrow -XX:+AlwaysPreTouch -XX:+UnlockExperimentalVMOptions -XX:+TrustFinalNonStaticFields -XX:+DisableExplicitGC -Djdk.tls.ephemeralDHKeySize=2048 -Djdk.tls.rejectClientInitiatedRenegotiation=true -Dunsupported.dbms.udc.source=tarball -Dfile.encoding=UTF-8 org.neo4j.server.CommunityEntryPoint --home-dir=/Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT --config-dir=/Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT/conf
```

```
Active database: graph.db
Directories in use:
  home:         /Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT
  config:       /Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT/conf
  logs:         /Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT/logs
  plugins:      /Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT/plugins
  import:       /Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT/import
  data:         /Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT/data
  certificates: /Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT/certificates
  run:          /Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT/run
Starting Neo4j.
Started neo4j (pid 36626). It is available at http://localhost:7474/
There may be a short delay until the server is ready.
See /Users/zlq/Projects/oss/BigData/neo4j/packaging/standalone/target/neo4j-community-3.4.0-SNAPSHOT/logs/neo4j.log for current status.
```