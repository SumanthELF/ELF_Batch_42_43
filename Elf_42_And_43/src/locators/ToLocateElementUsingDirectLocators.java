package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToLocateElementUsingDirectLocators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();
		driver.findElement(By.id("Email")).sendKeys("Sumanth");
		Thread.sleep(2000);
		driver.findElement(By.id("Password")).sendKeys("Testing@123");
		Thread.sleep(2000);
	}

}
