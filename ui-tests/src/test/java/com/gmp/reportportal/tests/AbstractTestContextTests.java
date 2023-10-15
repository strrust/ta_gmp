package com.gmp.reportportal.tests;

import com.gmp.reportportal.configuration.TestContextConfiguration;
import com.gmp.reportportal.steps.DashboardsSteps;
import com.gmp.reportportal.steps.LoginSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = {TestContextConfiguration.class})
public class AbstractTestContextTests extends AbstractTestNGSpringContextTests {
    @Autowired
    protected LoginSteps loginSteps;
    @Autowired
    protected DashboardsSteps dashboardsSteps;
}
