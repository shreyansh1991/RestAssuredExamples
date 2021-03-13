package headers;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class VerifySingleHeader {
	@Test
	public void restAssuredGet()
	{
		RestAssured.get("https://restful-booker.herokuapp.com/booking/1")
		.then()
		.log().headers()
		.header("Connection", "keep-alive")
		.header("Content-Length", "169");

		
	}

}
