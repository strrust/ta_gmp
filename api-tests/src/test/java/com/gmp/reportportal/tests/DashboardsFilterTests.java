package com.gmp.reportportal.tests;

import com.gmp.reportportal.domain.dashboards.DashboardsTableSettings;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.gmp.reportportal.domain.dashboards.DashboardsTable.DASHBOARD_DEMO_NAME;
import static org.assertj.core.api.Assertions.assertThat;

public class DashboardsFilterTests extends AbstractTestContextTests {

    @ParameterizedTest
    @MethodSource("com.gmp.reportportal.testdataproviders.DashboardsFilterTestData#dashboardFilterCriteria")
    public void filterDashboards(String criteriaDescription, String filterParameter) {
        DashboardsTableSettings settings = DashboardsTableSettings.builder()
                .filter(filterParameter)
                .build();
        dashboardsTable.filterDesigns(settings);

        dashboardsTable.pickContent().forEach(dashboard -> assertThat(dashboard.getName().toLowerCase())
                .describedAs("Dashboard '%s' should be presented after filtering by '%s'", DASHBOARD_DEMO_NAME, criteriaDescription)
                .contains(filterParameter.toLowerCase()));
    }
}
