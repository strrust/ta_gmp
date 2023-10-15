package com.gmp.reportportal.configuration;

import org.springframework.context.annotation.*;

@Configuration
@PropertySources({
        @PropertySource("classpath:env/${TA_ENV:local}.properties")
})
public class TestContextConfiguration {
}
