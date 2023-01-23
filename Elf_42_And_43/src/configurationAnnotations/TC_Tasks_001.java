package configurationAnnotations;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_Tasks_001 extends BaseTest {

	@Test
	public void addNewTask() {
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		driver.findElement(By.xpath("//div[text()='+ New Tasks']")).click();
		driver.findElement(By.id("closeCreateTasksPopupButton")).click();
	}
}
