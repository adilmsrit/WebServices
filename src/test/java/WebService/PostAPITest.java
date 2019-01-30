package WebService;

import WebService.Base.BaseClass;
import WebService.Base.RestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.Users;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class PostAPITest extends BaseClass {

    BaseClass baseClass;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;

    @BeforeMethod
    public void setup() {
        baseClass = new BaseClass();
        url = "https://reqres.in/api/users";
    }

    @Test
    public void postAPITest() throws Exception {
        restClient = new RestClient();
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");

        //Jackson API
        ObjectMapper mapper = new ObjectMapper();
        Users users = new Users("morpheus", "leader");

        //object to json.
        mapper.writeValue(new File("C:\\Users\\mohammed.nazeer\\IdeaProjects\\WebServices\\src\\main\\java\\data\\users.json"), users);
        String userJsonString = mapper.writeValueAsString(users);

        System.out.println("Outputs the Json Sting generated --> " + userJsonString);

        closeableHttpResponse = restClient.post(url, userJsonString, headerMap);

        //1. Get the status.
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("statusCode --> " + statusCode);
        Assert.assertEquals(statusCode, baseClass.RESPONSE_STATUS_CODE_201);

        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject jsonObject = new JSONObject(responseString);
        System.out.println("jsonObject --> "+jsonObject);



    }
}
