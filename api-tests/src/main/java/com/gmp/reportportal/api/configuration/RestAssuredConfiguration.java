package com.gmp.reportportal.api.configuration;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.parsing.Parser;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.apache.http.params.CoreConnectionPNames.CONNECTION_TIMEOUT;
import static org.apache.http.params.CoreConnectionPNames.SO_TIMEOUT;

@Slf4j
@Component
public class RestAssuredConfiguration {
    @Value("${connection.timeout.millisec:60000}")
    private int timeout;

    @PostConstruct
    private void configure() {
        log.debug("Requests timeout {}", timeout);
        RestAssured.config = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(CONNECTION_TIMEOUT, timeout)
                        .setParam(SO_TIMEOUT, timeout));
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.useRelaxedHTTPSValidation();
    }
}
