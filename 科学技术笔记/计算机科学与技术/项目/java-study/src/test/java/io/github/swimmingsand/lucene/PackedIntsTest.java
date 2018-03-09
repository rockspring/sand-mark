package io.github.swimmingsand.lucene;

import org.apache.lucene.codecs.CodecUtil;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FlushInfo;
import org.apache.lucene.store.IOContext;
import org.apache.lucene.store.IndexInput;
import org.apache.lucene.store.IndexOutput;
import org.apache.lucene.store.MergeInfo;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.LongValues;
import org.apache.lucene.util.LongsRef;
import org.apache.lucene.util.LuceneTestCase;
import org.apache.lucene.util.RamUsageTester;
import org.apache.lucene.util.TestUtil;
import org.apache.lucene.util.packed.PackedDataInput;
import org.apache.lucene.util.packed.PackedDataOutput;
import org.apache.lucene.util.packed.PackedInts;
import org.apache.lucene.util.packed.PackedInts.Format;
import org.apache.lucene.util.packed.PackedLongValues;
import org.apache.lucene.util.packed.PagedGrowableWriter;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Random;

import static org.junit.Assert.assertEquals;


/**
 * PackedInts测试
 */
public class PackedIntsTest {

    @Test
    public void testByteCount() {
        final int iters = 1;
        for (int i = 0; i < iters; ++i) {
            final int valueCount = 10;
            for (PackedInts.Format format : PackedInts.Format.values()) {
                for (int bpv = 1; bpv <= 64; ++bpv) {
                    final long byteCount = format.byteCount(PackedInts.VERSION_CURRENT, valueCount, bpv);
                    String msg = "format=" + format + ", byteCount=" + byteCount + ", valueCount=" + valueCount + ", bpv=" + bpv;
                    //assertTrue(msg, byteCount * 8 >= (long) valueCount * bpv);
                    if (format == PackedInts.Format.PACKED) {
                        //assertTrue(msg, (byteCount - 1) * 8 < (long) valueCount * bpv);
                    }

                    System.out.println(format.toString() + " " + bpv + " " + byteCount + " " + (int)Math.ceil(byteCount/8.0));
                }
            }
        }
    }

    @Test
    public void testBitsRequired() {
        assertEquals(61, PackedInts.bitsRequired((long)Math.pow(2, 61)-1));
        assertEquals(61, PackedInts.bitsRequired(0x1FFFFFFFFFFFFFFFL));
        assertEquals(62, PackedInts.bitsRequired(0x3FFFFFFFFFFFFFFFL));
        assertEquals(63, PackedInts.bitsRequired(0x7FFFFFFFFFFFFFFFL));
        assertEquals(64, PackedInts.unsignedBitsRequired(-1));
        assertEquals(64, PackedInts.unsignedBitsRequired(Long.MIN_VALUE));
        assertEquals(1, PackedInts.bitsRequired(0));
    }

    public static Random random() {
        return new Random();
    }

    /** TODO: javadoc */
    public static IOContext newIOContext(Random random) {
        return newIOContext(random, IOContext.DEFAULT);
    }

    /** TODO: javadoc */
    public static IOContext newIOContext(Random random, IOContext oldContext) {
        final int randomNumDocs = random.nextInt(4192);
        final int size = random.nextInt(512) * randomNumDocs;
        if (oldContext.flushInfo != null) {
            // Always return at least the estimatedSegmentSize of
            // the incoming IOContext:
            return new IOContext(new FlushInfo(randomNumDocs, Math.max(oldContext.flushInfo.estimatedSegmentSize, size)));
        } else if (oldContext.mergeInfo != null) {
            // Always return at least the estimatedMergeBytes of
            // the incoming IOContext:
            return new IOContext(new MergeInfo(randomNumDocs, Math.max(oldContext.mergeInfo.estimatedMergeBytes, size), random.nextBoolean(), TestUtil.nextInt(random, 1, 100)));
        } else {
            // Make a totally random IOContext:
            final IOContext context;
            switch (random.nextInt(5)) {
                case 0:
                    context = IOContext.DEFAULT;
                    break;
                case 1:
                    context = IOContext.READ;
                    break;
                case 2:
                    context = IOContext.READONCE;
                    break;
                case 3:
                    context = new IOContext(new MergeInfo(randomNumDocs, size, true, -1));
                    break;
                case 4:
                    context = new IOContext(new FlushInfo(randomNumDocs, size));
                    break;
                default:
                    context = IOContext.DEFAULT;
            }
            return context;
        }
    }

    public static Directory newDirectory() throws Exception{
        Path path = FileSystems.getDefault().getPath("/tmp/a");
        Directory directory = new SimpleFSDirectory(path);
        return directory;
    }

