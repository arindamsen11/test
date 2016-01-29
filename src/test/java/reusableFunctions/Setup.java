package reusableFunctions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import reusableFunctions.ReadFile;

public class Setup {
	
	public static WebDriver fnLaunch(WebDriver driver/*, String sBrowser, DesiredCapabilities capabilities*/) throws MalformedURLException
	{
		//WebDriver driver = null;
		String sPlatformName = ReadFile.readPropFile("platformName");
		//String currentWindowHandle ;//= this.webDriver.getWindowHandle();
		
		/* Setting up the Browsers */
		if(sPlatformName.equals("Chrome"))
		{
		  //File fileChrome=new File("src\\test\\resources\\Drivers\\chromedriver.exe"); 
      //File fBrwsr = new File("src/test/resources/Drivers/chromedriver"); 
	  File fBrwsr = new File("src\\test\\resources\\Drivers\\chromedriver.exe");
      System.setProperty("webdriver.chrome.driver", fBrwsr.getAbsolutePath()); 
      driver = new ChromeDriver( );//DesiredCapabilities.chrome());
      //driver=new ChromeDriver(); 
      driver.manage().timeouts().implicitlyWait( 50,TimeUnit.SECONDS);
		}
		else if(sPlatformName.equals("Safari"))
		{
			driver=new SafariDriver();//DesiredCapabilities.safari()); 
			driver.manage().window().maximize(); 
      driver.manage().timeouts().implicitlyWait( 50,TimeUnit.SECONDS);
		}
		else if(sPlatformName.equals("Mozilla"))
		{
			driver=new FirefoxDriver();//(DesiredCapabilities.firefox()); 
			driver.manage().window().maximize(); 
      driver.manage().timeouts().implicitlyWait( 50,TimeUnit.SECONDS);
		}
		else if(sPlatformName.equals("IE"))
		{
			driver=new InternetExplorerDriver(DesiredCapabilities.internetExplorer());
			driver.manage().window().maximize(); 
      driver.manage().timeouts().implicitlyWait( 50,TimeUnit.SECONDS);
		}
		
		
		/* Setting up the platform name */
		else if(sPlatformName.equals("ios")){
			DesiredCapabilities capabilities = SetCapability.SetCapabilitiesIos();
			driver = new IOSDriver( new URL( "http://127.0.0.1:4723/wd/hub" ), capabilities );
			driver.manage().timeouts().implicitlyWait( 50,TimeUnit.SECONDS);
		}
		else if(sPlatformName.equals("Android")){
			DesiredCapabilities capabilities = SetCapability.SetCapabilitiesAndroid();
			driver = new AndroidDriver( new URL( "http://127.0.0.1:4723/wd/hub" ), capabilities );
			driver.manage().timeouts().implicitlyWait( 50,TimeUnit.SECONDS);
		}
		
		//poc for windows 
		else if(sPlatformName.equals("Windows")){
			DesiredCapabilities capabilities = SetCapability.SetCapabilitiesAndroid();
			driver = new RemoteWebDriver( new URL( "http://127.0.0.1:4723/wd/hub" ), capabilities );
			driver.manage().timeouts().implicitlyWait( 50,TimeUnit.SECONDS);
		}
		
		return driver;
	}

}
