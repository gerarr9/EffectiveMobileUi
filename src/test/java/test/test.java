package test;

import com.codeborne.selenide.Selenide;
import extensions.SelenideExtensions;
import org.example.ui.page.MainPage;
import org.example.utils.config.ConfigData;
import org.example.utils.text.InvalidAuthorization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SelenideExtensions.class)
public class test {

    @Test
    @DisplayName("Авторизация с корректными данными")
    public void loginTest() {
        MainPage.of().inputLogin(ConfigData.LOGIN.getValue())
                .inputPassword(ConfigData.PASSWORD.getValue())
                .clickLoginButton();

        String currentUrl = Selenide.webdriver().object().getCurrentUrl();

        assertThat(currentUrl).isEqualTo(ConfigData.INVENTORY.getValue());
    }

    @Test
    @DisplayName("Авторизация с неправильным паролем")
    public void invalidPasswordTest() {
        MainPage.of().inputLogin(ConfigData.LOGIN.getValue())
                .inputPassword("1")
                .clickLoginButton();

        String text = MainPage.of().getErrorText();

        assertThat(text).isEqualTo(InvalidAuthorization.INVALID_PASSWORD);
    }

    @Test
    @DisplayName("Авторизация с заблокированным юзером")
    public void lockedUserTest() {
        MainPage.of().inputLogin(ConfigData.LOCKED_USER.getValue())
                .inputPassword(ConfigData.PASSWORD.getValue())
                .clickLoginButton();

        String text = MainPage.of().getErrorText();
        assertThat(text).isEqualTo(InvalidAuthorization.LOCKED_USER);
    }

    @Test
    @DisplayName("Авторизация с пустым юзером")
    public void emptyLoginTest() {
        MainPage.of().inputLogin("")
                .inputPassword(ConfigData.PASSWORD.getValue())
                .clickLoginButton();

        String text = MainPage.of().getErrorText();
        assertThat(text).isEqualTo(InvalidAuthorization.EMPTY_LOGIN);
    }

    @Test
    @DisplayName("Авторизация с долгой загрузкой юзера")
    public void performanceGlitchUserTest() {
        MainPage.of().inputLogin(ConfigData.GLITCH_USER.getValue())
                .inputPassword(ConfigData.PASSWORD.getValue())
                .clickLoginButton();

        $x("//input[@data-test='login-button']").shouldNot(exist);

        String currentUrl = Selenide.webdriver().object().getCurrentUrl();

        assertThat(currentUrl).isEqualTo(ConfigData.INVENTORY.getValue());
    }
}
