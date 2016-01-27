package objectRepository;


	
	import java.util.List;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class Orange_HRM {

	 @FindBy(id="txtUsername")
	 public WebElement inputUserName;
	 
	 @FindBy(id="txtPassword")
	 public WebElement inputPassword;
	 
	 @FindBy(id="btnLogin")
	 public WebElement btnLogin;
	 
	 /*@FindBy(xpath="//div[@id='divLoginButton']/input[@type='submit']")
	 public WebElement btnLogin;*/
	 
	 @FindBy(xpath="//div[@id='branding']//a[text()='Welcome Admin']")
	 public WebElement lnkWelcome;
	 
	 @FindBy(linkText="Job Titles")
	 public WebElement lnkJobTitles;
	 
	 @FindBy(linkText="Job")
	 public WebElement lnkJob;
	 

	 
	 @FindBy(xpath="//table[@id='resultTable']//td/a")
	 public List<WebElement> lstJobTitles;
	 
	 
	 public Orange_HRM(WebDriver driver){

	  PageFactory.initElements(driver, this);

	 }
	 
	}


