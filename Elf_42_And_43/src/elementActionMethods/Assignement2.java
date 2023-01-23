package elementActionMethods;

import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignement2 {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the product number : ");
		int product = sc.nextInt();
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
				
		//Step 1: Open Wooden Street
		driver.get("https://www.woodenstreet.com/");
		Thread.sleep(1000);
		
		//Step 2: Select Study table
		driver.findElement(By.linkText("Study Tables")).click();
		Thread.sleep(1000);
		
		//Step 3: Fetch the cost of 2nd Prod
		String costOfProduct = driver.
				findElement(By.xpath("(//div[contains(@id,'article')])["+product+"]//strong[contains(text(),'Rs')]")).getText();
		System.out.println("Cost of the Prodcut : "+ costOfProduct);
		costOfProduct=costOfProduct.replace("Rs", "");
		costOfProduct=costOfProduct.replace(",", "");
		costOfProduct=costOfProduct.trim();
		
		//Step 4 & 5: Check cost is greater than 10000 if not display error message
		int cost = Integer.parseInt(costOfProduct);
		if(cost>10000) {
			System.out.println("The cost is tooo high !!");
		}else {
			driver.findElement(By.xpath("(//div[contains(@id,'article')])["+product+"]//a")).click();
			String parentWindowId = driver.getWindowHandle();
			Set<String> allWindowIds = driver.getWindowHandles();
			allWindowIds.remove(parentWindowId);
			for(String windowId : allWindowIds) {
				driver.switchTo().window(windowId);
			}
			driver.findElement(By.id("button-cart-buy-now")).click();
		}
//		driver.quit();
	}

}
