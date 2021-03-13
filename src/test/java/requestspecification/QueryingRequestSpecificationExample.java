package requestspecification;
 
import java.util.HashSet;
import java.util.Set;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.SpecificationQuerier;
 
public class QueryingRequestSpecificationExample {
	
	public static void main(String[] args) {
		
		Set set=new HashSet<>();
		RequestSpecBuilder requestSpecBuilder= new RequestSpecBuilder();
		// Setting Base URI
		requestSpecBuilder.setBaseUri("https://restful-booker.herokuapp.com")
		// Setting Base Path
		.setBasePath("/booking")
		.addHeader("Header1", "Value1")
		.setConfig(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeaders(set)));
		RestAssured.requestSpecification=requestSpecBuilder.build();
		
		// Querying RequestSpecification
		// Use query() method of SpecificationQuerier class to query 
		QueryableRequestSpecification queryRequest = SpecificationQuerier.query(RestAssured.requestSpecification);
		
		// get base URI
		String retrieveURI = queryRequest.getBaseUri();
		System.out.println("Base URI is : "+retrieveURI);
		
		// get base Path
		String retrievePath = queryRequest.getBasePath();
		System.out.println("Base PATH is : "+retrievePath);
		
		Headers headers = queryRequest.getHeaders();
		System.out.println("Header is : "+headers);
		
	}
 
}