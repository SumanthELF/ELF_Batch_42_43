package popups;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToHandleCalendarInTrivago {

	public static void main(String[] args) throws InterruptedException {
		LocalDateTime systemDate = LocalDateTime.now();
		int year = systemDate.getYear();
		int day = systemDate.getDayOfMonth();
		int month = systemDate.getMonthValue();
		LocalDateTime returnDate = systemDate.plusDays(5);
		int returnYear = returnDate.getDayOfYear();
		int returnMonth = returnDate.getMonthValue();
		int returnDay = returnDate.getDayOfMonth();
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebDriverWait explicitWait = new WebDriverWait(driver, 15);

		driver.get("https://www.trivago.in/");
		driver.findElement(By.xpath("//button[@data-testid='calendar-checkin']")).click();
		driver.findElement(By.xpath("//button[@data-testid='calendar-button-prev']")).click();
		for(;;) {
			try {
				driver.findElement(By.xpath("//time[@datetime='"+year+"-"+month+"-"+day+"']")).click();
				driver.findElement(By.xpath("//time[@datetime='"+returnYear+"-"+returnMonth+"-"+returnDay+"']")).click();
				break;
			}catch(NoSuchElementException e) {
				driver.findElement(By.xpath("//button[@data-testid='calendar-button-next']")).click();
			}
		}
	}

}
