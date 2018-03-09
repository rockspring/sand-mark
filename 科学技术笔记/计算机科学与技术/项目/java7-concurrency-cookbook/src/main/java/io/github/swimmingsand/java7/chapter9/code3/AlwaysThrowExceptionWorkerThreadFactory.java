package io.github.swimmingsand.java7.chapter9.code3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * Created by zlq on 7/1/15.
 */
public class AlwaysThrowExceptionWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
    public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
        return new AlwaysThrowsExceptionWorkerThread(pool);
    }
}
