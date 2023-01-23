package keyboardAndMouseStimulation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToPerformControlClickAction {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);
		
		driver.get("https://www.kalkifashion.com/");
		Actions actions = new Actions(driver);
		List<WebElement> navElements = driver.
				findElements(By.xpath("//nav[not(@id='mobile-nav')]//div[@id='desktop-nav']//a[contains(@class,'menu')]"));
		for(WebElement menu : navElements) {
			actions.keyDown(Keys.CONTROL).click(menu).perform();
		}
		actions.keyUp(Keys.CONTROL);
	}

}
