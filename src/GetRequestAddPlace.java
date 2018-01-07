import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class GetRequestAddPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*given()
		.queryParam("key","AIzaSyCOAKf3pKKtzAKtJAeODHx58Umx38vYPAM")
		.contentType(ContentType.JSON)
		.body("{"
				+ "\"location\": {"
				+ "\"lat\": -33.8669710,"
				+"\"lng\": 151.1958750" 
				+ "},"
				+ "\"accuracy\": 50,"
				+ "\"name\": \"Google Shoes!\","
				+ "\"phone_number\": \"(02) 9374 4000\","
				+ "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","
				+ "\"types\": [\"shoe_store\"],"
				+ "\"website\": \"http://www.google.com.au/\","
				+ "\"language\": \"en-AU\""
				+ "}")
		.when()
		.post("https://maps.googleapis.com/maps/api/place/add/json")
		.then()
		.extract().response().prettyPrint();
		*/
		Location loc = new Location(-33.8669710,151.1958750);
		List<String> list = new ArrayList<String>();
		list.add("shoe_store");
		Places places = new Places(loc, 50, "my new shop", "3435","dfjsd dkfjsdkf",list,"www.type.com","english");
		String res = given()
		.queryParam("key","AIzaSyCOAKf3pKKtzAKtJAeODHx58Umx38vYPAM")
		.contentType(ContentType.JSON)
		.body(places)
		.when()
		.post("https://maps.googleapis.com/maps/api/place/add/json")
		.then()
		.extract().response().prettyPrint();
		
		JsonPath json = new JsonPath(res);
		String placeid = json.get("place_id");
		System.out.println(placeid);
		

	}

}
