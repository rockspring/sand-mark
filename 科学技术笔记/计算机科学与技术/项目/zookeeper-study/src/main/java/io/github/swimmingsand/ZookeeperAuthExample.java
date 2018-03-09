package io.github.swimmingsand;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 4/2/16.
 */
public class ZookeeperAuthExample {
    public static void main(String[] args) throws Exception {
        final ZooKeeper zooKeeper = new ZooKeeper("localhost:2182", 100000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getState());
            }
        });
        while (zooKeeper.getState() != ZooKeeper.States.CONNECTED) {
            TimeUnit.SECONDS.sleep(1);
        }

        zooKeeper.addAuthInfo("digest", "leqinzhou:pass".getBytes());

        System.out.println("getChildren(String path, boolean watch)");
        List<String> children = zooKeeper.getChildren("/", false);
        for (String child : children) {
            System.out.println(child);
            Stat stat = new Stat();

            byte[] data = zooKeeper.getData("/" + child, true, stat);
            System.out.println(data.length);
        }

        zooKeeper.close();

        SortedSet<String> sortedNames = new TreeSet<String>();
        sortedNames.headSet("a");
    }
}
