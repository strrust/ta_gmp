package com.gmp.reportportal.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class DashboardsTableSteps {
    @Autowired
    private ScenarioContext scenarioContext;

    @When("I load dashboards")
    public void iLoadDashboards() {
        scenarioContext.dashboardsTable.loadDashboardsTable();
    }

    @When("I open demo dashboard")
    public void iOpenDemoDashboard() {
        // TODO
    }

    @Then("Dashboard is opened")
    public void dashboardIsOpened() {
        // TODO
    }

    @Then("Dashboard contains widgets")
    public void dashboardContainsWidgets() {
        // TODO
    }
}
