package workingWithTextNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Demod {

	@Test
	public void read(String [] arr) {
		
		for(String s : arr) {
			System.out.println(s);
		}
		System.out.println();
	}

}
