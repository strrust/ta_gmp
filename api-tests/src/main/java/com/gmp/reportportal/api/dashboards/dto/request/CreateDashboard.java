package com.gmp.reportportal.api.dashboards.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateDashboard {
    private String name;
    private String description;
}
