import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;

public class GetRequestGroupKt1 {
	public static void main(String[] args) {
	
	String res = given()
			.when()
			.pathParam("CC", "USA")
			.pathParam("SC","CA")
			.get("http://services.groupkt.com/state/get/{CC}/{SC}")
			.then()
			.extract().response().asString();
	System.out.println(res);
	JsonPath json = new JsonPath(res);
	String abbr = json.getString("RestResponse.result.abbr");
	System.out.println(abbr);
	
}
}
