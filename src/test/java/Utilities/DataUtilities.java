package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Base.BaseTest;

public class DataUtilities {
	
	public String readPageURL(String key) throws IOException
	{
		BaseTest.prop = new Properties();
		FileInputStream fis = new FileInputStream(AppConstants.PROPERTIES_FILE_PATH);
		BaseTest.prop.load(fis);
		return BaseTest.prop.getProperty(key);
	}
	
	public String[] readCredentials() throws IOException
	{
		FileInputStream fis = new FileInputStream(AppConstants.CREDENTIALS_FILE_PATH);
		XSSFWorkbook xWorkBook = new XSSFWorkbook(fis);
		XSSFSheet xSheet = xWorkBook.getSheet("Credentials");
		String[] sCred = new String[2];
		sCred[0]=xSheet.getRow(1).getCell(1).getStringCellValue();
		sCred[1]=xSheet.getRow(1).getCell(2).getStringCellValue();
		return sCred;
	}

}
