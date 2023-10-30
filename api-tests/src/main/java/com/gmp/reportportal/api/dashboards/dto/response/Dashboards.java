package com.gmp.reportportal.api.dashboards.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class Dashboards {
    private List<Dashboard> content;
    private Page page;
}
