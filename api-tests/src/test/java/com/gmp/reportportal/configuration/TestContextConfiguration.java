package com.gmp.reportportal.configuration;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.SimpleThreadScope;

@Configuration
@ComponentScan({"com.gmp.reportportal"})
@PropertySources({
        @PropertySource("classpath:env/${TA_ENV:local}.properties")
})
public class TestContextConfiguration {

    @Bean
    public static CustomScopeConfigurer threadLocalScopeRegistration() {
        CustomScopeConfigurer scopeConfigurator = new CustomScopeConfigurer();
        scopeConfigurator.addScope("threadlocal", new SimpleThreadScope());
        return scopeConfigurator;
    }
}
