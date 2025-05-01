package com.demoqa.pages;

import com.base.BasePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class ModalDialogPage extends BasePage {
    // Constructor
    public ModalDialogPage(Page page) {
        super(page);
    }

    // Locators
    public Locator title = page.locator("h1.text-center");
    public Locator smallModalBtn = page.locator("#showSmallModal");
    public Locator largeModalBtn = page.locator("#showLargeModal");

    // Assertions
    public void verifyModalDialogPage() {
        Locator[] locators = { title, smallModalBtn, largeModalBtn };
        assertions.verifyMultipleElementsAreVisible(locators);
    }
}
