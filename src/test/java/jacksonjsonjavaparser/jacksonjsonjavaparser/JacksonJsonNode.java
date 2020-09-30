package jacksonjsonjavaparser.jacksonjsonjavaparser;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Shreyansh Jain
 *  The JsonNode class lets you navigate the JSON as a
 *         Java object in a quite flexible and dynamic way.
 * 
 */
public class JacksonJsonNode {
	public static void main(String[] args) {
		String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5," + "  \"owners\" : [\"John\", \"Jack\", \"Jill\"],"
				+ "  \"nestedObject\" : { \"field\" : \"value\" } }";

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);

			JsonNode brandNode = jsonNode.get("brand");
			String brand = brandNode.asText();
			System.out.println("brand = " + brand);

			JsonNode doorsNode = jsonNode.get("doors");
			int doors = doorsNode.asInt();
			System.out.println("doors = " + doors);

			JsonNode array = jsonNode.get("owners");
			JsonNode jsonNode1 = array.get(0);
			String john = jsonNode1.asText();
			System.out.println("john  = " + john);

			JsonNode child = jsonNode.get("nestedObject");
			JsonNode childField = child.get("field");
			String field = childField.asText();
			System.out.println("field = " + field);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
