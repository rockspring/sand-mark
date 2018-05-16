package io.github.swimmingsand.java7.chapter9.code5;

import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 7/1/15.
 */
public class Main {

    public static void main(String[] args) {
        Task task = new Task();

        Thread[] threads = new Thread[5];

        for (int i=0; i<5; i++) {
            threads[i] = new Thread(task);
            threads[i].setPriority(i+1);
            threads[i].start();
        }

        for (int j=0; j<10; j++) {
            System.out.printf("Main: Logging threads\n");

            for (int i=0; i<threads.length; i++) {
                System.out.printf("*************************\n");
                System.out.printf("Main: %d: Id: %d Name: %s: Priority: %d\n", i, threads[i].getId(), threads[i].getName(), threads[i].getPriority());
                System.out.printf("Main: Stack Trace: \n");

                for (int t=0; t<threads[i].getStackTrace().length; t++) {
                    System.out.printf("Main: %s\n", threads[i].getStackTrace()[t]);
                }

                System.out.printf("*************************\n");
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
