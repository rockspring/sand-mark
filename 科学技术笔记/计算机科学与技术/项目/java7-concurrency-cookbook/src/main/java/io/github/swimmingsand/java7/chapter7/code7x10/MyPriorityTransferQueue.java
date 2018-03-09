package io.github.swimmingsand.java7.chapter7.code7x10;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zlq on 7/5/15.
 */
public class MyPriorityTransferQueue<E> extends PriorityBlockingQueue<E> implements TransferQueue<E>{

    private AtomicInteger counter;

    private LinkedBlockingDeque<E> transfered;

    private ReentrantLock lock;

    public MyPriorityTransferQueue() {
        counter = new AtomicInteger();
        lock = new ReentrantLock();
        transfered = new LinkedBlockingDeque<E>();
    }

    public boolean tryTransfer(E e) {
        lock.lock();
        boolean value;
        if (counter.get() == 0) {
            value = false;
        } else {
            put(e);
            value = true;
        }

        lock.unlock();
        return value;
    }

    public void transfer(E e) throws InterruptedException {
        lock.lock();
        if (counter.get() != 0) {
            put(e);
            lock.unlock();
        } else {
            transfered.add(e);
            lock.unlock();
            synchronized (e) {
                e.wait();
            }
        }

    }

    public boolean tryTransfer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        lock.lock();
        if (counter.get() != 0) {
            put(e);
            lock.unlock();
            return true;
        } else {
            transfered.add(e);
            long newTimeout = TimeUnit.MILLISECONDS.convert(timeout, unit);
            lock.unlock();
            e.wait(newTimeout);
            lock.lock();
            if (transfered.contains(e)) {
                transfered.remove(e);
                lock.unlock();
                return false;
            } else {
                lock.unlock();
                return true;
            }
        }
    }

    public boolean hasWaitingConsumer() {
        return (counter.get() != 0);
    }

    public int getWaitingConsumerCount() {
        return counter.get();
    }

    public E take() throws InterruptedException {
        lock.lock();
        counter.incrementAndGet();
        E value = transfered.poll();
        if (value == null) {
            lock.unlock();
            value = super.take();
            lock.lock();
        } else {
            synchronized (value) {
                value.notify();
            }
        }

        counter.decrementAndGet();
        lock.unlock();
        return value;
    }
}
