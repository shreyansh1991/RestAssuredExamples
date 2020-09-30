package com.makeseleniumeasy.jackson;

import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
/*
 * Note :- When we add jackson-databind dependency then it will automatically download transitive dependencies of same version 
 * i.e. jackson-annotations and jackson-core as well.
 * */
public class CreateObjectNode {
	public static void main(String[] args) {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode objectNode = objectMapper.createObjectNode();
		objectNode.put("firstName", "Shreyansh");
		objectNode.put("lastName", "Jain");
		try {
			System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("After Adding Booking Details...");
		ObjectNode bookingDetails = objectMapper.createObjectNode();
		bookingDetails.put("from", "Sitapur");
		bookingDetails.put("to", "Hyd");
		objectNode.set("bookingDetails", bookingDetails);
		try {
			System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		/*
		 * Retrieve a field value from JSON Object or ObjectNode
		 */
		// We can retrieve field value by passing field name. Since it is string, use
		// asText().
		String firstName = objectNode.get("firstName").asText();
		System.out.println("First name is : " + firstName);

		// We can use asText() as well but return type will be string
		String lastName = objectNode.get("lastName").asText();
		System.out.println("Last Name is : " + lastName);

		// To retrieve value of nested ObjectNode
		String fromLocation = objectNode.get("bookingDetails").get("from").asText();
		System.out.println("from Location is : " + fromLocation);

		JsonNode jsonNode = objectNode.get("bookingDetails");
		System.out.println("BookingDetails Node -  " + jsonNode);

		// Retrieve all field names from JSON Object or Object Node
		// To get all field names
		System.out.println("Retrieving all field names from JSON Object or Object Node.");
		System.out.println("Count of fields in ObjectNode : " + objectNode.size());
		Iterator<String> allFieldNames = objectNode.fieldNames();
		System.out.println("Fields are -- ");
		while (allFieldNames.hasNext()) {
			System.out.println(allFieldNames.next());
		}

		System.out.println("Retrieving all field values from from JSON Object or ObjectNode");

		// To get all field values
		Iterator<JsonNode> allFieldValues = objectNode.elements();
		System.out.println("Fields values are : ");
		while (allFieldValues.hasNext()) {
			System.out.println(allFieldValues.next());
		}

		System.out.println("Retrieve all key-value pair from JSON Object or ObjectNode");

		// To get all key-value pair
		Iterator<Entry<String, JsonNode>> allFieldsAndValues = objectNode.fields();
		System.out.println("All fields and their values are : ");
		while (allFieldsAndValues.hasNext()) {
			Entry<String, JsonNode> node = allFieldsAndValues.next();
			System.out.println("Key is : " + node.getKey() + " and its value is : " + node.getValue());
		}

		System.out.println("Removing FirstName...");
		firstName = objectNode.remove("firstName").asText();
		System.out.println("firstName is ---" + firstName);

		System.out.println("All fields and their values after removing firstName : ");

		// To get all key-value pair
		allFieldsAndValues = objectNode.fields();

		while (allFieldsAndValues.hasNext()) {
			Entry<String, JsonNode> node = allFieldsAndValues.next();
			System.out.println("Key is : " + node.getKey() + " and its value is : " + node.getValue());
		}
		
		// To replace a field value, use put() method for non ObjectNode type and replace() or set() for ObjectNode
				objectNode.put("firstName", "Amod");
				objectNode.put("firstName", "Aditya");
				String updatedJsonObject = null;
				try {
					updatedJsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("After updating field , JSON Object is : \n"+ updatedJsonObject);
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}