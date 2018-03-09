package io.github.swimmingsand.elasticsearch.SearchAPI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.ListenableActionFuture;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zlq on 12/27/14.
 */
public class SearchTest {
    private static Logger logger = LogManager.getLogger(SearchTest.class);

    @Test
    public void testSearch() {
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

        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch("index", "twitter")
                .setTypes("type", "tweet")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("user", "kimchy"))             // Query
                //.setPostFilter(FilterBuilders.rangeFilter("age").from(12).to(18))   // Filter
                .setFrom(0).setSize(60).setExplain(true);

        ListenableActionFuture<SearchResponse> future = searchRequestBuilder.execute();
        SearchResponse searchResponse = future.actionGet();

        logger.info("hits=" + searchResponse.getHits());
        logger.info("total=" + searchResponse.getHits().getTotalHits());
        logger.info("time=" + searchResponse.getTook().toString());
        logger.info("response=\n" + searchResponse.toString());

        transportClient.close();
    }

    @Test
    public void testSearch2() {
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
            for (int i = 0; i < 100; i++) {
                IndexRequestBuilder indexRequestBuilder = transportClient.prepareIndex("test_search2", "test", String.valueOf(i));
                indexRequestBuilder.setSource(XContentFactory.jsonBuilder()
                        .startObject()
                        .field("data", "data" + String.valueOf(i))
                        .endObject()
                ).execute();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch("test_search2")
                .setTypes("test")
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                .setScroll(new TimeValue(60000))
                .setQuery(QueryBuilders.matchAllQuery())             // Query
                //.setPostFilter(FilterBuilders.rangeFilter("age").from(12).to(18))   // Filter
                .setSize(5).setExplain(true);

        SearchResponse scrollResp = searchRequestBuilder.execute().actionGet();

        //returned for each scroll
        //Scroll until no hits are returned
        while (true) {

            for (SearchHit hit : scrollResp.getHits()) {
                //Handle the hit...
                logger.info("_index", hit.getIndex());
                logger.info("_type", hit.getType());
                logger.info("id=" + hit.getId());
                logger.info("score=" + hit.getScore());
                logger.info("source=\n" + hit.getSourceAsString());
                logger.info("explain=\n" + hit.getExplanation().toString());

            }
            scrollResp = transportClient.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(600000)).execute().actionGet();
            //Break condition: No hits are returned
            if (scrollResp.getHits().getHits().length == 0) {
                break;
            }
        }

        transportClient.close();
    }

    @Test
    public void testMultiSearch() {
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

        SearchRequestBuilder searchRequestBuilder1 = transportClient.prepareSearch("twitter")
                .setTypes("tweet")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("user", "kimchy"))             // Query
                //.setPostFilter(FilterBuilders.rangeFilter("age").from(12).to(18))   // Filter
                .setFrom(0).setSize(60).setExplain(true);

        SearchRequestBuilder searchRequestBuilder2 = transportClient.prepareSearch("test_search2")
                .setTypes("test")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("data", "data1"))             // Query
                //.setPostFilter(FilterBuilders.rangeFilter("age").from(12).to(18))   // Filter
                .setFrom(0).setSize(60).setExplain(true);

        MultiSearchResponse multiSearchResponse = transportClient.prepareMultiSearch()
                .add(searchRequestBuilder1)
                .add(searchRequestBuilder2)
                .execute()
                .actionGet();

        // You will get all individual responses from MultiSearchResponse#getResponses()
        long nbHits = 0;
        for (MultiSearchResponse.Item item : multiSearchResponse.getResponses()) {
            SearchResponse searchResponse = item.getResponse();
            nbHits += searchResponse.getHits().getTotalHits();
            logger.info("hits=" + searchResponse.getHits());
            logger.info("total=" + searchResponse.getHits().getTotalHits());
            logger.info("time=" + searchResponse.getTook().toString());
            logger.info("response=\n" + searchResponse.toString());
        }

        logger.info("nbHits=" + String.valueOf(nbHits));

        transportClient.close();
    }

    @Test
    public void testAggregation() {
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

        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch("twitter")
                .setTypes("tweet")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchAllQuery())
                .addAggregation(AggregationBuilders.terms("kimchy").field("user"))
                .setFrom(0).setSize(60).setExplain(true);

        ListenableActionFuture<SearchResponse> future = searchRequestBuilder.execute();
        SearchResponse searchResponse = future.actionGet();

        logger.info("hits=" + searchResponse.getHits());
        logger.info("total=" + searchResponse.getHits().getTotalHits());
        logger.info("time=" + searchResponse.getTook().toString());
        logger.info("response=\n" + searchResponse.toString());

        // Get your facet results
        Terms agg1 = searchResponse.getAggregations().get("kimchy");


        transportClient.close();
    }

    @Test
    public void testSearchTemplate() {
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

        Map<String, Object> template_params = new HashMap<String, Object>();
        template_params.put("param_user", "kimchy");

        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch("twitter")
                .setTypes("tweet");
        //.setTemplateName("template_user")
        //.setTemplateType(ScriptService.ScriptType.INLINE)
        //.setTemplateParams(template_params);

        ListenableActionFuture<SearchResponse> future = searchRequestBuilder.execute();
        SearchResponse searchResponse = future.actionGet();

        logger.info("hits=" + searchResponse.getHits());
        logger.info("total=" + searchResponse.getHits().getTotalHits());
        logger.info("time=" + searchResponse.getTook().toString());
        logger.info("response=\n" + searchResponse.toString());

        transportClient.close();
    }

    @Test
    public void testSearchTemplate2() {
        // TODO
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

        String jsonStr = "{\n" +
                "    \"template_user\" : {\n" +
                "        \"query\" : {\n" +
                "            \"match\" : {\n" +
                "                \"user\" : \"{{param_user}}\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

        /**transportClient.prepareIndex(".scripts","template_gender")
         .setSource(jsonStr)
         .execute()
         .actionGet();

         transportClient.preparePutIndexedScript("mustache", "template_gender",
         "{\n" +
         "    \"template\" : {\n" +
         "        \"query\" : {\n" +
         "            \"match\" : {\n" +
         "                \"user\" : \"{{param_user}}\"\n" +
         "            }\n" +
         "        }\n" +
         "    }\n" +
         "}").get();**/

        Map<String, Object> template_params = new HashMap<String, Object>();
        template_params.put("param_user", "kimchy");

        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch("twitter")
                .setTypes("tweet");
        //.setTemplateName("template_user")
        //.setTemplateSource(jsonStr)
        //.setTemplateType(ScriptService.ScriptType.INLINE)
        //.setTemplateParams(template_params);

        ListenableActionFuture<SearchResponse> future = searchRequestBuilder.execute();
        SearchResponse searchResponse = future.actionGet();

        logger.info("hits=" + searchResponse.getHits());
        logger.info("total=" + searchResponse.getHits().getTotalHits());
        logger.info("time=" + searchResponse.getTook().toString());
        logger.info("response=\n" + searchResponse.toString());

        transportClient.close();
    }
}
