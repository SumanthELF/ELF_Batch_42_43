package elementActionMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToCheckTheAllignmentOfWebElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		
		WebElement emailTextField = driver.findElement(By.id("email"));
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@id='pass']/.."));
		
		Rectangle passwordRectangleObj = passwordTextField.getRect();
		Point emailTextFieldLocation = emailTextField.getLocation();
		Point passwordTextFieldLocation = passwordTextField.getLocation();
		Dimension emailTextFieldSize = emailTextField.getSize();
		Dimension passwordTextFieldSize = passwordTextField.getSize();
		
		int xLocationOfEmailTextField = emailTextFieldLocation.getX();
		int xLocationOfPasswordTextField = passwordTextFieldLocation.getX();
		int xLocationPlusWidthOfEmailTextField = emailTextFieldSize.getWidth()+xLocationOfEmailTextField;
		int xLocationPlusWidthOfPasswordTextField = passwordTextFieldSize.getWidth()+xLocationOfPasswordTextField;
		
		System.out.println("xLocationOfEmailTextField: "+xLocationOfEmailTextField);
		System.out.println("xLocationOfPasswordTextField: "+xLocationOfPasswordTextField);
		System.out.println("widthOfEmailTextField: "+emailTextFieldSize.getWidth());
		System.out.println("widthOfPasswordTextField: "+passwordTextFieldSize.getWidth());
		
		//Left allignment Check
		if(xLocationOfEmailTextField==xLocationOfPasswordTextField) 
			System.out.println("Email text field and Password text field are properly alligned towards left");
		else 
			System.out.println("Email text field and Password text field are not inLine towards left");
		
		//Right allignment Check
		if(xLocationPlusWidthOfEmailTextField==xLocationPlusWidthOfPasswordTextField)
			System.out.println("Email text field and Password text field are properly alligned towards right");
		else 
			System.out.println("Email text field and Password text field are not inLine towards right");
		
		
	}

}
