package com.restassured.utilities;

import org.testng.annotations.Test;

import com.restassured.base.TestBase;

public class Demo extends TestBase{
	
	
	@Test
	void demo() {
		String empName=RestUtils.empName();
		 String empSal=RestUtils.empSal();
		 String empAge=RestUtils.empAge();
		 System.out.println(empName);
		 System.out.println(empSal);
		 System.out.println(empAge);
	}

}
