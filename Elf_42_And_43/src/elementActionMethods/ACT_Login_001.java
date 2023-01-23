package elementActionMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/***
 * 
 * @author Sumanth
 *
 */
public class ACT_Login_001 {
	
	public static void main(String[] args) throws InterruptedException {
		//Expected Data
		String expectedLoginPageTitle = "actiTIME - Login";
		String expectedHomePageTitle = "actiTIME -  Enter Time-Track";
		String usernameData = "admin";
		String passwordData = "manager";
		
		//Step 1: Open the browser and enter the test Url
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Empty Chrome browser is launched");
		driver.manage().window().maximize();
		System.out.println("Browser window is maximized");
		driver.get("https://demo.actitime.com/login.do");
		String actualLoginPageTitle = driver.getTitle();
		if(expectedLoginPageTitle.equals(actualLoginPageTitle)) {
			System.out.println("Login Page is displayed");
		}else {
			System.err.println("Login Page is not displayed");
		}
		
		//Step 2: Enter valid credentials into Username text field and Password text field
		WebElement usernameTextField = driver.findElement(By.id("username"));
		usernameTextField.clear();
		usernameTextField.sendKeys(usernameData);
		String actualUsernameEntered = usernameTextField.getAttribute("value");
		if(usernameData.equals(actualUsernameEntered)) {
			System.out.println("Sucessfully entered username into Username Text field");
		}else {
			System.err.println("Username is not entered sucessfully");
		}
		
		WebElement passwordTextField = driver.findElement(By.name("pwd"));
		passwordTextField.clear();
		passwordTextField.sendKeys(passwordData);
		String actualPasswordEntered = passwordTextField.getAttribute("value");
		if(passwordData.equals(actualPasswordEntered)) {
			System.out.println("Sucessfully entered password into Password Text field");
		}else {
			System.err.println("Password is not entered sucessfully");
		}
		
		//Step 3: Click on Login Button
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(3000);
		String actualHomePageTitle = driver.getTitle();
		if(expectedHomePageTitle.equals(actualHomePageTitle)) {
			System.out.println("Home Page is displayed");
		}else {
			System.err.println("Home Page is not displayed");
		}
		
	}

}
