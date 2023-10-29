package com.gmp.reportportal.api.dashboards.dto.request;

import com.gmp.reportportal.api.dashboards.dto.common.widget.Widget;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AddWidget {
    private Widget addWidget;
}
