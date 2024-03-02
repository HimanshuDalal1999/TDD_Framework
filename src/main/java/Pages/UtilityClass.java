package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilityClass 
{
	public static String ExcelSheet(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException
	{
		String ExcelPath = System.getProperty("user.dir")+"\\Test-Data\\Book1.xlsx";
		FileInputStream ExcelFile = new FileInputStream(ExcelPath);
		String ExcelValue = WorkbookFactory.create(ExcelFile).getSheet("Sheet1").getRow(RowIndex).getCell(CellIndex).getStringCellValue();
		return ExcelValue;
		
	}
	
	public static String PropertyData(String Value) throws IOException
	{
		Properties Prop = new Properties();
		String PropertyPath = System.getProperty("user.dir")+"\\Test-Data\\Property.properties";
		FileInputStream PropertyFile = new FileInputStream(PropertyPath);
		Prop.load(PropertyFile);
		String PropertyKey = Prop.getProperty(Value);
		return PropertyKey;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public String ExcelSheet(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException
//	{
//		String Excelpath = System.getProperty("user.dir")+"\\Test-Data\\Book1.xlsx";
//		FileInputStream file = new FileInputStream(Excelpath);
//		String Excelvalue = WorkbookFactory.create(file).getSheet("Sheet1").getRow(RowIndex).getCell(CellIndex).getStringCellValue();
//		return Excelvalue;
//	}
//	public String PropertyFile(String Key) throws IOException
//	{
//		Properties P = new Properties();
//		String Path = System.getProperty("user.dir")+"\\Test-Data\\Property.properties";
//		FileInputStream File = new FileInputStream(Path);
//		P.load(File);
//		String PropertyValue = P.getProperty(Key);
//		return PropertyValue;
//	}
	
	
	
	
	
	
	

	
	
}
