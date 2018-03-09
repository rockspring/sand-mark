import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 */
public class HttpClientTest {


    public String parseStrToMd5L32(String str) throws Exception {
        String reStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bytes) {
                int bt = b & 0xff;
                if (bt < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(bt));
            }
            reStr = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return reStr;
    }

    @Test
    public void testMd5() throws Exception {
        String a = "123456";
        String md5 = parseStrToMd5L32("cmdb_api" + a);
        Assert.assertEquals("01ea4f23dee9f004477d4fc6c4572cd7", md5);
        System.out.println(md5);
    }

    public void getPool(Integer poolId) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://ops.corp.anjuke.com/api/cmdb/pool/id:";
        url += poolId.toString() + "?random=";
        Random random = new Random(System.currentTimeMillis());
        Integer randomInt = random.nextInt(Integer.MAX_VALUE) % 1000000;
        String md5 = parseStrToMd5L32("cmdb_api" + randomInt.toString());
        url += randomInt.toString() + "&access_token=" + md5;
        HttpGet httpGet = new HttpGet(url);
        //httpGet.setParams(null);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
// The underlying HTTP connection is still held by the response object
// to allow the response content to be streamed directly from the network socket.
// In order to ensure correct deallocation of system resources
// the user MUST call CloseableHttpResponse#close() from a finally clause.
// Please note that if response content is not fully consumed the underlying
// connection cannot be safely re-used and will be shut down and discarded
// by the connection manager.
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            //entity1.writeTo(System.out);
            ObjectMapper mapper = new ObjectMapper(); // create once, reuse
            Map<String, Object> result = mapper.readValue(entity1.getContent(), Map.class);
            LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) result.get("data");

            EntityUtils.consume(entity1);
        } finally {
            response1.close();
        }
    }

    @Test
    public void testHttpClient() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://ops.corp.anjuke.com/api/cmdb/host/ip:10.10.9.34";
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
// The underlying HTTP connection is still held by the response object
// to allow the response content to be streamed directly from the network socket.
// In order to ensure correct deallocation of system resources
// the user MUST call CloseableHttpResponse#close() from a finally clause.
// Please note that if response content is not fully consumed the underlying
// connection cannot be safely re-used and will be shut down and discarded
// by the connection manager.
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            //entity1.writeTo(System.out);
            ObjectMapper mapper = new ObjectMapper(); // create once, reuse
            Map<String, Object> result = mapper.readValue(entity1.getContent(), Map.class);
            List<LinkedHashMap<String, Object>> data = (ArrayList<LinkedHashMap<String, Object>>) result.get("data");
            List<Integer> poolIds = (ArrayList<Integer>) data.get(0).get("pool_ids");
            for (Integer poolId : poolIds) {
                System.out.println(poolId);

                getPool(poolId);
            }
            EntityUtils.consume(entity1);
        } finally {
            response1.close();
        }
    }
}
