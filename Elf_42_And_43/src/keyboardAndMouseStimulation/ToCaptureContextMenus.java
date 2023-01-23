package keyboardAndMouseStimulation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToCaptureContextMenus {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);
		
		driver.get("https://trello.com/login");
		driver.findElement(By.id("user")).sendKeys("sumanthkeshav.scl@gmail.com");
		driver.findElement(By.id("login")).click();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));
		driver.findElement(By.name("password")).sendKeys("Testing@123");
		driver.findElement(By.id("login-submit")).click();
		driver.findElement(By.xpath("//div[@title='ELF_42_43']")).click();
		WebElement mockCompletedCard = driver.findElement(By.xpath("//span[text()='Mock Completed']"));
		Actions actions = new Actions(driver);
		actions.contextClick(mockCompletedCard).perform();
		List<WebElement> contextMenu = driver.findElements(By.xpath("//a[contains(@class,'quick-card-editor')]"));
		for(WebElement menu : contextMenu) {
			System.out.println(menu.getText());
		}
	}

}
