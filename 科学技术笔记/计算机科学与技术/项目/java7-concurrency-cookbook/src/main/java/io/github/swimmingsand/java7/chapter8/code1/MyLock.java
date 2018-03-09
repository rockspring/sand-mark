package io.github.swimmingsand.java7.chapter8.code1;

import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zlq on 6/30/15.
 */
public class MyLock extends ReentrantLock {

    public String getOwnerName() {
        if (this.getOwner() == null) {
            return "None";
        } else {
            return this.getOwner().getName();
        }
    }

    public Collection<Thread> getThreads() {
        return this.getQueuedThreads();
    }
}
