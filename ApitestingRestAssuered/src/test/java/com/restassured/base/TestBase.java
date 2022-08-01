package com.restassured.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	
	public static RequestSpecification httpRequst;
	public static Response responce;
	public static String EmpID="2";
	
	public Logger logger;
	@BeforeClass
	public void setUp() {
		logger=LogManager.getLogger(this.getClass());
		
		
	}
	
	
	

}
