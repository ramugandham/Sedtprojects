package com.restassured.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restassured.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_Get_Single_empolyees extends TestBase{
	@BeforeClass
	void getSingleempolyee() throws InterruptedException {
		logger.info("****start TC002_get_SingleEmployees****");
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
		 responce = httpRequest.request(Method.GET,"/employee/"+EmpID);
		Thread.sleep(3000);
	}
	@Test
	void checkresponceBody() {
		logger.info("****checkresponceBody****");
		String responceBody = responce.getBody().asString();
		logger.info("responcebody is==>"+responceBody);
		Assert.assertEquals(responceBody.contains(EmpID), true);
	}
	@Test
	void checkStatusCode() {
		logger.info("****checkStatusCodey ****");
		int statusCode = responce.getStatusCode();
		logger.info("statusCode is==>"+statusCode);
	Assert.assertEquals(statusCode, 200);
	}
	@Test
	void checkresponceTime() {
		logger.info("****checkresponceTime ****");
		long responceTime = responce.getTime();
		logger.info("responceTime is==>"+responceTime);
		
		Assert.assertTrue(responceTime<6000);
	}
	@Test
	void checkStatusLine() {
		logger.info("****checkStatusLine ****");
		String statusline=responce.getStatusLine();
		logger.info("statusline is==>"+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");

	
	}
	@Test
	void checkContent_Type() {
		logger.info("****checkContent_Type ****");
		 String content_Type=responce.header("Content-Type");
		 logger.info("content_Type is:" + content_Type);
		 Assert.assertEquals(content_Type, "application/json");

	
	}
	@Test
	void checkServer_Type() {
		logger.info("****checkServer_Type ****");
		 String server_Type=responce.header("Server");
		 logger.info("Server_Type is:" + server_Type);
		 Assert.assertEquals(server_Type, "nginx");

	
	}
	@Test
	void checkcontent_Length() {
		logger.info("****checkcontentLength****");
		 String contentLength=responce.header("Content-Length");
		 logger.info("content_Encoding is:" + contentLength);
		
		 Assert.assertTrue(Integer.parseInt(contentLength)<1500);

	
	}
	@AfterClass
	void tearDown() {
		logger.info("*******finshed test emp***");
		
	}
	

}
