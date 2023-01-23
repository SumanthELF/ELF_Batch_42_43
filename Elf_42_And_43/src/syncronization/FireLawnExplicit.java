package syncronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FireLawnExplicit {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://firelawn.com/");
		
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);
		
		driver.findElement(By.xpath("//span[text()='5.0']/../..//img[@alt='APPLE iPhone 14 Pro']")).click();
		driver.findElement(By.xpath("//input[@placeholder='580023']")).sendKeys("560019");
		WebElement checkButton = driver.findElement(By.xpath("//button[text()='Check']"));
		explicitWait.until(ExpectedConditions.elementToBeClickable(checkButton));
		checkButton.click();
		
		try {
			//code to click on the email which you have sent 
		}catch (NoSuchElementException e) {
			//code to refresh page
			//code to click on the email which you have sent 
		}
		//code for clicking on delete
	}

}
