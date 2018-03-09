package io.github.swimmingsand;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 3/30/16.
 */
public class ZookeeperTransactionExample {
    public static void main(String[] args) throws Exception {
        final ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 100000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getState());
            }
        });
        while (zooKeeper.getState() != ZooKeeper.States.CONNECTED) {
            TimeUnit.SECONDS.sleep(1);
        }

        Transaction transaction = zooKeeper.transaction();

        transaction.create("/test","test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        List<OpResult> opResults = transaction.commit();
        for (OpResult opResult : opResults) {
            OpResult.CreateResult createResult = (OpResult.CreateResult)opResult;
            System.out.println(createResult.getType());
            System.out.println(createResult.getPath());
        }

        Stat stat = new Stat();

        byte[] data = zooKeeper.getData("/test", false, stat);
        int version = stat.getVersion();
        System.out.println("version=" + version);
        System.out.println("data=" + new String(data));


        transaction = zooKeeper.transaction();
        transaction.check("/test", version);
        transaction.setData("/test", "data".getBytes(), version);
        transaction.commit();

        data = zooKeeper.getData("/test", false, stat);
        version = stat.getVersion();
        System.out.println("version=" + version);
        System.out.println("data=" + new String(data));

        transaction = zooKeeper.transaction();
        transaction.delete("/test", version);
        transaction.commit();

        zooKeeper.close();
    }
}
