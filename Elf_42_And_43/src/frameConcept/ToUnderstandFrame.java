package frameConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToUnderstandFrame {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.dream11.com/");
		WebElement frmaeElement = driver.findElement(By.xpath("//iframe[@title='Iframe Example']"));
		Thread.sleep(2000);
		driver.switchTo().frame(frmaeElement);
		
		driver.findElement(By.id("regEmail")).sendKeys("9876543210");
	}

}
