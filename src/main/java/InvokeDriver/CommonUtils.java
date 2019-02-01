package InvokeDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.testng.TestException;




public class CommonUtils {
	
	 public WebDriver driver;
	    public WebDriverWait wait;
	    public Actions actions;


	    public CommonUtils(WebDriver driver) {
	    	this.driver = driver;
	    }

	    
	    public String getPageTitle() {
	        try {
	        
	            System.out.print(String.format("The title of the page is: %s\n\n", driver.getTitle()));
	            return driver.getTitle();
	        } catch (Exception e) {
	            throw new TestException(String.format("Current page title is: %s", driver.getTitle()));
	        }
	    }
	    
	    public String getText(By selector) {
	    	WebElement element = getElement(selector);
	        try {
	            System.out.print(String.format("The title of the page is: %s\n\n", element.getText()));
	            return element.getText();
	        } catch (Exception e) {
	            throw new TestException(String.format("Current page title is: %s", element.getText()));
	        }
	    }

	    public WebElement getElement(By selector) {
	        try {
	            return driver.findElement(selector);
	        } catch (Exception e) {
	            System.out.println(String.format("Element %s does not exist - proceeding", selector));
	        }
	        return null;
	    }


	    public void enterText(By selector, String value) {
	        WebElement element = getElement(selector);
	        try {
	            element.sendKeys(value);
	        } catch (Exception e) {
	            throw new TestException(String.format("Error in sending [%s] to the following element: [%s]", value, selector.toString()));
	        }
	    }


	    public void enterkey(By selector) {
	        WebElement element = getElement(selector);
	        try {
	            element.sendKeys(Keys.ENTER);
	        } catch (Exception e) {
	            throw new TestException(String.format("Error in the following element: [%s]",  selector.toString()));
	        }
	    }
	 
	    public void click(By selector) {
	        WebElement element = getElement(selector);
	        try {
	            element.click();
	        } catch (Exception e) {
	            throw new TestException(String.format("The following element is not clickable: [%s]", selector));
	        }
	

}
}
