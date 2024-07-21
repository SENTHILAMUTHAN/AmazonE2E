package org.runner;



import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src\\test\\resources\\amazone2e.feature",
    glue = {"org.step"},
    plugin = {"pretty", 
    		"html:target/cucumber-reports",
            
            "json:target/cucumber-report.json",
            "junit:target/cucumber-results.xml"},
    monochrome = true
)
public class Amazone2eRunner {
}
