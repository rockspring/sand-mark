package io.github.swimmingsand.java7.chapter9.code4;

import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by zlq on 7/1/15.
 */
public class Producer implements Runnable {

    private LinkedTransferQueue<String> buffer;

    private String name;

    public Producer(String name, LinkedTransferQueue<String> buffer) {
        this.buffer = buffer;
        this.name = name;
    }

    public void run() {
        for (int i=0; i<10000; i++) {
            buffer.put(name + ": Element " + i);
        }

        System.out.printf("Producer: %s: Producer done\n", name);
    }
}
