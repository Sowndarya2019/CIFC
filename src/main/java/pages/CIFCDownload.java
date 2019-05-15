package pages;



import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Command;


import InvokeDriver.CommonUtils;
import InvokeDriver.Log;

public class CIFCDownload {
	
	private WebDriver driver;
	By locInputEmail = By.cssSelector("#username01");
	By locInputPassword = By.cssSelector("#password01");
	By locLoginButton = By.cssSelector(".button-text");
	
	
	CommonUtils com = null;
	

	public CIFCDownload(WebDriver driver)
	{
		this.driver = driver;
		com = new CommonUtils(driver);	
		
	}
	
	
	public void get_URL(String url) {
		com.moveToPage(url);
	}
	
	public void loginToApplication(String userName, String password){
		Log.info("login with valid credentials");
		com.enterText(locInputEmail, userName);
		com.enterText(locInputPassword, password);
		com.click(locLoginButton);
	}
	
	
}
