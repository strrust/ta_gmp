package com.gmp.reportportal.pages;

import com.codeborne.selenide.SelenideElement;
import com.gmp.reportportal.models.User;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Component
public class LoginPage implements WebPage {
    public static final String URL = "/ui/#login";

    public final SelenideElement loginInput = $("input[name='login']");
    public final SelenideElement passwordInput = $("input[type='password']");
    public final SelenideElement loginBtn = $("[type='submit']");

    @Override
    public void openPage() {
        open(URL, LoginPage.class);
    }

    public void login(User user) {
        if (loginInput.isDisplayed()) {
            loginInput.shouldBe(visible)
                    .setValue(user.getLogin());
            passwordInput.shouldBe(visible)
                    .setValue(user.getPassword());
            loginBtn.click();
        }
    }
}
