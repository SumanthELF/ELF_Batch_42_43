package elementActionMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCaptureAttributeOfParticularElements {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//to capture value from textfield
		/*driver.get("https://yonobusiness.sbi/login/yonobusinesslogin");
		WebElement usernameTextField = driver.findElement(By.id("userName"));
		usernameTextField.sendKeys("Sumanth");
		Thread.sleep(2000);
		String attrValue = usernameTextField.getAttribute("value");
		System.out.println(attrValue);*/
		
		//to capture tool tip text
		/*driver.get("https://demo.actitime.com/login.do");
		String toolTip = driver.findElement(By.id("keepMeLoggedInCaptionContainer")).getAttribute("title");
		System.out.println(toolTip);*/
		
		//to capture alternate text for images
		driver.get("https://www.woodenstreet.com/");
		String alternateText = driver.
					findElement(By.xpath("//img[@title='Wooden Sofas Online Furniture']")).
					getAttribute("alt");
		System.out.println(alternateText);
	}

}
