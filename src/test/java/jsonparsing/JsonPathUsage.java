package jsonparsing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.makeseleniumeasy.jackson.Employee;

import io.restassured.path.json.JsonPath;

public class JsonPathUsage {
	public static void main(String[] args) throws JsonProcessingException {
		// Create first employee
		Employee amod = new Employee();
		amod.setFirstName("Amod");
		amod.setLastName("Mahajan");
		amod.setAge(29);
		amod.setGender("Male");
		amod.setSalary(10000.56);
		amod.setMarried(false);

		// Create second employee
		Employee animesh = new Employee();
		animesh.setFirstName("Animesh");
		animesh.setLastName("Prashant");
		animesh.setAge(30);
		animesh.setGender("Male");
		animesh.setSalary(20000.56);
		animesh.setMarried(true);

		// Create third employee
		Employee kitty = new Employee();
		kitty.setFirstName("Kitty");
		kitty.setLastName("Gupta");
		kitty.setAge(27);
		kitty.setGender("Female");
		kitty.setSalary(30000.56);
		kitty.setMarried(false);

		// Creating a List of Employees
		List<Employee> allEMployees = new ArrayList<Employee>();
		allEMployees.add(amod);
		allEMployees.add(animesh);
		allEMployees.add(kitty);
		ObjectMapper objectMapper = new ObjectMapper();
		String writeValueAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allEMployees);

		// using jsonPath class from Rest Assured
		JsonPath jsonPath = new JsonPath(writeValueAsString);
		String data = jsonPath.get("firstName[0]");
		String data1 = jsonPath.get("firstName[1]");
		String data2 = jsonPath.get("firstName[2]");
		
		System.out.println(data + " " + data1 + " " + data2);
		
		JsonPath jsonPath1 = new JsonPath(writeValueAsString);
	
		//validating the count of jsonObject
		int size = jsonPath1.getList("$").size();
		System.out.println(size);
		
		// extracting all the firstName
		
		List<Object> list = jsonPath1.getList("firstName");
		System.out.println(list);
		
		
	}
}
