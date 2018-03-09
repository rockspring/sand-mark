package org.apache.lucene.util;

import org.apache.lucene.util.packed.PackedInts;
import org.junit.Test;

/**
 * Created by zlq on 11/4/15.
 */
public class PackedIntsTest {

    @Test
    public void testFastestFormatAndBits() {
        for (int i=1; i<=64;i ++) {
            System.out.println(PackedInts.fastestFormatAndBits(1000,i,0).bitsPerValue);
        }
    }
}
