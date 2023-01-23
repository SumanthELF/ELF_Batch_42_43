package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this); // Rule 1
	}

	@FindBy(partialLinkText = "Bus")
	private WebElement busNavBarIcon; // Rule 2

	public WebElement getBusNavBarIcon() {
		return busNavBarIcon;
	}

}
