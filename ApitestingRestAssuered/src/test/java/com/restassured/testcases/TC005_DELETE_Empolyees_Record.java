package com.restassured.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.restassured.base.TestBase;
import com.restassured.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_DELETE_Empolyees_Record extends TestBase {
	RequestSpecification httprequst;
	Response response;
	String empName = RestUtils.empName();
	String empSal = RestUtils.empSal();
	String empAge = RestUtils.empAge();

	// randomly generated data
	@Test
	void deleteEmployee() throws InterruptedException {
		logger.info("***Started TC005_DELETE_Empolyees_Record****");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequst = RestAssured.given();
		Response response = httprequst.request(Method.GET,"/employee");
		JsonPath jsonPathEvalutor = response.jsonPath();
		String EmpID=jsonPathEvalutor.get("[0].id");
		Response response1 = httprequst.request(Method.DELETE,"/delete/"+EmpID);
		Thread.sleep(5000);

	}

	@Test
	void checkResponseBody() {
		logger.info("****checkResponseBody ****");
		String responseBody = response.getBody().asString();
		System.out.println("responsebody is:" + responseBody);
		logger.info("responseBody is==>" + responseBody);
	}

	@Test
	void checkStatusCode() {
		logger.info("****checkStatusCodey ****");
		int statusCode = responce.getStatusCode();
		logger.info("statusCode is==>" + statusCode);
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	void checkresponceTime() {
		logger.info("****checkresponceTime ****");
		long responceTime = responce.getTime();
		logger.info("responceTime is==>" + responceTime);

		Assert.assertTrue(responceTime < 6000);
	}

	@Test
	void checkStatusLine() {
		logger.info("****checkStatusLine ****");
		String statusline = responce.getStatusLine();
		logger.info("statusline is==>" + statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");

	}

	@Test
	void checkContent_Type() {
		logger.info("****checkContent_Type ****");
		String content_Type = responce.header("Content-Type");
		logger.info("content_Type is:" + content_Type);
		Assert.assertEquals(content_Type, "application/json");

	}

	@Test
	void checkServer_Type() {
		logger.info("****checkServer_Type ****");
		String server_Type = responce.header("Server");
		logger.info("Server_Type is:" + server_Type);
		Assert.assertEquals(server_Type, "nginx");

	}

	@Test
	void checkcontent_Length() {
		logger.info("****checkcontentLength****");
		String contentLength = responce.header("Content-Length");
		logger.info("content_Encoding is:" + contentLength);

		Assert.assertTrue(Integer.parseInt(contentLength) < 1500);

	}

	@AfterClass
	void tearDown() {
		logger.info("*******finshed Post_Empolyees_Record***");

	}


}
