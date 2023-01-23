package workingWithTextNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RecevieUrlFromXML {

	@Parameters({"url","name","pwd","browserName"})
	@Test
	public void readDataFromXML(
			@Optional("https://demo.actitime.com/") String urlFromXml,
			@Optional("trainee") String username, 
			@Optional("trainee") String password,
			@Optional("chrome") String bName) {
		
		WebDriver driver=null;
		
		if(bName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(bName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			Reporter.log("Please pass a valid browser name",true);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get(urlFromXml);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		
		
	}
}
