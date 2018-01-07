import static io.restassured.RestAssured.given;
public class GetLandlordsIdApartments {

	public static void main(String[] args) {
		given()
		.when()
		.get("http://localhost:8080/landlords/eGKBsU0r/apartments?minSq=500&maxSq=800")
		.then()
		.extract().response().prettyPrint();
			}

}
