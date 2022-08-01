package Apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Validating_Jsonresponsebody {
	
	
	@Test
	void validating_Jsonresponsebody() {
		RestAssured.baseURI = "https://restcountries.com/v2/capital";
		RequestSpecification httprequst = RestAssured.given();
		Response response = httprequst.request(Method.GET, "/delhi");
		String responseBody = response.getBody().asString();
		System.out.println("responsebody is:" + responseBody);
		 Assert.assertEquals(responseBody.contains("New Delhi"), true);
	}
}
