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
}