package Apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TS007_GET_Authorizaation {
	
	
	@Test
	void authenticationTest() {
		RestAssured.baseURI = "https://postman-echo.com";
		PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
		authscheme.setUserName("postman");
		authscheme.setPassword("password");
		RestAssured.authentication=authscheme;
		
		RequestSpecification httprequst = RestAssured.given();
		Response response = httprequst.request(Method.GET, "/basic-auth");
		int statuscode=response.getStatusCode();
		System.out.println("statuscode;"+statuscode);
		Assert.assertEquals(statuscode, 200);
		String responseBody = response.getBody().asString();
		System.out.println("Response Body Is :" + responseBody);
	
	}
}
