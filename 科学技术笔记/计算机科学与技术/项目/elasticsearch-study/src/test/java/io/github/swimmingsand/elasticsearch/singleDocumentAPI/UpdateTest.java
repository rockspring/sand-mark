package io.github.swimmingsand.elasticsearch.singleDocumentAPI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.ListenableActionFuture;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.script.Script;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

/**
 * Created by zlq on 12/27/14.
 */
public class UpdateTest {

    private static Logger logger = LogManager.getLogger(UpdateTest.class);

    @Test
    public void testIndex() {
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
                "\"gender\":\"male\"}";

        IndexRequestBuilder indexRequestBuilder = transportClient.prepareIndex("index", "type", "1");
        indexRequestBuilder = indexRequestBuilder.setSource(json);
        ListenableActionFuture<IndexResponse> future = indexRequestBuilder.execute();
        IndexResponse indexResponse = future.actionGet();

        logger.info("index=" + indexResponse.getIndex());
        logger.info("type=" + indexResponse.getType());
        logger.info("id=" + indexResponse.getId());
        logger.info("version=" + indexResponse.getVersion());

        transportClient.close();
    }

    @Test
    public void testIndex2() {
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
                "\"gender\":\"male\"}";

        IndexRequestBuilder indexRequestBuilder = transportClient.prepareIndex("ttl", "doc", "1");
        indexRequestBuilder = indexRequestBuilder.setSource(json);
        ListenableActionFuture<IndexResponse> future = indexRequestBuilder.execute();
        IndexResponse indexResponse = future.actionGet();

        logger.info("index=" + indexResponse.getIndex());
        logger.info("type=" + indexResponse.getType());
        logger.info("id=" + indexResponse.getId());
        logger.info("version=" + indexResponse.getVersion());

        transportClient.close();
    }

    @Test
    public void testUpdate() throws IOException {
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

        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("index");
        updateRequest.type("type");
        updateRequest.id("1");
        updateRequest.doc(XContentFactory.jsonBuilder()
                .startObject()
                .field("gender", "male")
                .endObject());

        UpdateResponse updateResponse = null;

        try {
            updateResponse = transportClient.update(updateRequest).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        logger.info("index=" + updateResponse.getIndex());
        logger.info("type=" + updateResponse.getType());
        logger.info("id=" + updateResponse.getId());
        logger.info("version=" + updateResponse.getVersion());

        transportClient.close();
    }

    @Test
    public void testUpdate2() throws IOException {
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

        UpdateResponse updateResponse = null;

        UpdateRequestBuilder updateRequestBuilder = transportClient.prepareUpdate("ttl", "doc", "1");
        Script script = new Script("ctx._source.gender = \"female\"");
        updateRequestBuilder.setScript(script);
        updateResponse = updateRequestBuilder.get();

        logger.info("index=" + updateResponse.getIndex());
        logger.info("type=" + updateResponse.getType());
        logger.info("id=" + updateResponse.getId());
        logger.info("version=" + updateResponse.getVersion());

        updateResponse = transportClient.prepareUpdate("ttl", "doc", "1")
                .setDoc(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("gender", "male")
                        .endObject())
                .get();

        logger.info("index=" + updateResponse.getIndex());
        logger.info("type=" + updateResponse.getType());
        logger.info("id=" + updateResponse.getId());
        logger.info("version=" + updateResponse.getVersion());

        transportClient.close();
    }

    @Test
    public void testUpdate3() throws IOException {
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

        UpdateResponse updateResponse = null;

        UpdateRequest updateRequest = new UpdateRequest("ttl", "doc", "1")
                .script("ctx._source.gender = \"male\"");
        try {
            updateResponse = transportClient.update(updateRequest).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        logger.info("index=" + updateResponse.getIndex());
        logger.info("type=" + updateResponse.getType());
        logger.info("id=" + updateResponse.getId());
        logger.info("version=" + updateResponse.getVersion());

        transportClient.close();
    }

    @Test
    public void testUpdateByMerging() throws IOException {
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

        UpdateResponse updateResponse = null;

        UpdateRequest updateRequest = new UpdateRequest("index", "type", "1")
                .doc(XContentFactory.jsonBuilder()
                        .startObject()
                        //.field("gender", "male")
                        .field("age", "27")
                        .endObject());

        try {
            updateResponse = transportClient.update(updateRequest).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        logger.info("index=" + updateResponse.getIndex());
        logger.info("type=" + updateResponse.getType());
        logger.info("id=" + updateResponse.getId());
        logger.info("version=" + updateResponse.getVersion());

        transportClient.close();
    }

    @Test
    public void testUpsert() throws IOException {
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

        UpdateResponse updateResponse = null;

        IndexRequest indexRequest = new IndexRequest("index", "type", "1")
                .source(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("name", "Joe Smith")
                        .field("gender", "male")
                        .endObject());


        UpdateRequest updateRequest = new UpdateRequest("index", "type", "1")
                .doc(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("gender", "male")
                        .field("age", "27")
                        .endObject())
                .upsert(indexRequest);

        try {
            updateResponse = transportClient.update(updateRequest).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        logger.info("index=" + updateResponse.getIndex());
        logger.info("type=" + updateResponse.getType());
        logger.info("id=" + updateResponse.getId());
        logger.info("version=" + updateResponse.getVersion());

        transportClient.close();
    }
}
