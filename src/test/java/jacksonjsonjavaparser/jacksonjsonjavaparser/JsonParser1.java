package jacksonjsonjavaparser.jacksonjsonjavaparser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser1 {
	public static void main(String[] args) throws IOException {
		byte[] readAllBytes = Files
				.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "employee.txt"));
		ObjectMapper objectMapper = new ObjectMapper();
		// read JSON like DOM Parser

		// Jackson JSON – Read Specific JSON Key
		/*
		 * Sometimes we have json data and we are interested in only few of the keys
		 * values, so in that case converting whole JSON to object is not a good idea.
		 * Jackson JSON API provides option to read json data as tree like DOM Parser
		 * and we can read specific elements of JSON object through this. Below code
		 * provides snippet to read specific entries from json file.
		 */

		/**
		 * The Jackson tree model is represented by the JsonNode class.
		 */
		JsonNode rootNode = objectMapper.readTree(readAllBytes);
		JsonNode idNode = rootNode.path("id");
		System.out.println("id = " + idNode.asInt());
		
		

		JsonNode phoneNosNode = rootNode.path("phoneNumbers");
		Iterator<JsonNode> elements = phoneNosNode.elements();
		while (elements.hasNext()) {
			JsonNode phone = elements.next();
			System.out.println("Phone No = " + phone.asLong());
		}
	}
}
