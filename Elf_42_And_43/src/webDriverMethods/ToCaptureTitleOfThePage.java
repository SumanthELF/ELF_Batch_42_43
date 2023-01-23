package webDriverMethods;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToCaptureTitleOfThePage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://online.kfc.co.in/");
		Thread.sleep(2000);
		String titleOfThePage = driver.getTitle();
		System.out.println(titleOfThePage);
		
	}

}
