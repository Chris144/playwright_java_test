package pl.qa;

import org.junit.jupiter.api.Test;
import utils.Locators;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddProductTest extends BaseTest
{
    @Test
    public void testAddProduct() {
        // Otwarcie strony
        openUrl(Locators.URL);

        // Zalogowanie się użytkownika
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("standard_user", "secret_sauce");

        // Dodanie lsowego produktu do koszyka
        AddProductPage addToCart = new AddProductPage(page);
        addToCart.addRandomProduct();
        addToCart.addRandomProduct();

        // Przejscie do koszyka i sprawdzenie koszyka
        addToCart.checkCart();
        assertThat(page.locator(Locators.CART)).isVisible();
        assertThat(page.locator(Locators.CART)).hasText("2");
        int count = page.locator(Locators.PRODUCT_ADDED).count();
        System.out.println("Ilość dodanych produktów wynosi : " + count);
        assertTrue(count >=2);


    }
}
