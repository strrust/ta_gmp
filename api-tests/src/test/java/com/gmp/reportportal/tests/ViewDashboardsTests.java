package com.gmp.reportportal.tests;

import com.gmp.reportportal.api.dashboards.dto.response.Dashboard;
import org.junit.jupiter.api.Test;

import static com.gmp.reportportal.domain.dashboards.DashboardsTable.DASHBOARD_DEMO_NAME;
import static org.assertj.core.api.Assertions.assertThat;

public class ViewDashboardsTests extends AbstractTestContextTests {

    @Test
    public void viewDashboards() {
        dashboardsTable.loadDashboardsTable();

        assertThat(dashboardsTable.pickContent())
                .describedAs("At least one dashboard should be presented")
                .isNotEmpty();
        assertThat(dashboardsTable.pickContent())
                .describedAs("Dashboards table should contain demo dashboard")
                .extracting(Dashboard::getName)
                .contains(DASHBOARD_DEMO_NAME);
    }
}
