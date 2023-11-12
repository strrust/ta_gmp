package com.gmp.reportportal.testdataproviders;

import org.testng.annotations.DataProvider;

public class DashboardsFilterTestData {
    public static final String DASHBOARD_DEMO_NAME = "DEMO DASHBOARD";

    @DataProvider(name = "Dashboards filter criteria", parallel = true)
    public static Object[][] dashboardFilterCriteria() {
        return new Object[][]{
                {"DEMO DASHBOARD"},
                {"DEMO"},
                {"BOA"},
                {"dashboard"},
                {"mo dAS"}
        };
    }
}
