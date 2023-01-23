package bus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import elementRepository.BasePage;
import elementRepository.BusHomePage;

public class SearchBuses {

	@Test
	public void searchBusForThreeDifferentFromAndToLocations() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://in.via.com/");
		BasePage basePage = new BasePage(driver);
		basePage.getBusNavBarIcon().click();
		BusHomePage busHomePage = new BusHomePage(driver);
		busHomePage.getFromTextField().sendKeys("Bangalore");
		busHomePage.getBangaloreSearchSuggestion().click();
		busHomePage.getToTextField().sendKeys("Goa");
		busHomePage.getGoaSearchSuggestion().click();
		busHomePage.getDepartureField().click();
		driver.findElement(By.xpath("//span[.='Jan 2023']/../..//div[text()='26']")).click();
		busHomePage.getSearchBusesButton().click();
		
		Thread.sleep(3000);
		driver.navigate().back();
		busHomePage.getFromTextField().clear();
		busHomePage.getFromTextField().sendKeys("Chennai");
		busHomePage.getChennaiSearchSuggestion().click();
		busHomePage.getToTextField().clear();
		busHomePage.getToTextField().sendKeys("Hyderabad");
		busHomePage.getHyderabadSearchSuggestion().click();
		busHomePage.getDepartureField().click();
		driver.findElement(By.xpath("//span[.='Jan 2023']/../..//div[text()='28']")).click();
		busHomePage.getSearchBusesButton().click();
	}
}
