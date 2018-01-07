package restauto;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import java.util.Arrays;
import java.util.List;

import restassi.Apartments1;

public class PutLandlordsIdApartmentsId {

	public static void main(String[] args) {
		List<String> features = Arrays.asList("doors", "tv","radio");
		Landlords ll = new Landlords("100", 1000, 700, features, false);
		String res = given()
				.contentType(ContentType.JSON)
				.body(ll.toString())
				.when()
				.put("http://localhost:8080/landlords/eGKBsU0r/apartments/t21dxpEm")
				.then()
				.extract().response().prettyPrint();
		
		
		

	}

}
