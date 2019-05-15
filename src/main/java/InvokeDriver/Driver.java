package InvokeDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class Driver {

		private WebDriver driver= null;
		String current_dir = "";
		
		
		private void setDriver( String appurl)
		{ 
			current_dir = System.getProperty("user.dir");
			System.out.println(current_dir);

				driver = driverChrome(appurl);
			
			} 
			
		
		
		public WebDriver driverChrome(String appurl ) {
			
			System.setProperty("webdriver.chrome.driver",current_dir + "\\src\\main\\java\\chromedriver.exe");
			  String downloadFilepath = current_dir + "\\CIFC_downloads";

			  HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

			  chromePrefs.put("profile.default_content_settings.popups", 0);

			  chromePrefs.put("download.default_directory", downloadFilepath);

			  ChromeOptions options = new ChromeOptions();

			  HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();

			  options.setExperimentalOption("prefs", chromePrefs);

			  options.addArguments("--test-type");
			  options.addArguments("--start-maximized");

			  
			driver = new ChromeDriver(options);
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
		public void initializeTestBaseSetup(@Optional("chrome")String browser , @Optional("localHost")String appurl) {
			
			//Log.startLog("Test is starting!");
			try {
				
				setDriver(appurl);

			} catch (Exception e) {
				System.out.println("Error....." + e.getStackTrace());
			}
		}
		
		@AfterClass
		public void tearDown() throws InterruptedException  {
			//Log.endLog("Test is ending!");
			Thread.sleep(50);
			driver.quit();
			
		}

	
}
