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

public class JsonParsing2 {
	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir") + File.separator + "sample.json";
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
			Object object2 = jsonObject.get("contact");
			JSONArray jsonObj = (JSONArray) object2;

			System.out.println("City Array is " + jsonObj);
			
			
			for (Object temp : jsonObj) {
				JSONObject 	tempCity=(JSONObject)temp;
				
				tempCity.put(temp, "surat");
				System.out.println(temp);
			}
		}

		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//  writing JSON to file:"JSONExample.json" in cwd 
        PrintWriter pw = null;
		try {
			pw = new PrintWriter(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        pw.write(jsonObject.toJSONString()); 
//          
        pw.flush(); 
        pw.close(); 
        System.out.println("done");

	}
}

