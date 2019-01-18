package WebService.Base;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {

    CloseableHttpResponse closeableHttpResponse;

    //Get Method
    public CloseableHttpResponse get(String url) throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        closeableHttpResponse = httpClient.execute(httpGet);

        return closeableHttpResponse;
    }
}
