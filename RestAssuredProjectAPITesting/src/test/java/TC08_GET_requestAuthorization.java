import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC08_GET_requestAuthorization {

	@Test

	public void AuthorizationTest() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/");
		
		int statusCode=response.getStatusCode();
		System.out.println("Status code is :" + statusCode);
		Assert.assertEquals(statusCode, 200);

		String responseBody = response.getBody().asString();

		System.out.println("Response Body is: " + responseBody);
		// capture details of header from response
		// String contentType=response.header("Host");
		// System.out.println("Content Type is :"+ contentType);

		//Assert.assertEquals(responseBody.contains("name"), true);

	}

}
