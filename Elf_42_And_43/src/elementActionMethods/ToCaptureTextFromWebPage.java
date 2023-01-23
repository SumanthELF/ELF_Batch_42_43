package elementActionMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCaptureTextFromWebPage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/login");
		
		driver.findElement(By.id("Email")).sendKeys("Sumanth",Keys.TAB);
		Thread.sleep(2000);
		String errorMessage = driver.findElement(By.xpath("//span[@for='Email']")).getText();
		System.out.println(errorMessage);
	}

}
