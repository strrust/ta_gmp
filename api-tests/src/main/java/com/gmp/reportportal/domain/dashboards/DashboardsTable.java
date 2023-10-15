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

    private DashboardsApi dashboardsApi;

    private Dashboards dashboards;

    public DashboardsTable(DashboardsApi dashboardsApi) {
        this.dashboardsApi = dashboardsApi;
    }

    @Step("I load dashboards table")
    public void loadDashboardsTable() {
        dashboards = dashboardsApi.requestDashboards(DEFAULT_PROJECT);
    }

    public List<Dashboard> pickContent() {
        return dashboards.getContent();
    }
}
