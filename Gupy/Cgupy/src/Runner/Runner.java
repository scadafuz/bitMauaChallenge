package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;



import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features= "features",
	    glue = {"Step"},plugin = { "pretty", "html:target/cucumber-reports" },
	    monochrome = true)

public class Runner {

	
	
	
}
