package com.gmp.reportportal.api.dashboards.dto.response.widget;

import lombok.Getter;

@Getter
public class Widget {
    private String widgetName;
    private Integer widgetId;
    private String widgetType;
    private WidgetSize widgetSize;
    private WidgetPosition widgetPosition;
    private WidgetOptions widgetOptions;
}
