package com.gmp.reportportal.configuration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import static com.codeborne.selenide.Configuration.*;

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

    @PostConstruct
    public void configure() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("enableVNC", true);
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--remote-allow-origins=*");
        browserCapabilities = chromeOptions;
        browser = "chrome";
        baseUrl = appBaseUri;
        timeout = browserTimeout;
        pageLoadTimeout = loadTimeout;
        pollingInterval = browserPollingInterval;
        screenshots = false;
        savePageSource = false;
        browserVersion = version;
        log.info("Starting chrome browser with version: {}, address: {}", browserVersion, "locally");
    }
}
