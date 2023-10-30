package com.gmp.reportportal.configuration;

import com.gmp.reportportal.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

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
}
