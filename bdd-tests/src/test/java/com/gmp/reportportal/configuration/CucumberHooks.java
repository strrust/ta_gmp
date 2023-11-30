package com.gmp.reportportal.configuration;

import com.gmp.reportportal.domain.dashboards.DashboardsTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@Slf4j
@CucumberContextConfiguration
@ContextConfiguration(classes = {TestContextConfiguration.class})
public class CucumberHooks {
    @Autowired
    private DashboardsTable dashboardsTable;

    private static int failedTests = 0;
    private static int passedTests = 0;
    private static int count = 0;

    @After("@widget")
    public void removeLastCreatedWidget() {
        dashboardsTable.removeLastCreatedWidgetFromDashboard();
    }

    @After
    public void logCountOfTest(Scenario scenario) {
        count++;
        if (scenario.isFailed()) {
            failedTests++;
        } else {
            passedTests++;
        }
        log.info("Tests completed: {}", count);
        log.info("Passed: {}, Failed: {}", passedTests, failedTests);
    }
}
