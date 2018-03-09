package com.anjuke.search.http;

/**
 * Created by zlq on 9/10/16.
 */
public class OuterClass {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    void print() {
        System.out.println("OuterClass");
    }

    //默认是同一个package的类可以访问
    //如果为private,只有OuterClass访问
    //protected,同一个包和继承类都可以访问
    protected class InnerClass {
        private int b;

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
        void print() {
            System.out.println("InnerClass b=" + b +";OuterClass.a=" + a);
        }
    }
}
