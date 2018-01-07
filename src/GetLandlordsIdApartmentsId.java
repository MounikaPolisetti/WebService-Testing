import static io.restassured.RestAssured.given;


public class GetLandlordsIdApartmentsId {
	
	public static void main(String[] args) {
	given()
	.when()
	.get("http://localhost:8080/landlords/eGKBsU0r/apartments/t21dxpEm")
	.then()
	.extract().response().prettyPrint();

	}

}
