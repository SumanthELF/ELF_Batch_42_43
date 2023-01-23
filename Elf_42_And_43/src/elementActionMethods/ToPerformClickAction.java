package elementActionMethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToPerformClickAction {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.suzukimotorcycle.co.in/product-details/hayabusa");
		driver.findElement(By.xpath("//a[contains(text(),'Book Online')]")).click();
		Set<String> allWindowIds = driver.getWindowHandles();
		String expectedTitle = "Booknow Suzuki";
		for(String windowId : allWindowIds) {
			driver.switchTo().window(windowId);
			if(driver.getTitle().equals(expectedTitle)) {
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href,'sitemap')]")).click();
	}

}
