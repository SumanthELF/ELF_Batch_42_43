package popups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToHandleAlertPopup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);

		//Login
		driver.get("https://www.firelawn.com/");
		driver.findElement(By.id("fl_login_btn")).click();
		driver.findElement(By.id("fl_email")).sendKeys("abcd@testyantra.com");
		driver.findElement(By.id("fl_password")).sendKeys("nopassword");
		driver.findElement(By.id("fl_login")).click();
		Thread.sleep(7000);
		
		//Click on Account Settings and then click on My Profile
		driver.findElement(By.xpath("//button[@aria-label='Account settings']")).click();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='My Profile']")));
		driver.findElement(By.xpath("//li[text()='My Profile']")).click();
		explicitWait.until(ExpectedConditions.titleContains("Firelawn | Profile"));
		driver.navigate().refresh();
		
		//Click on Edit Profile
		driver.findElement(By.xpath("//button[contains(text(),'Edit Profile')]")).click();
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.id("lastName")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.id("lastName")).sendKeys("ELF Batch");
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(1000);
		Alert alertObjRef = driver.switchTo().alert();
		System.out.println(alertObjRef.getText());
		Thread.sleep(1000);
		alertObjRef.dismiss();
	}

}
