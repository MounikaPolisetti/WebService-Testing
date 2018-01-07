import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;

public class GetLandlords {
	public static void main(String[] args) {
		String res = given()
				.when()
				.get("http://localhost:8080/landlords/")
				.then()
				.extract().response().prettyPrint();

	}

}
