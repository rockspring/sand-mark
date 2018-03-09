package io.github.swimmingsand.java7.concurrentProgrammingDesign.code7;

/**
 * Created by zlq on 6/30/15.
 */
public class Task implements Runnable {
    public void run() {
        System.out.printf("%s: Getting the connection...\n", Thread.currentThread().getName());
        DBConnectionOK connection = DBConnectionOK.getConnection();
        System.out.printf("%s: End\n", Thread.currentThread().getName());
    }
}
