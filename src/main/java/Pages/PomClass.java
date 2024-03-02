package Pages;

import java.beans.Visibility;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.AllArguments;

public class PomClass extends BaseClass
{						 //5
	WebDriver driver;
	JavascriptExecutor JS;
	
	@FindBy(xpath = "//div[@class='brand greenLogo']") private WebElement logo;
	@FindBy(xpath = "//input[@class='search-keyword']") private WebElement product;
	@FindBy(xpath = "//h4[text()='Tomato - 1 Kg']") private WebElement Tproduct;
	@FindBy(xpath = "//h4[text()='Cucumber - 1 Kg']") private WebElement Cproduct;
	@FindBy(xpath = "//img[@alt='Cart']") private WebElement Cartbutton;
	@FindBy(xpath = "//input[@class='quantity']") private WebElement Nquantity;
	@FindBy(xpath = "//button[text()='ADD TO CART']") private WebElement AddtocartNquantity;
	@FindBy(xpath = "//p[@class='quantity']") private WebElement quantityText;
	@FindBy(xpath = "(//div[@class='product'])[24]") private WebElement strawberry;
	@FindBy(xpath = "(//input[@class='quantity'])[24]") private WebElement strawberryQuantity;
	@FindBy(xpath = "(//button[text()='ADD TO CART'])[24]") private WebElement SBAddtocart;
	@FindBy(xpath = "//button[text()='PROCEED TO CHECKOUT']") private WebElement checkoutButton;
	@FindBy(xpath = "//button[text()='Place Order']") private WebElement placeOrderbutton;
	@FindBy(xpath = "//select[@style='width: 200px;']") private WebElement listBox;
	@FindBy(xpath = "//input[@type='checkbox']") private WebElement checkbox;
	@FindBy(xpath = "//button[text()='Proceed']") private WebElement proceedButton;
	@FindBy(xpath = "//h2[text()='You cart is empty!']") private WebElement cartText;
	@FindBy(xpath = "//a[text()='Top Deals']") private WebElement topDeals;
	@FindBy(xpath = "//span[@class='fa fa-angle-double-left']") private WebElement First;
	//-------------------------------Rahul Shetty New Application-------------------------------
	@FindBy(xpath = "//a[text()='Practice']") private WebElement PracticeButton;
	@FindBy(id = "name") private WebElement EnterName;
	@FindBy(id = "email") private WebElement EnterEmail;
	@FindBy(id = "agreeTerms") private WebElement SelectCheckbox;
	@FindBy(id = "form-submit") private WebElement Submit;
	@FindBy(xpath = "//a[text()='Automation Practise - 2']") private WebElement Practice2;
	@FindBy(xpath = "//img[@class='logoClass']") private WebElement BrandLogo;
	
//	@FindBy(xpath = "") private WebElement aa;
	
/////////////////////////////////////////	
													  //1
	public PomClass(WebDriver driver)
	{			 //4  		//3
		this.driver = driver;
													//2
		PageFactory.initElements(driver, this);
		 JS = (JavascriptExecutor) driver;
	}
/////////////////////////////////////////
	//******************1thTestCase**********************************
	public String checkLogo()
	{
		String Logo = logo.getText();
		return Logo;
	}
	//******************2thTestCase**********************************
	public void enterProduct(String Product)
	{
		product.sendKeys(Product);
	}
	public String getProductText()
	{
		String ProductText = Tproduct.getText();
		return ProductText;
	}
	//******************3thTestCase************************************
	public void entersecondProduct(String Product2)
	{
		product.clear();
		product.sendKeys(Product2);
	}
	public String getProduct2Text()
	{
		String Product2Text = Cproduct.getText();
		return Product2Text;
	}
	//*******************4thTestCase*************************************
	
	//*******************5thTestCase*************************************
	public void enterthirdProduct(String Product3)
	{
		product.clear();
		product.sendKeys(Product3);
	}
	public void enterQuantity(String Quantity) throws InterruptedException
	{
		Thread.sleep(3000);
		Nquantity.clear();
		Nquantity.sendKeys(Quantity);
		AddtocartNquantity.click();
		Cartbutton.click();
	}
	public String getQuantityText()
	{
		String Text = quantityText.getText();
		return Text;
	}
	//*************************6thTestCase**********************************
	public void enterfourthproduct(String Quantity) throws InterruptedException
	{
		Thread.sleep(2000);
//	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", strawberry);
		JS.executeScript("arguments[0].scrollIntoView(true)", strawberry);
		
		strawberryQuantity.clear();
		strawberryQuantity.sendKeys(Quantity);
		SBAddtocart.click();
		Cartbutton.click();
		checkoutButton.click();
		placeOrderbutton.click();
		
		Select S = new Select(listBox);
		S.selectByVisibleText("India");
		checkbox.click();
		proceedButton.click();
	}
	public String getCartText()
	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(Cartbutton));
		Cartbutton.click();
		String Text = cartText.getText();
		return Text;
	}
	//***************************7thTestCase**************************************
	public void enterTopDeals()
	{
		topDeals.click();
	}
	public boolean verifyElement()
	{
		Set<String> AllWindowId = driver.getWindowHandles();
		ArrayList<String> AL = new ArrayList<String>(AllWindowId);
		driver.switchTo().window(AL.get(1));
		boolean Enable = First.isEnabled();
		return Enable;
	}
	//***************************8thTestCase**************************************
	public void EnterPractice(String Name, String Email)
	{
		PracticeButton.click();
		EnterName.sendKeys(Name);
		EnterEmail.sendKeys(Email);
		SelectCheckbox.click();
		Submit.click();
		Practice2.click();
	}
	public boolean VerifyLogo()
	{
		 boolean Logo = BrandLogo.isDisplayed();
		 return Logo;
	}
	
	
	
	
	
	
	
	public boolean clickCart()
	{
		boolean Button = Cartbutton.isEnabled();
		return Button;	
	}
	
}
