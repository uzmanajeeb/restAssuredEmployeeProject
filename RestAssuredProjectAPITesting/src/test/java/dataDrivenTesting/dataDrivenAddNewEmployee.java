package dataDrivenTesting;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class dataDrivenAddNewEmployee {
	
	@Test(dataProvider="empdataProvider")
	void postNewEmployee(String ename,String esal,String eage)
	
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject RequestParams = new JSONObject ();
		
		RequestParams.put("name", ename);
		RequestParams.put("salary", esal);
		RequestParams.put("age", eage);
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(RequestParams.toJSONString());
		
		Response response=httpRequest.request(Method.POST,"/create");
		
		String ResponseBody=response.getBody().asString();
		
		AssertJUnit.assertEquals(ResponseBody.contains(ename), true);
		AssertJUnit.assertEquals(ResponseBody.contains(esal), true);
		AssertJUnit.assertEquals(ResponseBody.contains(eage), true);
		
		int statuscode=response.getStatusCode();
		AssertJUnit.assertEquals(statuscode, 200);
		
		
		
		
		
		
	}
	
	@DataProvider(name="empdataProvider")
	
	String [][]getEmpData() throws IOException
	{
		String path = System.getProperty("user.dir")+ "path with forword slash ";
		int rownum=XLUtil.getRowCount(path,"NameOfTheFile");
		int colcount =XLUtil.getCellCount(path,"NameOfTheFile",1);
		//String empdata[][] = { { "Tiger","50000","32"},{"Simran", "45000","25"},{"Sara","35000","26"}}; for dynamic array
		// Static Array
		
		String empdata[][]=new String[rownum][colcount];
		
		for (int i=1; i<= rownum; i++) {
			for (int j=0; j < colcount ;j++) {
				empdata[i-1][j]=XLUtil.getCellData(path,"Sheet1",i,j);
				}
		}
				
			
		
		
		return(empdata);

} }
