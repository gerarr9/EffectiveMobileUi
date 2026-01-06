package org.example.ui.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private SelenideElement loginField = $x("//input[@data-test='username']");
    private SelenideElement passwordField = $x("//input[@data-test='password']");
    private SelenideElement loginButton = $x("//input[@data-test='login-button']");
    private SelenideElement errorText = $x("//h3");

    public static MainPage of() {
        return new MainPage();
    }

    @Step("Нажал на кнопку логина")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Вписал логин")
    public MainPage inputLogin(String login) {
        loginField.setValue(login);
        return this;

    }

    @Step("Вписал пороль")
    public MainPage inputPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public String getErrorText() {
        return errorText.getText();
    }

}
