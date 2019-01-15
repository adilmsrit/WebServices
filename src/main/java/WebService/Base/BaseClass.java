package WebService.Base;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Hello world!
 */
public class BaseClass {

    public Properties prop;

    public BaseClass() {
        try {
            prop = new Properties();
            FileInputStream fs = new FileInputStream(System.getProperty("C:\\Users\\mohammed.nazeer\\IdeaProjects\\WebServices\\src\\main\\java\\config\\config.properties"));
            //FileInputStream fs = new FileInputStream(System.getProperty("config/config.properties"));
            prop.load(fs);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
