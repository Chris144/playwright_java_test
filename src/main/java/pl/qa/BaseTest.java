package pl.qa;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

// klasa i metody  dla każdego testu
public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeEach
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        page = browser.newPage();
    }
    @AfterEach
    public void teardown(TestInfo testInfo) {
        takeScreenshot(testInfo.getDisplayName());
        browser.close();
        playwright.close();

    }
    private void takeScreenshot(String displayName) {
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshots/"+displayName+".png"))
                .setFullPage(true));
    }

    public void openUrl(String url) {
        page.navigate(url);
    }


}