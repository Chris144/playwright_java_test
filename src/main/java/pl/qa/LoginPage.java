package pl.qa;

import com.microsoft.playwright.Page;
import utils.Locators;

public class LoginPage {

    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String user, String pass){
        page.fill(Locators.USERNAME,user);
        page.fill(Locators.PASSWORD, pass);
        page.click(Locators.LOGIN);

    }
}
