package apireusableutils;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestUtils {
	
	public static Response postReq(HashMap<String, String> payload, HashMap<String, String> headers, String endpoint) {
	return	RestAssured.given().headers(headers).when().body(payload).post(endpoint);
	}

	public static Response getReq(HashMap<String,String> headers, String endpoint){
		return RestAssured.given().headers(headers).when().get(endpoint);
	}
	
	public static Response postReq(Object payload, HashMap<String, String> headers, String endpoint) {
		return	RestAssured.given().headers(headers).when().body(payload).post(endpoint);
		}
	
	public static Response postReq(String payload, HashMap<String, String> headers, String endpoint) {
		return	RestAssured.given().headers(headers).when().body(payload).post(endpoint);
		}
}
