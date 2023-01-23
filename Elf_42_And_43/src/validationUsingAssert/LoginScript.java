package validationUsingAssert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginScript {

	@Test
	public void loginAsAdmin() {
		String expectedLoginPageTitle = "actiTIME  Login";
		String expectedHomePageTitle = "actiTIME  Enter Time-Track";
		String usernameData = "admin";
		String passwordData = "manager";
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);
		SoftAssert softAssert = new SoftAssert();
		
		driver.get("https://demo.actitime.com/login.do");
		String actualLoginPageTitle = driver.getTitle();
		softAssert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle, "Login Page is not displayed");
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys(usernameData);
		softAssert.assertEquals(username.getAttribute("value"), usernameData, "Username is not entered properly");
		WebElement password = driver.findElement(By.name("pwd"));
		password.clear();
		password.sendKeys(passwordData);
		softAssert.assertEquals(password.getAttribute("value"), passwordData, "Password is not entered properly");
		driver.findElement(By.id("loginButton")).click();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
		softAssert.assertEquals(driver.getTitle(), expectedHomePageTitle, "Home Page is not displayed successfully");
		softAssert.assertAll();
	}
}
