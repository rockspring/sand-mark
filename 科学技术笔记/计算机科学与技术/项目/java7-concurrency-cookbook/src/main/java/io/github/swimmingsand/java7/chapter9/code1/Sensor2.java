package io.github.swimmingsand.java7.chapter9.code1;

/**
 * Created by zlq on 6/30/15.
 */
public class Sensor2 implements Runnable{

    private BuildStats stats;

    public Sensor2(BuildStats stats) {
        this.stats = stats;
    }

    public void run() {
        stats.comeIn();
        stats.comeIn();
        stats.goOut();
        stats.goOut();
        stats.goOut();
    }
}
