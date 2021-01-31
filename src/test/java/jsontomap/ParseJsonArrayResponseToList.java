
package jsontomap;
 
import java.util.List;
import java.util.Map;
 
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
 
public class ParseJsonArrayResponseToList {
 
	public static void main(String[] args) {
		
		List<Map<String,Object>> responseBody = null;
		
		responseBody = 
		RestAssured
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
				.extract()
				
//				.body()
				
				// Extract response as List<Map<String,Object>>
				// Since the response in a List of Map format.
				.as(new TypeRef<List<Map<String,Object>>>() {});
				
		
		System.out.println("Total bookings : "+ responseBody.size());
		
		System.out.println("All booking ids are: ");
		
		for(Map<String,Object> booking : responseBody)
		{
			System.out.println(booking.get("bookingid"));
		}
				
	}
}