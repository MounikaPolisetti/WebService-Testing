package restauto;

import static io.restassured.RestAssured.given;

public class DeleteLandlordsIdApartmentsId {

	public static void main(String[] args) {
		given()
		.when()
		.delete("http://localhost:8080/landlords/eGKBsU0r/apartments/usrGtF0y")
		.then()
		.extract().response().prettyPrint();
		
	}

}
