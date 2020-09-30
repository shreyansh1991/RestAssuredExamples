package jacksonjsonjavaparser.jacksonjsonjavaparser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.FormatDemoBean;

public class FormatDemoBeanTest {
	ObjectMapper objectMapper = new ObjectMapper();
	@Test
	public void testSerializingWithJsonFormat()
	    throws JsonProcessingException, ParseException {
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
	        String dateAndTime = "26-09-2017 11:00:00";
	        Date date = null;
			try {
				date = simpleDateFormat.parse(dateAndTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        FormatDemoBean fb = new FormatDemoBean();
	        fb.setActiveDate(date);
	        String jsonString = objectMapper.writeValueAsString(fb);
	        System.out.println(jsonString);
	     /*   assertThat(jsonString, containsString("James Clark"));
	        assertThat(jsonString, containsString("123"));
	        assertThat(jsonString, containsString("26-09-2017 11:00:00"));*/
	}
}

