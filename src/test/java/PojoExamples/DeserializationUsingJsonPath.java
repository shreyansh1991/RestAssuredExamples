package PojoExamples;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;

public class DeserializationUsingJsonPath {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		String jsonObject = "{\r\n" + 
				"  \"id\": 1,\r\n" + 
				"  \"first_name\": \"Lothaire\",\r\n" + 
				"  \"last_name\": \"Benazet\",\r\n" + 
				"  \"email\": \"lbenazet0@tinyurl.com\",\r\n" + 
				"  \"gender\": \"Male\"\r\n" + 
				"}";
		
		JsonPath jsonPath = JsonPath.from(jsonObject);
		Employee employee = jsonPath.getObject("", Employee.class);
		System.out.println("Id is         : "+employee.getId());
		System.out.println("First name is : "+employee.getFirst_name());
		System.out.println("Last name is  : "+employee.getLast_name());
		System.out.println("Email id is   : "+employee.getEmail());
		System.out.println("Gender is     : "+employee.getGender());
		
		
		// Another way
		Employee employee1 = jsonPath.getObject("$", Employee.class);
		System.out.println("Id is         : "+employee1.getId());
		System.out.println("First name is : "+employee1.getFirst_name());
		System.out.println("Last name is  : "+employee1.getLast_name());
		System.out.println("Email id is   : "+employee1.getEmail());
		System.out.println("Gender is     : "+employee1.getGender());
		
		Map<String, Object> employeeMap = jsonPath.getObject("$",new TypeRef<Map<String, Object>>() {});
		System.out.println("Employee Map: "+employeeMap);
		LinkedHashMap<String, Object> object = jsonPath.getObject("$",new TypeRef<LinkedHashMap<String, Object>>() {});
		System.out.println("Set: "+object);
		
 
	}
 
}