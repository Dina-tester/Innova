package TestRunner.in;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources\\Features" },glue = {
		"Steps.in" }, monochrome = true, dryRun = false,
		plugin = { "pretty","html:target\\ht.html" ,"json:target\\report.json"})//tags = {"@task-2"}

public class Testrunner {

}