package workingWithTextNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ToUnderstandStale {

	@Test
	public void sample() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.redbus.in/");
		WebElement fromTextField = driver.findElement(By.id("src"));
		WebElement toTextField = driver.findElement(By.id("dest"));
		WebElement dateField = driver.findElement(By.xpath("//label[.='Date']"));
		WebElement searchButton = driver.findElement(By.id("search_btn"));
		
		fromTextField.sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[contains(.,'Anand Rao')]")).click();
		toTextField.sendKeys("Goa");
		driver.findElement(By.xpath("//li[contains(.,'Mapusa')]")).click();
		dateField.click();
		driver.findElement(By.xpath("//td[text()='14']")).click();
		searchButton.click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("redbus")).click();
		
		driver.findElement(By.id("src")).clear();
		driver.findElement(By.id("src")).sendKeys("Mangalore");
		driver.findElement(By.xpath("//li[.='Mangalore Bypass']")).click();
		toTextField.clear();
		toTextField.sendKeys("Chennai");
		driver.findElement(By.xpath("//li[contains(.,'Koyambedu')]")).click();
		dateField.click();
		driver.findElement(By.xpath("//td[text()='16']")).click();
		searchButton.click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("redbus")).click();
		
	}
}
