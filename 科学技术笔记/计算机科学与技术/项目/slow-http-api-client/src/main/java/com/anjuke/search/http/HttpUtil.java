package com.anjuke.search.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * Created by zlq on 9/2/16.
 */
public class HttpUtil {
    private static final Logger logger = LogManager.getLogger(HttpUtil.class);

    /**
     * @param url    请求url
     * @param params 请求参数
     * @return
     */
    public static String get(String url, Map<String, String> params) {
        return get(url, params, 1000, 1000);
    }

    /**
     * @param url            请求url,如http://search.tj.a.ajkdns.com/search/universal
     * @param params         请求参数,如m=s&query=is_list=1
     * @param connectTimeout 连接超时时间,ms
     * @param socketTimeout  传输超时时间,ms
     * @return
     */
    public static String get(String url, Map<String, String> params, final int connectTimeout, final int socketTimeout) {
        long start = System.currentTimeMillis();
        URI uri = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(url);

            for (Map.Entry<String, String> entry : params.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue());
            }
            uri = uriBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpGet httpget = new HttpGet(uri);
        String responseBody = null;

        CloseableHttpClient httpclient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout).setSocketTimeout(socketTimeout).build();
        //设置请求和传输超时时间
        httpget.setConfig(requestConfig);

        try {
            logger.trace("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                //@Override
                public String handleResponse(
                        final HttpResponse response) throws IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status == 200) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        logger.error("status=" + status + ";response=" + response);
                        return null;
                    }
                }
            };

            try {
                responseBody = httpclient.execute(httpget, responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (null == responseBody) {
                logger.error("httpclient execute error:url=" + uri);
            }
            long end = System.currentTimeMillis();
            logger.info(httpget.getRequestLine() + "\t" + (end - start));
            return responseBody;
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
