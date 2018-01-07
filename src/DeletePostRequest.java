import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;


public class DeletePostRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = given()
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
		.extract().response().asString();
		
		JsonPath json = new JsonPath(res);
		String placeid = json.get("place_id");
		System.out.println(placeid);
		
		
		given()
		.queryParam("key","AIzaSyCOAKf3pKKtzAKtJAeODHx58Umx38vYPAM")
		.contentType(ContentType.JSON)
		.body("{\"place_id\": \""+placeid+"\"}")
		.when()
		.post("https://maps.googleapis.com/maps/api/place/delete/json")
		.then()
		.extract().response().prettyPrint();

	}

}
