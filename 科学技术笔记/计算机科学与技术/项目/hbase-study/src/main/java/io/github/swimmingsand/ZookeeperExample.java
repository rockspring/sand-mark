package io.github.swimmingsand;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 3/30/16.
 */
public class ZookeeperExample {
    public static void main(String[] args) throws Exception {
        final ZooKeeper zooKeeper = new ZooKeeper("localhost:2182", 100000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getState());
            }
        });
        while (zooKeeper.getState() != ZooKeeper.States.CONNECTED) {
            TimeUnit.SECONDS.sleep(1);
        }

        long sessionId = zooKeeper.getSessionId();
        System.out.println("sessionId = " + sessionId);

        byte[] sessionPasswd = zooKeeper.getSessionPasswd();
        System.out.print("sessionPasswd = ");
        for (byte sessionPasswdByte : sessionPasswd) {
            System.out.print("0x" + Integer.toHexString(sessionPasswdByte) + " ");
        }
        System.out.println();

        int sessionTimeout = zooKeeper.getSessionTimeout();
        System.out.println("sessionTimeout=" + sessionTimeout);

        zooKeeper.close();
    }
}
