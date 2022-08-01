package Apitesting;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Requst {
	@org.testng.annotations.Test

	void getweatherDetails() {

		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httprequst = RestAssured.given();
		Response response = httprequst.request(Method.GET, "/user?page=2");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body Is :" + responseBody);
		int statuscode=response.getStatusCode();
		System.out.println("statuscode;"+statuscode);
		Assert.assertEquals(statuscode, 200);
		String statusline=response.getStatusLine();
		System.out.println("statusline;"+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1.200 OK");

	}

}
