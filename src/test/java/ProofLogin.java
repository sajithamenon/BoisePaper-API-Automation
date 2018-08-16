import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ProofLogin {



    @Test
    public void ProofLogin(){

        RestAssured.baseURI="https://proof.303-dev.com/api";
        given().
                header("Content-Type","application/json").and().
                header("client-type","admin").and().
body("{\n" +
        "  \"email\": \"keith@303software.com\",\n" +
        "  \"password\": \"secret\"\n" +
        "}").
                when().
                post("/api/login").
                then().
                assertThat().statusCode(200).and().
                log().all();


    }
    @Test
    public void createUser()
    {


        RestAssured.baseURI="https://proof.303-dev.com/api";
        given().header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoyLCJzZWNyZXQiOiJiOWY1Z\n" +
                        "                jg3NS00YTJkLTRlOGYtYjIxYy0zZThhMmNmMTNlMDQifQ.dl4s-SW07pV-UyEy78F7APiz-zXRmMPRHamV1_rS27I").
                and(). header("Content-Type","application/json").and().
                header("client-type","admin").and().
                body("{\n" +
                        "  \"user\" : {\n" +
                        "      \"firstName\": \"testRestAssured\",\n" +
                        "      \"lastName\": \"perez\",\n" +
                        "      \"userType\": \"server\",\n" +
                        "      \"primaryPhone\": \"5555555555\",\n" +
                        "      \"verified\": true,\n" +
                        "      \"active\": true,\n" +
                        "      \"email\": \"Sajitha.r+rest12@303software.com\",\n" +
                        "      \"password\": \"secret\"\n" +
                        "  }\n" +
                        "}\n").

                when().
                    post("/api/users").

                then().assertThat().statusCode(200).

                and().log().all();

    }
}
