package jacksonjsonjavaparser.jacksonjsonjavaparser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.Employee;

public class EditJsonDocument1 {
	public static void main(String[] args) throws IOException {
		// Jackson JSON – Edit JSON Document

		/*
		 * Jackson JSON Java API provide useful methods to add, edit and remove keys
		 * from JSON data and then we can save it as new json file or write it to any
		 * stream. Below code shows us how to do this easily.
		 */
		byte[] jsonData = Files.readAllBytes(Paths.get("employee.json"));

		ObjectMapper objectMapper = new ObjectMapper();
		Employee readValue = objectMapper.readValue(jsonData, Employee.class);
		readValue.setId("789");
		String filePath = System.getProperty("user.dir") + File.separator + "employee.json";
		objectMapper.writeValue(new File(filePath), readValue);
		System.out.println("done");
	}
}
