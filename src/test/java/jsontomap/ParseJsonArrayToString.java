
package jsontomap;
 
import io.restassured.RestAssured;
 
public class ParseJsonArrayToString {
 
	public static void main(String[] args) {
		
		//List<Map<String,Object>> responseBody = null;
		
		
		String asString = RestAssured
			.given()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking")
				.log()
				.all()
			.when()
				.get()
			.then()
			.log()
			.all()
				.extract().asString();
		System.out.println(asString);
				
							
	}
}