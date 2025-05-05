package com.demoqa.base;

import com.demoqa.pages.HomePage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.nio.file.Paths;
import java.time.LocalDate;

public class BaseTest {
    protected HomePage homePage;
    protected String url = "https://demoqa.com";

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
        homePage = new HomePage(page);
    }

    @AfterMethod
    public void takeFailedResultScreenshot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            page.screenshot(
                    new Page.ScreenshotOptions()
                            .setPath(Paths.get(
                                    "resources/screenshots/("
                                            + LocalDate.now()
                                            + ")-"
                                            + testResult.getName()
                                            + ".png"
                            ))
                            .setFullPage(true)
            );
        }
    }

    @AfterClass
    public void tearDown() {
        if (page != null) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
