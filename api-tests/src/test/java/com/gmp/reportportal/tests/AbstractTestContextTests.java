package com.gmp.reportportal.tests;

import com.gmp.reportportal.configuration.TestContextConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = {TestContextConfiguration.class})
public class AbstractTestContextTests extends AbstractTestNGSpringContextTests {

}
