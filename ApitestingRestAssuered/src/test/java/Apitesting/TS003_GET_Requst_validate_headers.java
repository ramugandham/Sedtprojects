package Apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TS003_GET_Requst_validate_headers {
	@Test
	void validateHeaders() {
		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httprequst = RestAssured.given();
		Response response = httprequst.request(Method.GET, "/user?page=2");
		String responseBody = response.getBody().asString();
		System.out.println("responsebody is:" + responseBody);
		
		 String content_Type=response.header("Content-Type");
		 System.out.println("content_Type is:" + content_Type);
		 Assert.assertEquals(content_Type, "application/json; charset=utf-8");

		 String ContentEncoding=response.header("Content-Encoding");
		 System.out.println("ContentEncoding is:" + ContentEncoding);
		 Assert.assertEquals(ContentEncoding, "br");
	}
	}
	

