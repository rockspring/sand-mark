package org.apache.lucene.util;

import org.junit.Test;

/**
 * Created by zlq on 6/24/15.
 */
public class NumericUtilsTest {

    @Test
    public void test() {
        BytesRefBuilder bytesRefBuilder = new BytesRefBuilder();
        //NumericUtils.longToPrefixCoded(288301844407517247l, 0, bytesRefBuilder);

        byte[] bytes = bytesRefBuilder.bytes();

        for (int i=0; i<bytesRefBuilder.length(); i++) {
            System.out.println(bytes[i]);
        }

        bytesRefBuilder.clear();
        //NumericUtils.longToPrefixCoded(288301844407517247l, 8, bytesRefBuilder);

        bytes = bytesRefBuilder.bytes();
        System.out.println("...........");

        for (int i=0; i<bytesRefBuilder.length(); i++) {
            System.out.println(bytes[i]);
        }
    }

    @Test
    public void test2() {
        String coded = "10000000000000000000000100101100";
        coded = "100000000000000000000001";
        coded = "1000000000000000";

        int segmentCount = coded.length()/7;
        int firstSegmentSize = coded.length()%7;

        for (int i= 0; i< firstSegmentSize; i++) {
            System.out.print(coded.charAt(i));
        }

        System.out.print(" ");

        int count = 0;
        for (int i= firstSegmentSize; i< coded.length(); i++) {
            System.out.print(coded.charAt(i));
            count++;

            if (count %7 ==0) {
                System.out.print(" ");
            }
        }
    }

    @Test
    public void test3() {
        String coded = "10000000000000000000000100101100";
        //coded = "100000000000000000000001";
        coded = "1000000000000000";

        int segmentCount = coded.length()/8;
        int firstSegmentSize = coded.length()%8;

        for (int i= 0; i< firstSegmentSize; i++) {
            System.out.print(coded.charAt(i));
        }

        System.out.print(" ");

        int count = 0;
        for (int i= firstSegmentSize; i< coded.length(); i++) {
            System.out.print(coded.charAt(i));
            count++;

            if (count %8 ==0) {
                System.out.print(" ");
            }
        }
    }

    @Test
    public void test4() {
        int a =300;
        String binStr = Integer.toBinaryString(a);

        System.out.println(binStr);

        a = a ^ 0x80000000;

        binStr = Integer.toBinaryString(a);

        System.out.println(a);
        System.out.println(binStr);

        a = -2147483348;

        a = a ^ 0x80000000;

        binStr = Integer.toBinaryString(a);

        System.out.println(a);
        System.out.println(binStr);
    }
}
