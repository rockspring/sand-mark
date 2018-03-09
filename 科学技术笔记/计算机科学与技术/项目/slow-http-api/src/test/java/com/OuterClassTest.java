package com;

import com.anjuke.search.http.OuterClass;

/**
 * Created by zlq on 9/10/16.
 */
public class OuterClassTest extends OuterClass{

    public static void  main(String args[]) {
        OuterClass outerClass = new OuterClass();
        outerClass.setA(10);
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        outerClass.print();
        innerClass.print();
    }
}
