package io.github.swimmingsand.elasticsearch.SearchAPI;

import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zlq on 11/25/16.
 */
public class MultiSearchTest {
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

        SearchRequestBuilder srb1 = transportClient
                .prepareSearch().setQuery(QueryBuilders.queryStringQuery("elasticsearch")).setSize(1);
        SearchRequestBuilder srb2 = transportClient
                .prepareSearch().setQuery(QueryBuilders.matchQuery("name", "kimchy")).setSize(1);

        MultiSearchResponse sr = transportClient.prepareMultiSearch()
                .add(srb1)
                .add(srb2)
                .execute().actionGet();

// You will get all individual responses from MultiSearchResponse#getResponses()
        long nbHits = 0;
        for (MultiSearchResponse.Item item : sr.getResponses()) {
            SearchResponse response = item.getResponse();
            nbHits += response.getHits().getTotalHits();
        }
    }
}
