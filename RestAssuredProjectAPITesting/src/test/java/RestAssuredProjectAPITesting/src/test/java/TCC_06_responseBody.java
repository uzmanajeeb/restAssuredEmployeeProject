package RestAssuredProjectAPITesting.src.test.java;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TCC_06_responseBody {
	@Test
	public void validateJsonResponeBody()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET,"/employee");
		
		String responseBody=response.getBody().asString();
		
		System.out.println("Response Body is: " + responseBody);
		// capture details of header from response
		//String contentType=response.header("Host");
		//System.out.println("Content Type is :"+ contentType);
		
		Assert.assertEquals(responseBody.contains("name"), true);
		
		
		
		
		
		
		
		
		
	}
	

}
