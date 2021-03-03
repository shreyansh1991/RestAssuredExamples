package jsonparsing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.makeseleniumeasy.jackson.Employee;

public class JsonNodeUsage {
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
		ArrayNode tree = (ArrayNode)objectMapper.readTree(writeValueAsString);
		System.out.println(tree.size());
		
		
		System.out.println(tree.get(0).toPrettyString());
		System.out.println(tree.get(1).toPrettyString());
		System.out.println(tree.get(2).toPrettyString());
		System.out.println(tree.get(0).get("firstName").asText());
		

	}
}
