package com.gmp.reportportal.api.dashboards.dto.response.widget;

import lombok.Getter;

@Getter
public class WidgetOptions {
    private Boolean zoom;
    private String timeline;
    private String viewMode;
    private Boolean latest;
    private Boolean includeMethods;
    private String launchNameFilter;
}
