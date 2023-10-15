package com.gmp.reportportal.configuration;

import com.codeborne.selenide.Selenide;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.remote;

@Slf4j
@Configuration
public class SelenideConfiguration {
    @Value("${backend.baseUrl}")
    protected String appBaseUri;

    @Value("${browser.version:latest}")
    protected String version;

    @Value("${timeout:5000}")
    protected int browserTimeout;

    @Value("${page.load.timeout:60000}")
    protected int loadTimeout;

    @Value("${polling.interval:200}")
    protected int browserPollingInterval;

    @Value("${selenoid.url}")
    protected String selenoidUrl;

    @PostConstruct
    public void configure() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("enableVNC", true);
        chromeOptions.addArguments("--ignore-certificate-errors");
        browserCapabilities = chromeOptions;
        browser = "chrome";
        baseUrl = appBaseUri;
        timeout = browserTimeout;
        pageLoadTimeout = loadTimeout;
        pollingInterval = browserPollingInterval;
        screenshots = false;
        savePageSource = false;
        browserVersion = browserVersion != null ? browserVersion : version;
        if (remote != null || !selenoidUrl.isBlank()) {
            remote = remote != null ? remote : selenoidUrl;
            Selenide.open();
        }
        log.info("Starting chrome browser with version: {}, address: {}", browserVersion, remote != null ? remote : "locally");
    }
}
