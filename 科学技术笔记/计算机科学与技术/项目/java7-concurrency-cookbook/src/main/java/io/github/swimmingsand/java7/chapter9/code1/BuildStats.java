package io.github.swimmingsand.java7.chapter9.code1;

import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 6/30/15.
 */
public class BuildStats {

    private long numPepole;

    public /**synchronized**/ void comeIn() {
        System.out.printf("%s: A person enters.\n", Thread.currentThread().getName());

        synchronized (this) {
            numPepole++;
        }

        generateCard();
    }

    public /**synchronized**/ void goOut() {
        System.out.printf("%s: A person leaves.\n", Thread.currentThread().getName());

        synchronized (this) {
            numPepole--;
        }

        generateReport();
    }

    private void generateCard() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void generateReport() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printStats() {
        System.out.printf("%d persons in the building.\n", numPepole);
    }
}
