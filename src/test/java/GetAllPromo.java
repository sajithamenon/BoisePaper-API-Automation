import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import javafx.beans.binding.When;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;
import static  org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

/* To test the Home | Get All Promos Get Request*/

public class GetAllPromo {
    @BeforeTest
    public void setBaseUri() {

        RestAssured.baseURI = "https://boise-app-api.303-dev.com";
    }

    @Test
    public void postString() {

        /*All the parameters, cookies and headers are under given() session.If no parameters, no need to include given().;*/
        /*The  the Type of request and the Resources are under When() session.*/

        when().
                get("/wp-json/sales-application/v1/promos/all").
                then().
                // checking expected result, the promo imag for the office Depot,Amazon,Staples and wbMason
                        assertThat().statusCode(200).and().
                body("[0].promoImage", equalTo("https://boise-app-api.303-dev.com/wp-content/uploads/2018/07/BP-App-Image-OD.jpg")).and().
                body("[0].appliesToDomain", equalTo("officedepot.com")).and().
                body("[0].link", equalTo("http://boisepaper.com/promolink")).and().
                body("[1].promoImage", equalTo("https://boise-app-api.303-dev.com/wp-content/uploads/2018/06/amazon.png")).and().
                body("[1].appliesToDomain", equalTo("amazon.com")).and().
                body("[1].link", equalTo("http://boisepaper.com/promolink")).and().
                body("[2].promoImage", equalTo("https://boise-app-api.303-dev.com/wp-content/uploads/2018/06/staples.png")).and().
                body("[2].appliesToDomain", equalTo("staples.com")).and().
                body("[2].link", equalTo("http://boisepaper.com/promolink")).and().
                body("[3].promoImage", equalTo("https://boise-app-api.303-dev.com/wp-content/uploads/2018/07/WBM-App-Image.jpg")).and().
                body("[3].appliesToDomain", equalTo("wbmason.com")).and().
                body("[3].link", equalTo("http://boisepaper.com/promolink"))

        ;

    }
}