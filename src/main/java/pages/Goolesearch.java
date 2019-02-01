package pages;



import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Command;


import InvokeDriver.CommonUtils;

public class Goolesearch {
	
	private WebDriver driver;
	private By search = By.xpath("//*[@class='gLFyf gsfi']");
	//private By button = By.xpath("//*[@class='hb2Smf']");
	private By First_link = By.xpath("//*[@class ='LC20lb'][1]");
	
	CommonUtils com = null;
	

	public Goolesearch(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	
	public void setSearchData(String str) {
		com = new CommonUtils(driver);	
		
		com.enterText(search,str);
		
	}
			
	public void clickSearch() {
		
		com.enterkey(search);	 
		
	}
	
	public void validateSearch(String actual) {
		String expected =  com.getElement(First_link).getText();
		Assert.assertEquals(actual, expected);
	}
	
	public void clickSelenium() throws InterruptedException {
		com.getElement(First_link).click();
		Thread.sleep(30);
		
	}

}
