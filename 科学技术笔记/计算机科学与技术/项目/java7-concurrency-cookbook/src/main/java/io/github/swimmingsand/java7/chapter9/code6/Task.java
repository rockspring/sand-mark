package io.github.swimmingsand.java7.chapter9.code6;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 7/1/15.
 */
public class Task implements Runnable {

    private Semaphore semaphore;

    public Task(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            semaphore.acquire();
            System.out.printf("%s: Get the semaphore.\n", Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "Release the semaphore.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
