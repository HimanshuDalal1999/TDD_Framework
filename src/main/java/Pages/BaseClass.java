package Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;import org.apache.poi.hpsf.TypedPropertyValue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass
{
	public WebDriver driver;
	public WebDriver initializeBrowser(String Browser)
	{
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (Browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
	
//	driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}

}
