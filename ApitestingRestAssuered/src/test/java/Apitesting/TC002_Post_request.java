package Apitesting;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Post_request {
	@Test
	void registrationSuccessful() {

		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httprequst = RestAssured.given();
		JSONObject requestparams = new JSONObject();
		requestparams.put("first_name", "JohnXYZ");
		requestparams.put("last_name", "XYZjohn");
		requestparams.put("email", "JohnXYZ@gmail.com");

		httprequst.header("content-Type", "application/JSON");
		httprequst.body(requestparams.toJSONString());
		Response response = httprequst.request(Method.POST, "/users");
		String responseBody = response.getBody().asString();
		System.out.println("responsebody is:" + responseBody);
		int statusCode = response.getStatusCode();
		System.out.println("status code is:" + statusCode);
		Assert.assertEquals(statusCode, 201);

		String successCode = response.jsonPath().get("email");
		System.out.println("successCode is:" + successCode);
		Assert.assertEquals(successCode, "JohnXYZ@gmail.com");

	}

}
