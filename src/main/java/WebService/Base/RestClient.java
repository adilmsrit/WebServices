package WebService.Base;


import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

    CloseableHttpResponse closeableHttpResponse;

    //Get Method
    public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        closeableHttpResponse = httpClient.execute(httpGet);

        return closeableHttpResponse;
    }

    //Get Method with Headers.
    public CloseableHttpResponse get(String url, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            httpGet.addHeader(entry.getKey(), entry.getValue());
        }
        closeableHttpResponse = httpClient.execute(httpGet);

        return closeableHttpResponse;

    }

    public CloseableHttpResponse post (String url, String entityString, HashMap<String, String> headerMap) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(entityString));

        //for Headers.
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            httpPost.addHeader(entry.getKey(), entry.getValue());
        }

        closeableHttpResponse = httpClient.execute(httpPost);
        return closeableHttpResponse;

    }
}
