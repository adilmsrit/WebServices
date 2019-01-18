package WebService;

import WebService.Base.BaseClass;
import WebService.Base.RestClient;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetAPITest extends BaseClass {
    BaseClass baseClass;
    String serviceUrl;
    String apiUrl;
    String url;
    RestClient restClient;

    @BeforeMethod
    public void setup(){
        baseClass = new BaseClass();
        serviceUrl = prop.getProperty("URL");
        url = prop.getProperty("serviceURL");

        //url = serviceUrl + apiUrl;

       url = "https://reqres.in/api/users";

    }

    @Test
    public void getAPITest() throws Exception {
        restClient = new RestClient();
        restClient.get(url);

    }


}
