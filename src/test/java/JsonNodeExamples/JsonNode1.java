package JsonNodeExamples;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonNode1 {
	public static void main(String[] args) {
		ObjectMapper objectMapper=new ObjectMapper();
		System.out.println(System.getProperty("user.dir"));
		String filePath=System.getProperty("user.dir")+File.separator+"employee.json";
		JsonNode node = null;
		
			try {
				node = objectMapper.readTree(new File(filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		JsonNode jsonNode = node.get("address").get("zipcode");
		System.out.println(jsonNode.asText());
		JsonNode jsonNode1 = node.get("address").path("zipcode");
		System.out.println(jsonNode1.asText());
		JsonNode jsonNode2 = node.path("address").path("zipcode");
		System.out.println(jsonNode2.asText());
		JsonNode jsonNode3 = node.get("cities");
		System.out.println(jsonNode3.get(1).asText());
	}

}
