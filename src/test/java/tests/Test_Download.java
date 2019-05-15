package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import InvokeDriver.Driver;
import pages.CIFCDownload;



public class Test_Download extends Driver{
	
	private WebDriver driver;
	CIFCDownload cifcObject = null;
	
	
	@DataProvider(name = "clicktabs")

    public Object[][] clickData() {
             return new Object[][] {
            	 { "Repricing pipeline", "https://www.lcdcomps.com/lcd/download/10013/Repricing%20Pipeline%20-%20WEB.xlsx?rid=910&method=downloadResearchFile" }, 
            	 { "Default List", "https://www.lcdcomps.com/lcd/download/3491/Defaults%20List%20-%20WEB.xlsx?rid=910&method=downloadResearchFile" },
            	// { "Bond for Loan Take-Out", "https://www.lcdcomps.com/lcd/download/4417/Bond%20for%20Loan%20-%20WEB.xlsx?rid=910&method=downloadResearchFile"},
            	// {"Amendment Pipeline", "https://www.lcdcomps.com/lcd/download/10015/Amendment%20Pipeline%20-%20WEB%20CD.xlsx?rid=910&method=downloadResearchFile"},
            	// {"Watch List","https://www.lcdcomps.com/lcd/download/10451/LCD%20restructuring%20watch%20list%202019.xls?rid=1,001&method=downloadResearchFile"},
            	// {"Repayment","https://www.lcdcomps.com/lcd/download/10002/Investor%20Technicals%20-%20WEB%20LP-US.xlsx?rid=917&method=downloadResearchFile"},
   
            	 };
             
    }
	
	@BeforeClass
	public void setup()
	{
		driver= getdriver();
		cifcObject = new CIFCDownload(driver);
         
	}
	

	
	  @Test(dataProvider= "clicktabs") 
	  public void testSearchOnGoogle(String download, String url ) throws InterruptedException {
		  
		  cifcObject.get_URL(url);
		  cifcObject.loginToApplication("hlau@cifc.com", "Welcome1234");
		
	  }
	
	

}
