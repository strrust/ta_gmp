package com.gmp.reportportal.domain.dashboards;

import java.util.HashMap;
import java.util.Map;

import static com.gmp.reportportal.domain.dashboards.DefaultTableSettings.DEFAULT_PAGE;
import static com.gmp.reportportal.domain.dashboards.DefaultTableSettings.DEFAULT_PAGE_SIZE;

public class DashboardsTableSettings {
    private Map<String, String> queryParams;

    private DashboardsTableSettings(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public static TableSettingsBuilder builder() {
        return new TableSettingsBuilder();
    }

    public Map<String, String> pickQueryParams() {
        return queryParams;
    }

    @Override
    public String toString() {
        return queryParams.toString();
    }

    public static class TableSettingsBuilder {
        private Map<String, String> queryParams;

        TableSettingsBuilder() {
            queryParams = new HashMap<>();
            queryParams.put("page.page", String.valueOf(DEFAULT_PAGE));
            queryParams.put("page.size", String.valueOf(DEFAULT_PAGE_SIZE));
        }

        public TableSettingsBuilder filter(String filterQuery) {
            queryParams.put("filter.cnt.name", filterQuery);
            return this;
        }

        public DashboardsTableSettings build() {
            return new DashboardsTableSettings(queryParams);
        }
    }
}
