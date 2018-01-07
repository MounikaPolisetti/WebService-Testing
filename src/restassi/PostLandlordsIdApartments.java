package restassi;
import static io.restassured.RestAssured.given;
import java.util.Arrays;
import java.util.List;
import io.restassured.http.ContentType;
public class PostLandlordsIdApartments {

	public static void main(String[] args) {
		List<String> features = Arrays.asList("doors", "tv","radio");
		Apartments1 a = new Apartments1("LjTwfy3h", "1000", 100, 500, features, true);
		String res = given()
				.contentType(ContentType.JSON)
				.body(a)
				.when()
				.post("http://localhost:8080/landlords/eGKBsU0r/apartments")
				.then()
				.extract().response().prettyPrint();
		
	}

}
