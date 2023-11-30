package com.gmp.reportportal.tests;

import com.gmp.reportportal.api.dashboards.dto.common.widget.Widget;
import com.gmp.reportportal.api.dashboards.dto.request.WidgetParameters;
import com.gmp.reportportal.api.dashboards.dto.response.Message;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.gmp.reportportal.domain.dashboards.DashboardsTable.DASHBOARD_DEMO_NAME;
import static org.assertj.core.api.Assertions.assertThat;

public class AddWidgetTests extends AbstractTestContextTests {
    private static final String MESSAGE_TEMPLATE = "Widget with ID = '%s' was successfully added to the dashboard with ID = '%s'";

    @BeforeEach
    public void openDemoDashboard() {
        dashboardsTable.loadDashboardsTable();
        dashboardsTable.openDashboard(DASHBOARD_DEMO_NAME);
    }

    @ParameterizedTest
    @MethodSource("com.gmp.reportportal.testdataproviders.WidgetTestData#widget")
    public void addWidgetToDashboard(String widgetDescription, WidgetParameters widgetParameters, Widget widget) {
        dashboardsTable.createWidget(widgetParameters);
        int widgetId = dashboardsTable.getLastCreatedWidgetId();
        widget.setWidgetId(widgetId);
        Message message = dashboardsTable.addWidgetToDashboard(widget);

        String expectedMessage = String.format(MESSAGE_TEMPLATE, widgetId, dashboardsTable.getOpenedDashboard().getId());
        assertThat(message.getMessage())
                .describedAs("Message after adding '%s' should be '%s'", widgetDescription, expectedMessage)
                .isEqualTo(expectedMessage);

        dashboardsTable.openDashboard(DASHBOARD_DEMO_NAME);

        Widget addedWidget = dashboardsTable.pickOpenedDashboardWidgetByName(widget.getWidgetName());
        assertThat(addedWidget)
                .describedAs("Dashboard should contain '%s' widget", widgetDescription)
                .usingRecursiveComparison()
                .isEqualTo(widget);
    }

    @AfterEach
    public void removeWidget() {
        dashboardsTable.removeLastCreatedWidgetFromDashboard();
    }
}
