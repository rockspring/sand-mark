package io.github.swimmingsand.java7.concurrentProgrammingDesign.code3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zlq on 6/30/15.
 */
public class TaskLock implements Runnable {

    private Lock lock;
    private int number;

    public TaskLock() {
        this.lock = new ReentrantLock();
    }

    public void run() {

        for (int i=0; i<100000; i++) {
            lock.lock();
            number = i;
            lock.unlock();
        }
    }
}
