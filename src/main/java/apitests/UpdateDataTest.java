package apitests;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import apiTestdata.UpdateUser;
import apiUtils.CommonUtilities;
import apireusableutils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateDataTest extends APIBaseTest{

	
	@BeforeClass
	public void setUri() throws IOException {
		System.out.println(RestAssured.baseURI);
	}
	
	
	
	@Test
	public void adddataTC_01() throws JsonProcessingException {
		
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Token", token);
		headers.put("Content-Type", "application/json");
		
				
		UpdateUser usr1 = new UpdateUser("TA-GV11122","1","111","112212","fbSxAvmF5UgV1RLuX411","JBI15ufyViE1MQ1BroVt");
//		Creating Serialize payload of user
		String sPayload = CommonUtilities.serializeObject(usr1);
		Response updateUser = RestUtils.postReq(sPayload, headers, "/updateData");
//				.then().assertThat().statusCode(200)
//				.extract().response();
		
		System.out.println(updateUser.asPrettyString());
	}
}
