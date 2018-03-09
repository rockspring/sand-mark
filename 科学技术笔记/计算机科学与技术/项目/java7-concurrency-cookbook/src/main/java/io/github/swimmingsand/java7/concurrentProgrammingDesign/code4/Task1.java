package io.github.swimmingsand.java7.concurrentProgrammingDesign.code4;

import java.util.concurrent.locks.Lock;

/**
 * Created by zlq on 6/29/15.
 */
public class Task1 implements Runnable{
    private Lock lock;

    public Task1(Lock lock) {
        this.lock = lock;
    }


    public void run() {
        lock.lock();
        Operations.readData();
        Operations.processData();
        Operations.writeData();
        lock.unlock();
    }
}
