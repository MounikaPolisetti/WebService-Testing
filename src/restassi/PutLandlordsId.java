package restassi;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class PutLandlordsId {

	public static void main(String[] args) {
		Landlord l = new Landlord("Mouni","Poli",false);
		String res = given()
				.contentType(ContentType.JSON)
				.body(l)
				.when()
				.put("http://localhost:8080/landlords/eGKBsU0r")
				.then()
				.extract().response().prettyPrint();

	}

}
