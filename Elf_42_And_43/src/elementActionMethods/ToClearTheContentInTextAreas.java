package elementActionMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToClearTheContentInTextAreas {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		/*driver.get("https://demo.vtiger.com/vtigercrm/");

		Thread.sleep(2000);
		WebElement usernameTextField = driver.findElement(By.xpath("//input[@id='username']"));
		usernameTextField.clear();
		Thread.sleep(1000);
		usernameTextField.sendKeys("Sumanth");
		Thread.sleep(1000);
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@name='password']"));
		passwordTextField.clear();
		Thread.sleep(1000);
		passwordTextField.sendKeys("Testing@123");
		driver.findElement(By.xpath("//button[text()='Sign in']")).submit();*/
		
		driver.get("https://www.instagram.com/accounts/login/");
		Thread.sleep(1000);
		WebElement usernameTextField = driver.findElement(By.name("username"));
		Thread.sleep(1000);
		usernameTextField.sendKeys("sumanth");
		Thread.sleep(1000);
		usernameTextField.sendKeys(Keys.CONTROL+"a");
		usernameTextField.sendKeys(Keys.DELETE);
	}

}
