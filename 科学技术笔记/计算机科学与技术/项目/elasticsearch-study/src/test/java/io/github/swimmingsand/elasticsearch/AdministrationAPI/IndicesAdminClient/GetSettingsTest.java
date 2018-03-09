package io.github.swimmingsand.elasticsearch.AdministrationAPI.IndicesAdminClient;

import com.carrotsearch.hppc.cursors.ObjectObjectCursor;
import io.github.swimmingsand.elasticsearch.singleDocumentAPI.IndexTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.settings.get.GetSettingsResponse;
import org.elasticsearch.client.AdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zlq on 11/26/16.
 */
public class GetSettingsTest {
    private static Logger logger = LogManager.getLogger(IndexTest.class);

    @Before
    public void prepare() {
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

        AdminClient adminClient = transportClient.admin();

        DeleteIndexResponse deleteIndexResponse = adminClient.indices().prepareDelete("twitter").get();

        logger.info(deleteIndexResponse);
    }

    @Test
    public void test() {
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

        AdminClient adminClient = transportClient.admin();

        adminClient.indices().prepareCreate("twitter").get();
        adminClient.indices().prepareCreate("employee").get();

        GetSettingsResponse response = adminClient.indices()
                .prepareGetSettings("company", "employee").get();
        for (ObjectObjectCursor<String, Settings> cursor : response.getIndexToSettings()) {
            String index = cursor.key;
            Settings getSettings = cursor.value;
            Integer shards = getSettings.getAsInt("index.number_of_shards", null);
            Integer replicas = getSettings.getAsInt("index.number_of_replicas", null);
        }
    }
}
