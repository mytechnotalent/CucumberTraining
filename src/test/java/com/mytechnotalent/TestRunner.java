package com.mytechnotalent;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Login.feature",
        glue = "com.mytechnotalent.StepDefs",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        }
)

public class TestRunner extends AbstractTestNGCucumberTests {
}