package headers;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class VerifyMultipleHeaders {
	@Test
	public void restAssuredGet()
	{
		RestAssured.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com")
		.basePath("/booking")
		.when()
		.get()
		.then()
		.log().headers()
		.headers("Connection","keep-alive","Content-Length",Matchers.greaterThan("170"));

		
	}

}

