package WebServices;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsEmptyCollection;

import io.restassured.http.ContentType;

public class GetLandlords {
	public static void main(String[] args) {
		
/*
1. read all landlord information using get request, Validate for the empty list(before adding any lanlord data) 
Validate status code is 200
*/

		
	    given().
		when().
		get("http://localhost:8080/landlords").
		then()
		.statusCode(200)
		.body("", Matchers.hasSize(0))
		.extract().response().prettyPrint();
		System.out.println("Success");
	

		

/*
2.Add a landlord(firstName=aana, lastname=sa) using post request(use pojo class to send the data)
validate that the new landlord exists validate the status code is 201 Validate that the response for add request
is synchronized with the corresponding jsonSchema(refer swagger response content for the modelschema)
*/
		
		List<String> features = Arrays.asList("doors", "tv", "radio");
		Apartments apt = new Apartments("ESC", 1000, 10, features, true);
		
		LandLord ll = new LandLord("aana", "sa", true, apt);
		String res = given()
				.contentType(ContentType.JSON)
				.body(ll)
				.when()
				.post("http://localhost:8080/landlords")
				.then()
				.statusCode(201)
				.extract().response().prettyPrint();
	


		
		
/*
3.add landlord (firstName=john, lastname=KL) using post request
Validate &quot;apartments&quot;is empty list
Validate &quot;status code&quot; is 201
Edit the landlord information which had added previously, to (firstName=antony, lastname=KL) using
put request
Validate status code is 200
Validate message = LandLord with id: {id} successfully updated
Validate that the response is synchronized with the corresponding jsonSchema(refer swagger response
content for model schema)
*/
		
		
		LandLord testLandlord = new LandLord("John", "KL", true, apt);
		String addLandlordResponse = given()
				.contentType(ContentType.JSON)
				.body(testLandlord)
				.when()
				.post("http://localhost:8080/landlords")
				.then()
				.body("apartments",  Matchers.hasSize(0))
				.statusCode(201)
				.extract().response().prettyPrint();
		JsonPath addLandlordJson = new JsonPath(addLandlordResponse);
		String testLanlordId = addLandlordJson.get("id");
		
		// Update firstName.
		testLandlord.setFirstName("antony");
		
		// Put Request to update firstName
		String putLandlordResponse= given()
				.contentType(ContentType.JSON)
				.body(testLandlord)
				.when()
				.put("http://localhost:8080/landlords/" + testLanlordId)
				.then()
				.statusCode(200)
				.body("message", is("LandLord with id: " + testLanlordId + " successfully updated"))
				.extract().response().prettyPrint();
		

		
		
/*
4.Edit the landlord information for the id=4DKlS34 to (firstName=saara, lastname=KL)
Validate status code is 404
Validate message = There is no LandLord with id: 4DKlS34		
 */
		
		LandLord l3 = new LandLord("saara","KL",false,apt);
				given()
				.contentType(ContentType.JSON)
				.body(l3)
				.when()
				.put("http://localhost:8080/landlords/4DKlS34")
				.then()
				.statusCode(404)
				.body("message", is("There is no LandLord with id: 4DKlS34"))
				.extract().response().prettyPrint();
		
		
/*
5.extract the id from the response in question 3
Read the particular landlord information for the above id using get method
Validate status code is 200
Validate id, firstname, lastname is same as question 3 request body.
*/
		 given()
		.when()
		.get("http://localhost:8080/landlords/" + testLanlordId)
		.then()
		.statusCode(200)
		.body("firstName", is("antony"))
		.body("lastName",is("KL") )
		.extract().response().prettyPrint();
		 
		
/*
6. extract the id from the response in question 3
add the apartment information to particular landlord for the above id
json request is the following(use pojo class in the request)

*/
		
		
		List<String> features1 = Arrays.asList("fine");
		Apartments a = new Apartments("bang", 1000, 20, features1, false);
		String res4 = given()
				.contentType(ContentType.JSON)
				.body(a)
				.when()
				.post("http://localhost:8080/landlords/"+ testLanlordId +"/apartments")
				.then()
				.body("square", is(20))
				.body("active", is(false))
				.body("features", hasSize(1))
				.statusCode(201)
				.extract().response().prettyPrint();
				
		JsonPath Json = new JsonPath(res4);
		String apartmentId = Json.get("id");
		System.out.println(apartmentId);
		
		
/*
7.extract the landlord id from the response in question 3
extract the aparment id from the response in question 6
edit the apartment information using put request	
*/
		
		
		List<String> features2 = Arrays.asList("good");
		Apartments a1 = new Apartments("bang", 1000, 200, features2, false);
		String res5 = given()
				.contentType(ContentType.JSON)
				.body(a1)
				.when()
				.put("http://localhost:8080/landlords/"+testLanlordId+"/apartments/"+apartmentId)
				.then()
				.statusCode(200)
				.extract().response().prettyPrint();
	
	  
/*
8.add two more apartment information to same landlord id recieved from question 3 response
*/
		
		
		Apartments a2 = new Apartments("mysore", 2000, 300, features2, false);
		String res6 = given()
				.contentType(ContentType.JSON)
				.body(a2)
				.when()
				.post("http://localhost:8080/landlords/"+testLanlordId+"/apartments")
				.then()
				.extract().response().prettyPrint();
		
		
		
		Apartments a3 = new Apartments("bang", 3000, 800, features2, false);
		String res7 = given()
				.contentType(ContentType.JSON)
				.body(a3)
				.when()
				.post("http://localhost:8080/landlords/"+testLanlordId+"/apartments")
				.then()
				.extract().response().prettyPrint();
		
		System.out.println("======================");
		
		String totalRecords = given()
		.when()
		.get("http://localhost:8080/landlords/"+testLanlordId+"/apartments?minSq=300&maxSq=800")
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
        .body("list.size()", is(2))
		.body("address",hasItems("mysore"))
		.body("address",hasItems("bang")) 
		.extract().response().prettyPrint();
		
		given()
		.when()
		.get("http://localhost:8080/landlords/ibU4RuP4/apartments?minSq=100&maxSq=900")
		.then()
		.statusCode(200)
		.extract().response().prettyPrint();
		
/* 
 * 9. Delete the last added apartment information using delete request Validate the status code is 200 
 */	
			 given()
			.when()
			.delete("http://localhost:8080/landlords/ibU4RuP4/apartments/V99SSfDi")
			.then()
			.statusCode(200)
			.extract().response().prettyPrint();
	
/*
 * 10. Extract the id from the response in question 3 Delete the particular landlord for the above id Validate "status code" is 200 *		 
 */
		 given()
			.when()
			.delete("http://localhost:8080/landlords/"+testLanlordId)
			.then()
			.statusCode(200)
			.extract().response().prettyPrint();
			
	}
	}


