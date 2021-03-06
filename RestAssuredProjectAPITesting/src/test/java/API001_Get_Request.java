

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import io.restassured.*;

public class API001_Get_Request {

	@Test
	void getweatherDetails()
	{
		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest= RestAssured.given();
		
		io.restassured.response.Response response=httpRequest.request(Method.GET,"/employees");
		
		String responseBody=response.getBody().asString();
		System.out.println("Response body is" + responseBody);
		// status code validation 
		int statusCode=response.getStatusCode();
		System.out.println("status code is :"+statusCode);
		Assert.assertEquals(statusCode, 200);
		// status line varification
		String statusLine =response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
}
