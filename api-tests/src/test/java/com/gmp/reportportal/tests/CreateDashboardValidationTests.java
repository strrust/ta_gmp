package com.gmp.reportportal.tests;

import com.gmp.reportportal.api.dashboards.dto.response.Message;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateDashboardValidationTests extends AbstractTestContextTests {

    @ParameterizedTest
    @MethodSource("com.gmp.reportportal.testdataproviders.DashboardsCreationTestData#dashboardCreationNegativeCriteria")
    public void attemptCreateDashboard(String dashboardName, String dashboardDescription, String errorMessage, int errorCode) {
        dashboardsTable.createDashboard(dashboardName, dashboardDescription);
        Message message = dashboardsTable.pickErrorMessage();

        assertThat(message.getMessage())
                .describedAs("Error message should be '%s'", errorMessage)
                .isEqualTo(errorMessage);
        assertThat(message.getErrorCode())
                .describedAs("Error code should be '%s'", errorCode)
                .isEqualTo(errorCode);
    }
}
