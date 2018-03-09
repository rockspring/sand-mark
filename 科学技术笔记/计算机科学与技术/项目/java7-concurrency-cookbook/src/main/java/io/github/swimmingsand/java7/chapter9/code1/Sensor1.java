package io.github.swimmingsand.java7.chapter9.code1;

/**
 * Created by zlq on 6/30/15.
 */
public class Sensor1 implements Runnable {

    private BuildStats stats;

    public Sensor1(BuildStats stats) {
        this.stats = stats;
    }

    public void run() {
        stats.comeIn();
        stats.comeIn();
        stats.comeIn();
        stats.goOut();
        stats.comeIn();
    }
}
