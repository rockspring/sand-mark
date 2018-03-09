package io.github.swimmingsand.java7.chapter9.code3;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * Created by zlq on 7/1/15.
 */
public class Handler implements UncaughtExceptionHandler {

    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("Handler: Thread %s has thrown an Exception.\n", t.getName());
        System.out.printf("%s\n", e);
        System.exit(-1);
    }
}
