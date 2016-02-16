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
								//"json:src/test/resources/Jenkins/cucumber.json"
/								"json:target_junit/cucumber.json"
								//"json:/testproject/src/test/resources/Jenkins/cucumber.json"
								}
		)



public class CucumberDriver {

}
