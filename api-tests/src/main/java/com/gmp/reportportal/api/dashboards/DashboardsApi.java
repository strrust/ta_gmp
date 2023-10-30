package com.gmp.reportportal.api.dashboards;

import com.gmp.reportportal.api.RequestSpecificationFactory;
import com.gmp.reportportal.api.dashboards.dto.response.Dashboards;
import io.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.apache.http.HttpStatus.SC_OK;

@Repository
public class DashboardsApi {
    private static final String DASHBOARD = "/{projectName}/dashboard";

    @Autowired
    private RequestSpecificationFactory requestConfigFactory;

    public Dashboards requestDashboards(String projectName) {
        return RestAssured
                .given(requestConfigFactory.getRequestSpecification())
                .get(DASHBOARD, projectName).prettyPeek()
                .then().assertThat().statusCode(SC_OK)
                .extract().as(Dashboards.class);
    }
}
