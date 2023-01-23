package configurationAnnotations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import genericLibrary.ReadData;

public class BaseTest {

	public WebDriver driver;
	// Expected Data
	String expectedLoginPageTitle = "actiTIME - Login";
	String expectedHomePageTitle = "actiTIME -  Enter Time-Track";
	String usernameData = "admin";
	String passwordData = "manager";

	@Parameters("browserName")
	@BeforeClass(alwaysRun=true)
	public void browserSetUp(@Optional("chrome") String bname) throws InvalidBrowserValueException {
		//Step 1: Open the browser and enter the test Url
		if (bname.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (bname.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			throw new InvalidBrowserValueException();
		}
		Reporter.log("Empty browser is launched", true);
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized", true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(ReadData.fromPropertyFile("url"));
		String actualLoginPageTitle = driver.getTitle();
		if (expectedLoginPageTitle.equals(actualLoginPageTitle)) {
			Reporter.log("Login Page is displayed", true);
		} else {
			Reporter.log("Login Page is not displayed", true);
		}
	}

	@BeforeMethod(alwaysRun=true)
	public void loginToApplication() {
		//Step 2: Enter valid credentials into Username text field and Password text field
		WebElement usernameTextField = driver.findElement(By.id("username"));
		usernameTextField.clear();
		usernameTextField.sendKeys(ReadData.fromPropertyFile("username"));
		String actualUsernameEntered = usernameTextField.getAttribute("value");
		if (usernameData.equals(actualUsernameEntered)) {
			Reporter.log("Sucessfully entered username into Username Text field", true);
		} else {
			Reporter.log("Username is not entered sucessfully", true);
		}

		WebElement passwordTextField = driver.findElement(By.name("pwd"));
		passwordTextField.clear();
		passwordTextField.sendKeys(ReadData.fromPropertyFile("password"));
		String actualPasswordEntered = passwordTextField.getAttribute("value");
		if (passwordData.equals(actualPasswordEntered)) {
			Reporter.log("Sucessfully entered password into Password Text field", true);
		} else {
			Reporter.log("Password is not entered sucessfully", true);
		}

		// Step 3: Click on Login Button
		driver.findElement(By.id("loginButton")).click();
		String actualHomePageTitle = driver.getTitle();
		if (expectedHomePageTitle.equals(actualHomePageTitle)) {
			Reporter.log("Home Page is displayed", true);
			Reporter.log("Successfully Logged in to application",true);
		} else {
			Reporter.log("Home Page is not displayed", true);
		}
	}
	
	@AfterMethod(alwaysRun=true)
	public void logOutOfApp() {
		driver.findElement(By.id("logoutLink")).click();
		String actualLoginPageTitle = driver.getTitle();
		if (expectedLoginPageTitle.equals(actualLoginPageTitle)) {
			Reporter.log("Login Page is displayed", true);
			Reporter.log("Successfully Logged out of application",true);
		} else {
			Reporter.log("Login Page is not displayed", true);
		}
	}
	
	@AfterClass(alwaysRun=true)
	public void browserTearDown() {
		driver.quit();
		Reporter.log("Closed the browser session",true);
	}
}

@SuppressWarnings("serial")
class InvalidBrowserValueException extends Exception {
	public InvalidBrowserValueException() {
		super("The browser name passed is invalid");
	}
}
