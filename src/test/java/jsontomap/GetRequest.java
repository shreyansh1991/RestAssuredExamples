package jsontomap;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest {
	

	@Test
	public void restAssuredGet()
	{
		 Map<String,Object> map = RestAssured.get("https://restful-booker.herokuapp.com/booking/1")
		 .then()
		 .extract()
		 .as(Map.class);
		 System.out.println("Response in Map "+map);
		 map.entrySet().stream().forEach(i->{
			 System.out.println(i.getKey()+" :: "+i.getValue());
		 });
		
	}

}
