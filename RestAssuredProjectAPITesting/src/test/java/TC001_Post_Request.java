import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_Post_Request {
 @Test
 void postRegistration()
 {
	 RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
	 
	 RequestSpecification httpRequest=RestAssured.given();
	 JSONObject requestParams = new JSONObject();
	 requestParams.put("name", "miller");
	 requestParams.put("salary", "9250");
	 requestParams.put("age", "31");
	 httpRequest.header("Content-Type","application/json");
	 httpRequest.body(requestParams.toJSONString());
	 Response response=httpRequest.request(Method.POST,"/create");
	 
	 String responseBody=response.getBody().asString();
	 System.out.println("Response body is :" +responseBody);
	 
	 int statusCode=response.getStatusCode();
	 System.out.println("Response Body is;" +statusCode);
	 Assert.assertEquals(statusCode, 201);
	 
	 String successCode=response.jsonPath().getString("successCode");
	 //Assert.assertEquals(successCode,"null");
	 
	
	 
	 
}}
