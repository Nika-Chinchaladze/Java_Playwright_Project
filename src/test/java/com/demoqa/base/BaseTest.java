package com.demoqa.base;

import com.demoqa.pages.HomePage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;

public class BaseTest {
    protected HomePage homePage;
    protected String url = "https://demoqa.com";

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @BeforeMethod
    public void loadApplication() {
        page.navigate(url);
        homePage = new HomePage(page);
    }

    @AfterClass
    public void tearDown() {
        if (page != null) page.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
