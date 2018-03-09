package io.github.swimmingsand.java7.concurrentProgrammingDesign.code9;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zlq on 6/30/15.
 */
public class Main {

    public static void main(String args[]) {
        ReentrantLock lock = new ReentrantLock();

        for (int i=0; i<10; i++) {
            Task task = new Task(lock);
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
