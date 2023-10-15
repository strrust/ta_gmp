package com.gmp.reportportal.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan({"com.gmp.reportportal"})
@PropertySources({
        @PropertySource("classpath:env/${TA_ENV:local}.properties")
})
public class TestContextConfiguration {
}
