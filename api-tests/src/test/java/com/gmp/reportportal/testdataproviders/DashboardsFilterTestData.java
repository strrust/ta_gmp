package com.gmp.reportportal.testdataproviders;

import java.util.Arrays;
import java.util.List;

public class DashboardsFilterTestData {

    public static List<Object[]> dashboardFilterCriteria() {
        return Arrays.asList(
                new Object[]{"Searching by full dashboard name", "DEMO DASHBOARD"},
                new Object[]{"Searching by partial name", "DEMO"},
                new Object[]{"Searching by 3 symbols", "BOA"},
                new Object[]{"Lower case searching", "dashboard"},
                new Object[]{"Mixed case searching with space symbol", "mo dAS"}
        );
    }
}
