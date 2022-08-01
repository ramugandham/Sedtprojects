package DataDrivenTesing;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DatadrivenTest_AddnewEmployee {

	@Test(dataProvider ="empdataprovider")
	void postNewEmployeeDetials(String Efirst_name,String Elast_name,String Eemail) {

		RestAssured.baseURI = "https://reqres.in/api";
		RequestSpecification httprequst = RestAssured.given();
		JSONObject requestparams = new JSONObject();
		requestparams.put("first_name", Efirst_name);
		requestparams.put("last_name", Elast_name);
		requestparams.put("email", Eemail);

		httprequst.header("content-Type", "application/JSON");
		httprequst.body(requestparams.toJSONString());
		Response response = httprequst.request(Method.POST, "/users");
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		Assert.assertEquals(responseBody.contains(Efirst_name), true);
		Assert.assertEquals(responseBody.contains(Elast_name), true);
		Assert.assertEquals(responseBody.contains(Eemail), true);

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
	}
	@DataProvider(name="empdataprovider")
      String[][]getEmpData(){
    	  String[][]empdata= {{"JohnXYZ","XYZjohn","JohnXYZ@gmail.com"},{"RamXYZ","XYZram","ramXYZ@gmail.com"},
    			  {"peterXYZ","XYZpeter","peterXYZ@gmail.com"}};
		return empdata;
      
      }
}
