package io.github.swimmingsand.elasticsearch.AggregationsAPI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.AdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * Created by zlq on 11/26/16.
 */
public class AggregationsTest {
    private static Logger logger = LogManager.getLogger(AggregationsTest.class);

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

        IndicesExistsResponse indicesExistsResponse = adminClient.indices().prepareExists("twitter").get();
        logger.info(indicesExistsResponse);

        if (indicesExistsResponse.isExists()) {
            DeleteIndexResponse deleteIndexResponse = adminClient.indices().prepareDelete("twitter").get();
            logger.info(deleteIndexResponse);
        }


        String json = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";


        adminClient.indices().prepareCreate("twitter")
                .setSettings(Settings.builder()
                        .put("index.number_of_shards", 1)
                        .put("index.number_of_replicas", 0)
                )
                .get();

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



        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        QueryBuilder queryBuilder = QueryBuilders.termQuery("user", "kimchy");
        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("postDate").field("postDate");
        SearchResponse sr = transportClient.prepareSearch("twitter")
                .setQuery(new MatchAllQueryBuilder())
                .setQuery(queryBuilder)
                .addAggregation(aggregationBuilder)
                .execute().actionGet();

        logger.info(sr);

        queryBuilder = QueryBuilders.termQuery("user", "kimchya");
        QueryBuilder aggQueryBuilder = QueryBuilders.termQuery("user", "kimchy");
        aggregationBuilder = AggregationBuilders.global("all").subAggregation(
                AggregationBuilders.filter("user", aggQueryBuilder).subAggregation(
                        AggregationBuilders.terms("postDate").field("postDate")));
        sr = transportClient.prepareSearch("twitter")
                .setQuery(new MatchAllQueryBuilder())
                .setQuery(queryBuilder)
                .addAggregation(aggregationBuilder)
                .execute().actionGet();

        logger.info(sr);
    }
}
