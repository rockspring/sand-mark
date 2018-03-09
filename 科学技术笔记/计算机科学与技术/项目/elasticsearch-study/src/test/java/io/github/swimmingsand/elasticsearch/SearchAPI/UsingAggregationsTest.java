package io.github.swimmingsand.elasticsearch.SearchAPI;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zlq on 11/25/16.
 */
public class UsingAggregationsTest {
    public void test() {
        Settings.Builder settings = Settings.builder();
        settings.put("client.transport.sniff", true);
        settings.put("client.transport.ignore_cluster_name", true);
        settings.put("client.transport.ping_timeout", 5);
        settings.put("client.transport.nodes_sampler_interval", 5);

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

        SearchResponse sr = transportClient.prepareSearch()
                .setQuery(QueryBuilders.matchAllQuery())
                .addAggregation(
                        //    public static FilterAggregationBuilder filter(String name, QueryBuilder filter)
                        AggregationBuilders.terms("agg1").field("field")
                )
                .addAggregation(
                        AggregationBuilders.dateHistogram("agg2")
                                .field("birth")
                                .dateHistogramInterval(DateHistogramInterval.YEAR)
                )
                .execute().actionGet();

// Get your facet results
        Terms agg1 = sr.getAggregations().get("agg1");
        DateHistogramInterval agg2 = sr.getAggregations().get("agg2");
    }

    public void test2() {
        Settings.Builder settings = Settings.builder();
        settings.put("client.transport.sniff", true);
        settings.put("client.transport.ignore_cluster_name", true);
        settings.put("client.transport.ping_timeout", 5);
        settings.put("client.transport.nodes_sampler_interval", 5);

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

        SearchResponse sr = transportClient.prepareSearch()
                .setQuery(QueryBuilders.matchAllQuery())
                .addAggregation(
                        //    public static FilterAggregationBuilder filter(String name, QueryBuilder filter)
                        AggregationBuilders.global("").subAggregation(AggregationBuilders.dateHistogram("agg2")
                                .field("birth")
                                .dateHistogramInterval(DateHistogramInterval.YEAR)))
                .addAggregation(
                        AggregationBuilders.dateHistogram("agg2")
                                .field("birth")
                                .dateHistogramInterval(DateHistogramInterval.YEAR)
                )
                .execute().actionGet();

// Get your facet results
        Terms agg1 = sr.getAggregations().get("agg1");
        DateHistogramInterval agg2 = sr.getAggregations().get("agg2");
    }
}
