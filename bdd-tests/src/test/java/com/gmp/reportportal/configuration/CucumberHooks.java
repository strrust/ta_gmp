package com.gmp.reportportal.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = {TestContextConfiguration.class})
public class CucumberHooks {
}
