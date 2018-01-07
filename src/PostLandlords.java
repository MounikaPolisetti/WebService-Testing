import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class PostLandlords {
	public static void main(String[] args) {
		Apartments apt = new Apartments("S6BaoqfQ","1000",10,20);
		Landlords ll = new Landlords("abc","xyz",true,apt);
		String res = given()
				.contentType(ContentType.JSON)
				.body(ll.toString())
				.when()
				.post("http://localhost:8080/landlords")
				.then()
				.extract().response().prettyPrint();
		
	}
}
