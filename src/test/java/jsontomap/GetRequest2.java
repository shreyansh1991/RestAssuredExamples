package jsontomap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest2 {
	

	@Test
	public void restAssuredGet()
	{
		 RestAssured.
		 given()
		 .log()
		 .all()
		 .get("https://restful-booker.herokuapp.com/booking/1")
		 .then()
		 .log()
		 .all()
		 .assertThat()
		 .body("bookingdates.checkin",Matchers.equalTo("2020-01-19"))
		 .body("bookingdates.checkout",Matchers.equalTo("2018-08-26"));
		
		
	}

}
