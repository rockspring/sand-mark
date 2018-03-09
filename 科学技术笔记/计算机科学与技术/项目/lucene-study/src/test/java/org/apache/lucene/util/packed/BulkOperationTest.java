package org.apache.lucene.util.packed;

import org.apache.lucene.util.packed.PackedInts.Format;
import org.junit.Test;

/**
 * Created by zlq on 11/5/15.
 */
public class BulkOperationTest {

    @Test
    public void testOf() {
        for (int i=1; i<=64;i ++) {
            System.out.format("%2d", i);
            System.out.print(" ");
            System.out.format("%2d", (BulkOperation.of(Format.PACKED, i).longBlockCount()));
            System.out.print(" ");
            for (int j = 0; j < BulkOperation.of(Format.PACKED,i).longBlockCount(); j++) {
                System.out.print("- ");
            }
            System.out.println();
        }
    }

    @Test
    public void testOf2() {
        for (int i=1; i<=64;i ++) {
            System.out.format("%2d", i);
            System.out.print(" ");
            System.out.format("%2d", (BulkOperation.of(Format.PACKED, i).byteBlockCount()));
            System.out.print(" ");
            for (int j = 0; j < BulkOperation.of(Format.PACKED,i).byteBlockCount(); j++) {
                System.out.print("- ");
            }
            System.out.println();
        }
    }
}
