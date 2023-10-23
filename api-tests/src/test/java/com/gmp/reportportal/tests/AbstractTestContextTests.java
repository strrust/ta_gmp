package com.gmp.reportportal.tests;

import com.gmp.reportportal.configuration.TestContextConfiguration;
import com.gmp.reportportal.domain.dashboards.DashboardsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = TestContextConfiguration.class)
public abstract class AbstractTestContextTests {

    @Autowired
    protected DashboardsTable dashboardsTable;
}
