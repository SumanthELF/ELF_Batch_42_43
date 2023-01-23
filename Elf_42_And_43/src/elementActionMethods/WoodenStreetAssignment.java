package elementActionMethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WoodenStreetAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.woodenstreet.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Study Tables")).click();
		Thread.sleep(2000);
		String costOfSecondProduct = driver
				.findElement(By.xpath("(//div[contains(@id,'article')])[2]//strong[contains(text(),'Rs')]")).getText();
		costOfSecondProduct = costOfSecondProduct.replace(",", "");
		costOfSecondProduct = costOfSecondProduct.replace("Rs", "");
		costOfSecondProduct = costOfSecondProduct.trim();
		int cost = Integer.parseInt(costOfSecondProduct);
		System.out.println("Cost of the product : "+cost);
		Thread.sleep(2000);
		if (cost > 10000)
			System.out.println("The product cost is too hight");
		else {
			driver.findElement(By.xpath("(//div[contains(@id,'article')])[2]//a[contains(@href,'https') and @target]"))
					.click();
			Thread.sleep(2000);
			String parentWindowId = driver.getWindowHandle();
			Set<String> allWindowIds = driver.getWindowHandles();
			allWindowIds.remove(parentWindowId);
			for (String windowId : allWindowIds) {
				driver.switchTo().window(windowId);
			}
			Thread.sleep(2000);
			driver.findElement(By.id("button-cart-buy-now")).click();
		}
		Thread.sleep(2000);
		driver.quit();

	}

}
