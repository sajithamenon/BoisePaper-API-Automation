import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class DeleteUser {
    @Test
    public void delete(){

        RestAssured.baseURI="https://proof.303-dev.com/api";
        given().
                header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjoyLCJzZWNyZXQiOiIzZDFjMDE3OC1iNTBmLTQ2NjItYmFlMi05OTA5ZDVlMGQ0YzcifQ.OcAwisUYAZ0JZQHlKp9Qd3TrQeykOccy6125kKm11gQ").
header("client-type","admin").
                when().
                delete("/api/users/89").
                then().assertThat().statusCode(200).log().all();










    }
}
