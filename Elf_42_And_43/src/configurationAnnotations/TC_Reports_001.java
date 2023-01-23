package configurationAnnotations;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_Reports_001 extends BaseTest {

	@Test
	public void addNewTask() {
		driver.findElement(By.id("container_reports")).click();
		driver.findElement(By.xpath("//div[.='New Report' and contains(@class,'createNewReportButton')]")).click();
		driver.findElement(By.xpath("//div[text()='Choose Report to Create']/..//div[contains(@class,'closeButton')]")).click();
	}
}
