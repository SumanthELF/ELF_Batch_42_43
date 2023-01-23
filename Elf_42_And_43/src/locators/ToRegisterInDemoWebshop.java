package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToRegisterInDemoWebshop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("gender-male")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("FirstName")).sendKeys("Sumanth");
		Thread.sleep(1000);
		driver.findElement(By.id("LastName")).sendKeys("c l");
		driver.findElement(By.name("Email")).sendKeys("sumanth.l@testyantra.com");
		driver.findElement(By.id("Password")).sendKeys("Testing@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Testing@321");
		Thread.sleep(3000);
		driver.findElement(By.id("register-button")).click();
	}
}
