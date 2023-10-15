package com.gmp.reportportal.api.dashboards.dto.response;

import com.gmp.reportportal.api.dashboards.dto.response.widget.Widget;
import lombok.Getter;

import java.util.List;

@Getter
public class Dashboard {
    private String owner;
    private Integer id;
    private String name;
    private List<Widget> widgets;
}
