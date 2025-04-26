package com.demoqa.pages;

import com.base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SelectMenuPage extends BasePage {
    // Locators
    public Locator title = page.locator("h1.text-center");
    public Locator oldSelect = page.locator("#oldSelectMenu");
    public Locator multiSelect = page.locator("#cars");

    // Constructor
    public SelectMenuPage(Page page) {
        super(page);
    }

    // Assertions
    public void verifySelectMenuPage() {
        Locator[] locators = {title, oldSelect};
        assertions.verifyMultipleElementsAreVisible(locators);
    }
}
