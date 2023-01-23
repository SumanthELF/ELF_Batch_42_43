package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ToReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		//Step 1 : Creating Input stream type object
		File absPath = new File("./testData/testData.xlsx");
		FileInputStream fis = new FileInputStream(absPath);
		
		//Step 2 : Creating object of File type
		Workbook workbook = new XSSFWorkbook(fis);
		
		//Step 3 : Read methods
		String value = workbook.getSheet("Test").getRow(8).getCell(6).getStringCellValue();
		System.out.println(workbook.getSheet("Test").getRow(8).getCell(7).getStringCellValue());
		System.out.println(value);
		
		LocalDateTime date = workbook.getSheet("Test").getRow(8).getCell(2).getLocalDateTimeCellValue();
		System.out.println(date.getMonth().name());
		System.out.println(date.getYear());
		System.out.println(date.getDayOfMonth());
	}

}
