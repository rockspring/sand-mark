package io.github.swimmingsand.java7.concurrentProgrammingDesign.code8;

import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 6/30/15.
 */
public class Task implements Runnable{
    private int array[];

    public Task(int array[]) {
        this.array = array;
    }

    public void run() {
        for (int i=0; i<array.length; i++) {
            array[i]++;

            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
