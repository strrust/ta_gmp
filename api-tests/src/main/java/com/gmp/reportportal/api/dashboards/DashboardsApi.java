package com.gmp.reportportal.api.dashboards;

import com.gmp.reportportal.api.RequestSpecificationFactory;
import com.gmp.reportportal.api.dashboards.dto.request.AddWidget;
import com.gmp.reportportal.api.dashboards.dto.request.WidgetParameters;
import com.gmp.reportportal.api.dashboards.dto.response.Dashboard;
import com.gmp.reportportal.api.dashboards.dto.response.Dashboards;
import com.gmp.reportportal.api.dashboards.dto.response.Message;
import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

@Repository
public class DashboardsApi {
    private static final String DASHBOARDS = "/{projectName}/dashboard";
    private static final String DASHBOARD = "/{projectName}/dashboard/{dashboardId}";
    private static final String ADD_WIDGET = "/{projectName}/dashboard/{dashboardId}/add";
    private static final String REMOVE_WIDGET = "/{projectName}/dashboard/{dashboardId}/{widgetId}";
    private static final String CREATE_WIDGET = "/{projectName}/widget";

    @Autowired
    private RequestSpecificationFactory requestConfigFactory;

    public Dashboards requestDashboards(String projectName, Map<String, ?> requestParameters) {
        return RestAssured
                .given(requestConfigFactory.getRequestSpecification(requestParameters))
                .get(DASHBOARDS, projectName).prettyPeek()
                .then().assertThat().statusCode(SC_OK)
                .extract().as(Dashboards.class);
    }

    public Message addWidgetToDashboard(String projectName, int dashboardId, AddWidget addWidget) {
        return RestAssured
                .given(requestConfigFactory.getRequestSpecification())
                .body(addWidget)
                .put(ADD_WIDGET, projectName, dashboardId).prettyPeek()
                .then().assertThat().statusCode(SC_OK)
                .extract().as(Message.class);
    }

    public Message removeWidgetFromDashboard(String projectName, int dashboardId, int widgetId) {
        return RestAssured
                .given(requestConfigFactory.getRequestSpecification())
                .delete(REMOVE_WIDGET, projectName, dashboardId, widgetId).prettyPeek()
                .then().assertThat().statusCode(SC_OK)
                .extract().as(Message.class);
    }

    public Dashboard requestDashboard(String projectName, int dashboardId) {
        return RestAssured
                .given(requestConfigFactory.getRequestSpecification())
                .get(DASHBOARD, projectName, dashboardId).prettyPeek()
                .then().assertThat().statusCode(SC_OK)
                .extract().as(Dashboard.class);
    }

    public int createWidget(String projectName, WidgetParameters widgetParameters) {
        return RestAssured
                .given(requestConfigFactory.getRequestSpecification())
                .body(widgetParameters)
                .post(CREATE_WIDGET, projectName).prettyPeek()
                .then().assertThat().statusCode(SC_CREATED)
                .extract().path("id");
    }
}
