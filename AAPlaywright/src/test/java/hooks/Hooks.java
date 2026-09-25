package hooks;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.TestContext;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Hooks {

    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @After
    public void takeScreenshot(Scenario scenario) throws Exception {

        Page page = testContext.getPage();

        String fileName = scenario.getName()
                .replaceAll("[^a-zA-Z0-9]", "_");

        Path screenshotDirectory =
                Paths.get("target", "screenshots");

        Files.createDirectories(screenshotDirectory);

        Path screenshotPath =
                screenshotDirectory.resolve(fileName + ".png");


        page.screenshot(
                new Page.ScreenshotOptions()
                        .setPath(screenshotPath)
                        .setFullPage(true)
        );


        byte[] screenshot = Files.readAllBytes(screenshotPath);

        scenario.attach(
                screenshot,
                "image/png",
                "Screenshot - " + scenario.getName()
        );

        System.out.println(
                "Screenshot saved: " +
                        screenshotPath.toAbsolutePath()
        );
    }
}