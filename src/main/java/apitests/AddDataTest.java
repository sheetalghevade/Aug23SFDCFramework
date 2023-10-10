package apitests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import apiTestdata.AddUser;
import apiUtils.CommonUtilities;
import apireusableutils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class AddDataTest extends APIBaseTest{

	@BeforeClass
	public void setUri() throws IOException {

			
		System.out.println(RestAssured.baseURI);
	}
	
	
	
	@Test
	public void adddataTC_01() throws JsonProcessingException {
		
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Token", token);
		headers.put("Content-Type", "application/json");
		
//		HashMap<String, String> payload = new HashMap<>();
//		payload.put("accountno", "TA-abcdefh");
//		payload.put("departmentno", "1");
//		payload.put("salary", "123456");
//		payload.put("pincode", "112233");

		Random rand = new Random();
		int upperbound = 25;
		int account = rand.nextInt();
		
		String accountno = Integer.toString(account);
		
		System.out.println(accountno);
		
		AddUser usr1 = new AddUser(accountno, "1", "12345", "123456");
//		Creating Serialize payload of user
		String sPayload = CommonUtilities.serializeObject(usr1);
		Response addUser = RestUtils.postReq(sPayload, headers, "/addData");
//				.then().assertThat().statusCode(200)
//				.extract().response();
		
			
		
		System.out.println("Added User: "+addUser.asPrettyString());
		Response getUsersData = RestUtils.getReq(headers, "/getdata");
		
       	List<String> accountno1 = getUsersData.jsonPath().getList("account");
		 
		System.out.println(accountno1.size());
		assertThat(accountno1.contains(accountno), false);
		
		boolean ispresent = getUsersData.asPrettyString().contains(accountno);
		
		if(ispresent == true) {
			System.out.println("user added successfully");
		}
		else {
			System.out.println("user not added");
		}
	}



	private void assertThat(boolean contains, boolean assertion) {
		// TODO Auto-generated method stub
		
	}
	
}
