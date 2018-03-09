package io.github.swimmingsand.java7.chapter2.code2x4;

/**
 * Created by zlq on 7/1/15.
 */
public class Producer implements Runnable {

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    public void run() {
        for (int i=0; i<100; i++) {
            storage.set();
        }
    }
}
