package io.github.swimmingsand.java7.chapter9.code3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * Created by zlq on 7/1/15.
 */
public class AlwaysThrowsExceptionWorkerThread extends ForkJoinWorkerThread {

    protected AlwaysThrowsExceptionWorkerThread(ForkJoinPool pool) {
        super(pool);
    }

    @Override
    protected void onStart() {
        super.onStart();
        throw new RuntimeException("Exception from worker thread");
    }
}
