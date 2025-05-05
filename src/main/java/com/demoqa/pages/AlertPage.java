package com.demoqa.pages;

import com.base.BasePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class AlertPage extends BasePage {
    // Constructor
    public AlertPage(Page page) {
        super(page);
    }

    // Locators
    public Locator title = page.locator("h1.text-center");
    public Locator simpleAlertBtn = page.locator("#alertButton");
    public Locator confirmAlertBtn = page.locator("#confirmButton");
    public Locator promptAlertBtn = page.locator("#promtButton");
    public Locator confirmationResult = page.locator("#confirmResult");
    public Locator promptResult = page.locator("#promptResult");

    // Assertions
    public void verifyAlertPage() {
        Locator[] locators = { title, simpleAlertBtn, confirmAlertBtn, promptAlertBtn };
        assertions.verifyMultipleElementsAreVisible(locators);
    }
}
