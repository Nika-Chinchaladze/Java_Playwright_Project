package com.demoqa.pages;

import com.base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LinksPage extends BasePage {
    // Test Data
    public Integer statusCode = 400;
    public String message = "Bad Request";

    // Locators
    public Locator title = page.locator("h1.text-center");
    public Locator badRequest = page.locator("#bad-request");
    public Locator linkResponse = page.locator("#linkResponse");

    public LinksPage(Page page) {
        super(page);
    }
}
