package WebService;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FirstRestAssuredClass {

   // @Test
    public void testGoogleBooks() {
        Response response = RestAssured.given().param("q", "Paulo Coelho").
                when().get("https://www.googleapis.com/books/v1/volumes").
                then().statusCode(200).extract().response();

        System.out.println("Response = " + response.asString());

        int totalItems = JsonPath.read(response.asString(), "$.totalItems");

        System.out.println("Total Items in the response = " + totalItems);

        Assert.assertTrue(totalItems > 0, "Total Items greater that 0");

        List<Map<String, Object>> allBooks = JsonPath.read(response.asString(), "$.items[*].volumeInfo");

        for (Map<String, Object> book : allBooks) {
            List<String> authors = (List<String>) book.get("authors");
            String title = book.get("title").toString();

            Assert.assertTrue(authors.contains("Paulo Coelho") ||
                            title.contains("Paulo Coelho"),
                    "Title" + title + "or Authors = ");

        }

    }

    @Test
    public void TestCase1(){
        Response response = RestAssured.given().param("q","paulo+coelho").
                when().get("https://www.googleapis.com/books/v1/volumes").
                then().statusCode(200).extract().response();

        int totalItems = JsonPath.read(response.asString(),"$.totalItems");

        System.out.println("Response = " + response.asString());

        Assert.assertTrue(totalItems>0,"Total Items should be greater than 0");

        List<Map<String,Object>> allBooks = JsonPath.read(response.asString(),"$.items[*].volumeInfo");

        for(Map<String,Object> book : allBooks ){
            List<String> authors = (List<String>)book.get("authors");
            String title=book.get("title").toString();

            Assert.assertTrue(authors.contains("Paulo Coelho") || title.contains("Paulo Coelho"), "Title = " + title + " or Authors = " + Arrays.toString(authors.toArray()) + " should contain Paulo Coelho");
        }
    }


}
