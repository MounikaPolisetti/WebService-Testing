package restassi;

import static io.restassured.RestAssured.given;

public class DeleteLandlordsId {
	public static void main(String[] args) {
		given()
		.when()
		.delete("http://localhost:8080/landlords/ZnvwVSSe")
		.then()
		.extract().response().prettyPrint();
		
	}

}
