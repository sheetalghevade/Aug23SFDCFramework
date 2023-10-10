package apiUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import apiTestdata.AddUser;

public class CommonUtilities {
	
	public static String readFileandReturnString(String Filepath) throws IOException {
		
		byte[] fileContents = Files.readAllBytes(Paths.get(Filepath));
		return new String(fileContents, StandardCharsets.UTF_8);
		}
	
//	to Convert object to json string(Serialization)	
	
	public static String serializeObject(Object user) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		om.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CASE);
		String sJasonPayload = om.writeValueAsString(user);
		
		System.out.println(sJasonPayload);
		return sJasonPayload;
	}
	
//	to Convert json to object string(De-Serialization)	
	
	public static Object deserializeObject(String sJson) throws JsonMappingException, JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		AddUser au = om.readValue(sJson, AddUser.class);
		
		System.out.println(au);
		
		return au;
	}
	
	
	
}

