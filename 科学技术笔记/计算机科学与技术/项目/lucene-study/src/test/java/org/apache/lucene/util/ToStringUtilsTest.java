package org.apache.lucene.util;

import org.junit.Test;

/**
 * Created by zlq on 6/12/15.
 */
public class ToStringUtilsTest {

    @Test
    public void test() {
        String longHex = ToStringUtils.longHex(123);
        System.out.println(longHex);

        byte[] bytes = new byte[10];
        for (int i=0; i< 10; ++i) {
            bytes[i] = (byte)i;
        }
        StringBuilder stringBuffer = new StringBuilder();
        ToStringUtils.byteArray(stringBuffer, bytes);
        System.out.println(stringBuffer.toString());

        //String boost = ToStringUtils.boost(1.5f);
        //System.out.println(boost);
    }
}
