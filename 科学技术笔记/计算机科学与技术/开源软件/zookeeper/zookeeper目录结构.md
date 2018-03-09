dataDir=/data1/data/zookeeper/zk-cluster-2181
dataLogDir=/data1/logs/zookeeper/zk-cluster-2181


/data1/logs/zookeeper/zk-cluster-2181
├── gc.log.0.current
├── version-2
│   ├── log.10019bcca
│   ├── log.1001b213c
│   ├── log.1001c4f50
│   └── log.1001d739c
├── zookeeper.log
├── zookeeper.log.2015-11-17


work@tjtx-97-143:/data1/data/zookeeper$ tree
.
└── zk-cluster-2181
    ├── myid
    ├── version-2
    │   ├── acceptedEpoch
    │   ├── currentEpoch
    │   ├── snapshot.1001b213a
    │   ├── snapshot.1001c4f4f
    │   └── snapshot.1001d739b
    └── zookeeper_server.pid

acceptedEpoch=1
currentEpoch=1
