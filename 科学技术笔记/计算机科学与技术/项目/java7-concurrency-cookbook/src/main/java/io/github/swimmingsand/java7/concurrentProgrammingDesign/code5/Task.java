package io.github.swimmingsand.java7.concurrentProgrammingDesign.code5;

/**
 * Created by zlq on 6/30/15.
 */
public class Task implements Runnable{
    public void run() {
        int r;
        for (int i=0; i<100000; i++) {
            r=0;
            r++;
            r++;
            r*=r;
        }
    }
}
