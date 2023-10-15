package com.gmp.reportportal.tests;

import com.gmp.reportportal.configuration.TestContextConfiguration;
import com.gmp.reportportal.domain.dashboards.DashboardsTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = {TestContextConfiguration.class})
public class AbstractTestContextTests extends AbstractTestNGSpringContextTests {

    @Autowired
    DashboardsTable dashboardsTable;
}
