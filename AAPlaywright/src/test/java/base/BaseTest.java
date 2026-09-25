
        package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeEach
    public void setUp() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
        );

        page = browser.newPage();
    }

    @AfterEach
    public void takeScreenshotAfterTest(TestInfo testInfo) throws IOException {

        // Get test method name
        String testName = testInfo.getTestMethod()
                .map(method -> method.getName())
                .orElse("unknown-test");

        // Screenshot folder
        Path screenshotDirectory = Paths.get(
                "/Users/dhivya.m/Documents/IdealProjects/AAPlaywright/screenshots"
        );

        // Create folder if it doesn't exist
        Files.createDirectories(screenshotDirectory);

        // Screenshot file path
        Path screenshotPath =
                screenshotDirectory.resolve(testName + ".png");

        // Take screenshot
        page.screenshot(
                new Page.ScreenshotOptions()
                        .setPath(screenshotPath)
                        .setFullPage(true)
        );

        System.out.println(
                "Screenshot saved: " +
                        screenshotPath.toAbsolutePath()
        );

        // Close browser
        browser.close();

        // Close Playwright
        playwright.close();
    }
}
