package com.gmp.reportportal.configuration;

import com.gmp.reportportal.domain.dashboards.DashboardsTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.apache.commons.lang3.StringUtils.EMPTY;

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

    @Before("@filter")
    public void createAdditionalDesignBeforeFiltering() {
        dashboardsTable.createDashboard("ta-db-1", EMPTY);
    }

    @After("@filter")
    public void removeAdditionalDesignAfterFiltering() {
        dashboardsTable.loadDashboardsTable();
        dashboardsTable.removeDashboard("ta-db-1");
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
