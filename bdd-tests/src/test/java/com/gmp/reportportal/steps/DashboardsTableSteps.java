package com.gmp.reportportal.steps;

import com.gmp.reportportal.api.dashboards.dto.response.Dashboard;
import com.gmp.reportportal.api.dashboards.dto.response.Message;
import com.gmp.reportportal.domain.dashboards.DashboardsTableSettings;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static com.gmp.reportportal.domain.dashboards.DashboardsTable.DASHBOARD_DEMO_NAME;
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

    @When("I load dashboards")
    public void iLoadDashboards() {
        scenarioContext.dashboardsTable.loadDashboardsTable();
    }

    @Then("Dashboards table contains only demo dashboard")
    public void dashboardsTableContainsOnlyDemoDashboard() {
        assertThat(scenarioContext.dashboardsTable.pickContent())
                .describedAs("Dashboard should contain widgets")
                .extracting(Dashboard::getName)
                .containsExactly(DASHBOARD_DEMO_NAME);
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
}
