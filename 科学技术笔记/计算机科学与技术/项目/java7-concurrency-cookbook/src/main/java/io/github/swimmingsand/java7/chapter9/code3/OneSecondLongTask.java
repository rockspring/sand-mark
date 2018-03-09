package io.github.swimmingsand.java7.chapter9.code3;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 7/1/15.
 */
public class OneSecondLongTask extends RecursiveAction {
    @Override
    protected void compute() {
        System.out.printf("Task: Starting.\n");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Task: Finish.\n");
    }
}
