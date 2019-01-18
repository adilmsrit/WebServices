package WebService.Base;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Hello world!
 */
public class BaseClass {

    public Properties prop;


    public int RESPONSE_STATUS_CODE_200 = 200;
    public int RESPONSE_STATUS_CODE_500 = 500;
    public int RESPONSE_STATUS_CODE_400 = 400;
    public int RESPONSE_STATUS_CODE_401 = 401;
    public int RESPONSE_STATUS_CODE_201 = 201;


    public BaseClass() {
        try {
            prop = new Properties();
            FileInputStream fs = new FileInputStream(System.getProperty("C:\\Users\\mohammed.nazeer\\IdeaProjects\\WebServices\\src\\main\\java\\config\\config.properties"));
            prop.load(fs);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
