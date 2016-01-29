package cucumberController;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
			features={"src/test/resources/Features"},
			tags={"@Test3"},
			glue={"Test_Ios_POC"},
			monochrome= true,
			strict=true,
			plugin = {
								"pretty",
								"html:target/cucmber",
								"junit:target_junit/cucumber.xml",
								"json:C:/Users/arindams621/.jenkins/workspace/JENKINS_CUCUMBER_INTEGRATION/cucumber.json"
								}
		)



public class CucumberDriver {

}
