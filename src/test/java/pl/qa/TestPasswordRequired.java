package pl.qa;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import utils.Locators;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestPasswordRequired extends BaseTest{
    @Test
    public void testPasswordRequired(){
        openUrl(Locators.URL);
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("admin","");
        assertThat(page.locator(Locators.ErrorPassword)).hasText("Epic sadface: Password is required");

    }

}
