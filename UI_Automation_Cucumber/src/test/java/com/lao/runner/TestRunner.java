package com.lao.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		 features = "src/test/resources/FeatureFiles", 
		 glue = "com.lao.step_definitions", 
         dryRun = false, 
         monochrome = true,
		 tags = "@employeeCRUD", 
         plugin =  {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/report/webreport.html","json:target/report/jsonreport.json","rerun:target/failed_test_scenario.txt"} 
		 )

public class TestRunner {

}
