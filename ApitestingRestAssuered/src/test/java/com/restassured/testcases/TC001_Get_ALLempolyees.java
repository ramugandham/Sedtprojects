package com.restassured.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restassured.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_Get_ALLempolyees extends TestBase {
	@BeforeClass
	void getAllempolyee() throws InterruptedException {
		logger.info("****start Tc001_get_allEmployees****");
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
		 responce = httpRequest.request(Method.GET,"/employees");
		Thread.sleep(3);
	}
	@Test
	void checkresponceBody() {
		logger.info("****checkresponceBody****");
		String responceBody = responce.getBody().asString();
		logger.info("responcebody is==>"+responceBody);
		Assert.assertTrue(responceBody!=null);
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
		if(responceTime>2000)
			logger.warn("responce time is grater than 2000");
		Assert.assertTrue(responceTime<2000);
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
	void checkcontent_Encoding() {
		logger.info("****checkcontent_Encoding ****");
		 String content_Encoding=responce.header("Content-Encoding");
		 logger.info("content_Encoding is:" + content_Encoding);
		 Assert.assertEquals(content_Encoding, "gzip");

	
	}
	@Test
	void checkcontent_Length() {
		logger.info("****checkcontentLength****");
		 String contentLength=responce.header("Content-Length");
		 logger.info("content_Encoding is:" + contentLength);
		 if(Integer.parseInt(contentLength)<100)
			 logger.warn("contentLength is less than 100");
		 Assert.assertTrue(Integer.parseInt(contentLength)<100);

	
	}
	@Test
	void checkCookies() {
		logger.info("****checkCookies****");
		 String cookies=responce.getCookie("ezosuibasgeneris-1");
		 logger.info("cookies is:" + cookies);
		 Assert.assertEquals(cookies, "d2a7ab80-f7be-44cc-589e-576e3bbdab82");

	
	}
	@AfterClass
	void tearDown() {
		logger.info("*******finshed test emp***");
		
	}
	

	
}
