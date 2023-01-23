package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusHomePage {

	public BusHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "One way")
	private WebElement oneWayLink;

	@FindBy(linkText = "Round trip")
	private WebElement roundTripLink;

	@FindBy(linkText = "Packages")
	private WebElement packagesLink;

	@FindBy(id = "src")
	private WebElement fromTextField;

	@FindBy(id = "dest")
	private WebElement toTextField;

	@FindBy(id = "departure")
	private WebElement departureField;

	@FindBy(id = "return")
	private WebElement returnField;
	
	@FindBy(xpath = "//input[@value='Search Buses' and contains(@class,'journey')]")
	private WebElement searchBusesButton;
	
	@FindBy(xpath = "//li[.='Bangalore']") 
	private WebElement bangaloreSearchSuggestion;
	
	@FindBy(xpath = "//li[.='Goa']") 
	private WebElement goaSearchSuggestion;
	
	@FindBy(xpath = "//li[.='Chennai']") 
	private WebElement chennaiSearchSuggestion;
	
	@FindBy(xpath = "//li[.='Hyderabad']") 
	private WebElement hyderabadSearchSuggestion;
	
	public WebElement getOneWayLink() {
		return oneWayLink;
	}

	public WebElement getRoundTripLink() {
		return roundTripLink;
	}

	public WebElement getPackagesLink() {
		return packagesLink;
	}

	public WebElement getFromTextField() {
		return fromTextField;
	}

	public WebElement getToTextField() {
		return toTextField;
	}

	public WebElement getDepartureField() {
		return departureField;
	}

	public WebElement getReturnField() {
		return returnField;
	}

	public WebElement getSearchBusesButton() {
		return searchBusesButton;
	}

	public WebElement getBangaloreSearchSuggestion() {
		return bangaloreSearchSuggestion;
	}

	public WebElement getGoaSearchSuggestion() {
		return goaSearchSuggestion;
	}

	public WebElement getChennaiSearchSuggestion() {
		return chennaiSearchSuggestion;
	}

	public WebElement getHyderabadSearchSuggestion() {
		return hyderabadSearchSuggestion;
	}
	
	
}
