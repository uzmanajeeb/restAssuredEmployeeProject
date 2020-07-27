import io.restassured.http.Header;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TCC_005_allHeaders {
	@Test
	void print_allHeaders()
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET,"/employee");
		
		String responseBody=response.getBody().asString();
		
		System.out.println("Response Body is:"+ responseBody);
		
		Headers allheaders= response.headers();
		
		for (Header header:allheaders)
		{
			System.out.println(header.getName()+ "   " + header.getValue());
		}
		
		
		
		
		
		
		
		
	}

}
