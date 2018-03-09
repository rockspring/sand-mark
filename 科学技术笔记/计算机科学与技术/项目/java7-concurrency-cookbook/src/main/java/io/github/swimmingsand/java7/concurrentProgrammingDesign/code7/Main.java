package io.github.swimmingsand.java7.concurrentProgrammingDesign.code7;

/**
 * Created by zlq on 6/30/15.
 */
public class Main {

    public static void main(String[] args) {
        for (int i=0; i<20; i++) {
            Task task = new Task();
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
