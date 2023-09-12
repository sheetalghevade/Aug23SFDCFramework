package utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.FileConstants;

public class trialUtil {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		XSSFWorkbook loginWorkBook = new XSSFWorkbook(new File(FileConstants.LOGIN_TESTDATA_FILE_PATH));
		XSSFSheet loginCreds = loginWorkBook.getSheet("UserCredentials");
		

		System.out.println(FileConstants.LOGIN_TESTDATA_FILE_PATH);
		
		for(int row=1; row<=loginCreds.getLastRowNum();row++) {
			XSSFRow second = loginCreds.getRow(row);
			for(int col=1;col<second.getLastCellNum();col++) {
				System.out.println(second.getCell(col));
				
			}
		}

	}
		
	
}
