package com.gmp.reportportal.domain.dashboards;

import com.gmp.reportportal.api.dashboards.DashboardsApi;
import com.gmp.reportportal.api.dashboards.dto.response.Dashboard;
import com.gmp.reportportal.api.dashboards.dto.response.Dashboards;
import io.qameta.allure.Step;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardsTable {
    private static final String DEFAULT_PROJECT = "default_personal";
    public static final String DASHBOARD_DEMO_NAME = "DEMO DASHBOARD";

    private DashboardsApi dashboardsApi;

    private Dashboards dashboards;

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
}
