package WebService.Base;


import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.HashMap;

public class Client {
    //Get Method
    public void get(String url) throws Exception {

        try {

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);

            //a. Get the Status code.
            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            System.out.println("Status code --> " + statusCode);

            //b. Json String:
            String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
            System.out.println(responseString);


            JSONObject responseJson = new JSONObject(responseString);
            System.out.println("Response Jason from API --> " + responseJson);

            //c. Get all Headers.
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
