package utils;

import com.microsoft.playwright.*;

public class TestContext {

    private final Playwright playwright;
    private final Browser browser;
    private final BrowserContext browserContext;
    private final Page page;

    public TestContext() {
        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    public Page getPage() {
        return page;
    }

    public void closeBrowser() {
        browserContext.close();
        browser.close();
        playwright.close();
    }
}