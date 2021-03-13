
package headers;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class PrintAllHeaders {
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
//		List<Header> allHeaders = headers.asList();
		for(Header header :allHeaders)
		{
			System.out.println("Header name ==>"+header.getName()+" and header value is "+header.getValue());
		}
		

		
	}

}


