package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility_Class_Matin 
{

	public static String TestData(int rowindex, int cellindex) throws EncryptedDocumentException, IOException 
	{
		
		String Path = System.getProperty("user.dir")+"\\TestData\\Data.xlsx";
		FileInputStream fis =new FileInputStream(Path);
		String value = WorkbookFactory.create(fis).getSheet("Sheet1").getRow(rowindex).getCell(cellindex).getStringCellValue();
		return value;
	}
		
		
	  public static String property_file(String key) throws IOException 
	  {
		  Properties prop = new Properties();
		  String path = System.getProperty("user.dir")+"\\src\\PropertyFile\\prop.properties";
		  FileInputStream file = new FileInputStream(path);
		  prop.load(file);
		  String value = prop.getProperty(key);
		  return value; 
	  }
	  
	  
	  


}
