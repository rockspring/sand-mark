package io.github.swimmingsand.hadoop1x;

import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    static {
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}
    public static void main( String[] args )
    {
    	System.out.println("start");
        InputStream in = null;
        try {
			in = new URL("hdfs://10.10.8.151:50075/tmp/chenlei/20140608/G1_worker1_access_log_201406082057_log").openStream();
			IOUtils.copy(in, System.out);
		} catch (Exception e) {
			IOUtils.closeQuietly(in);
		}
    }
}
