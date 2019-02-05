package tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import InvokeDriver.Driver;
import pages.Goolesearch;



public class Test_search_selenium extends Driver{
	
	//
	
	private WebDriver driver;
	Goolesearch google = null;
	
	//public static Logger log = Logger.getLogger(Test_search_selenium.class);
	
	@BeforeClass
	public void setup()
	{
		driver= getdriver();
		
	}
	
	@Test
	public void firstPageSelenium()
	{
		google = new Goolesearch(driver);
		google.setSearchData("selenium");
		google.clickSearch();
		
	}
	
	@Test
	public void validatePageSelenium() throws InterruptedException {
		//log.info("validating the search results");
		google.validateSearch("Selenium - Web Browser Automation");
		google.clickSelenium();
		
	}

}
