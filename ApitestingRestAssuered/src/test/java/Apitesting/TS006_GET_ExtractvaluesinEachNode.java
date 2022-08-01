package Apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TS006_GET_ExtractvaluesinEachNode {
	
	@Test
	void getExtractvaluesinEachNode() {
		RestAssured.baseURI = "https://restcountries.com/v2/capital";
		RequestSpecification httprequst = RestAssured.given();
		Response response = httprequst.request(Method.GET, "/delhi");
		JsonPath jsonpath = response.jsonPath();
		
		//System.out.println(jsonpath.get("name"));
		/*
		 * Assert.assertEquals(jsonpath.get("name"), "India");
		 * Assert.assertEquals(jsonpath.get("capital"), "New Delhi");
		 * Assert.assertEquals(jsonpath.get("subregion"), "Southern Asia");
		 */
		
		
	}
}
