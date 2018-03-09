package com.anjuke.search.http;

/**
 * Created by zlq on 9/10/16.
 */
public class OuterClassTest {

    public static void  main(String args[]) {
        OuterClass outerClass = new OuterClass();
        outerClass.setA(10);
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        outerClass.print();
        innerClass.print();
    }
}
