package apitests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.BeforeTest;

import com.jayway.jsonpath.JsonPath;

import api.Constants.FileConstants;
import apiUtils.CommonUtilities;
import apireusableutils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIBaseTest {

	public static String token;
	
	public static void setToken() throws IOException {
		String uri = CommonUtilities.readFileandReturnString(FileConstants.URI_CONFIG_FILE_PATH);
		RestAssured.baseURI = JsonPath.read(uri, "$.login.prod");
		
		String creds = CommonUtilities.readFileandReturnString(FileConstants.USER_CONFIG_FILE_PATH);
		String un = JsonPath.read(creds, "$.prod.username");
		String pw = JsonPath.read(creds, "$.prod.password");
				
		HashMap<String, String> payload = new HashMap<>();
		payload.put("username", un);
		payload.put("password", pw);
		
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		
		Response res = RestUtils.postReq(payload,headers, "/login");
		
		System.out.println("Login Response: "+res.asPrettyString());
		
		token = res.jsonPath().getString("token").replace("[", "").replace("]", "");
		System.out.println("Token Generated: " +token);
		
	}
	
	@BeforeTest
	public void setup() throws IOException {
		APIBaseTest.setToken();
	}
	
}
