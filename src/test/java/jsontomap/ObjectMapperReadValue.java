package jsontomap;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperReadValue {
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<HashMap<String, String>> readValue = objectMapper.readValue(
				new File(System.getProperty("user.dir") + File.separator + "demo.json"),
				new TypeReference<List<HashMap<String, String>>>() {
				});
		readValue.forEach(i -> {
			System.out.println(i);
		});
	}
}
