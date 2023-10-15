package com.gmp.reportportal.api.dashboards.dto.response;

import lombok.Getter;

@Getter
public class Page {
    private Integer number;
    private Integer size;
    private Integer totalElements;
    private Integer totalPages;
}
