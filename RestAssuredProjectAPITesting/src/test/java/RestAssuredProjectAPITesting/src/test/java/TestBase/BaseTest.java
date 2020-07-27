package RestAssuredProjectAPITesting.src.test.java.TestBase;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import com.sun.xml.fastinfoset.sax.Properties;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID ="51838"; // hard coded - input for get details of single employee & update employee
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		
		logger=Logger.getLogger("EmployeeRestAPI");
		Properties props = new Properties();
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.WARNING);
		
		
	
	}
}
