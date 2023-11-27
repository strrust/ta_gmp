package com.gmp.reportportal.configuration;

import com.gmp.reportportal.domain.dashboards.DashboardsTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@CucumberContextConfiguration
@ContextConfiguration(classes = {TestContextConfiguration.class})
public class CucumberHooks {
    @Autowired
    private DashboardsTable dashboardsTable;

    @After("@widget")
    public void removeLastCreatedWidget() {
        dashboardsTable.removeLastCreatedWidgetFromDashboard();
    }

    @Before("@filter")
    public void createAdditionalDesignBeforeFiltering() {
        dashboardsTable.createDashboard("Additional dashboard", EMPTY);
    }

    @After("@filter")
    public void removeAdditionalDesignAfterFiltering() {
        dashboardsTable.removeDashboard("Additional dashboard");
    }
}
