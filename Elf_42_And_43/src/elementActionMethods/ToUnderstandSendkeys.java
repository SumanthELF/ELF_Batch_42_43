package elementActionMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToUnderstandSendkeys {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login");
		driver.findElement(By.xpath("//input[@placeholder='Email address or phone number']"))
									.sendKeys("Sumanth",Keys.CONTROL+"A");
		driver.findElement(By.xpath("//input[@placeholder='Email address or phone number']"))
								.sendKeys(Keys.CONTROL+"c");
		driver.findElement(By.id("pass")).sendKeys(Keys.CONTROL+"V");
		
	}

}
