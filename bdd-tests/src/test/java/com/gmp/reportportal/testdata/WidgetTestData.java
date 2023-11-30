package com.gmp.reportportal.testdata;

import com.gmp.reportportal.api.dashboards.dto.common.widget.Widget;
import com.gmp.reportportal.api.dashboards.dto.common.widget.WidgetPosition;
import com.gmp.reportportal.api.dashboards.dto.common.widget.WidgetSize;
import com.gmp.reportportal.api.dashboards.dto.request.ContentParameters;
import com.gmp.reportportal.api.dashboards.dto.request.WidgetParameters;

import java.util.List;

public class WidgetTestData {
    public static final WidgetParameters ACTIVITY_STREAM_CHART_PARAMETERS = WidgetParameters.builder()
            .contentParameters(ContentParameters.builder()
                    .itemsCount(10)
                    .contentFields(List.of("name", "actionType"))
                    .build())
            .name("Test activity stream chart")
            .widgetType("activityStream")
            .build();
    public static final Widget ACTIVITY_STREAM_CHART = Widget.builder()
            .widgetName("Test activity stream chart")
            .widgetType("activityStream")
            .widgetPosition(new WidgetPosition(0, 0))
            .widgetSize(new WidgetSize(6, 7))
            .build();
    public static final WidgetParameters LAUNCHES_TABLE_CHART_PARAMETERS = WidgetParameters.builder()
            .contentParameters(ContentParameters.builder()
                    .itemsCount(10)
                    .contentFields(List.of("name"))
                    .build())
            .name("Test launches table chart")
            .widgetType("launchesTable")
            .build();
    public static final Widget LAUNCHES_TABLE_CHART = Widget.builder()
            .widgetName("Test launches table chart")
            .widgetType("launchesTable")
            .widgetPosition(new WidgetPosition(0, 0))
            .widgetSize(new WidgetSize(6, 7))
            .build();
    public static final WidgetParameters OVERALL_STATISTICS_CHART_PARAMETERS = WidgetParameters.builder()
            .contentParameters(ContentParameters.builder()
                    .itemsCount(10)
                    .contentFields(List.of("name"))
                    .build())
            .name("Test overall statistics chart")
            .widgetType("overallStatistics")
            .build();
    public static final Widget OVERALL_STATISTICS_CHART = Widget.builder()
            .widgetName("Test overall statistics chart")
            .widgetType("overallStatistics")
            .widgetPosition(new WidgetPosition(0, 0))
            .widgetSize(new WidgetSize(6, 7))
            .build();
}
