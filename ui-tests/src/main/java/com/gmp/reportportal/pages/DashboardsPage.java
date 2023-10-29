package com.gmp.reportportal.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Component
public class DashboardsPage implements WebPage {
    public static final String URL = "/ui/#default_personal/dashboard";

    public SelenideElement title = $("span[title='All Dashboards']");
    public SelenideElement searchByNameInputField = $(".inputSearch__input--3e4db");
    private ElementsCollection dashboardsTableRows = $$(".gridRow__grid-row-wrapper--1dI9K");

    @Override
    public void openPage() {
        open(URL, DashboardsPage.class);
    }

    public void shouldBeLoaded() {
        title.shouldBe(visible);
    }

    public void filterDesigns(String text) {
        searchByNameInputField.sendKeys(text);
    }

    public void dashboardShouldBePresented(String dashboardName) {
        dashboardsTableRows.shouldHave(CollectionCondition.texts(dashboardName));
    }
}
