package WebService.Base;


import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

    CloseableHttpResponse closeableHttpResponse;

    //Get Method
    public CloseableHttpResponse get(String url) throws ClientProtocolException , IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        closeableHttpResponse = httpClient.execute(httpGet);

        return closeableHttpResponse;
    }

    //Get Method
    public CloseableHttpResponse get(String url, HashMap<String, String> headerMap) throws ClientProtocolException , IOException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        for (Map.Entry<String, String> entry : headerMap.entrySet()){
             httpGet.addHeader(entry.getKey(),entry.getValue());
        }
        closeableHttpResponse = httpClient.execute(httpGet);

        return closeableHttpResponse;

    }
}
