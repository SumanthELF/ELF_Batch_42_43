package validationUsingAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidationOfFacebookLoginPage {

	@Test
	public void clickOnLoginWithoutEnteringCredentials() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Reporter.log("Empty Chrome browser is launched", true);
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized", true);
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);
		SoftAssert sa = new SoftAssert();
		
		driver.get("https://www.facebook.com/login/");
		sa.assertEquals(driver.getTitle(), "Log in to Facebook", "Login Page is not displayed");
		
		driver.findElement(By.id("loginbutton")).click();
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='email_container']/div[2]")));
		Reporter.log("Successfully clicked on Login button");
		sa.assertEquals(driver.getCurrentUrl(), "ttps://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100", "Url is mismatched");
		
		WebElement emailTextField = driver.findElement(By.id("email"));
		sa.assertEquals(emailTextField.getCssValue("border"), "1px solid rgb(240, 0, 73)", "Border colour of Email text field is mismatched");
		WebElement errorMessage = driver.findElement(By.xpath("//div[@id='email_container']/div[2]"));
		sa.assertEquals(errorMessage.getText(), "The email address or mobile number you entered isn't connected to an account. Find your account and log in.", "Error message is not displayed properly");
		
		sa.assertAll();
	}
}
