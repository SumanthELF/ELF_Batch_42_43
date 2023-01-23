package elementActionMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToWorkWithBooleanMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		/*driver.get("https://demo.actitime.com/login.do");
		WebElement checkBox = driver.findElement(By.id("keepLoggedInCheckBox"));
		System.out.println(checkBox.isDisplayed());
		System.out.println(checkBox.isSelected());
		checkBox.click();
		System.out.println("After click");
		System.out.println(checkBox.isSelected());*/
		
		/*driver.get("https://demoapp.skillrary.com/");
		WebElement disabledTextBox = driver.findElement(By.xpath("//p[contains(text(),'Get free updates')]/..//input"));
		System.out.println(disabledTextBox.isEnabled());*/
		
		driver.get("https://www.instagram.com/accounts/login/");
		Thread.sleep(2000);
		boolean flag = driver.findElement(By.xpath("//div[text()='Log in']/..")).isEnabled();
		System.out.println(flag);
		driver.findElement(By.name("username")).sendKeys("Sumanth");
		flag = driver.findElement(By.xpath("//div[text()='Log in']/..")).isEnabled();
		System.out.println(flag);
		driver.findElement(By.name("password")).sendKeys("Testing@123");
		System.out.println("After entering both Username and Password");
		flag = driver.findElement(By.xpath("//div[text()='Log in']/..")).isEnabled();
		System.out.println(flag);
	}

}
