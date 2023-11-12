package com.gmp.reportportal.configuration;

import com.gmp.reportportal.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.SimpleThreadScope;

@Configuration
@ComponentScan("com.gmp.reportportal")
@PropertySources({
        @PropertySource("classpath:env/${TA_ENV:local}.properties"),
        @PropertySource("classpath:browser.properties")
})
public class TestContextConfiguration {

    @Bean
    public User testUser(@Value("${test.usr}") String login, @Value("${test.psw}") String psw) {
        return new User(login, psw);
    }

    @Bean
    public static CustomScopeConfigurer threadLocalScopeRegistration() {
        CustomScopeConfigurer scopeConfigurator = new CustomScopeConfigurer();
        scopeConfigurator.addScope("threadlocal", new SimpleThreadScope());
        return scopeConfigurator;
    }
}