    @Test
    public void testPackedInts() throws Exception {
        int num = 1;
        for (int iter = 0; iter < num; iter++) {
            for(int nbits=1;nbits<=64;nbits++) {
                final long maxValue = PackedInts.maxValue(nbits);
                final int valueCount = TestUtil.nextInt(random(), 1, 600);
                final int bufferSize = random().nextBoolean()
                        ? TestUtil.nextInt(random(), 0, 48)
                        : TestUtil.nextInt(random(), 0, 4096);
                final Directory d = newDirectory();

                IndexOutput out = d.createOutput("out.bin", newIOContext(random()));
                final float acceptableOverhead;
                if (iter == 0) {
                    // have the first iteration go through exact nbits
                    acceptableOverhead = 0.0f;
                } else {
                    acceptableOverhead = random().nextFloat();
                }
                PackedInts.Writer w = PackedInts.getWriter(out, valueCount, nbits, acceptableOverhead);
                final long startFp = out.getFilePointer();

                final int actualValueCount = random().nextBoolean() ? valueCount : TestUtil.nextInt(random(), 0, valueCount);
                final long[] values = new long[valueCount];
                for(int i=0;i<actualValueCount;i++) {
                    if (nbits == 64) {
                        values[i] = random().nextLong();
                    } else {
                        values[i] = TestUtil.nextLong(random(), 0, maxValue);
                    }
                    w.add(values[i]);
                }
                w.finish();
                final long fp = out.getFilePointer();
                out.close();

                // ensure that finish() added the (valueCount-actualValueCount) missing values
                Method method =w.getClass().getDeclaredMethod("getFormat");
                method.setAccessible(true);
                Field field = w.getClass().getSuperclass().getDeclaredField("bitsPerValue");
                field.setAccessible(true);
                Format format = (Format)method.invoke(w);
                final long bytes = format.byteCount(PackedInts.VERSION_CURRENT, valueCount, field.getInt(w));
                assertEquals(bytes, fp - startFp);

                {// test header
                    IndexInput in = d.openInput("out.bin", newIOContext(random()));
                    // header = codec header | bitsPerValue | valueCount | format
                    method =w.getClass().getDeclaredMethod("getFormat");
                    method.setAccessible(true);
                    field = w.getClass().getSuperclass().getDeclaredField("bitsPerValue");
                    field.setAccessible(true);
                    format = (Format)method.invoke(w);
                    CodecUtil.checkHeader(in, PackedInts.CODEC_NAME, PackedInts.VERSION_START, PackedInts.VERSION_CURRENT); // codec header
                    assertEquals(field.getInt(w), in.readVInt());
                    assertEquals(valueCount, in.readVInt());
                    assertEquals(format.getId(), in.readVInt());
                    assertEquals(startFp, in.getFilePointer());
                    in.close();
                }

                {// test reader
                    IndexInput in = d.openInput("out.bin", newIOContext(random()));
                    PackedInts.Reader r = PackedInts.getReader(in);
                    assertEquals(fp, in.getFilePointer());
                    for(int i=0;i<valueCount;i++) {
                        assertEquals("index=" + i + " valueCount="
                                + valueCount + " nbits=" + nbits + " for "
                                + r.getClass().getSimpleName(), values[i], r.get(i));
                    }
                    in.close();

                    final long expectedBytesUsed = RamUsageTester.sizeOf(r);
                    final long computedBytesUsed = r.ramBytesUsed();
                    assertEquals(r.getClass() + "expected " + expectedBytesUsed + ", got: " + computedBytesUsed,
                            expectedBytesUsed, computedBytesUsed);
                }

                { // test reader iterator next
                    IndexInput in = d.openInput("out.bin", newIOContext(random()));
                    PackedInts.ReaderIterator r = PackedInts.getReaderIterator(in, bufferSize);
                    for(int i=0;i<valueCount;i++) {
                        assertEquals("index=" + i + " valueCount="
                                + valueCount + " nbits=" + nbits + " for "
                                + r.getClass().getSimpleName(), values[i], r.next());
                        assertEquals(i, r.ord());
                    }
                    assertEquals(fp, in.getFilePointer());
                    in.close();
                }

                { // test reader iterator bulk next
                    IndexInput in = d.openInput("out.bin", newIOContext(random()));
                    PackedInts.ReaderIterator r = PackedInts.getReaderIterator(in, bufferSize);
                    int i = 0;
                    while (i < valueCount) {
                        final int count = TestUtil.nextInt(random(), 1, 95);
                        final LongsRef next = r.next(count);
                        for (int k = 0; k < next.length; ++k) {
                            assertEquals("index=" + i + " valueCount="
                                    + valueCount + " nbits=" + nbits + " for "
                                    + r.getClass().getSimpleName(), values[i + k], next.longs[next.offset + k]);
                        }
                        i += next.length;
                    }
                    assertEquals(fp, in.getFilePointer());
                    in.close();
                }

                { // test direct reader get
                    IndexInput in = d.openInput("out.bin", newIOContext(random()));
                    PackedInts.Reader intsEnum = PackedInts.getDirectReader(in);
                    for (int i = 0; i < valueCount; i++) {
                        final String msg = "index=" + i + " valueCount="
                                + valueCount + " nbits=" + nbits + " for "
                                + intsEnum.getClass().getSimpleName();
                        final int index = random().nextInt(valueCount);
                        assertEquals(msg, values[index], intsEnum.get(index));
                    }
                    intsEnum.get(intsEnum.size() - 1);
                    assertEquals(fp, in.getFilePointer());
                    in.close();
                }
                d.close();
            }
        }
    }

