package com.gmp.reportportal;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = {"com.gmp.reportportal.steps", "com.gmp.reportportal.configuration"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-report.json"},
        features = "src/test/resources/features"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
