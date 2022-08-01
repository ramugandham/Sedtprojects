package Apitesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_Request_PrintAllheaders {
	
	@Test
	void printAllHeaders() {
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httprequst = RestAssured.given();
		Response response = httprequst.request(Method.GET, "/user?page=2");
		String responseBody = response.getBody().asString();
		System.out.println("responsebody is:" + responseBody);
		Headers allHeaders = response.headers();
		for(Header header:allHeaders) {
			System.out.println(header.getName()+"    "+header.getValue());
			
		}
	
	
	
	
	
	}

}
