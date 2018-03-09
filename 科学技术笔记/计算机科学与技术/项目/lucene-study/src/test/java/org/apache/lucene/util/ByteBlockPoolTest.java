package org.apache.lucene.util;

import org.junit.Test;

/**
 * Created by zlq on 6/18/15.
 */
public class ByteBlockPoolTest {

    @Test
    public void test() {
        ByteBlockPool byteBlockPool = new ByteBlockPool(new ByteBlockPool.DirectAllocator(32768));
        byteBlockPool.newSlice(32767);
        byteBlockPool.newSlice(5);
        //byteBlockPool.allocSlice()

    }
}