    public static boolean rarely() {
        return random().nextBoolean();
    }

    @Test
    public void testPagedGrowableWriter() {
        int pageSize = 1 << (TestUtil.nextInt(random(), 6, 30));
        // supports 0 values?
        PagedGrowableWriter writer = new PagedGrowableWriter(0, pageSize, TestUtil.nextInt(random(), 1, 64), random().nextFloat());
        assertEquals(0, writer.size());

        // compare against AppendingDeltaPackedLongBuffer
        PackedLongValues.Builder buf = PackedLongValues.deltaPackedBuilder(random().nextFloat());
        int size = random().nextInt(1000000);
        long max = 5;
        for (int i = 0; i < size; ++i) {
            buf.add(TestUtil.nextLong(random(), 0, max));
            if (rarely()) {
                max = PackedInts.maxValue(rarely() ? TestUtil.nextInt(random(), 0, 63) : TestUtil.nextInt(random(), 0, 31));
            }
        }
        writer = new PagedGrowableWriter(size, pageSize, TestUtil.nextInt(random(), 1, 64), random().nextFloat());
        assertEquals(size, writer.size());
        final LongValues values = buf.build();
        for (int i = size - 1; i >= 0; --i) {
            writer.set(i, values.get(i));
        }
        for (int i = 0; i < size; ++i) {
            assertEquals(values.get(i), writer.get(i));
        }

        // test ramBytesUsed
        assertEquals(RamUsageTester.sizeOf(writer), writer.ramBytesUsed(), 8);

        // test copy
        PagedGrowableWriter copy = writer.resize(TestUtil.nextLong(random(), writer.size() / 2, writer.size() * 3 / 2));
        for (long i = 0; i < copy.size(); ++i) {
            if (i < writer.size()) {
                assertEquals(writer.get(i), copy.get(i));
            } else {
                assertEquals(0, copy.get(i));
            }
        }

        // test grow
        PagedGrowableWriter grow = writer.grow(TestUtil.nextLong(random(), writer.size() / 2, writer.size() * 3 / 2));
        for (long i = 0; i < grow.size(); ++i) {
            if (i < writer.size()) {
                assertEquals(writer.get(i), grow.get(i));
            } else {
                assertEquals(0, grow.get(i));
            }
        }
    }

    @Test
    public void testPackedInputOutput() throws Exception {
        final long[] longs = new long[random().nextInt(8192)];
        final int[] bitsPerValues = new int[longs.length];
        final boolean[] skip = new boolean[longs.length];
        for (int i = 0; i < longs.length; ++i) {
            final int bpv = random().nextInt(64);
            bitsPerValues[i] = random().nextBoolean() ? bpv : TestUtil.nextInt(random(), bpv, 64);
            if (bpv == 64) {
                longs[i] = random().nextLong();
            } else {
                longs[i] = TestUtil.nextLong(random(), 0, PackedInts.maxValue(bpv));
            }
            skip[i] = rarely();
        }

        final Directory dir = newDirectory();
        final IndexOutput out = dir.createOutput("out.bin", IOContext.DEFAULT);
        PackedDataOutput pout = new PackedDataOutput(out);
        long totalBits = 0;
        for (int i = 0; i < longs.length; ++i) {
            pout.writeLong(longs[i], bitsPerValues[i]);
            totalBits += bitsPerValues[i];
            if (skip[i]) {
                pout.flush();
                totalBits = 8 * (long) Math.ceil((double) totalBits / 8);
            }
        }
        pout.flush();
        assertEquals((long) Math.ceil((double) totalBits / 8), out.getFilePointer());
        out.close();
        final IndexInput in = dir.openInput("out.bin", IOContext.READONCE);
        final PackedDataInput pin = new PackedDataInput(in);
        for (int i = 0; i < longs.length; ++i) {
            assertEquals("" + i, longs[i], pin.readLong(bitsPerValues[i]));
            if (skip[i]) {
                pin.skipToNextByte();
            }
        }
        assertEquals((long) Math.ceil((double) totalBits / 8), in.getFilePointer());
        in.close();
        dir.close();
    }

    @Test
    public void testLucene() {
        LuceneTestCase.rarely();
    }
}
