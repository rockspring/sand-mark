package io.github.swimmingsand.java7.chapter2.code2x5;

/**
 * Created by zlq on 7/1/15.
 */
public class Main {
    public static void main(String args[]) {
        PrintQueue printQueue = new PrintQueue();

        Thread threads[] = new Thread[10];

        for (int i=0; i<threads.length; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        for (int i=0; i<threads.length; i++) {
            threads[i].start();
        }
    }
}
