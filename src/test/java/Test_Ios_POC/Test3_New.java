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


public class Test3_New 
{
	WebDriver driver,driver1;
	//Instantiating the page
	NewToursPage objNewToursPage;
	private ExtentReports extent = ExtentManager.getInstance();
	private ExtentTest test;
	
	@Given("^Launch Url and Sign in$")
	public void launch_Url_and_Sign_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		try
		{
			test = extent.startTest("New Tours Site");
			test.log(LogStatus.INFO, "<b>Given: Launch Url and Sign in</b>");
			driver = Setup.fnLaunch(driver);
			
			objNewToursPage = new NewToursPage(driver);
			
			Thread.sleep(5000);
			
			//Navigate to the url
			driver.get(ReadFile.readPropFile("Site_1"));
			//driver.manage().window().maximize(); 
			Thread.sleep(30000);
			
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
			
			
			//Login
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
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Then("^Select Flight Details and Continue$")
	public void select_Flight_Details_and_Continue() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		try {
			Thread.sleep(5000);
			if(objNewToursPage.btnContinue.isDisplayed())
			{
				objNewToursPage.btnContinue.click();
				System.out.println("The Flight details were filled and clicked on continue button");
				test.log(LogStatus.PASS, "The Flight details were filled and clicked on continue button");
			}
			else
			{
				System.out.println("The click on continue button is unsuccessful");
				test.log(LogStatus.FAIL, "The click on continue button is unsuccessful");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^Select Flights and Continue$")
	public void select_Flights_and_Continue() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		//Select outbound flight
		try {
			Thread.sleep(5000);
			if(objNewToursPage.radioFlightOutbound.isDisplayed())
			{
				objNewToursPage.radioFlightOutbound.click();
				System.out.println("The outbound fight is selected");
				test.log(LogStatus.PASS, "The outbound fight is selected");
			}
			else
			{
				System.out.println("The outbound fight is not selected");
				test.log(LogStatus.FAIL, "The outbound fight is not selected");
			}
			//select inbound flight
			if(objNewToursPage.radioFlightInbound.isDisplayed())
			{
				objNewToursPage.radioFlightInbound.click();
				System.out.println("The inbound fight is selected");
				test.log(LogStatus.PASS, "The inbound fight is selected");
			}
			else
			{
				System.out.println("The inbound fight is not selected");
				test.log(LogStatus.FAIL, "The inbound fight is not selected");
			}
			//Click Continue
			if(objNewToursPage.btnSelFlightContinue.isDisplayed())
			{
				objNewToursPage.btnSelFlightContinue.click();
				System.out.println("The Countinue is clicked after selecting the flights");
				test.log(LogStatus.PASS, "The Countinue is clicked after selecting the flights");
			}
			else
			{
				System.out.println("The Countinue is not clicked after selecting the flights");
				test.log(LogStatus.FAIL, "The Countinue is not clicked after selecting the flights");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^Fill passenger details and book flight$")
	public void fill_passenger_details_and_book_flight() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		//Fill First name Details
		try {
			if(objNewToursPage.txtboxFirstname.isDisplayed())
			{
				objNewToursPage.txtboxFirstname.sendKeys("Test Name");
				System.out.println("The First name: Test Name is filled in the first name box");
				test.log(LogStatus.PASS, "The First name: Test Name is filled in the first name box");
			}
			else
			{
				System.out.println("The First name: Test Name is not filled in the first name box");
				test.log(LogStatus.FAIL, "The First name: Test Name is not filled in the first name box");
			}
			//Fill Last name details
			if(objNewToursPage.txtboxLastname.isDisplayed())
			{
				objNewToursPage.txtboxLastname.sendKeys("Test SurName");
				System.out.println("The Last name: Test SurName is filled in the last name box");
				test.log(LogStatus.PASS, "The Last name: Test SurName is filled in the last name box");
			}
			else
			{
				System.out.println("The Last name: Test SurName is not filled in the last name box");
				test.log(LogStatus.FAIL, "The Last name: Test SurName is not filled in the last name box");
			}
			//Fill credit card details
			if(objNewToursPage.txtboxCreditCardNumber.isDisplayed())
			{
				objNewToursPage.txtboxCreditCardNumber.sendKeys("1234567890123");
				System.out.println("The Credit card number: 1234567890123 is filled in the last name box");
				test.log(LogStatus.PASS, "The Credit card number: 1234567890123 is filled in the last name box");
			}
			else
			{
				System.out.println("The Credit card number is not filled in the last name box");
				test.log(LogStatus.FAIL, "The Credit card number is not filled in the last name box");
			}
			//click on button purchase
			Thread.sleep(5000);
			if(objNewToursPage.btnSecurePurchase.isDisplayed())
			{
				objNewToursPage.btnSecurePurchase.submit();
				System.out.println("The Secure Purchase button is clicked");
				test.log(LogStatus.PASS, "The Secure Purchase button is clicked");
			}
			else
			{
				System.out.println("The Secure Purchase button is not clicked");
				test.log(LogStatus.FAIL, "The Secure Purchase button is not clicked");
			}
			
			Thread.sleep(5000);
			
			if(objNewToursPage.labelFlightBookConfrmation.isDisplayed())
			{
				System.out.println("The flight booking is confirmed");
				test.log(LogStatus.PASS, "The flight booking is confirmed");
			}
			else
			{
				System.out.println("The flight booking is not confirmed");
				test.log(LogStatus.FAIL, "The flight booking is not confirmed");
			}
			if(objNewToursPage.btnSignOut.isDisplayed())
			{
				objNewToursPage.btnSignOut.click();
				System.out.println("The Sign out button is present and click");
				test.log(LogStatus.PASS, "The Sign out button is present and clicked");
			}
			else
			{
				System.out.println("The Sign out button is not present");
				test.log(LogStatus.FAIL, "The Sign out button is not present");
			}
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Stop reporting and driver
		driver.quit();
		extent.endTest(test);
		extent.flush();
	}

	

}
