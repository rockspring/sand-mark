package com.anjuke.search.http;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zlq on 9/2/16.
 */
public class SlowHttpClientMain {
    private static final Logger logger = LogManager.getLogger(SlowHttpClientMain.class);

    public static void printUsage() {
        String cmdPrefix = "java";
        String cmdSuffix = " -jar slow-http-api-client-jar-with-dependencies.jar";
        System.out.println(cmdPrefix + cmdSuffix + " [serverConfigPath]");
        System.exit(1);
    }

    public static void startClient(String[] args) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("sleep", "1000");
        HttpUtil.get("http://127.0.0.1:8080/hello",params, 100000,100000);
    }

    public static void main(String[] args) throws Exception {
        startClient(args);
    }
}
