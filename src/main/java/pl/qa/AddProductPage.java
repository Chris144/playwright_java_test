package pl.qa;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.Locators;
import java.util.concurrent.ThreadLocalRandom;



public class AddProductPage {

    private final Page page;

    public AddProductPage(Page page) {
        this.page = page;
    }


    public void addRandomProduct() {
        // Zliczenie wszystkich produktów na stronie
        Locator products = page.locator(Locators.BTN_PRODUCT);
        int count = products.count();
        // Wylosowanie  produktu i kliknięcie w niego
        int randomIndex = ThreadLocalRandom.current().nextInt(0, count);
        System.out.println("Wylosowany index produktu to : " + randomIndex);
        products.nth(randomIndex).click();

        if (count == 0){
            throw new RuntimeException("Brak dodanych produktów");
        }
    }
    public void checkCart(){
        page.click(Locators.CART);


    }

}
