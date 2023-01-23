package webDriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToSetSizeAndPositionOfTheBrowserWindow {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.udemy.com/");
		Thread.sleep(3000);
		Point positonOfTheBrowser = new Point(0, 0);
		driver.manage().window().setPosition(positonOfTheBrowser);
		Thread.sleep(2000);
		Dimension sizeOfTheBrowser = new Dimension(800, 800);
		driver.manage().window().setSize(sizeOfTheBrowser);
		
		driver.manage().window().fullscreen();
	}

}
