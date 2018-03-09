package io.github.swimmingsand.lucene;

import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.BytesRefBuilder;
import org.apache.lucene.util.IntsRef;
import org.apache.lucene.util.IntsRefBuilder;
import org.apache.lucene.util.fst.Builder;
import org.apache.lucene.util.fst.ByteSequenceOutputs;
import org.apache.lucene.util.fst.BytesRefFSTEnum;
import org.apache.lucene.util.fst.BytesRefFSTEnum.InputOutput;
import org.apache.lucene.util.fst.FST;
import org.apache.lucene.util.fst.FST.INPUT_TYPE;
import org.apache.lucene.util.fst.Outputs;
import org.apache.lucene.util.fst.Util;
import org.apache.lucene.util.packed.PackedInts;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystems;

/**
 * Created by zlq on 4/23/15.
 */
public class FSTTest {

    @Test
    public void testFST() throws IOException {
        String inputValues[] = {"ab", "abd", "abe", "acf"};

        byte[] outputValues[] = {{1}, {1, 2}, {3, 4}, {5, 6}};

        Outputs<BytesRef> outputs = ByteSequenceOutputs.getSingleton();

        Builder<BytesRef> builder = new Builder<BytesRef>(INPUT_TYPE.BYTE1, outputs);

        BytesRef scracthBytes = new BytesRef();

        BytesRefBuilder scracthBytesBuilder = new BytesRefBuilder();

        IntsRef scratchInts = new IntsRef();

        IntsRefBuilder scratchIntsBuilder = new IntsRefBuilder();
        BytesRef inputBytesRef = new BytesRef();
        BytesRefBuilder inputBytesRefBuilder = new BytesRefBuilder();

        for (int i = 0; i < inputValues.length; i++) {
            scracthBytesBuilder.copyChars(inputValues[i]);
            builder.add(Util.toIntsRef(scracthBytesBuilder.toBytesRef(), scratchIntsBuilder),
                    new BytesRef(outputValues[i]));
        }

        FST<BytesRef> fst = builder.finish();

        BytesRef value = Util.get(fst, new BytesRef("acf"));

        System.out.println(value);
    }

    @Test
    public void testFSTdoPack() throws IOException {
        String inputValues[] = {"abef", "bef", "cef", "def"};

        byte[] outputValues[] = {{1}, {1, 2}, {3, 4}, {5, 6}};

        Outputs<BytesRef> outputs = ByteSequenceOutputs.getSingleton();

        Builder<BytesRef> builder =
                new Builder<BytesRef>(INPUT_TYPE.BYTE1, 0, 0, true, true, Integer.MAX_VALUE, outputs,
                        true, PackedInts.COMPACT, true, 1);

        BytesRef scracthBytes = new BytesRef();

        BytesRefBuilder scracthBytesBuilder = new BytesRefBuilder();

        IntsRef scratchInts = new IntsRef();

        IntsRefBuilder scratchIntsBuilder = new IntsRefBuilder();

        for (int i = 0; i < inputValues.length; i++) {
            scracthBytesBuilder.copyChars(inputValues[i]);
            builder.add(Util.toIntsRef(scracthBytesBuilder.toBytesRef(), scratchIntsBuilder),
                    new BytesRef(outputValues[i]));
        }

        FST<BytesRef> fst = builder.finish();

        BytesRef value = Util.get(fst, new BytesRef("acf"));

        System.out.println(value);
    }

    @Test
    public void testFSTdoPack2() throws IOException {
        //String inputValues[] ={"abd", "abe", "汉"};

        //String inputValues[] ={"ab", "abc", "abcd"};
        String inputValues[] = {"ab", "ac", "ad"};

        byte[] outputValues[] = {{1, 2}, {1, 4}, {5, 6}};

        Outputs<BytesRef> outputs = ByteSequenceOutputs.getSingleton();

        Builder<BytesRef> builder =
                new Builder<BytesRef>(INPUT_TYPE.BYTE1, 0, 0, true, true, Integer.MAX_VALUE, outputs,
                        true, PackedInts.COMPACT, true, 15);

        BytesRef scracthBytes = new BytesRef();

        BytesRefBuilder scracthBytesBuilder = new BytesRefBuilder();

        IntsRef scratchInts = new IntsRef();

        IntsRefBuilder scratchIntsBuilder = new IntsRefBuilder();

        for (int i = 0; i < inputValues.length; i++) {
            scracthBytesBuilder.copyChars(inputValues[i]);
            builder.add(Util.toIntsRef(scracthBytesBuilder.toBytesRef(), scratchIntsBuilder),
                    new BytesRef(outputValues[i]));
        }

        FST<BytesRef> fst = builder.finish();
        fst.save(FileSystems.getDefault().getPath("/tmp/fst"));

        BytesRef value = Util.get(fst, new BytesRef("abcd"));

        BytesRefFSTEnum bytesRefFSTEnum = new BytesRefFSTEnum(fst);

        InputOutput<BytesRef> inputOutput = null;

        while ((inputOutput = bytesRefFSTEnum.next()) != null) {
            System.out.print(inputOutput.input);
            System.out.print(" --> ");
            System.out.println(inputOutput.output);
        }

        System.out.println(value);
    }

    @Test
    public void testFST2() throws IOException {
        //String inputValues[] ={"abd", "abe", "汉"};

        //String inputValues[] ={"ab", "abc", "abcd"};
        String inputValues[] = {"ab", "ac", "ad"};

        byte[] outputValues[] = {{1, 2}, {1, 4}, {5, 6}};

        Outputs<BytesRef> outputs = ByteSequenceOutputs.getSingleton();

        Builder<BytesRef> builder = new Builder<BytesRef>(INPUT_TYPE.BYTE1, outputs);

        BytesRef scracthBytes = new BytesRef();

        BytesRefBuilder scracthBytesBuilder = new BytesRefBuilder();

        IntsRef scratchInts = new IntsRef();

        IntsRefBuilder scratchIntsBuilder = new IntsRefBuilder();

        for (int i = 0; i < inputValues.length; i++) {
            scracthBytesBuilder.copyChars(inputValues[i]);
            builder.add(Util.toIntsRef(scracthBytesBuilder.toBytesRef(), scratchIntsBuilder),
                    new BytesRef(outputValues[i]));
        }

        FST<BytesRef> fst = builder.finish();
        fst.save(FileSystems.getDefault().getPath("/tmp/fst"));

        BytesRef value = Util.get(fst, new BytesRef("abcd"));

        BytesRefFSTEnum bytesRefFSTEnum = new BytesRefFSTEnum(fst);

        InputOutput<BytesRef> inputOutput = null;

        while ((inputOutput = bytesRefFSTEnum.next()) != null) {
            System.out.print(inputOutput.input);
            System.out.print(" --> ");
            System.out.println(inputOutput.output);
        }

        System.out.println(value);
    }
}

