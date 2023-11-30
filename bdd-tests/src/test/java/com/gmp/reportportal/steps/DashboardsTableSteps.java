package com.gmp.reportportal.steps;

import com.gmp.reportportal.api.dashboards.dto.common.widget.Widget;
import com.gmp.reportportal.api.dashboards.dto.request.WidgetParameters;
import com.gmp.reportportal.api.dashboards.dto.response.Dashboard;
import com.gmp.reportportal.api.dashboards.dto.response.Message;
import com.gmp.reportportal.domain.dashboards.DashboardsTableSettings;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static com.gmp.reportportal.domain.dashboards.DashboardsTable.DASHBOARD_DEMO_NAME;
import static com.gmp.reportportal.testdata.WidgetTestData.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DashboardsTableSteps {
    @Autowired
    private ScenarioContext scenarioContext;

    private static final String EMPTY_NAME_ERROR_MESSAGE = "Incorrect Request. [Field 'name' should not contain only white spaces and shouldn't be empty. Field 'name' should have size from '3' to '128'.] ";
    private static final String INCORRECT_NAME_ERROR_MESSAGE = "Incorrect Request. [Field 'name' should have size from '3' to '128'.] ";
    private static final String EXISTED_NAME_ERROR_MESSAGE = "Resource 'DEMO DASHBOARD' already exists. You couldn't create the duplicate.";
    private static final Map<String, Message> DASHBOARD_CREATION_ERRORS = Map.ofEntries(
            Map.entry("emptyName", new Message(EMPTY_NAME_ERROR_MESSAGE, 4001)),
            Map.entry("nameWithIncorrectSize", new Message(INCORRECT_NAME_ERROR_MESSAGE, 4001)),
            Map.entry("existedName", new Message(EXISTED_NAME_ERROR_MESSAGE, 4091))
    );
    private static final Map<String, WidgetParameters> WIDGET_DEFAULT_PARAMETERS = Map.ofEntries(
            Map.entry("activityStream", ACTIVITY_STREAM_CHART_PARAMETERS),
            Map.entry("launchesTable", LAUNCHES_TABLE_CHART_PARAMETERS),
            Map.entry("overallStatistics", OVERALL_STATISTICS_CHART_PARAMETERS)
    );
    private static final Map<String, Widget> WIDGETS = Map.ofEntries(
            Map.entry("activityStream", ACTIVITY_STREAM_CHART),
            Map.entry("launchesTable", LAUNCHES_TABLE_CHART),
            Map.entry("overallStatistics", OVERALL_STATISTICS_CHART)
    );

    @When("I load dashboards")
    public void iLoadDashboards() {
        scenarioContext.dashboardsTable.loadDashboardsTable();
    }

    @Then("Dashboards table contains dashboards matches {string}")
    public void dashboardsTableContainsDashboardMatchesQuery(String searchingQuery) {
        scenarioContext.dashboardsTable.pickContent().forEach(dashboard -> assertThat(dashboard.getName().toLowerCase())
                .describedAs("Dashboard '%s' should be presented after filtering")
                .contains(searchingQuery.toLowerCase()));
    }

    @Then("Dashboards table contains demo dashboard")
    public void dashboardsTableContainsDemoDashboard() {
        assertThat(scenarioContext.dashboardsTable.pickContent())
                .describedAs("Dashboard should contain widgets")
                .extracting(Dashboard::getName)
                .contains(DASHBOARD_DEMO_NAME);
    }

    @Then("Dashboards table contains one demo dashboard")
    public void dashboardsTableContainsOneDemoDashboard() {
        assertThat(scenarioContext.dashboardsTable.pickContent())
                .describedAs("Dashboard should contain widgets")
                .filteredOn(dashboard -> dashboard.getName().equals(DASHBOARD_DEMO_NAME))
                .hasSize(1);
    }

    @When("I open demo dashboard")
    public void iOpenDemoDashboard() {
        scenarioContext.dashboardsTable.openDashboard(DASHBOARD_DEMO_NAME);
    }

    @Then("Dashboard is opened")
    public void dashboardIsOpened() {
        assertThat(scenarioContext.dashboardsTable.getOpenedDashboard())
                .describedAs("Dashboard should be opened")
                .isNotNull();
    }

    @Then("Dashboard contains widgets")
    public void dashboardContainsWidgets() {
        assertThat(scenarioContext.dashboardsTable.getOpenedDashboard().getWidgets())
                .describedAs("Dashboard should contain widgets")
                .isNotEmpty();
    }

    @When("I filter dashboards by name {string}")
    public void filterDashboards(String searchingQuery) {
        DashboardsTableSettings settings = DashboardsTableSettings.builder()
                .filter(searchingQuery)
                .build();
        scenarioContext.dashboardsTable.filterDesigns(settings);
    }

    @When("I create dashboard with name {string} and description {string}")
    public void createDashboard(String name, String description) {
        scenarioContext.dashboardsTable.createDashboard(name, description);
    }

    @Then("User receives dashboard creation error with message {string}")
    public void userReceivesDashboardCreationError(String errorMessageType) {
        Message actualErrorMessage = scenarioContext.dashboardsTable.pickErrorMessage();
        Message expectedErrorMessage = DASHBOARD_CREATION_ERRORS.get(errorMessageType);
        assertThat(actualErrorMessage.getMessage())
                .describedAs("Dashboard creation error message should be '%s'", expectedErrorMessage.getMessage())
                .isEqualTo(expectedErrorMessage.getMessage());
        assertThat(actualErrorMessage.getErrorCode())
                .describedAs("Dashboard creation error code should be '%s'", expectedErrorMessage.getErrorCode())
                .isEqualTo(expectedErrorMessage.getErrorCode());
    }

    @When("I add widget {string} with default parameters")
    public void addWidget(String widgetType) {
        WidgetParameters widgetParameters = WIDGET_DEFAULT_PARAMETERS.get(widgetType);
        scenarioContext.dashboardsTable.createWidget(widgetParameters);
        int widgetId = scenarioContext.dashboardsTable.getLastCreatedWidgetId();
        Widget widget = WIDGETS.get(widgetType);
        widget.setWidgetId(widgetId);
        scenarioContext.dashboardsTable.addWidgetToDashboard(widget);
    }

    @Then("Dashboard contains created widget {string} with correct parameters")
    public void dashboardContainsWidget(String widgetType) {
        Widget actualWidget = scenarioContext.dashboardsTable.pickOpenedDashboardLastCreatedWidget();
        Widget expectedWidget = WIDGETS.get(widgetType);
        assertThat(actualWidget)
                .describedAs("Added widget should be correct")
                .usingRecursiveComparison()
                .isEqualTo(expectedWidget);
    }
}
