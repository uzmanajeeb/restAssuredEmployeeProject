import org.junit.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TCC_04GET_header {
	
	@Test
	void googleMaps_header()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/employee/1");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		// capture details of header from response
		String contentType=response.header("Host");
		System.out.println("Content Type is :"+ contentType);
		//Assert.assertEquals(contentType, "<calculated when request is sent>");
	}

}
