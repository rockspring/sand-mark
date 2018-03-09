package io.github.swimmingsand.java7.chapter3.code3x2;

/**
 * Created by zlq on 7/1/15.
 */
public class Main {

    public static void main(String args[]) {
        PrintQueue printQueue = new PrintQueue();

        Thread threads[] = new Thread[10];

        for (int i=0; i<10; i++) {
            threads[i] = new Thread(new Job(printQueue), "Thread" + i);
        }

        for (int i=0; i<10; i++) {
            threads[i].start();
        }
    }
}
