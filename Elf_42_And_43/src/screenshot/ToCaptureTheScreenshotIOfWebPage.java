package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ToCaptureTheScreenshotIOfWebPage {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.thrillophilia.com/");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File tempScreenshot = ts.getScreenshotAs(OutputType.FILE);
		File targetScreenshot = new File("./errorshots/snap.png");
		FileHandler.copy(tempScreenshot, targetScreenshot);
//		tempScreenshot.renameTo(targetScreenshot);
//		FileUtils.copyFile(tempScreenshot, targetScreenshot);
//		System.out.println(tempScreenshot);
//		Thread.sleep(15000);
	}

}
