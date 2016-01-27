package reusableFunctions;

import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SetCapability {
	WebDriver driver;
	
public static DesiredCapabilities SetCapabilitiesIos() { 
		
		//Setting the desired capabilities
			DesiredCapabilities capabilities = new DesiredCapabilities(); 
			
			capabilities.setCapability("platformName", ReadFile.readPropFile("platformName"));
			capabilities.setCapability("version", ReadFile.readPropFile("version"));
      capabilities.setCapability("deviceName",ReadFile.readPropFile("deviceName"));
      capabilities.setCapability("browserName", ReadFile.readPropFile("browserName"));
      capabilities.setCapability("udid", ReadFile.readPropFile("udid"));
      capabilities.setCapability("app", ReadFile.readPropFile("app"));
    
      return capabilities;
		  
	}  

public static DesiredCapabilities SetCapabilitiesAndroid() { 
	
	//Setting the desired capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities(); 
		//capabilities.setCapability("platformName", ReadFile.readPropFile("android_platformName"));
		//capabilities.setCapability("version", ReadFile.readPropFile("android_version"));
    capabilities.setCapability("deviceName",ReadFile.readPropFile("android_deviceName"));
    capabilities.setCapability("browserName", ReadFile.readPropFile("browserName"));
    //capabilities.setCapability("appPackage", ReadFile.readPropFile("android_appPackage"));
    //capabilities.setCapability("appActivity", ReadFile.readPropFile("android_appActivity"));
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"ANDROID");
	    capabilities.setCapability(MobileCapabilityType.PLATFORM, "ANDROID");
	    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "BROWSER");
    return capabilities;
	  
}  

}
