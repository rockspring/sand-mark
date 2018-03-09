package io.github.swimmingsand.solr;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private int getNumBits(String firstPart, int commaIdx) {
        int v = 0;
        for (int idx = commaIdx + 1; idx < firstPart.length(); idx++) {
            char ch = firstPart.charAt(idx);
            if (ch < '0' || ch > '9') return -1;
            v = v * 10 + (ch - '0');
        }
        return v > 32 ? -1 : v;
    }

    @Test
    public void testSplit() {
        String a = "a!/123";
        String[] pieces = a.split("!");
        System.out.println(pieces.length);
    }

    @Test
    public void test2() {
        char a = '0';
        char b = '9';

        System.out.println((int)a);
        System.out.println((int)b);
        System.out.println(b-a);

        int c = -1 << (32 - 2);

        int d = -1 << (32 - 2 - 4);

        System.out.println(Integer.toBinaryString(-1));

        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(d));
        System.out.println(Integer.toBinaryString(d^c));
    }

    @Test
    public void test3() {
        int a = -1 >>> 2;
        int b = -1 >> 2;
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
    }
}
