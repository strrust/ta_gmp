package com.gmp.reportportal.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static io.restassured.filter.log.LogDetail.ALL;

@Component
public class RequestSpecificationFactory {
    @Value("${backend.baseUrl}")
    private String baseUri;
    @Value("${backend.basePath}")
    private String basePath;
    @Value("${AUTH_TOKEN}")
    private String authToken;

    private RequestSpecBuilder getCommonSpecificationBuilder() {
        return new RequestSpecBuilder()
                .addHeader("Authorization", String.format("Bearer %s", authToken))
                .setConfig(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization")))
                .setBaseUri(baseUri)
                .setBasePath(basePath)
                .log(ALL)
                .setContentType(ContentType.JSON);
    }

    public RequestSpecification getRequestSpecification() {
        return getCommonSpecificationBuilder()
                .build();
    }
}
