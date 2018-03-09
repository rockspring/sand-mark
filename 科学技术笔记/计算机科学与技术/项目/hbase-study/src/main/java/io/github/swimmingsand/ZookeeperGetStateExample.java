package io.github.swimmingsand;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 3/30/16.
 */
public class ZookeeperGetStateExample {
    public static void main(String[] args) throws Exception {
        final ZooKeeper zooKeeper = new ZooKeeper("localhost:2182", 100000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getState());
            }
        });
        ZooKeeper.States states = zooKeeper.getState();
        System.out.println(states.name());
        TimeUnit.SECONDS.sleep(1);
        states = zooKeeper.getState();
        System.out.println(states.name());
        zooKeeper.close();
    }
}
