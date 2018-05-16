package io.github.swimmingsand.java7.concurrentProgrammingDesign.code3;

import java.util.Date;

/**
 * Created by zlq on 6/30/15.
 */
public class Main {

    public static void main(String[] args) {
        TaskAtomic atomicTask = new TaskAtomic();
        TaskLock lockTask = new TaskLock();

        int numberThreads = 50;
        Thread threads[] = new Thread[numberThreads];
        Date begin, end;

        begin = new Date();

        for (int i=0; i<numberThreads; i++) {
            threads[i] = new Thread(lockTask);
            threads[i].start();
        }

        for (int i=0; i<numberThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        end = new Date();

        System.out.printf("Main: Lock results: %d\n", (end.getTime() - begin.getTime()));

        begin = new Date();

        for (int i=0; i<numberThreads; i++) {
            threads[i] = new Thread(atomicTask);
            threads[i].start();
        }

        for (int i=0; i<numberThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        end = new Date();

        System.out.printf("Main: Atomic results: %d\n", (end.getTime() - begin.getTime()));
    }
}
