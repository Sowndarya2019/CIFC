

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import InvokeDriver.Driver;
import pages.Goolesearch;



public class Test_search_java extends Driver{
	
	private WebDriver driver;
	Goolesearch google = null;
	
	
	@BeforeClass
	public void setup()
	{
		driver= getdriver();
         
	}
	
	
	@Test
	public void firstPageJava() 
	{
		google = new Goolesearch(driver);
		google.setSearchData("java");
		google.clickSearch();
		
		
	}
	
	@Test
	public void validatePageJava() throws InterruptedException {
		google.validateSearch("Download Free Java Software");
		google.clickSelenium();
		
	}

}
