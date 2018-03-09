package io.github.swimmingsand.java7.concurrentProgrammingDesign.code4;

import java.util.concurrent.locks.Lock;

/**
 * Created by zlq on 6/29/15.
 */
public class Task2 implements Runnable{

    private Lock lock;

    public Task2(Lock lock) {
        this.lock = lock;
    }

    public void run() {
        lock.lock();
        Operations.readData();
        lock.unlock();

        Operations.processData();

        lock.lock();
        Operations.writeData();
        lock.unlock();
    }
}
