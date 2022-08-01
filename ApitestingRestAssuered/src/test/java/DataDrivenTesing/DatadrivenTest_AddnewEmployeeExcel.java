package DataDrivenTesing;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DatadrivenTest_AddnewEmployeeExcel {
	
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
      String[][]getEmpData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/DataDrivenTesing/Employeedata.xlsx";

		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String empdata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //1
		{		
			for(int j=0;j<totalcols;j++)  //0
			{
				empdata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
		return empdata;
      
		}
}

	
	
	
	
	
	
	
	
	
	
	
	


