package io.github.swimmingsand.java7.concurrentProgrammingDesign.code3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zlq on 6/30/15.
 */
public class TaskAtomic implements Runnable {

    public AtomicInteger number;

    public TaskAtomic() {
        this.number = new AtomicInteger();
    }

    public void run() {
        for (int i=0; i<100000; i++) {
            number.set(i);
        }
    }
}
