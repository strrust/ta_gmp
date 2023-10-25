package com.gmp.reportportal.tests;

import com.gmp.reportportal.api.dashboards.dto.response.Dashboard;
import com.gmp.reportportal.domain.dashboards.DashboardsTableSettings;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.gmp.reportportal.domain.dashboards.DashboardsTable.DASHBOARD_DEMO_NAME;
import static org.assertj.core.api.Assertions.assertThat;

public class DashboardsFilterTests extends AbstractTestContextTests {

    @ParameterizedTest
    @MethodSource("com.gmp.reportportal.testdataproviders.DashboardsFilterTestData#dashboardFilterCriteria")
    public void searchDashboards(String criteriaDescription, String searchParameter) {
        DashboardsTableSettings settings = DashboardsTableSettings.builder()
                .filter(searchParameter)
                .build();
        dashboardsTable.filterDesigns(settings);

        assertThat(dashboardsTable.pickContent())
                .describedAs("Dashboard '%s' should be presented after filtering by '%s'", DASHBOARD_DEMO_NAME, criteriaDescription)
                .extracting(Dashboard::getName)
                .containsExactly(DASHBOARD_DEMO_NAME);
    }
}
