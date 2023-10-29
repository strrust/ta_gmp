package com.gmp.reportportal.api.dashboards.dto.response;

import com.gmp.reportportal.api.dashboards.dto.common.widget.Widget;
import lombok.Getter;

import java.util.List;

@Getter
public class Dashboard {
    private String owner;
    private String description;
    private Integer id;
    private String name;
    private List<Widget> widgets;
}
