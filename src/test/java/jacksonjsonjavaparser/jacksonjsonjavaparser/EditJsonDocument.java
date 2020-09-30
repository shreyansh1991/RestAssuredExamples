package jacksonjsonjavaparser.jacksonjsonjavaparser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EditJsonDocument {
	public static void main(String[] args) throws IOException {
		// Jackson JSON – Edit JSON Document

		/*
		 * Jackson JSON Java API provide useful methods to add, edit and remove keys
		 * from JSON data and then we can save it as new json file or write it to any
		 * stream. Below code shows us how to do this easily.
		 */
		byte[] jsonData = Files.readAllBytes(Paths.get("employee.json"));

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readValue(jsonData, JsonNode.class);
		
		List<JsonNode> cities = jsonNode.findParents("key1:Los Angeles");
		System.out.println("cities => "+ cities);
		if(cities!=null)
		{
			 for(JsonNode city : cities){
				  System.out.println("city => "+city);
			    
			  }
		}
		
		List<JsonNode> parentNodes = jsonNode.findParents("zipcode");
		System.out.println("parentNodes => "+ parentNodes);
		if(parentNodes != null) {
		  for(JsonNode parentNode : parentNodes){
			  System.out.println("ParentNode => "+parentNode);
		    ((ObjectNode)parentNode).put("zipcode", "500081");
		    ((ObjectNode)parentNode).put("city", "Hyd");
		    ((ObjectNode)parentNode).put("street", "Madhapur");
		    
		    
		  }
		}
		

		List<JsonNode> phoneNumbers = jsonNode.findParents("key1");
		System.out.println("phoneNumbers => "+ phoneNumbers);
		if(phoneNumbers != null) {
		  for(JsonNode parentNode : phoneNumbers){
			  System.out.println("ParentNode => "+parentNode);
		    ((ObjectNode)parentNode).put("key1", "9458703411");
		    ((ObjectNode)parentNode).put("key2", "8884688154");
		    
		  }
		}
		
		

		List<JsonNode> salaryProp = jsonNode.findParents("salary");
		System.out.println("salaryProp => "+ salaryProp);
		if(salaryProp != null) {
		  for(JsonNode parentNode : salaryProp){
			  System.out.println("salaryProp => "+parentNode);
		    ((ObjectNode)parentNode).put("salary", "5000 USD");
		    
		    
		  }
		}
		
		
		
		
	//	((ObjectNode)jsonNode).put("id", "1786");
		//((ObjectNode)jsonNode).put("city", "Hyderabad");
	
		String filePath = System.getProperty("user.dir") + File.separator + "employee.json";
		objectMapper.writeValue(new File(filePath), jsonNode);
		System.out.println("done");
		
		// https://stackoverflow.com/questions/28607255/how-can-i-replace-a-java-jackson-textnode-by-another-one-update/28649524#28649524
	}
}
