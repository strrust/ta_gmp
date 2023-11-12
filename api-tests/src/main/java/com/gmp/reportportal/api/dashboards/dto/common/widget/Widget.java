package com.gmp.reportportal.api.dashboards.dto.common.widget;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Widget {
    private String widgetName;
    private Integer widgetId;
    private String widgetType;
    private WidgetSize widgetSize;
    private WidgetPosition widgetPosition;
    private WidgetOptions widgetOptions;
}
