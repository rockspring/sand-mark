package io.github.swimmingsand.java7.chapter9.code5;

import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 7/1/15.
 */
public class Task implements Runnable {
    public void run() {
        for (int i=0; i<100; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("%s: %d\n", Thread.currentThread().getName(), i);
        }
    }
}
