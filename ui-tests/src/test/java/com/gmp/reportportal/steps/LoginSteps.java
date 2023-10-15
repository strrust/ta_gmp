package com.gmp.reportportal.steps;

import com.gmp.reportportal.models.User;
import com.gmp.reportportal.pages.LoginPage;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginSteps {
    @Autowired
    public LoginPage loginPage;
    @Autowired
    private User testUser;

    @Step("Login as RP default user")
    public void login() {
        loginPage.openPage();
        loginPage.login(testUser);
    }
}
