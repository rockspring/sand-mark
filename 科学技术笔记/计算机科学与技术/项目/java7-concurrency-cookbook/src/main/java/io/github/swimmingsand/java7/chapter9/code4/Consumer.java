package io.github.swimmingsand.java7.chapter9.code4;

import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by zlq on 7/1/15.
 */
public class Consumer implements Runnable {

    private LinkedTransferQueue<String> buffer;

    private String name;

    public Consumer(String name, LinkedTransferQueue<String> buffer) {
        this.name = name;
        this.buffer = buffer;
    }

    public void run() {
        for (int i=0; i< 10000; i++) {
            try {
                buffer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Consumer: %s: Consumer done\n", name);
    }
}
