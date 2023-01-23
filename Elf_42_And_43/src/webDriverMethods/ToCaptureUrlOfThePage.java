package webDriverMethods;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToCaptureUrlOfThePage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.samsung.com/");
		String urlOfThePage = driver.getCurrentUrl();
		System.out.println(urlOfThePage);
	}

}
