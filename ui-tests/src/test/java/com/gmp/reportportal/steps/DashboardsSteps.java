package com.gmp.reportportal.steps;

import com.gmp.reportportal.pages.DashboardsPage;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardsSteps {
    @Autowired
    public DashboardsPage dashboardsPage;

    @Step("Dashboards page should be loaded")
    public void dashboardsTableShouldBeLoaded() {
        dashboardsPage.shouldBeLoaded();
    }

    @Step("I filter designs by {text}")
    public void filterDesigns(String text) {
        dashboardsPage.filterDesigns(text);
    }

    @Step("Dashboard with name should be presented in filter results")
    public void dashboardWithNameShouldBeInFilterResults(String dashboardName) {
        dashboardsPage.dashboardShouldBePresented(dashboardName);
    }
}
