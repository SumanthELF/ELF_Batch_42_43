package workingWithTextNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleScript { //TC_Accounts_001      TestNG class

	
	/*@Test(invocationCount=0)
	public void register() { //createAccount        Test Case
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
																			//Test Steps
		driver.get("https://vtu.ac.in/");
		driver.quit();
	}*/	
	@Test(timeOut=3000)
	public void createAccount() { 
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.irctctourism.com/");
		driver.quit();
	}	
	@Test
	public void modifyAccount() { 
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://ksrtc.in/oprs-web/");
		driver.quit();
	}	
	@Test(priority=1)
	public void deleteAccount() { 
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.upsc.gov.in/");
		driver.quit();
	}
}
