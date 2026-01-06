package test;

import com.codeborne.selenide.Selenide;
import extensions.SelenideExtensions;
import org.example.ui.page.MainPage;
import org.example.utils.config.ConfigData;
import org.example.utils.text.InvalidAuthorization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

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
}
