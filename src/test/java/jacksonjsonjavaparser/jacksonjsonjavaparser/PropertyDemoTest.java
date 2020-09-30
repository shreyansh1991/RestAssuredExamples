package jacksonjsonjavaparser.jacksonjsonjavaparser;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.PropertyDemoBean;

public class PropertyDemoTest {
	ObjectMapper objectMapper = new ObjectMapper();
	@Test
	public void testSerializingWithJsonProperty() throws JsonProcessingException {
		String jsonString = objectMapper.writeValueAsString(new PropertyDemoBean());
		System.out.println(jsonString);
		Assert.assertTrue(jsonString.contains("James Clark"));
		Assert.assertTrue(jsonString.contains("123"));
	}
	 @Test
	 public void testDeSerializingWithJsonProperty() throws IOException {
	 String jsonString = "{\"person-id\": 231, \"name\": \"Mary Parker\"}";
	 PropertyDemoBean bean = objectMapper.readValue(jsonString,
	 PropertyDemoBean.class);
	 System.out.println(bean.name);
	 System.out.println(bean.personId);
	
	 }

}