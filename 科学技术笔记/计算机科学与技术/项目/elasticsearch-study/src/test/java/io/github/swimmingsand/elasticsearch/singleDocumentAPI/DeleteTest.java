package io.github.swimmingsand.elasticsearch.singleDocumentAPI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zlq on 12/27/14.
 */
public class DeleteTest {
    private static Logger logger = LogManager.getLogger(DeleteTest.class);

    @Test
    public void testDelete() {
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

        DeleteResponse response = transportClient.prepareDelete("twitter", "tweet", "1").execute().actionGet();

        logger.info("index=" + response.getIndex());
        logger.info("type=" + response.getType());
        logger.info("id=" + response.getId());
        logger.info("version=" + response.getVersion());

        transportClient.close();
    }

    @Test
    public void testDelete2() {
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


        DeleteResponse response = transportClient.prepareDelete("twitter", "tweet", "1")
                .execute().actionGet();

        logger.info("index=" + response.getIndex());
        logger.info("type=" + response.getType());
        logger.info("id=" + response.getId());
        logger.info("version=" + response.getVersion());

        transportClient.close();
    }
}
