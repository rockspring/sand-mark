package io.github.swimmingsand;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 3/30/16.
 */
public class ZookeeperExistsExample4 {
    public static void main(String[] args) throws Exception {
        final ZooKeeper zooKeeper = new ZooKeeper("localhost:2182", 100000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getState());
            }
        });
        while (zooKeeper.getState() != ZooKeeper.States.CONNECTED) {
            TimeUnit.SECONDS.sleep(1);
        }

        //public void exists(String path, boolean watch, StatCallback cb, Object ctx)

        Stat stat = new Stat();
        Map<String, String> ctx = new HashMap<String, String>();
        zooKeeper.exists("/", false, new AsyncCallback.StatCallback() {
            public void processResult(int rc, String path, Object ctx, Stat stat) {
                System.out.println("rc=" + rc);
                System.out.println("path=" + path);
                System.out.println("ctx=" + ctx);
            }
        }, ctx);

        zooKeeper.exists("/test", false, new AsyncCallback.StatCallback() {
            public void processResult(int rc, String path, Object ctx, Stat stat) {
                System.out.println("rc=" + rc);
                System.out.println("path=" + path);
                System.out.println("ctx=" + ctx);
            }
        }, ctx);


        zooKeeper.close();
    }
}
