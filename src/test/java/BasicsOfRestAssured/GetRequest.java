package BasicsOfRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;




public class GetRequest {
	

	@Test
	public void restAssuredGet()
	{
		Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/1");
//		System.out.println(response);
		String body = response.prettyPrint().toString();
//		System.out.println(body);
		
	}

}
