package com.gmp.reportportal.domain.dashboards;

import com.gmp.reportportal.api.dashboards.DashboardsApi;
import com.gmp.reportportal.api.dashboards.dto.common.widget.Widget;
import com.gmp.reportportal.api.dashboards.dto.request.AddWidget;
import com.gmp.reportportal.api.dashboards.dto.request.CreateDashboard;
import com.gmp.reportportal.api.dashboards.dto.request.WidgetParameters;
import com.gmp.reportportal.api.dashboards.dto.response.CreatedId;
import com.gmp.reportportal.api.dashboards.dto.response.Dashboard;
import com.gmp.reportportal.api.dashboards.dto.response.Dashboards;
import com.gmp.reportportal.api.dashboards.dto.response.Message;
import io.qameta.allure.Step;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Scope(value = "threadlocal", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class DashboardsTable {
    private static final String DEFAULT_PROJECT = "default_personal";
    public static final String DASHBOARD_DEMO_NAME = "DEMO DASHBOARD";

    private DashboardsApi dashboardsApi;

    private Dashboards dashboards;
    @Getter
    private Dashboard openedDashboard;
    private CreatedId createdDashboardId;
    @Getter
    private int lastCreatedWidgetId;

    public DashboardsTable(DashboardsApi dashboardsApi) {
        this.dashboardsApi = dashboardsApi;
    }

    @Step("I load dashboards table")
    public void loadDashboardsTable() {
        DashboardsTableSettings settings = DashboardsTableSettings.builder().build();
        dashboards = dashboardsApi.requestDashboards(DEFAULT_PROJECT, settings.pickQueryParams());
    }

    public List<Dashboard> pickContent() {
        return dashboards.getContent();
    }

    @Step("I filter designs by parameters: {settings}")
    public void filterDesigns(DashboardsTableSettings settings) {
        dashboards = dashboardsApi.requestDashboards(DEFAULT_PROJECT, settings.pickQueryParams());
    }

    @Step("I open dashboard with name {dashboardName}")
    public void openDashboard(String dashboardName) {
        int dashboardId = pickDashboardIdByName(dashboardName);
        openedDashboard = dashboardsApi.requestDashboard(DEFAULT_PROJECT, dashboardId);
    }

    @Step("I add widget with parameters {widgetParameters} to dashboard")
    public Message addWidgetToDashboard(Widget widgetParameters) {
        AddWidget addWidget = AddWidget.builder()
                .addWidget(widgetParameters)
                .build();
        return dashboardsApi.addWidgetToDashboard(DEFAULT_PROJECT, openedDashboard.getId(), addWidget);
    }

    private int pickDashboardIdByName(String name) {
        return pickContent().stream()
                .filter(dashboard -> dashboard.getName().equals(name))
                .map(Dashboard::getId)
                .findFirst()
                .orElseThrow(() -> new NullPointerException(String.format("Dashboard with name '%s' not found", name)));
    }

    public Widget pickOpenedDashboardWidgetByName(String widgetName) {
        return openedDashboard.getWidgets().stream()
                .filter(widget -> widget.getWidgetName().equals(widgetName))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(String.format("Widget with name '%s' not found", widgetName)));
    }

    public Widget pickOpenedDashboardLastCreatedWidget() {
        return openedDashboard.getWidgets().stream()
                .filter(widget -> widget.getWidgetId().equals(lastCreatedWidgetId))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(String.format("Widget with id '%s' not found", lastCreatedWidgetId)));
    }

    @Step("I remove last created widget from dashboard")
    public Message removeLastCreatedWidgetFromDashboard() {
        return dashboardsApi.removeWidgetFromDashboard(DEFAULT_PROJECT, openedDashboard.getId(), lastCreatedWidgetId);
    }

    public void createWidget(WidgetParameters widgetParameters) {
        lastCreatedWidgetId = dashboardsApi.createWidget(DEFAULT_PROJECT, widgetParameters);
    }

    @Step("I create dashboard with name {name} and description {description}")
    public void createDashboard(String name, String description) {
        CreateDashboard createDashboard = CreateDashboard.builder()
                .name(name)
                .description(description)
                .build();
        createdDashboardId = dashboardsApi.createDashboard(DEFAULT_PROJECT, createDashboard);
    }

    public Message pickErrorMessage() {
        return createdDashboardId;
    }

    public void removeDashboard(String dashboardName) {
        int dashboardId = pickDashboardIdByName(dashboardName);
        dashboardsApi.removeDashboard(DEFAULT_PROJECT, dashboardId);
    }
}
