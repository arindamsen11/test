package Test_Ios_POC;

/******Script Name: OrangeHRMS_JobTitle
 * Purpose: Demo of Mobile test Automation
 * Script Description: This script launches the OrangeHRM web application in Chrome browser of an
 *         Android device. It then logs in and then navigates to the Job Titles option
 *         and lists down all the job titles.
 * Author: Anupam Jha
 */

//package stepDefs;

import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import objectRepository.Orange_HRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import reporting.ExtentManager;
import reusableFunctions.ReadFile;
import reusableFunctions.SetCapability;
import reusableFunctions.Setup;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test2_OrangeHRMS_Login {

 //********Variable declaration********
 private WebDriver driver;
 private ExtentReports extent = ExtentManager.getInstance();
 private ExtentTest test;
 //DesiredCapabilities dcapabilities;
 Orange_HRM objHomePage;


 //********Setting the desired capabilities for Android device********
 

 @Given("^The user is on the home page \"(.*?)\"$")
 public void the_user_is_on_the_home_page(String url) throws Throwable {
  boolean bIsPresent=false;
  try{
  	test = extent.startTest("Orange HRM");
		test.log(LogStatus.INFO, "<b>Given: The user is on the home page</b>");
   //********Launching the Chrome browser in the device********
  	driver = Setup.fnLaunch(driver);
   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   driver.get(url);
   //********Page Sync********
   WebDriverWait wdWait= new WebDriverWait(driver, 30);
   bIsPresent=wdWait.until(ExpectedConditions.titleIs("OrangeHRM"));
   if(bIsPresent){
    System.out.println("The home page is rendered");
    test.log(LogStatus.PASS, "User is able to access the Homepage");
   }
   else{
    System.out.println("The home page is not rendered");
    test.log(LogStatus.PASS, "User is not able to access the Homepage");
   }
  }
  catch(Exception e)
  {
   test.log(LogStatus.FAIL, "User is not able to access the Homepage");
   System.out.println(e.toString());
  }
 }

 @When("^The user logs in with the credentials\"(.*?)\",\"(.*?)\"$")
 public void the_user_logs_in_with_the_credentials(String username, String password) throws Throwable {
 //@When("^The user logs in with the credentials$")
 //public void the_user_logs_in_with_the_credentials() throws Throwable {
  try{
   test.log(LogStatus.INFO, "<b>When : The user logs in with the credentials</b>");
   objHomePage= new Orange_HRM(driver);
   //********Entering the login credentials********
   objHomePage.inputUserName.sendKeys(username);
   objHomePage.inputPassword.sendKeys(password);
   Thread.sleep(5000);
   objHomePage.btnLogin.submit();
   WebDriverWait wdWait= new WebDriverWait(driver, 30);
   wdWait.until(ExpectedConditions.visibilityOf(objHomePage.lnkWelcome));
   System.out.println("User is able to login");
   test.log(LogStatus.PASS, "User is able to login");
  } 
  catch(Exception e)
  {
   test.log(LogStatus.FAIL, "User is not able to login");
   System.out.println(e.toString());
  }
 }

 @When("^The Job Titles link is clicked$")
 public void the_Job_Titles_link_is_clicked() throws Throwable {
  //WebElement jobs;
  try{
   test.log(LogStatus.INFO, "<b>When : The Job Titles link is clicked</b>");
   Thread.sleep(10000);
   WebElement lnkAdmin= driver.findElement(By.linkText("Admin"));
  
   //********Clicking the Job titles options********
   lnkAdmin.click();
  // objHomePage.lnkJobTitles.click();
   System.out.println("The click event is successful");
   test.log(LogStatus.PASS, "The click event is successful");
  }
  catch(Exception e)
  {
   test.log(LogStatus.FAIL, "The click event is not successful");
   System.out.println(e.toString());
  }
 }

 @Then("^The list of the Job Titles is displayed$")
 public void the_list_of_the_JOb_Titles_is_displayed() throws Throwable {
  boolean bIsPresent=false;
  int i=1;
  try{
   test.log(LogStatus.INFO, "<b>Then : The list of the Job Titles is displayed</b>");
   WebDriverWait wdWait= new WebDriverWait(driver, 30);
   wdWait.until(ExpectedConditions.visibilityOfAllElements(objHomePage.lstJobTitles));
   //********Listing all the Job titles displayed********
   if(objHomePage.lstJobTitles.size()>0){
    bIsPresent=true;
    for(WebElement jobs:objHomePage.lstJobTitles){
     System.out.println("Job "+i+" is "+jobs.getText());
     test.log(LogStatus.INFO, "Job "+i+" is <b>"+jobs.getText()+"</b>");
     i++;
    }
   }
   if(bIsPresent){
    System.out.println("The Job list is captured");
    test.log(LogStatus.PASS, "The Job list is captured");
   }
   else{
    System.out.println("The Job list is not captured");
    test.log(LogStatus.FAIL, "The Job list is not captured");
   }
  }
  catch(Exception e)
  {
   test.log(LogStatus.FAIL, "The Job list is not captured");
   System.out.println(e.toString());
  }
  extent.endTest(test);
  extent.flush(); 
  driver.quit();

 }



}

