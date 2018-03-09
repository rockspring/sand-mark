package org.apache.lucene.util;

/**
 * Created by zlq on 6/11/15.
 */
public class ArrayUtilTest {
    public void test() {
        Integer[] a = {1,3,2};
        ArrayUtil.timSort(a, 0 ,3);
    }
}
