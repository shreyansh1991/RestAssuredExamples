package jsonparsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParsing {
	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir") + File.separator + "employee.json";
		JSONParser jsonParser = new JSONParser();
		JSONObject addressObject = null;
		JSONObject jsonObject=null;
		try {
			Object object = null;
			try {
				object = jsonParser.parse(new FileReader(new File(filePath)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 jsonObject = (JSONObject) object;
			System.out.println("jsonObject is " + jsonObject);
			Object object3 = jsonObject.get("cities");
			System.out.println("Cities Array => "+ object3);
			JSONArray jsArray=(JSONArray)object3;
			
			System.out.println("JSON Array "+ jsArray);
			System.out.println(jsArray.size());
			
			   jsArray.add("key3:Blore");
			   
			/*for(int i=0;i<jsArray.size();i++)
			{
				System.out.print("iterating json array - "+i );
				 
				   System.out.println ("root object - "+ jsArray.get(i));
				 
				   jsArray.add("yo");
				   
				   System.out.println(" jsArray.size() -- "+jsArray.size());
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}*/
		
			Object object2 = jsonObject.get("address");
			Object role = jsonObject.get("role");
			System.out.println("role ::" + role);
			 addressObject = (JSONObject) object2;

			Set<String> addresses = addressObject.keySet();
			Iterator<String> iterator = addresses.iterator();

			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(key + " :: " + addressObject.get(key));
				if(key.equals("zipcode"))
				{
				addressObject.put(key, "9458703411");
				//jsonObject.put(key, addressObject.put(key, "8884688154"));
				}
			}
			
		}

		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 // writing JSON to file:"JSONExample.json" in cwd 
        PrintWriter pw = null;
		try {
			pw = new PrintWriter(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        pw.write(jsonObject.toJSONString()); 
          
        pw.flush(); 
        pw.close(); 
        System.out.println("done");

	}
}
