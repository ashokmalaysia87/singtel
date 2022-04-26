package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features"},glue = {"Stepdefinitions"},
plugin = { "pretty", "junit:target/cucumber-reports.xml" },monochrome = true)
public class TestRunner {

	
	
}
