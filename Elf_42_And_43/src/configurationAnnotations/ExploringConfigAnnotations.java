package configurationAnnotations;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExploringConfigAnnotations {
		
	@BeforeSuite
	public void browserSetup() {
		Reporter.log("JDBC connection, Report config",true);
	}	
	@AfterSuite
	public void browserTearDown() {
		Reporter.log("JDBC close, Flush reports",true);
	}
	
	@BeforeClass
	public void loginToApp() {
		Reporter.log("Browser launch",true);
	}	
	@AfterClass
	public void afterClass() {
		Reporter.log("Closing browser session",true);
	}
	@BeforeTest
	public void beforeTest() {
		Reporter.log("From before test",true);
	}
	@AfterTest
	public void logoutOfApp() {
		Reporter.log("From after test",true);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("login to app",true);
	}
	@AfterMethod
	public void afterMethod() {
		Reporter.log("logout of app",true);
	}
	
	
	
	
}
