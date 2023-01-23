package elementActionMethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KalkiFashionSVG {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.kalkifashion.com/");
		driver.findElement(By.linkText("LEHENGAS")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='customer-menu']/*[name()='svg']")).click();
	}
}
