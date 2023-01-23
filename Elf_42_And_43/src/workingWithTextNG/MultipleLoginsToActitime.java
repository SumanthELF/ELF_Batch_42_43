package workingWithTextNG;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleLoginsToActitime {

	@DataProvider
	public String[][] getCredentials() throws Exception {
		/*String [][] sarr = {
								{"admin","manager"},
								{"trainee","trainee"}
							};
		return sarr;*/
		FileInputStream fis = new FileInputStream(new File("./testData/testData.xlsx"));
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet dataSheet = workbook.getSheet("Cred");
		int rowCount = dataSheet.getPhysicalNumberOfRows()-1;
		int colCount = dataSheet.getRow(1).getPhysicalNumberOfCells()-1;
		
		String[][] testData = new String[rowCount][colCount];
		for(int i=0; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				testData[i][j] = dataSheet.getRow(i+1).getCell(j+1).toString();
			}
		}
		return testData;
		
		
	}
	
	@Test(dataProvider="getCredentials")
	public void launchApplication(String[] credentials) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys(credentials[0]);
		driver.findElement(By.name("pwd")).sendKeys(credentials[1]);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
