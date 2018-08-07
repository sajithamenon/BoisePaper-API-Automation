import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import static com.sun.javafx.fxml.expression.Expression.equalTo;
import static io.restassured.RestAssured.given;

public class PostLogin {
    @Test
    public void postLogin() {
        RestAssured.baseURI = "https://apps.net-results.com";

        given().
                queryParam("Controller","Contact").
        auth().preemptive().basic("303software@gmail.com","Ni0pa0m").

                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"id\": \"16108\",\n" +
                        "  \"method\": \"submitContactImport\",\n" +
                        "  \"jsonrpc\": \"2.0\",\n" +
                        "  \"params\": {\n" +
                        "    \"overwrite\": false,\n" +
                        "    \"contact_import_mapping\": {\n" +
                        "      \"first_name\": \"First Name\",\n" +
                        "      \"last_name\": \"Last Name\",\n" +
                        "      \"email\": \"Email Address\",\n" +
                        "      \"company\": \"Company Name\"\n" +
                        "    },\n" +
                        "    \"contact_import_name\": \"Customer Import - Boise Paper App\",\n" +
                        "    \"notification_recipients\": [\"\"],\n" +
                        "    \"add_to_lists\": [],\n" +
                        "    \"remove_from_lists\": [],\n" +
                        "    \"contacts\": [\n" +
                        "      {\n" +
                        "        \"first_name\": \"Jason\",\n" +
                        "        \"last_name\": \"Roberts\",\n" +
                        "        \"email\": \"jason@303software.com\",\n" +
                        "        \"company\": \"303 Software\"\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }\n" +
                        "}").

                when().
                post("/api/v2/rpc/server.php").
                then().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("id",equalTo("16108"));



    }
}