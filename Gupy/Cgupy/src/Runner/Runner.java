package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features= "features",
	    glue = {"Step"},plugin = { "pretty", "html:target/cucumber-reports" },
	    monochrome = true)
/**
 * Runner do Projeto.
 * 
 * @author Bruno Viana Lopes
 * @version 0.0.1
 */
public class Runner {

	
	
	
}
