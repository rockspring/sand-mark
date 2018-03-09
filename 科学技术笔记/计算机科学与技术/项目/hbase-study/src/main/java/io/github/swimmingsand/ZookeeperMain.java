package io.github.swimmingsand;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zlq on 3/29/16.
 */
public class ZookeeperMain {
    public static void main(String[] args) throws Exception{
        final ZooKeeper zooKeeper = new ZooKeeper("localhost:2182", 100000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getState());
            }
        });
        System.out.println(zooKeeper.toString());

        List<String> children = zooKeeper.getChildren("/", new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println(event.getState());
            }
        });
        for (String child : children) {
            System.out.println(child);
            Stat stat = new Stat();

            byte[] data = zooKeeper.getData("/" + child, true, stat);
            System.out.println(data.length);
        }

        //public List<String> getChildren(String path, boolean watch) throws KeeperException, InterruptedException
        System.out.println("getChildren(String path, boolean watch)");
        children = zooKeeper.getChildren("/", false);
        for (String child : children) {
            System.out.println(child);
            Stat stat = new Stat();

            byte[] data = zooKeeper.getData("/" + child, true, stat);
            System.out.println(data.length);
        }

        //getChildren(final String path, Watcher watcher, AsyncCallback.ChildrenCallback cb, Object ctx)
        System.out.println("getChildren(final String path, Watcher watcher, AsyncCallback.ChildrenCallback cb, Object ctx)");
        zooKeeper.getChildren("/", new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println(event.getState());
            }
        }, new AsyncCallback.ChildrenCallback() {
            public void processResult(int rc, String path, Object ctx, List<String> children) {
                System.out.println("rc=" + rc);
                System.out.println("path=" + path);
                System.out.println("ctx=" + ctx);
                for (String child : children) {
                    System.out.println(child);
                    Stat stat = new Stat();

                    try {
                        byte[] data = zooKeeper.getData("/" + child, true, stat);
                        System.out.println(data.length);
                    } catch (KeeperException e) {

                    } catch (InterruptedException e) {

                    }
                }
            }
        }, null);

        System.out.println("getChildren(String path, boolean watch, ChildrenCallback cb, Object ctx)");
        zooKeeper.getChildren("/", false, new AsyncCallback.ChildrenCallback() {
            public void processResult(int rc, String path, Object ctx, List<String> children) {
                System.out.println("rc=" + rc);
                System.out.println("path=" + path);
                System.out.println("ctx=" + ctx);
                for (String child : children) {
                    System.out.println(child);
                    Stat stat = new Stat();

                    try {
                        byte[] data = zooKeeper.getData("/" + child, true, stat);
                        System.out.println(data.length);
                    } catch (KeeperException e) {

                    } catch (InterruptedException e) {

                    }
                }
            }
        }, null);

        Stat stat = new Stat();
        System.out.println("List<String> getChildren(final String path, Watcher watcher, Stat stat)");

        children = zooKeeper.getChildren("/", new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println(event.getState());
            }
        }, stat);
        System.out.println("stat.getCtime=" + stat.getCtime());

        System.out.println("List<String> getChildren(final String path, boolean watch, Stat stat)");

        children = zooKeeper.getChildren("/", false, stat);
        System.out.println("stat.getCtime=" + stat.getCtime());


        System.out.println("getChildren(final String path, Watcher watcher, Children2Callback cb, Object ctx)");

        zooKeeper.getChildren("/", new Watcher() {
            public void process(WatchedEvent event) {

            }
        }, new AsyncCallback.Children2Callback() {
            public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
                System.out.println("rc=" + rc);
                System.out.println("path=" + path);
                System.out.println("ctx=" + ctx);
                for (String child : children) {
                    System.out.println(child);
                    stat = new Stat();

                    try {
                        byte[] data = zooKeeper.getData("/" + child, true, stat);
                        System.out.println(data.length);
                    } catch (KeeperException e) {

                    } catch (InterruptedException e) {

                    }
                }
            }
        }, null);

        System.out.println("getChildren(final String path, boolean watch, Children2Callback cb, Object ctx)");

        Map<String, String> ctx = new HashMap<String, String>();
        ctx.put("name", "leqinzhou");
        zooKeeper.getChildren("/", false, new AsyncCallback.Children2Callback() {
            public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
                System.out.println("rc=" + rc);
                System.out.println("path=" + path);
                System.out.println("ctx=" + ctx);
                for (String child : children) {
                    System.out.println(child);
                    stat = new Stat();

                    try {
                        byte[] data = zooKeeper.getData("/" + child, true, stat);
                        System.out.println(data.length);
                    } catch (KeeperException e) {

                    } catch (InterruptedException e) {

                    }
                }
            }
        }, ctx);

        zooKeeper.close();
        System.exit(1);

        List<ACL> acls = new ArrayList<ACL>();
        acls.add(new ACL(ZooDefs.Perms.CREATE, ZooDefs.Ids.ANYONE_ID_UNSAFE));
        acls.add(new ACL(ZooDefs.Perms.DELETE, ZooDefs.Ids.ANYONE_ID_UNSAFE));
        //zooKeeper.setACL("/test", acls, -1);

        //zooKeeper.delete("/test",-1);
        zooKeeper.create("/test", "test".getBytes(), acls, CreateMode.EPHEMERAL);
        stat = new Stat();

        zooKeeper.getData("/test", false, stat);

        System.out.println(stat.getCtime());
    }
}
