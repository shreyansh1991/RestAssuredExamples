package complexjson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

/*[
  {
    "colors": [
      {
        "color": "black",
        "category": "hue",
        "type": "primary",
        "code": {
          "rgba": [
            255,
            255,
            255,
            1
          ],
          "hex": "#000"
        }
      },
      {
        "color": "white",
        "category": "value",
        "code": {
          "rgba": [
            0,
            0,
            0,
            1
          ],
          "hex": "#FFF"
        }
      }
    ]
  }
]
 * 
 * 
 * */


public class AutomateComplexJson {
	@Test
	public void demo() {
		Map<String, Object> colorsMap=new LinkedHashMap<>();
		List<Map<String, Object>> colorsArray=new ArrayList<>();
		Map<String, Object> firstObject=new LinkedHashMap<>();
		Map<String, Object> secondObject=new LinkedHashMap<>();
		
		Map<String, Object> codeMap=new HashMap<>();
		Map<String, Object> code=new HashMap<>();
		List<Integer> rgbaList1=new ArrayList<>();
		rgbaList1.add(255);
		rgbaList1.add(255);
		rgbaList1.add(255);
		rgbaList1.add(1);
		code.put("rgba", rgbaList1);
		code.put("hex", "#000");
		codeMap.put("code", code);
		firstObject.put("color", "black");
		firstObject.put("category", "hue");
		firstObject.put("type", "primary");
		firstObject.put("code", code);
		
		secondObject.put("color", "white");
		secondObject.put("category", "hue");
		
		Map<String, Object> codeMap1=new HashMap<>();
		Map<String, Object> code1=new HashMap<>();
		List<Integer> rgbaList2=new ArrayList<>();
		rgbaList2.add(0);
		rgbaList2.add(0);
		rgbaList2.add(0);
		rgbaList2.add(1);
		code1.put("rgba", rgbaList2);
		code1.put("hex", "#FFF");
		codeMap1.put("code", code);
		secondObject.put("code", code1);
		secondObject.put("category", "value");
		
		colorsArray.add(firstObject);
		colorsArray.add(secondObject);
		colorsMap.put("colors",colorsArray);

		RestAssured.given()
		.log()
		.all()
		.body(colorsMap)
		.when().get();
	}
}
