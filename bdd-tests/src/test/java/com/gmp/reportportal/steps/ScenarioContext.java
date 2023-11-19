package com.gmp.reportportal.steps;

import com.gmp.reportportal.domain.dashboards.DashboardsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class ScenarioContext {

    @Autowired
    @Lazy
    public DashboardsTable dashboardsTable;
}
