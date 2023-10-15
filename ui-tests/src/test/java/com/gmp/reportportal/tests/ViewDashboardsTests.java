package com.gmp.reportportal.tests;

import org.testng.annotations.Test;

public class ViewDashboardsTests extends AbstractTestContextTests {

    @Test
    public void viewDashboardsTable() {
        loginSteps.login();
        dashboardsSteps.dashboardsTableShouldBeLoaded();
    }
}
