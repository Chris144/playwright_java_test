package pl.qa;
import com.microsoft.playwright.Response;
import org.junit.jupiter.api.Test;
import utils.Locators;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Otwarcie strony
public class OpenUrlTest extends BaseTest {

    @Test
    void testOpenUrl() {
        openUrl(Locators.URL);
        // Sprawdzenie czy adres jest prawidłowy
        assertThat(page).hasURL("https://www.saucedemo.com/");
        // Sprawdzenie czy status odpowiedzi to 200
        Response response = page.navigate(Locators.URL);
        assertEquals(200,response.status());
        System.out.println(response.status());

    }
}