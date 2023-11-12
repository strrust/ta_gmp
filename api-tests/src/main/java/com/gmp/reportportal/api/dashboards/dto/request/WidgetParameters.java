package com.gmp.reportportal.api.dashboards.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class WidgetParameters {
    private ContentParameters contentParameters;
    private String description;
    private List<Integer> filterIds;
    private List<Filter> filters;
    private String name;
    private String widgetType;
}
