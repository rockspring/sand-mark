package io.github.swimmingsand.java7.chapter8.code1;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 6/30/15.
 */
public class Main {

    public static void main(String[] args) {
        MyLock lock = new MyLock();

        Thread threads[] = new Thread[5];

        for (int i=0; i<5; i++) {
            Task task = new Task(lock);
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i=0; i< 15; i++) {
            System.out.printf("Main: Logging the Lock\n");
            System.out.printf("**********************\n");
            System.out.printf("Lock: Owner : %s\n", lock.getOwnerName());

            System.out.printf("Lock: Quened Threads: %s\n", lock.hasQueuedThreads());

            if (lock.hasQueuedThreads()) {
                System.out.printf("Lock: Queue Length: %d\n", lock.getQueueLength());

                System.out.printf("Lock: Queued Threads: ");

                Collection<Thread> lockedThreads = lock.getThreads();

                for (Thread lockedThread : lockedThreads) {
                    System.out.printf("%s ", lockedThread.getName());
                }
                System.out.printf("\n");
            }

            System.out.printf("Lock: Fairness: %s\n", lock.isFair());
            System.out.printf("Lock: Locked: %s\n", lock.isLocked());
            System.out.printf("**********************************\n");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
