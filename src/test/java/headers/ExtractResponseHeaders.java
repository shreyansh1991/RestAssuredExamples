
package headers;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;

public class ExtractResponseHeaders {
	@Test
	public void restAssuredGet()
	{
		Headers allHeaders = RestAssured.given()
		
		.baseUri("https://restful-booker.herokuapp.com")
		.basePath("/booking")
		.when()
		.get()
		.then()
		.extract()
		.headers();
		String name = allHeaders.get("Connection").getValue();
		System.out.println(name);
		
		System.out.println(allHeaders.getValue("Connection"));
		
		

		
	}

}


