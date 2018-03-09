package org.apache.lucene.index;

import org.apache.lucene.util.ByteBlockPool;
import org.apache.lucene.util.ByteBlockPool.DirectAllocator;
import org.apache.lucene.util.RecyclingByteBlockAllocator;
import org.junit.Test;

/**
 * Created by zlq on 6/18/15.
 */
public class ByteSliceWriterTest {
    @Test
    public void test() {

        RecyclingByteBlockAllocator recyclingByteBlockAllocator = new RecyclingByteBlockAllocator(32768, 1);

        DirectAllocator directAllocator = new DirectAllocator(32768);
        ByteBlockPool byteBlockPool = new ByteBlockPool(recyclingByteBlockAllocator);
        byteBlockPool.newSlice(5);
        //byteBlockPool.newSlice(5);
        //byteBlockPool.allocSlice()
        ByteSliceWriter byteSliceWriter = new ByteSliceWriter(byteBlockPool);

        byteSliceWriter.init(0);

        byte[] aa = {'a', 'b', 'c', 'd'};

        for (int i=0; i< 4; i++) {
            byte a = 'a';
            byteSliceWriter.writeByte(a);
        }

        for (int i=0; i< 13; i++) {
            byte a = 'b';
            byteSliceWriter.writeByte(a);
        }

        for (int i=0; i< 32768; i++) {
            byte a = 'c';
            byteSliceWriter.writeByte(a);
        }

        //byte a = 'e';
        //byteSliceWriter.writeByte(a);

        //byte[] read = new byte[100];

        //byteBlockPool.readBytes(0, read, 0, 4);

        ByteSliceReader byteSliceReader = new ByteSliceReader();
        byteSliceReader.init(byteBlockPool, 0, 5);

        for (int i=0; i< 1; i++) {
            byte byteRead = byteSliceReader.readByte();
            System.out.println(byteRead);
        }

        byteBlockPool.reset();
        //byteBlockPool.reset(true, true);

        byteSliceWriter.init(0);
        for (int i=0; i< 4; i++) {
            byte a = 'd';
            byteSliceWriter.writeByte(a);
        }

        //byteBlockPool.reset(false, false);
    }
}
