package headers;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;

public class BlackListHeader {
	@Test
	public void blackListHeader()
	{
	
		RestAssured.given()
		.config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization")))
		.log()
		.all()
		.accept(ContentType.JSON)
		.header("Authorization","Bearer Token Value")
		.when()
		.get("https://restful-booker.herokuapp.com/booking/1")
		.then()
		.log().all();	
}
	@Test
	public void blackListMultupleHeader()
	{
	Set<String> headersToBeBlackListed=new HashSet<>();
	headersToBeBlackListed.add("Authorization");
	headersToBeBlackListed.add("Accept");
		RestAssured.given()
		.config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeaders(headersToBeBlackListed)))
		.log()
		.all()
		.accept(ContentType.JSON)
		.header("Authorization","Bearer Token Value")
		.when()
		.get("https://restful-booker.herokuapp.com/booking/1")
		.then()
		.log().all();	
}
	}

	