import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC07_GET_ExtractValueOfEachNodeInJSON {

	@Test
	public void extractValueOfNode()
	{
		
RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET,"/employees");
		
		JsonPath jsonpath=response.jsonPath();
		
		System.out.println(jsonpath.getBoolean("employee_name"));
		//System.out.println(jsonpath.getBoolean("age"));
		//System.out.println(jsonpath.getBoolean("id"));
	//	System.out.println(jsonpath.getBoolean("salary"));
		
		
		
		
		
		
		
		
		
		
	
	}
}
