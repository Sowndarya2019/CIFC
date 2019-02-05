package InvokeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class Driver {

		private WebDriver driver= null;
		String current_dir = "";
		
		
		private void setDriver(String browser , String appurl)
		{ 
			current_dir = System.getProperty("user.dir");
			System.out.println(current_dir);
			
			switch (browser) {
			case "chrome":
				driver = driverChrome(appurl);
				break;
			case "firefox":
				driver = driverFirefox(appurl);
				break;
			default:
				System.out.println("browser : " + browser
						+ " is invalid, Launching chrome as browser of choice..");
				driver = driverChrome(appurl);
			} 
			
		}
		
		public WebDriver driverChrome(String appurl ) {
			
			System.setProperty("webdriver.chrome.driver",current_dir + "\\src\\main\\java\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.get(appurl);
	        driver.manage().window().maximize();
			return driver; 
			
		}
		
		public WebDriver driverFirefox(String appurl) {
			
			System.setProperty("webdriver.gecko.driver",current_dir + "\\src\\main\\java\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.get(appurl);
	        driver.manage().window().maximize();
			return driver; 
			
		}
		
		
		public WebDriver getdriver() {
			return driver;
		}
		
		
		@Parameters({ "browser", "appurl" })
		@BeforeClass
		public void initializeTestBaseSetup(@Optional("firefox")String browser , @Optional("http://www.google.com")String appurl) {
			
			//Log.startLog("Test is starting!");
			try {
				
				setDriver(browser,appurl);

			} catch (Exception e) {
				System.out.println("Error....." + e.getStackTrace());
			}
		}
		
		@AfterClass
		public void tearDown()  {
			//Log.endLog("Test is ending!");
			driver.quit();
		}

	
}
