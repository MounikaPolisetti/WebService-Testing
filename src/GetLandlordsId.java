import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;

public class GetLandlordsId {
public static void main(String[] args) {
			given()
			.when()
			.get("http://localhost:8080/landlords/eGKBsU0r")
			.then()
			.extract().response().prettyPrint();
			}
}
