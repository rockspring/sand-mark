package io.github.swimmingsand;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        ArrayList<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(MediaType.ALL);
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new
                MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        messageConverters.add(mappingJackson2HttpMessageConverter);
        RestTemplate restTemplate = new RestTemplate(messageConverters);
        String urlStr = "http://search.anjuke.test/search/universal/v1?m=s&query=city_id=11";
        URL url = new URL("http://search.anjuke.test/search/universal/v1?m=s&query=city_id=11");
        HashMap response = restTemplate.getForObject(urlStr, HashMap.class);

        System.out.println(response);
        HashMap responseMap = (HashMap) response.get("response");
        Map verSearchResultCombine = (HashMap) responseMap.get("verSearchResultCombine");
        int totalCount = (Integer) verSearchResultCombine.get("totalCount");
        int resultCount = (Integer) responseMap.get("resultCount");
        System.out.println(resultCount);
        System.out.println(totalCount);
    }
}
