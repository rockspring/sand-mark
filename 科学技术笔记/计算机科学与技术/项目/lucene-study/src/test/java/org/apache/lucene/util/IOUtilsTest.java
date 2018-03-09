package org.apache.lucene.util;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by zlq on 6/10/15.
 */
public class IOUtilsTest {

    @Test
    public void test() throws IOException{
        IOUtils.getFileStore(Paths.get("/tmp"));
        IOUtils.spinsLinux(Paths.get("/tmp"));
    }

    @Test
    public void test2() {

    }
}
