package apitests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.Constants.FileConstants;
import apireusableutils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class LoginTest extends APIBaseTest {
	
	String token;
	
	@BeforeClass
	public void setUri() throws IOException {
		
//		String uri = CommonUtilities.readFileandReturnString(FileConstants.URI_CONFIG_FILE_PATH);
//		RestAssured.baseURI = JsonPath.read(uri, "$.login.prod");
		
//		instead of above line 27 and 28 we can have below :
//		RestAssured.baseURI = JsonPath.read(FileConstants.URI_CONFIG_FILE_PATH, "$.login.prod");
		
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");

		
		HashMap<String, String> logincreds = new HashMap<>();
		logincreds.put("username", "ghevade@tekarch.com");
		logincreds.put("password", "Admin123");
		
		Response res = RestUtils.postReq(logincreds, headers, "/login");
		res.then().assertThat()
		.body(matchesJsonSchema(new File(FileConstants.LOGIN_SCHEMA_FILE_PATH)));
		
		Assert.assertEquals(res.statusCode(), "201");
		
//		Or for above three lines combined
//		Response res = RestUtils.postReq(logincreds, headers, "/login")
//				.then().assertThat().statusCode(201)
//		.body(matchesJsonSchema(new File(FileConstants.LOGIN_SCHEMA_FILE_PATH)))
//				.extract().response();
		
		
		
		System.out.println(RestAssured.baseURI);
		
	}
	
	@Test(enabled = true)
	public void loginTC_01(){
		
		System.out.println("Login Successfully");
	}




	
}
