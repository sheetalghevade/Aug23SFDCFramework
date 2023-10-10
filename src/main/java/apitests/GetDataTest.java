package apitests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import apireusableutils.RestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class GetDataTest extends APIBaseTest{
	
	@BeforeClass
	public void setUri() throws IOException {

			
		System.out.println(RestAssured.baseURI);
	}

	
	@Test
	public void getdataTC_01() {
		HashMap<String, String> headers = new HashMap<>();
		headers.put("Token", token);
		headers.put("Content-Type", "application/json");
		
		Response getUsersData = RestUtils.getReq(headers, "/getdata");
		
		List<String> accountno = getUsersData.jsonPath().getList("account");
		
		System.out.println(accountno.size());
		assertThat(accountno.size(), greaterThan(1000));
		
//		Assertion can be done seperately.
		Assert.assertEquals(getUsersData.statusCode(), 200);
		System.out.println("Users: "+getUsersData.asPrettyString());
	}
	
}
