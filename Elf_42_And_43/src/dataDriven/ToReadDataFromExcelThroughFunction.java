package dataDriven;

import genericLibrary.ReadData;

public class ToReadDataFromExcelThroughFunction {

	public static void main(String[] args) {
		
		System.out.println(ReadData.fromExcel("Test", 8, 6));
		System.out.println(ReadData.ldtFromExcel("Test", 8, 2));
	}

}
