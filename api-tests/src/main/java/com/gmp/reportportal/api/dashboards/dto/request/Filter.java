package com.gmp.reportportal.api.dashboards.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Filter {
    private String name;
    private Integer value;
}
