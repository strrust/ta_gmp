package com.gmp.reportportal.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.gmp.reportportal.testdataproviders.DashboardsFilterTestData.DASHBOARD_DEMO_NAME;

public class DashboardsFilterTests extends AbstractTestContextTests {

    @BeforeMethod
    public void login() {
        loginSteps.login();
    }

    @Test(dataProvider = "Dashboards filter criteria", dataProviderClass = com.gmp.reportportal.testdataproviders.DashboardsFilterTestData.class)
    public void filterDashboards(String filterText) {
        dashboardsSteps.filterDesigns(filterText);
        dashboardsSteps.dashboardWithNameShouldBeInFilterResults(DASHBOARD_DEMO_NAME);
    }
}
