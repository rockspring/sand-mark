package io.github.swimmingsand;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 3/30/16.
 */
public class ZookeeperMultiExample {
    public static void main(String[] args) throws Exception {
        final ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 100000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getState());
            }
        });
        while (zooKeeper.getState() != ZooKeeper.States.CONNECTED) {
            TimeUnit.SECONDS.sleep(1);
        }

        Map<String, String> ctx = new HashMap<String, String>();
        List<Op> multiOp = new ArrayList<Op>();
        multiOp.add(Op.create("/test","test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT));
        zooKeeper.multi(multiOp, new AsyncCallback.MultiCallback() {
            public void processResult(int rc, String path, Object ctx, List<OpResult> opResults) {
                System.out.println("rc=" + rc);
                System.out.println("path=" + path);
                System.out.println("ctx=" + ctx);
                for (OpResult opResult : opResults) {
                    OpResult.CreateResult createResult = (OpResult.CreateResult)opResult;
                    System.out.println(createResult.getType());
                    System.out.println(createResult.getPath());
                }
            }
        }, ctx);
        Stat stat = new Stat();

        byte[] data = zooKeeper.getData("/test", false, stat);
        int version = stat.getVersion();
        System.out.println("version=" + version);
        System.out.println("data=" + new String(data));

        multiOp.clear();
        multiOp.add(Op.check("/test", version));
        multiOp.add(Op.setData("/test", "data".getBytes(), version));
        zooKeeper.multi(multiOp, new AsyncCallback.MultiCallback() {
            public void processResult(int rc, String path, Object ctx, List<OpResult> opResults) {
                System.out.println("rc=" + rc);
                System.out.println("path=" + path);
                System.out.println("ctx=" + ctx);
                for (OpResult opResult : opResults) {
                    OpResult.CheckResult createResult = (OpResult.CheckResult)opResult;
                    System.out.println(createResult.getType());
                }
            }
        }, ctx);

        data = zooKeeper.getData("/test", false, stat);
        version = stat.getVersion();
        System.out.println("version=" + version);
        System.out.println("data=" + new String(data));

        zooKeeper.delete("/test", version);

        zooKeeper.close();
    }
}
