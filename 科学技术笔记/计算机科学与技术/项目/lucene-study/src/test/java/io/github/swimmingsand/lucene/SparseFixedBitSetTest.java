package io.github.swimmingsand.lucene;

import org.apache.lucene.util.SparseFixedBitSet;
import org.junit.Test;

/**
 * Created by zlq on 6/9/15.
 */
public class SparseFixedBitSetTest {

    @Test
    public void test() {
        SparseFixedBitSet sparseFixedBitSet = new SparseFixedBitSet(4096+64+3);//4163
        sparseFixedBitSet.set(0);
        sparseFixedBitSet.set(1);
        sparseFixedBitSet.set(2);
        sparseFixedBitSet.set(3);
        sparseFixedBitSet.set(63);
        sparseFixedBitSet.set(64*2+1);
        sparseFixedBitSet.set(65);
        sparseFixedBitSet.set(4098);
    }
}
