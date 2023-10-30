package com.gmp.reportportal.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Component
public class DashboardsPage implements WebPage {
    public static final String URL = "/ui/#default_personal/dashboard";

    public SelenideElement title = $("span[title='All Dashboards']");

    @Override
    public void openPage() {
        open(URL, DashboardsPage.class);
    }

    public void shouldBeLoaded() {
        title.shouldBe(visible);
    }
}
