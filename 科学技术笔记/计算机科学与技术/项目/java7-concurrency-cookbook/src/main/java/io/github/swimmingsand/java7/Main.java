package io.github.swimmingsand.java7;

import edu.umd.cs.mtc.TestFramework;

/**
 * Created by zlq on 6/27/15.
 */
public class Main {
    public static void main(String args[]) throws Throwable {
        ProducerConsumerTest test = new ProducerConsumerTest();
        test.setTrace(true);
        System.out.printf("Main: Starting the test\n");
        //test.freezeClock();
        //test.freezeClock();
        TestFramework.runOnce(test);
        System.out.printf("Main: The test has finished\n");
    }
}
