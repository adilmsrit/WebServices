package WebService;

import WebService.Base.BaseClass;
import WebService.Base.RestClient;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class GetAPITest extends BaseClass {
    BaseClass baseClass;
    String serviceUrl;
    String apiUrl;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;

    @BeforeMethod
    public void setup() {
        baseClass = new BaseClass();
        url = "https://reqres.in/api/users";
    }

    @Test
    public void getAPITest() throws Exception {
        restClient = new RestClient();
        closeableHttpResponse = restClient.get(url);

        //a. Get the Status code.
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code --> " + statusCode);

        //b. Json String:
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response Jason from API --> " + responseJson);

        //c. Get all Headers.
        Header[] headersArray = closeableHttpResponse.getAllHeaders();

        HashMap<String, String> allHeaders = new HashMap<String, String>();

        for (Header header : headersArray) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Header Array -->" + allHeaders);

    }


}
