package workingWithTextNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataFromDataProvider {

	@DataProvider(parallel=true)
	public String[] getUrl() throws Exception {
		/*String [] sarr = {
							"https://www.cornerhouseicecreams.com/",
							"https://www.ibaco.in/",
							"https://polarbear.co.in/",
							"https://apsaraicecreams.com/flavours/",
							"https://baskinrobbinsindia.com/"
							};
		return sarr;*/
		FileInputStream fis = new FileInputStream(new File("./testData/testData.xlsx"));
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet dataSheet = workbook.getSheet("AppUrl");
		int rowCount = dataSheet.getPhysicalNumberOfRows()-1;
		String[] sarr = new String[rowCount];
		for(int i=0; i<rowCount; i++) {
			sarr[i] = dataSheet.getRow(i+1).getCell(0).toString();
		}
		return sarr;
		
	}
	
	@Test(dataProvider="getUrl")
	public void launchApplication(String url) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(url);
		driver.quit();
	}
}
