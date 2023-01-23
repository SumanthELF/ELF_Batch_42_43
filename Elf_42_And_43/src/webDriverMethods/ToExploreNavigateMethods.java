package webDriverMethods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToExploreNavigateMethods {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("https://www.udemy.com/");
		System.out.println("Hi");
		Thread.sleep(1000);
		driver.get("https://www.coursera.org/");
		Thread.sleep(1000);
		
		Navigation navigate = driver.navigate();
		navigate.back();
		Thread.sleep(1000);
		navigate.forward();
		Thread.sleep(1000);
		navigate.refresh();
		URL url = new URL("https://www.edureka.co/");
		navigate.to(url);
	}

}
