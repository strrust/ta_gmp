package com.gmp.reportportal.tests;

import com.gmp.reportportal.api.dashboards.dto.response.Dashboard;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ViewDashboardsTests extends AbstractTestContextTests {
    private static final String DASHBOARD_DEMO_NAME = "DEMO DASHBOARD";

    @Test
    public void viewDashboards() {
        dashboardsTable.loadDashboardsTable();

        assertThat(dashboardsTable.pickContent())
                .describedAs("Only one dashboard should be presented")
                .hasSize(1);
        assertThat(dashboardsTable.pickContent())
                .describedAs("Dashboard name should be '%s'", DASHBOARD_DEMO_NAME)
                .extracting(Dashboard::getName)
                .containsExactly(DASHBOARD_DEMO_NAME);
    }
}
