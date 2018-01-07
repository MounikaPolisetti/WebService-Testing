import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;
public class GetRequestGroupkt {

	public static void main(String[] args) {
		//pretty print - print response in console
		String res = given()
		.when()
		.get("http://services.groupkt.com/state/get/IND/KA")
		.then()
		//.extract().response().prettyPrint();
		.extract().response().asString();
		//dependencies hamcrest matchers
		//hamcrest is for assertion
		//.statusCode(200)
		/*.body("RestResponse.result.id", is(67))
		.body("RestResponse.result.abbr", is("KA"))
		.body("RestResponse.messages[0]", is("State found matching code [KA]."));*/
		System.out.println(res);
		
		//another way to validate 
		JsonPath json = new JsonPath(res);
		int id = json.get("RestResponse.result.id");
		System.out.println(id);
		
		

	}
}
