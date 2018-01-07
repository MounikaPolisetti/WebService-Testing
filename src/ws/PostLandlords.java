package ws;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import restassi.Apartments1;
import restassi.Landlord;
import restauto.Landlords;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class PostLandlords {
	public static void main(String[] args) {
		
		
		
		/*Apartments apt1 = new Apartments("S6BaoqfQ","1000",10,20);
		Landlords ll1 = new Landlords("john","KL",true,apt1);
		String res1 = given()
				.contentType(ContentType.JSON)
				.body(ll1.toString())
				.when()
				.post("http://localhost:8080/landlords")
				.then()
				.extract().response().prettyPrint();
		
		
		Landlord l = new Landlord("antony","KL",false);
		String res2 = given()
				.contentType(ContentType.JSON)
				.body(l)
				.when()
				.put("http://localhost:8080/landlords/Y27BdZ18")
				.then()
				.extract().response().prettyPrint();
		
		
		Landlord l2 = new Landlord("saara","KL",false);
		String res3 = given()
				.contentType(ContentType.JSON)
				.body(l2)
				.when()
				.put("http://localhost:8080/landlords/4DKlS34")
				.then()
				.extract().response().prettyPrint();
		
		
		given()
		.when()
		.get("http://localhost:8080/landlords/E9oMk5Kt")
		.then()
		.extract().response().prettyPrint();*/
		
		/*
		List<String> features = Arrays.asList("fine");
		Apartments a = new Apartments("ABCDE", "bang", 1000, 20, features, false);
		String res4 = given()
				.contentType(ContentType.JSON)
				.body(a)
				.when()
				.post("http://localhost:8080/landlords/ibU4RuP4/apartments")
				.then()
				.extract().response().prettyPrint();*/
		
		
		/*given()
		.when()
		.get("http://localhost:8080/landlords/ibU4RuP4/apartments/nfKltOO5")
		.then()
		.extract().response().prettyPrint();
		
		
		List<String> features = Arrays.asList("good");
		Landlords ll = new Landlords("100", 1000, 200, features, false);
		String res = given()
				.contentType(ContentType.JSON)
				.body(ll.toString())
				.when()
				.put("http://localhost:8080/landlords/ibU4RuP4/apartments/nfKltOO5")
				.then()
				.extract().response().prettyPrint();
		*/
	/*	 given()
		.when()
		.get("http://localhost:8080/landlords/ibU4RuP4/apartments?minSq=100&maxSq=900")
		.then()
		.extract().response().prettyPrint();
		 
		 
		 given()
			.when()
			.delete("http://localhost:8080/landlords/ibU4RuP4/apartments/ZlEuf9ck")
			.then()
			.extract().response().prettyPrint();
		 */
		 
		/* given()
			.when()
			.delete("http://localhost:8080/landlords/ibU4RuP4/apartments/oh5g00Mu")
			.then()
			.extract().response().prettyPrint();*/
		
	}
}
