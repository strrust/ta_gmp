package com.gmp.reportportal.api.dashboards.dto.request;

import com.gmp.reportportal.api.dashboards.dto.common.widget.WidgetOptions;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ContentParameters {
    private List<String> contentFields;
    private Integer itemsCount;
    private WidgetOptions widgetOptions;
}
