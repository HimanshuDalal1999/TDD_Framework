package Validation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.PomClass;
import Pages.UtilityClass;

public class TestClass extends BaseClass
{

	UtilityClass UC;
	PomClass PC;
	@BeforeClass
	public void openBrowser()
	{
		initializeBrowser("chrome");
		PC = new PomClass(driver);
	}
//================================================	
	@Test(priority = 1)
	public void verifyLogoText() throws EncryptedDocumentException, IOException
	{
		String CL = PC.checkLogo();
		Assert.assertEquals(CL, UC.ExcelSheet(0, 0));
	}
//-----------------------------------------------------------------------------------------------
	@Test(priority = 2)
	public void verifyProduct() throws InterruptedException, EncryptedDocumentException, IOException
	{
		driver.navigate().refresh();
		PC.enterProduct(UC.ExcelSheet(1, 0));
		Thread.sleep(5000);
		String Product = PC.getProductText();
		Assert.assertEquals(Product, UC.ExcelSheet(1, 1));
	}
//-----------------------------------------------------------------------------------------------
	@Test(priority = 3)
	public void verifyProduct2() throws EncryptedDocumentException, IOException
	{
		driver.navigate().refresh();
		PC.entersecondProduct(UC.ExcelSheet(2, 0));
		String Product2 = PC.getProduct2Text();
		Assert.assertEquals(Product2, (UC.ExcelSheet(2, 1)));
	}
//-----------------------------------------------------------------------------------------------
	@Test(priority = 4)
	public void verifyCartButton()
	{
		driver.navigate().refresh();
		boolean CartButton = PC.clickCart();
		Assert.assertTrue(CartButton);
	}
//-----------------------------------------------------------------------------------------------
	@Test(priority = 5)
	public void verifyProductAddtoCart() throws EncryptedDocumentException, IOException, InterruptedException
	{
		driver.navigate().refresh();
		PC.enterthirdProduct(UC.ExcelSheet(4, 0));
		PC.enterQuantity(UC.ExcelSheet(4, 1));
		String Qtext = PC.getQuantityText();
		Assert.assertEquals(Qtext, (UC.ExcelSheet(4, 2)));
	}
//-----------------------------------------------------------------------------------------------
	@Test(priority = 6)
	public void verifyOrderFunctionality() throws InterruptedException, EncryptedDocumentException, IOException
	{
		driver.navigate().refresh();
		PC.enterfourthproduct(UC.ExcelSheet(5, 0));
		String TextofCart = PC.getCartText();
		Assert.assertEquals(TextofCart, (UC.ExcelSheet(5, 1)));
	}
//------------------------------------------------------------------------------------------------
	@Test(priority = 7)
	public void VerifyFirstButton() throws EncryptedDocumentException, IOException
	{
		PC.enterTopDeals();
		boolean Element = PC.verifyElement();
		Assert.assertTrue(Element);
	}
//-----------------------------------------------------------------------------------------------------
	@Test(priority = 8)
	public void VerifyRSLogin() throws EncryptedDocumentException, IOException
	{
		driver.navigate().refresh();
		driver.navigate().to("https://www.rahulshettyacademy.com/");
		PC.EnterPractice(UC.ExcelSheet(7, 0), UC.ExcelSheet(7, 1));
		boolean Logo = PC.VerifyLogo();
		Assert.assertTrue(Logo);
	}
	
	
	
//===================================================	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	
	
}
