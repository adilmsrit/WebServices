package WebService;

import WebService.Base.BaseClass;
import org.testng.annotations.BeforeMethod;

public class GetAPITest extends BaseClass {
    BaseClass baseClass;

    @BeforeMethod
    public void setup() {
        baseClass = new BaseClass();


    }

}
