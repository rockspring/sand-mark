package io.github.swimmingsand;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 3/30/16.
 */
public class ZookeeperSyncExample {
    public static void main(String[] args) throws Exception {
        final ZooKeeper zooKeeper = new ZooKeeper("localhost:2182", 100000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getState());
            }
        });
        System.out.println(zooKeeper.toString());
        Map<String, String> ctx = new HashMap<String, String>();
        zooKeeper.sync("/", new AsyncCallback.VoidCallback() {
            public void processResult(int rc, String path, Object ctx) {
                System.out.println("rc=" + rc);
                System.out.println("path=" + path);
                System.out.println("ctx=" + ctx);

            }
        }, ctx);

        TimeUnit.SECONDS.sleep(1);
        System.out.println(zooKeeper.toString());

        zooKeeper.close();
    }
}
