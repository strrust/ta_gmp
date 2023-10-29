package com.gmp.reportportal.api.dashboards.dto.common.widget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WidgetOptions {
    private Boolean zoom;
    private String timeline;
    private String viewMode;
    private Boolean latest;
    private Boolean includeMethods;
    private String launchNameFilter;
    private String user;
    private List<String> actionType;
}
