package io.github.swimmingsand.java7.chapter9.code3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 7/1/15.
 */
public class Main {

    public static void main(String[] args) {
        OneSecondLongTask task = new OneSecondLongTask();

        Handler handler = new Handler();

        AlwaysThrowExceptionWorkerThreadFactory factory = new AlwaysThrowExceptionWorkerThreadFactory();

        ForkJoinPool pool = new ForkJoinPool(2, factory,null, false);

        pool.execute(task);

        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Task: Finish.\n");
    }
}
