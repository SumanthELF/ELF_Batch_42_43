package elementActionMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipKartAssignment {

	public static ChromeDriver driver;
	public static int countOfMobilesAdded=0;
	public static Map<String, Integer> productDetails = new TreeMap<>();
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		Thread.sleep(2000);
		
		searchAndAddProductToCart("REDMI");
		searchAndAddProductToCart("iPhone");
		searchAndAddProductToCart("POCO");
		removeLowestProductFromCart();
	}
	
	public static void searchAndAddProductToCart(String productName) throws InterruptedException {
		countOfMobilesAdded++;
		driver.findElement(By.name("q")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys(productName,Keys.ENTER);
		Thread.sleep(2000);
		
		String costOfTheProduct = driver.findElement(By.xpath("//a[contains(.,'realme')]//div[contains(text(),'₹') and not(contains(text(),'EMI'))][1]")).getText();
		costOfTheProduct = costOfTheProduct.replace("₹", "").replace(",", "");
		productDetails.put(productName, Integer.parseInt(costOfTheProduct));
		driver.findElement(By.xpath("//a[contains(.,'"+productName+"')]")).click();
		String parentWindowId = driver.getWindowHandle();
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parentWindowId);
		for(String windowId : allWindowIds) {
			driver.switchTo().window(windowId);
		}
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(parentWindowId);
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys(Keys.CONTROL+"a");
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys(Keys.DELETE);
	}
	
	public static void removeLowestProductFromCart() throws InterruptedException {
		driver.findElement(By.xpath("//a[.='Cart']")).click();
		Thread.sleep(2000);
		int lowestCost=0;
		List<Integer> costIndex = new ArrayList<>();
		Set<Integer> costSort = new TreeSet<>();
		for(int i=1;i<=countOfMobilesAdded;i++) {
			String costOfMobile = driver.findElement(By.xpath("(//span[contains(text(),'₹')][2])["+i+"]")).getText(); ////span[contains(text(),'₹')]/..//span[contains(text(),'₹')][2]
			costOfMobile=costOfMobile.trim();
			costOfMobile=costOfMobile.replace("₹", "");
			costOfMobile=costOfMobile.trim();
			costOfMobile=costOfMobile.replace(",", "");
			costOfMobile=costOfMobile.trim();
			int mobilePrice = Integer.parseInt(costOfMobile);
			costIndex.add(mobilePrice);
			costSort.add(mobilePrice);			
		}
		for(Integer cost1 : costSort) {
			lowestCost = cost1;
			break;
		}
		System.out.println("The Lowest cost : "+lowestCost);
		int indexOfProductToBeRemoved = costIndex.indexOf(lowestCost);
		indexOfProductToBeRemoved+=1;
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[text()='Remove'])["+indexOfProductToBeRemoved+"]")).click();
	}
}








//driver.findElement(By.xpath("//div[contains(text(),'"+productName+"')]/../../..")).click();
//driver.findElement(By.xpath("//body/div/div/div[3]/div[1]/div[2]/div[2]//a")).click();


//Thread.sleep(1000);
//driver.findElement(By.xpath("//form[@action='/search']/div/button")).click();