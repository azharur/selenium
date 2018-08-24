package cucumberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.runtime.RuntimeOptions;
import org.junit.runner.RunWith;

import java.util.Formatter;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",glue = "stepImplementation")

public class LoginTestRunner {



}