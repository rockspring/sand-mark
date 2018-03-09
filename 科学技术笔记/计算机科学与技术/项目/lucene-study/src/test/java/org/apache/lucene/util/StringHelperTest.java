package org.apache.lucene.util;

import org.junit.Test;

/**
 * Created by zlq on 6/12/15.
 */
public class StringHelperTest {
    @Test
    public void testBytesDifference() {
        BytesRef left = new BytesRef("abc");
        BytesRef right = new BytesRef("bac");
        int diffrence = StringHelper.bytesDifference(left, right);
        System.out.println(diffrence);


        BytesRef priorTerm = new BytesRef("abc");
        BytesRef currentTerm = new BytesRef("abcdefg");
        int sortKeyLength = StringHelper.sortKeyLength(priorTerm, currentTerm);
        System.out.println(sortKeyLength);
    }

    @Test
    public void testEquals() {
        String a = "abc";
        String b = "abc";
        //String b = a;
        //boolean equal = StringHelper.equals(a, b);
        //System.out.println(equal);
    }

    @Test
    public void testRandomId() {
        byte[] id = StringHelper.randomId();
        for (int i=0; i< id.length; ++i) {
            System.out.println(id[i]);
        }

    }

    @Test
    public void test() {

    }
}
