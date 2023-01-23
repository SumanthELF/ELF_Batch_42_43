package dropdowns;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ToHandleMultiSelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("file:///C:/Users/user/Desktop/dropDown.html");
		WebElement multiSelectDropDown = driver.findElement(By.id("m1"));
		Select multiSelect = new Select(multiSelectDropDown);
		System.out.println("Is the drop down multi select : "+multiSelect.isMultiple());
		List<WebElement> allOptions = multiSelect.getOptions();
		for(WebElement ele : allOptions) {
			System.out.print(ele.getText()+", ");
		}
		System.out.println();
		
		multiSelect.selectByIndex(1);
		multiSelect.selectByValue("4");
		
		System.out.println("Selected Options");
		List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
		for(WebElement ele : selectedOptions) {
			System.out.println(ele.getText());
		}
		Thread.sleep(2000);
		
//		multiSelect.deselectByVisibleText("Mango");
//		multiSelect.deselectByIndex(3);
		multiSelect.deselectAll();
		
		multiSelect.selectByVisibleText("Grapes");
		multiSelect.selectByValue("1");
		
		WebElement firstSelectedOption = multiSelect.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	}

}
