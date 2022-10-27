package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/featureFile" }, 
		glue = { "stepDefinaion", "hooks" },
		plugin = {"pretty"}
		

)

public class MyTestRunner {

}
