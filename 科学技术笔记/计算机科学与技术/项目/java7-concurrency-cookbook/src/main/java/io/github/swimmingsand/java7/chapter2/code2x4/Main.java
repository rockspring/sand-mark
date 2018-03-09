package io.github.swimmingsand.java7.chapter2.code2x4;

/**
 * Created by zlq on 7/1/15.
 */
public class Main {

    public static void main(String[] args) {
        EventStorage storage = new EventStorage();

        Producer producer = new Producer(storage);
        Thread thread1 = new Thread(producer);

        Consumer consumer = new Consumer(storage);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
    }
}
