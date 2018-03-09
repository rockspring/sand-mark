package io.github.swimmingsand.lucene;

import org.apache.lucene.util.FixedBitSet;
import org.junit.Test;

/**
 * Created by zlq on 5/22/15.
 */
public class FixedBitSetTest {

    @Test
    public void test() {
        FixedBitSet fixedBitSet = new FixedBitSet(66);

        fixedBitSet.set(65);
        fixedBitSet.set(2);
        fixedBitSet.set(1);
        fixedBitSet.set(3);
        fixedBitSet.set(4);
        System.out.println(fixedBitSet.prevSetBit(3));
        System.out.println(fixedBitSet.nextSetBit(3));
        System.out.println(fixedBitSet.cardinality());
    }

    @Test
    public void test1() {
        long a = 0x0101010101010101L;
        //BitUtil.select(a, 3);
        System.out.println(Long.toBinaryString(a * a));

        System.out.printf("\n%2d: ", 1);
        for (int s = 1; s <= 64; s++) {
            String line = Long.toBinaryString((128 - s) * 0x0101010101010101L);
            line = "0" + line;
            for (int i=0; i<line.length(); ++i) {
                if ((i!=0) && (i % 8 ==0)) {
                    System.out.printf("%8s ",line.substring(i-8,i));
                }
            }
            System.out.printf("\n%2d: ", s+1);
        }

        final byte[] select256 = new byte[8 * 256];
        for (int b = 0; b <= 0xFF; b++) {
            for (int s = 1; s <= 8; s++) {
                int byteIndex = b | ((s-1) << 8);
                int bitIndex = selectNaive(b, s);
                if (bitIndex < 0) {
                    bitIndex = 127; // positive as byte
                }
                assert bitIndex >= 0;
                assert ((byte) bitIndex) >= 0; // non negative as byte, no need to mask the sign
                select256[byteIndex] = (byte) bitIndex;
            }
        }

        for (int i=0; i<select256.length; ++i) {
            if ((i % 8 ==0)) {
                System.out.printf("\n%3d: ", i);
            }
            System.out.printf("%3d ",select256[i]);

        }
    }

    public static int selectNaive(long x, int r) {
        assert r >= 1;
        int s = -1;
        while ((x != 0L) && (r > 0)) {
            int ntz = Long.numberOfTrailingZeros(x);
            x >>>= (ntz + 1);
            s += (ntz + 1);
            r -= 1;
        }
        int res = (r > 0) ? -1 : s;
        return res;
    }
}
