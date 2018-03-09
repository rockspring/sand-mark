package io.github.swimmingsand.elasticsearch.singleDocumentAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zlq on 11/25/16.
 */
public class IndexTest {
    private static Logger logger = LogManager.getLogger(IndexTest.class);

    @Test
    public void testUseString() {
        Settings.Builder settings = Settings.builder();
        settings.put("client.transport.sniff", true);
        settings.put("client.transport.ignore_cluster_name", true);
        settings.put("client.transport.ping_timeout", "5s");
        settings.put("client.transport.nodes_sampler_interval", "5s");

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

        String json = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";

        IndexResponse response = transportClient.prepareIndex("twitter", "tweet")
                .setSource(json)
                .get();

        System.out.println(response);

        // Index name
        String _index = response.getIndex();
// Type name
        String _type = response.getType();
// Document ID (generated or not)
        String _id = response.getId();
// Version (if it's the first time you index this document, you will get: 1)
        long _version = response.getVersion();

        logger.info("index=" + response.getIndex());
        logger.info("type=" + response.getType());
        logger.info("id=" + response.getId());
        logger.info("version=" + response.getVersion());
    }

    @Test
    public void testUseMap() {
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("user","kimchy");
        json.put("postDate",new Date());
        json.put("message","trying out Elasticsearch");
    }

    @Test
    public void testUseBean() {
        DocumentBean yourbeaninstance = new DocumentBean();
        // instance a json mapper
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse

        // generate json
        try {
            byte[] json = mapper.writeValueAsBytes(yourbeaninstance);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUseElasticsearchHelper() throws IOException{
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

        XContentBuilder builder = JsonXContent.contentBuilder().startObject()
                .field("user", "kimchy")
                .field("postDate", new Date())
                .field("message", "trying out Elasticsearch")
                .endObject();

        String content = builder.string();
        System.out.println(content);

        IndexResponse response = transportClient.prepareIndex("twitter", "tweet", "1")
                .setSource(builder)
                .get();

        System.out.println(response);
    }
}
