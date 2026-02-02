package pl.qa;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import utils.Locators;

import java.awt.image.PixelGrabber;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

// Logowanie do systemu
public class TestLogin extends BaseTest {
    @Test
    public void shouldLoginSuccessfully(){

        openUrl(Locators.URL);
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("standard_user", "secret_sauce");
        var plik = page.getByText("Products");
        assertThat(plik).isVisible();
        // pobierz tekst i wypisz w konsoli
        String tekst = plik.textContent();
        System.out.println("Tekst elementu: " + tekst);


    }
}
