package io.github.swimmingsand.java7.concurrentProgrammingDesign.code4;

import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 6/29/15.
 */
public class Operations {

    public static void readData() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void writeData() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void processData() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
