package javaScriptInSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToHandleHiddenElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/signup");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='It is working';", driver.findElement(By.name("custom_gender")));
		driver.findElement(By.xpath("//label[text()='Custom']/..//input[@name='sex']")).click();
	}

}
