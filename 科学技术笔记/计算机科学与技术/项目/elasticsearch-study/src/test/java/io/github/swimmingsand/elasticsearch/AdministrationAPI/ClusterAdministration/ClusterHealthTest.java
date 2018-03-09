package io.github.swimmingsand.elasticsearch.AdministrationAPI.ClusterAdministration;

import io.github.swimmingsand.elasticsearch.singleDocumentAPI.IndexTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.client.AdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.health.ClusterHealthStatus;
import org.elasticsearch.cluster.health.ClusterIndexHealth;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zlq on 11/26/16.
 */
public class ClusterHealthTest {
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

        ClusterHealthResponse healths = adminClient.cluster().prepareHealth().get();
        String clusterName = healths.getClusterName();
        int numberOfDataNodes = healths.getNumberOfDataNodes();
        int numberOfNodes = healths.getNumberOfNodes();

        for (ClusterIndexHealth health : healths.getIndices().values()) {
            String index = health.getIndex();
            int numberOfShards = health.getNumberOfShards();
            int numberOfReplicas = health.getNumberOfReplicas();
            ClusterHealthStatus status = health.getStatus();

            logger.info(status.toString());
        }
    }

    @Test
    public void testWaitForStatus() {
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

        ClusterHealthResponse healths = adminClient.cluster().prepareHealth().get();
        String clusterName = healths.getClusterName();
        int numberOfDataNodes = healths.getNumberOfDataNodes();
        int numberOfNodes = healths.getNumberOfNodes();

        for (ClusterIndexHealth health : healths.getIndices().values()) {
            String index = health.getIndex();
            int numberOfShards = health.getNumberOfShards();
            int numberOfReplicas = health.getNumberOfReplicas();
            ClusterHealthStatus status = health.getStatus();

            logger.info(status.toString());
        }

        adminClient.cluster().prepareHealth()
                .setWaitForYellowStatus()
                .get();
        adminClient.cluster().prepareHealth("company")
                .setWaitForGreenStatus()
                .get();

        adminClient.cluster().prepareHealth("employee")
                .setWaitForGreenStatus()
                .setTimeout(TimeValue.timeValueSeconds(2))
                .get();
    }

    @Test
    public void testStatusInterpret() {
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

        ClusterHealthResponse healths = adminClient.cluster().prepareHealth().get();
        String clusterName = healths.getClusterName();
        int numberOfDataNodes = healths.getNumberOfDataNodes();
        int numberOfNodes = healths.getNumberOfNodes();

        for (ClusterIndexHealth health : healths.getIndices().values()) {
            String index = health.getIndex();
            int numberOfShards = health.getNumberOfShards();
            int numberOfReplicas = health.getNumberOfReplicas();
            ClusterHealthStatus status = health.getStatus();

            logger.info(status.toString());
        }

        ClusterHealthResponse response = adminClient.cluster().prepareHealth("company")
                .setWaitForGreenStatus()
                .get();

        ClusterHealthStatus status = response.getIndices().get("company").getStatus();
        if (!status.equals(ClusterHealthStatus.GREEN)) {
            throw new RuntimeException("Index is in " + status + " state");
        }
    }
}
