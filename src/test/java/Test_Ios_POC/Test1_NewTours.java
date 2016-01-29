package Test_Ios_POC;

import objectRepository.NewToursPage;

//import org.junit.After;
//import org.junit.Before;
import org.openqa.selenium.WebDriver;

import reporting.ExtentManager;
//import com.relevantcodes.extentreports.common.ExtentManager;
//import org.uiautomation.ios.IOSCapabilities;
import reusableFunctions.ReadFile;
import reusableFunctions.Setup;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class Test1_NewTours 
{
	WebDriver driver,driver1;
	//Instantiating the page
	NewToursPage objNewToursPage;
  private ExtentReports extent = ExtentManager.getInstance();
  private ExtentTest test;
	//DesiredCapabilities capabilities;// = SetCapability.SetCap();
	
	/*public void InstantiateDriver(){
		try{
		driver = Setup.fnLaunch(driver1, capabilities);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	 */
	
	//capabilities = SetCapability.SetCap();
	
	/*@Before  
	public void setUp() throws MalformedURLException {  
		
		//Setting the desired capabilities
			DesiredCapabilities capabilities = new DesiredCapabilities(); 
		  /*capabilities.setCapability("platformName", "ios");
      capabilities.setCapability("deviceName","Abhijit's iPhone");
      capabilities.setCapability("device", "iPhone");
      capabilities.setCapability("version", "8.3");
      capabilities.setCapability("udid", "2de8cf8cf2e7f62147668db56bb1718835bf7dd6");
      capabilities.setCapability("app", "Safari");
      capabilities.setCapability(IOSCapabilities.SIMULATOR, false);
      capabilities.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT, "15000");
			*/
			
		/*	capabilities.setCapability("platformName", ReadFile.readPropFile("platformName"));
			capabilities.setCapability("version", ReadFile.readPropFile("version"));
      capabilities.setCapability("deviceName",ReadFile.readPropFile("deviceName"));
      //capabilities.setCapability("device", ReadFile.readPropFile("device"));
      capabilities.setCapability("browserName", ReadFile.readPropFile("browserName"));
      capabilities.setCapability("udid", ReadFile.readPropFile("udid"));
      capabilities.setCapability("app", ReadFile.readPropFile("app"));
      //capabilities.setCapability(IOSCapabilities.SIMULATOR, false);
      //capabilities.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT, "15000");
			
		 //driver = new IOSDriver( new URL( "http://127.0.0.1:4723/wd/hub" ), capabilities );
		  //driver.manage().timeouts().implicitlyWait( 50,TimeUnit.SECONDS); 
      
      driver = Setup.fnLaunch(driver, capabilities);
		  
	}  */
	
	
	//@Given("^Navigate to the url$")
	@Given("^Navigate to the url$")
	//public void navigate_to_the_url throws Throwable {
	public void navigate_to_the_url() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		try
		{
			test = extent.startTest("New Tours Site");
			test.log(LogStatus.INFO, "<b>Given: Navigate to the url</b>");
			driver = Setup.fnLaunch(driver);
			//driver.manage().window().maximize(); 
		//	driver = Setup.fnLaunch(driver, capabilities);
			objNewToursPage = new NewToursPage(driver);
			//navigate to the mercury tour site
			Thread.sleep(5000);
			//driver.get("http://newtours.demoaut.com/");
			driver.get(ReadFile.readPropFile("Site_1"));
			//driver.manage().window().maximize(); 
			Thread.sleep(3000);
			
			if(objNewToursPage.txtbxUserName.isDisplayed())
			{
				System.out.println("The navigation to the desired page is successful");
				test.log(LogStatus.PASS, "The navigation the desired page is successful");
			}
			else
			{
				System.out.println("The navigation to the desired page is not successful");
				test.log(LogStatus.FAIL, "The navigation to the desired page is not successful");
			}
			
			//driver.switchTo().window(driver.getWindowHandle());
		//Store the current window handle
		//	String currentWindowHandle = this.driver.getWindowHandle();

			//run your javascript and alert code
			//((JavascriptExecutor)this.webDriver).executeScript("alert('Test')"); 
			//this.webDriver.switchTo().alert().accept();

			//Switch back to to the window using the handle saved earlier
			//driver.switchTo().window(currentWindowHandle);
			
			
			Thread.sleep(5000);		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Then("^Login and check Sign out link$")
	public void login_and_check_Sign_out_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		try
		{
			test.log(LogStatus.INFO, "<b>Then: Login and check Sign out link</b>");
			//Check if the user name and the password fields are present
			if(objNewToursPage.txtbxUserName.isDisplayed())
			{
				System.out.println("The user name text box is present and displayed");
				test.log(LogStatus.PASS, "The user name text box is present and displayed");
				//objNewToursPage.txtbxUserName.sendKeys("mercury");
				objNewToursPage.txtbxUserName.sendKeys(ReadFile.readPropFile("Site_1_Username"));
				
				if(objNewToursPage.txtbxPassword.isDisplayed())
				{
					System.out.println("The Password text box is present and displayed");
					test.log(LogStatus.PASS, "The Password text box is present and displayed");
					//objNewToursPage.txtbxPassword.sendKeys("mercury");
					objNewToursPage.txtbxPassword.sendKeys(ReadFile.readPropFile("Site_1_Password"));
					
					if(objNewToursPage.btnLogin.isDisplayed())
					{
						System.out.println("The Login button is present and displayed");
						test.log(LogStatus.PASS, "The Login button is present and displayed");
						//objNewToursPage.btnLogin.click();
						objNewToursPage.txtbxPassword.submit();
						Thread.sleep(5000);
						
						//check if login is successful
						String url = driver.getCurrentUrl();
						if(url.contains("http://newtours.demoaut.com/mercuryreservation"))
						{
							System.out.println("The Login is successful");
							test.log(LogStatus.PASS, "The Login is successful");
							Thread.sleep(5000);
							
							if(objNewToursPage.btnSignOut.isDisplayed())
							{
								System.out.println("The Sign out button is present and displayed");
								test.log(LogStatus.PASS, "The Sign out button is present and displayed");
							}
							else
							{
								System.out.println("The Sign out button is not present");
								test.log(LogStatus.FAIL, "The Sign out button is not present");
							}
						}
						else
						{
							System.out.println("The Login is not successful");
							test.log(LogStatus.FAIL, "The Login is not successful");
						}
					}
					else
					{
						System.out.println("The Login button is not present");
						test.log(LogStatus.FAIL, "The Login button is not present");
					}
				}
				else
				{
					System.out.println("The password text box is not present");
					test.log(LogStatus.FAIL, "The password text box is not present");
				}
			}
			else
			{
				System.out.println("The user name text box is not present");
				test.log(LogStatus.FAIL, "The user name text box is not present");
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Then("^Click on Sign out link and validate it is successful$")
	public void click_on_Sign_out_link_and_validate_it_is_successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		try 
		{
			test.log(LogStatus.INFO, "<b>Then: Click on Sign out link and validate it is successful</b>");
			//Click on the Sign out link
			objNewToursPage.btnSignOut.click();
			Thread.sleep(5000);
			
			if(objNewToursPage.txtbxUserName.isDisplayed())
			{
				System.out.println("The Sign out is successful");
				test.log(LogStatus.PASS, "The Sign out is successful");
			}
			else
			{
				System.out.println("The Sign out is not successful");
				test.log(LogStatus.FAIL, "The Sign out is not successful");
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		extent.endTest(test);
		extent.flush();
	}
   
	
	/*@After
	public void tearDown() throws Exception {  
		//driver.close();
		driver.quit(); 
		//driver = null;
		//System.exit(1);
		System.out.println("The driver is closed");
	}*/  
}
