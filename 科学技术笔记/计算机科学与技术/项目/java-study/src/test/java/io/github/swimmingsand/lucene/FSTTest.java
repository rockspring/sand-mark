package io.github.swimmingsand.lucene;

import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.BytesRefBuilder;
import org.apache.lucene.util.IntsRef;
import org.apache.lucene.util.IntsRefBuilder;
import org.apache.lucene.util.fst.ByteSequenceOutputs;
import org.apache.lucene.util.fst.Builder;
import org.apache.lucene.util.fst.FST;
import org.apache.lucene.util.fst.FST.INPUT_TYPE;
import org.apache.lucene.util.fst.Outputs;
import org.apache.lucene.util.fst.Util;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by zlq on 4/23/15.
 */
public class FSTTest {

    @Test
    public void testFST() throws IOException {
        String inputValues[] ={"abd", "abe", "acf"};

        byte[] outputValues[] = {{1, 2}, {3, 4}, {5, 6}};

        Outputs<BytesRef> outputs = ByteSequenceOutputs.getSingleton();

        Builder<BytesRef> builder = new Builder<BytesRef>(INPUT_TYPE.BYTE1, outputs);

        BytesRef scracthBytes = new BytesRef();

        BytesRefBuilder scracthBytesBuilder = new BytesRefBuilder();

        IntsRef scratchInts = new IntsRef();

        IntsRefBuilder scratchIntsBuilder = new IntsRefBuilder();

        for (int i=0;i < inputValues.length; i++) {
            scracthBytesBuilder.copyChars(inputValues[i]);
            builder.add(Util.toIntsRef(scracthBytesBuilder.toBytesRef(), scratchIntsBuilder), new BytesRef(outputValues[i]));
        }

        FST<BytesRef> fst = builder.finish();

        BytesRef value = Util.get(fst, new BytesRef("acf"));

        System.out.println(value);
    }
}
