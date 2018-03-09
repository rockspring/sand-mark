package io.github.swimmingsand.readonly;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 4/11/16.
 */

public class ZookeeperExistsExample1 {
    public static void main(String[] args) throws Exception {
        final ZooKeeper zooKeeper = new ZooKeeper("localhost:2183", 100000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getState());
            }
        }, true);
        while (zooKeeper.getState() != ZooKeeper.States.CONNECTEDREADONLY) {
            TimeUnit.SECONDS.sleep(1);
        }

        //public Stat exists(final String path, Watcher watcher) throws KeeperException, InterruptedException

        Stat stat = new Stat();
        stat = zooKeeper.exists("/", new Watcher() {
            public void process(WatchedEvent event) {

            }
        });

        if (null != stat) {
            System.out.println(stat.getVersion());
        } else {
            System.out.println("不存在");
        }

        /*stat = zooKeeper.exists("/test", new Watcher() {
            public void process(WatchedEvent event) {

            }
        });

        if (null != stat) {
            System.out.println(stat.getVersion());
        } else {
            System.out.println("不存在");
        }*/

        zooKeeper.close();
    }
}
