package WebService;

import WebService.Base.BaseClass;
import WebService.Base.RestClient;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.util.HashMap;

public class GetAPITest extends BaseClass {
    BaseClass baseClass;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;

    @BeforeMethod
    public void setup() {
        baseClass = new BaseClass();
        url = "https://reqres.in/api/users";
    }

    @Test(priority = 0)
    public void getAPITest() throws Exception {
        restClient = new RestClient();
        closeableHttpResponse = restClient.get(url);

        //a. Get the Status code.
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code --> " + statusCode);

        Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");


        //b. Json String:
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response Jason from API --> " + responseJson);

        String s = TestUtils.getValueByJPath(responseJson, "/total");

        System.out.println("total is --> " + s);
        Assert.assertEquals(Integer.parseInt(s), 12);

        String lastName = TestUtils.getValueByJPath(responseJson, "/data[0]/last_name"); // This is to pull out data from the array.
        String id = TestUtils.getValueByJPath(responseJson, "/data[0]/id"); // This is to pull out data from the array.


        //c. Get all Headers.
        Header[] headersArray = closeableHttpResponse.getAllHeaders();

        HashMap<String, String> allHeaders = new HashMap<String, String>();

        for (Header header : headersArray) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Header Array -->" + allHeaders);


    }

    @Test(priority = 1)
    public void getAPITestWithHeaders() throws Exception {

        restClient = new RestClient();

        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Content-Typee", "application/xml");
        headerMap.put("authentication", "a8721jlkjkd#asdj76767676");
        headerMap.put("Auth Token", "xyz234324234");


        closeableHttpResponse = restClient.get(url, headerMap);

        //a. Get the Status code.
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code Test 2--> " + statusCode);

        Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");


        //b. Json String:
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

        JSONObject responseJson = new JSONObject(responseString);
        System.out.println("Response Jason from API --> " + responseJson);

        String s = TestUtils.getValueByJPath(responseJson, "/total");

        System.out.println("total is --> " + s);
        Assert.assertEquals(Integer.parseInt(s), 12);


        //c. Get all Headers.
        Header[] headersArray = closeableHttpResponse.getAllHeaders();

        HashMap<String, String> allHeaders = new HashMap<String, String>();

        for (Header header : headersArray) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Header Array -->" + allHeaders);

    }


}
