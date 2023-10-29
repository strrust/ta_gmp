package com.gmp.reportportal.testdataproviders;

import com.gmp.reportportal.api.dashboards.dto.common.widget.Widget;
import com.gmp.reportportal.api.dashboards.dto.common.widget.WidgetPosition;
import com.gmp.reportportal.api.dashboards.dto.common.widget.WidgetSize;
import com.gmp.reportportal.api.dashboards.dto.request.ContentParameters;
import com.gmp.reportportal.api.dashboards.dto.request.Filter;
import com.gmp.reportportal.api.dashboards.dto.request.WidgetParameters;

import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public class WidgetTestData {
    private static final Filter DEMO_FILTER = Filter.builder()
            .name("DEMO_FILTER")
            .value(1)
            .build();
    private static final WidgetParameters LAUNCH_STATISTICS_CHART_PARAMETERS = WidgetParameters.builder()
            .contentParameters(ContentParameters.builder()
                    .itemsCount(10)
                    .contentFields(List.of("statistics$executions$total"))
                    .build())
            .name("Test launch statistics chart")
            .widgetType("statisticTrend")
            .filterIds(List.of(1))
            .filters(List.of(DEMO_FILTER))
            .description(EMPTY)
            .build();
    private static final Widget LAUNCH_STATISTICS_CHART = Widget.builder()
            .widgetName("Test launch statistics chart")
            .widgetType("statisticTrend")
            .widgetPosition(new WidgetPosition(0, 0))
            .widgetSize(new WidgetSize(6, 7))
            .build();
    private static final WidgetParameters LAUNCHES_DURATION_CHART_PARAMETERS = WidgetParameters.builder()
            .contentParameters(ContentParameters.builder()
                    .itemsCount(10)
                    .contentFields(List.of("startTime", "endTime"))
                    .build())
            .name("Test launches duration chart")
            .widgetType("launchesDurationChart")
            .filterIds(List.of(1))
            .filters(List.of(DEMO_FILTER))
            .description(EMPTY)
            .build();
    private static final Widget LAUNCHES_DURATION_CHART = Widget.builder()
            .widgetName("Test launches duration chart")
            .widgetType("launchesDurationChart")
            .widgetPosition(new WidgetPosition(0, 0))
            .widgetSize(new WidgetSize(6, 7))
            .build();
    private static final WidgetParameters ACTIVITY_STREAM_CHART_PARAMETERS = WidgetParameters.builder()
            .contentParameters(ContentParameters.builder()
                    .itemsCount(10)
                    .contentFields(List.of("name", "actionType"))
                    .build())
            .name("Test activity stream chart")
            .widgetType("activityStream")
            .build();
    private static final Widget ACTIVITY_STREAM_CHART = Widget.builder()
            .widgetName("Test activity stream chart")
            .widgetType("activityStream")
            .widgetPosition(new WidgetPosition(0, 0))
            .widgetSize(new WidgetSize(6, 7))
            .build();
    private static final WidgetParameters LAUNCHES_TABLE_CHART_PARAMETERS = WidgetParameters.builder()
            .contentParameters(ContentParameters.builder()
                    .itemsCount(10)
                    .contentFields(List.of("name"))
                    .build())
            .name("Test launches table chart")
            .widgetType("launchesTable")
            .build();
    private static final Widget LAUNCHES_TABLE_CHART = Widget.builder()
            .widgetName("Test launches table chart")
            .widgetType("launchesTable")
            .widgetPosition(new WidgetPosition(0, 0))
            .widgetSize(new WidgetSize(6, 7))
            .build();
    private static final WidgetParameters OVERALL_STATISTICS_CHART_PARAMETERS = WidgetParameters.builder()
            .contentParameters(ContentParameters.builder()
                    .itemsCount(10)
                    .contentFields(List.of("name"))
                    .build())
            .name("Test overall statistics chart")
            .widgetType("overallStatistics")
            .build();
    private static final Widget OVERALL_STATISTICS_CHART = Widget.builder()
            .widgetName("Test overall statistics chart")
            .widgetType("overallStatistics")
            .widgetPosition(new WidgetPosition(0, 0))
            .widgetSize(new WidgetSize(6, 7))
            .build();

    public static List<Object[]> widgets() {
        return Arrays.asList(
                new Object[]{"Launch statistics chart", LAUNCH_STATISTICS_CHART_PARAMETERS, LAUNCH_STATISTICS_CHART},
                new Object[]{"Launches duration chart", LAUNCHES_DURATION_CHART_PARAMETERS, LAUNCHES_DURATION_CHART},
                new Object[]{"Activity stream chart", ACTIVITY_STREAM_CHART_PARAMETERS, ACTIVITY_STREAM_CHART},
                new Object[]{"Launches table chart", LAUNCHES_TABLE_CHART_PARAMETERS, LAUNCHES_TABLE_CHART},
                new Object[]{"Overall statistics chart", OVERALL_STATISTICS_CHART_PARAMETERS, OVERALL_STATISTICS_CHART}
        );
    }
}
