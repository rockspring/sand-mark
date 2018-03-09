package io.github.swimmingsand.elasticsearch.singleDocumentAPI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 12/27/14.
 */
public class GetTest {
    private static Logger logger = LogManager.getLogger(GetTest.class);

    @Test
    public void testGet() throws Exception {
        Settings.Builder settings = Settings.builder();
        settings.put("client.transport.sniff", true).build();

        //TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY.EMPTY);

        TransportClient transportClient = new PreBuiltTransportClient(settings.build());
        try {
            transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),
                    9300));
            transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),
                    9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        logger.info(transportClient.toString());


        GetResponse getResponse = transportClient.prepareGet("twitter", "tweet", "1").execute().actionGet();

        logger.info("index=" + getResponse.getIndex());
        logger.info("type=" + getResponse.getType());
        logger.info("id=" + getResponse.getId());
        logger.info("version=" + getResponse.getVersion());

        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        transportClient.close();
    }

    @Test
    public void testGet2() {
        Settings.Builder settings = Settings.builder();
        settings.put("client.transport.sniff", true).build();

        //TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY.EMPTY);

        TransportClient transportClient = new PreBuiltTransportClient(settings.build());
        try {
            transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),
                    9300));
            transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),
                    9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        logger.info(transportClient.toString());

        GetResponse getResponse = transportClient.prepareGet("twitter", "tweet", "1").setOperationThreaded(false)
                .execute().actionGet();

        logger.info("index=" + getResponse.getIndex());
        logger.info("type=" + getResponse.getType());
        logger.info("id=" + getResponse.getId());
        logger.info("version=" + getResponse.getVersion());

        transportClient.close();
    }
}
