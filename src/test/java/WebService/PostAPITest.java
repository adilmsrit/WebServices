package WebService;

import WebService.Base.BaseClass;
import WebService.Base.RestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.Users;
import org.apache.http.client.methods.CloseableHttpResponse;
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
    public void postAPITest() throws Exception{
        restClient = new RestClient();
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");

//Jackson API
        ObjectMapper mapper = new ObjectMapper();
        Users users = new Users("morpheus", "leader");

        //object to json.
        mapper.writeValue(new File("data/users.json"),users);


    }

}
