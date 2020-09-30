package jacksonjsonjavaparser.jacksonjsonjavaparser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.Employee;
/**
 * 
 * @author Shreyansh Jain
 * The ObjectMapper is located in the Jackson Databind project, so your application will need that 
 * project on its classpath to work.
 */
public class JsonParser {
	public static void main(String[] args) throws IOException {
		byte[] readAllBytes = Files
				.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "employee.json"));
		ObjectMapper objectMapper = new ObjectMapper();
		Employee employee = objectMapper.readValue(readAllBytes, Employee.class);
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getPermanent());
		System.out.println(employee.getRole());
		System.out.println(employee.getAddress());
		String[] cities = employee.getCities();
		System.out.println(cities[0] + " " + cities[1]);
		System.out.println(employee.getPhoneNumbers());
		System.out.println(employee.getProperties());

	}
}
