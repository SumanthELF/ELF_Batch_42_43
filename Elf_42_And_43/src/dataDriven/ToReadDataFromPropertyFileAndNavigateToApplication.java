package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToReadDataFromPropertyFileAndNavigateToApplication {

	public static void main(String[] args) throws IOException {
		
		//Step 1 : Creating Input stream type object
		File absPath = new File("./testData/SampleScriptData.properties");
		FileInputStream fis = new FileInputStream(absPath);
		
		//Step 2 : Creating object of File type
		Properties properties = new Properties();
		properties.load(fis);
		
		//Step 3 : Read methods
		String key = properties.get("ChromeBrowserKey").toString();
		String value = properties.get("ChromeDriverPath").toString();
		String url = properties.get("url").toString();
		
		System.setProperty(key, value);
		WebDriver driver = new ChromeDriver();
		driver.get(url);
	}

}
