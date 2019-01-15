package WebService;


import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

@Test
public class Client {
    public void get(String url) throws Exception {

        try {

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);

            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            System.out.println("Status code --> " + statusCode);

            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
            System.out.println(responseString);

            JSONObject responseJson = new JSONObject(responseString);
            System.out.println(responseJson);

            Header[] headersArray = closeableHttpResponse.getAllHeaders();

            HashMap<String, String> allHeaders = new HashMap<String, String>();

            for (Header header : headersArray){
                allHeaders.put(header.getName(), header.getValue());

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
