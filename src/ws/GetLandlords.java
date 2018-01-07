package ws;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsEmptyCollection;

import WebServices.LandLord;
import io.restassured.http.ContentType;

public class GetLandlords {
	public static void main(String[] args) {
		given()
				.when()
				.get("http://localhost:8080/landlords/")
				.then()
				.statusCode(200)
				.body("",Matchers.hasSize(0))
				.extract().response().prettyPrint();
		System.out.println("Success");
		
		
		
	}
	

}
